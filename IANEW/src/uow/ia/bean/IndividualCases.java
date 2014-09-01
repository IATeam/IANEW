package uow.ia.bean;

// Generated Aug 9, 2014 1:06:20 PM by Hibernate Tools 4.0.0

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Bean class for Individual Case
 * @author Kim To
 * @version 1.0.7, 30/08/2014
 */
public class IndividualCases implements java.io.Serializable {

	private Integer id;
	private Contacts contact;
	private Contacts advocate;
	private String description;
	private StatusTypes statusType;
	private PriorityTypes priorityType;
	private Integer serviceProviderId;
	private Date createdDateTime;
	private Integer createdUserId;
	private Date updatedDateTime;
	private Integer updatedUserId;
	private String referredTo;
	private List<Risks> risksList = new ArrayList<Risks>();
	private IndividualCases oldCase;
	private Enquiries relatedEnquiry;
	private Plans plan;
	private List<PlanGoals> planGoalsList = new ArrayList<PlanGoals>();
	private List<PlanDevelopers> planDevelopersList = new ArrayList<PlanDevelopers>();
	
	private List<IndividualCases> individualCasesList = new ArrayList<IndividualCases>();
	
	private List<CaseIssues> caseIssuesList = new ArrayList<CaseIssues>();
	private List<IndividualCaseCommunications> communicationsList = new ArrayList<IndividualCaseCommunications>();
	
	/**
	 * 
	 */
	public IndividualCases() {
		// TODO Auto-generated constructor stub
	}




	/**
	 * @param id
	 * @param contact
	 * @param advocate
	 * @param description
	 * @param statusType
	 * @param priorityType
	 * @param serviceProviderId
	 * @param createdDateTime
	 * @param createdUserId
	 * @param updatedDateTime
	 * @param updatedUserId
	 * @param referredTo
	 * @param risksList
	 * @param oldCase
	 * @param relatedEnquiry
	 * @param plan
	 * @param planGoalsList
	 * @param planDevelopersList
	 * @param individualCasesList
	 * @param caseIssuesList
	 * @param communicationsList
	 */
	public IndividualCases(Integer id, Contacts contact, Contacts advocate,
			String description, StatusTypes statusType,
			PriorityTypes priorityType, Integer serviceProviderId,
			Date createdDateTime, Integer createdUserId, Date updatedDateTime,
			Integer updatedUserId, String referredTo, List<Risks> risksList,
			IndividualCases oldCase, Enquiries relatedEnquiry, Plans plan,
			List<PlanGoals> planGoalsList,
			List<PlanDevelopers> planDevelopersList,
			List<IndividualCases> individualCasesList,
			List<CaseIssues> caseIssuesList,
			List<IndividualCaseCommunications> communicationsList) {
		super();
		this.id = id;
		this.contact = contact;
		this.advocate = advocate;
		this.description = description;
		this.statusType = statusType;
		this.priorityType = priorityType;
		this.serviceProviderId = serviceProviderId;
		this.createdDateTime = createdDateTime;
		this.createdUserId = createdUserId;
		this.updatedDateTime = updatedDateTime;
		this.updatedUserId = updatedUserId;
		this.referredTo = referredTo;
		this.risksList = risksList;
		this.oldCase = oldCase;
		this.relatedEnquiry = relatedEnquiry;
		this.plan = plan;
		this.planGoalsList = planGoalsList;
		this.planDevelopersList = planDevelopersList;
		this.individualCasesList = individualCasesList;
		this.caseIssuesList = caseIssuesList;
		this.communicationsList = communicationsList;
	}




