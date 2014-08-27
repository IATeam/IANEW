package uow.ia.test.hibernate;

import java.util.List;
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

import uow.ia.bean.Enquiries;
import uow.ia.bean.EnquiryIssues;

/*
 * Test deleting an enquiry issue from an existing enquiry
 * Need to save Enquiry object due to cascade save-update in order to have this change in effect.
 * 
 * @author Kim To
 * @version 1.0.0, 27/08/2014
 */
public class EnquiryIssueDeleteTest {
	private Logger logger = Logger.getLogger(EnquiryIssueDeleteTest.class);
	@Autowired
	private SessionFactory sessionFactory;
	private Session session;
	private static ServiceRegistry serviceRegistry;

	@Test
	public void f() {
		System.out.println("Remove enquiry issue id 103 from enquiry id 105");
		Enquiries enquiry = (Enquiries)session.get(Enquiries.class, 105);
		EnquiryIssues eIssue = (EnquiryIssues)session.get(EnquiryIssues.class, 103);
		 
		Set<EnquiryIssues> eIssueSet = enquiry.getEnquiryIssuesSet();
		eIssueSet.remove(eIssue);
		
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.saveOrUpdate(enquiry);
			tx.commit();
		} catch (Exception e) {
			System.out.println("Error: " + e);
		} finally {
			System.out.println("Enquiry Issue for enquiry 105");
			for (EnquiryIssues i : enquiry.getEnquiryIssuesSet()) {
				System.out.println(i.getId());
			}
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
