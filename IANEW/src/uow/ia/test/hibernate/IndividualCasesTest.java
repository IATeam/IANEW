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
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.log4testng.Logger;

import uow.ia.bean.CaseIssues;
import uow.ia.bean.Contacts;
import uow.ia.bean.GenderTypes;
import uow.ia.bean.IndividualCaseCommunications;
import uow.ia.bean.IndividualCases;
import uow.ia.bean.Risks;

public class IndividualCasesTest {
	private Logger logger = Logger.getLogger(IndividualCasesTest.class);
	@Autowired
	private SessionFactory sessionFactory;
	private Session session;
	private static ServiceRegistry serviceRegistry;

	@Test
	public void f() {
		List<IndividualCases> IACase = session.createSQLQuery("SELECT * FROM Individual_Cases").addEntity(IndividualCases.class).list();
		IndividualCases ia = IACase.get(1);
		System.out.println("Case ID: " + ia.getId());
		System.out.println("Contact Id: " + ia.getContact().getId());
		System.out.println("Advocate Id: " + ia.getAdvocate().getId());
		System.out.println("Priority: " + ia.getPriorityType().getPriorityName());
		List<Risks> riskSet = ia.getRisksList();
		for (Risks a : riskSet) {
			System.out.println("Risks: " + a.getId() + " " + a.getRiskDescription() + " " + a.getRiskManagement());
		}
		
//		System.out.println("old case Id: " + ia.getOldCase().getId());
		List<CaseIssues> caseIssues = ia.getCaseIssuesList();
		for (CaseIssues dt : caseIssues) {
			System.out.println("Issue: " + dt.getId() + " " + dt.getIssue().getIssueName() + " " + dt.getStatusType().getStatusName() + " " + dt.getComments());
		}
		List<IndividualCaseCommunications> communicationSet = ia.getCommunicationsList();
		for (IndividualCaseCommunications icc : communicationSet) {
			System.out.println("Communication: " + icc.getDescription() + ", time:" + icc.getTimeSpent());
			System.out.println("communication type: " + icc.getCommunicationType().getCommunicationTypeName());
		}
		
//		System.out.println("enquiry id" + ia.getRelatedEnquiry().getId());
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
