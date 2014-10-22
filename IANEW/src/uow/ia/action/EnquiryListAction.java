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

import org.apache.lucene.document.DateTools;
import org.hibernate.search.FullTextQuery;

import uow.ia.bean.Contacts;
import uow.ia.bean.Enquiries;
import uow.ia.bean.EnquiryIssues;
import uow.ia.bean.IssueTypes;
import uow.ia.bean.StatusTypes;
import uow.ia.util.DateUtil;
import uow.ia.util.SearchUtil;

import com.opensymphony.xwork2.ModelDriven;

public class EnquiryListAction extends BaseAction implements ModelDriven<List<Enquiries>> {
	private List<Enquiries> iamodelList;
	private String formTitle;
	private final String kEnquiryList = "Enquiry List";
	
	/* For pagination */
	private int page;
	private int numberOfRecords;

	
//	version2
	private String createdDateStart;
	private String createdDateEnd;
	private String updatedDateStart;
	private String updatedDateEnd;
	private String firstName = null;
	private String lastName = null;
	private String searchString = null;
	private String sortField;
	private int startIndex;
	private int recordsPerPage;
	private int currentPage;
	private int totalNumberOfPages;
	private int totalNumberOfRecords;
	private boolean descending;
	
	
	
	
	public String getCreatedDateStart() {
		return createdDateStart;
	}

	public void setCreatedDateStart(String createdDateStart) {
		this.createdDateStart = createdDateStart;
	}

	public String getCreatedDateEnd() {
		return createdDateEnd;
	}

	public void setCreatedDateEnd(String createdDateEnd) {
		this.createdDateEnd = createdDateEnd;
	}

	public String getUpdatedDateStart() {
		return updatedDateStart;
	}

	public void setUpdatedDateStart(String udpatedDateStart) {
		this.updatedDateStart = udpatedDateStart;
	}

	public String getUpdatedDateEnd() {
		return updatedDateEnd;
	}

