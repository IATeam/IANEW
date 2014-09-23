package uow.ia.test.hibernate;

import java.sql.Date;
import java.util.List;
import java.util.Set;

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

import uow.ia.bean.AccommodationTypes;
import uow.ia.bean.Addresses;
import uow.ia.bean.ClientDisabilities;
import uow.ia.bean.Contacts;
import uow.ia.bean.DisabilityTypes;
import uow.ia.bean.Enquiries;
import uow.ia.bean.IndividualCases;

public class ContactUpdateTest {
	private Logger logger = Logger.getLogger(ContactUpdateTest.class);
	@Autowired
	public static SessionFactory sessionFactory;
	private Session session;
	private static ServiceRegistry serviceRegistry;
	
	@Test
	public void f() {
		Contacts updateContact = new Contacts();
		updateContact.setId(102);
		//updateContact.setFirstname("To");
		updateContact.setOthername("Kim");
		
		AccommodationTypes acc = new AccommodationTypes();
		acc.setId(1);
		acc.setAccommodationName("Aged Care");
		acc.setAccommodationDescription("rag");
		updateContact.setAccommodation(acc);
		
		
//		Contacts updateContact = (Contacts)session.get(Contacts.class, 11);
//		
//		updateContact.setAccommodation((AccommodationTypes)session.get(AccommodationTypes.class, 2));
//		updateContact.setDob(Date.valueOf("1992-07-23"));
//		updateContact.setAccommodationComment("kim test first update");
		
//		Set<ClientDisabilities> disabilitySet = updateContact.getDisabilitiesSet();
//		for (ClientDisabilities d : disabilitySet) {
//			if (d.getDisabilityType().getId() == 6) {
//				d.setDisabilityType((DisabilityTypes)session.get(DisabilityTypes.class, 2));
//			}
//		}
		
//		ClientDisabilities newDisability = new ClientDisabilities();
//		newDisability.setComments("Kim test");
//		newDisability.setContact(updateContact);
//		newDisability.setDisabilityType((DisabilityTypes)session.get(DisabilityTypes.class, 5));
//		
//		disabilitySet.add(newDisability);
//		updateContact.setDisabilitiesSet(disabilitySet);
		
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.saveOrUpdate(updateContact);
			//session.merge(updateContact);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			System.out.println(e);
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
