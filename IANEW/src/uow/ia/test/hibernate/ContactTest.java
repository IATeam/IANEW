package uow.ia.test.hibernate;

import java.util.List;
import java.util.Set;

import net.sf.ehcache.hibernate.HibernateUtil;

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
import uow.ia.bean.CaseIssues;
import uow.ia.bean.ClientDisabilities;
import uow.ia.bean.ContactTypes;
import uow.ia.bean.Contacts;
import uow.ia.bean.CulturalBackgroundTypes;
import uow.ia.bean.DangerTypes;
import uow.ia.bean.DisabilityTypes;
import uow.ia.bean.Enquiries;
import uow.ia.bean.EnquiryIssues;
import uow.ia.bean.EnquiryTypes;
import uow.ia.bean.GenderTypes;
import uow.ia.bean.IndividualCases;
import uow.ia.bean.IssueTypes;
import uow.ia.bean.Risks;
import uow.ia.bean.StatusTypes;



public class ContactTest {
	private Logger logger = Logger.getLogger(ContactTest.class);
	@Autowired
	public static SessionFactory sessionFactory;
	private Session session;
	private static ServiceRegistry serviceRegistry;
	
  @Test
  public void f() {
	  @SuppressWarnings("unchecked")
	  //save
//  	  Transaction tx = null;
//  	  try{
//  		tx = session.beginTransaction();
//  		tx.setTimeout(5);
//  		Contacts newContact = new Contacts();
//  		List<AccommodationTypes> accommodationList = session.createSQLQuery("select * from Accommodation_Types where id = 3").addEntity(AccommodationTypes.class).list();
//  		AccommodationTypes accommodation = accommodationList.get(0);
//  		newContact.setAccommodation(accommodation);
//  		newContact.setAccommodationComment("Kim first saving contact aommodation");
//  		newContact.setFirstname("Ngoc");
//  		newContact.setLastname("To");
//  		
//  		Enquiries newEnquiry = new Enquiries();
//  		newEnquiry.setDescription("kim test first save for enquiry");
//  		
//  		newEnquiry.setContact(newContact);
//
//  		newContact.getEnquiriesSet().add(newEnquiry);
//  		session.save(newContact);
//  		tx.commit();
//  		
//  		List<Contacts> contactList = session.createSQLQuery("SELECT * FROM Contacts where id = 109").addEntity(Contacts.class).list();
//  		Contacts deleteContact = contactList.get(0);
//  		tx = session.beginTransaction();
//  		session.delete(deleteContact);
//  		tx.commit();
//  	}catch(RuntimeException e){
//  		try{
//  			tx.rollback();
//  		}catch(RuntimeException rbe){
//  			logger.error("Couldnt roll back transaction", rbe);
//  		}
//  		throw e;
//  	}
  	
	  
	  
	List<Contacts> contactList = session.createSQLQuery("SELECT * FROM Contacts").addEntity(Contacts.class).list();
	  Contacts contact = contactList.get(1);
	  System.out.println("Contact ID: " + contact.getId());
	  System.out.println("Title ID: " + contact.getTitleType().getName());
	  System.out.println("firstname: " + contact.getFirstname());
	  System.out.println("lastname: " + contact.getLastname());
	  System.out.println("othername: " + contact.getOthername());
	  System.out.println("genderId: " + contact.getGenderType().getGenderName());
	  System.out.println("contactTypename: " + contact.getContactType().getContactTypeName());
	  System.out.println("mobilephone: " + contact.getMobilephone());
	  System.out.println("email: " + contact.getEmail());
	  System.out.println("accommodation: " + contact.getAccommodation().getAccommodationName());
	  System.out.println("accommodationComment: " + contact.getAccommodationComment());
	  System.out.println("culturalBackgroundId: " + contact.getCulturalBackground().getCulturalBackgroundName());
	  System.out.println("culturalBackgroundComment: " + contact.getCulturalBackgroundComment());
	  System.out.println("dangerFlagId: " + contact.getDangerType().getDangerName());
	  System.out.println("identification: " + contact.getIdentification());
	  System.out.println("dob: " + contact.getDob());
	  List<Addresses> addressesSet = contact.getAddressesList();
	  for (Addresses a : addressesSet) {
		  System.out.println("Address: " + a.getId() + " " + a.getStreet() + " " + a.getSuburb() + " " + a.getPostcode() + " " + a.getState());
	  }
	  List<ClientDisabilities> disabilitySet = contact.getDisabilitiesList();
	  for (ClientDisabilities dt : disabilitySet) {
		  System.out.println("CLient Disability: " + dt.getId() + " " + dt.getDisabilityType().getDisabilityName() + " " + dt.getComments());
	  }
	  List<Enquiries> enquiriesSet  = contact.getEnquiriesList();
	  for (Enquiries a : enquiriesSet) {
		  System.out.println("Enquiry: " + a.getId());
	  }
	  List<IndividualCases> iaList = contact.getIndividualCasesList();

	  for (IndividualCases ia : iaList) {
		  System.out.println("IACase: " + ia.getId());
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
