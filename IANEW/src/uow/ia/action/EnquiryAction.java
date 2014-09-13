	package uow.ia.action;


import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import uow.ia.bean.AccommodationTypes;
import uow.ia.bean.Addresses;
import uow.ia.bean.ClientDisabilities;
import uow.ia.bean.ContactEmployments;
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
import uow.ia.bean.StatusTypes;
import uow.ia.bean.TitleTypes;

import uow.ia.reflection.Reflection;

/** ---------------------------------------------------------------------------------------------
 * @author: Quang Nhan
 * Created Date: 27/07/2014
 * ==============================================
 * Updates:
 * 12/08/2014 - 	Quang Nhan
 * 					Migrate code into new project setup
 * 14/08/2014 	- 	Quang Nhan
 * 					Connect and retrieve data from service class to enquiry, enquirylist jsps and a
 * 					dded pagination functionality
 * 16/08/2014 -		Quang Nhan
 * 					Refactor the code
 * 21/08/2014 -		Quang Nhan
 * 					populate today's date for created and updated fields for  new enquiry
 * 28/08/2014 -		Quang Nhan
 * 					Save enquiry implemented.Get contact by firstname and last name in new enquiry
 * 29/08/2014 -		Quang Nhan
 * 					Moved enquiry list to its own action class EnquiryListAction
 * 02/08/2014 -		Quang Nhan
 * 					Modified JSPs such that the name is directly associated with the bean class
 * 11/08/2014 -		Quang Nhan
 * 					Implements SessionAware and used reflection to updated enquiry.
 * ==============================================
 * 	Description: An action class to linking the service from spring to the enquiry jsp pages
 *
 *----------------------------------------------------------------------------------------------*/



public class EnquiryAction extends BaseAction implements SessionAware{
	
	private final String ENQUIRY = "enquiry";
	/* 
	 * form title (can either be new enquiry/exisiting enquiry/enquiry list)
	 */
	private String formTitle;;
	private Enquiries iamodel;
	//private Contacts ccontact;
	//not calling from enquiry to allow 'CASE' to share the same include jsp
	
	/*
	 * Lists for the drop down select options for the jsps
	 * and its associated value variables
	 */
	private List<TitleTypes> titleSelectList; 							
	private List<GenderTypes> genderSelectList; 						
	private List<CulturalBackgroundTypes> culturalBackgroundSelectList;
	private List<AccommodationTypes> accommodationSelectList;			
	private List<DisabilityTypes> disabilitySelectList;					
	private List<EnquiryTypes> enquiryTypeSelectList;					
	private List<IssueTypes> issueSelectList;							
	private List<EmploymentTypes> employmentSelectList;					
	private List<DangerTypes> dangerSelectList;							
	private List<StatusTypes> statusSelectList;							
	

	private List<String> firstNameAuto;
	
	public List<String> getFirstNameAuto() {
		return firstNameAuto;
	}

	public void setFirstNameAuto(List<String> firstNameAuto) {
		this.firstNameAuto = firstNameAuto;
	}

	private List<Enquiries> linkedEnquiriesList;
	
	//vairiable used to get enquiry id from enquiry list;
	int hiddenid;
	
	public int getHiddenid() { 
		return hiddenid;
	}

	public void setHiddenid(int hiddenid) {
		this.hiddenid = hiddenid;
	}
 
	Addresses address;
	ClientDisabilities clientDisability;
	EnquiryIssues enquiryIssue;
	

	EnquiryIssues issue;
	
	Date today;
	
	
	public Date getToday() {
		return today;
	}

	public void setToday(Date today) {
		this.today = today;
	}

	/*
	 * ----------------------------------------------------------------------------------------------------------
	 * ----------------------------------------------------------------------------------------------------------
	 * Action Methods
	 * ----------------------------------------------------------------------------------------------------------
	 * ----------------------------------------------------------------------------------------------------------*/
	public Addresses getAddress() {
		return address;
	}
	
	public void setAddress(Addresses address) {
		this.address = address;
	}

	/**
	 * Action Method to create a new enquiry
	 * @return String
	 */
	public String newEnquiry(){

		System.out.println(">>>Beg New Enquiry");
		//activateAutocomplete();

		activateLists();
		iamodel = new Enquiries();
		
		Reflection ref = new Reflection();
		ref.initializeNewModel(iamodel);
		
		if(userSession.containsKey(ENQUIRY))
			userSession.remove(ENQUIRY); 
		
		userSession.put(ENQUIRY, iamodel);
	
		
		//linkedEnquiriesList = services.getLinkedEnquiry(getHiddenid());
		System.out.println("<<<end of new equiry");
		
		return SUCCESS;
	
	}

