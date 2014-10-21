package uow.ia.action;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.struts2.ServletActionContext;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import uow.ia.bean.Contacts;
import uow.ia.bean.Enquiries;
import uow.ia.service.UtilService;
import uow.ia.util.SearchUtil;

public class ContactListAction extends BaseAction{

	private String firstName = null;
	private String lastName = null;
	private String searchString = null;
	private String contactType;
	private String sortField;
	private int startIndex;
	private int recordsPerPage;
	private int currentPage;
	private int totalNumberOfPages;
	private int totalNumberOfRecords;
	private boolean descending;
	private String search; // used by plan to search for support or authorised
	/**
	 * @return the totalNumberOfRecords
	 */
	public int getTotalNumberOfRecords() {
		return totalNumberOfRecords;
	}

	/**
	 * @param totalNumberOfRecords the totalNumberOfRecords to set
	 */
	public void setTotalNumberOfRecords(int totalNumberOfRecords) {
		this.totalNumberOfRecords = totalNumberOfRecords;
	}

	/**
	 * @return the search
	 */
	public String getSearch() {
		return search;
	}

	/**
	 * @param search the search to set
	 */
	public void setSearch(String search) {
		this.search = search;
	}

	private List<Contacts> contactList = null;
	
	@Resource
	protected UtilService utilService;
	
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

	public String getContactType() {
		return contactType;
	}

	public void setContactType(String contactType) {
		this.contactType = contactType;
	}

	public String getSearchString() {
		return searchString;
	}

	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}

	
	public String getSortField() {
		return sortField;
	}

	public void setSortField(String sortField) {
		this.sortField = sortField;
	}

	

	public List<Contacts> getContactList() {
		return contactList;
	}

	public void setContactList(List<Contacts> contactList) {
		this.contactList = contactList;
	}

	public boolean isDescending() {
		return descending;
	}

	public void setDescending(boolean descending) {
		this.descending = descending;
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

	public int getTotalNumberOfPages() {
		return totalNumberOfPages;
	}

	public void setTotalNumberOfPages(int totalNumberOfPages) {
		this.totalNumberOfPages = totalNumberOfPages;
	}
	
	

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	/**
	 * load an empty contact list search form
	 * @return String
	 */
	public String loadClientSearchResult(){
		System.out.println("in load client search form");
		
		SearchUtil service = new SearchUtil();
		setStartIndex(0);
		setRecordsPerPage(10);
		setCurrentPage(1);
			
		//need to check the size of contactlist
		
		initializeSearchString();
		contactList = getContactListResult(service);
		activatePageDetails(service);
		
		if(totalNumberOfPages == 0)
			setCurrentPage(0);
		
		if (search != null)
			return "plan";
		else
			return SUCCESS;
	}
	
	public String getNextPage(){
		SearchUtil service = new SearchUtil();
		startIndex = getStartIndex() + getRecordsPerPage();
		
		initializeSearchString();
		activatePageDetails(service);
		
		if(startIndex <= totalNumberOfRecords){
			contactList = getContactListResult(service);
			currentPage = getCurrentPage() + 1;
		}
		
		if (search != null) 
			return "plan";
		else 
			return SUCCESS;
	}
	
	public String getPrevPage(){
		SearchUtil service = new SearchUtil();
		startIndex = getStartIndex() - getRecordsPerPage();
		
		initializeSearchString();
		activatePageDetails(service);
		
		if(startIndex >= 0){
			contactList = getContactListResult(service);
			currentPage = getCurrentPage() - 1;
		}
		
		if (search != null)
			return "plan";
		else
			return SUCCESS;
	}
	
	public String getPage(){
		SearchUtil service = new SearchUtil();
		
		initializeSearchString();
		activatePageDetails(service);
		
		if(getCurrentPage() > 0 && getCurrentPage() <= totalNumberOfPages){
			startIndex = getRecordsPerPage() * getCurrentPage();
			contactList = getContactListResult(service);
		}
		
		if (search != null)
			return "plan";
		else
			return SUCCESS;
	}
	
	private void initializeSearchString(){
		searchString = "(";
		
		try{
			if(!getFirstName().isEmpty() || !getFirstName().equals(null)){
				searchString += "firstname:" + getFirstName();
				if(!getFirstName().contains("*"))
					searchString += "*";
			}
		}catch(NullPointerException npe){}
			
		try{
			if(!getLastName().isEmpty() || !getLastName().equals(null)){
				searchString += " AND lastname:" + getLastName();
				if(!getLastName().contains("*"))
					searchString += "*";
			}
		}catch(NullPointerException npe){}
		
		if (getSearch() != null) {
			searchString +=")";
		} else {
			searchString += ") AND contactType.id:2";
		}
	}
	
	private List<Contacts> getContactListResult(SearchUtil service){
		
		List<Contacts> resultList = new ArrayList<Contacts>();
		
		if(!getSearchString().isEmpty()){
			
			resultList = service.getPage(startIndex, recordsPerPage, sortField, searchString, utilService, descending, Contacts.class);
		}
		return resultList;
	}
	
	private void activatePageDetails(SearchUtil service){
		
		totalNumberOfRecords = service.getTotalNumberOfRecords(sortField, searchString, utilService, descending, Contacts.class);
		
		
		int mod = totalNumberOfRecords % recordsPerPage;
		if (mod != 0)
			mod = 1;
		totalNumberOfPages = totalNumberOfRecords / recordsPerPage + mod;
	}
	
	public void something() throws Exception{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		//String path = "ianewPathDictionary.xml";
		
		//ApplicationContext appContext;
		//appContext.getResource("classpath:uow/ia/search/ianewPathDictionary.xml");
		//InputStream is = 
		//InputStream path = new FileInputStream(ServletActionContext.getServletContext().getRealPath("ianewPathDictionary.xml"));
		
		
		//Document doc = builder.parse(path);
		
	}
}
