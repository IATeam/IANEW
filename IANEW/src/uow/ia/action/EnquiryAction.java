package uow.ia.action;


import java.util.Date;
import java.util.List;
import java.util.Set;


import com.opensymphony.xwork2.ModelDriven;

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
	private List<TitleTypes> titleSelectList; 							private String theTitle;
	private List<GenderTypes> genderSelectList; 						private String theGender;
	private List<CulturalBackgroundTypes> culturalBackgroundSelectList;	private String theCulturalBackground;
	private List<AccommodationTypes> accommodationSelectList;			private String theAccommodation;
	private List<DisabilityTypes> disabilitySelectList;					private String theDisability;
	private List<EnquiryTypes> enquiryTypeSelectList;					private String theEnquiryType;
	private List<IssueTypes> issueSelectList;							private String theIssue;
	private List<EmploymentTypes> employmentSelectList;					private String theEmployment;
	private List<DangerTypes> dangerSelectList;							//private String theDanger;
	//Status_Type or criteria control value table 
	private List<StatusTypes> statusSelectList;							private String theStatus;
	

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
	 * status variables
	 */
	private String createdBy, updatedBy;
	//private Integer id;
	
	
	
	/*
	 * Employment
	 */
	
	private String profession, workPhone, employmentDescription, employmentComment;
	
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

//	/* For pagination */
//	private List<Enquiries> enquiryList;
//	int page;
//	int numberOfRecords;
//	long totalNumberOfRecords;
//	long totalNumberOfPages;

	//used to populate address 
	Addresses address;
	

	EnquiryIssues issue;
	
	
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
		Date today = new Date();
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
		
		
		//Set<Addresses> addressSet = new HashSet<Addresses>();
		//this is going to be inserted into the addressSet 
		//address = new Addresses();
		
		//iamodel.getEnquiryIssuesSet();
		//issue = new EnquiryIssues();
		
		
//		ActionContext context = ActionContext.getContext();
//		ActionMapping am = new ActionMapping();
//		Map map = context.getContextMap();
//		System.out.println("getting action name: " + map.toString());
		
		
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
		System.out.println(getCcontact().getAddressesSet().size());
		//setCcontact(getIamodel().getContact());
//		setIssueSet(iamodel.getEnquiryIssuesSet());
//		setClientDisabilitiesSet(contact.getDisabilitiesSet());
//		setLinkedEnquiriesSet(iamodel.getEnquiriesSet());
	
		//LATER
		//setCreatedBy();
		//setUpdatedBy(contact.);
		
		//setAddressSet(contact.getAddressesSet());
		
//		if(null != contact.getGenderType())
//			setTheGender(contact.getGenderType().getGenderName());
		
		//if(null != contact.getDangerType())
			//setTheDanger(contact.getDangerType().getDangerName());
		
		//setTheEmployment(contact.getEmploymentsTypeSet());
//		setTheEmployment("Kim change databse need chagne code for this part");
		//setTheCulturalBackground(contact.getCulturalBackground().getCulturalBackgroundName());
