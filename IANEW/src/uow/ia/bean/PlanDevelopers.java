package uow.ia.bean;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

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
 * 		28/09/2014	Change from Integer createdUserId and Integer UpdatedUserId to Contacts createdUser and Contacts updatedUser 
 */

@Indexed
public class PlanDevelopers implements java.io.Serializable {

	@DocumentId
	private Integer id;
	
	@IndexedEmbedded
	private IndividualCases individualCase;
	
	@IndexedEmbedded
	private Contacts contact;
	
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
	public PlanDevelopers() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param individualCase
	 * @param contact
	 * @param createdUser
	 * @param createdDateTime
	 * @param updatedUser
	 * @param updatedDateTime
	 */
	public PlanDevelopers(Integer id, IndividualCases individualCase,
			Contacts contact, Contacts createdUser, Date createdDateTime,
			Contacts updatedUser, Date updatedDateTime) {
		this.id = id;
		this.individualCase = individualCase;
		this.contact = contact;
		this.createdUser = createdUser;
		this.createdDateTime = createdDateTime;
		this.updatedUser = updatedUser;
		this.updatedDateTime = updatedDateTime;
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
