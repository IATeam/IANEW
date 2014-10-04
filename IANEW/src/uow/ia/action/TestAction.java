package uow.ia.action;

import java.util.ArrayList;
import java.util.List;

import uow.ia.bean.EmploymentTypes;
import uow.ia.bean.Enquiries;
import uow.ia.bean.EnquiryIssues;
import uow.ia.bean.IssueTypes;
import uow.ia.service.EnquiryService;

import com.google.common.util.concurrent.Service;

public class TestAction extends BaseAction{
	
	int id;
	Enquiries iamodel;
	List<EmploymentTypes> employmentSelectList = new ArrayList<EmploymentTypes>();;
	
	int employmentid;
	String employmentName;
	
	
	
	public String getEmploymentName() {
		return employmentName;
	}



	public void setEmploymentName(String employmentName) {
		this.employmentName = employmentName;
	}



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


	



	public List<EmploymentTypes> getEmploymentSelectList() {
		return employmentSelectList;
	}



	public void setEmploymentSelectList(List<EmploymentTypes> employmentSelectList) {
		this.employmentSelectList = employmentSelectList;
	}



	public int getEmploymentid() {
		return employmentid;
	}



	public void setEmploymentid(int employmentid) {
		this.employmentid = employmentid;
	}



	public String execute() {
		System.out.println("id: " + id);
		iamodel = enquiryService.getEnquiry(1);
		System.out.println(iamodel.getId());
		employmentSelectList = typesService.findEmploymentTypes();
		System.out.print(iamodel.getContact().getEmploymentsList().get(0).getEmploymentType().getId()+ "name " + iamodel.getContact().getEmploymentsList().get(0).getWorkphone());
		employmentid = iamodel.getContact().getEmploymentsList().get(0).getEmploymentType().getId();
		
		return SUCCESS;
	}
	
	public String save(){
		System.out.println("employmentid: " + getEmploymentid());
		if(getEmploymentid() != -1)
			iamodel.getContact().getEmploymentsList().get(0).setEmploymentType(typesService.getEmploymentTypeId(getEmploymentid()));
		
		
		if(enquiryService.saveOrUpdateEnquiry(iamodel)){
			System.out.println("Save update successful");
			return SUCCESS;
		}else{
			System.out.println("Eorror save unsuccessful");
			return ERROR;
		}
	}
}
