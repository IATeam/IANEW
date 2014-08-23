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
import uow.ia.bean.IndividualCases;
import uow.ia.bean.CaseIssues;
import uow.ia.bean.GenderTypes;
import uow.ia.bean.IssueTypes;
import uow.ia.bean.TitleTypes;

/** ---------------------------------------------------------------------------------------------
 * @author: Quang Nhan
 * Created Date: 27/07/2014
 * ==============================================
 * Updates:
 * 12/08/2014 - 	Quang Nhan
 * 					Migrate code into new project setup
 * 14/08/2014 	- 	Quang Nhan
 * 					Connect and retrieve data from service class to case, caselist jsps and a
 * 					dded pagination functionality
 * 16/08/2014 -	Quang Nhan
 * 					Refactor the code
 * ==============================================
 * 	Description: An action class to linking the service from spring to the case jsp pages
 *
 *----------------------------------------------------------------------------------------------*/



public class CaseAction extends BaseAction{
	
	/* 
	 * form title (can either be new case/exisiting case/case list)
	 */
	private String formTitle;;
	private IndividualCases iCase;
	private Contacts contact; //not calling from case to allow 'CASE' to share the same include jsp
	
	/*
	 * Lists for the drop down select options for the jsps
	 * and its associated value variables
	 */
	private List<TitleTypes> titleSelectList; 							private String theTitle;
	private List<GenderTypes> genderSelectList; 						private String theGender;
	private List<CulturalBackgroundTypes> culturalBackgroundSelectList;	private String theCulturalBackground;
	private List<AccommodationTypes> accommodationSelectList;			private String theAccommodation;
	private List<DisabilityTypes> disabilitySelectList;					private String theDisability;
	private List<IndividualCases> caseTypeSelectList;					private String theCaseType;
	private List<IssueTypes> issueSelectList;							private String theIssue;
	private List<EmploymentTypes> employmentSelectList;					private String theEmployment;
	private List<DangerTypes> dangerSelectList;							private String theDanger;
	//Status_Type or criteria control value table 
	private List<String> statusSelectList;								private String theStatus;
	

	/*
	 * Sets variables for 1 to many relationship tables
	 */
	private Set<CaseIssues> issueSet;
	private Set<IndividualCases> linkedCasesSet;
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
	
	
	//vairiable used to get case id;
	int hiddenid;
	
	public int getHiddenid() {
		return hiddenid;
	}

	public void setHiddenid(int hiddenid) {
		this.hiddenid = hiddenid;
	}

	/* For pagination */
	private List<IndividualCases> caseList;
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
	public String newCase(){
		activateLists();
		return SUCCESS;
	}

	/**
	 * Action Method
	 * @return
	 */
	public String getExistingCase(){
		setCase(caseServices.getCase(getHiddenid()));
		setContact(iCase.getContact());
		
		setIssueSet(iCase.getCaseIssuesSet());
		setClientDisabilities(contact.getDisabilitiesSet());
		setLinkedCasesSet(iCase.getIndividualCasesSet());
		
		//to be deleted
		System.out.println(iCase.getIndividualCasesSet().toString());
		for (IndividualCases c : linkedCasesSet) {
			System.out.println("case linked: " + c.getId() + " " + c.getDescription() );
		}
		
		//setCreatedBy(case.getCreatedUserId().get);
		setCreatedDate(iCase.getCreatedDateTime());
		setUpdatedDate(iCase.getUpdatedDateTime());
		setId(iCase.getId());
		setDescription(iCase.getDescription());
		setAddress(contact.getAddressesSet());
		
		setTheGender(contact.getGenderType().getGenderName());
		setTheDanger(contact.getDangerType().getDangerName());
		setTheTitle(contact.getTitleType().getName());
		//setTheEmployment(contact.getEmploymentsTypeSet());
		setTheEmployment("Kim change databse need chagne code for this part");
		setTheCulturalBackground(contact.getCulturalBackground().getCulturalBackgroundName());
		setTheAccommodation(contact.getAccommodation().getAccommodationName());
		
		activateLists();
		
		return SUCCESS;
	}
	

	/**
	 * Action method
	 * @return
	 */
	public String caseList(){
		setPage(1);
		setNumberOfRecords(10);
		
		setCaseList(caseServices.findCasesByPage(page,numberOfRecords));
		totalNumberOfRecords = caseServices.countCases();
		totalNumberOfPages = totalNumberOfRecords/numberOfRecords;
		System.out.println(totalNumberOfPages);
		return SUCCESS;
	}
	
	
	/**
	 * Action Method for updating the case list after requesting a different page
	 * @return
	 */
	public String updateCaseList(){
		caseList = caseServices.findCasesByPage(getPage(),getNumberOfRecords());
		totalNumberOfRecords = caseServices.countCases();
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
		titleSelectList=caseServices.findTitleTypes();
		genderSelectList=caseServices.findGenderTypes();
		culturalBackgroundSelectList=caseServices.findCulturalBackgroundTypes();
		accommodationSelectList = caseServices.findAccommodationTypes();
		disabilitySelectList = caseServices.findDisabilityTypes();
		issueSelectList = caseServices.findIssueTypes();
		dangerSelectList = caseServices.findDangerTypes();
		//employmentSelectList = caseServices.findEmploymentTypes();
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
	

	public IndividualCases getCase(){
		return iCase;
	}

	/**
	 * Setter for case
	 * @param case
	 */
	public void setCase(IndividualCases iCase){
		this.iCase = iCase;
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

	public List<IndividualCases> getCaseList() {
		return caseList;
	}

	public void setCaseList(List<IndividualCases> caseList) {
		this.caseList = caseList;
	}

	public Set<IndividualCases> getLinkedCasesSet() {
		return linkedCasesSet;
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

	public Set<CaseIssues> getIssueSet() {
		return issueSet;
	}

	public void setIssueSet(Set<CaseIssues> issueSet) {
		this.issueSet = issueSet;
	}

	public Set<IndividualCases> getLinkedEquiriesSet() {
		return linkedCasesSet;
	}

	public void setLinkedCasesSet(Set<IndividualCases> linkedCasesSet) {
		this.linkedCasesSet = linkedCasesSet;
	}

	public Set<Addresses> getAddress() {
		return addressSet;
	}

	public void setAddress(Set<Addresses> address) {
		this.addressSet = address;
	}

	public Set<ClientDisabilities> getClientDisabilities() {
		return clientDisabilitiesSet;
	}

	public void setClientDisabilities(Set<ClientDisabilities> clientDisabilitiesSet) {
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
	 * Getter for case id
	 * @return
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Setter for case id
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