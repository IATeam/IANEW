package uow.ia.test.hibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.internal.ManagedSessionContext;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import uow.ia.bean.Contacts;

public class ContactSearchTest {
	private Logger logger = Logger.getLogger(GoalTypeTest.class);
	@Autowired
	private SessionFactory sessionFactory;
	private Session session;
	private static ServiceRegistry serviceRegistry;
	
	@Test
	public void f() {
		FullTextSession fts = org.hibernate.search.Search.getFullTextSession(session);
		
		try {
			fts.createIndexer().startAndWait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		fts.getTransaction().begin();
		QueryBuilder qb = fts.getSearchFactory().buildQueryBuilder().forEntity(Contacts.class).get();
		org.apache.lucene.search.Query query = qb.keyword().onFields("firstname", "lastname", "accommodationComment").matching("hayley").createQuery();
		
		List<Contacts> list = fts.createFullTextQuery(query, Contacts.class).list();
		
		System.out.println(list.size());
		
		for (Contacts c : list) {
			System.out.println(c.getFirstname() + " " + c.getLastname() + " " + c.getAccommodationComment());
		}
		
		fts.getTransaction().commit();
		
		
//		fts.getTransaction().begin();
//		
//		@SuppressWarnings("unchecked")
//		List<Contacts> contacts = session.createQuery("FROM Contacts").list();
//		
//		for (Contacts c : contacts) {
//			fts.index(c);
//		}
//		
//		fts.getTransaction().commit();
		
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
