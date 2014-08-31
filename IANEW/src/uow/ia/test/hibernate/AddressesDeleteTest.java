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

import uow.ia.bean.Addresses;
import uow.ia.bean.Contacts;

/*
 * Test deleting an address of an existing contact
 * 
 * @author Kim To
 * @version 1.0.0, 26/08/2014
 */

public class AddressesDeleteTest {
	private Logger logger = Logger.getLogger(AddressesDeleteTest.class);
	@Autowired
	public static SessionFactory sessionFactory;
	private Session session;
	private static ServiceRegistry serviceRegistry;
	
	@Test
	public void f() {
		Contacts deleteContact = (Contacts)session.get(Contacts.class, 100);
		Transaction tx = null;
		try {
			List<Addresses> addressesSet = deleteContact.getAddressesList();
			addressesSet.clear();
			tx = session.beginTransaction();
			session.saveOrUpdate(deleteContact);
			tx.commit();
		} catch (Exception e) {
			System.out.println(e);
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
