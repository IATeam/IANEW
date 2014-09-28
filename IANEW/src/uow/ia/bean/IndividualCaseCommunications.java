package uow.ia.bean;

// Generated Aug 9, 2014 1:06:20 PM by Hibernate Tools 4.0.0

import java.sql.Date;

import org.hibernate.search.annotations.DateBridge;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;
import org.hibernate.search.annotations.Resolution;

/**
 * @author Kim To
 * @version 1.0.4, 28/09/2014
 * 
 * Modification History:
 * 		28/09/2014 Change Integer createdUserId and Integer updatedUserId to Contacts createdUser and Contacts updatedUser
 * 				   Mods to constructor, setters, and getters
 */

@Indexed
public class IndividualCaseCommunications implements java.io.Serializable {

	@DocumentId
	private Integer id;
	
	@IndexedEmbedded
	private IndividualCases individualCase;
	
	@DateBridge(resolution = Resolution.DAY)
	@Field
	private Date communicationDate;
	
	@IndexedEmbedded
	private CommunicationTypes communicationType;
	
	@Field
	private String description;
	
	@Field
	private Float timeSpent;
	
	@Field
	private String importantFlag;
	
	private Contacts createdUser;
	
	@DateBridge(resolution = Resolution.DAY)
	@Field
	private Date createdDateTime;
	
	private Contacts updatedUser;
	
	@DateBridge(resolution = Resolution.DAY)
	@Field
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
	 * @param createdUser
	 * @param createdDateTime
	 * @param updatedUser
	 * @param updatedDateTime
	 */
	public IndividualCaseCommunications(Integer id,
			IndividualCases individualCase, Date communicationDate,
			CommunicationTypes communicationType, String description,
			Float timeSpent, String importantFlag, Contacts createdUser,
			Date createdDateTime, Contacts updatedUser, Date updatedDateTime) {
		this.id = id;
		this.individualCase = individualCase;
		this.communicationDate = communicationDate;
		this.communicationType = communicationType;
		this.description = description;
		this.timeSpent = timeSpent;
		this.importantFlag = importantFlag;
		this.createdUser = createdUser;
		this.createdDateTime = createdDateTime;
		this.updatedUser = updatedUser;
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

	/**
	 * @return the createdUser
	 */
	public Contacts getCreatedUser() {
		return createdUser;
	}

	/**
	 * @param createdUser the createdUser to set
	 */
	public void setCreatedUser(Contacts createdUser) {
		this.createdUser = createdUser;
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
	 * @return the updatedUser
	 */
	public Contacts getUpdatedUser() {
		return updatedUser;
	}

	/**
	 * @param updatedUser the updatedUser to set
	 */
	public void setUpdatedUser(Contacts updatedUser) {
		this.updatedUser = updatedUser;
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
