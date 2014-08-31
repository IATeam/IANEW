package uow.ia.test.hibernate;

import java.util.List;
import java.util.Set;

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

import uow.ia.bean.ContactTypes;
import uow.ia.bean.Contacts;
import uow.ia.bean.GenderTypes;

public class GenderTypesTest {
	private Logger logger = Logger.getLogger(GenderTypesTest.class);
	@Autowired
	private SessionFactory sessionFactory;
	private Session session;
	private static ServiceRegistry serviceRegistry;

	@Test
	public void f() {
		List<GenderTypes> genderList = session.createSQLQuery("Select * From Gender_Types").addEntity(GenderTypes.class).list();
		List<Contacts> contactsSet3  = genderList.get(0).getContactsList();
		System.out.println("Contacts");
		System.out.println("GenderId: " + genderList.get(0).getId());
		System.out.println("Count: " + contactsSet3.size());
		for (Contacts s : contactsSet3) {
			System.out.println("contactId: " + s.getId());
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
