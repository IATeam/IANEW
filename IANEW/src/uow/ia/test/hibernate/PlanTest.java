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
import uow.ia.bean.Plans;

public class PlanTest {
	private Logger logger = Logger.getLogger(PlanTest.class);
	@Autowired
	private SessionFactory sessionFactory;
	private Session session;
	private static ServiceRegistry serviceRegistry;

	@Test
	public void f() {
		List<Plans> list = session.createSQLQuery("SELECT * FROM Plans").addEntity(Plans.class).list();
		Plans p  = list.get(0);
		System.out.println("id: " + p.getId());
		System.out.println("notes: " + p.getNotes());
		System.out.println("authorise by id: " + p.getAuthorisedBy().getId());
		System.out.println("case id: " + p.getIndividualCase().getId());
		//System.out.println("frequency: " + p.getReviewFrequency().getFrequencyName());
		System.out.println("status: " + p.getStatusType().getId() + " " + p.getStatusType().getStatusName());
		//System.out.println("support person id: " + p.getSupportPerson().getId());
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
