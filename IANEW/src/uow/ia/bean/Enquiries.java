package uow.ia.bean;

// Generated Aug 9, 2014 1:06:20 PM by Hibernate Tools 4.0.0

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.search.annotations.DateBridge;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;
import org.hibernate.search.annotations.Resolution;


/**
 * @author Kim To
 * @version 1.0.5, 28/09/2014
 * 
 * Modification History:
 * 		28/09/2014 - Change from Integer createdUserId and Integer updatedUserId to Contacts createdUser and Contacts updatedUser
 * 					 Change constructor, setters, and getters
 */

@Indexed
public class Enquiries implements java.io.Serializable {

	@DocumentId
	private Integer id;
	
	@IndexedEmbedded
	private Contacts contact;
	
	@IndexedEmbedded
	private EnquiryTypes enquiryType;
	
	@IndexedEmbedded
	private StatusTypes statusType;
	
	@Field
	private String description;
	
	@Field
	private String inquisitor;
	
	@Field
	private String referralBy;
	
	@Field
	private String referralTo;
	
	private Contacts createdUser;
	
	@DateBridge(resolution = Resolution.DAY)
	@Field
	private Date createdDateTime;
	
	private Contacts updatedUser;
	
	@DateBridge(resolution = Resolution.DAY)
	@Field
	private Date updatedDateTime;
	
	private String outOfCoverageFlag;
	
	private List<Enquiries> enquiriesList = new ArrayList<Enquiries>();
	
	private Enquiries parentEnquiry; 
	
	private List<EnquiryIssues> enquiryIssuesList = new ArrayList<EnquiryIssues>();


	/**
	 * 
	 */
	public Enquiries() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param contact
	 * @param enquiryType
	 * @param statusType
	 * @param description
	 * @param inquisitor
	 * @param referralBy
	 * @param referralTo
	 * @param createdUser
	 * @param createdDateTime
	 * @param updatedUser
	 * @param updatedDateTime
	 * @param outOfCoverageFlag
	 * @param enquiriesList
	 * @param parentEnquiry
	 * @param enquiryIssuesList
	 */
	public Enquiries(Integer id, Contacts contact, EnquiryTypes enquiryType,
			StatusTypes statusType, String description, String inquisitor,
			String referralBy, String referralTo, Contacts createdUser,
			Date createdDateTime, Contacts updatedUser, Date updatedDateTime,
			String outOfCoverageFlag, List<Enquiries> enquiriesList,
			Enquiries parentEnquiry, List<EnquiryIssues> enquiryIssuesList) {
		this.id = id;
		this.contact = contact;
		this.enquiryType = enquiryType;
		this.statusType = statusType;
		this.description = description;
		this.inquisitor = inquisitor;
		this.referralBy = referralBy;
		this.referralTo = referralTo;
		this.createdUser = createdUser;
		this.createdDateTime = createdDateTime;
		this.updatedUser = updatedUser;
		this.updatedDateTime = updatedDateTime;
		this.outOfCoverageFlag = outOfCoverageFlag;
		this.enquiriesList = enquiriesList;
		this.parentEnquiry = parentEnquiry;
		this.enquiryIssuesList = enquiryIssuesList;
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
	 * @return the enquiryType
	 */
	public EnquiryTypes getEnquiryType() {
		return this.enquiryType;
	}

	/**
	 * @param enquiryType the enquiryType to set
	 */
	public void setEnquiryType(EnquiryTypes enquiryType) {
		this.enquiryType = enquiryType;
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
	 * @return the description
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
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
	 * @return the inquisitor
	 */
	public String getInquisitor() {
		return this.inquisitor;
	}

	/**
	 * @param inquisitor the inquisitor to set
	 */
	public void setInquisitor(String inquisitor) {
		this.inquisitor = inquisitor;
	}

	/**
	 * @return the referralBy
	 */
	public String getReferralBy() {
		return this.referralBy;
	}

	/**
	 * @param referralBy the referralBy to set
	 */
	public void setReferralBy(String referralBy) {
		this.referralBy = referralBy;
	}

	/**
	 * @return the referralTo
	 */
	public String getReferralTo() {
		return this.referralTo;
	}

	/**
	 * @param referralTo the referralTo to set
	 */
	public void setReferralTo(String referralTo) {
		this.referralTo = referralTo;
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
	 * @return the outOfCoverageFlag
	 */
	public String getOutOfCoverageFlag() {
		return this.outOfCoverageFlag;
	}

	/**
	 * @param outOfCoverageFlag the outOfCoverageFlag to set
	 */
	public void setOutOfCoverageFlag(String outOfCoverageFlag) {
		this.outOfCoverageFlag = outOfCoverageFlag;
	}


	/**
	 * @return the parentEnquiry
	 */
	public Enquiries getParentEnquiry() {
		return this.parentEnquiry;
	}

	/**
	 * @param parentEnquiry the parentEnquiry to set
	 */
	public void setParentEnquiry(Enquiries parentEnquiry) {
		this.parentEnquiry = parentEnquiry;
	}
	
	public List<Enquiries> getEnquiriesList(){
		return this.enquiriesList;
	}
	
	public void setEnquiriesList(List<Enquiries> enquiriesList){
		this.enquiriesList = enquiriesList;
	}
	
	public List<EnquiryIssues> getEnquiryIssuesList(){
		return this.enquiryIssuesList;
	}
	
	public void setEnquiryIssuesList(List<EnquiryIssues> enquiryIssuesList){
		this.enquiryIssuesList = enquiryIssuesList;
	}
	
	/**
	 * @auther ZhiYu Yang
	 * @return String - Issues Types for this Enquiry as a String
	 */
	public String getIssuesTypes() {
		String issuesTypesString="";
		for(EnquiryIssues ei: this.enquiryIssuesList) {
			issuesTypesString += ei.getIssue().getIssueName()+" ";
		}
		issuesTypesString = issuesTypesString.trim();
		return issuesTypesString;
	}
	
	public String getFileNumber() {
		return "E" + this.id;
	}
	
	public String toString(){
		return "Client: " + this.contact.getFirstname() + " " + this.contact.getOthername() + " " + this.contact.getLastname() +
				". Description: " + this.description;
	}
	
	public String entityName(){
		return "Enquiries";
	}

}
