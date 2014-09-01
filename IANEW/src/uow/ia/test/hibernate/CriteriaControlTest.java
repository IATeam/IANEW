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

import uow.ia.bean.CriteriaControlValues;
import uow.ia.bean.CriteriaControls;

/*
 * Test fetching criteria control records
 * 
 * @author Kim TO
 * @version 1.0.0, 28/08/2014
 */
public class CriteriaControlTest {
	private Logger logger = Logger.getLogger(CriteriaControlTest.class);
	@Autowired
	private SessionFactory sessionFactory;
	private Session session;
	private static ServiceRegistry serviceRegistry;

	@Test
	public void f() {
		CriteriaControls control = (CriteriaControls)session.get(CriteriaControls.class, 1);
		System.out.println("control id: " + control.getId());
		
		List<CriteriaControlValues> values = control.getCriteriaControlValuesList();
		for (CriteriaControlValues v : values) {
			System.out.println("value id: " + v.getValue());
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
