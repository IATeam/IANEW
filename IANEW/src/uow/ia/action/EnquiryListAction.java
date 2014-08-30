/** ---------------------------------------------------------------------------------------------
 * @author: Quang Nhan
 * Created Date: 29/08/2014
 * ==============================================
 * Updates:
 * ==============================================
 * 	Description: An action class to linking the service from spring to the enquirylist jsp pages
 *
 *----------------------------------------------------------------------------------------------*/

package uow.ia.action;

import java.util.List;

import uow.ia.bean.Enquiries;

import com.opensymphony.xwork2.ModelDriven;

public class EnquiryListAction extends BaseAction{


	List<Enquiries> iamodelList;
	
	
	/* For pagination */
	int page;
	int numberOfRecords;
	long totalNumberOfRecords;
	long totalNumberOfPages;
	
	public String getEnquiryList(){
		setPage(1);
		setNumberOfRecords(10);
		
		setIamodelList(services.findEnquiriesByPage(page,numberOfRecords));
		totalNumberOfRecords = services.countEnquiries();
		int mod = (int) totalNumberOfRecords % numberOfRecords;
		if(mod != 0) mod = 1;
		totalNumberOfPages = totalNumberOfRecords/numberOfRecords + mod;
		return SUCCESS;
	}
	
	
	public String updateEnquiryList(){
		System.out.println(getPage());
		
		setIamodelList(services.findEnquiriesByPage(getPage(),getNumberOfRecords()));
		totalNumberOfRecords = services.countEnquiries();
		int mod = (int) totalNumberOfRecords % numberOfRecords;
		if(mod != 0) mod = 1;
		totalNumberOfPages = totalNumberOfRecords/numberOfRecords + mod;
		return SUCCESS;
	}
	
	public List<Enquiries> getIamodelList() {
		return iamodelList;
	}

	public void setIamodelList(List<Enquiries> iamodList) {
		this.iamodelList = iamodList;
	}

	/*------------------------------------------------Pagination Variables
	 * 
	 */
	
	/**
	 * Getter for page
	 * @return
	 */
	public int getPage() {
		return page;
	}



	/**
	 * Setter for Page
	 * @param page
	 */
	public void setPage(int page) {
		this.page = page;
	}



	/**
	 * Getter for the number of records for display
	 * @return
	 */
	public int getNumberOfRecords() {
		return numberOfRecords;
	}



	/**
	 * Setter for the number of records for display
	 * @param numberOfRecords
	 */
	public void setNumberOfRecords(int numberOfRecords) {
		this.numberOfRecords = numberOfRecords;
	}

	

	/**
	 * Getter for the total number of records
	 * @return
	 */
	public long getTotalNumberOfRecords() {
		return totalNumberOfRecords;
	}



	/**
	 * Setter for the total number of records
	 * @param totalNumberOfRecords
	 */
	public void setTotalNumberOfRecords(int totalNumberOfRecords) {
		this.totalNumberOfRecords = totalNumberOfRecords;
	}



	/**
	 * Getter for the total number of pages
	 * @return
	 */
	public long getTotalNumberOfPages() {
		return totalNumberOfPages;
	}


	/**
	 * Setter for the total number of records
	 * @param totalNumberOfPages
	 */
	public void setTotalNumberOfPages(int totalNumberOfPages) {
		this.totalNumberOfPages = totalNumberOfPages;
	}
	
}
