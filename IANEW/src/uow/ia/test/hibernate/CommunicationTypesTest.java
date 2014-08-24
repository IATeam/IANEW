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

import uow.ia.bean.CommunicationTypes;
import uow.ia.bean.IndividualCaseCommunications;

public class CommunicationTypesTest {
	private Logger logger = Logger.getLogger(CommunicationTypesTest.class);
	@Autowired
	private SessionFactory sessionFactory;
	private Session session;
	private static ServiceRegistry serviceRegistry;

	@Test
	public void f() {
		List<CommunicationTypes> communicationTypeList = session.createSQLQuery("select * from Communication_Types").addEntity(CommunicationTypes.class).list();
		CommunicationTypes communicationType = communicationTypeList.get(0);
		System.out.println("typeid: " + communicationType.getId());
		System.out.println("name: " + communicationType.getCommunicationTypeName());
		Set<IndividualCaseCommunications> iaCommunications = communicationType.getIndividualCaseCommunicationsSet();
		System.out.println("case count: " + iaCommunications.size());
		for (IndividualCaseCommunications icc : iaCommunications) {
			System.out.println(icc.getId() + " " + icc.getDescription() + " " + icc.getTimeSpent());
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
