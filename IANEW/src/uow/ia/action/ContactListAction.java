package uow.ia.action;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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
	private boolean descending;
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

	/**
	 * load an empty contact list search form
	 * @return String
	 */
	public String loadClientSearchResult(){
		System.out.println("in load client search form");
		//searchString = "contactType.id: 2 ";// + getContactType();
		//System.out.println(searchString);
		System.out.println(sortField);
		System.out.println(descending);
		
		//searchString = "firstname: Mo*";
		
		if(!getFirstName().equals("undefined")){
			searchString += "firstname:" + getFirstName();
			if(!getFirstName().contains("*"))
				searchString += "*";
		}
			
		if(!getLastName().equals("undefined")){
			searchString += " lastname:" + getLastName();
			if(!getLastName().contains("*"))
				searchString += "*";
		}
		
		
		if(!getSearchString().isEmpty()){
			System.out.println(searchString);
			SearchUtil service = new SearchUtil()	;
			
			contactList = service.getPage(0, 10, sortField, searchString, utilService, descending, Contacts.class);
			//System.out.println("List: " + list);
		}
		System.out.println("End of searchContact");
		return SUCCESS;
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
