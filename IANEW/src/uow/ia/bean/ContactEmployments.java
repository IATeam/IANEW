package uow.ia.bean;

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
 * 		28/09/2014 - Mods to change Integer createdUserId and Integer updatedUserId to Contacts createdUser and Contacts updatedUser
 * 				   - Mods to constructor, setters and getters
 */
@Indexed
public class ContactEmployments implements java.io.Serializable{
	
	@DocumentId
	private Integer id;
	
	@IndexedEmbedded
	private Contacts contact;
	
	@IndexedEmbedded
	private EmploymentTypes employmentType;
	
	@Field
	private String workphone;
	
	@Field
	private String comments;
	
	private Contacts createdUser;
	
	@DateBridge(resolution = Resolution.DAY)
	@Field
	private Date createdDateTime;
	
	private Contacts updatedUser;
	
	@DateBridge(resolution = Resolution.DAY)
	@Field
	private Date updatedDateTime;
	/**
	 * 
	 */
	public ContactEmployments() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param id
	 * @param contact
	 * @param employmentType
	 * @param workphone
	 * @param comments
	 * @param createdUser
	 * @param createdDateTime
	 * @param updatedUser
	 * @param updatedDateTime
	 */
	public ContactEmployments(Integer id, Contacts contact,
			EmploymentTypes employmentType, String workphone, String comments,
			Contacts createdUser, Date createdDateTime, Contacts updatedUser,
			Date updatedDateTime) {
		this.id = id;
		this.contact = contact;
		this.employmentType = employmentType;
		this.workphone = workphone;
		this.comments = comments;
		this.createdUser = createdUser;
		this.createdDateTime = createdDateTime;
		this.updatedUser = updatedUser;
		this.updatedDateTime = updatedDateTime;
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
	 * @return the employmentType
	 */
	public EmploymentTypes getEmploymentType() {
		return this.employmentType;
	}

	/**
	 * @param employmentType the employmentType to set
	 */
	public void setEmploymentType(EmploymentTypes employmentType) {
		this.employmentType = employmentType;
	}

	/**
	 * @return the workphone
	 */
	public String getWorkphone() {
		return this.workphone;
	}
	/**
	 * @param workphone the workphone to set
	 */
	public void setWorkphone(String workphone) {
		this.workphone = workphone;
	}
	/**
	 * @return the comments
	 */
	public String getComments() {
		return this.comments;
	}
	/**
	 * @param comments the comments to set
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	/**
	 * @return the createdUser
	 */
	public Contacts getCreatedUser() {
		return this.createdUser;
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
		return this.updatedUser;
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
