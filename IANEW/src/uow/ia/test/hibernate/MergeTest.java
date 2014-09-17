package uow.ia.test.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.internal.ManagedSessionContext;
import org.hibernate.service.ServiceRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import uow.ia.bean.AccommodationTypes;
import uow.ia.bean.Contacts;
import uow.ia.bean.Enquiries;

public class MergeTest {
	private Logger logger = Logger.getLogger(MergeTest.class);
	@Autowired
	private SessionFactory sessionFactory;
	private Session session;
	private static ServiceRegistry serviceRegistry;

	@Test
	public void f() {
		session.beginTransaction();
		Enquiries e = (Enquiries)session.get(Enquiries.class, 1);
		Contacts contact = (Contacts)session.get(Contacts.class, 44);
		session.close();
		
		Transaction tx = null;
		session = sessionFactory.openSession();
		try {
			tx = session.beginTransaction();
			//Enquiries enquiry = new Enquiries();
			Contacts contact1 = new Contacts();
			contact1.getEnquiriesList().add(e);
			e = (Enquiries)session.merge(e);
			contact1 = (Contacts)session.merge(contact);
			contact1.setLastname("To");
			e.setContact(contact);
			session.saveOrUpdate(contact1);
			tx.commit();
		} catch (Exception e1) {
			tx.rollback();
			System.out.println(e1);
		}
		
	}
	
	@AfterMethod
	public void afterMethod() {
		logger.debug("destroy session facotry");
		session.close();
		ManagedSessionContext.unbind(sessionFactory);
	}

	@BeforeMethod
	public void beforeMethod() {
		logger.debug("init session facotry");
		Configuration configuration = new Configuration().configure();
		serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		session = sessionFactory.openSession();
		ManagedSessionContext.bind(session);
	}
}
