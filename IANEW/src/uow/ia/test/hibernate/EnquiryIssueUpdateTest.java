package uow.ia.test.hibernate;

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

import uow.ia.bean.EnquiryIssues;
import uow.ia.bean.IssueTypes;

/*
 * Test updating enquiry issues in two ways:
 * 1. Update enquiry object (usefull when it is a new enquiry or the existing enquiry has its other attributes need to be updated)
 * 2. Update enquiry issue object (useful when only enquiry issue got updated)
 * 
 * @author Kim To
 * @version 1.0.0, 27/08/2014
 */
public class EnquiryIssueUpdateTest {
	private Logger logger = Logger.getLogger(EnquiryIssueUpdateTest.class);
	@Autowired
	public static SessionFactory sessionFactory;
	private Session session;
	private static ServiceRegistry serviceRegistry;
	
	@Test
	public void f() {
		System.out.println("1. Start update enquiry issue by update enquiry object");
		EnquiryIssues eIssue = (EnquiryIssues)session.get(EnquiryIssues.class, 107);
		eIssue.setComment("Kim tes update enquiry issue");
		eIssue.setIssue((IssueTypes)session.get(IssueTypes.class, 20));
		
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.saveOrUpdate(eIssue.getEnquiry());
			tx.commit();
		} catch (Exception e) {
			System.out.println("enquiry object save error: " + e);
		} finally {
			System.out.println("finish first update: " + eIssue.getId());
		}
		
		System.out.println("2. Start update enquiry issue by update enquiry issue object");
		EnquiryIssues eIssue2 = (EnquiryIssues)session.get(EnquiryIssues.class, 108);
		eIssue2.setComment("Kim tes update enquiry issue 2");
		eIssue2.setIssue((IssueTypes)session.get(IssueTypes.class, 13));
		
		try {
			tx = session.beginTransaction();
			session.saveOrUpdate(eIssue2);
			tx.commit();
		} catch (Exception e) {
			System.out.println("enquiry object save error: " + e);
		} finally {
			System.out.println("finish update 2: " + eIssue2.getId());
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
