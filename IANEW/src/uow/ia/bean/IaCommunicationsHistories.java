package uow.ia.bean;

// Generated Aug 9, 2014 1:06:20 PM by Hibernate Tools 4.0.0

import java.sql.Date;

/**
 * IaCommunicationsHistories generated by hbm2java
 * 
 * @author Kim To
 * @version 1.0.1, 28/09/2014
 * 
 * Modification History:
 * 		28/09/2014 Mods to attributes, constructor, setters and getters to match table structure
 */
public class IaCommunicationsHistories implements java.io.Serializable {

	private Integer id;
	private String action;
	private Integer caseCommunicationId;
	private Integer caseId;
	private Date communicationDate;
	private Integer communicationTypeId;
	private String description;
	private Float timeSpent;
	private String importantFlag;
	private Integer changeOrder;
	private Integer createdUserId;
	private Date createdDateTime;

	public IaCommunicationsHistories() {
	}

	/**
	 * @param id
	 * @param action
	 * @param caseCommunicationId
	 * @param caseId
	 * @param communicationDate
	 * @param communicationTypeId
	 * @param description
	 * @param timeSpent
	 * @param importantFlag
	 * @param changeOrder
	 * @param createdUserId
	 * @param createdDateTime
	 */
	public IaCommunicationsHistories(Integer id, String action,
			Integer caseCommunicationId, Integer caseId,
			Date communicationDate, Integer communicationTypeId,
			String description, Float timeSpent, String importantFlag,
			Integer changeOrder, Integer createdUserId, Date createdDateTime) {
		this.id = id;
		this.action = action;
		this.caseCommunicationId = caseCommunicationId;
		this.caseId = caseId;
		this.communicationDate = communicationDate;
		this.communicationTypeId = communicationTypeId;
		this.description = description;
		this.timeSpent = timeSpent;
		this.importantFlag = importantFlag;
		this.changeOrder = changeOrder;
		this.createdUserId = createdUserId;
		this.createdDateTime = createdDateTime;
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
	 * @return the action
	 */
	public String getAction() {
		return this.action;
	}

	/**
	 * @param action the action to set
	 */
	public void setAction(String action) {
		this.action = action;
	}

	/**
	 * @return the caseCommunicationId
	 */
	public Integer getCaseCommunicationId() {
		return this.caseCommunicationId;
	}

	/**
	 * @param caseCommunicationId the caseCommunicationId to set
	 */
	public void setCaseCommunicationId(Integer caseCommunicationId) {
		this.caseCommunicationId = caseCommunicationId;
	}

	/**
	 * @return the caseId
	 */
	public Integer getCaseId() {
		return this.caseId;
	}

	/**
	 * @param caseId the caseId to set
	 */
	public void setCaseId(Integer caseId) {
		this.caseId = caseId;
	}

	/**
	 * @return the communicationDate
	 */
	public Date getCommunicationDate() {
		return this.communicationDate;
	}

	/**
	 * @param communicationDate the communicationDate to set
	 */
	public void setCommunicationDate(Date communicationDate) {
		this.communicationDate = communicationDate;
	}

	/**
	 * @return the communicationTypeId
	 */
	public Integer getCommunicationTypeId() {
		return this.communicationTypeId;
	}

	/**
	 * @param communicationTypeId the communicationTypeId to set
	 */
	public void setCommunicationTypeId(Integer communicationTypeId) {
		this.communicationTypeId = communicationTypeId;
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
	 * @return the timeSpent
	 */
	public Float getTimeSpent() {
		return this.timeSpent;
	}

	/**
	 * @param timeSpent the timeSpent to set
	 */
	public void setTimeSpent(Float timeSpent) {
		this.timeSpent = timeSpent;
	}

	/**
	 * @return the importantFlag
	 */
	public String getImportantFlag() {
		return importantFlag;
	}

	/**
	 * @param importantFlag the importantFlag to set
	 */
	public void setImportantFlag(String importantFlag) {
		this.importantFlag = importantFlag;
	}

	/**
	 * @return the changeOrder
	 */
	public Integer getChangeOrder() {
		return this.changeOrder;
	}

	/**
	 * @param changeOrder the changeOrder to set
	 */
	public void setChangeOrder(Integer changeOrder) {
		this.changeOrder = changeOrder;
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


}
