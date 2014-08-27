package uow.ia.test.hibernate;

import java.sql.Date;
import java.util.Set;

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

import com.sun.jndi.cosnaming.IiopUrl.Address;

import uow.ia.bean.AccommodationTypes;
import uow.ia.bean.Addresses;
import uow.ia.bean.ClientDisabilities;
import uow.ia.bean.Contacts;
import uow.ia.bean.DisabilityTypes;

/* 
 * Test insert a new address for an existing contact in two ways:
 * 1. Save via contacts object
 * 2. Save address object directly
 * 
 * @author Kim To
 * @version 1.0.0, 26/08/2014
 */

public class AddressesInsertTest {
	private Logger logger = Logger.getLogger(AddressesInsertTest.class);
	@Autowired
	public static SessionFactory sessionFactory;
	private Session session;
	private static ServiceRegistry serviceRegistry;
	
	@Test
	public void f() {
		
		Contacts updateContact = (Contacts)session.get(Contacts.class, 100);
		Set<Addresses> addressSet = updateContact.getAddressesSet();
		for (Addresses a : addressSet) {
			a.setHomephone("40376432");
		}
		
		try {
			Transaction tx = session.beginTransaction();
			session.saveOrUpdate(updateContact);
			tx.commit();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		System.out.println("Save addresses directly");
		Contacts updateContact2 = (Contacts)session.get(Contacts.class, 99);
		Set<Addresses> addressSet2 = updateContact2.getAddressesSet();
		for (Addresses a : addressSet2) {
			a.setHomephone("123456");
			
			try {
				Transaction tx = session.beginTransaction();
				session.saveOrUpdate(a);
				tx.commit();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
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

    @AfterMethod
    public void afterMethod() {
	    logger.debug("destroy session facotry");
	    session.close();
	    ManagedSessionContext.unbind(sessionFactory);
    }
}
