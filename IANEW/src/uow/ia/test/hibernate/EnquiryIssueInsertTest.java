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

import uow.ia.bean.Enquiries;
import uow.ia.bean.EnquiryIssues;
import uow.ia.bean.IssueTypes;

/*
 * Test insert enquiry issue in two ways:
 * 1. Update enquiry object
 * 2. Insert enquiry issue object
 * 
 * @author Kim To
 * @version 1.0.0, 27/08/2014
 */
public class EnquiryIssueInsertTest {
	private Logger logger = Logger.getLogger(EnquiryIssueInsertTest.class);
	@Autowired
	public static SessionFactory sessionFactory;
	private Session session;
	private static ServiceRegistry serviceRegistry;
	
	@Test
	public void f() {
		System.out.println("1. Save Enquiry-Issue by update Enquiry Object");
		Enquiries enquiry = (Enquiries)session.get(Enquiries.class, 105);
		
		EnquiryIssues eIssue = new EnquiryIssues();
		eIssue.setComment("Kim test insert enquiry issue 1");
		eIssue.setEnquiry(enquiry);
		eIssue.setIssue((IssueTypes)session.get(IssueTypes.class, 7));
		
		enquiry.getEnquiryIssuesList().add(eIssue);
		
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.saveOrUpdate(enquiry);
			tx.commit();
		} catch (Exception e) {
			System.out.println("1. " + e);
		} finally {
			System.out.println("new enquiry issue id: " + eIssue.getId());
		}
		
		EnquiryIssues eIssue2 = new EnquiryIssues();
		eIssue2.setComment("Kim test another insert enquiry issue");
		eIssue2.setEnquiry(enquiry);
		eIssue2.setIssue((IssueTypes)session.get(IssueTypes.class, 13));
		
		try {
			tx = session.beginTransaction();
			session.saveOrUpdate(eIssue2);
			tx.commit();
		} catch (Exception e) {
			System.out.println("2. " + e);
		} finally {
			System.out.println("another new enquiry issue id: " + eIssue2.getId());
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
