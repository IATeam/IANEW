package uow.ia.bean;

// Generated Aug 9, 2014 1:06:20 PM by Hibernate Tools 4.0.0

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.search.annotations.DateBridge;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;
import org.hibernate.search.annotations.Resolution;

/**
 * Bean class of Plans
 * 
 * @author Kim To
 * @version 1.0.4, 28/09/2014
 * 
 * Modification History:
 * 		28/09/2014	Change from Integer to Contacts for createdUser and updatedUser
 */

@Indexed
public class Plans implements java.io.Serializable {

	@DocumentId
	private Integer id;
	
	@IndexedEmbedded
	private StatusTypes statusType;
	
	private Date closedDateTime;
	
	private Date lastReviewedDate;
	
	@IndexedEmbedded
	private ReviewFrequencies reviewFrequency;
	
	private Date providedPlanDate;
	
	private Date consentSignedDate;
	
	@IndexedEmbedded
	private Contacts supportPerson;
	
	@IndexedEmbedded
	private Contacts authorisedBy;
	
	private Date authorisedByDate;
	
	@Field
	private String notes;
	
	private Contacts createdUser;
	
	private Date createdDateTime;
	
	private Contacts updatedUser;
	
	private Date updatedDateTime;
	
	private IndividualCases individualCase;

	/**
	 * 
	 */
	public Plans() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param statusType
	 * @param closedDateTime
	 * @param lastReviewedDate
	 * @param reviewFrequency
	 * @param providedPlanDate
	 * @param consentSignedDate
	 * @param supportPerson
	 * @param authorisedBy
	 * @param authorisedByDate
	 * @param notes
	 * @param createdUser
	 * @param createdDateTime
	 * @param updatedUser
	 * @param updatedDateTime
	 * @param individualCase
	 */
	public Plans(Integer id, StatusTypes statusType, Date closedDateTime,
			Date lastReviewedDate, ReviewFrequencies reviewFrequency,
			Date providedPlanDate, Date consentSignedDate,
			Contacts supportPerson, Contacts authorisedBy,
			Date authorisedByDate, String notes, Contacts createdUser,
			Date createdDateTime, Contacts updatedUser, Date updatedDateTime,
			IndividualCases individualCase) {
		this.id = id;
		this.statusType = statusType;
		this.closedDateTime = closedDateTime;
		this.lastReviewedDate = lastReviewedDate;
		this.reviewFrequency = reviewFrequency;
		this.providedPlanDate = providedPlanDate;
		this.consentSignedDate = consentSignedDate;
		this.supportPerson = supportPerson;
		this.authorisedBy = authorisedBy;
		this.authorisedByDate = authorisedByDate;
		this.notes = notes;
		this.createdUser = createdUser;
		this.createdDateTime = createdDateTime;
		this.updatedUser = updatedUser;
		this.updatedDateTime = updatedDateTime;
		this.individualCase = individualCase;
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
	 * @return the statusType
	 */
	public StatusTypes getStatusType() {
		return this.statusType;
	}
	/**
	 * @param statusType the statusType to set
	 */
	public void setStatusType(StatusTypes statusType) {
		this.statusType = statusType;
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
	 * @return the closedDateTime
	 */
	public Date getClosedDateTime() {
		return this.closedDateTime;
	}
	/**
	 * @param closedDateTime the closedDateTime to set
	 */
	public void setClosedDateTime(Date closedDateTime) {
		this.closedDateTime = closedDateTime;
	}
	/**
	 * @return the lastReviewedDate
	 */
	public Date getLastReviewedDate() {
		return this.lastReviewedDate;
	}
	/**
	 * @param lastReviewedDate the lastReviewedDate to set
	 */
	public void setLastReviewedDate(Date lastReviewedDate) {
		this.lastReviewedDate = lastReviewedDate;
	}
	/**
	 * @return the reviewFrequency
	 */
	public ReviewFrequencies getReviewFrequency() {
		return this.reviewFrequency;
	}
	/**
	 * @param reviewFrequency the reviewFrequency to set
	 */
	public void setReviewFrequency(ReviewFrequencies reviewFrequency) {
		this.reviewFrequency = reviewFrequency;
	}
	/**
	 * @return the providedPlanDate
	 */
	public Date getProvidedPlanDate() {
		return this.providedPlanDate;
	}
	/**
	 * @param providedPlanDate the providedPlanDate to set
	 */
	public void setProvidedPlanDate(Date providedPlanDate) {
		this.providedPlanDate = providedPlanDate;
	}
	/**
	 * @return the consentSignedDate
	 */
	public Date getConsentSignedDate() {
		return this.consentSignedDate;
	}
	/**
	 * @param consentSignedDate the consentSignedDate to set
	 */
	public void setConsentSignedDate(Date consentSignedDate) {
		this.consentSignedDate = consentSignedDate;
	}
	/**
	 * @return the supportPerson
	 */
	public Contacts getSupportPerson() {
		return this.supportPerson;
	}
	/**
	 * @param supportPerson the supportPerson to set
	 */
	public void setSupportPerson(Contacts supportPerson) {
		this.supportPerson = supportPerson;
	}
	/**
	 * @return the authorisedBy
	 */
	public Contacts getAuthorisedBy() {
		return this.authorisedBy;
	}
	/**
	 * @param authorisedBy the authorisedBy to set
	 */
	public void setAuthorisedBy(Contacts authorisedBy) {
		this.authorisedBy = authorisedBy;
	}
	/**
	 * @return the authorisedByDate
	 */
	public Date getAuthorisedByDate() {
		return this.authorisedByDate;
	}
	/**
	 * @param authorisedByDate the authorisedByDate to set
	 */
	public void setAuthorisedByDate(Date authorisedByDate) {
		this.authorisedByDate = authorisedByDate;
	}
	/**
	 * @return the notes
	 */
	public String getNotes() {
		return this.notes;
	}
	/**
	 * @param notes the notes to set
	 */
	public void setNotes(String notes) {
		this.notes = notes;
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

}
