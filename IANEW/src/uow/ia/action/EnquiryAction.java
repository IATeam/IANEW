package uow.ia.action;


import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Set;

import antlr.Lookahead;

import com.opensymphony.xwork2.ModelDriven;
import com.sun.xml.rpc.processor.modeler.j2ee.xml.javaIdentifierType;

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
import uow.ia.bean.IssueTypes;
import uow.ia.bean.StatusTypes;
import uow.ia.bean.TitleTypes;
import uow.ia.util.DateUtil;

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
 * ==============================================
 * 	Description: An action class to linking the service from spring to the enquiry jsp pages
 *
 *----------------------------------------------------------------------------------------------*/



public class EnquiryAction extends BaseAction implements ModelDriven<Enquiries>{
	
	/* 
	 * form title (can either be new enquiry/exisiting enquiry/enquiry list)
	 */
	private String formTitle;;
	private Enquiries iamodel;
	private Contacts ccontact; //not calling from enquiry to allow 'CASE' to share the same include jsp
	
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
	//Status_Type or criteria control value table 
	private List<StatusTypes> statusSelectList;							
	

	/*
	 * Sets variables for 1 to many relationship tables
	 */
	private Set<EnquiryIssues> issueSet;
	private Set<Enquiries> linkedEnquiriesSet;
	private Set<Addresses> addressSet;
	private Set<ClientDisabilities> clientDisabilitiesSet;
	private Set<ContactEmployments> contactEmploymentsSet;

	public Set<ContactEmployments> getContactEmploymentsSet() {
		return contactEmploymentsSet;
	}

	public void setContactEmploymentsSet(
			Set<ContactEmployments> contactEmploymentsSet) {
		this.contactEmploymentsSet = contactEmploymentsSet;
	}	
	
	
	/*
	 * Sumamry
	 */
	private String description;
	
	
	
	
	
	
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
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
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
		activateLists();
		
		iamodel = new Enquiries();
		ccontact = new Contacts();
		
		//form status setters
		today = new Date();
		java.sql.Date sqlDate = new java.sql.Date(today.getTime());
		iamodel.setCreatedDateTime(sqlDate);
		iamodel.setUpdatedDateTime(sqlDate);
		/*
		 * TODO: change the user to the session user.
		 */
		iamodel.setCreatedUserId(1);
		iamodel.setUpdatedUserId(1);
		
		//setAddress(new Addresses());
		address = new Addresses();
		setToday(sqlDate);
		setDob("");
		
		
		return SUCCESS;
	}

	/**
	 * Action Method to get an Existing Enquiry Form by id
	 * @return String
	 */
	public String getExistingEnquiry(){
		activateLists();
		//System.out.println(getHiddenid());

		setIamodel(services.getEnquiry(getHiddenid()));
		setCcontact(getIamodel().getContact());
		System.out.println(getCcontact().getAddressesList().size());
		
		Date date = new Date(ccontact.getDob().getTime());
		//dob = DateUtil.yyyymmddStr(date);
		
		setDob(getCcontact().getDob().toString());
		
		
		
		System.out.println("hbm date = " + ccontact.getDob());
		//LATER
		//setCreatedBy();
		//setUpdatedBy(contact.);
		
		return SUCCESS;
	}
	
	String dob;
	
	
	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String updateAddressList(){ System.out.println("inside address List");
		
		System.out.println("street: " + getAddress().getStreet());
		System.out.println("suburb: " + getAddress().getSuburb());
		System.out.println("state: " + getAddress().getState());
		System.out.println("country: " + getAddress().getCountry());
		System.out.println("postcode: " + getAddress().getPostcode());
		System.out.println("homephone: " + getAddress().getHomephone());
		//getModel().getContact().getAddressesSet().add(address);
		//setAddress(new Addresses()); 
		//iamodel.getContact().getAddressesList().add(getAddress());
		
		
		setAddress(new Addresses());
		
		
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

		/*
		 * Address component
		 */
		List<Addresses> aSet = getCcontact().getAddressesList();
		System.out.println("firstname " + getCcontact().getFirstname());
		System.out.println("addressSet size " + getCcontact().getAddressesList().size());
		
		//today's date in sql format
		java.sql.Date sqlDate = new java.sql.Date(new Date().getTime());
		
		/*******************
		 * KIM HEERE
		 */
		getCcontact().setDob(new java.sql.Date(DateUtil.yyyymmddDate(getDob()).getTime()));
		System.out.println(getCcontact().getDob());
		/***************************/
		for(Addresses a: aSet){
			System.out.println("createdDateTime " + a.getCreatedDateTime());
			System.out.println("Street " + a.getStreet());
			System.out.println("Postcode: " + a.getPostcode());
			if(a.getId() == null){
				a.setCreatedDateTime(sqlDate);
				a.setUpdatedDateTime(sqlDate);
				//TODO: set created user and updated user to session user
				a.setCreatedUserId(1);
				a.setUpdatedUserId(1);
			}
		}
		
		
		
		/*
		 * Disability Component
		 */
		
		/*
		 * Issue Component
		 */
		
		/*
		 * Linked Enquiries Component;
		 */
		
		/*
		 * 
		 */
		
		
		/*
		 * Save compoenents into contact
		 */
		
		/*
		 * Save contact and enquiries
		 */
		//services.saveOrUpdateEnquiry(this.getIamodel(), this.getCcontact());
//		if(getCcontact().getDob() != null){
//			getCcontact().setDob(new java.sql.Date(DateUtil.yyyymmddDate(getDob()).getTime()));
//			//System.out.println(getCcontact().getDob());
//		}
		//getCcontact().setDob(new java.sql.Date(DateUtil.yyyymmddDate(getDob()).getTime()));
//		if(getDob() != ""){
//			getCcontact().setDob(new java.sql.Date(DateUtil.yyyymmddDate(getDob()).getTime()));
//		}
			//System.out.println("DOB: " + getDob());
		
		//services.saveOrUpdateEnquiry(getModel(), getModel().getCcontact());
		
		return SUCCESS;
	}

	/**
	 * Action method to return a list of enquiries
	 * @return String
	 */
