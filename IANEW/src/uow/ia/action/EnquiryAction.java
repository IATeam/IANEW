package uow.ia.action;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.sun.xml.rpc.processor.modeler.j2ee.xml.variableMappingType;

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
	private List<String> statusSelectList;								private String theStatus;
	

	/*
	 * Sets variables for 1 to many relationship tables
	 */
	private Set<EnquiryIssues> issueSet;
	private Set<Enquiries> linkedEnquiriesSet;
	private Set<Addresses> addressSet;
	private Set<ClientDisabilities> clientDisabilitiesSet;

	private Set<Enquiries> tmpSet;
	public Set<Enquiries> getTmpSet() {
		return tmpSet;
	}

	public void setTmpSet(Set<Enquiries> tmpSet) {
		this.tmpSet = tmpSet;
	}

	/*
	 * status variables
	 */
	private Date createdDate;
	private Date updatedDate;
	private String createdBy;
	private String updatedBy;
	private Integer id;
	
	/*
	 * Referral
	 */
	private String inquisitor;
	private String referredBy;
	private String referredTo;
	
	/*
	 * Employment
	 */
	
	private String profession;
	private String workPhone;
	private String employmentDescription;
	private String employmentComment;

	private String description;
	
	
	//vairiable used to get enqury id;
	int enquiryID;
	
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
		setEnquiry(services.getEnquiry(enquiryID));
		setContact(enquiry.getContact());
		
		setIssueSet(enquiry.getEnquiryIssuesSet());
		setClientDisabilities(contact.getDisabilitiesSet());
		setLinkedEnquiriesSet(enquiry.getEnquiriesSet());
		
		//to be deleted
		System.out.println(enquiry.getEnquiriesSet().toString());
		for (Enquiries e : linkedEnquiriesSet) {
			System.out.println("enquiry linked: " + e.getId() + " " + e.getDescription() );
		}
		
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
	
	
	public Set<Enquiries> getLinkedEnquiriesSet() {
		return linkedEnquiriesSet;
	}

	/**
	 * Action method
	 * @return
	 */
	public String enquiryList(){
		setPage(1);
		setNumberOfRecords(10);
		
		setEnquiryList(services.findEnquiriesByPage(page,numberOfRecords));
		totalNumberOfRecords = services.countEnquiries();
		totalNumberOfPages = totalNumberOfRecords/numberOfRecords;
		System.out.println(totalNumberOfPages);
		return SUCCESS;
	}
	
	
	/**
	 * Action Method for updating the enquiry list after requesting a different page
	 * @return
	 */
	public String updateEnquiryList(){
		enquiryList = services.findEnquiriesByPage(getPage(),getNumberOfRecords());
		totalNumberOfRecords = services.countEnquiries();
		totalNumberOfPages = totalNumberOfRecords/numberOfRecords;
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
	 * populate the Select List vairables
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

	/**
	 * Getter for employment types
	 * @return List
	 */
	public List<EmploymentTypes> getEmploymentSelectList() {
		return employmentSelectList;
	}

	public List<DangerTypes> getDangerSelectList() {
		return dangerSelectList;
	}

	/**
	 * Getter for enquiryID
	 * @return
	 */
	public int getEnquiryID() {
		return enquiryID;
	}

	/**
	 * Setter for enquiryID
	 * @param hidden
	 */
	public void setEnquiryID(int enquiryID) {
		this.enquiryID = enquiryID;
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
		return clientDisabilitiesSet;
	}

	public void setClientDisabilities(Set<ClientDisabilities> clientDisabilitiesSet) {
		this.clientDisabilitiesSet = clientDisabilitiesSet;
	}

	/*------------------------------------------------Pagination Variables
	 * 
	 */

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
		return addressSet;
	}

	public void setAddress(Set<Addresses> address) {
		this.addressSet = address;
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

	public List<Enquiries> getEnquiryList() {
		return enquiryList;
	}

	public void setEnquiryList(List<Enquiries> enquiryList) {
		this.enquiryList = enquiryList;
	}
	


	public Set<Enquiries> getLinkedEquiriesSet() {
		return linkedEnquiriesSet;
	}

	public void setLinkedEnquiriesSet(Set<Enquiries> linkedEnquiriesSet) {
		this.linkedEnquiriesSet = linkedEnquiriesSet;
	}

	
}
