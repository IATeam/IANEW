package uow.ia.bean;

// Generated Aug 9, 2014 1:06:20 PM by Hibernate Tools 4.0.0

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Bean class for Individual Case
 * @author Kim To
 * @version 1.0.5, 28/08/2014
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
	private Set<Risks> risksSet = new HashSet<Risks>();
	private IndividualCases oldCase;
	private Enquiries relatedEnquiry;
	private Plans plan;
	private Set<PlanGoals> planGoalsSet = new HashSet<PlanGoals>();
	private Set<PlanDevelopers> planDevelopersSet = new HashSet<PlanDevelopers>();
	
	private Set<IndividualCases> individualCasesSet = new HashSet<IndividualCases>();
	
	private Set<CaseIssues> caseIssuesSet = new HashSet<CaseIssues>();
	private Set<IndividualCaseCommunications> communicationsSet = new HashSet<IndividualCaseCommunications>();
	
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
	 * @param risksSet
	 * @param oldCase
	 * @param relatedEnquiry
	 * @param plan
	 * @param planGoalsSet
	 * @param planDevelopersSet
	 * @param individualCasesSet
	 * @param caseIssuesSet
	 * @param communicationsSet
	 */
	public IndividualCases(Integer id, Contacts contact, Contacts advocate,
			String description, StatusTypes statusType,
			PriorityTypes priorityType, Integer serviceProviderId,
			Date createdDateTime, Integer createdUserId, Date updatedDateTime,
			Integer updatedUserId, String referredTo, Set<Risks> risksSet,
			IndividualCases oldCase, Enquiries relatedEnquiry, Plans plan,
			Set<PlanGoals> planGoalsSet, Set<PlanDevelopers> planDevelopersSet,
			Set<IndividualCases> individualCasesSet,
			Set<CaseIssues> caseIssuesSet,
			Set<IndividualCaseCommunications> communicationsSet) {
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
		this.risksSet = risksSet;
		this.oldCase = oldCase;
		this.relatedEnquiry = relatedEnquiry;
		this.plan = plan;
		this.planGoalsSet = planGoalsSet;
		this.planDevelopersSet = planDevelopersSet;
		this.individualCasesSet = individualCasesSet;
		this.caseIssuesSet = caseIssuesSet;
		this.communicationsSet = communicationsSet;
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
	 * @return the risksSet
	 */
	public Set<Risks> getRisksSet() {
		return this.risksSet;
	}

	/**
	 * @param risksSet the risksSet to set
	 */
	public void setRisksSet(Set<Risks> risksSet) {
		this.risksSet = risksSet;
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
		return plan;
	}




	/**
	 * @param plan the plan to set
	 */
	public void setPlan(Plans plan) {
		this.plan = plan;
	}




	/**
	 * @return the planGoalsSet
	 */
	public Set<PlanGoals> getPlanGoalsSet() {
		return planGoalsSet;
	}


	/**
	 * @param planGoalsSet the planGoalsSet to set
	 */
	public void setPlanGoalsSet(Set<PlanGoals> planGoalsSet) {
		this.planGoalsSet = planGoalsSet;
	}


	/**
	 * @return the planDevelopersSet
	 */
	public Set<PlanDevelopers> getPlanDevelopersSet() {
		return planDevelopersSet;
	}



	/**
	 * @param planDevelopersSet the planDevelopersSet to set
	 */
	public void setPlanDevelopersSet(Set<PlanDevelopers> planDevelopersSet) {
		this.planDevelopersSet = planDevelopersSet;
	}



	/**
	 * @return the individualCasesSet
	 */
	public Set<IndividualCases> getIndividualCasesSet() {
		return this.individualCasesSet;
	}

	/**
	 * @param individualCasesSet the individualCasesSet to set
	 */
	public void setIndividualCasesSet(Set<IndividualCases> individualCasesSet) {
		this.individualCasesSet = individualCasesSet;
	}

	/**
	 * @return the caseIssuesSet
	 */
	public Set<CaseIssues> getCaseIssuesSet() {
		return this.caseIssuesSet;
	}

	/**
	 * @param caseIssuesSet the caseIssuesSet to set
	 */
	public void setCaseIssuesSet(Set<CaseIssues> caseIssuesSet) {
		this.caseIssuesSet = caseIssuesSet;
	}

	/**
	 * @return the communicationsSet
	 */
	public Set<IndividualCaseCommunications> getCommunicationsSet() {
		return this.communicationsSet;
	}

	/**
	 * @param communicationsSet the communicationsSet to set
	 */
	public void setCommunicationsSet(
			Set<IndividualCaseCommunications> communicationsSet) {
		this.communicationsSet = communicationsSet;
	}

	
}
