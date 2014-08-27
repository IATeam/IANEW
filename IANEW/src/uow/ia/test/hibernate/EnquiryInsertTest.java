package uow.ia.test.hibernate;

import java.util.HashSet;
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

import uow.ia.bean.Contacts;
import uow.ia.bean.Enquiries;
import uow.ia.bean.EnquiryIssues;
import uow.ia.bean.EnquiryTypes;
import uow.ia.bean.IssueTypes;
import uow.ia.bean.StatusTypes;

/*
 * Test insert a new enquiry to an existing contact via two ways:
 * 1. save contact object
 * 2. save enquiry object
 * 
 * @author Kim To
 * @version 1.0.0, 27/08/2014 15:07
 */
public class EnquiryInsertTest {
	private Logger logger = Logger.getLogger(EnquiryInsertTest.class);
	@Autowired
	public static SessionFactory sessionFactory;
	private Session session;
	private static ServiceRegistry serviceRegistry;
	
	@Test
	public void f() {
		
		System.out.println("1. Insert new Enquiry to an existing contact by save contact object");

		Contacts contact = (Contacts)session.get(Contacts.class, 100);
		
		EnquiryTypes eType = (EnquiryTypes)session.get(EnquiryTypes.class, 2);
		Enquiries newEnquiry = new Enquiries();
		newEnquiry.setContact(contact);
		newEnquiry.setDescription("Kim test enquiry - new to existing contact");
		newEnquiry.setEnquiryType(eType);
		
		EnquiryIssues enquiryIssue = new EnquiryIssues();
		enquiryIssue.setComment("kim first issue");
		enquiryIssue.setEnquiry(newEnquiry);
		enquiryIssue.setIssue((IssueTypes)session.get(IssueTypes.class, 2));
				
		newEnquiry.getEnquiryIssuesSet().add(enquiryIssue);
		
		newEnquiry.setInquisitor("Kim To");
		newEnquiry.setOutOfCoverageFlag("N");
		newEnquiry.setReferralBy("San To");
		newEnquiry.setStatusType((StatusTypes)session.get(StatusTypes.class, 2));
		
		
		contact.getEnquiriesSet().add(newEnquiry);
		
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.saveOrUpdate(contact);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			System.out.println(e);
		} finally{
			System.out.println("Successfully insert new enquiry id: " + newEnquiry.getId());
		}

		System.out.println("2. Insert new Enquiry to an existing contact by save enquiry object");
	
		Enquiries newEnquiry2 = new Enquiries();
		eType = (EnquiryTypes)session.get(EnquiryTypes.class, 3);
		newEnquiry2.setContact(contact);
		newEnquiry2.setDescription("Kim test enquiry 2 - new to existing contact");
		newEnquiry2.setEnquiryType(eType);
		
		EnquiryIssues enquiryIssue2 = new EnquiryIssues();
		enquiryIssue2.setComment("kim first issue 2");
		enquiryIssue2.setEnquiry(newEnquiry2);
		enquiryIssue2.setIssue((IssueTypes)session.get(IssueTypes.class, 5));
				
		newEnquiry2.getEnquiryIssuesSet().add(enquiryIssue2);
		
		newEnquiry2.setInquisitor("Ngoc To");
		newEnquiry2.setOutOfCoverageFlag("Y");
		newEnquiry2.setReferralBy("Vinh To");
		newEnquiry2.setStatusType((StatusTypes)session.get(StatusTypes.class, 3));
		
		try {
			tx = session.beginTransaction();
			session.saveOrUpdate(newEnquiry2);
			tx.commit();
		} catch (Exception e) {
			System.out.println("Save 2  error: " + e);
		} finally {
			System.out.println("Successfully insert another enquiry id: " + newEnquiry2.getId());
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
