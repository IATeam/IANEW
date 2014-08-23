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
import uow.ia.bean.CaseIssues;
import uow.ia.bean.Contacts;

public class CaseIssuesTest {
	private Logger logger = Logger.getLogger(CaseIssuesTest.class);
	@Autowired
	private SessionFactory sessionFactory;
	private Session session;
	private static ServiceRegistry serviceRegistry;

	@Test
	public void f() {
		List<CaseIssues> caseIssuesList = session.createSQLQuery("SELECT * FROM Case_Issues").addEntity(CaseIssues.class).list();
		CaseIssues caseIssue = caseIssuesList.get(0);
		System.out.println("id: " + caseIssue.getId());
		System.out.println("comment: " + caseIssue.getComments());
		System.out.println("case: " + caseIssue.getIndividualCase().getId());
		System.out.println("issue: " + caseIssue.getIssue().getIssueName());
		System.out.println("status: " + caseIssue.getStatusType().getStatusName());
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
