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

public class EnquiriesTest {
	private Logger logger = Logger.getLogger(EnquiriesTest.class);
	@Autowired
	private SessionFactory sessionFactory;
	private Session session;
	private static ServiceRegistry serviceRegistry;

	@Test
	public void f() {
		 List<Enquiries> enquiryList = session.createSQLQuery("SELECT * FROM Enquiries").addEntity(Enquiries.class).list();
		 Enquiries enquiry = enquiryList.get(1);
		 System.out.println("Enquiry ID: " + enquiry.getId());
		 System.out.println("Contact Id: " + enquiry.getContact().getId());
		 System.out.println("Enquiry Type: " + enquiry.getEnquiryType().getEnquiryTypeName());
		 System.out.println("StatusTypeID " + enquiry.getStatusType().getId() + " " + enquiry.getStatusType().getStatusName());
//		 System.out.println("ParentEnquiryId Id: " + enquiry.getParentEnquiry().getId());
		 List<Enquiries> enquirySet = enquiry.getEnquiriesList();
		 for(Enquiries e : enquirySet) {
			 System.out.println("Enquiry set: " + e.getId() + " " + e.getDescription());
		 }
		 List<EnquiryIssues> issueTypes = enquiry.getEnquiryIssuesList();
		 for (EnquiryIssues dt : issueTypes) {
			 System.out.println("Issue: " + dt.getId() + " " + dt.getIssue().getIssueName()  + dt.getComment());
		 }
		 
		 //update things
		 enquiry.setDescription("Kim Test");
		 Transaction tx = session.beginTransaction();
		 
		 session.saveOrUpdate(enquiry);
		 tx.commit();
		 
		 tx = session.beginTransaction();
		 enquiry.getContact().setAccommodationComment("kim test save for enquiry");
		 enquiry.setOutOfCoverageFlag("Y");
		 session.saveOrUpdate(enquiry.getContact());
		 tx.commit();
		 
		 tx = session.beginTransaction();
		 enquiry.getContact().setAccommodationComment("kim test save for enquiry 2");
		 session.saveOrUpdate(enquiry.getContact());
		 tx.commit();
		 
		 enquiry.setDescription("Kim Test 2");
		 
		 tx = session.beginTransaction();
		 session.saveOrUpdate(enquiry.getContact());
		 tx.commit();
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
