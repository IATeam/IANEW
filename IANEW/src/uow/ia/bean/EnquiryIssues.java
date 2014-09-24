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
 * @version 1.0.3, 29/08/2014
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
	
	@Field
	private Integer createdUserId;
	
	@DateBridge(resolution = Resolution.DAY)
	@Field
	private Date createdDateTime;
	
	@Field
	private Integer updatedUserId;
	
	@DateBridge(resolution = Resolution.DAY)
	@Field
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
	 * @param createdUserId
	 * @param createdDateTime
	 * @param updatedUserId
	 * @param updatedDateTime
	 */
	public EnquiryIssues(Integer id, Enquiries enquiry, IssueTypes issue,
			String comment, Integer createdUserId, Date createdDateTime,
			Integer updatedUserId, Date updatedDateTime) {
		super();
		this.id = id;
		this.enquiry = enquiry;
		this.issue = issue;
		this.comment = comment;
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
