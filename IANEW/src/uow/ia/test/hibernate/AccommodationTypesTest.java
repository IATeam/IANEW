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

import uow.ia.bean.AccommodationTypes;
import uow.ia.bean.Addresses;
import uow.ia.bean.Contacts;

public class AccommodationTypesTest {
	private Logger logger = Logger.getLogger(AccommodationTypesTest.class);
	@Autowired
	private SessionFactory sessionFactory;
	private Session session;
	private static ServiceRegistry serviceRegistry;

	@Test
	public void f() {
		List<AccommodationTypes> accommodationList = session.createSQLQuery("SELECT * FROM Accommodation_Types").addEntity(AccommodationTypes.class).list();
		List<Contacts> contactsSet  = accommodationList.get(1).getContactsList();
		System.out.println("Contacts");
		System.out.println("accommodationId: " + accommodationList.get(1).getId());
		System.out.println("Count: " + contactsSet.size());
		for (Contacts c : contactsSet) {
			System.out.println("contactId: " + c.getId());
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
