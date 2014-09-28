package uow.ia.test.hibernate;

import java.util.ArrayList;
import java.util.Collection;
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
import uow.ia.bean.StatusTypes;

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
		// what user will need to passed in 
		Class entityClass = StatusTypes.class;
		Integer id = 1;
		
		// start getting object
		CriteriaControls control = (CriteriaControls)session.get(CriteriaControls.class, id);
		System.out.println("control id: " + control.getId());
		
		List<CriteriaControlValues> values = control.getCriteriaControlValuesList();
		for (CriteriaControlValues v : values) {
			System.out.println("value id: " + v.getValue());
		}
		
		String valueString = "";
		for (int i = 0; i < values.size(); i++) {
			if (i == values.size() - 1) {
				valueString += values.get(i).getValue();
			} else {
				valueString += values.get(i).getValue() + ",";
			}
		}
		
		List list = session.createSQLQuery("SELECT * FROM " + control.getTableName() + " WHERE " + 
										control.getColumnName() + " IN (" + valueString + ")").addEntity(entityClass).list();
		
		List<StatusTypes> statusList = new ArrayList<StatusTypes>();
		statusList.addAll(list);
		
		for (StatusTypes st : statusList) {
			System.out.println("Status Types : " + st.getId() + " " + st.getStatusName());
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
