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
	private Integer createdUserId;
	private Date createdDateTime;
	private Float timeSpent;
	private String importantFlag;

	public IndividualCaseCommunications() {
	}


	/**
	 * @param id
	 * @param individualCase
	 * @param communicationDate
	 * @param communicationType
	 * @param description
	 * @param createdUserId
	 * @param createdDateTime
	 * @param timeSpent
	 * @param importantFlag
	 */
	public IndividualCaseCommunications(Integer id,
			IndividualCases individualCase, Date communicationDate,
			CommunicationTypes communicationType, String description,
			Integer createdUserId, Date createdDateTime, Float timeSpent,
			String importantFlag) {
		this.id = id;
		this.individualCase = individualCase;
		this.communicationDate = communicationDate;
		this.communicationType = communicationType;
		this.description = description;
		this.createdUserId = createdUserId;
		this.createdDateTime = createdDateTime;
		this.timeSpent = timeSpent;
		this.importantFlag = importantFlag;
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

}
