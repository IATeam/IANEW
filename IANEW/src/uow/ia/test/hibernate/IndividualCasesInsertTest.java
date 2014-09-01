package uow.ia.test.hibernate;

import java.sql.Date;
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

import uow.ia.bean.CaseIssues;
import uow.ia.bean.Contacts;
import uow.ia.bean.Enquiries;
import uow.ia.bean.EnquiryIssues;
import uow.ia.bean.IndividualCaseCommunications;
import uow.ia.bean.IndividualCases;
import uow.ia.bean.IssueTypes;
import uow.ia.bean.PlanDevelopers;
import uow.ia.bean.PlanGoals;
import uow.ia.bean.Plans;
import uow.ia.bean.Risks;
import uow.ia.bean.StatusTypes;
import uow.ia.bean.CommunicationTypes;
import uow.ia.bean.GoalTypes;
import uow.ia.bean.PriorityTypes;

/*
 * Test to insert a new individual case for an existing contact
 * 1. save case object, or
 * 2. save contact associated with this case.
 * 
 * @author Kim To
 * @version 1.0.1, 28/08/2014
 */
public class IndividualCasesInsertTest {
	private Logger logger = Logger.getLogger(IndividualCasesInsertTest.class);
	@Autowired
	private SessionFactory sessionFactory;
	private Session session;
	private static ServiceRegistry serviceRegistry;

	@Test
	public void f() {
		System.out.println("Start process to insert new individual case");
		Contacts contact = (Contacts)session.get(Contacts.class, 100);
		IndividualCases iCase = new IndividualCases();
		iCase.setAdvocate((Contacts)session.get(Contacts.class, 1));
		iCase.setStatusType((StatusTypes)session.get(StatusTypes.class, 1));
		iCase.setContact(contact);
		iCase.setDescription("Kim insert case");
		iCase.setPriorityType((PriorityTypes)session.get(PriorityTypes.class, 1));
		iCase.setServiceProviderId(1);
		iCase.setReferredTo("Kim To");
		iCase.setRelatedEnquiry((Enquiries)session.get(Enquiries.class, 1));
		
		//add case issue to case
		CaseIssues caseIssue = new CaseIssues();
		caseIssue.setComments("Kim test insert 1");
		caseIssue.setIndividualCase(iCase);
		caseIssue.setIssue((IssueTypes)session.get(IssueTypes.class, 5));
		caseIssue.setStatusType((StatusTypes)session.get(StatusTypes.class, 3));
		
		iCase.getCaseIssuesList().add(caseIssue);
		
		// add new communication to case
		IndividualCaseCommunications communication = new IndividualCaseCommunications();
		communication.setCommunicationDate(Date.valueOf("2014-08-26"));
		communication.setCommunicationType((CommunicationTypes)session.get(CommunicationTypes.class, 1));
		communication.setDescription("Kim first communication contact");
		communication.setImportantFlag("N");
		communication.setIndividualCase(iCase);
		communication.setTimeSpent((float) 3.1);
		
		iCase.getCommunicationsList().add(communication);
		
		// add plan to case
		Plans plan = new Plans();
		plan.setNotes("Kim test plan");
		plan.setStatusType((StatusTypes)session.get(StatusTypes.class, 3));
		plan.setAuthorisedBy((Contacts)session.get(Contacts.class, 1));
	    plan.setIndividualCase(iCase);
		
		iCase.setPlan(plan);
		
		// add risk to case
		Risks risk = new Risks();
		risk.setIndividualCase(iCase);
		risk.setRiskDescription("kim test risk");
		risk.setRiskManagement("kim test risk management");
		
		iCase.getRisksList().add(risk);
		
		// ad plan goal to case
		PlanGoals goal = new PlanGoals();
		goal.setGoalAction("kim test goal");
		goal.setGoalType((GoalTypes)session.get(GoalTypes.class, 1));
		goal.setIndividualCase(iCase);
		goal.setStatusType((StatusTypes)session.get(StatusTypes.class, 1));
	
		iCase.getPlanGoalsList().add(goal);
		
		PlanDevelopers developer = new PlanDevelopers();
		developer.setContact((Contacts)session.get(Contacts.class, 1));
		developer.setIndividualCase(iCase);
		
		iCase.getPlanDevelopersList().add(developer);
		
		contact.getIndividualCasesList().add(iCase);
		
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.saveOrUpdate(iCase);
			//session.saveOrUpdate(contact);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			System.out.println(e);
		} finally {
			System.out.println("case id: " + iCase.getId());
			System.out.println("case issue id: " + caseIssue.getId());
			System.out.println("communication id: " + communication.getId());
			System.out.println("plan id: " + plan.getId());
			System.out.println("risk id: " + risk.getId());
			System.out.println("goal id: " + goal.getId());
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
