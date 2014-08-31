package uow.ia.test.hibernate;

import java.sql.Date;

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

import uow.ia.bean.Contacts;
import uow.ia.bean.IndividualCases;

/*
 * Test deleting individual case in two ways:
 * 1. retrieve case by id and delete the object
 * 2. retrieve case via contact and save contact object
 * 
 * @author Kim To
 * @version 1.0.0, 28/08/2014
 */
public class IndividualCaseDeleteTest {
	private Logger logger = Logger.getLogger(IndividualCaseDeleteTest.class);
	@Autowired
	private SessionFactory sessionFactory;
	private Session session;
	private static ServiceRegistry serviceRegistry;

	@Test
	public void f() {
		System.out.println("Start process to delete new individual case");
		IndividualCases iCase = (IndividualCases)session.get(IndividualCases.class ,104);
		
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			session.delete(iCase);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			System.out.println(e);
		} finally {
			iCase = (IndividualCases)session.get(IndividualCases.class ,104);
			if (iCase == null) {
				System.out.println("successfully deleted");
			} else {
				System.out.println("unsucessfully deleted");
			}
		}
		
		System.out.println("delete case by save contact object");
		Contacts contact = (Contacts)session.get(Contacts.class, 100);
		contact.getIndividualCasesSet().remove((IndividualCases)session.get(IndividualCases.class, 105));
		
		try {
			tx = session.beginTransaction();
			session.saveOrUpdate(contact);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			System.out.println(e);
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