package uow.ia.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.sun.org.apache.xml.internal.security.keys.content.PGPData;

import uow.ia.bean.AccommodationTypes;
import uow.ia.bean.Addresses;
import uow.ia.bean.ClientDisabilities;
import uow.ia.bean.CommunicationTypes;
import uow.ia.bean.ContactEmployments;
import uow.ia.bean.Contacts;
import uow.ia.bean.CulturalBackgroundTypes;
import uow.ia.bean.DangerTypes;
import uow.ia.bean.DisabilityTypes;
import uow.ia.bean.EmploymentTypes;
import uow.ia.bean.GoalTypes;
import uow.ia.bean.IndividualCaseCommunications;
import uow.ia.bean.IndividualCases;
import uow.ia.bean.CaseIssues;
import uow.ia.bean.GenderTypes;
import uow.ia.bean.IssueTypes;
import uow.ia.bean.PlanDevelopers;
import uow.ia.bean.PlanGoals;
import uow.ia.bean.ReviewFrequencies;
import uow.ia.bean.StatusTypes;
import uow.ia.bean.TitleTypes;
import uow.ia.bean.PriorityTypes;
import uow.ia.bean.Users;

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
	
	private String formTitle;;
	private IndividualCases iamodel;
	private Contacts contact; //not calling from case to allow 'CASE' to share the same include jsp
	
	/**
	 * List of typs for drop down selection box
	 */
	private List<TitleTypes> titleSelectList = new ArrayList<TitleTypes>(); 							
	private List<GenderTypes> genderSelectList = new ArrayList<GenderTypes>(); 						
	private List<CulturalBackgroundTypes> culturalBackgroundSelectList = new ArrayList<CulturalBackgroundTypes>();	
	private List<AccommodationTypes> accommodationSelectList = new ArrayList<AccommodationTypes>();			
	private List<DisabilityTypes> disabilitySelectList = new ArrayList<DisabilityTypes>();	
	private List<IssueTypes> issueSelectList = new ArrayList<IssueTypes>();					
	private List<EmploymentTypes> employmentSelectList = new ArrayList<EmploymentTypes>();
	private List<DangerTypes> dangerSelectList = new ArrayList<DangerTypes>();					
	private List<StatusTypes> statusSelectList = new ArrayList<StatusTypes>();								
	private List<Contacts> advocateSelectList = new ArrayList<Contacts>();
	private List<PriorityTypes> prioritySelectList = new ArrayList<PriorityTypes>();
	private List<CommunicationTypes> communicationSelectList = new ArrayList<CommunicationTypes>();	
	private List<GoalTypes> goalSelectList = new ArrayList<GoalTypes>();	
	private List<ReviewFrequencies> reviewFrequencyList = new ArrayList<ReviewFrequencies>();
	private List<Contacts> developerSelectList = new ArrayList<Contacts>();
	
	/**
	 * Lists of selected type ids
	 */
	private List<Integer> theDisabilityListId = new ArrayList<Integer>();						
	private List<Integer> theIssueListId = new ArrayList<Integer>();				
	private List<Integer> theEmploymentListId = new ArrayList<Integer>();			
	private List<Integer> theCommunicationsList = new ArrayList<Integer>();	
	private List<Integer> theGoalList = new ArrayList<Integer>();
	
	
	private String theReviewFrequencyString;
	String dob;
	private int theTitleTypeId; 							
	private int theGenderTypeId;
	private int theCulturalBackgroundTypeId;
	private int theAccommodationTypeId;
	private int theDangerTypeId;
	private int theStatusTypeId;							
	private int theAdvocate;						
	private int thePriority;	
	
	
	/**
	 * @return the formTitle
	 */
	public String getFormTitle() {
		return formTitle;
	}

	/**
	 * @param formTitle the formTitle to set
	 */
	public void setFormTitle(String formTitle) {
		this.formTitle = formTitle;
	}

	/**
	 * @return the iamodel
	 */
	public IndividualCases getIamodel() {
		return iamodel;
	}

	/**
	 * @param iamodel the iamodel to set
	 */
	public void setIamodel(IndividualCases iamodel) {
		this.iamodel = iamodel;
	}

	/**
	 * @return the contact
	 */
	public Contacts getContact() {
		return contact;
	}

	/**
	 * @param contact the contact to set
	 */
	public void setContact(Contacts contact) {
		this.contact = contact;
	}

	/**
	 * @return the statusSelectList
	 */
	public List<StatusTypes> getStatusSelectList() {
		return statusSelectList;
	}

	/**
	 * @param statusSelectList the statusSelectList to set
	 */
	public void setStatusSelectList(List<StatusTypes> statusSelectList) {
		this.statusSelectList = statusSelectList;
	}

	/**
	 * @return the advocateSelectList
	 */
	public List<Contacts> getAdvocateSelectList() {
		return advocateSelectList;
	}

	/**
	 * @param advocateSelectList the advocateSelectList to set
	 */
	public void setAdvocateSelectList(List<Contacts> advocateSelectList) {
		this.advocateSelectList = advocateSelectList;
	}

	/**
	 * @return the prioritySelectList
	 */
	public List<PriorityTypes> getPrioritySelectList() {
		return prioritySelectList;
	}

	/**
	 * @param prioritySelectList the prioritySelectList to set
	 */
	public void setPrioritySelectList(List<PriorityTypes> prioritySelectList) {
		this.prioritySelectList = prioritySelectList;
	}

	/**
	 * @return the communicationSelectList
	 */
	public List<CommunicationTypes> getCommunicationSelectList() {
		return communicationSelectList;
	}

	/**
	 * @param communicationSelectList the communicationSelectList to set
	 */
	public void setCommunicationSelectList(
			List<CommunicationTypes> communicationSelectList) {
		this.communicationSelectList = communicationSelectList;
	}

	/**
	 * @return the goalSelectList
	 */
	public List<GoalTypes> getGoalSelectList() {
		return goalSelectList;
	}

	/**
	 * @param goalSelectList the goalSelectList to set
	 */
	public void setGoalSelectList(List<GoalTypes> goalSelectList) {
		this.goalSelectList = goalSelectList;
	}

	/**
	 * @return the theDisabilityListId
	 */
	public List<Integer> getTheDisabilityListId() {
		return theDisabilityListId;
	}

	/**
	 * @param theDisabilityListId the theDisabilityListId to set
	 */
	public void setTheDisabilityListId(List<Integer> theDisabilityListId) {
		this.theDisabilityListId = theDisabilityListId;
	}

	/**
	 * @return the theIssueListId
	 */
	public List<Integer> getTheIssueListId() {
		return theIssueListId;
	}

	/**
	 * @param theIssueListId the theIssueListId to set
	 */
	public void setTheIssueListId(List<Integer> theIssueListId) {
		this.theIssueListId = theIssueListId;
	}

	/**
	 * @return the theCommunicationsList
	 */
	public List<Integer> getTheCommunicationsList() {
		return theCommunicationsList;
	}

	/**
	 * @param theCommunicationsList the theCommunicationsList to set
	 */
	public void setTheCommunicationsList(List<Integer> theCommunicationsList) {
		this.theCommunicationsList = theCommunicationsList;
	}

	/**
	 * @return the theGoalList
	 */
	public List<Integer> getTheGoalList() {
		return theGoalList;
	}

	/**
	 * @param theGoalList the theGoalList to set
	 */
	public void setTheGoalList(List<Integer> theGoalList) {
		this.theGoalList = theGoalList;
	}

	/**
	 * @return the theAdvocate
	 */
	public int getTheAdvocate() {
		return theAdvocate;
	}

	/**
	 * @param theAdvocate the theAdvocate to set
	 */
	public void setTheAdvocate(int theAdvocate) {
		this.theAdvocate = theAdvocate;
	}

	/**
	 * @return the thePriority
	 */
	public int getThePriority() {
		return thePriority;
	}

	/**
	 * @param thePriority the thePriority to set
	 */
	public void setThePriority(int thePriority) {
		this.thePriority = thePriority;
	}

	/**
	 * @return the issueSet
	 */
	public List<CaseIssues> getIssueSet() {
		return issueSet;
	}

	/**
	 * @param issueSet the issueSet to set
	 */
	public void setIssueSet(List<CaseIssues> issueSet) {
		this.issueSet = issueSet;
	}

	/**
	 * @return the linkedCasesSet
	 */
	public List<IndividualCases> getLinkedCasesSet() {
		return linkedCasesSet;
	}

	/**
	 * @param linkedCasesSet the linkedCasesSet to set
	 */
	public void setLinkedCasesSet(List<IndividualCases> linkedCasesSet) {
		this.linkedCasesSet = linkedCasesSet;
	}

	/**
	 * @return the createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return the updatedDate
	 */
	public Date getUpdatedDate() {
		return updatedDate;
	}

	/**
	 * @param updatedDate the updatedDate to set
	 */
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the updatedBy
	 */
	public String getUpdatedBy() {
		return updatedBy;
	}

	/**
	 * @param updatedBy the updatedBy to set
	 */
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the inquisitor
	 */
	public String getInquisitor() {
		return inquisitor;
	}

	/**
	 * @param inquisitor the inquisitor to set
	 */
	public void setInquisitor(String inquisitor) {
		this.inquisitor = inquisitor;
	}

	/**
	 * @return the referredBy
	 */
	public String getReferredBy() {
		return referredBy;
	}

	/**
	 * @param referredBy the referredBy to set
	 */
	public void setReferredBy(String referredBy) {
		this.referredBy = referredBy;
	}

	/**
	 * @return the referredTo
	 */
	public String getReferredTo() {
		return referredTo;
	}

	/**
	 * @param referredTo the referredTo to set
	 */
	public void setReferredTo(String referredTo) {
		this.referredTo = referredTo;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the caseList
	 */
	public List<IndividualCases> getCaseList() {
		return caseList;
	}

	/**
	 * @param caseList the caseList to set
	 */
	public void setCaseList(List<IndividualCases> caseList) {
		this.caseList = caseList;
	}

	/**
	 * @return the page
	 */
	public int getPage() {
		return page;
	}

	/**
	 * @param page the page to set
	 */
	public void setPage(int page) {
		this.page = page;
	}

	/**
	 * @return the numberOfRecords
	 */
	public int getNumberOfRecords() {
		return numberOfRecords;
	}

	/**
	 * @param numberOfRecords the numberOfRecords to set
	 */
	public void setNumberOfRecords(int numberOfRecords) {
		this.numberOfRecords = numberOfRecords;
	}

	/**
	 * @return the titleSelectList
	 */
	public List<TitleTypes> getTitleSelectList() {
		return titleSelectList;
	}

	/**
	 * @return the genderSelectList
	 */
	public List<GenderTypes> getGenderSelectList() {
		return genderSelectList;
	}

	/**
	 * @return the culturalBackgroundSelectList
	 */
	public List<CulturalBackgroundTypes> getCulturalBackgroundSelectList() {
		return culturalBackgroundSelectList;
	}

	/**
	 * @return the disabilitySelectList
	 */
	public List<DisabilityTypes> getDisabilitySelectList() {
		return disabilitySelectList;
	}

	/**
	 * @return the issueSelectList
	 */
	public List<IssueTypes> getIssueSelectList() {
		return issueSelectList;
	}

	/**
	 * @return the employmentSelectList
	 */
	public List<EmploymentTypes> getEmploymentSelectList() {
		return employmentSelectList;
	}

	/**
	 * @return the dangerSelectList
	 */
	public List<DangerTypes> getDangerSelectList() {
		return dangerSelectList;
	}

	/**
	 * @return the totalNumberOfRecords
	 */
	public long getTotalNumberOfRecords() {
		return totalNumberOfRecords;
	}

	/**
	 * @return the totalNumberOfPages
	 */
	public long getTotalNumberOfPages() {
		return totalNumberOfPages;
	}

	/**
	 * @return the theTitleTypeId
	 */
	public int getTheTitleTypeId() {
		return theTitleTypeId;
	}

	/**
	 * @param theTitleTypeId the theTitleTypeId to set
	 */
	public void setTheTitleTypeId(int theTitleTypeId) {
		this.theTitleTypeId = theTitleTypeId;
	}

	/**
	 * @return the theGenderTypeId
	 */
	public int getTheGenderTypeId() {
		return theGenderTypeId;
	}

	/**
	 * @param theGenderTypeId the theGenderTypeId to set
	 */
	public void setTheGenderTypeId(int theGenderTypeId) {
		this.theGenderTypeId = theGenderTypeId;
	}

	/**
	 * @return the theCulturalBackgroundTypeId
	 */
	public int getTheCulturalBackgroundTypeId() {
		return theCulturalBackgroundTypeId;
	}

	/**
	 * @param theCulturalBackgroundTypeId the theCulturalBackgroundTypeId to set
	 */
	public void setTheCulturalBackgroundTypeId(int theCulturalBackgroundTypeId) {
		this.theCulturalBackgroundTypeId = theCulturalBackgroundTypeId;
	}

	/**
	 * @return the theAccommodationTypeId
	 */
	public int getTheAccommodationTypeId() {
		return theAccommodationTypeId;
	}

	/**
	 * @param theAccommodationTypeId the theAccommodationTypeId to set
	 */
	public void setTheAccommodationTypeId(int theAccommodationTypeId) {
		this.theAccommodationTypeId = theAccommodationTypeId;
	}

	/**
	 * @return the theDangerTypeId
	 */
	public int getTheDangerTypeId() {
		return theDangerTypeId;
	}

	/**
	 * @param theDangerTypeId the theDangerTypeId to set
	 */
	public void setTheDangerTypeId(int theDangerTypeId) {
		this.theDangerTypeId = theDangerTypeId;
	}

	/**
	 * @return the theStatusTypeId
	 */
	public int getTheStatusTypeId() {
		return theStatusTypeId;
	}

	/**
	 * @param theStatusTypeId the theStatusTypeId to set
	 */
	public void setTheStatusTypeId(int theStatusTypeId) {
		this.theStatusTypeId = theStatusTypeId;
	}

	/**
	 * @return the userSession
	 */
	public Map<String, Object> getUserSession() {
		return userSession;
	}

	/**
	 * @param userSession the userSession to set
	 */
	public void setUserSession(Map<String, Object> userSession) {
		this.userSession = userSession;
	}
	
	/**
	 * @return the developerSelectList
	 */
	public List<Contacts> getDeveloperSelectList() {
		return developerSelectList;
	}

	/**
	 * @param developerSelectList the developerSelectList to set
	 */
	public void setDeveloperSelectList(List<Contacts> developerSelectList) {
		this.developerSelectList = developerSelectList;
	}

	/**
	 * @return the theReviewFrequencyString
	 */
	public String getTheReviewFrequencyString() {
		return theReviewFrequencyString;
	}

	/**
	 * @param theReviewFrequencyString the theReviewFrequencyString to set
	 */
	public void setTheReviewFrequencyString(String theReviewFrequencyString) {
		this.theReviewFrequencyString = theReviewFrequencyString;
	}

	/**
	 * @return the accommodationSelectList
	 */
	public List<AccommodationTypes> getAccommodationSelectList() {
		return accommodationSelectList;
	}

	/**
	 * @param accommodationSelectList the accommodationSelectList to set
	 */
	public void setAccommodationSelectList(
			List<AccommodationTypes> accommodationSelectList) {
		this.accommodationSelectList = accommodationSelectList;
	}

	/**
	 * @return the reviewFrequencyList
	 */
	public List<ReviewFrequencies> getReviewFrequencyList() {
		return reviewFrequencyList;
	}

	/**
	 * @param reviewFrequencyList the reviewFrequencyList to set
	 */
	public void setReviewFrequencyList(List<ReviewFrequencies> reviewFrequencyList) {
		this.reviewFrequencyList = reviewFrequencyList;
	}

	/**
	 * @return the addressSet
	 */
	public List<Addresses> getAddressSet() {
		return addressSet;
	}

	/**
	 * @param addressSet the addressSet to set
	 */
	public void setAddressSet(List<Addresses> addressSet) {
		this.addressSet = addressSet;
	}

	/**
	 * @return the clientDisabilitiesSet
	 */
	public List<ClientDisabilities> getClientDisabilitiesSet() {
		return clientDisabilitiesSet;
	}

	/**
	 * @param clientDisabilitiesSet the clientDisabilitiesSet to set
	 */
	public void setClientDisabilitiesSet(
			List<ClientDisabilities> clientDisabilitiesSet) {
		this.clientDisabilitiesSet = clientDisabilitiesSet;
	}

	/**
	 * @param titleSelectList the titleSelectList to set
	 */
	public void setTitleSelectList(List<TitleTypes> titleSelectList) {
		this.titleSelectList = titleSelectList;
	}

	/**
	 * @param genderSelectList the genderSelectList to set
	 */
	public void setGenderSelectList(List<GenderTypes> genderSelectList) {
		this.genderSelectList = genderSelectList;
	}

	/**
	 * @param culturalBackgroundSelectList the culturalBackgroundSelectList to set
	 */
	public void setCulturalBackgroundSelectList(
			List<CulturalBackgroundTypes> culturalBackgroundSelectList) {
		this.culturalBackgroundSelectList = culturalBackgroundSelectList;
	}

	/**
	 * @param disabilitySelectList the disabilitySelectList to set
	 */
	public void setDisabilitySelectList(List<DisabilityTypes> disabilitySelectList) {
		this.disabilitySelectList = disabilitySelectList;
	}

	/**
	 * @param issueSelectList the issueSelectList to set
	 */
	public void setIssueSelectList(List<IssueTypes> issueSelectList) {
		this.issueSelectList = issueSelectList;
	}

	/**
	 * @param employmentSelectList the employmentSelectList to set
	 */
	public void setEmploymentSelectList(List<EmploymentTypes> employmentSelectList) {
		this.employmentSelectList = employmentSelectList;
	}

	/**
	 * @param dangerSelectList the dangerSelectList to set
	 */
	public void setDangerSelectList(List<DangerTypes> dangerSelectList) {
		this.dangerSelectList = dangerSelectList;
	}

	/**
	 * @param totalNumberOfRecords the totalNumberOfRecords to set
	 */
	public void setTotalNumberOfRecords(long totalNumberOfRecords) {
		this.totalNumberOfRecords = totalNumberOfRecords;
	}

	/**
	 * @param totalNumberOfPages the totalNumberOfPages to set
	 */
	public void setTotalNumberOfPages(long totalNumberOfPages) {
		this.totalNumberOfPages = totalNumberOfPages;
	}

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
		System.out.println("Set stuffs");
		System.out.println("no");
		if (iamodel.getContact() != null) {
			if (iamodel.getContact().getAccommodation() != null) {
				setTheAccommodationTypeId(iamodel.getContact().getAccommodation().getId());
			}
			
			if (iamodel.getContact().getCulturalBackground() != null) {
				setTheCulturalBackgroundTypeId(iamodel.getContact().getCulturalBackground().getId());
			}
			
			if (iamodel.getContact().getDangerType() != null) {
				setTheDangerTypeId(iamodel.getContact().getDangerType().getId());
			}
			
			if (iamodel.getContact().getGenderType() != null) {
				setTheGenderTypeId(iamodel.getContact().getDangerType().getId());
			}
			
			if (iamodel.getStatusType() != null) {
				//setTheStatusTypeId(iamodel.getStatusType().getId());
				theStatusTypeId = iamodel.getStatusType().getId();
				System.out.println("status=" + theStatusTypeId);
			}
			
			if (iamodel.getContact().getTitleType() != null) {
				setTheTitleTypeId(iamodel.getContact().getTitleType().getId());
			}
			
			if (iamodel.getAdvocate() != null) {
				theAdvocate = iamodel.getAdvocate().getId();
			}
			
			//theAdvocate = iamodel.getAdvocate().getLastname() + ", " + iamodel.getAdvocate().getFirstname();
			
			List<PlanGoals> planGoalsDB = getIamodel().getPlanGoalsList();
			for (PlanGoals pg : planGoalsDB){
				try {
					theGoalList.add(pg.getGoalType().getId());
				} catch (NullPointerException e) {
					theGoalList.add(new Integer(-1));
				}
			}
			
			List<CaseIssues> caseIssuesDB = getIamodel().getCaseIssuesList();
			for (CaseIssues ci : caseIssuesDB) {
				try {
					theIssueListId.add(ci.getIssue().getId());
				} catch(NullPointerException e) {
					theIssueListId.add(new Integer(-1));
				}
			}
			
			List<IndividualCaseCommunications> communicationListDBCaseCommunications = getIamodel().getCommunicationsList();
			for(IndividualCaseCommunications icc : communicationListDBCaseCommunications) {
				try {
					theCommunicationsList.add(icc.getCommunicationType().getId());
				} catch(NullPointerException e) {
					theCommunicationsList.add(new Integer(-1));
				}
			}
			
			List<ClientDisabilities> disabilityDB = getIamodel().getContact().getDisabilitiesList();
			for (ClientDisabilities cd : disabilityDB) {
				try {
					theDisabilityListId.add(cd.getDisabilityType().getId());
				} catch(NullPointerException e) {
					theDisabilityListId.add(new Integer(-1));
				}
			}
			
			List<ContactEmployments> employmentsDB = getIamodel().getContact().getEmploymentsList();
			for (ContactEmployments ce : employmentsDB) {
				try {
					theEmploymentListId.add(ce.getEmploymentType().getId());
				} catch(NullPointerException e) {
					theEmploymentListId.add(new Integer(-1));
				}
			} 
			
			
		}
		return SUCCESS;
	}
	

	/**
	 * @return the dob
	 */
	public String getDob() {
		return dob;
	}

	/**
	 * @param dob the dob to set
	 */
	public void setDob(String dob) {
		this.dob = dob;
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
	private Map <String, Object> userSession;
	public String saveUpdateCase(){
		System.out.println("Start Saving Case");
		
		Users user = (Users) userSession.get(USER);
		List<Addresses> al = iamodel.getContact().getAddressesList();
		
		System.out.println("checking address");
		for (int i = 0; i < al.size(); i++) {
			if (al.get(i).getId() == null){
				al.get(i).setContact(iamodel.getContact());
			} else if (al.get(i).getId() == -1) {
				System.out.println("Remove a false address");
				iamodel.getContact().getAddressesList().remove(i);
				i--;
			}
		}
		
		System.out.println("checking client disability");
		List<ClientDisabilities> cdl = iamodel.getContact().getDisabilitiesList();
		if (getTheDisabilityListId().size() > 0) {
			for(int i = 0; i < theDisabilityListId.size(); i++){
				if(getTheDisabilityListId().get(i) != -1){
					cdl.get(i).setDisabilityType(typesService.getDisabilityTypeId(getTheDisabilityListId().get(i)));
				}
		
				if(cdl.get(i).getId() == null){
					cdl.get(i).setContact(iamodel.getContact());
					cdl.get(i).setCreatedUser(user.getContact());
					cdl.get(i).setUpdatedUser(user.getContact());
					
				} else {
					cdl.get(i).setUpdatedUser(user.getContact());
				}
			}
		}
		
		System.out.println("Contact employments");
		List<ContactEmployments> cel = iamodel.getContact().getEmploymentsList();
		if (getTheEmploymentListId().size() > 0) {
			for(int i = 0; i < theEmploymentListId.size(); i++){
				if(getTheEmploymentListId().get(i) != -1)
					cel.get(i).setEmploymentType(typesService.getEmploymentTypeId(getTheEmploymentListId().get(i)));
		
				if(cel.get(i).getId() == null){
					cel.get(i).setContact(iamodel.getContact());
					cel.get(i).setCreatedUser(user.getContact());
					cel.get(i).setUpdatedUser(user.getContact());
					
				} else {
					cel.get(i).setUpdatedUser(user.getContact());
				}
			}
		}
		
		System.out.println("End Saving Case");
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
	 * @return the theEmploymentListId
	 */
	public List<Integer> getTheEmploymentListId() {
		return theEmploymentListId;
	}

	/**
	 * @param theEmploymentListId the theEmploymentListId to set
	 */
	public void setTheEmploymentListId(List<Integer> theEmploymentListId) {
		this.theEmploymentListId = theEmploymentListId;
	}

	/**
	 * populate the Select List vairables
	 */
	private void activateLists(){
		titleSelectList=typesService.findTitleTypes();
		genderSelectList=typesService.findGenderTypes();
		culturalBackgroundSelectList=typesService.findCulturalBackgroundTypes();
		accommodationSelectList = typesService.findAccommodationTypes();
		disabilitySelectList = typesService.findDisabilityTypes();
		issueSelectList = typesService.findIssueTypes();
		dangerSelectList = typesService.findDangerTypes();
		statusSelectList = typesService.findStatusTypes(1);
		employmentSelectList = typesService.findEmploymentTypes();
		advocateSelectList = caseServices.findAdvocates();
		prioritySelectList = typesService.findPriorityTypes();
		communicationSelectList = typesService.findCommunicationTypes();
		goalSelectList = typesService.findGoalTypes();
		reviewFrequencyList = caseServices.findReviewFrequencies();
		developerSelectList = caseServices.findAdvocates();
		
	}

	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Prepare start");
		System.out.println("hiddenid2 = " + getHiddenid());
		if (!((Integer) getHiddenid() == null || (Integer)getHiddenid() == 0)) {
			iamodel = caseServices.getCase(getHiddenid());
			//activateLists();
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
