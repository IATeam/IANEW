package uow.ia.bean;

import java.sql.Date;
import java.util.HashSet;

// Generated Aug 9, 2014 1:06:20 PM by Hibernate Tools 4.0.0

/**
 * @author Kim To
 * @veersion 1.0.3, 29/08/2014
 */
public class ClientDisabilities implements java.io.Serializable {

	private Integer id;
	private Contacts contact;
	private DisabilityTypes disabilityType;
	private String comments;
	private String primaryFlag;
	private Integer createdUserId;
	private Date createdDateTime;
	private Integer updatedUserId;
	private Date updatedDateTime;

	public ClientDisabilities() {
	}

	/**
	 * @param id
	 * @param contact
	 * @param disabilityType
	 * @param comments
	 * @param primaryFlag
	 * @param createdUserId
	 * @param createdDateTime
	 * @param updatedUserId
	 * @param updatedDateTime
	 */
	public ClientDisabilities(Integer id, Contacts contact,
			DisabilityTypes disabilityType, String comments,
			String primaryFlag, Integer createdUserId, Date createdDateTime,
			Integer updatedUserId, Date updatedDateTime) {
		super();
		this.id = id;
		this.contact = contact;
		this.disabilityType = disabilityType;
		this.comments = comments;
		this.primaryFlag = primaryFlag;
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
	 * @return the disabilityType
	 */
	public DisabilityTypes getDisabilityType() {
		return this.disabilityType;
	}

	/**
	 * @param disabilityType the disabilityType to set
	 */
	public void setDisabilityType(DisabilityTypes disabilityType) {
		this.disabilityType = disabilityType;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getPrimaryFlag() {
		return this.primaryFlag;
	}

	public void setPrimaryFlag(String primaryFlag) {
		this.primaryFlag = primaryFlag;
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

}
