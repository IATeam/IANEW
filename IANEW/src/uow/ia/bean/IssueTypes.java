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
public class IssueTypes implements java.io.Serializable {

	private Integer id;
	private String issueName;
	private String issueDescription;
	private List<EnquiryIssues> enquiryIssuesList = new ArrayList<EnquiryIssues>();
	private List<CaseIssues> caseIssuesList = new ArrayList<CaseIssues>();


	/**
	 * 
	 */
	public IssueTypes() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param issueName
	 * @param issueDescription
	 * @param enquiryIssuesList
	 * @param caseIssuesList
	 */
	public IssueTypes(Integer id, String issueName, String issueDescription,
			List<EnquiryIssues> enquiryIssuesList,
			List<CaseIssues> caseIssuesList) {
		super();
		this.id = id;
		this.issueName = issueName;
		this.issueDescription = issueDescription;
		this.enquiryIssuesList = enquiryIssuesList;
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
	 * @return the issueName
	 */
	public String getIssueName() {
		return this.issueName;
	}

	/**
	 * @param issueName the issueName to set
	 */
	public void setIssueName(String issueName) {
		this.issueName = issueName;
	}

	/**
	 * @return the issueDescription
	 */
	public String getIssueDescription() {
		return this.issueDescription;
	}

	/**
	 * @param issueDescription the issueDescription to set
	 */
	public void setIssueDescription(String issueDescription) {
		this.issueDescription = issueDescription;
	}

	/**
	 * @return the enquiryIssuesList
	 */
	public List<EnquiryIssues> getEnquiryIssuesList() {
		return this.enquiryIssuesList;
	}

	/**
	 * @param enquiryIssuesList the enquiryIssuesList to set
	 */
	public void setEnquiryIssuesList(List<EnquiryIssues> enquiryIssuesList) {
		this.enquiryIssuesList = enquiryIssuesList;
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
