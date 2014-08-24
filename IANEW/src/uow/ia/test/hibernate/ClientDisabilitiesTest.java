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
import uow.ia.bean.ClientDisabilities;

public class ClientDisabilitiesTest {
	private Logger logger = Logger.getLogger(ClientDisabilitiesTest.class);
	@Autowired
	private SessionFactory sessionFactory;
	private Session session;
	private static ServiceRegistry serviceRegistry;
  @Test
  public void f() {
	  @SuppressWarnings("unchecked")
	  List<ClientDisabilities> clientDisabilityList = session.createSQLQuery("select * from Client_Disabilities").addEntity(ClientDisabilities.class).list();
	  ClientDisabilities clientDisability = clientDisabilityList.get(0);
	  System.out.println("id: " + clientDisability.getId());
	  System.out.println("comments: " + clientDisability.getComments());
	  System.out.println("primary flag: " + clientDisability.getPrimaryFlag());
	  System.out.println("contact: " + clientDisability.getContact().getFullName());
	  System.out.println("disability: " + clientDisability.getDisabilityType().getDisabilityName());
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
