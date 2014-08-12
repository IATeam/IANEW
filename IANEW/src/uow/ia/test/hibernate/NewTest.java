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



public class NewTest {
	private Logger logger = Logger.getLogger(NewTest.class);
	@Autowired
	public static SessionFactory sessionFactory;
	private Session session;
	private static ServiceRegistry serviceRegistry;
  @Test
  public void f() {
	  @SuppressWarnings("unchecked")
	List<Contacts> contactList = session.createSQLQuery("SELECT * FROM Contacts").addEntity(Contacts.class).list();
	  Contacts contact = contactList.get(1);
	  System.out.println("Contact ID: " + contact.getId());
	  System.out.println("Title ID: " + contact.getTitleType().getName());
	  System.out.println("firstname: " + contact.getFirstname());
	  System.out.println("lastname: " + contact.getLastname());
	  System.out.println("othername: " + contact.getOthername());
	  System.out.println("genderId: " + contact.getGenderType().getGenderName());
	  System.out.println("contactTypename: " + contact.getContactType().getContactTypeName());
	  System.out.println("homephone: " + contact.getHomephone());
	  System.out.println("workphone: " + contact.getWorkphone());
	  System.out.println("mobilephone: " + contact.getMobilephone());
	  System.out.println("email: " + contact.getEmail());
	  System.out.println("accommodation: " + contact.getAccommodation().getAccommodationName());
	  System.out.println("accommodationComment: " + contact.getAccommodationComment());
	  System.out.println("employmentId: " + contact.getEmploymentType().getEmploymentName());
	  System.out.println("employmentComment: " + contact.getEmploymentComment());
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
	  
	  List<AccommodationTypes> accommodationList = session.createSQLQuery("SELECT * FROM Accommodation_Types").addEntity(AccommodationTypes.class).list();
	  Set<Contacts> contactsSet  = accommodationList.get(1).getContactsSet();
	  System.out.println("Contacts");
	  System.out.println("accommodationId: " + accommodationList.get(1).getId());
	  System.out.println("Count: " + contactsSet.size());
	  for (Contacts c : contactsSet) {
		  System.out.println("contactId: " + c.getId());
	  }
	  
	  
	  List<ContactTypes> contactTypeList = session.createSQLQuery("SELECT * FROM Contact_Types").addEntity(ContactTypes.class).list();
	  Set<Contacts> contactsSet2  = contactTypeList.get(0).getContactsSet();
	  System.out.println("Contacts");
	  System.out.println("contactTypeId: " + contactTypeList.get(0).getId());
	  System.out.println("Count: " + contactsSet2.size());
	  for (Contacts s : contactsSet2) {
		  System.out.println("contactId: " + s.getId());
	  }
	  
	  List<GenderTypes> genderList = session.createSQLQuery("Select * From Gender_Types").addEntity(GenderTypes.class).list();
	  Set<Contacts> contactsSet3  = genderList.get(0).getContactsSet();
	  System.out.println("Contacts");
	  System.out.println("GenderId: " + genderList.get(0).getId());
	  System.out.println("Count: " + contactsSet3.size());
	  for (Contacts s : contactsSet3) {
		  System.out.println("contactId: " + s.getId());
	  }
	  
	  List<CulturalBackgroundTypes> culturalBackgroundList = session.createSQLQuery("Select * From Cultural_Background_Types").addEntity(CulturalBackgroundTypes.class).list();
	  System.out.println("CulturalBackgroundId: " + culturalBackgroundList.get(0).getId());
	  System.out.println("Count: " + culturalBackgroundList.get(0).getContactsSet().size());

	  List<DangerTypes> dangerList = session.createSQLQuery("Select * From Danger_Types").addEntity(DangerTypes.class).list();
	  System.out.println("DangerTypeId: " + dangerList.get(0).getId());
	  System.out.println("Count: " + dangerList.get(0).getContactsSet().size());
	  
	  List<Addresses> addressList = session.createSQLQuery("SELECT * FROM Addresses").addEntity(Addresses.class).list();
	  Addresses address = addressList.get(0);
	  System.out.println("Address ID: " + address.getId());
	  System.out.println("Address: " + address.getAddress());
	  System.out.println("Surburb: " + address.getSurburb());
	  System.out.println("State: " + address.getState());
	  System.out.println("Postcode: " + address.getPostcode());
	  System.out.println("Country:" + address.getCountry());
	  
	  List<DisabilityTypes> disabilityList = session.createSQLQuery("SELECT * FROM Disability_Types").addEntity(DisabilityTypes.class).list();
	  System.out.println("DisabilityId: " + disabilityList.get(0).getId());
	  System.out.println("Disability Count: " + disabilityList.get(0).getContactsSet().size());
	 
	  List<Enquiries> enquiryList = session.createSQLQuery("SELECT * FROM Enquiries").addEntity(Enquiries.class).list();
	  Enquiries enquiry = enquiryList.get(1);
	  System.out.println("Enquiry ID: " + enquiry.getId());
	  System.out.println("Contact Id: " + enquiry.getContact().getId());
	  System.out.println("Enquiry Type: " + enquiry.getEnquiryType().getEnquiryTypeName());
	  System.out.println("StatusTypeID " + enquiry.getStatusType().getId() + " " + enquiry.getStatusType().getStatusName());
	  System.out.println("ParentEnquiryId Id: " + enquiry.getParentEnquiry().getId());
	  Set<Enquiries> enquirySet = enquiry.getEnquiriesSet();
	  for(Enquiries e : enquirySet) {
		  System.out.println(e.getId() + " " + e.getDescription());
	  }
	  Set<EnquiryIssues> issueTypes = enquiry.getEnquiryIssuesSet();
	  for (EnquiryIssues dt : issueTypes) {
		  System.out.println("Issue: " + dt.getId() + " " + dt.getIssue().getIssueName()  + dt.getComment());
	  }
	  
	  List<EnquiryTypes> enquiryTypeList = session.createSQLQuery("SELECT * FROM Enquiry_Types").addEntity(EnquiryTypes.class).list();
	  System.out.println("Enquiry Type ID: " + enquiryTypeList.get(0).getId());
	  System.out.println("Count: " + enquiryTypeList.get(0).getEnquiriesSet().size());
	
	  List<IssueTypes> issueTypeList = session.createSQLQuery("SELECT * FROM Issue_Types").addEntity(IssueTypes.class).list();
	  System.out.println("Issue Type ID: " + issueTypeList.get(0).getId());
	  System.out.println("Enuiry Count: " + issueTypeList.get(0).getEnquiriesSet().size());
	  System.out.println("Case Count: " + issueTypeList.get(0).getIndividualCasesSet().size());
	  
	  
	  List<StatusTypes> statusList = session.createSQLQuery("SELECT * FROM Status_Types").addEntity(StatusTypes.class).list();
	  System.out.println("StatusId: " + statusList.get(0).getId());
	  System.out.println("Status Count: " + statusList.get(0).getEnquiriesSet().size());
	 
	  List<IndividualCases> IACase = session.createSQLQuery("SELECT * FROM Individual_Cases").addEntity(IndividualCases.class).list();
	  IndividualCases ia = IACase.get(1);
	  System.out.println("Case ID: " + ia.getId());
	  System.out.println("Contact Id: " + ia.getContact().getId());
	  System.out.println("Priority: " + ia.getPriorityType().getPriorityName());
	  Set<Risks> riskSet = ia.getRisksSet();
	  for (Risks a : riskSet) {
		  System.out.println("Risks: " + a.getId() + " " + a.getRiskDescription() + " " + a.getRiskManagement());
	  }
	  System.out.println("old case Id: " + ia.getOldCase().getId());
	  Set<CaseIssues> caseIssues = ia.getCaseIssuesSet();
	  for (CaseIssues dt : caseIssues) {
		  System.out.println("Issue: " + dt.getId() + " " + dt.getIssue().getIssueName() + " " + dt.getStatusType().getStatusName() + " " + dt.getComments());
	  }
	  
//	  Set<IndividualCases> iaSet = ia.getIndividualCasesSet();
//	  for(IndividualCases e : iaSet) {
//		  System.out.println(e.getId());
//	  }
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
