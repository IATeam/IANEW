package uow.ia.test.hibernate;

import java.util.HashSet;
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
import uow.ia.bean.ContactEmployments;
import uow.ia.bean.ContactTypes;
import uow.ia.bean.Contacts;
import uow.ia.bean.CulturalBackgroundTypes;
import uow.ia.bean.DangerTypes;
import uow.ia.bean.DisabilityTypes;
import uow.ia.bean.EmploymentTypes;
import uow.ia.bean.Enquiries;
import uow.ia.bean.EnquiryIssues;
import uow.ia.bean.EnquiryTypes;
import uow.ia.bean.GenderTypes;
import uow.ia.bean.IndividualCases;
import uow.ia.bean.IssueTypes;
import uow.ia.bean.Risks;
import uow.ia.bean.StatusTypes;
import uow.ia.bean.TitleTypes;



public class ContactInsertTest {
	private Logger logger = Logger.getLogger(ContactInsertTest.class);
	@Autowired
	public static SessionFactory sessionFactory;
	private Session session;
	private static ServiceRegistry serviceRegistry;
	
  @Test
  public void f() {
	  @SuppressWarnings("unchecked")
	  //save
  	  Transaction tx = null;
  	  try{
    		tx = session.beginTransaction();
	  		Contacts newContact = new Contacts();
	  		TitleTypes title = (TitleTypes)session.get(TitleTypes.class, 1);
	  		AccommodationTypes accommodation = (AccommodationTypes)session.get(AccommodationTypes.class, 3);
	  		
	  		newContact.setAccommodation(accommodation);
	  		newContact.setAccommodationComment("Kim first saving contact aommodation");
	  		newContact.setFirstname("Ngoc");
	  		newContact.setLastname("To");
	  		newContact.setTitleType(title);
	  		
	  		EmploymentTypes etype = (EmploymentTypes)session.get(EmploymentTypes.class, 2);
	  		
	  		ContactEmployments employment = new ContactEmployments();
	  		employment.setComments("Kim 1st employment");
	  		employment.setContact(newContact);
	  		employment.setEmploymentType(etype);
	  		employment.setWorkphone("4036578");
	  		
	  		newContact.getEmploymentsSet().add(employment);
	  		
	  		session.saveOrUpdate(newContact);
	  		tx.commit();
  	}catch(RuntimeException e){
  		try{
  			tx.rollback();
  		}catch(RuntimeException rbe){
  			logger.error("Couldnt roll back transaction", rbe);
  		}
  		throw e;
  	}
  	
	  
	  
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
	  Set<Addresses> addressesSet = contact.getAddressesSet();
	  for (Addresses a : addressesSet) {
		  System.out.println("Address: " + a.getId() + " " + a.getAddress() + " " + a.getSurburb() + " " + a.getPostcode() + " " + a.getState());
	  }
	  Set<ClientDisabilities> disabilitySet = contact.getDisabilitiesSet();
	  for (ClientDisabilities dt : disabilitySet) {
		  System.out.println("CLient Disability: " + dt.getId() + " " + dt.getDisabilityType().getDisabilityName() + " " + dt.getComments());
	  }
	  Set<Enquiries> enquiriesSet  = contact.getEnquiriesSet();
	  for (Enquiries a : enquiriesSet) {
		  System.out.println("Enquiry: " + a.getId());
	  }
	  Set<IndividualCases> iaList = contact.getIndividualCasesSet();

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