/**----------------------------------------------------------------------------------------------
	@author: Quang Nhan
	Created Date: 03/10/2014
	==============================================
	Updates:
		
	==============================================	
	Description: This class allows filtering and sorting of lists
------------------------------------------------------------------------------------------------*/

package uow.ia.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FilterSortAction extends BaseAction{
	
	List<String>sortOptionList  = new ArrayList<String>();
	Map<String, String>filterOptionList  = new HashMap<String, String>();
	
	public String execute(){
		populateFilterOptions();
		populateSortOptions();
		
		return SUCCESS;
	}
	
	/**
	 * populate the filter list with different options
	 */
	private void populateFilterOptions(){
		//filterOptionList.put("Status", value) 
		
	}
	
	
	/**
	 * populate the sort list with different options
	 */
	private void populateSortOptions(){
		String createdDate = "Created Date";
		String updatedDate = "Updated Date";
		String firstName = "First Name";
		String lastName = "Last Name";
		String id = "id";
		
		sortOptionList.add(createdDate);
		sortOptionList.add(updatedDate);
		sortOptionList.add(firstName);
		sortOptionList.add(lastName);
		sortOptionList.add(id);
	}

	public List<String> getSortOptionList() {
		return sortOptionList;
	}

	public void setSortOptionList(List<String> sortOptionList) {
		this.sortOptionList = sortOptionList;
	}

	public Map<String, String> getFilterOptionList() {
		return filterOptionList;
	}

	public void setFilterOptionList(Map<String, String> filterOptionList) {
		this.filterOptionList = filterOptionList;
	}
}

