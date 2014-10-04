package uow.ia.bean;

import java.sql.Date;
import java.util.HashSet;

import org.hibernate.search.annotations.DateBridge;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;
import org.hibernate.search.annotations.Resolution;

// Generated Aug 9, 2014 1:06:20 PM by Hibernate Tools 4.0.0

/**
 * @author Kim To
 * @version 1.0.4, 28/09/2014
 * 
 * Modification History:
 * 		28/09/2014
 * 			Change Integer createdUserId and Integer updatedUserId to Contacts
 * 			Mods to construtor, setters, and getters.
 */
@Indexed
public class ClientDisabilities implements java.io.Serializable {

	@DocumentId
	private Integer id;
	
	@IndexedEmbedded
	private Contacts contact;
	
	@IndexedEmbedded
	private DisabilityTypes disabilityType;
	
	@Field
	private String comments;
	
	private String primaryFlag;
	
	private Contacts createdUser;
	
	private Date createdDateTime;
	
	private Contacts updatedUser;
	
	private Date updatedDateTime;

	public ClientDisabilities() {
	}

	/**
	 * @param id
	 * @param contact
	 * @param disabilityType
	 * @param comments
	 * @param primaryFlag
	 * @param createdUser
	 * @param createdDateTime
	 * @param updatedUser
	 * @param updatedDateTime
	 */
	public ClientDisabilities(Integer id, Contacts contact,
			DisabilityTypes disabilityType, String comments,
			String primaryFlag, Contacts createdUser, Date createdDateTime,
			Contacts updatedUser, Date updatedDateTime) {
		this.id = id;
		this.contact = contact;
		this.disabilityType = disabilityType;
		this.comments = comments;
		this.primaryFlag = primaryFlag;
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
