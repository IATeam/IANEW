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
 * @version 1.0.2, 29/08/2014
 */

@Indexed
public class CaseIssues implements java.io.Serializable {
	
	@DocumentId
	private Integer id;
	
	@IndexedEmbedded
	private IndividualCases individualCase;
	
	@IndexedEmbedded
	private IssueTypes issue;
	
	@Field
	private String comments;
	
	@IndexedEmbedded
	private StatusTypes statusType;
	
	@DateBridge(resolution = Resolution.DAY)
	@Field
	private Date completedDate;
	
	@DateBridge(resolution = Resolution.DAY)
	@Field
	private Date createdDateTime;
	
	//@Field
	private Integer createdUserId;
	
	@DateBridge(resolution = Resolution.DAY)
	@Field
	private Date updatedDateTime;
	
	//@Field
	private Integer updatedUserId;

	public CaseIssues() {
	}
	/**
	 * @param id
	 * @param individualCase
	 * @param issue
	 * @param comments
	 * @param statusType
	 * @param completedDate
	 * @param createdDateTime
	 * @param createdUserId
	 * @param updatedDateTime
	 * @param udpatedUserId
	 */
	public CaseIssues(Integer id, IndividualCases individualCase,
			IssueTypes issue, String comments, StatusTypes statusType,
			Date completedDate, Date createdDateTime, Integer createdUserId,
			Date updatedDateTime, Integer updatedUserId) {
		super();
		this.id = id;
		this.individualCase = individualCase;
		this.issue = issue;
		this.comments = comments;
		this.statusType = statusType;
		this.completedDate = completedDate;
		this.createdDateTime = createdDateTime;
		this.createdUserId = createdUserId;
		this.updatedDateTime = updatedDateTime;
		this.updatedUserId = updatedUserId;
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


	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
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


	public Date getCompletedDate() {
		return this.completedDate;
	}

	public void setCompletedDate(Date completedDate) {
		this.completedDate = completedDate;
	}


	public Integer getCreatedUserId() {
		return this.createdUserId;
	}

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
	 * @return the udpatedUserId
	 */
	public Integer getUpdatedUserId() {
		return this.updatedUserId;
	}
	/**
	 * @param udpatedUserId the udpatedUserId to set
	 */
	public void setUpdatedUserId(Integer updatedUserId) {
		this.updatedUserId = updatedUserId;
	}

}