//		setTheAccommodation(contact.getAccommodation().getAccommodationName());
//		setTheStatus(iamodel.getStatusType().getStatusName());
		
		
//		setInquisitor(model.getInquisitor());
//		setReferredBy(model.getReferralBy());
//		setReferredTo(model.getReferralTo());
		
		
		
		return SUCCESS;
	}
	
	public String updateAddressSet(){ System.out.println("inside address");
//		address.setCountry("ABC");
//		address.setPostcode("2324");
//		address.setHomephone("22323 2323");
	
		System.out.println("address: " + getAddress().getStreet());
		System.out.println("suburb: " + getAddress().getSuburb());
		System.out.println("state: " + getAddress().getState());
		System.out.println("country: " + getAddress().getCountry());
		System.out.println("postcode: " + getAddress().getPostcode());
		System.out.println("homephone: " + getAddress().getHomephone());
		//getModel().getContact().getAddressesSet().add(address);
		//setAddress(new Addresses()); 
		iamodel.getContact().getAddressesSet().add(getAddress());
		
		
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
	 */
	public String saveUpdateEnquiry(){ 
//		System.out.println("in save update");
//		Enquiries newEnquiry = new Enquiries();
//		Contacts newContact = new Contacts();
		
//		newEnquiry.setCreatedDateTime(getCreatedDate());
//		newEnquiry.setCreatedUserId(1);
//		newEnquiry.setUpdatedDateTime(getCreatedDate());
//		newEnquiry.setUpdatedUserId(1);
		
//		newEnquiry.setDescription(getDescription());
//		newEnquiry.setInquisitor(getInquisitor());
//		
//		newContact.setFirstname(contact.getFirstname());
//		newContact.setLastname(contact.getLastname());
//		
//		services.saveOrUpdateEnquiry(newEnquiry, newContact);
		//if(titleSelectList.equals(null))
		
//		Contacts newContact = new Contacts();
//		populateContact(newContact);
		
		//iamodel.setEnquiryType(getEnquiryTypeSelectList().get(services.getEnquiryTypeId(getTheEnquiryType())));
		//EnquiryTypes enquiryTypes = enquiryTypeSelectList.get(services.getEnquiryTypeId(getTheEnquiryType()));
		//iamodel.setEnquiryType(services.getDangerType(getTheEnquiryType()));
		//Contacts aSet = getCcontact();
		System.out.println("firstname " + getCcontact().getFirstname());
		System.out.println("addressSet size " + getCcontact().getAddressesSet().size());
//		for(Addresses a: aSet){
//			System.out.println("Suburb " + a.getSurburb());
//		}
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
		
		String title = getTheTitle();
		int index;
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

	public String getTheTitle() {
		return theTitle;
	}

	public void setTheTitle(String theTitle) {
		this.theTitle = theTitle;
	}

	/**
	 * Getter for gender types
	 * @return List
	 */
	public List<GenderTypes> getGenderSelectList() {
		return genderSelectList;
	}

	public String getTheGender() {
		return theGender;
	}

	public void setTheGender(String string) {
		this.theGender = string;
	}

	/**
	 * Getter for cultural background types
	 * @return List
	 */
	public List<CulturalBackgroundTypes> getCulturalBackgroundSelectList() {
		return culturalBackgroundSelectList;
	}

	public String getTheCulturalBackground() {
		return theCulturalBackground;
	}

	public void setTheCulturalBackground(String theCulturalBackground) {
		this.theCulturalBackground = theCulturalBackground;
	}

	/**
	 * Getter for accommodation types
	 * @return List
	 */
	public List<AccommodationTypes> getAccomodationSelectList() {
		return accommodationSelectList;
	}

	public String getTheAccommodation() {
		return theAccommodation;
	}

	public void setTheAccommodation(String theAccommodation) {
		this.theAccommodation = theAccommodation;
	}

	/**
	 * Getter for disability type
	 * @return List
	 */
	public List<DisabilityTypes> getDisabilitySelectList() {
		return disabilitySelectList;
	}

	public String getTheDisability() {
		return theDisability;
	}

	public void setTheDisability(String theDisability) {
		this.theDisability = theDisability;
	}

	/**
	 * Getter for issue type
	 * @return List
	 */
	public List<IssueTypes> getIssueSelectList() {
		return issueSelectList;
	}

	public String getTheIssue() {
		return theIssue;
	}

	public void setTheIssue(String theIssue) {
		this.theIssue = theIssue;
	}

	/**
	 * Getter for employment types
	 * @return List
	 */
	public List<EmploymentTypes> getEmploymentSelectList() {
		return employmentSelectList;
	}

	public String getTheEmployment() {
		return theEmployment;
	}

	public void setTheEmployment(String theEmployment) {
		this.theEmployment = theEmployment;
	}

	/**
	 * @return List
	 */
	public List<DangerTypes> getDangerSelectList() {
		return dangerSelectList;
	}

//	public String getTheDanger() {
//		return theDanger;
//	}
//
//	public void setTheDanger(String theDanger) {
//		this.theDanger = theDanger;
//	}

	/**
	 * Getter for enquiry status select list
	 * @return
	 */
	public List<StatusTypes> getStatusSelectList() {
		return statusSelectList;
	}
	/**
	 * setter for enquiry status select list
	 * @param enquiryStatusSelectList
	 */
	public void setStatusSelectList(List<StatusTypes> statusSelectList) {
		this.statusSelectList = statusSelectList;
	}

	
	/**
	 * @return
	 */
	public String getTheStatus() {
		return theStatus;
	}

	/**
	 * @param theEnquiryStatus
	 */
	public void setTheStatus(String theStatus) {
		this.theStatus = theStatus;
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

	public String getTheEnquiryType() {
		return theEnquiryType;
	}

	public void setTheEnquiryType(String theEnquiryType) {
		this.theEnquiryType = theEnquiryType;
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


	/**
	 * Getter for created by full name
	 * @return
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * Setter for the created by full name
	 * @param createdBy
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * Getter for updated by
	 * @return String
	 */
	public String getUpdatedBy() {
		return updatedBy;
	}

	/**
	 * Setter for updated by
	 * @param updatedBy
	 */
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	

//	/**
//	 * Getter for enquiry id
//	 * @return
//	 */
//	public Integer getId() {
//		return id;
//	}
//
//	/**
//	 * Setter for enquiry id
//	 * @param id
//	 */
//	private void setId(Integer id) {
//		this.id = id;
//	}

	/** Referrals **/
	/**
	 * Getter for inquisitor
	 * @return
	 */
//	public String getInquisitor() {
//		return inquisitor;
//	}
//
//	/**
//	 * Setter for inquisitor
//	 * @param inquisitor
//	 */
//	public void setInquisitor(String inquisitor) {
//		this.inquisitor = inquisitor;
//	}
//
//	/**
//	 * Getter for referred by
//	 * @return String
//	 */
//	public String getReferredBy() {
//		return referredBy;
//	}
//
//	/**
//	 * Setter for referred by
//	 * @param referredBy
//	 */
//	public void setReferredBy(String referredBy) {
//		this.referredBy = referredBy;
//	}
//
//	/**
//	 * Getter for referred to
//	 * @return
//	 */
//	public String getReferredTo() {
//		return referredTo;
//	}
//
//	/**
//	 * Setter for referred to
//	 * @param referredTo
//	 */
//	public void setReferredTo(String referredTo) {
//		this.referredTo = referredTo;
//	}

	@Override
	public Enquiries getModel() {
		// TODO Auto-generated method stub
		return iamodel;
	}


}
