package uow.ia.test.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.internal.ManagedSessionContext;
import org.hibernate.service.ServiceRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import uow.ia.bean.Enquiries;
import uow.ia.bean.EnquiryIssues;
import uow.ia.bean.IssueTypes;

public class EnquiryDeleteTest {
	private Logger logger = Logger.getLogger(EnquiryDeleteTest.class);
	@Autowired
	public static SessionFactory sessionFactory;
	private Session session;
	private static ServiceRegistry serviceRegistry;
	
	@Test
	public void f() {
		System.out.println("Start deleting enquiry");
		Enquiries deleteEnquiry = (Enquiries)session.get(Enquiries.class, 107);
		
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.delete(deleteEnquiry);
			tx.commit();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			System.out.println("finish delete enquiry");
			deleteEnquiry = (Enquiries)session.get(Enquiries.class, 107);
			if (deleteEnquiry == null) {
				System.out.println("successfully deleted enquiry");
			} else {
				System.out.println("delete unsucessfully");
			}
		}
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

    @AfterMethod
    public void afterMethod() {
	    logger.debug("destroy session facotry");
	    session.close();
	    ManagedSessionContext.unbind(sessionFactory);
    }
}
