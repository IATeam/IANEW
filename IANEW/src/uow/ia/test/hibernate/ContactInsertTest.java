package uow.ia.test.hibernate;

import java.sql.Date;
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
	  		ContactTypes contactType = (ContactTypes)session.get(ContactTypes.class, 2);
	  		CulturalBackgroundTypes culturalBackground = (CulturalBackgroundTypes)session.get(CulturalBackgroundTypes.class,3);
	  		GenderTypes genderType = (GenderTypes)session.get(GenderTypes.class, 2);
	  		TitleTypes titleType = (TitleTypes)session.get(TitleTypes.class, 2);
	  		
	  		newContact.setAccommodation(accommodation);
	  		newContact.setAccommodationComment("Kim first saving contact aommodation");
	  		newContact.setFirstname("Ngoc");
	  		newContact.setLastname("To");
	  		newContact.setTitleType(title);
	  		newContact.setContactType(contactType);
	  		newContact.setCulturalBackground(culturalBackground);
	  		newContact.setCulturalBackgroundComment("kim is vietnamese");
	  		newContact.setDangerType((DangerTypes)session.get(DangerTypes.class, 1));
	  		newContact.setDob(Date.valueOf("1992-08-26"));
	  		newContact.setEmail("kim.to6462@gmail.com");
	  		newContact.setGenderType(genderType);
	  		newContact.setIdentification("NF1234");
	  		newContact.setMobilephone("0401520752");
	  		newContact.setTitleType(titleType);
	  		
	  		// set client disability
	  		ClientDisabilities cDisability = new ClientDisabilities();
	  		cDisability.setComments("primary disability");
	  		cDisability.setContact(newContact);
	  		cDisability.setDisabilityType((DisabilityTypes)session.get(DisabilityTypes.class, 2));
	  		cDisability.setPrimaryFlag("Y");
	  		
	  		newContact.getDisabilitiesSet().add(cDisability);
	  		
	  		// set client employment
	  		EmploymentTypes etype = (EmploymentTypes)session.get(EmploymentTypes.class, 2);
	  		
	  		ContactEmployments employment = new ContactEmployments();
	  		employment.setComments("Kim 1st employment");
	  		employment.setContact(newContact);
	  		employment.setEmploymentType(etype);
	  		employment.setWorkphone("4036578");
	  		
	  		newContact.getEmploymentsSet().add(employment);
	  		
	  		// set contact address
	  		Addresses address = new Addresses();
	  		address.setStreet("Unit 2/19 Sperry Street");
	  		address.setContact(newContact);
	  		address.setCountry("Australia");
	  		address.setHomephone("021323234");
	  		address.setPostcode("2500");
	  		address.setState("NSW");
	  		address.setSuburb("Wollongong");
	  		
	  		newContact.getAddressesSet().add(address);
	  		
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