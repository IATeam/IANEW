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
import uow.ia.bean.ContactEmployments;
import uow.ia.bean.Contacts;
import uow.ia.bean.EmploymentTypes;

public class EmploymentTypeTest {
	private Logger logger = Logger.getLogger(EmploymentTypeTest.class);
	@Autowired
	private SessionFactory sessionFactory;
	private Session session;
	private static ServiceRegistry serviceRegistry;

	@Test
	public void f() {
		List<EmploymentTypes> employmentList = session.createSQLQuery("SELECT * FROM Employment_Types").addEntity(EmploymentTypes.class).list();
		List<ContactEmployments> contactEmploymentSet  = employmentList.get(1).getContactEmploymentsList();
		System.out.println("employment id:" + employmentList.get(1).getId());
		System.out.println("contact employment count: " + contactEmploymentSet.size());
		for (ContactEmployments c : contactEmploymentSet) {
			System.out.println("contact epmployment details: " + c.getId() + " " + c.getComments() + " " + c.getWorkphone());
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
