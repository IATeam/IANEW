package uow.ia.bean;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Generated Aug 9, 2014 1:06:20 PM by Hibernate Tools 4.0.0

/**
 * @author Kim To
 * @version 1.0.3, 30/08/2014
 */
public class StatusTypes implements java.io.Serializable {

	private Integer id;
	private String statusName;
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
	 * @param enquiriesList
	 * @param caseIssuesList
	 */
	public StatusTypes(Integer id, String statusName,
			List<Enquiries> enquiriesList, List<CaseIssues> caseIssuesList) {
		super();
		this.id = id;
		this.statusName = statusName;
		this.enquiriesList = enquiriesList;
		this.caseIssuesList = caseIssuesList;
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
