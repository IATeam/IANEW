package uow.ia.bean;

// Generated Aug 9, 2014 1:06:20 PM by Hibernate Tools 4.0.0

/**
 * EnquiryIssues generated by hbm2java
 */
public class EnquiryIssues implements java.io.Serializable {

	private Integer id;
	private Integer enquiryId;
	private Integer issueId;
	private String comment;

	public EnquiryIssues() {
	}

	public EnquiryIssues(Integer enquiryId, Integer issueId, String comment) {
		this.enquiryId = enquiryId;
		this.issueId = issueId;
		this.comment = comment;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getEnquiryId() {
		return this.enquiryId;
	}

	public void setEnquiryId(Integer enquiryId) {
		this.enquiryId = enquiryId;
	}

	public Integer getIssueId() {
		return this.issueId;
	}

	public void setIssueId(Integer issueId) {
		this.issueId = issueId;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
