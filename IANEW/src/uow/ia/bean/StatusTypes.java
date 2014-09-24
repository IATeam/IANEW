package uow.ia.bean;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

// Generated Aug 9, 2014 1:06:20 PM by Hibernate Tools 4.0.0

/**
 * @author Kim To
 * @version 1.0.4, 31/08/2014
 */

@Indexed
public class StatusTypes implements java.io.Serializable {

	@DocumentId
	private Integer id;
	
	@Field
	private String statusName;
	
	@Field
	private Integer displayOrder;
	
	private List<Enquiries> enquiriesList = new ArrayList<Enquiries>();
	private List<CaseIssues> caseIssuesList = new ArrayList<CaseIssues>();
	
	/**
	 * 
	 */
	public StatusTypes() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param id
	 * @param statusName
	 * @param displayOrder
	 */
	public StatusTypes(Integer id, String statusName, Integer displayOrder) {
		this.id = id;
		this.statusName = statusName;
		this.displayOrder = displayOrder;
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
	 * @return the statusName
	 */
	public String getStatusName() {
		return this.statusName;
	}

	/**
	 * @param statusName the statusName to set
	 */
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	/**
	 * @return the displayOrder
	 */
	public Integer getDisplayOrder() {
		return this.displayOrder;
	}
	/**
	 * @param displayOrder the displayOrder to set
	 */
	public void setDisplayOrder(Integer displayOrder) {
		this.displayOrder = displayOrder;
	}
	/**
	 * @return the enquiriesList
	 */
	public List<Enquiries> getEnquiriesList() {
		return this.enquiriesList;
	}
	/**
	 * @param enquiriesList the enquiriesList to set
	 */
	public void setEnquiriesList(List<Enquiries> enquiriesList) {
		this.enquiriesList = enquiriesList;
	}
	/**
	 * @return the caseIssuesList
	 */
	public List<CaseIssues> getCaseIssuesList() {
		return this.caseIssuesList;
	}
	/**
	 * @param caseIssuesList the caseIssuesList to set
	 */
	public void setCaseIssuesList(List<CaseIssues> caseIssuesList) {
		this.caseIssuesList = caseIssuesList;
	}
}