	/**
	 * Action Method to get an Existing Enquiry Form by id
	 * @return String
	 */
	public String getExistingEnquiry(){
		activateAutocomplete();
		activateLists();
		
		iamodel = services.getEnquiry(getHiddenid());
		//TODO: pass this block of code into Reflection.
		
		Contacts contacts = null;
		try {
			contacts = (Contacts) iamodel.getContact().clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		iamodel.setContact(contacts);
		if(userSession.containsKey(ENQUIRY))
			userSession.remove(ENQUIRY); 
		userSession.put(ENQUIRY, iamodel);
		
		linkedEnquiriesList = services.getLinkedEnquiry(getHiddenid());
		
		return SUCCESS;
	}
	
	String dob;
	
	
	
	
	public String updateLinkedEnquiries(){
		System.out.println("hidden id is " + getHiddenid());
		linkedEnquiriesList = services.getLinkedEnquiry(getHiddenid());
		System.out.println(getLinkedEnquiriesList().size());
		
		
		return SUCCESS;
	}
	
	public String checkContactExists(){
		//services.findContactsByFullName(, lastName);
		return SUCCESS;
	}
	
	/**
	 * Action method to Save/Update an enquiry form
	 * @return String
	 * @throws ParseException 
	 */
	public String saveUpdateEnquiry() throws ParseException{ 
		
		System.out.println(">>>Begin SaveUpdateEnquiry");
		//System.out.println(iamodel.getContact().getAddressesList().get(2).getCountry());	
		Enquiries enquiry = (Enquiries) userSession.get(ENQUIRY);
		enquiry = services.mergeEnquiry(enquiry);
		System.out.println("called ");
		//System.out.println("contact class: " + enquiry.getContact().getClass());
		//printIamodel(iamodel);
		//Reflection ref = new Reflection();
		//ref.updateObject(enquiry, iamodel);
		
		enquiry.getContact().setFirstname(iamodel.getContact().getFirstname());
		
		//System.out.println("contact class: " + enquiry.getContact().getClass());
		
		//System.out.println("first name iamodel: " + iamodel.getContact().getFirstname());
		//System.out.println("first name enquiry: " + enquiry.getContact().getFirstname());
		
		if(services.saveOrUpdateEnquiry(enquiry)){
			activateLists();
			setIamodel(enquiry);
			return SUCCESS;
		}
		activateLists();
		setIamodel(enquiry);
		System.out.println("save unsuccessful");
		return SUCCESS;
		
	}

	
	/* 
	 * ----------------------------------------------------------------------------------------------------------
	 * ----------------------------------------------------------------------------------------------------------
	 * Other Methods & Setters and Getters
	 * ----------------------------------------------------------------------------------------------------------
	 * ----------------------------------------------------------------------------------------------------------*/
	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}
	
	private void activateAutocomplete(){
		firstNameAuto = new ArrayList<String>();
		firstNameAuto.add("Tom");
		firstNameAuto.add("Tori");
		firstNameAuto.add("Terry");
		firstNameAuto.add("Cary");
		firstNameAuto.add("Cathy");
	}
	
	/**
	 * populate the Select List variables
	 */
	private void activateLists(){
		setTitleSelectList(services.findTitleTypes());
		genderSelectList=services.findGenderTypes();
		culturalBackgroundSelectList=services.findCulturalBackgroundTypes();
		accommodationSelectList = services.findAccommodationTypes();
		disabilitySelectList = services.findDisabilityTypes();
		issueSelectList = services.findIssueTypes();
		dangerSelectList = services.findDangerTypes();
		employmentSelectList = services.findEmploymentTypes();
		//setEmploymentList(contact.getEmploymentType());
		statusSelectList = services.findStatusTypes();
		enquiryTypeSelectList = services.findEnquiryTypes();
		
	}
	
	
	public void setTitleSelectList(List<TitleTypes> titleSelectList) {
		this.titleSelectList = titleSelectList;
	}
	
	/**
	 * Getter for the form title
	 * @return String
	 */
	public String getFormTitle() {
		return formTitle;
	}
	/**
	 * Setter for the form title
	 * @param formTitle
	 */
	public void setFormTitle(String formTitle) {
		System.out.println(formTitle);
		this.formTitle = formTitle;
	}
	

	public Enquiries getIamodel(){
		return iamodel;
	}

	/**
	 * Setter for enquiry
	 * @param enquiry
	 */
	public void setIamodel(Enquiries enquiry){
		this.iamodel = enquiry;
	}

	/**
	 * Getter for title types
	 * @return List
	 */
	public List<TitleTypes> getTitleSelectList() {
		return titleSelectList;
	}

	/**
	 * Getter for gender types
	 * @return List
	 */
	public List<GenderTypes> getGenderSelectList() {
		return genderSelectList;
	}

	/**
	 * Getter for cultural background types
	 * @return List
	 */
	public List<CulturalBackgroundTypes> getCulturalBackgroundSelectList() {
		return culturalBackgroundSelectList;
	}

	/**
	 * Getter for accommodation types
	 * @return List
	 */
	public List<AccommodationTypes> getAccomodationSelectList() {
		return accommodationSelectList;
	}

	/**
	 * Getter for disability type
	 * @return List
	 */
	public List<DisabilityTypes> getDisabilitySelectList() {
		return disabilitySelectList;
	}


