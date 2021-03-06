package uow.ia.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
//import bsh.This;


import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.sun.org.apache.xml.internal.security.keys.content.PGPData;
import com.sun.xml.rpc.processor.modeler.j2ee.xml.javaIdentifierType;
import com.sun.xml.rpc.processor.modeler.j2ee.xml.string;

import uow.ia.bean.AccommodationTypes;
import uow.ia.bean.Addresses;
import uow.ia.bean.CaseIssues;
import uow.ia.bean.ClientDisabilities;
import uow.ia.bean.CommunicationTypes;
import uow.ia.bean.ContactEmployments;
import uow.ia.bean.Contacts;
import uow.ia.bean.CulturalBackgroundTypes;
import uow.ia.bean.DangerTypes;
import uow.ia.bean.DisabilityTypes;
import uow.ia.bean.EmploymentTypes;
import uow.ia.bean.Enquiries;
import uow.ia.bean.EnquiryIssues;
import uow.ia.bean.GenderTypes;
import uow.ia.bean.GoalTypes;
import uow.ia.bean.IndividualCaseCommunications;
import uow.ia.bean.IndividualCases;
import uow.ia.bean.IssueTypes;
import uow.ia.bean.PlanDevelopers;
import uow.ia.bean.PlanGoals;
import uow.ia.bean.PriorityTypes;
import uow.ia.bean.Plans;
import uow.ia.bean.ReviewFrequencies;
import uow.ia.bean.Risks;
import uow.ia.bean.StatusTypes;
import uow.ia.bean.TitleTypes;
import uow.ia.bean.Users;
import uow.ia.util.DateUtil;

