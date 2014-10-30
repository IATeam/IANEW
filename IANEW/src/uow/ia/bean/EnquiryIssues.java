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
 */

@Indexed
public class EnquiryIssues implements java.io.Serializable {

	@DocumentId
	private Integer id;
	
	@IndexedEmbedded
	private Enquiries enquiry;
	
	@IndexedEmbedded
	private IssueTypes issue;
	
	@Field
	private String comment;
	
	private Contacts createdUser;
	
	private Date createdDateTime;
	
	private Contacts updatedUser;
	
	private Date updatedDateTime;
	/**
	 * 
	 */
	public EnquiryIssues() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param id
	 * @param enquiry
	 * @param issue
	 * @param comment
	 * @param createdUser
	 * @param createdDateTime
	 * @param updatedUser
	 * @param updatedDateTime
	 */
	public EnquiryIssues(Integer id, Enquiries enquiry, IssueTypes issue,
			String comment, Contacts createdUser, Date createdDateTime,
			Contacts updatedUser, Date updatedDateTime) {
		this.id = id;
		this.enquiry = enquiry;
		this.issue = issue;
		this.comment = comment;
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
	 * @return the enquiry
	 */
	public Enquiries getEnquiry() {
		return this.enquiry;
	}
	/**
	 * @param enquiry the enquiry to set
	 */
	public void setEnquiry(Enquiries enquiry) {
		this.enquiry = enquiry;
	}
	/**
	 * @return the issue
	 */
	public IssueTypes getIssue() {
		return this.issue;
	}
	/**
	 * @param issue the issue to set
	 */
	public void setIssue(IssueTypes issue) {
		this.issue = issue;
	}

	/**
	 * @return the comment
	 */
	public String getComment() {
		return this.comment;
	}
	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
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
