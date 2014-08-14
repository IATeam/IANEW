package uow.ia.action;

import java.util.Date;
import java.util.List;
import java.util.Set;

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
import uow.ia.bean.TitleTypes;
import uow.ia.util.DateUtil;
/*
 * Created By Quang Nhan,
 * Editor: David Forbes, Quang Nhan
 * Creaed On: 14/7/14
 * Last Updated On: 9/8/14
 * Description: Action class for enquiries
 */


/**
 * @author Quang
 *
 */
public class EnquiryAction extends BaseAction{
	
	/* 
	 * form title (can either be new enquiry/exisiting enquiry/enquiry list)
	 */
	String formTitle;;
	
	
	
	Enquiries enquiry;
	Contacts contact; //not calling from enquiry to allow 'CASE' to share the same include jsp
	Set<Addresses> address;
	Set<ClientDisabilities> clientDisabilities;
	String description;
	/*
	 * status
	 */
	Date createdDate;
	Date updatedDate;
	String createdBy;
	String updatedBy;
	Integer id;
	
	List<DangerTypes> dangerSelectList;
	String theDanger;
	
	//drop down menu
	List<String> flagList; 			//Danger_Type table connected to Contacts table 
	List<String> status; 			//Status_Type or criteria control value table 
	
	
	List<Enquiries> enquiryList;
	
	/*
	 * Personal Details
	 */
	//List<String> title; 
	List<TitleTypes> titleSelectList; 
	String theTitle; 	//
	//List<String> gender; 
	List<GenderTypes> genderSelectList; 
	String theGender;	//
	//List<String> culturalBackground;
	List<CulturalBackgroundTypes> culturalBackgroundSelectList;
	String theCulturalBackground; //

	/*
	 * Address 
	 */
	//List<String> accomodation;
	List<AccommodationTypes> accommodationSelectList;
	String theAccommodation;
	String accommodationComments;

	/*
	 * Referral
	 */
	String inquisitor;
	String referredBy;
	String referredTo;
	
	/*
	 * Employment
	 */
	
	String profession;
	String workPhone;
	String employmentDescription;
	String employmentComment;

	List<DisabilityTypes> disabilitySelectList;
	String theDisability;
	
	List<IssueTypes> issueSelectList;
	String theIssue;

	int hidden;
	
	/* For pagination */
	int page;
	int numberOfRecords;
	long totalNumberOfRecords;
	long totalNumberOfPages;



	private Set<EnquiryIssues> issueSet;



	private Set<Enquiries> linkedEnquiries;



	private EmploymentTypes employmentList;
	private String theEmployment;
	
	
	public EmploymentTypes getEmploymentList() {
		return employmentList;
	}

	public void setEmploymentList(EmploymentTypes employmentList) {
		this.employmentList = employmentList;
	}

	public Set<Enquiries> getLinkedEquiries() {
		return linkedEnquiries;
	}

	public void setLinkedEnquiries(Set<Enquiries> linkedEnquiries) {
		this.linkedEnquiries = linkedEnquiries;
	}

	/**
	 * Action Method
	 * @return
	 */
	public String newEnquiry(){
		activateLists();
		return SUCCESS;
	}

	/**
	 * Action Method
	 * @return
	 */
	public String getExistingEnquiry(){
		//System.out.println("The hdiden field is : " + hidden);
		enquiry = services.getEnquiry(hidden);
		contact = enquiry.getContact();
		//System.out.println("first name " + enquiry.getContact().getFirstname());
		
		setIssueSet(enquiry.getEnquiryIssuesSet());
		//issueSet = enquiry.getEnquiryIssuesSet();
		clientDisabilities = contact.getDisabilitiesSet();
		setLinkedEnquiries(enquiry.getEnquiriesSet());
		System.out.println(enquiry.getEnquiriesSet().toString());
		//setCreatedBy(enquiry.getCreatedUserId().get);
		setCreatedDate(enquiry.getCreatedDateTime());
		setUpdatedDate(enquiry.getUpdatedDateTime());
		setId(enquiry.getId());
		setDescription(enquiry.getDescription());
		setAddress(contact.getAddressesSet());
		
		setTheGender(contact.getGenderType().getGenderName());
		setTheDanger(contact.getDangerType().getDangerName());
		setTheTitle(contact.getTitleType().getName());
		setTheEmployment(contact.getEmploymentType().getEmploymentName());
		setTheCulturalBackground(contact.getCulturalBackground().getCulturalBackgroundName());
		setTheAccommodation(contact.getAccommodation().getAccommodationName());
		
		setInquisitor(enquiry.getInquisitor());
		setReferredBy(enquiry.getReferralBy());
		setReferredTo(enquiry.getReferralTo());
		
		activateLists();
		
		
		return SUCCESS;
	}
	
	
	/**
	 * Action method
	 * @return
	 */
	public String enquiryList(){
		setPage(1);
		setNumberOfRecords(10);
		
		enquiryList = services.findEnquiriesByPage(page,numberOfRecords);
		totalNumberOfRecords = services.countEnquiries();
		totalNumberOfPages = totalNumberOfRecords/numberOfRecords;
		System.out.println(totalNumberOfPages);
		return SUCCESS;
	}
	
	
	/**
	 * Action Method
	 * @return
	 */
	public String updateEnquiryList(){
		System.out.println("updating page: " + getPage() + " number of Records: " + getNumberOfRecords());
		
		enquiryList = services.findEnquiriesByPage(getPage(),getNumberOfRecords());
		totalNumberOfRecords = services.countEnquiries();
		totalNumberOfPages = totalNumberOfRecords/numberOfRecords;
		return SUCCESS;
	}
	
	

