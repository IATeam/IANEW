package uow.ia.bean;

// Generated Aug 9, 2014 1:06:20 PM by Hibernate Tools 4.0.0

import java.sql.Date;

/**
 * @author Kim To
 * @version 1.0.3, 26/08/2014
 */
public class IndividualCaseCommunications implements java.io.Serializable {

	private Integer id;
	private IndividualCases individualCase;
	private Date communicationDate;
	private CommunicationTypes communicationType;
	private String description;
	private Float timeSpent;
	private String importantFlag;
	private Integer createdUserId;
	private Date createdDateTime;
	private Integer updatedUserId;
	private Date updatedDateTime;

	public IndividualCaseCommunications() {
	}
	/**
	 * @param id
	 * @param individualCase
	 * @param communicationDate
	 * @param communicationType
	 * @param description
	 * @param timeSpent
	 * @param importantFlag
	 * @param createdUserId
	 * @param createdDateTime
	 * @param updatedUserId
	 * @param updatedDateTime
	 */
	public IndividualCaseCommunications(Integer id,
			IndividualCases individualCase, Date communicationDate,
			CommunicationTypes communicationType, String description,
			Float timeSpent, String importantFlag, Integer createdUserId,
			Date createdDateTime, Integer updatedUserId, Date updatedDateTime) {
		super();
		this.id = id;
		this.individualCase = individualCase;
		this.communicationDate = communicationDate;
		this.communicationType = communicationType;
		this.description = description;
		this.timeSpent = timeSpent;
		this.importantFlag = importantFlag;
		this.createdUserId = createdUserId;
		this.createdDateTime = createdDateTime;
		this.updatedUserId = updatedUserId;
		this.updatedDateTime = updatedDateTime;
	}
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the individualCase
	 */
	public IndividualCases getIndividualCase() {
		return this.individualCase;
	}


	/**
	 * @param individualCase the individualCase to set
	 */
	public void setIndividualCase(IndividualCases individualCase) {
		this.individualCase = individualCase;
	}


	public Date getCommunicationDate() {
		return this.communicationDate;
	}

	public void setCommunicationDate(Date communicationDate) {
		this.communicationDate = communicationDate;
	}


	/**
	 * @return the communicationType
	 */
	public CommunicationTypes getCommunicationType() {
		return this.communicationType;
	}


	/**
	 * @param communicationType the communicationType to set
	 */
	public void setCommunicationType(CommunicationTypes communicationType) {
		this.communicationType = communicationType;
	}


	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getCreatedUserId() {
		return this.createdUserId;
	}

	public void setCreatedUserId(Integer createdUserId) {
		this.createdUserId = createdUserId;
	}

	public Date getCreatedDateTime() {
		return this.createdDateTime;
	}

	public void setCreatedDateTime(Date createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	public Float getTimeSpent() {
		return this.timeSpent;
	}

	public void setTimeSpent(Float timeSpent) {
		this.timeSpent = timeSpent;
	}

	public String getImportantFlag() {
		return this.importantFlag;
	}

	public void setImportantFlag(String importantFlag) {
		this.importantFlag = importantFlag;
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
	 * @return the udpatedDateTime
	 */
	public Date getUpdatedDateTime() {
		return this.updatedDateTime;
	}
	/**
	 * @param udpatedDateTime the udpatedDateTime to set
	 */
	public void setUpdatedDateTime(Date updatedDateTime) {
		this.updatedDateTime = updatedDateTime;
	}

}