	/**
	 * Getter for issue type
	 * @return List
	 */
	public List<IssueTypes> getIssueSelectList() {
		return issueSelectList;
	}


	/**
	 * Getter for employment types
	 * @return List
	 */
	public List<EmploymentTypes> getEmploymentSelectList() {
		return employmentSelectList;
	}

	/**
	 * @return List
	 */
	public List<DangerTypes> getDangerSelectList() {
		return dangerSelectList;
	}

	/**
	 * Getter for enquiry status select list
	 * @return
	 */
	public List<StatusTypes> getStatusSelectList() {
		return statusSelectList;
	}

	public List<EnquiryTypes> getEnquiryTypeSelectList() {
		return enquiryTypeSelectList;
	}

	public void setEnquiryTypeSelectList(List<EnquiryTypes> enquiryTypeSelectList) {
		this.enquiryTypeSelectList = enquiryTypeSelectList;
	}

	public List<Enquiries> getLinkedEnquiriesList() {
		return linkedEnquiriesList;
	}

	public void setLinkedEnquiriesList(List<Enquiries> linkedEnquiriesList) {
		this.linkedEnquiriesList = linkedEnquiriesList;
	}
	
	private void printContact(Contacts c){
		System.out.println(">>>Start Printing Contact Information: ");
		//TODO: missing created and updated user date and id
		//why status type for contact?
		//"\ncontact type: " + c.getContactType().getContactTypeName() +
		System.out.println(
				"danger type: " + c.getDangerType().getDangerName() + 
				"\ncontact id: " + c.getId() + 
				"\ntitle: " + c.getTitleType().getName() +
				"\nfirst name: " + c.getFirstname() + 
				"\nother name: " + c.getOthername() +
				"\nlast name: " + c.getLastname() + 
				"\ngender type: " + c.getGenderType().getGenderName() +
				"\ndob: " + c.getDob().toString() + 
				 
				"\nmobile: " + c.getMobilephone() + 
				"\nemail: " + c.getEmail() + 
				"\nidentification: " + c.getIdentification() +
				"\ncultural background: " + c.getCulturalBackground().getCulturalBackgroundName() + 
				"\ncultrual background comment: " + c.getCulturalBackgroundComment() +
				"\naccommodation: " + c.getAccommodation().getAccommodationName() +
				"\naccommodation comment: " + c.getAccommodationComment());
		for (Addresses a : c.getAddressesList()) {
			System.out.println(
					"address id: " + a.getId() +
					"\nstreet: " + a.getStreet() +
					"\nsuburb: " + a.getSuburb() +
					"\npostcode: " + a.getPostcode() +
					"\nstate: " + a.getState() +
					"\ncountry: " + a.getCountry() + 
					"\nhomephone: " + a.getHomephone()
					);
		}
		
		for(ClientDisabilities cd: c.getDisabilitiesList()){
			System.out.println(
					"disability id: " + cd.getId() +
					"\ndisability type: " + cd.getDisabilityType().getDisabilityName() +
					"\ncomments: " + cd.getComments() +
					"\nprimary flag: " + cd.getPrimaryFlag() );
		};
		for(ContactEmployments ce: c.getEmploymentsList()){
			System.out.println(
					"employment id: " + ce.getId() +
					"\nemployment type: " + ce.getEmploymentType().getEmploymentName() +
					"\ncomments: " + ce.getComments() + 
					"\nwork phone: " + ce.getWorkphone() );
		}
		System.out.println(">>>End of Printing Contact Information");
	}
	private void printIamodel(Enquiries e) throws NullPointerException{
		System.out.println(
			"Enquiry id: " + e.getId() + 
			"\ncreated date: " + e.getCreatedDateTime() + 
			"\ncreated User: " + e.getCreatedUserId() +
			"\nupdated date: " + e.getUpdatedDateTime() +
			"\nupdated User: " + e.getUpdatedUserId() +
			"\nenquiry type: " + e.getEnquiryType().getEnquiryTypeName() +
			"\nstatus type: " + e.getStatusType().getStatusName() + 
			"\ndescription: " + e.getDescription() +
			"\ninquisitor: " + e.getInquisitor() + 
			"\nreferral by: " + e.getReferralBy() +
			"\nreferred to: " + e.getReferralTo());// +
			//"\nparent enquiry id: " + e.getParentEnquiry().getId() );
		for (EnquiryIssues ei : e.getEnquiryIssuesList()) {
			System.out.println(
					"Enquiry Issue id: " + ei.getId() +
					"\nissue type: " + ei.getIssue().getIssueName() +
					"\ncomment: " + ei.getComment()
					);
		}
//		for(Enquiries e2: e.getEnquiriesList()){
//			System.out.println( "linked enquiry id: " + e2.getId());
//		}
	
	}
	
	Map <String, Object> userSession;

	@Override
	public void setSession(Map<String,Object> session) {
		System.out.println("setSession called");
		this.userSession = session;
	}
}