	public void setUpdatedDateEnd(String updatedDateEnd) {
		this.updatedDateEnd = updatedDateEnd;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSortField() {
		return sortField;
	}

	public void setSortField(String sortField) {
		this.sortField = sortField;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getRecordsPerPage() {
		return recordsPerPage;
	}

	public void setRecordsPerPage(int recordsPerPage) {
		this.recordsPerPage = recordsPerPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public boolean isDescending() {
		return descending;
	}

	public void setDescending(boolean descending) {
		this.descending = descending;
	}

	private List<IssueTypes>issueTypeList  = new ArrayList<IssueTypes>();
	
	private List<StatusTypes> statusSelectList = new ArrayList<StatusTypes>();
	private int theStatus;
	
	
	
	public List<StatusTypes> getStatusSelectList() {
		return statusSelectList;
	}

	public void setStatusSelectList(List<StatusTypes> statusSelectList) {
		this.statusSelectList = statusSelectList;
	}

	public int getTheStatus() {
		return theStatus;
	}

	public void setTheStatus(int theStatus) {
		this.theStatus = theStatus;
	}

	public String getLinkedEnquiriesList() {
		
//		setPage(1);
//		setNumberOfRecords(10);
//		setIamodelList(enquiryService.findEnquiriesByPage(page, numberOfRecords));
//		totalNumberOfRecords = enquiryService.countEnquiries();
//		int mod = (int) totalNumberOfRecords % numberOfRecords;
//		if (mod != 0)
//			mod = 1;
//		totalNumberOfPages = totalNumberOfRecords / numberOfRecords + mod;
		return SUCCESS;
	}

	public String updateLinkedEnquiriesList() {
		System.out.println(getPage());
//		setIamodelList(enquiryService.findEnquiriesByPage(getPage(),
//				getNumberOfRecords()));
//		totalNumberOfRecords = enquiryService.countEnquiries();
//		int mod = (int) totalNumberOfRecords % numberOfRecords;
//		if (mod != 0)
//			mod = 1;
//		totalNumberOfPages = totalNumberOfRecords / numberOfRecords + mod;
		return SUCCESS;
	}

	public String getEnquiryList() {
		SearchUtil service = new SearchUtil();
		
		System.out.println(getSortField());
		statusSelectList = typesService.findStatusTypes(1);
		
		setStartIndex(0);
		setRecordsPerPage(10);
		setCurrentPage(1);
		setDescending(true);
		setSortField("id");
		setFormTitle(kEnquiryList);
		
		searchString = "";
		
		
		FullTextQuery ftq = getFullTextQuery(service);
		ftq = activatePageDetails(service, ftq);
		
		System.out.println("getEnquiryList size: " + ftq.getResultSize());
		
		if(totalNumberOfPages == 0)
			setCurrentPage(0);
		
		iamodelList = (List<Enquiries>) ftq.list();
		return SUCCESS;
	}
	
	public String loadFilterSortResult(){
		System.out.println("in load filter sort search form");
		
		SearchUtil service = new SearchUtil();
		setStartIndex(0);
		setRecordsPerPage(10);
		setCurrentPage(1);
			
		initializeSearchString();
		FullTextQuery ftq = getFullTextQuery(service);
		ftq = activatePageDetails(service, ftq);
		
		if(totalNumberOfPages == 0)
			setCurrentPage(0);
		
		iamodelList = (List<Enquiries>) ftq.list();
		
		System.out.println("End of searchContact");
		return SUCCESS;
	}
	

	public String getNextPage(){
		SearchUtil service = new SearchUtil();
		startIndex = getStartIndex() + getRecordsPerPage();
		
		initializeSearchString();
		FullTextQuery ftq = getFullTextQuery(service);
		activatePageDetails(service, ftq);
		
		if(startIndex <= totalNumberOfRecords){
			
			iamodelList = (List<Enquiries>) ftq.list();
			if(iamodelList.size() > 0)
				currentPage = getCurrentPage() + 1;
		}
		
		return SUCCESS;
	}
	
	public String getPrevPage(){
		SearchUtil service = new SearchUtil();
		startIndex = getStartIndex() - getRecordsPerPage();
		
		initializeSearchString();
		FullTextQuery ftq = getFullTextQuery(service);
		ftq = activatePageDetails(service, ftq);
		
		if(startIndex >= 0){
			
			iamodelList = (List<Enquiries>) ftq.list();
			if(iamodelList.size() > 0)
				currentPage = getCurrentPage() - 1;
		}
		
		return SUCCESS;
	}
	
	public String getPage(){
		SearchUtil service = new SearchUtil();
		startIndex = getRecordsPerPage() * getCurrentPage() - getRecordsPerPage();
		
		initializeSearchString();
		FullTextQuery ftq = getFullTextQuery(service);
		ftq = activatePageDetails(service, ftq);
		
		System.out.println("current page: " + getCurrentPage());
		if(getCurrentPage() > 0 && getCurrentPage() <= totalNumberOfPages){
			iamodelList =(List<Enquiries>) ftq.list();
		}
		return SUCCESS;
	}
	
	public String updateEnquiryList() {
//		System.out.println(getPage());
//		setIamodelList(enquiryService.findEnquiriesByPage(getPage(),
//				getNumberOfRecords()));
//		totalNumberOfRecords = enquiryService.countEnquiries();
//		int mod = (int) totalNumberOfRecords % numberOfRecords;
//		if (mod != 0)
//			mod = 1;
//		totalNumberOfPages = totalNumberOfRecords / numberOfRecords + mod;
		return SUCCESS;
	}

	public String getFormTitle() {
		return formTitle;
	}

	public void setFormTitle(String formTitle) {
		this.formTitle = formTitle;
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
	
	private void initializeSearchString(){
		
		searchString = "";
		//firstname and last name searchString construction
		try{
			if(getFirstName().length() == 0 && getLastName().length() == 0);
			else{
				searchString += "(";
				try{
					if(!getFirstName().isEmpty() || !getFirstName().equals(null)){
						searchString += "contact.firstname:" + getFirstName();
						if(!getFirstName().contains("*"))
							searchString += "*";
					}
				}catch(NullPointerException npe){}
				try{
					
					if(getFirstName().length() > 0 && getLastName().length() > 0)
						searchString += " AND ";
					
				}catch(NullPointerException npe){}
				
				try{
					if(!getLastName().isEmpty() || !getLastName().equals(null)){
						searchString += "contact.lastname:" + getLastName();
						if(!getLastName().contains("*"))
							searchString += "*";
					}
				}catch(NullPointerException npe){}
				searchString += ")";
			}
		}catch(NullPointerException np){}
		
		//created date construction
		//created date start and end - assuming javascript has updated the date fields
		//such that the string either is either empty or has ( * or numbers+*)
		try{
			if((getCreatedDateStart().length() > 0 || getCreatedDateEnd().length() > 0)){
				if(searchString.contains(")") || searchString.contains("]"))
					searchString += " AND ";
			
				
				if(!getCreatedDateStart().isEmpty() || !getCreatedDateStart().equals(null)){
					searchString += "createdDateTime:[" + getCreatedDateStart() + " TO ";
				}
				if(!getCreatedDateEnd().isEmpty() || !getCreatedDateEnd().equals(null)){
					searchString += getCreatedDateEnd() + "]";
				}
				
			}
		}catch(NullPointerException npe){}
		
		//updated date searchstring construction
		try{
			if((getUpdatedDateStart().length() > 0 || getUpdatedDateEnd().length() > 0)){
				if(searchString.contains(")") || searchString.contains("]"))
					searchString += " AND ";
				//created date start and end - assuming javascript has updated the date fields
				//such that the string either is either empty or has ( * or numbers+*)
				
				if(!getUpdatedDateStart().isEmpty() || !getUpdatedDateStart().equals(null)){
					searchString += "updatedDateTime:[" + getUpdatedDateStart() + " TO ";
				}
				if(!getUpdatedDateEnd().isEmpty() || !getUpdatedDateEnd().equals(null)){
					searchString += getUpdatedDateEnd() + "]";
				}
			}
		}catch(NullPointerException npe){}
		
		//status searchstring construction
		if(getTheStatus() != -1 && getTheStatus() != 0){
			if(searchString.length() > 0){
				searchString += " AND statusType.id: " + getTheStatus();
			}else {
				searchString += "statusType.id: " + getTheStatus();
			}
		}
		
		//issues searchstring construction, only support 1 type atm
//		if(getTheIssue() != -1 && getTheIssue() != 0){
//			if(searchString.length() > 0){
//				searchString += " AND enquiryIssuesList"
//			}
//		}
		
//		String createdDateStart = getCreatedDateStart();
//		String milliCreatedDateStart = "0";
//		try{
//			milliCreatedDateStart = DateTools.dateToString(DateUtil.yyyymmddDate(createdDateStart), DateTools.Resolution.MILLISECOND);
//		}catch (Exception e) { }
//		
//		searchString = milliCreatedDateStart;
		System.out.println("searchString: " + searchString);
//		System.out.println("created date: " + createdDateStart);
//		System.out.println(getCreatedDateStart());
	}
		
	
	private FullTextQuery getFullTextQuery(SearchUtil service){
		return service.getFullTextQuery(sortField, searchString, utilService, descending, Enquiries.class);
	}
	
	private FullTextQuery activatePageDetails(SearchUtil service, FullTextQuery ftq){
		System.out.println("Struts: start activatePage searchString is: " + searchString);
		
		
		totalNumberOfRecords = service.getTotalNumberOfRecords(ftq);
		System.out.println("result list size in action class: " + totalNumberOfRecords);
		
		int mod = totalNumberOfRecords % recordsPerPage;
		if (mod != 0)
			mod = 1;
		
		ftq.setFirstResult(getStartIndex());
		ftq.setMaxResults(getRecordsPerPage());
		
		totalNumberOfPages = totalNumberOfRecords / recordsPerPage + mod;
		System.out.println("Struts: end activatePage");
		
		return ftq;
	}
	
	/**
	 * Getter for page
	 * 
	 * @return
	 */
//	public int getPage() {
//		return page;
//	}

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
	public int getTotalNumberOfRecords() {
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
	

	public List<IssueTypes> getIssueTypeList() {
		return issueTypeList;
	}

	public void setIssueTypeList(List<IssueTypes> issueTypeList) {
		this.issueTypeList = issueTypeList;
	}
	
	
	@Override
	public List<Enquiries> getModel() {
		return iamodelList;
	}
}