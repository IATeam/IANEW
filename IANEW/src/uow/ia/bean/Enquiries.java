package uow.ia.bean;

// Generated Aug 9, 2014 1:06:20 PM by Hibernate Tools 4.0.0

import java.util.Date;

/**
 * Enquiries generated by hbm2java
 */
public class Enquiries implements java.io.Serializable {

	private Integer id;
	private Integer contactId;
	private Integer enquiryTypeId;
	private Integer statusId;
	private String description;
	private Integer createdUserId;
	private Date createdDateTime;
	private String inquisitor;
	private String referralBy;
	private String referralTo;
	private Date updatedDateTime;
	private Integer updatedUserId;
	private Integer parentEnquiryId;
	private String outOfCoverageFlag;

	public Enquiries() {
	}

	public Enquiries(Integer contactId, Integer enquiryTypeId,
			Integer statusId, String description, Integer createdUserId,
			Date createdDateTime, String inquisitor, String referralBy,
			String referralTo, Date updatedDateTime, Integer updatedUserId,
			Integer parentEnquiryId, String outOfCoverageFlag) {
		this.contactId = contactId;
		this.enquiryTypeId = enquiryTypeId;
		this.statusId = statusId;
		this.description = description;
		this.createdUserId = createdUserId;
		this.createdDateTime = createdDateTime;
		this.inquisitor = inquisitor;
		this.referralBy = referralBy;
		this.referralTo = referralTo;
		this.updatedDateTime = updatedDateTime;
		this.updatedUserId = updatedUserId;
		this.parentEnquiryId = parentEnquiryId;
		this.outOfCoverageFlag = outOfCoverageFlag;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getContactId() {
		return this.contactId;
	}

	public void setContactId(Integer contactId) {
		this.contactId = contactId;
	}

	public Integer getEnquiryTypeId() {
		return this.enquiryTypeId;
	}

	public void setEnquiryTypeId(Integer enquiryTypeId) {
		this.enquiryTypeId = enquiryTypeId;
	}

	public Integer getStatusId() {
		return this.statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getCreatedUserId() {
		return this.createdUserId;
	}

	public void setCreatedUserId(Integer createdUserId) {
		this.createdUserId = createdUserId;
	}

	public Date getCreatedDateTime() {
		return this.createdDateTime;
	}

	public void setCreatedDateTime(Date createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	public String getInquisitor() {
		return this.inquisitor;
	}

	public void setInquisitor(String inquisitor) {
		this.inquisitor = inquisitor;
	}

	public String getReferralBy() {
		return this.referralBy;
	}

	public void setReferralBy(String referralBy) {
		this.referralBy = referralBy;
	}

	public String getReferralTo() {
		return this.referralTo;
	}

	public void setReferralTo(String referralTo) {
		this.referralTo = referralTo;
	}

	public Date getUpdatedDateTime() {
		return this.updatedDateTime;
	}

	public void setUpdatedDateTime(Date updatedDateTime) {
		this.updatedDateTime = updatedDateTime;
	}

	public Integer getUpdatedUserId() {
		return this.updatedUserId;
	}

	public void setUpdatedUserId(Integer updatedUserId) {
		this.updatedUserId = updatedUserId;
	}

	public Integer getParentEnquiryId() {
		return this.parentEnquiryId;
	}

	public void setParentEnquiryId(Integer parentEnquiryId) {
		this.parentEnquiryId = parentEnquiryId;
	}

	public String getOutOfCoverageFlag() {
		return this.outOfCoverageFlag;
	}

	public void setOutOfCoverageFlag(String outOfCoverageFlag) {
		this.outOfCoverageFlag = outOfCoverageFlag;
	}

}