import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

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
	
	private final static String kExistingCaseTitle = "Existing Case";
	private String formTitle;
	private Integer enquiryId;
	private Integer contactid;
	private Integer call;
	private Integer supportContactId;
	private Integer authorisedContactId;

	
	/**
	 * @return the supportContactId
	 */
	public Integer getSupportContactId() {
		return supportContactId;
	}

	/**
	 * @param supportContactId the supportContactId to set
	 */
	public void setSupportContactId(Integer supportContactId) {
		this.supportContactId = supportContactId;
	}

	/**
	 * @return the authorisedContactId
	 */
	public Integer getAuthorisedContactId() {
		return authorisedContactId;
	}

	/**
	 * @param authorisedContactId the authorisedContactId to set
	 */
	public void setAuthorisedContactId(Integer authorisedContactId) {
		this.authorisedContactId = authorisedContactId;
	}

	/**
	 * @return the call
	 */
	public Integer getCall() {
		return call;
	}

	/**
	 * @param call the call to set
	 */
	public void setCall(Integer call) {
		this.call = call;
	}

	/**
	 * @return the contactid
	 */
	public Integer getContactid() {
		return contactid;
	}

	/**
	 * @param contactid the contactid to set
	 */
	public void setContactid(Integer contactid) {
		this.contactid = contactid;
	}

	private IndividualCases iamodel = new IndividualCases();
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
	private List<StatusTypes> planStatusSelectList = new ArrayList<StatusTypes>();
	private List<StatusTypes> goalStatusSelectList = new ArrayList<StatusTypes>();
	private List<StatusTypes> caseIssueStatusSelectList = new ArrayList<StatusTypes>();
	/**
	 * @return the caseIssueStatusSelectList
	 */
	public List<StatusTypes> getCaseIssueStatusSelectList() {
		return caseIssueStatusSelectList;
	}

	/**
	 * @param caseIssueStatusSelectList the caseIssueStatusSelectList to set
	 */
	public void setCaseIssueStatusSelectList(
			List<StatusTypes> caseIssueStatusSelectList) {
		this.caseIssueStatusSelectList = caseIssueStatusSelectList;
	}

	/**
	 * Lists of selected type ids
	 */
	private List<Integer> theDisabilityListId = new ArrayList<Integer>();						
	/**
	 * @return the planStatusSelectList
	 */
	public List<StatusTypes> getPlanStatusSelectList() {
		return planStatusSelectList;
	}

	/**
	 * @param planStatusSelectList the planStatusSelectList to set
	 */
	public void setPlanStatusSelectList(List<StatusTypes> planStatusSelectList) {
		this.planStatusSelectList = planStatusSelectList;
	}

	/**
	 * @return the goalStatusSelectList
	 */
	public List<StatusTypes> getGoalStatusSelectList() {
		return goalStatusSelectList;
	}

	/**
	 * @param goalStatusSelectList the goalStatusSelectList to set
	 */
	public void setGoalStatusSelectList(List<StatusTypes> goalStatusSelectList) {
		this.goalStatusSelectList = goalStatusSelectList;
	}

	private List<Integer> theIssueListId = new ArrayList<Integer>();				
	private List<Integer> theEmploymentListId = new ArrayList<Integer>();			
	private List<Integer> theCommunicationsList = new ArrayList<Integer>();	
	private List<Integer> theGoalList = new ArrayList<Integer>();
	private List<Integer> theDeveloperList = new ArrayList<Integer>();
	private List<Integer> theGoalStatusList = new ArrayList<Integer>();
	private List<Integer> theIssueStatusList = new ArrayList<Integer>();
	private List<String> communicationDateList = new ArrayList<String>(); 
	
	
	/**
	 * @return the theIssueStatusList
	 */
	public List<Integer> getTheIssueStatusList() {
		return theIssueStatusList;
	}

	/**
	 * @return the communicationDateList
	 */
	public List<String> getCommunicationDateList() {
		return communicationDateList;
	}

	/**
	 * @param communicationDateList the communicationDateList to set
	 */
	public void setCommunicationDateList(List<String> communicationDateList) {
		this.communicationDateList = communicationDateList;
	}

	/**
	 * @return the lastReviewedDate
	 */
	public String getLastReviewedDate() {
		return lastReviewedDate;
	}

	/**
	 * @param lastReviewedDate the lastReviewedDate to set
	 */
	public void setLastReviewedDate(String lastReviewedDate) {
		this.lastReviewedDate = lastReviewedDate;
	}

	/**
	 * @return the planProvidedDate
	 */
	public String getPlanProvidedDate() {
		return planProvidedDate;
	}

	/**
	 * @param planProvidedDate the planProvidedDate to set
	 */
	public void setPlanProvidedDate(String planProvidedDate) {
		this.planProvidedDate = planProvidedDate;
	}

	/**
	 * @return the consentSignedDate
	 */
	public String getConsentSignedDate() {
		return consentSignedDate;
	}

	/**
	 * @param consentSignedDate the consentSignedDate to set
	 */
	public void setConsentSignedDate(String consentSignedDate) {
		this.consentSignedDate = consentSignedDate;
	}

	/**
	 * @param theIssueStatusList the theIssueStatusList to set
	 */
	public void setTheIssueStatusList(List<Integer> theIssueStatusList) {
		this.theIssueStatusList = theIssueStatusList;
	}

	/**
	 * @return the theGoalStatusList
	 */
	public List<Integer> getTheGoalStatusList() {
		return theGoalStatusList;
	}

	/**
	 * @param theGoalStatusList the theGoalStatusList to set
	 */
	public void setTheGoalStatusList(List<Integer> theGoalStatusList) {
		this.theGoalStatusList = theGoalStatusList;
	}

	private String theReviewFrequencyString;
	private String dob;
	private int theTitleTypeId; 							
	private int theGenderTypeId;
	private int theCulturalBackgroundTypeId;
	private int theAccommodationTypeId;
	private int theDangerTypeId;
	private int theStatus;							
	private int theAdvocate;						
	private int thePriority;
	private int thePlanStatus;
	private int theReviewFrequency;
	private String lastReviewedDate;
	private String planProvidedDate;
	private String consentSignedDate;
	private String authorisedByDate;
	
	
	/**
	 * @return the theReviewFrequency
	 */
	public int getTheReviewFrequency() {
		return theReviewFrequency;
	}

	/**
	 * @param theReviewFrequency the theReviewFrequency to set
	 */
	public void setTheReviewFrequency(int theReviewFrequency) {
		this.theReviewFrequency = theReviewFrequency;
	}

	/**
	 * @return the thePlanStatus
	 */
	public int getThePlanStatus() {
		return thePlanStatus;
	}

	/**
	 * @param thePlanStatus the thePlanStatus to set
	 */
	public void setThePlanStatus(int thePlanStatus) {
		this.thePlanStatus = thePlanStatus;
	}

	/**
	 * @return the formTitle
	 */
	public String getFormTitle() {
		return formTitle;
	}

	/**
	 * @return the theDeveloperList
	 */
	public List<Integer> getTheDeveloperList() {
		return theDeveloperList;
	}

	/**
	 * @param theDeveloperList the theDeveloperList to set
	 */
	public void setTheDeveloperList(List<Integer> theDeveloperList) {
		this.theDeveloperList = theDeveloperList;
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
	public int getTheStatus() {
		return theStatus;
	}

	/**
	 * @param theStatusTypeId the theStatusTypeId to set
	 */
	public void setTheStatus(int theStatus) {
		this.theStatus = theStatus;
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
	public String newCase(){//TODO:
		setFormTitle("New Case");
		activateLists();
		setCreatedDate(new Date());
		setUpdatedDate(new Date());
		return SUCCESS;
	}

	/**
	 * Action Method
	 * @return
	 */
	public String getExistingCase(){//TODO:
		this.formTitle = kExistingCaseTitle;
		activateLists();
		initialiseDBList();
		System.out.println(iamodel.getCaseIssuesList().size());
		
		System.out.println("Set stuffs");
		System.out.println("no");
		System.out.println("end get existing list");
		return SUCCESS;
	}
	
	public void initialiseDBList() {//TODO:
		if (iamodel != null) {
			if (iamodel.getContact() != null) {
				clearList();
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
					setTheGenderTypeId(iamodel.getContact().getGenderType().getId());
				}
				
				if (iamodel.getStatusType() != null) {
					setTheStatus(iamodel.getStatusType().getId());
				}
				
				if (iamodel.getContact().getTitleType() != null) {
					setTheTitleTypeId(iamodel.getContact().getTitleType().getId());
				}
				
				if (iamodel.getAdvocate() != null) {
					theAdvocate = iamodel.getAdvocate().getId();
				}
				
				if (iamodel.getPlan() != null) {
					if (iamodel.getPlan().getStatusType() != null) {
						setThePlanStatus(iamodel.getPlan().getStatusType().getId());
					}
					
					if (iamodel.getPlan().getLastReviewedDate() != null) {
						lastReviewedDate = iamodel.getPlan().getLastReviewedDate().toString();
					}
					
					if (iamodel.getPlan().getAuthorisedByDate() != null) {
						authorisedByDate = iamodel.getPlan().getAuthorisedByDate().toString();
					}
					
					if (iamodel.getPlan().getConsentSignedDate() != null) {
						consentSignedDate = iamodel.getPlan().getConsentSignedDate().toString();
					}
					
					if (iamodel.getPlan().getProvidedPlanDate() != null) {
						planProvidedDate = iamodel.getPlan().getProvidedPlanDate().toString();
					}
					
					if (iamodel.getPlan().getReviewFrequency() != null) {
						theReviewFrequency = iamodel.getPlan().getReviewFrequency().getId();
					}
					
				}
				
				if (iamodel.getPriorityType() != null) {
					setThePriority(iamodel.getPriorityType().getId());
				}
				
				List<PlanDevelopers> planDevelopersDB = iamodel.getPlanDevelopersList();
				for (PlanDevelopers pd : planDevelopersDB) {
					try {
						theDeveloperList.add(pd.getContact().getId());
					} catch(NullPointerException e) {
						theDeveloperList.add(new Integer(-1));
					}
				}
				
				List<PlanGoals> planGoalsDB = getIamodel().getPlanGoalsList();
				for (PlanGoals pg : planGoalsDB){
					try {
						theGoalList.add(pg.getGoalType().getId());
					} catch (NullPointerException e) {
						theGoalList.add(new Integer(-1));
					}
					
					try {
						theGoalStatusList.add(pg.getStatusType().getId());
					}catch(NullPointerException e) {
						theGoalStatusList.add(new Integer(-1));
					}
				}
				
				List<CaseIssues> caseIssuesDB = getIamodel().getCaseIssuesList();
				for (CaseIssues ci : caseIssuesDB) {
					try {
						theIssueListId.add(ci.getIssue().getId());
					} catch(NullPointerException e) {
						theIssueListId.add(new Integer(-1));
					}
					
					try {
						theIssueStatusList.add(ci.getStatusType().getId());
					}catch (NullPointerException e) {
						theIssueStatusList.add(new Integer(-1));
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
		}
	}
	
	public void clearList() {//TODO:
		theDeveloperList.clear();
		theGoalList.clear();
		theGoalStatusList.clear();
		theIssueListId.clear();
		theIssueStatusList.clear();
		theCommunicationsList.clear();
		theDisabilityListId.clear();
		theEmploymentListId.clear();
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
	public String caseList(){//TODO:
		this.formTitle = "Case List";
		setPage(1);
		setNumberOfRecords(10);
		
		setCaseList(caseServices.findCasesByPage(page,numberOfRecords));
		totalNumberOfRecords = caseServices.countCases();
		int mod = (int) totalNumberOfRecords % numberOfRecords;
		if (mod!= 0)
			mod = 1;
		totalNumberOfPages = totalNumberOfRecords/numberOfRecords + mod;
		return SUCCESS;
	}
	
	
	/**
	 * Action Method for updating the case list after requesting a different page
	 * @return
	 */
	public String updateCaseList(){ //TODO:
		caseList = caseServices.findCasesByPage(getPage(),getNumberOfRecords());
		totalNumberOfRecords = caseServices.countCases();
		int mod = (int) totalNumberOfRecords % numberOfRecords;
		if (mod!= 0)
			mod = 1;
		totalNumberOfPages = totalNumberOfRecords/numberOfRecords + mod;
		this.formTitle = "Case List";
		return SUCCESS;
	}
	
	private Map <String, Object> userSession;
	
	public String assignContact(){ //TODO:
		setFormTitle("New Case");
		try{
			if (getContactid() > 0)
				iamodel.setContact(contactService.getContacts(getContactid()));
			
		}catch(NullPointerException npe){
			iamodel = new IndividualCases();
			if (getContactid() > 0)
				iamodel.setContact(contactService.getContacts(getContactid()));
		}
		activateLists();
		//initialiseDBList();
		if(getCall() == 1)
			return "contactinfo";
		else{
			return "dangertype";
		}
	}
	
	public String assignSupportContact() {//TODO:
		if (getSupportContactId() > 0) {
			if (iamodel == null) {
				iamodel = new IndividualCases();
			}
				
			Contacts support = new Contacts();
			try {
				support = contactService.getContacts(getSupportContactId());
				
				if (iamodel.getPlan() == null)
					iamodel.setPlan(new Plans());
				
				iamodel.getPlan().setSupportPerson(support);
				support = null;
			} catch(Exception e) {
				iamodel.getPlan().setSupportPerson(new Contacts());
			}
		}
		return SUCCESS;
	}
	
	public String assignAuthorisedContact() {//TODO:
		if (getAuthorisedContactId() > 0) {
			if (iamodel == null) {
				iamodel = new IndividualCases();
			}
				
			Contacts authorised = new Contacts();
			try {
				authorised = contactService.getContacts(getAuthorisedContactId());
				
				if (iamodel.getPlan() == null)
					iamodel.setPlan(new Plans());
				
				iamodel.getPlan().setAuthorisedBy(authorised);
			} catch(Exception e) {
				iamodel.getPlan().setAuthorisedBy(new Contacts());
			}
		}
		return SUCCESS;
	}
	
	public String clearContact(){ //TODO:
		setFormTitle("New Case");
		try{
			iamodel.setContact(new Contacts());
		}catch(NullPointerException npe){
			iamodel = new IndividualCases();
			iamodel.setContact(new Contacts());
		}
		activateLists();
		return SUCCESS;
	}
	
	// to clear contact list after user select
	public String clearContactList() {//TODO:
		System.out.println("clear the contact List");
		return SUCCESS;
	}
	
	//clear support person
	public String clearSupportContact() {//TODO:
		try {
			if (iamodel == null)
				iamodel = new IndividualCases();
			
			if (iamodel.getPlan() == null)
				iamodel.setPlan(new Plans());
			
			iamodel.getPlan().setSupportPerson(new Contacts());
			System.out.println("clear support"+iamodel.getPlan().getSupportPerson());
		} catch(NullPointerException e) {
			iamodel = new IndividualCases();
			iamodel.setPlan(new Plans());
			iamodel.getPlan().setSupportPerson(new Contacts());
		}
		
		return SUCCESS;
	}
	
	public String clearAuthorisedContact() {//TODO:
		try {
			if (iamodel == null)
				iamodel = new IndividualCases();
			
			if (iamodel.getPlan() == null)
				iamodel.setPlan(new Plans());
			
			iamodel.getPlan().setAuthorisedBy(new Contacts());
		} catch(NullPointerException e) {
			iamodel = new IndividualCases();
			iamodel.setPlan(new Plans());
			iamodel.getPlan().setAuthorisedBy(new Contacts());
		}
		
		return SUCCESS;
	}
	
	
	public String saveUpdateCase(){ //TO DO
		System.out.println("Start Saving Case");
		System.out.println("support " + getSupportContactId() + " " + " authorised " + getAuthorisedContactId());
		Users user = (Users) userSession.get(USER);
		java.util.Calendar cal = java.util.Calendar.getInstance();
		java.util.Date utilDate = cal.getTime();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		
		iamodel.getContact().setUpdatedDateTime(sqlDate);
		
		// set status
		iamodel.setStatusType(typesService.getStatusTypeById(theStatus));
		iamodel.setPriorityType(typesService.getPriorityTypeById(thePriority));
		iamodel.getContact().setDangerType(typesService.getDangerTypeById(theDangerTypeId));
		
		// save advocate
		iamodel.setAdvocate(contactService.getContacts(theAdvocate));
		
		// save contact details
		if (theCulturalBackgroundTypeId != -1) { 
			iamodel.getContact().setCulturalBackground(typesService.getCulturalBackgroundTypeById(theCulturalBackgroundTypeId));
		} else {
			iamodel.getContact().setCulturalBackground(null);
		}
		
		if(theTitleTypeId != -1) {
			iamodel.getContact().setTitleType(typesService.getTitleTypeById(theTitleTypeId));
		} else {
			iamodel.getContact().setTitleType(null);
		}
		
		iamodel.getContact().setGenderType(typesService.getGenderTypeById(theGenderTypeId));
		iamodel.getContact().setDangerType(typesService.getDangerTypeById(theDangerTypeId));
		
		java.sql.Date sqlDobDate = null;
		try {
			sqlDobDate = DateUtil.yyyymmddSqlDate(dob);
		} catch (Exception e) {
			sqlDobDate = null;
		}
		iamodel.getContact().setDob(sqlDobDate);
		
		// save addresses
		if (theAccommodationTypeId != -1) {
			iamodel.getContact().setAccommodation(typesService.getAccommodationTypeById(theAccommodationTypeId));
		} else {
			iamodel.getContact().setAccommodation(null);
		}
		
		List<Addresses> al = iamodel.getContact().getAddressesList();
		for (int i = 0; i < al.size(); i++) {
			if (al.get(i).getId() == null){
				al.get(i).setContact(iamodel.getContact());
			} else if (al.get(i).getId() == -1) {
				iamodel.getContact().getAddressesList().remove(i);
				i--;
			}
		}
		
		// save disability
		List<ClientDisabilities> cdl = iamodel.getContact().getDisabilitiesList();
		if (getTheDisabilityListId().size() > 0) {
			for(int i = 0; i < theDisabilityListId.size(); i++){
				if (cdl.get(i).getId() != null) {
					if (cdl.get(i).getId() != -1 && theDisabilityListId.get(i) != -1) {
						cdl.get(i).setDisabilityType(typesService.getDisabilityTypeById(getTheDisabilityListId().get(i)));
						cdl.get(i).setContact(iamodel.getContact());
						//cdl.get(i).setUpdatedUser(user.getContact());
					} else {
						cdl.remove(i);
						theDisabilityListId.remove(i);
						i--;
					}
				} else {
					if (theDisabilityListId.get(i) != -1) {
						cdl.get(i).setDisabilityType(typesService.getDisabilityTypeById(getTheDisabilityListId().get(i)));
						cdl.get(i).setContact(iamodel.getContact());
						//cdl.get(i).setCreatedUser(user.getContact());
						//cdl.get(i).setUpdatedUser(user.getContact());
					} else {
						cdl.remove(i);
						theDisabilityListId.remove(i);
						i--;
					}
				}
			}
		}
		
		// save employments
		List<ContactEmployments> cel = iamodel.getContact().getEmploymentsList();
		System.out.println();
		if (getTheEmploymentListId().size() > 0) {
			for(int i = 0; i < theEmploymentListId.size(); i++){
				if (cel.get(i).getId() != null) {
					if (cel.get(i).getId() != -1 && theEmploymentListId.get(i) != -1) {
						cel.get(i).setEmploymentType(typesService.getEmploymentTypeById(getTheEmploymentListId().get(i)));
						cel.get(i).setContact(iamodel.getContact());
						//cel.get(i).setUpdatedUser(user.getContact());
					} else {
						cel.remove(i);
						theEmploymentListId.remove(i);
						i--;
					}
				} else {
					if (theEmploymentListId.get(i) != -1) {
						cel.get(i).setEmploymentType(typesService.getEmploymentTypeById(getTheEmploymentListId().get(i)));
						cel.get(i).setContact(iamodel.getContact());
						//cel.get(i).setCreatedUser(user.getContact());
						//cel.get(i).setUpdatedUser(user.getContact());
					} else {
						cel.remove(i);
						theEmploymentListId.remove(i);
						i--;
					}
				}
			}
		}
		
		//save risk
		List<Risks> riskList = iamodel.getRisksList();
		for (int i = 0; i < riskList.size(); i++) {
			if (riskList.get(i).getId() != null) {
				if(riskList.get(i).getId() == -1) {
					riskList.remove(i);
					i--;
				} 
			} else {
				riskList.get(i).setIndividualCase(iamodel);
			}
		}
		
		// save plan

		if (iamodel.getPlan() == null)
			iamodel.setPlan(new Plans());
		
		if (iamodel.getId() == null) {
			iamodel.getPlan().setIndividualCase(iamodel);
		}
		
//		if (iamodel.getPlan().getSupportPerson() != null) {
//			System.out.println("xxxxxxxxxxxxxxxxxxxxx called in outter get id");
//			if (iamodel.getPlan().getSupportPerson().getId() != null) {
//				System.out.println("xxxxxxxxxxxxxxxxxxxxx called in inner get id");
//				Contacts support = contactService.getContacts(iamodel.getPlan().getSupportPerson().getId());
//				support.setFirstname(iamodel.getPlan().getSupportPerson().getFirstname());
//				support.setOthername(iamodel.getPlan().getSupportPerson().getOthername());
//				support.setLastname(iamodel.getPlan().getSupportPerson().getLastname());
//				iamodel.getPlan().setSupportPerson(support);
//			} else {
//				System.out.println("xxxxxxxxxxxxxxxxxxxxx called in inner get id else");
//			}
//		} else {
//			System.out.println("xxxxxxxxxxxxxxxxxxxxx called in outter get id else");
//		}
//		
//		if (iamodel.getPlan().getAuthorisedBy() != null) {
//			if (iamodel.getPlan().getAuthorisedBy().getId() != null) {
//				Contacts authorise = contactService.getContacts(iamodel.getPlan().getAuthorisedBy().getId());
//				support.setFirstname(iamodel.getPlan().getSupportPerson().getFirstname());
//				support.setOthername(iamodel.getPlan().getSupportPerson().getOthername());
//				support.setLastname(iamodel.getPlan().getSupportPerson().getLastname());
//				iamodel.getPlan().setAuthorisedBy(authorise);
//			}
//		}
//		if (getSupportContactId() != null) {
//			try {
//				iamodel.getPlan().setSupportPerson(contactService.getContacts(getSupportContactId()));
//			} catch (NullPointerException e) {
//				iamodel.getPlan().setSupportPerson(new Contacts());
//			}
//		} 
//		
//		if (getAuthorisedContactId() != null) {
//			try {
//				iamodel.getPlan().setAuthorisedBy(contactService.getContacts(getAuthorisedContactId()));
//			} catch (NullPointerException e) {
//				iamodel.getPlan().setAuthorisedBy(new Contacts());
//			}
//		} 
		
		if (theReviewFrequency != -1) {
			iamodel.getPlan().setReviewFrequency(typesService.getReviewFrequencyById(theReviewFrequency));
		} else {
			iamodel.getPlan().setReviewFrequency(null);
		}
		
		if (thePlanStatus != -1) {
			iamodel.getPlan().setStatusType(typesService.getStatusTypeById(thePlanStatus));
		} else {
			iamodel.getPlan().setStatusType(null);
		}
		
		// save plan developers
		List<PlanDevelopers> pdl = iamodel.getPlanDevelopersList();
		System.out.println(pdl.size());
		for (int i = 0; i < theDeveloperList.size(); i++) {
			if (pdl.get(i).getId() != null) {
				if (pdl.get(i).getId() != -1) {
					pdl.get(i).setContact(contactService.getContacts(theDeveloperList.get(i)));
					pdl.get(i).setIndividualCase(iamodel);
				} else {
					pdl.remove(i);
					theDeveloperList.remove(i);
					i--;
				}
			} else {
				pdl.get(i).setContact(contactService.getContacts(theDeveloperList.get(i)));
				pdl.get(i).setIndividualCase(iamodel);
			}
		}
		
		// save goals
		System.out.println("Save goals");
		List<PlanGoals> pgl = iamodel.getPlanGoalsList();
		System.out.println(theGoalList.size() + " " + theGoalStatusList.size());
		if (theGoalList.size() == theGoalStatusList.size()) {
			for (int i = 0; i < theGoalList.size(); i++) {
				if(pgl.get(i).getId() != null) {
					if (pgl.get(i).getId() != -1 && theGoalList.get(i) != -1) {
						pgl.get(i).setGoalType(typesService.getGoalTypeById(theGoalList.get(i)));
						
						if (theGoalStatusList.get(i) != -1) {
							pgl.get(i).setStatusType(typesService.getStatusTypeById(theGoalStatusList.get(i)));
						}
						
						pgl.get(i).setIndividualCase(iamodel);
					} else {
						pgl.remove(i);
						theGoalList.remove(i);
						theGoalStatusList.remove(i);
						i--;
					}
				} else {
					if (theGoalList.get(i) != -1) {
						pgl.get(i).setGoalType(typesService.getGoalTypeById(theGoalList.get(i)));
						
						if (theGoalStatusList.get(i) != -1) {
							pgl.get(i).setStatusType(typesService.getStatusTypeById(theGoalStatusList.get(i)));
						}
						
						pgl.get(i).setIndividualCase(iamodel);
					} else {
						pgl.remove(i);
						theGoalList.remove(i);
						theGoalStatusList.remove(i);
						i--;
					}
				}
			}
		}
		
		// save case issues
		System.out.println("Save case issues");
		List<CaseIssues> cil = iamodel.getCaseIssuesList();
		System.out.println(cil.size() + " " + theIssueListId.size());
		if (theIssueListId.size() == theIssueStatusList.size() && theIssueListId.size() == cil.size()) {
			for (int i = 0; i < theIssueListId.size(); i++) {
				if (cil.get(i).getId() != null) {
					if (cil.get(i).getId() != -1 && theIssueListId.get(i) != -1) {
						cil.get(i).setIssue(typesService.getIssueTypeById(theIssueListId.get(i)));
						
						if (theIssueStatusList.get(i) != -1) {
							cil.get(i).setStatusType(typesService.getStatusTypeById(theIssueStatusList.get(i)));
						}
						
						cil.get(i).setIndividualCase(iamodel);
					} else {
						cil.remove(i);
						theIssueListId.remove(i);
						theIssueStatusList.remove(i);
						i--;
					}
				} else {
					if (theIssueListId.get(i) != -1) {
						cil.get(i).setIssue(typesService.getIssueTypeById(theIssueListId.get(i)));
						
						if (theIssueStatusList.get(i) != -1) {
							cil.get(i).setStatusType(typesService.getStatusTypeById(theIssueStatusList.get(i)));
						}
						
						cil.get(i).setIndividualCase(iamodel);
					} else {
						cil.remove(i);
						theIssueListId.remove(i);
						theIssueStatusList.remove(i);
						i--;
					}
				}
			}
		}
		
		//save communications - need to find a better way
		System.out.println("Save communications");
		List<IndividualCaseCommunications> icl = iamodel.getCommunicationsList();
		System.out.println(theCommunicationsList.size());
		if (theCommunicationsList.size() == icl.size()) {
			for (int i = 0; i < theCommunicationsList.size(); i++) {
				System.out.println(theCommunicationsList.get(i));
				if (icl.get(i).getId() != null) {
					if (icl.get(i).getId() != -1 && theCommunicationsList.get(i) != -1) {
						icl.get(i).setCommunicationType(typesService.getCommunicationTypeById(theCommunicationsList.get(i)));
						icl.get(i).setIndividualCase(iamodel);
					} else {
						icl.remove(i);
						theCommunicationsList.remove(i);
						i--;
					}
				} else {
					
					if (theCommunicationsList.get(i) != -1) {
						icl.get(i).setCommunicationType(typesService.getCommunicationTypeById(theCommunicationsList.get(i)));
						icl.get(i).setIndividualCase(iamodel);
					} else {
						icl.remove(i);
						theCommunicationsList.remove(i);
						i--;
					}
				}
			}
		}
		
		if (iamodel.getPlan() != null) {
			if (iamodel.getPlan().getAuthorisedBy() != null) {
				if (isContactEmpty(iamodel.getPlan().getAuthorisedBy())) {
					iamodel.getPlan().setAuthorisedBy(null);
				}
			}
			
			if (iamodel.getPlan().getSupportPerson() != null) {
				System.out.println("suport id " + iamodel.getPlan().getSupportPerson().getId());
				if (isContactEmpty(iamodel.getPlan().getSupportPerson())) {
					System.out.println("support contact is empty");
					iamodel.getPlan().setSupportPerson(null);
				}
			}
		}
		
		iamodel.getContact().setContactType(typesService.getContactTypeById(2));
		System.out.println("calling case services to save");
		if (iamodel.getId() == null) {
			if (caseServices.saveOrUpdateCase(iamodel, iamodel.getContact())) {
				this.formTitle = kExistingCaseTitle;
				activateLists();
				setIamodel(caseServices.getCase(iamodel.getId()));
				initialiseDBList();
				hiddenid = iamodel.getId();
				System.out.println("test " + iamodel.getId());
				return SUCCESS;
			} 
		} else if(caseServices.saveOrUpdateCase(iamodel)) {
			System.out.println("called after support remove");
			this.formTitle = kExistingCaseTitle;
			activateLists();
			setIamodel(caseServices.getCase(iamodel.getId()));
			initialiseDBList();
			return SUCCESS;
		}
		
		System.out.println("End Saving Case");
		return SUCCESS;
	}
	
	public boolean isContactEmpty(Contacts c) {
		if (c != null) {
			if (c.getFirstname().trim().isEmpty() && 
				c.getLastname().trim().isEmpty() && 
				c.getOthername().trim().isEmpty() && 
				c.getMobilephone().trim().isEmpty()) {
				
				return true;
			}
		} 
		return false;
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
	 * @return the authorisedByDate
	 */
	public String getAuthorisedByDate() {
		return authorisedByDate;
	}

	/**
	 * @param authorisedByDate the authorisedByDate to set
	 */
	public void setAuthorisedByDate(String authorisedByDate) {
		this.authorisedByDate = authorisedByDate;
	}

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
		statusSelectList = typesService.findStatusTypes(2);
		employmentSelectList = typesService.findEmploymentTypes();
		advocateSelectList = caseServices.findAdvocates();
		prioritySelectList = typesService.findPriorityTypes();
		communicationSelectList = typesService.findCommunicationTypes();
		goalSelectList = typesService.findGoalTypes();
		reviewFrequencyList = caseServices.findReviewFrequencies();
		developerSelectList = caseServices.findAdvocates();
		planStatusSelectList = typesService.findStatusTypes(3);
		goalStatusSelectList = typesService.findStatusTypes(4);
		caseIssueStatusSelectList = typesService.findStatusTypes(5);
	}

	@Override
	public void prepare() throws Exception {//TODO:
		if (!((Integer) getHiddenid() == null || (Integer)getHiddenid() == 0)) {
			iamodel = caseServices.getCase(getHiddenid());
			activateLists();
			
		} else {
			
			//if (this.contactId != null) {
			//	iamodel.setContact(contactService.getContacts(this.contactId));
			//	iamodel.setRelatedEnquiry(enquiryService.getEnquiry(this.enquiryId));
			//} else 
				if (this.enquiryId != null) {
					this.formTitle = "New Case";
					Enquiries enquiry = enquiryService.getEnquiry(this.enquiryId);
					iamodel.setRelatedEnquiry(enquiry);
					System.out.println(enquiry.getContact().getId());
					iamodel.setContact(enquiry.getContact());
					
					List<EnquiryIssues> eiList = enquiry.getEnquiryIssuesList();
					iamodel.getCaseIssuesList().clear();
					for (EnquiryIssues e : eiList) {
						CaseIssues ci = new CaseIssues();
						ci.setIssue(e.getIssue());
						ci.setComments(e.getComment());
						iamodel.getCaseIssuesList().add(ci);
						System.out.println(ci.getIssue().getIssueName());
					}
					System.out.println("issue list size " + iamodel.getCaseIssuesList().size());
					initialiseDBList();
			} 
		}

		if (iamodel == null)
			iamodel = new IndividualCases();
		
		if (iamodel.getPlan() == null)
			iamodel.setPlan(new Plans());
		
		if (getSupportContactId() != null) {
			try {
				iamodel.getPlan().setSupportPerson(contactService.getContacts(getSupportContactId()));
			} catch(Exception e) {
				iamodel.getPlan().setSupportPerson(new Contacts());
			}
		} 
		
		if (getAuthorisedContactId() != null) {
			try {
				iamodel.getPlan().setAuthorisedBy(contactService.getContacts(getAuthorisedContactId()));
			} catch(Exception e) {
				iamodel.getPlan().setAuthorisedBy(new Contacts());
			}
		} 
	}

	/**
	 * @return the enquiryId
	 */
	public Integer getEnquiryId() {
		return enquiryId;
	}

	/**
	 * @param enquiryId the enquiryId to set
	 */
	public void setEnquiryId(Integer enquiryId) {
		this.enquiryId = enquiryId;
	}

	@Override
	public IndividualCases getModel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		System.out.println("setSession called");
		this.userSession = session;
	}
	
}
