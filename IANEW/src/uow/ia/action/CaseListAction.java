package uow.ia.action;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.search.FullTextQuery;

import uow.ia.bean.IndividualCases;
import uow.ia.bean.IssueTypes;
import uow.ia.bean.StatusTypes;
import uow.ia.util.SearchUtil;

import com.opensymphony.xwork2.ModelDriven;

public class CaseListAction extends BaseAction implements ModelDriven<List<IndividualCases>>{

	private List<IndividualCases> iamodelList;
	private String formTitle;
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
	

	private List<IssueTypes>issueTypeList  = new ArrayList<IssueTypes>();
	
	private List<StatusTypes> statusSelectList = new ArrayList<StatusTypes>();
	private int theStatus;
	
	
	public String getCaseList() {
		SearchUtil service = new SearchUtil();
		
		System.out.println("case list");
		statusSelectList = typesService.findStatusTypes(2);
		
		setStartIndex(0);
		setRecordsPerPage(10);
		setCurrentPage(1);
		setDescending(false);
		setSortField("id");
		
		searchString = "";
		
		
		FullTextQuery ftq = getFullTextQuery(service);
		ftq = activatePageDetails(service, ftq);
		
		System.out.println("getEnquiryList size: " + ftq.getResultSize());
		
		if(totalNumberOfPages == 0)
			setCurrentPage(0);
		
		iamodelList = (List<IndividualCases>) ftq.list();
		return SUCCESS;
	}
	
	public String loadFilterSortResult(){
		SearchUtil service = new SearchUtil();
		setStartIndex(0);
		setRecordsPerPage(10);
		setCurrentPage(1);
			
		initializeSearchString();
		FullTextQuery ftq = getFullTextQuery(service);
		ftq = activatePageDetails(service, ftq);
		
		if(totalNumberOfPages == 0)
			setCurrentPage(0);
		
		iamodelList = (List<IndividualCases>) ftq.list();
		
		return SUCCESS;
	}
	
	public String getNextPage(){
		SearchUtil service = new SearchUtil();
		startIndex = getStartIndex() + getRecordsPerPage();
		
		initializeSearchString();
		FullTextQuery ftq = getFullTextQuery(service);
		activatePageDetails(service, ftq);
		
		if(startIndex <= totalNumberOfRecords){
			
			iamodelList = (List<IndividualCases>) ftq.list();
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
			
			iamodelList = (List<IndividualCases>) ftq.list();
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
			iamodelList =(List<IndividualCases>) ftq.list();
		}
		return SUCCESS;
	}
	
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
		return service.getFullTextQuery(sortField, searchString, utilService, descending, IndividualCases.class);
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
	 * @return the formTitle
	 */
	public String getFormTitle() {
		return formTitle;
	}

	/**
	 * @param formTitle the formTitle to set
	 */
	public void setFormTitle(String formTitle) {
		this.formTitle = formTitle;
	}

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
	
	public int getTotalNumberOfPages() {
		return totalNumberOfPages;
	}

	public void setTotalNumberOfPages(int totalNumberOfPages) {
		this.totalNumberOfPages = totalNumberOfPages;
	}

	@Override
	public List<IndividualCases> getModel() {
		return iamodelList;
	}


}
