package uow.ia.bean;

import java.util.Date;

public class ContactEmployments implements java.io.Serializable{
	private Integer id;
	private Contacts contact;
	private EmploymentTypes employmentType;
	private String workphone;
	private String comments;
	private Integer createdUserId;
	private Date createdDateTime;
	private Integer updatedUserId;
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
	 * @param createdUserId
	 * @param createdDateTime
	 * @param updatedUserId
	 * @param updatedDateTime
	 */
	public ContactEmployments(Integer id, Contacts contact,
			EmploymentTypes employmentType, String workphone, String comments,
			Integer createdUserId, Date createdDateTime, Integer updatedUserId,
			Date updatedDateTime) {
		this.id = id;
		this.contact = contact;
		this.employmentType = employmentType;
		this.workphone = workphone;
		this.comments = comments;
		this.createdUserId = createdUserId;
		this.createdDateTime = createdDateTime;
		this.updatedUserId = updatedUserId;
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
