package uow.ia.action;

import java.util.List;

import uow.ia.util.SearchUtil;

public class SearchAction extends BaseAction {
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

	public String search() {		
		list = new SearchUtil().getResultObjectList("Mrs harley Kim", utilService);
		
		return SUCCESS;
	}
}
