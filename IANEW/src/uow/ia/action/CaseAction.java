package uow.ia.action;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

import uow.ia.bean.AccommodationTypes;
import uow.ia.bean.Addresses;
import uow.ia.bean.ClientDisabilities;
import uow.ia.bean.CommunicationTypes;
import uow.ia.bean.Contacts;
import uow.ia.bean.CulturalBackgroundTypes;
import uow.ia.bean.DangerTypes;
import uow.ia.bean.DisabilityTypes;
import uow.ia.bean.EmploymentTypes;
import uow.ia.bean.GoalTypes;
import uow.ia.bean.IndividualCases;
import uow.ia.bean.CaseIssues;
import uow.ia.bean.GenderTypes;
import uow.ia.bean.IssueTypes;
import uow.ia.bean.StatusTypes;
import uow.ia.bean.TitleTypes;
import uow.ia.bean.PriorityTypes;

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



public class CaseAction extends BaseAction implements SessionAware, ModelDriven<IndividualCases>, Preparable{
	
	/* 
	 * form title (can either be new case/exisiting case/case list)
	 */
	private String formTitle;;
	private IndividualCases iamodel;
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
	//private List<IndividualCases> caseTypeSelectList;					private String theCaseType;
	private List<IssueTypes> issueSelectList;							private String theIssue;
	private List<EmploymentTypes> employmentSelectList;					private String theEmployment;
	private List<DangerTypes> dangerSelectList;							private String theDanger;
	private List<StatusTypes> statusSelectList;							private String theStatus;
	private List<Contacts> advocateSelectList;							private String theAdvocate;
	private List<PriorityTypes> prioritySelectList;						private String thePriority;	
	private List<CommunicationTypes> communicationSelectList;			private String theCommunication;
	private List<GoalTypes> goalSelectList;								private String theGoal;							
	
	/*
	 * Sets variables for 1 to many relationship tables
	 */
	private List<CaseIssues> issueSet;
	private List<IndividualCases> linkedCasesSet;
	private List<Addresses> addressSet;
	private List<ClientDisabilities> clientDisabilitiesSet;

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
	
	//private String profession, workPhone, employmentDescription, employmentComment;
	
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

		setCreatedDate(new Date());
		setUpdatedDate(new Date());
		setCreatedBy("Michael Hall");
		setUpdatedBy("Michael Hall");
		return SUCCESS;
	}

	/**
	 * Action Method
	 * @return
	 */
	public String getExistingCase(){
		//set(caseServices.getCase(getHiddenid()));
//		setContact(iamodel.getContact());
//		
//		setIssueSet(iamodel.getCaseIssuesList());
//		setClientDisabilities(contact.getDisabilitiesList());
//		setLinkedCasesSet(iamodel.getIndividualCasesList());
//		
//		//to be deleted
//		System.out.println(iamodel.getIndividualCasesList().toString());
//		for (IndividualCases c : linkedCasesSet) {
//			System.out.println("case linked: " + c.getId() + " " + c.getDescription() );
//		}
//		
//		//setCreatedBy(case.getCreatedUserId().get);
//		setCreatedDate(iamodel.getCreatedDateTime());
//		setUpdatedDate(iamodel.getUpdatedDateTime());
//		setId(iamodel.getId());
//		setDescription(iamodel.getDescription());
//		setAddress(contact.getAddressesList());
//		
//		setTheGender(contact.getGenderType().getGenderName());
//		setTheDanger(contact.getDangerType().getDangerName());
//		setTheTitle(contact.getTitleType().getName());
//		//setTheEmployment(contact.getEmploymentsTypeSet());
//		setTheEmployment("Kim change databse need chagne code for this part");
//		setTheCulturalBackground(contact.getCulturalBackground().getCulturalBackgroundName());
//		setTheAccommodation(contact.getAccommodation().getAccommodationName());
//		
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
		statusSelectList = services.findStatusTypes();
		employmentSelectList = caseServices.findEmploymentTypes();
		advocateSelectList = caseServices.findAdvocates();
		prioritySelectList = caseServices.findPriorityTypes();
		communicationSelectList = caseServices.findCommunicationTypes();
		goalSelectList = caseServices.findGoalTypes();
	}
	
	
	public void setStatusSelectList(List<StatusTypes> statusSelectList) {
		this.statusSelectList = statusSelectList;
		}
		public List<StatusTypes> getStatusSelectList() {
		return statusSelectList;
		}
		public void setTheStatus(String theStatus) {
		this.theStatus = theStatus;
		}
		public String getTheStatus() {
		return theStatus;
		}
	
	
	public void setPrioritySelectList(List<PriorityTypes> prioritySelectList) {
		this.prioritySelectList = prioritySelectList;
		}
		public List<PriorityTypes> getPrioritySelectList() {
		return prioritySelectList;
		}
		public void setThePriority(String thePriority) {
		this.thePriority = thePriority;
		}
		public String getThePriority() {
		return thePriority;
		}
		
		public void setCommunicationSelectList(List<CommunicationTypes> communicationSelectList) {
			this.communicationSelectList = communicationSelectList;
			}
			public List<CommunicationTypes> getCommunicationSelectList() {
			return communicationSelectList;
			}
			public void setTheCommunication(String theCommunication) {
			this.theCommunication = theCommunication;
			}
			public String getTheCommunication() {
			return theCommunication;
			}
			
			
			public void setGoalSelectList(List<GoalTypes> goalSelectList) {
				this.goalSelectList = goalSelectList;
				}
				public List<GoalTypes> getGoalSelectList() {
				return goalSelectList;
				}
				public void setTheGoal(String theGoal) {
				this.theGoal = theGoal;
				}
				public String getTheGoal() {
				return theGoal;
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
	

	public IndividualCases getIamodel(){
		return iamodel;
	}

	/**
	 * Setter for case
	 * @param case
	 */
	public void setIamodel(IndividualCases iamodel){
		this.iamodel = iamodel;
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

	public List<IndividualCases> getLinkedCasesSet() {
		return linkedCasesSet;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	/**
	 * Getter for advocate type
	 * @return List
	 */
	public List<Contacts> setAdvocateSelectList(List<Contacts> advocateSelectList) {
		return this.advocateSelectList = advocateSelectList;
	}
	
	public List<Contacts> getAdvocateSelectList() {
		return advocateSelectList;
	}

	public String getTheAdvocate() {
		return theAdvocate;
	}

	public void setTheAdvocate(String theAdvocate) {
		this.theAdvocate = theAdvocate;
	}
	/*------------------------------------------------Pagination Variables
	 * 
	 */

	public List<CaseIssues> getIssueSet() {
		return issueSet;
	}

	public void setIssueSet(List<CaseIssues> list) {
		this.issueSet = list;
	}

	public List<IndividualCases> getLinkedEquiriesSet() {
		return linkedCasesSet;
	}

	public void setLinkedCasesSet(List<IndividualCases> list) {
		this.linkedCasesSet = list;
	}

	public List<Addresses> getAddress() {
		return addressSet;
	}

	public void setAddress(List<Addresses> list) {
		this.addressSet = list;
	}

	public List<ClientDisabilities> getClientDisabilities() {
		return clientDisabilitiesSet;
	}

	public void setClientDisabilities(List<ClientDisabilities> list) {
		this.clientDisabilitiesSet = list;
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

	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Prepare start");
		System.out.println("hiddenid = " + getHiddenid());
		if (!((Integer) getHiddenid() == null || (Integer)getHiddenid() == 0)) {
			iamodel = caseServices.getCase(getHiddenid());
			activateLists();
		}
	}

	@Override
	public IndividualCases getModel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