	/**
	 * @return the id
	 */
	public Integer getId() {
		return this.id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the contact
	 */
	public Contacts getContact() {
		return this.contact;
	}

	/**
	 * @param contact the contact to set
	 */
	public void setContact(Contacts contact) {
		this.contact = contact;
	}

	/**
	 * @return the advocateId
	 */
	public Contacts getAdvocate() {
		return this.advocate;
	}

	/**
	 * @param advocateId the advocateId to set
	 */
	public void setAdvocate(Contacts advocate) {
		this.advocate = advocate;
	}

	/**
	 * @return the statusType
	 */
	public StatusTypes getStatusType() {
		return statusType;
	}



	/**
	 * @param statusType the statusType to set
	 */
	public void setStatusType(StatusTypes statusType) {
		this.statusType = statusType;
	}



	/**
	 * @return the description
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the priorityType
	 */
	public PriorityTypes getPriorityType() {
		return this.priorityType;
	}

	/**
	 * @param priorityType the priorityType to set
	 */
	public void setPriorityType(PriorityTypes priorityType) {
		this.priorityType = priorityType;
	}

	/**
	 * @return the serviceProviderId
	 */
	public Integer getServiceProviderId() {
		return this.serviceProviderId;
	}

	/**
	 * @param serviceProviderId the serviceProviderId to set
	 */
	public void setServiceProviderId(Integer serviceProviderId) {
		this.serviceProviderId = serviceProviderId;
	}

	/**
	 * @return the createdDateTime
	 */
	public Date getCreatedDateTime() {
		return this.createdDateTime;
	}

	/**
	 * @param createdDateTime the createdDateTime to set
	 */
	public void setCreatedDateTime(Date createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	/**
	 * @return the createdUserId
	 */
	public Integer getCreatedUserId() {
		return this.createdUserId;
	}

	/**
	 * @param createdUserId the createdUserId to set
	 */
	public void setCreatedUserId(Integer createdUserId) {
		this.createdUserId = createdUserId;
	}

	/**
	 * @return the updatedDateTime
	 */
	public Date getUpdatedDateTime() {
		return this.updatedDateTime;
	}

	/**
	 * @param updatedDateTime the updatedDateTime to set
	 */
	public void setUpdatedDateTime(Date updatedDateTime) {
		this.updatedDateTime = updatedDateTime;
	}

	/**
	 * @return the updatedUserId
	 */
	public Integer getUpdatedUserId() {
		return this.updatedUserId;
	}

	/**
	 * @param updatedUserId the updatedUserId to set
	 */
	public void setUpdatedUserId(Integer updatedUserId) {
		this.updatedUserId = updatedUserId;
	}

	/**
	 * @return the referredTo
	 */
	public String getReferredTo() {
		return this.referredTo;
	}

	/**
	 * @param referredTo the referredTo to set
	 */
	public void setReferredTo(String referredTo) {
		this.referredTo = referredTo;
	}

	/**
	 * @return the oldCase
	 */
	public IndividualCases getOldCase() {
		return this.oldCase;
	}

	/**
	 * @param oldCase the oldCase to set
	 */
	public void setOldCase(IndividualCases oldCase) {
		this.oldCase = oldCase;
	}

	/**
	 * @return the relatedEnquiryId
	 */
	public Enquiries getRelatedEnquiry() {
		return this.relatedEnquiry;
	}

	/**
	 * @param relatedEnquiryId the relatedEnquiryId to set
	 */
	public void setRelatedEnquiry(Enquiries relatedEnquiry) {
		this.relatedEnquiry = relatedEnquiry;
	}

	/**
	 * @return the plan
	 */
	public Plans getPlan() {
		return this.plan;
	}




	/**
	 * @param plan the plan to set
	 */
	public void setPlan(Plans plan) {
		this.plan = plan;
	}




	/**
	 * @return the risksList
	 */
	public List<Risks> getRisksList() {
		return this.risksList;
	}




	/**
	 * @param risksList the risksList to set
	 */
	public void setRisksList(List<Risks> risksList) {
		this.risksList = risksList;
	}




	/**
	 * @return the planGoalsList
	 */
	public List<PlanGoals> getPlanGoalsList() {
		return this.planGoalsList;
	}




	/**
	 * @param planGoalsList the planGoalsList to set
	 */
	public void setPlanGoalsList(List<PlanGoals> planGoalsList) {
		this.planGoalsList = planGoalsList;
	}




	/**
	 * @return the planDevelopersList
	 */
	public List<PlanDevelopers> getPlanDevelopersList() {
		return this.planDevelopersList;
	}




	/**
	 * @param planDevelopersList the planDevelopersList to set
	 */
	public void setPlanDevelopersList(List<PlanDevelopers> planDevelopersList) {
		this.planDevelopersList = planDevelopersList;
	}




	/**
	 * @return the individualCasesList
	 */
	public List<IndividualCases> getIndividualCasesList() {
		return this.individualCasesList;
	}




	/**
	 * @param individualCasesList the individualCasesList to set
	 */
	public void setIndividualCasesList(List<IndividualCases> individualCasesList) {
		this.individualCasesList = individualCasesList;
	}




	/**
	 * @return the caseIssuesList
	 */
	public List<CaseIssues> getCaseIssuesList() {
		return this.caseIssuesList;
	}




	/**
	 * @param caseIssuesList the caseIssuesList to set
	 */
	public void setCaseIssuesList(List<CaseIssues> caseIssuesList) {
		this.caseIssuesList = caseIssuesList;
	}




	/**
	 * @return the communicationsList
	 */
	public List<IndividualCaseCommunications> getCommunicationsList() {
		return this.communicationsList;
	}




	/**
	 * @param communicationsList the communicationsList to set
	 */
	public void setCommunicationsList(
			List<IndividualCaseCommunications> communicationsList) {
		this.communicationsList = communicationsList;
	}

}
