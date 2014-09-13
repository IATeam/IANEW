package uow.ia.test.hibernate;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.queryParser.MultiFieldQueryParser;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.util.Version;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.internal.ManagedSessionContext;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import uow.ia.bean.Contacts;
import uow.ia.bean.TitleTypes;

public class GenericSearchMethodTest {
	private Logger logger = Logger.getLogger(AccommodationTypesTest.class);
	@Autowired
	private SessionFactory sessionFactory;
	private Session session;
	private static ServiceRegistry serviceRegistry;
	
	@Test
	public void f() {

		String searchQuery = "mrs hayley kim 1991-07-20";
		List<String> productFields = new ArrayList<String>();
		
		try{
			Map<String, ClassMetadata> map = sessionFactory.getAllClassMetadata();
		
			for (ClassMetadata c : map.values()) {
				
				// test for contact object only
				if (c.getEntityName().endsWith("Contacts") || c.getEntityName().endsWith("TitleTypes")) {

					System.out.println("mapped class " + c.getMappedClass());
					System.out.println("entity name " + c.getEntityName());
					System.out.println("mapped class class" + c.getMappedClass().getClass().toString());
					
					Field[] field = c.getMappedClass().getDeclaredFields();
					for (Field f : field) {
						if (f.getType().isInstance(new String()) || 
							f.getType().isInstance(new java.sql.Date(0)) || 
							f.getType().isInstance(new java.util.Date()) ||
							f.getType().isInstance(new Integer(0)) )
						{
							System.out.println(f.getName());
							productFields.add(f.getName());
						}
						
					}
					
				}
			}

		} catch ( Exception ex ) {
		    System.out.println(ex);

		}
		
		System.out.println(productFields.toString());
		String[] searchFields = productFields.toArray(new String[0]);
		QueryParser parser = new MultiFieldQueryParser(Version.LUCENE_36,
				searchFields,
				new StandardAnalyzer(Version.LUCENE_36));
		
		org.apache.lucene.search.Query luceneQuery = null;
		
		try {
			luceneQuery = parser.parse(searchQuery);
		} catch (ParseException e) {
			System.out.println("parse exception " + e);
		} catch (Exception e2) {
			System.out.println("other exception " + e2);
		}
		
		FullTextSession fts = org.hibernate.search.Search.getFullTextSession(session);
		
		try {
			fts.createIndexer().startAndWait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		fts.getTransaction().begin();
		
		
		List list = fts.createFullTextQuery(luceneQuery).list();
		
		System.out.println(list.size());
		for (Object s : list) {
			
			if (s instanceof Contacts) {
				System.out.println("Kim test " + s.toString());
			} else if (s instanceof TitleTypes) {
				System.out.println("title type " + s.toString());
			}
		}
		
		fts.getTransaction().commit();
		
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
