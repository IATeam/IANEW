package uow.ia.bean;

// Generated Aug 9, 2014 1:06:20 PM by Hibernate Tools 4.0.0

import java.util.Date;

/**
 * EnquiriesHistories generated by hbm2java
 */
public class EnquiriesHistories implements java.io.Serializable {

	private Integer id;
	private Date timestamp;
	private String action;
	private int changeOrder;
	private int enquiryId;
	private Integer contactId;
	private Integer enquiryTypeId;
	private Integer statusId;
	private String description;
	private String inquisitor;
	private String referralBy;
	private String referralTo;
	private Integer parentEnquiryId;
	private String outOfCoverageFlag;
	private int createdUserId;

	public EnquiriesHistories() {
	}

	public EnquiriesHistories(String action, int changeOrder, int enquiryId,
			int createdUserId) {
		this.action = action;
		this.changeOrder = changeOrder;
		this.enquiryId = enquiryId;
		this.createdUserId = createdUserId;
	}

	public EnquiriesHistories(String action, int changeOrder, int enquiryId,
			Integer contactId, Integer enquiryTypeId, Integer statusId,
			String description, String inquisitor, String referralBy,
			String referralTo, Integer parentEnquiryId,
			String outOfCoverageFlag, int createdUserId) {
		this.action = action;
		this.changeOrder = changeOrder;
		this.enquiryId = enquiryId;
		this.contactId = contactId;
		this.enquiryTypeId = enquiryTypeId;
		this.statusId = statusId;
		this.description = description;
		this.inquisitor = inquisitor;
		this.referralBy = referralBy;
		this.referralTo = referralTo;
		this.parentEnquiryId = parentEnquiryId;
		this.outOfCoverageFlag = outOfCoverageFlag;
		this.createdUserId = createdUserId;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getTimestamp() {
		return this.timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getAction() {
		return this.action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public int getChangeOrder() {
		return this.changeOrder;
	}

	public void setChangeOrder(int changeOrder) {
		this.changeOrder = changeOrder;
	}

	public int getEnquiryId() {
		return this.enquiryId;
	}

	public void setEnquiryId(int enquiryId) {
		this.enquiryId = enquiryId;
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

	public int getCreatedUserId() {
		return this.createdUserId;
	}

	public void setCreatedUserId(int createdUserId) {
		this.createdUserId = createdUserId;
	}

}
