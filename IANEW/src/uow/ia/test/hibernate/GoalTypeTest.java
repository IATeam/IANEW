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
import uow.ia.bean.GoalTypes;
import uow.ia.bean.PlanGoals;

public class GoalTypeTest {
	private Logger logger = Logger.getLogger(GoalTypeTest.class);
	@Autowired
	private SessionFactory sessionFactory;
	private Session session;
	private static ServiceRegistry serviceRegistry;

	@Test
	public void f() {
		List<GoalTypes> goalTypeList = session.createSQLQuery("SELECT * FROM Goal_Types").addEntity(GoalTypes.class).list();
		System.out.println("id: " + goalTypeList.get(0).getId());
		Set<PlanGoals> planGoalsSet  = goalTypeList.get(0).getPlanGoalsSet();
		System.out.println("plan goal Count: " + planGoalsSet.size());
		for (PlanGoals c : planGoalsSet) {
			System.out.println(c.getId() + " " + c.getGoalAction() + " " + c.getGoalDescription());
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
