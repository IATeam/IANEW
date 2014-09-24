package uow.ia.test.hibernate;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.queryParser.MultiFieldQueryParser;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.util.Version;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.internal.ManagedSessionContext;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.search.FullTextSession;
import org.hibernate.service.ServiceRegistry;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import uow.ia.bean.Contacts;
import uow.ia.bean.TitleTypes;
import uow.ia.dao.BaseDao;

public class SearchUtilTestMethod {
	private Logger logger = Logger.getLogger(AccommodationTypesTest.class);
	private SessionFactory sessionFactory;
	private Session session;
	private static ServiceRegistry serviceRegistry;
	
	@Resource
	private BaseDao dao;
	
	@Test
	public void f() {

		String searchQuery = "mrs hayley kim 1991-07-20";
		//String[] searchFields = SearchFields();
		
//		for (String s : fieldList) {
//			System.out.println(s);
//		}
		List list = SearchUtil(searchQuery);
		
		System.out.println(list.size());
		
		if (list.size() > 0) {
			for (Object o : list) {
				System.out.println(o.toString());
			}
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
	
	private List<String> fieldList = new ArrayList<String>();
	
	public void fieldCollection (Class mappedClass, String objectFieldName) {
		Field[] fields = mappedClass.getDeclaredFields();
		for (Field f : fields) {
			if (f.getAnnotations().length != 0) {
				Class type = f.getType();
				if (!(Collection.class.isAssignableFrom(type))) {
					if (type.isInstance(new String()) || 
						type.isInstance(new java.sql.Date(0)) || 
						type.isInstance(new java.util.Date()) ||
						type.isInstance(new Integer(0)) ) {
						
						if (objectFieldName == null) {
							fieldList.add(f.getName());
						} else {
							fieldList.add(objectFieldName + "." + f.getName());
						}
					} else {
						fieldCollection(type, f.getName());
					}
				}
			}
		}
	}
	
	public String[] SearchFields() {
		
		Map<String, ClassMetadata> map = sessionFactory.getAllClassMetadata();
		for (ClassMetadata cm : map.values()) {
			fieldCollection(cm.getMappedClass(), null);
		}
		
		return fieldList.toArray(new String[0]);
				
	}
	
	public List SearchUtil(String searchString) {
		
		String[] searchFields = SearchFields();
		
		BooleanQuery.setMaxClauseCount(20000);
		QueryParser parser = new MultiFieldQueryParser(Version.LUCENE_36,
														searchFields,
														new StandardAnalyzer(Version.LUCENE_36));
		
		org.apache.lucene.search.Query luceneQuery = null;
		
		try {
			luceneQuery = parser.parse("mrs hayley kim");
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
		
		//List list = null;
		List list = fts.createFullTextQuery(luceneQuery).list();
		
		System.out.println(list.size());
		fts.getTransaction().commit();
		
		return list;
		//return null;
	}
}
