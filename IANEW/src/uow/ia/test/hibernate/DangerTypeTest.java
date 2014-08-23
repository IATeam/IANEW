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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import uow.ia.bean.AccommodationTypes;
import uow.ia.bean.Contacts;
import uow.ia.bean.DangerTypes;

public class DangerTypeTest {
	private Logger logger = Logger.getLogger(DangerTypeTest.class);
	@Autowired
	private SessionFactory sessionFactory;
	private Session session;
	private static ServiceRegistry serviceRegistry;

	@Test
	public void f() {
		List<DangerTypes> dangerList = session.createSQLQuery("Select * From Danger_Types").addEntity(DangerTypes.class).list();
		System.out.println("DangerTypeId: " + dangerList.get(0).getId());
		System.out.println("Count: " + dangerList.get(0).getContactsSet().size());
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
