package uow.ia.action;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.struts2.dispatcher.Dispatcher;
import org.apache.struts2.dispatcher.mapper.ActionMapping;
import org.apache.struts2.dispatcher.mapper.DefaultActionMapper;

import com.opensymphony.xwork2.ActionContext;

import uow.ia.bean.AccommodationTypes;
import uow.ia.bean.Addresses;
import uow.ia.bean.ClientDisabilities;
import uow.ia.bean.Contacts;
import uow.ia.bean.CulturalBackgroundTypes;
import uow.ia.bean.DangerTypes;
import uow.ia.bean.DisabilityTypes;
import uow.ia.bean.EmploymentTypes;
import uow.ia.bean.Enquiries;
import uow.ia.bean.EnquiryIssues;
import uow.ia.bean.GenderTypes;
import uow.ia.bean.IssueTypes;
import uow.ia.bean.StatusTypes;
import uow.ia.bean.TitleTypes;

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
 * ==============================================
 * 	Description: An action class to linking the service from spring to the enquiry jsp pages
 *
 *----------------------------------------------------------------------------------------------*/



public class EnquiryAction extends BaseAction{
	
	/* 
	 * form title (can either be new enquiry/exisiting enquiry/enquiry list)
	 */
	private String formTitle;;
	private Enquiries enquiry;
	private Contacts contact; //not calling from enquiry to allow 'CASE' to share the same include jsp
	
	/*
	 * Lists for the drop down select options for the jsps
	 * and its associated value variables
	 */
	private List<TitleTypes> titleSelectList; 							private String theTitle;
	private List<GenderTypes> genderSelectList; 						private String theGender;
	private List<CulturalBackgroundTypes> culturalBackgroundSelectList;	private String theCulturalBackground;
	private List<AccommodationTypes> accommodationSelectList;			private String theAccommodation;
	private List<DisabilityTypes> disabilitySelectList;					private String theDisability;
	private List<Enquiries> enquiryTypeSelectList;						private String theEnquiryType;
	private List<IssueTypes> issueSelectList;							private String theIssue;
	private List<EmploymentTypes> employmentSelectList;					private String theEmployment;
	private List<DangerTypes> dangerSelectList;							private String theDanger;
	//Status_Type or criteria control value table 
	private List<StatusTypes> statusSelectList;							private String theStatus;
	



	/*
	 * Sets variables for 1 to many relationship tables
	 */
	private Set<EnquiryIssues> issueSet;
	private Set<Enquiries> linkedEnquiriesSet;
	private Set<Addresses> addressSet;
	private Set<ClientDisabilities> clientDisabilitiesSet;

	/*
	 * status variables
	 */
	private Date createdDate, updatedDate;
	private String createdBy, updatedBy;
	private Integer id;
	
	/*
	 * Referral
	 */
	private String inquisitor, referredBy, referredTo;
	
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

	/* For pagination */
	private List<Enquiries> enquiryList;
	int page;
	int numberOfRecords;
	long totalNumberOfRecords;
	long totalNumberOfPages;


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
	
	
	/**
	 * Action Method to create a new enquiry
	 * @return String
	 */
	public String newEnquiry(){
		activateLists();
		setCreatedDate(new Date());
		setUpdatedDate(new Date());
		
		ActionContext context = ActionContext.getContext();
		ActionMapping am = new ActionMapping();
		Map map = context.getContextMap();
		System.out.println("getting action name: " + map.toString());
		return SUCCESS;
	}

