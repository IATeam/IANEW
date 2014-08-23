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
import uow.ia.bean.EnquiryIssues;

public class EnquiryIssuesTest {
	private Logger logger = Logger.getLogger(EnquiryIssuesTest.class);
	@Autowired
	private SessionFactory sessionFactory;
	private Session session;
	private static ServiceRegistry serviceRegistry;

	@Test
	public void f() {
		List<EnquiryIssues> enquiryIssuesList = session.createSQLQuery("SELECT * FROM Enquiry_Issues").addEntity(EnquiryIssues.class).list();
		EnquiryIssues enquiryIssue  = enquiryIssuesList.get(0);
		System.out.println("Id: " + enquiryIssue.getId());
		System.out.println("comment: " + enquiryIssue.getComment());
		System.out.println("enquiry id: " + enquiryIssue.getEnquiry().getId());
		System.out.println("issue: " + enquiryIssue.getIssue().getId() + " " + enquiryIssue.getIssue().getIssueName());
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