//	public String enquiryList(){
//		setPage(1);
//		setNumberOfRecords(10);
//		
//		setEnquiryList(services.findEnquiriesByPage(page,numberOfRecords));
//		totalNumberOfRecords = services.countEnquiries();
//		int mod = (int) totalNumberOfRecords % numberOfRecords;
//		if(mod != 0) mod = 1;
//		totalNumberOfPages = totalNumberOfRecords/numberOfRecords + mod;
//		return SUCCESS;
//	}
	
	/**
	 * Action Method to update the enquiry list after requesting a different page
	 * @return String
	 */
//	public String updateEnquiryList(){
//		System.out.println(getPage());
//		
//		setEnquiryList(services.findEnquiriesByPage(getPage(),getNumberOfRecords()));
//		totalNumberOfRecords = services.countEnquiries();
//		int mod = (int) totalNumberOfRecords % numberOfRecords;
//		if(mod != 0) mod = 1;
//		totalNumberOfPages = totalNumberOfRecords/numberOfRecords + mod;
//		return SUCCESS;
//	}
	
	/* 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * ----------------------------------------------------------------------------------------------------------
	 * ----------------------------------------------------------------------------------------------------------
	 * Other Methods & Setters and Getters
	 * ----------------------------------------------------------------------------------------------------------
	 * ----------------------------------------------------------------------------------------------------------*/

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
	
	/**
	 * private method used by saveAndUpdateEnquiry to populate a Contacts object
	 * @param Contacts c
	 */
	private void populateContact(Contacts c){
		//getters for types
		//services.getAccommodationId(getTheAccommodation());
		//services.getGenderId(getTheGender());
		//services.getDisabilityId(getTheDisability());
		//services.getEnquiryId(getThe)
		
		
		//System.out.println(getTitleSelectList().toString());
		//titleSelectList.
		//System.out.println("theDanger: position" + index);
		//c.setDangerType(getDangerSelectList().get(position));
	}
	
	public void setTitleSelectList(List<TitleTypes> titleSelectList) {
		this.titleSelectList = titleSelectList;
	}

	//private int getIndex(String name, List<?> obj) throws NoSuchFieldException, SecurityException{
//		int index;
//		for(Object o: obj){
//			//if(name.equals(((Field) o).getName()))
//			if(o.getClass().equals(TitleTypes.class))
//				if(name.equals(((TitleTypes) o).getName())
//						index= ((TitleTypes) o).getId();
//		}
//		return index;
	//}
	
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
	
	public Contacts getCcontact() {
		return ccontact;
	}

	public void setCcontact(Contacts contact) {
		this.ccontact = contact;
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

//	public String getTheGender() {
//		return theGender;
//	}
//
//	public void setTheGender(String string) {
//		this.theGender = string;
//	}

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

	
	public Set<Enquiries> getLinkedEnquiriesSet() {
		return linkedEnquiriesSet;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<EnquiryTypes> getEnquiryTypeSelectList() {
		return enquiryTypeSelectList;
	}

	public void setEnquiryTypeSelectList(List<EnquiryTypes> enquiryTypeSelectList) {
		this.enquiryTypeSelectList = enquiryTypeSelectList;
	}



	public Set<EnquiryIssues> getIssueSet() {
		return issueSet;
	}

	public void setIssueSet(Set<EnquiryIssues> issueSet) {
		this.issueSet = issueSet;
	}

	public Set<Enquiries> getLinkedEquiriesSet() {
		return linkedEnquiriesSet;
	}

	public void setLinkedEnquiriesSet(Set<Enquiries> linkedEnquiriesSet) {
		this.linkedEnquiriesSet = linkedEnquiriesSet;
	}

	public Set<Addresses> getAddressSet() {
		return addressSet;
	}

	public void setAddressSet(Set<Addresses> address) {
		this.addressSet = address;
	}

	public Set<ClientDisabilities> getClientDisabilitiesSet() {
		return clientDisabilitiesSet;
	}

	public void setClientDisabilitiesSet(Set<ClientDisabilities> clientDisabilitiesSet) {
		this.clientDisabilitiesSet = clientDisabilitiesSet;
	}


	@Override
	public Enquiries getModel() {
		return iamodel;
	}
}