	/**
	 * Action Method to get an Existing Enquiry Form by id
	 * @return String
	 */
	public String getExistingEnquiry(){
		//System.out.println(getHiddenid());
		setEnquiry(services.getEnquiry(getHiddenid()));
		setContact(enquiry.getContact());
		
		setIssueSet(enquiry.getEnquiryIssuesSet());
		setClientDisabilitiesSet(contact.getDisabilitiesSet());
		setLinkedEnquiriesSet(enquiry.getEnquiriesSet());
	
		//LATER
		//setCreatedBy();
		//setUpdatedBy(contact.);
		setCreatedDate(enquiry.getCreatedDateTime());
		setUpdatedDate(enquiry.getUpdatedDateTime());
		setId(enquiry.getId());
		setDescription(enquiry.getDescription());
		setAddress(contact.getAddressesSet());
		if(null != contact.getGenderType())
			setTheGender(contact.getGenderType().getGenderName());
		
		if(null != contact.getDangerType())
			setTheDanger(contact.getDangerType().getDangerName());
		
		setTheTitle(contact.getTitleType().getName());
		//setTheEmployment(contact.getEmploymentsTypeSet());
		setTheEmployment("Kim change databse need chagne code for this part");
		setTheCulturalBackground(contact.getCulturalBackground().getCulturalBackgroundName());
		setTheAccommodation(contact.getAccommodation().getAccommodationName());
		setTheStatus(enquiry.getStatusType().getStatusName());
		
		
		setInquisitor(enquiry.getInquisitor());
		setReferredBy(enquiry.getReferralBy());
		setReferredTo(enquiry.getReferralTo());
		
		activateLists();
		
		return SUCCESS;
	}
	
	/**
	 * Action method to Save/Update an enquiry form
	 * @return String
	 */
	public String saveUpdateEnquiry(){ 
		System.out.println("in save update");
		Enquiries newEnquiry = new Enquiries();
		Contacts newContact = new Contacts();
		
//		newEnquiry.setCreatedDateTime(getCreatedDate());
//		newEnquiry.setCreatedUserId(1);
//		newEnquiry.setUpdatedDateTime(getCreatedDate());
//		newEnquiry.setUpdatedUserId(1);
		
		newEnquiry.setDescription(getDescription());
		newEnquiry.setInquisitor(getInquisitor());
		
		newContact.setFirstname(contact.getFirstname());
		newContact.setLastname(contact.getLastname());
		
		services.saveOrUpdateNewEnquiry(newEnquiry, newContact);
		
		return SUCCESS;
	}

	/**
	 * Action method to return a list of enquiries
	 * @return String
	 */
	public String enquiryList(){
		setPage(1);
		setNumberOfRecords(10);
		
		setEnquiryList(services.findEnquiriesByPage(page,numberOfRecords));
		totalNumberOfRecords = services.countEnquiries();
		int mod = (int) totalNumberOfRecords % numberOfRecords;
		if(mod != 0) mod = 1;
		totalNumberOfPages = totalNumberOfRecords/numberOfRecords + mod;
		return SUCCESS;
	}
	