	private void activateLists(){
		titleSelectList=services.findTitleTypes();
		genderSelectList=services.findGenderTypes();
		culturalBackgroundSelectList=services.findCulturalBackgroundTypes();
		accommodationSelectList = services.findAccommodationTypes();
		disabilitySelectList = services.findDisabilityTypes();
		issueSelectList = services.findIssueTypes();
		dangerSelectList = services.findDangerTypes();
		setEmploymentList(contact.getEmploymentType());
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

	public List<Enquiries> getEnquiryList() {
		return enquiryList;
	}

	public void setEnquiryList(List<Enquiries> enquiryList) {
		this.enquiryList = enquiryList;
	}

	public List<DangerTypes> getDangerSelectList() {
		return dangerSelectList;
	}

	public int getHidden() {
		return hidden;
	}

	/**
	 * @param hidden
	 */
	public void setHidden(int hidden) {
		this.hidden = hidden;
	}

	/**
	 * @param enquiry
	 */
	public void setEnquiry(Enquiries enquiry) {
		this.enquiry = enquiry;
	}

	public Enquiries getEnquiry(){
		return enquiry;
	}

	public Contacts getContact() {
		return contact;
	}

	public void setContact(Contacts contact) {
		this.contact = contact;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<ClientDisabilities> getClientDisabilities() {
		return clientDisabilities;
	}

	public void setClientDisabilities(Set<ClientDisabilities> clientDisabilities) {
		this.clientDisabilities = clientDisabilities;
	}

	/*------------------------------------------------Pagination Variables
	 * 
	 */

	public int getPage() {
		return page;
	}



	public void setPage(int page) {
		this.page = page;
	}



	public int getNumberOfRecords() {
		return numberOfRecords;
	}



	public void setNumberOfRecords(int numberOfRecords) {
		this.numberOfRecords = numberOfRecords;
	}

	

	public long getTotalNumberOfRecords() {
		return totalNumberOfRecords;
	}



	public void setTotalNumberOfRecords(int totalNumberOfRecords) {
		this.totalNumberOfRecords = totalNumberOfRecords;
	}



	public long getTotalNumberOfPages() {
		return totalNumberOfPages;
	}



	public void setTotalNumberOfPages(int totalNumberOfPages) {
		this.totalNumberOfPages = totalNumberOfPages;
	}



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



	public String getCreatedBy() {
		return createdBy;
	}



	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}



	public String getUpdatedBy() {
		return updatedBy;
	}



	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}



	public Integer getId() {
		return id;
	}



	private void setId(Integer id) {
		this.id = id;
	}

	public Set<Addresses> getAddress() {
		return address;
	}

	public void setAddress(Set<Addresses> address) {
		this.address = address;
	}
	
	public Set<EnquiryIssues> getIssueSet() {
		return issueSet;
	}

	public void setIssueSet(Set<EnquiryIssues> issueSet) {
		this.issueSet = issueSet;
	}

	/** Referrals **/
	public String getInquisitor() {
		return inquisitor;
	}

	public void setInquisitor(String inquisitor) {
		this.inquisitor = inquisitor;
	}

	public String getReferredBy() {
		return referredBy;
	}

	public void setReferredBy(String referredBy) {
		this.referredBy = referredBy;
	}

	public String getReferredTo() {
		return referredTo;
	}

	public void setReferredTo(String referredTo) {
		this.referredTo = referredTo;
	}

	public String getTheDanger() {
		return theDanger;
	}

	public void setTheDanger(String theDanger) {
		this.theDanger = theDanger;
	}

	public String getTheTitle() {
		return theTitle;
	}

	public void setTheTitle(String theTitle) {
		this.theTitle = theTitle;
	}

	public String getTheGender() {
		return theGender;
	}

	public void setTheGender(String string) {
		this.theGender = string;
	}

	public String getTheDisability() {
		return theDisability;
	}

	public void setTheDisability(String theDisability) {
		this.theDisability = theDisability;
	}

	public String getTheIssue() {
		return theIssue;
	}

	public void setTheIssue(String theIssue) {
		this.theIssue = theIssue;
	}

	public String getTheEmployment() {
		return theEmployment;
	}

	public void setTheEmployment(String theEmployment) {
		this.theEmployment = theEmployment;
	}

	public String getTheCulturalBackground() {
		return theCulturalBackground;
	}

	public void setTheCulturalBackground(String theCulturalBackground) {
		this.theCulturalBackground = theCulturalBackground;
	}

	public String getTheAccommodation() {
		return theAccommodation;
	}

	public void setTheAccommodation(String theAccommodation) {
		this.theAccommodation = theAccommodation;
	}
	
	
	
}
