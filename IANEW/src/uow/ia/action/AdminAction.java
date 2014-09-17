package uow.ia.action;



import uow.ia.bean.DisabilityTypes;
import uow.ia.bean.IssueTypes;

import java.util.List;

/**
 * @author Quang
 * 
 * 25/08/2014 -	Quang Nhan
 * 				Updated Disability Type methods to integrate enquiryService
 * 				
 */
public class AdminAction extends BaseAction{
	
	
	/* 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * ----------------------------------------------------------------------------------------------------------
	 * ----------------------------------------------------------------------------------------------------------
	 * Disability Type Fields & Methods
	 * ----------------------------------------------------------------------------------------------------------
	 * ----------------------------------------------------------------------------------------------------------*/
	
	private DisabilityTypes disabilityType;
	private String disabilityName;
	private String disabilityDescription;
	
	 /* ----------------------------------------------------------------------------------------------------------
	 * Disability Type ActionMethods
	 * ----------------------------------------------------------------------------------------------------------
	 */
	public String getDisabilityTypeForm(){
		return SUCCESS;
	}
	
	public String saveNewDisabilityType(){
		List<DisabilityTypes> disabilityTypeList = adminService.findDisabilityTypes();
		boolean exists = false;
		
		for(DisabilityTypes dt: disabilityTypeList){
			if(getDisabilityName().equals(dt.getDisabilityName())){
				exists = true;
				break;
			}
		}
		
		if(exists){
			//asks the user to renter again.
			return INPUT;
		}
		System.out.println("in saving distype");
		disabilityType = new DisabilityTypes();
		disabilityType.setDisabilityName(getDisabilityName());
		disabilityType.setDisabilityDescription(getDisabilityDescription());
		System.out.println("name: " + getDisabilityName());
		System.out.println("description: " + getDisabilityDescription());
		if(adminService.saveDisabilityType(disabilityType))
			return SUCCESS;
		else {
			return ERROR;
		}
	}
	
	public String updateDisabilityType(){
		//adminService.updateDisabilityType(disabilityType);
		return SUCCESS;
	}
	/* ----------------------------------------------------------------------------------------------------------
	 * Disability Getters & Setters
	 * ----------------------------------------------------------------------------------------------------------
	 */
	public String getDisabilityName() {
		return disabilityName;
	}

	public void setDisabilityName(String disabilityName) {
		this.disabilityName = disabilityName;
	}

	public String getDisabilityDescription() {
		return disabilityDescription;
	}

	public void setDisabilityDescription(String disabilityDescription) {
		this.disabilityDescription = disabilityDescription;
	}

	/* 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * ----------------------------------------------------------------------------------------------------------
	 * ----------------------------------------------------------------------------------------------------------
	 * Issues Type Fields & Methods
	 * ----------------------------------------------------------------------------------------------------------
	 * ----------------------------------------------------------------------------------------------------------*/
	
	private IssueTypes issueType;
	private String issueName;
	private String issueDescription;
	
	 /* ----------------------------------------------------------------------------------------------------------
	 * Issues Type ActionMethods
	 * ----------------------------------------------------------------------------------------------------------
	 */
	public String getIssueTypeForm(){
		return SUCCESS;
	}
	
	public String saveNewIssueType(){
		List<DisabilityTypes> disabilityTypeList = adminService.findDisabilityTypes();
		boolean exists = false;
		
		for(DisabilityTypes dt: disabilityTypeList){
			if(getDisabilityName().equals(dt.getDisabilityName())){
				exists = true;
				break;
			}
		}
		
		if(exists){
			return ERROR;
		}
		System.out.println("in saving issueType");
		issueType = new IssueTypes();
		issueType.setIssueName(getIssueName());
		issueType.setIssueDescription(getIssueDescription());
		System.out.println("name: " + getIssueName());
		System.out.println("description: " + getIssueDescription());
		
		//adminService.saveIssueType(issueType);
		return SUCCESS;
	}
	/* ----------------------------------------------------------------------------------------------------------
	 * Disability Getters & Setters
	 * ----------------------------------------------------------------------------------------------------------
	 */
	public String getIssueName() {
		return issueName;
	}

	public void setIssueName(String issueName) {
		this.issueName = issueName;
	}

	public String getIssueDescription() {
		return issueDescription;
	}

	public void setIssueDescription(String issueDescription) {
		this.issueDescription = issueDescription;
	}
	
}
