package uow.ia.action;

import java.util.List;

import uow.ia.bean.Enquiries;
import uow.ia.bean.EnquiryIssues;
import uow.ia.bean.IssueTypes;
import uow.ia.service.EnquiryService;

import com.google.common.util.concurrent.Service;

public class TestAction extends BaseAction{
	
	int id;
	Enquiries iamodel;
	List<EnquiryIssues> issuesSelectList;
	
	int issueid;
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}

	
	


	public Enquiries getIamodel() {
		return iamodel;
	}



	public void setIamodel(Enquiries iamodel) {
		this.iamodel = iamodel;
	}


	

	public List<EnquiryIssues> getIssuesSelectList() {
		return issuesSelectList;
	}



	public void setIssuesSelectList(List<EnquiryIssues> issuesSelectList) {
		this.issuesSelectList = issuesSelectList;
	}



	public int getIssueid() {
		return issueid;
	}



	public void setIssueid(int issueid) {
		this.issueid = issueid;
	}



	public String execute() {
		System.out.println("id: " + id);
		iamodel = enquiryService.getEnquiry(1);
		
		return SUCCESS;
	}
}
