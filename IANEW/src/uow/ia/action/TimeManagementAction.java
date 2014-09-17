package uow.ia.action;

import java.util.List;

import uow.ia.util.SearchUtil;

public class TimeManagementAction extends BaseAction{
	
private List list = null;
	
	/**
	 * @return the list
	 */
	public List getList() {
		return list;
	}

	/**
	 * @param list the list to set
	 */
	public void setList(List list) {
		this.list = list;
	}

	public String displayResults() {
		
		list = new SearchUtil().getResultObjectList("Mrs harley Kim", utilService);
		
		return SUCCESS;
	}
	
	public String timeManagement(){
		return displayResults();
	}
}
