package uow.ia.test.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.internal.ManagedSessionContext;
import org.hibernate.service.ServiceRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.log4testng.Logger;

import uow.ia.bean.Addresses;
import uow.ia.bean.ContactEmployments;

public class ContactEmploymentsTest {
	private Logger logger = Logger.getLogger(ContactEmployments.class);
	@Autowired
	private SessionFactory sessionFactory;
	private Session session;
	private static ServiceRegistry serviceRegistry;

	@Test
	public void f() {
		List<ContactEmployments> employmentList = session.createSQLQuery("SELECT * FROM Contact_Employments").addEntity(ContactEmployments.class).list();
		ContactEmployments ce = employmentList.get(0);
		  System.out.println("ID: " + ce.getId());
		  System.out.println("contact: " + ce.getContact().getFirstname() + " " + ce.getContact().getLastname());
		  System.out.println("comment: " + ce.getComments());
		  System.out.println("employment name: " + ce.getEmploymentType().getEmploymentName());
		  //System.out.println("created user: " + ce.getCreatedUserId());
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
