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

import uow.ia.bean.CaseIssues;
import uow.ia.bean.EnquiryIssues;
import uow.ia.bean.IssueTypes;

public class IssueTypeTest {
	private Logger logger = Logger.getLogger(IssueTypeTest.class);
	@Autowired
	private SessionFactory sessionFactory;
	private Session session;
	private static ServiceRegistry serviceRegistry;

	@Test
	public void f() {
		List<IssueTypes> list = session.createSQLQuery("SELECT * FROM Issue_Types").addEntity(IssueTypes.class).list();
		IssueTypes type = list.get(0);
		System.out.println("id: " + type.getId() + " " + type.getIssueName());
		Set<EnquiryIssues> enquirySet = type.getEnquiryIssuesSet();
		System.out.println("enquiry count: " + enquirySet.size());
		for (EnquiryIssues e : enquirySet) {
			System.out.println("enquiry issue: " + e.getId() + " " + e.getComment());
		}
		
		Set<CaseIssues> caseSet = type.getCaseIssuesSet();
		System.out.println("case count: " + caseSet.size());
		for (CaseIssues e : caseSet) {
			System.out.println("case issue: " + e.getId() + " " + e.getComments());
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
