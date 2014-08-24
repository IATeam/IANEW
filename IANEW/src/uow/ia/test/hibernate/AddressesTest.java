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

import uow.ia.bean.Addresses;
import uow.ia.bean.Enquiries;
import uow.ia.bean.EnquiryIssues;

public class AddressesTest {
	private Logger logger = Logger.getLogger(AddressesTest.class);
	@Autowired
	private SessionFactory sessionFactory;
	private Session session;
	private static ServiceRegistry serviceRegistry;

	@Test
	public void f() {
		List<Addresses> addressList = session.createSQLQuery("SELECT * FROM Addresses").addEntity(Addresses.class).list();
		  Addresses address = addressList.get(0);
		  System.out.println("Address ID: " + address.getId());
		  System.out.println("Address: " + address.getAddress());
		  System.out.println("Surburb: " + address.getSurburb());
		  System.out.println("State: " + address.getState());
		  System.out.println("Postcode: " + address.getPostcode());
		  System.out.println("Country:" + address.getCountry());
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
