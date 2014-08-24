package uow.ia.action;

import uow.ia.bean.DisabilityTypes;


/**
 * @author Quang
 * 
 */
public class AdminAction extends BaseAction{
	
	private DisabilityTypes disabilityType;
	private String disabilityName;
	private String disabilityDescription;
	
	public String getDisabilityTypeForm(){
		return SUCCESS;
	}
	
	public String saveNewDisabilityType(){
		disabilityType.setDisabilityName(getDisabilityName());
		disabilityType.setDisabilityDescription(getDisabilityDescription());
		
		adminService.saveDisabilityType(disabilityType);
		return SUCCESS;
	}

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

	
}
