package uow.ia.test.hibernate;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.internal.ManagedSessionContext;
import org.hibernate.internal.SessionFactoryImpl;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import uow.ia.bean.*;

public class getEntityTest {
	private Logger logger = Logger.getLogger(AccommodationTypesTest.class);
	@Autowired
	private SessionFactory sessionFactory;
	private Session session;
	private static ServiceRegistry serviceRegistry;
	
	@Test
	public void f() {
		try{
			Map<String, ClassMetadata> map = sessionFactory.getAllClassMetadata();
		
			for (ClassMetadata c : map.values()) {
				if (c.getEntityName().endsWith("Contacts")) {

					System.out.println(c.getMappedClass());
					System.out.println(c.getEntityName());
					System.out.println(c.getMappedClass().getClass().toString());
					System.out.println(c);
					
					FullTextSession fts = org.hibernate.search.Search.getFullTextSession(session);
					
					try {
						fts.createIndexer().startAndWait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					fts.getTransaction().begin();
					
					Field[] field = c.getMappedClass().getDeclaredFields();
					for (Field f : field) {
						//System.out.println(f.getType() + " " + f.getName());
						if (f.getName().equals("firstname")) 
						{

							QueryBuilder qb = fts.getSearchFactory().buildQueryBuilder().forEntity(c.getMappedClass()).get();
							org.apache.lucene.search.Query query = qb.keyword().onFields(f.getName()).matching("mrs hayley").createQuery();
							
							List list = fts.createFullTextQuery(query, c.getMappedClass()).list();
							
							System.out.println(list.size());
							for (Object s : list) {
								
								if (s instanceof Contacts) {
									System.out.println("Kim test " + s.toString());
								}
							}
							
							fts.getTransaction().commit();
						}
						
						if (f.getType().isInstance(new Object())) {
							System.out.println("Primitive " + f.getType() + " " + f.getName());
						}
					}
					
				}
			}
//			get entity name			
//			for (String entityname : map.keySet()) {
//				System.out.println(entityname);
//			}
			
			Method[] list = Contacts.class.getDeclaredMethods();
			Contacts contact = (Contacts)session.get(Contacts.class, 1);
			//Field[] field = Contacts.class.getDeclaredFields();
			for (Class c : Configuration.class.getClasses()) {
				System.out.println(c.getName());
			}
			
//			for (Field f : field) {
//				System.out.println(f.getName());
//				Object object = f.get(contact);
//			}
			for (Method m : list) {
				System.out.println(m.getName());
				Class type = (Class) m.getReturnType();
				if (m.toString().equals("public java.lang.String uow.ia.bean.Contacts.getLastname()")) {
						Object object = m.invoke(contact, null);
						
						System.out.println(type.toString());
						System.out.println(object.toString());
				}
			}

		} catch ( Exception ex ) {
		    System.out.println(ex);

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
