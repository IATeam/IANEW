package uow.ia.bean;

// Generated Aug 9, 2014 1:06:20 PM by Hibernate Tools 4.0.0

import java.util.Date;

/**
 * IndividualCases generated by hbm2java
 */
public class IndividualCases implements java.io.Serializable {

	private Integer id;
	private Integer clientId;
	private Integer advocateId;
	private Integer caseStatusId;
	private String description;
	private Integer priorityId;
	private Integer serviceProviderId;
	private Date createdDateTime;
	private Integer createdUserId;
	private Date updatedDateTime;
	private Integer updatedUserId;
	private String referredTo;
	private Integer oldCaseId;

	public IndividualCases() {
	}

	public IndividualCases(Integer clientId, Integer advocateId,
			Integer caseStatusId, String description, Integer priorityId,
			Integer serviceProviderId, Date createdDateTime,
			Integer createdUserId, Date updatedDateTime, Integer updatedUserId,
			String referredTo, Integer oldCaseId) {
		this.clientId = clientId;
		this.advocateId = advocateId;
		this.caseStatusId = caseStatusId;
		this.description = description;
		this.priorityId = priorityId;
		this.serviceProviderId = serviceProviderId;
		this.createdDateTime = createdDateTime;
		this.createdUserId = createdUserId;
		this.updatedDateTime = updatedDateTime;
		this.updatedUserId = updatedUserId;
		this.referredTo = referredTo;
		this.oldCaseId = oldCaseId;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getClientId() {
		return this.clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public Integer getAdvocateId() {
		return this.advocateId;
	}

	public void setAdvocateId(Integer advocateId) {
		this.advocateId = advocateId;
	}

	public Integer getCaseStatusId() {
		return this.caseStatusId;
	}

	public void setCaseStatusId(Integer caseStatusId) {
		this.caseStatusId = caseStatusId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getPriorityId() {
		return this.priorityId;
	}

	public void setPriorityId(Integer priorityId) {
		this.priorityId = priorityId;
	}

	public Integer getServiceProviderId() {
		return this.serviceProviderId;
	}

	public void setServiceProviderId(Integer serviceProviderId) {
		this.serviceProviderId = serviceProviderId;
	}

	public Date getCreatedDateTime() {
		return this.createdDateTime;
	}

	public void setCreatedDateTime(Date createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	public Integer getCreatedUserId() {
		return this.createdUserId;
	}

	public void setCreatedUserId(Integer createdUserId) {
		this.createdUserId = createdUserId;
	}

	public Date getUpdatedDateTime() {
		return this.updatedDateTime;
	}

	public void setUpdatedDateTime(Date updatedDateTime) {
		this.updatedDateTime = updatedDateTime;
	}

	public Integer getUpdatedUserId() {
		return this.updatedUserId;
	}

	public void setUpdatedUserId(Integer updatedUserId) {
		this.updatedUserId = updatedUserId;
	}

	public String getReferredTo() {
		return this.referredTo;
	}

	public void setReferredTo(String referredTo) {
		this.referredTo = referredTo;
	}

	public Integer getOldCaseId() {
		return this.oldCaseId;
	}

	public void setOldCaseId(Integer oldCaseId) {
		this.oldCaseId = oldCaseId;
	}

}