	/**
	 * Action Method to update the enquiry list after requesting a different page
	 * @return String
	 */
	public String updateEnquiryList(){
		System.out.println(getPage());
		
		setEnquiryList(services.findEnquiriesByPage(getPage(),getNumberOfRecords()));
		totalNumberOfRecords = services.countEnquiries();
		int mod = (int) totalNumberOfRecords % numberOfRecords;
		if(mod != 0) mod = 1;
		totalNumberOfPages = totalNumberOfRecords/numberOfRecords + mod;
		return SUCCESS;
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
	 * Other Methods & Setters and Getters
	 * ----------------------------------------------------------------------------------------------------------
	 * ----------------------------------------------------------------------------------------------------------*/

	/**
	 * populate the Select List variables
	 */
	private void activateLists(){
		titleSelectList=services.findTitleTypes();
		genderSelectList=services.findGenderTypes();
		culturalBackgroundSelectList=services.findCulturalBackgroundTypes();
		accommodationSelectList = services.findAccommodationTypes();
		disabilitySelectList = services.findDisabilityTypes();
		issueSelectList = services.findIssueTypes();
		dangerSelectList = services.findDangerTypes();
		//employmentSelectList = services.findEmploymentTypes();
		//setEmploymentList(contact.getEmploymentType());
		statusSelectList = services.findStatusTypes();
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
	

	public Enquiries getEnquiry(){
		return enquiry;
	}

	/**
	 * Setter for enquiry
	 * @param enquiry
	 */
	public void setEnquiry(Enquiries enquiry){
		this.enquiry = enquiry;
	}
	
	public Contacts getContact() {
		return contact;
	}

	public void setContact(Contacts contact) {
		this.contact = contact;
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

	public String getTheDanger() {
		return theDanger;
	}

	public void setTheDanger(String theDanger) {
		this.theDanger = theDanger;
	}

	public List<Enquiries> getEnquiryList() {
		return enquiryList;
	}

	public void setEnquiryList(List<Enquiries> enquiryList) {
		this.enquiryList = enquiryList;
	}

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

	

	/*------------------------------------------------Pagination Variables
	 * 
	 */

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

	public Set<Addresses> getAddress() {
		return addressSet;
	}

	public void setAddress(Set<Addresses> address) {
		this.addressSet = address;
	}

	public Set<ClientDisabilities> getClientDisabilitiesSet() {
		return clientDisabilitiesSet;
	}

	public void setClientDisabilitiesSet(Set<ClientDisabilities> clientDisabilitiesSet) {
		this.clientDisabilitiesSet = clientDisabilitiesSet;
	}

	/**
	 * Getter for careated Date
	 * @return Date
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	/**
	 * Getter for created by
	 * @return
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * Setter for the created by
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

	/**
	 * Getter for enquiry id
	 * @return
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Setter for enquiry id
	 * @param id
	 */
	private void setId(Integer id) {
		this.id = id;
	}

	/** Referrals **/
	/**
	 * Getter for inquisitor
	 * @return
	 */
	public String getInquisitor() {
		return inquisitor;
	}

	/**
	 * Setter for inquisitor
	 * @param inquisitor
	 */
	public void setInquisitor(String inquisitor) {
		this.inquisitor = inquisitor;
	}

	/**
	 * Getter for referred by
	 * @return String
	 */
	public String getReferredBy() {
		return referredBy;
	}

	/**
	 * Setter for referred by
	 * @param referredBy
	 */
	public void setReferredBy(String referredBy) {
		this.referredBy = referredBy;
	}

	/**
	 * Getter for referred to
	 * @return
	 */
	public String getReferredTo() {
		return referredTo;
	}

	/**
	 * Setter for referred to
	 * @param referredTo
	 */
	public void setReferredTo(String referredTo) {
		this.referredTo = referredTo;
	}

	/**
	 * Getter for page
	 * @return
	 */
	public int getPage() {
		return page;
	}



	/**
	 * Setter for Page
	 * @param page
	 */
	public void setPage(int page) {
		this.page = page;
	}



	/**
	 * Getter for the number of records for display
	 * @return
	 */
	public int getNumberOfRecords() {
		return numberOfRecords;
	}



	/**
	 * Setter for the number of records for display
	 * @param numberOfRecords
	 */
	public void setNumberOfRecords(int numberOfRecords) {
		this.numberOfRecords = numberOfRecords;
	}

	

	/**
	 * Getter for the total number of records
	 * @return
	 */
	public long getTotalNumberOfRecords() {
		return totalNumberOfRecords;
	}



	/**
	 * Setter for the total number of records
	 * @param totalNumberOfRecords
	 */
	public void setTotalNumberOfRecords(int totalNumberOfRecords) {
		this.totalNumberOfRecords = totalNumberOfRecords;
	}



	/**
	 * Getter for the total number of pages
	 * @return
	 */
	public long getTotalNumberOfPages() {
		return totalNumberOfPages;
	}


	/**
	 * Setter for the total number of records
	 * @param totalNumberOfPages
	 */
	public void setTotalNumberOfPages(int totalNumberOfPages) {
		this.totalNumberOfPages = totalNumberOfPages;
	}
}
