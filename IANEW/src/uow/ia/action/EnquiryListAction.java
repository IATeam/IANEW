/** ---------------------------------------------------------------------------------------------
 * @author: Quang Nhan
 * Created Date: 29/08/2014
 * ==============================================
 * Updates:
 * 02/08/2014 - Quang Nhan
 * Provide methods for linked enquiries
 * ==============================================
 * Description: An action class to linking the service from spring to the enquirylist jsp pages
 *
 *----------------------------------------------------------------------------------------------*/
package uow.ia.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import uow.ia.bean.Enquiries;

import com.opensymphony.xwork2.ModelDriven;

public class EnquiryListAction extends BaseAction implements ModelDriven<List<Enquiries>> {
	private List<Enquiries> iamodelList;
	private String formTitle;
	private String formType;


	/* For pagination */
	private int page;
	private int numberOfRecords;
	private long totalNumberOfRecords;
	private long totalNumberOfPages;

	/* For Filter & Sort */
	private List<String>sortOptionList  = new ArrayList<String>();
	private Map<String, String>filterOptionList  = new HashMap<String, String>();
	
	
	public String getLinkedEnquiriesList() {
		
		setPage(1);
		setNumberOfRecords(10);
		setIamodelList(enquiryService.findEnquiriesByPage(page, numberOfRecords));
		totalNumberOfRecords = enquiryService.countEnquiries();
		int mod = (int) totalNumberOfRecords % numberOfRecords;
		if (mod != 0)
			mod = 1;
		totalNumberOfPages = totalNumberOfRecords / numberOfRecords + mod;
		return SUCCESS;
	}

	public String updateLinkedEnquiriesList() {
		System.out.println(getPage());
		setIamodelList(enquiryService.findEnquiriesByPage(getPage(),
				getNumberOfRecords()));
		totalNumberOfRecords = enquiryService.countEnquiries();
		int mod = (int) totalNumberOfRecords % numberOfRecords;
		if (mod != 0)
			mod = 1;
		totalNumberOfPages = totalNumberOfRecords / numberOfRecords + mod;
		return SUCCESS;
	}

	public String getEnquiryList() {
		setPage(1);
		setNumberOfRecords(10);
		setIamodelList(enquiryService
				.findEnquiriesByPage(page, numberOfRecords));
		totalNumberOfRecords = enquiryService.countEnquiries();
		int mod = (int) totalNumberOfRecords % numberOfRecords;
		if (mod != 0)
			mod = 1;
		totalNumberOfPages = totalNumberOfRecords / numberOfRecords + mod;
		return SUCCESS;
	}

	public String updateEnquiryList() {
		System.out.println(getPage());
		setIamodelList(enquiryService.findEnquiriesByPage(getPage(),
				getNumberOfRecords()));
		totalNumberOfRecords = enquiryService.countEnquiries();
		int mod = (int) totalNumberOfRecords % numberOfRecords;
		if (mod != 0)
			mod = 1;
		totalNumberOfPages = totalNumberOfRecords / numberOfRecords + mod;
		return SUCCESS;
	}

	public String getFormTitle() {
		return formTitle;
	}

	public void setFormTitle(String formTitle) {
		this.formTitle = formTitle;
	}
	
	/**
	 * @return the formType
	 */
	public String getFormType() {
		return formType;
	}

	/**
	 * @param formType the formType to set
	 */
	public void setFormType(String formType) {
		this.formType = formType;
	}

	public List<Enquiries> getIamodelList() {
		return iamodelList;
	}

	public void setIamodelList(List<Enquiries> iamodList) {
		this.iamodelList = iamodList;
	}

	/*------------------------------------------------Pagination methods, setters & getters
	 *
	 */
	/**
	 * Getter for page
	 * 
	 * @return
	 */
	public int getPage() {
		return page;
	}

	/**
	 * Setter for Page
	 * 
	 * @param page
	 */
	public void setPage(int page) {
		this.page = page;
	}

	/**
	 * Getter for the number of records for display
	 * 
	 * @return
	 */
	public int getNumberOfRecords() {
		return numberOfRecords;
	}

	/**
	 * Setter for the number of records for display
	 * 
	 * @param numberOfRecords
	 */
	public void setNumberOfRecords(int numberOfRecords) {
		this.numberOfRecords = numberOfRecords;
	}

	/**
	 * Getter for the total number of records
	 * 
	 * @return
	 */
	public long getTotalNumberOfRecords() {
		return totalNumberOfRecords;
	}

	/**
	 * Setter for the total number of records
	 * 
	 * @param totalNumberOfRecords
	 */
	public void setTotalNumberOfRecords(int totalNumberOfRecords) {
		this.totalNumberOfRecords = totalNumberOfRecords;
	}

	/**
	 * Getter for the total number of pages
	 * 
	 * @return
	 */
	public long getTotalNumberOfPages() {
		return totalNumberOfPages;
	}

	/**
	 * Setter for the total number of records
	 * 
	 * @param totalNumberOfPages
	 */
	public void setTotalNumberOfPages(int totalNumberOfPages) {
		this.totalNumberOfPages = totalNumberOfPages;
	}

	/*------------------------------------------------Filter & Sorts methods, setters & getters
	 *
	 */
	/**
	 * populate the filter list with different options
	 */
	private void populateFilterOptions(){
		//filterOptionList.put("Status", value) 
		//Map<String, String> 
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
	
	
	@Override
	public List<Enquiries> getModel() {
		// TODO Auto-generated method stub
		return iamodelList;
	}
}