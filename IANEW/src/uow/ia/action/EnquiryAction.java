	package uow.ia.action;


import java.sql.SQLData;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.converters.SqlDateConverter;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

import uow.ia.bean.AccommodationTypes;
import uow.ia.bean.Addresses;
import uow.ia.bean.ClientDisabilities;
import uow.ia.bean.ContactEmployments;
import uow.ia.bean.Contacts;
import uow.ia.bean.CulturalBackgroundTypes;
import uow.ia.bean.DangerTypes;
import uow.ia.bean.DisabilityTypes;
import uow.ia.bean.EmploymentTypes;
import uow.ia.bean.Enquiries;
import uow.ia.bean.EnquiryIssues;
import uow.ia.bean.EnquiryTypes;
import uow.ia.bean.GenderTypes;
import uow.ia.bean.IndividualCases;
import uow.ia.bean.IssueTypes;
import uow.ia.bean.StatusTypes;
import uow.ia.bean.TitleTypes;
import uow.ia.bean.Users;
import uow.ia.reflection.Reflection;
import uow.ia.util.DateUtil;

/** ---------------------------------------------------------------------------------------------
 * @author: Quang Nhan
 * Created Date: 27/07/2014
 * ==============================================
 * Updates:
 * 12/08/2014 - 	Quang Nhan
 * 					Migrate code into new project setup
 * 14/08/2014 	- 	Quang Nhan
 * 					Connect and retrieve data from service class to enquiry, enquirylist jsps and a
 * 					dded pagination functionality
 * 16/08/2014 -		Quang Nhan
 * 					Refactor the code
 * 21/08/2014 -		Quang Nhan
 * 					populate today's date for created and updated fields for  new enquiry
 * 28/08/2014 -		Quang Nhan
 * 					Save enquiry implemented.Get contact by firstname and last name in new enquiry
 * 29/08/2014 -		Quang Nhan
 * 					Moved enquiry list to its own action class EnquiryListAction
 * 02/09/2014 -		Quang Nhan
 * 					Modified JSPs such that the name is directly associated with the bean class
 * 11/09/2014 -		Quang Nhan
 * 					Implements SessionAware and used reflection to updated enquiry.
 * 16/09/2014 -		Quang Nhan
 * 					Update all functions to accommodate preparable
 * ==============================================
 * 	Description: An action class to linking the service from spring to the enquiry jsp pages
 *
 *----------------------------------------------------------------------------------------------*/



public class EnquiryAction extends BaseAction implements 
SessionAware, 
ModelDriven<Enquiries>, Preparable{
	
	private final String ENQUIRY = "enquiry";
	/* 
	 * form title (can either be new enquiry/exisiting enquiry/enquiry list)
	 */
	private String formTitle;
	private Enquiries iamodel;
	
	//private Contacts ccontact;
	//not calling from enquiry to allow 'CASE' to share the same include jsp
	
	/**
	 * @param hiddenid the hiddenid to set
	 */
	public void setHiddenid(Integer hiddenid) {
		this.hiddenid = hiddenid;
	}

	private List<EnquiryTypes> enquiryTypeSelectList = new ArrayList<EnquiryTypes>();
	/*
	 * Lists for the drop down select options for the jsps
	 * and its associated value variables
	 */
	private List<TitleTypes> titleSelectList = new ArrayList<TitleTypes>();							
	private List<GenderTypes> genderSelectList = new ArrayList<GenderTypes>();
	private List<CulturalBackgroundTypes> culturalBackgroundSelectList = new ArrayList<CulturalBackgroundTypes>();
	private List<AccommodationTypes> accommodationSelectList = new ArrayList<AccommodationTypes>();
	private List<DangerTypes> dangerSelectList = new ArrayList<DangerTypes>();
	private List<StatusTypes> statusSelectList = new ArrayList<StatusTypes>();
	private List<DisabilityTypes> disabilitySelectList = new ArrayList<DisabilityTypes>();
	private List<IssueTypes> issueSelectList = new ArrayList<IssueTypes>();
	private List<EmploymentTypes> employmentSelectList = new ArrayList<EmploymentTypes>();
	private String theEnquiry;
	private String theTitle; 							
	private String theGender;
	private String theCulturalBackground;
	private String theAccommodation;
	private String theDanger;
	private String theStatus;
	private List<String> theDisabilityList = new ArrayList<String>();
	private List<String> theIssueList = new ArrayList<String>();
	private List<String> theEmploymentList = new ArrayList<String>();
	private List<String> firstNameAuto;
	
	public List<String> getFirstNameAuto() {
		return firstNameAuto;
	}

	public void setFirstNameAuto(List<String> firstNameAuto) {
		this.firstNameAuto = firstNameAuto;
	}

	private List<Enquiries> linkedEnquiriesList;
	
	//vairiable used to get enquiry id from enquiry list;
	int hiddenid;
	
	public int getHiddenid() { 
		return hiddenid;
	}

	public void setHiddenid(int hiddenid) {
		this.hiddenid = hiddenid;
	}
 
	Addresses address;
	ClientDisabilities clientDisability;
	EnquiryIssues enquiryIssue;
	

	EnquiryIssues issue;
	
	Date today;
	
	
	public Date getToday() {
		return today;
	}

	public void setToday(Date today) {
		this.today = today;
	}

	/*
	 * ----------------------------------------------------------------------------------------------------------
	 * ----------------------------------------------------------------------------------------------------------
	 * Action Methods
	 * ----------------------------------------------------------------------------------------------------------
	 * ----------------------------------------------------------------------------------------------------------*/
	public Addresses getAddress() {
		return address;
	}
	
	public void setAddress(Addresses address) {
		this.address = address;
	}

	/**
	 * Action Method to create a new enquiry
	 * @return String
	 */
	public String newEnquiry(){ //TODO:

		System.out.println("Struts: start newEnquiry");
		//activateAutocomplete();

		activateLists();
		
		
		
		System.out.println("Struts: end newEnquiry");
		
		return SUCCESS;
	
	}

	/**
	 * Action Method to get an Existing Enquiry Form by id
	 * @return String
	 */
	public String getExistingEnquiry(){ //TODO:
		System.out.println("Struts: start getExistingEnquiry");
		
		//activateAutocomplete();
		activateLists();

		setDob(iamodel.getContact().getDob().toString());
		
		if(iamodel.getContact().getEmploymentsList().size() > 0){
			for(ContactEmployments ce: iamodel.getContact().getEmploymentsList()){
				theEmploymentList.add(ce.getEmploymentType().getEmploymentName());
			}
		}
		
		if(iamodel.getContact().getDisabilitiesList().size() > 0){
			for(ClientDisabilities cd: iamodel.getContact().getDisabilitiesList()){
				theDisabilityList.add(cd.getDisabilityType().getDisabilityName());
			}
		}
		
		if(iamodel.getEnquiryIssuesList().size() > 0){
			for(EnquiryIssues is: iamodel.getEnquiryIssuesList()){
				theIssueList.add(is.getIssue().getIssueName());
			}
		}
		
		linkedEnquiriesList = services.getLinkedEnquiry(getHiddenid());
		
		System.out.println("Struts: start getExistingEnquiry");
		return SUCCESS;
	}
	
	String dob;
	
	
	
	
	public String updateLinkedEnquiries(){//TODO:
		System.out.println("Struts: start updateLinkedEnquiries");
		
		linkedEnquiriesList = services.getLinkedEnquiry(getHiddenid());
		System.out.println(getLinkedEnquiriesList().size() + " id: " + getHiddenid());
		//System.out.println(iamodel.getParentEnquiry());
		try{
			if(iamodel.getParentEnquiry() != null)
				iamodel.setParentEnquiry(services.getEnquiry(getHiddenid()));
		}catch(NullPointerException e){
			//iamodel.setParentEnquiry(new Enquiries());
			//iamodel.setParentEnquiry(services.getEnquiry(getHiddenid()));
			
		}
		
		
		System.out.println("Struts: end updateLinkedEnquiries");
		return SUCCESS;
	}
	
	public String checkContactExists(){
		//services.findContactsByFullName(, lastName);
		return SUCCESS;
	}
	
	/**
	 * Action method to Save/Update an enquiry form
	 * @return String
	 * @throws ParseException 
	 */
	public String saveUpdateEnquiry(){ //TODO
		System.out.println("Struts: start SaveUpdateEnquiry");
		
		System.out.println("parent enquiry is" +  iamodel.getParentEnquiry());
		Users user = (Users)userSession.get(USER);
		
		//System.out.println(iamodel.getId());
		
		
		//addresses setup
		List<Addresses> al = iamodel.getContact().getAddressesList();
		for(int i = 0; i < al.size(); i++){
				
			if(al.get(i).getId() == null){
				al.get(i).setContact(iamodel.getContact());
				al.get(i).setCreatedUserId(user.getContactId());
				al.get(i).setUpdatedUserId(user.getContactId());
			}
		}
		
		
		//enquiry issues set up
		List<EnquiryIssues> eil = iamodel.getEnquiryIssuesList();
		if(theIssueList != null)
		for(int i = 0; i < theIssueList.size(); i++){
			if (getTheIssueList().size() > 0) {
				if(getTheIssueList().get(i) != "-1")
					eil.get(i).setIssue(services.getIssueTypeByName(getTheIssueList().get(i)));
		
				if(eil.get(i).getId() == null){
					eil.get(i).setEnquiry(getIamodel());
					eil.get(i).setCreatedUserId(user.getContactId());
					eil.get(i).setUpdatedUserId(user.getContactId());
				}
			}
		}
		
		//client disabilities set up
		List<ClientDisabilities> cdl = iamodel.getContact().getDisabilitiesList();
		if(theDisabilityList != null)
		for(int i = 0; i < theDisabilityList.size(); i++){
			if (getTheDisabilityList().size() > 0) {
			if(getTheDisabilityList().get(i) != "-1")
				cdl.get(i).setDisabilityType(services.getDisabilityTypeByName(getTheDisabilityList().get(i)));
	
			if(cdl.get(i).getId() == null){
				cdl.get(i).setContact(iamodel.getContact());
				cdl.get(i).setCreatedUserId(user.getContactId());
				cdl.get(i).setUpdatedUserId(user.getContactId());
				
			}
			}
		}
		
		//contact employments set up
		List<ContactEmployments> cel = iamodel.getContact().getEmploymentsList();
		if(theEmploymentList != null)
		for(int i = 0; i < theEmploymentList.size(); i++){
			if (getTheEmploymentList().size() > 0) {
				if(getTheEmploymentList().get(i) != "-1")
					cel.get(i).setEmploymentType(services.getEmploymentTypeByName(getTheEmploymentList().get(i)));
		
				if(cel.get(i).getId() == null){
					cel.get(i).setContact(iamodel.getContact());
					cel.get(i).setCreatedUserId(user.getContactId());
					cel.get(i).setUpdatedUserId(user.getContactId());
					
				}
			}
		}
		
		//TODO: add a checker to see if value has changed first
		iamodel.setStatusType(services.getStatusTypeByName(getTheStatus()));
		iamodel.setEnquiryType(services.getEnquiryTypeByName(getTheEnquiry()));
		
		iamodel.getContact().setCulturalBackground(services.getCulturalBackgroundTypeByName(getTheCulturalBackground()));
		iamodel.getContact().setTitleType(services.getTitleTypeByName(getTheTitle()));
		iamodel.getContact().setGenderType(services.getGenderTypeByName(getTheGender()));
		iamodel.getContact().setDangerType(services.getDangerTypeByName(getTheDanger()));
		iamodel.getContact().setAccommodation(services.getAccommodationTypeByName(getTheAccommodation()));
		
		
		if(iamodel.getId() == null){
			if(services.saveOrUpdateEnquiry(iamodel, iamodel.getContact())){
				activateLists();
				setIamodel(iamodel);
				System.out.println("save new enquiry successfully");
				System.out.println("Struts: end saveUpdateEnquiry");
				return SUCCESS;
			}
		}
		
		else if(services.saveOrUpdateEnquiry(iamodel)){
			activateLists();
			setIamodel(iamodel);
			linkedEnquiriesList = services.getLinkedEnquiry(iamodel.getId());
			System.out.println("save existing successfully");
			System.out.println("Struts: end saveUpdateEnquiry");
			return SUCCESS;
		}

		
		System.out.println("Struts: save unsuccessful");
		System.out.println("Struts: end saveUpdateEnquiry");
		return ERROR;
		
	}
	
	String deleteFrom;
	int index;
	
	

	public String getDeleteFrom() {
		return deleteFrom;
	}

	public void setDeleteFrom(String deleteFrom) {
		this.deleteFrom = deleteFrom;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String deleteFromList(){ //TODO:
		System.out.println("Struts: start deleteFromList");
		
		String returnString = "error";
		
		System.out.println("index" + index);
		System.out.println("deleteFrom: " + deleteFrom);
		
		System.out.println("iamodel disalist size: " +iamodel.getContact().getDisabilitiesList().size());
		switch(deleteFrom){
		case "disabilitiesList": 
			System.out.println("deleting list id: " + index + " from " + deleteFrom); 
			iamodel.getContact().getDisabilitiesList().remove(index); returnString = "disabilityUpdate"; break;
		case "enquiryIssuesList": 
			System.out.println("deleting list id: " + index + " from " + deleteFrom); 
			iamodel.getEnquiryIssuesList().remove(index); returnString = "issueUpdate" ; break;
		case "addressesList": 
			System.out.println("deleting list id: " + index + " from " + deleteFrom); 
			iamodel.getContact().getAddressesList().remove(index); returnString = "addressUpdate"; break;
		case "employmentsList": 
			System.out.println("deleting list id: " + index + " from " + deleteFrom); 
			iamodel.getContact().getEmploymentsList().remove(index); returnString = "employmentUpdate"; break;
		default: System.out.println("Error deleting list");
		}
		
		if(services.saveOrUpdateEnquiry(iamodel)){
			System.out.println("Struts: delete successful");
			activateLists();
			setIamodel(iamodel);
		}
		System.out.println(returnString);
		System.out.println("Struts: end deleteFromList");
		return returnString;
	}
	
	/* 
	 * ----------------------------------------------------------------------------------------------------------
	 * ----------------------------------------------------------------------------------------------------------
	 * Other Methods & Setters and Getters
	 * ----------------------------------------------------------------------------------------------------------
	 * ----------------------------------------------------------------------------------------------------------*/
	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}
	
	private void activateAutocomplete(){
		firstNameAuto = new ArrayList<String>();
		firstNameAuto.add("Tom");
		firstNameAuto.add("Tori");
		firstNameAuto.add("Terry");
		firstNameAuto.add("Cary");
		firstNameAuto.add("Cathy");
	}
	
	/**
	 * populate the Select List variables
	 */
	private void activateLists(){
		setTitleSelectList(services.findTitleTypes());
		genderSelectList=services.findGenderTypes();
		culturalBackgroundSelectList=services.findCulturalBackgroundTypes();
		accommodationSelectList = services.findAccommodationTypes();
		disabilitySelectList = services.findDisabilityTypes();
		issueSelectList = services.findIssueTypes();
		dangerSelectList = services.findDangerTypes();
		employmentSelectList = services.findEmploymentTypes();
		//setEmploymentList(contact.getEmploymentType());
		statusSelectList = services.findStatusTypes();
		enquiryTypeSelectList = services.findEnquiryTypes();
		
		if(iamodel != null){
			theDisabilityList = new ArrayList<String>();
			theEmploymentList = new ArrayList<String>();
			theIssueList = new ArrayList<String>();
			
			//setTheTitle(getIamodel().getContact().getTitleType().getName());
			
			
			for(ClientDisabilities cd: getIamodel().getContact().getDisabilitiesList()){
				try{
					theDisabilityList.add(cd.getDisabilityType().getDisabilityName());
				}catch(NullPointerException e){
					theDisabilityList.add(new String());
				}
			}
			
			for(ContactEmployments ce: getIamodel().getContact().getEmploymentsList()){
				try{
					theEmploymentList.add(ce.getEmploymentType().getEmploymentName());
				}catch(NullPointerException e){
					theEmploymentList.add(new String());
				}
			}
			
			for(EnquiryIssues ei: getIamodel().getEnquiryIssuesList()){
				try{
					theIssueList.add(ei.getIssue().getIssueName());
				}catch(NullPointerException e){
					theIssueList.add(new String());
				}
			}
			
		}
		
	}
	
	
	public void setTitleSelectList(List<TitleTypes> titleSelectList) {
		this.titleSelectList = titleSelectList;
	}
	
	/**
	 * Getter for the form title
	 * @return String
	 */
	public String getFormTitle() {
		return formTitle;
	}
	/**
	 * Setter for the form title
	 * @param formTitle
	 */
	public void setFormTitle(String formTitle) {
		System.out.println(formTitle);
		this.formTitle = formTitle;
	}
	

	public Enquiries getIamodel(){
		return iamodel;
	}

	/**
	 * Setter for enquiry
	 * @param enquiry
	 */
	public void setIamodel(Enquiries enquiry){
		this.iamodel = enquiry;
	}

	/**
	 * Getter for title types
	 * @return List
	 */
	public List<TitleTypes> getTitleSelectList() {
		return titleSelectList;
	}

	/**
	 * Getter for gender types
	 * @return List
	 */
	public List<GenderTypes> getGenderSelectList() {
		return genderSelectList;
	}

	/**
	 * Getter for cultural background types
	 * @return List
	 */
	public List<CulturalBackgroundTypes> getCulturalBackgroundSelectList() {
		return culturalBackgroundSelectList;
	}

	/**
	 * Getter for accommodation types
	 * @return List
	 */
	public List<AccommodationTypes> getAccomodationSelectList() {
		return accommodationSelectList;
	}

	/**
	 * Getter for disability type
	 * @return List
	 */
	public List<DisabilityTypes> getDisabilitySelectList() {
		return disabilitySelectList;
	}


	/**
	 * Getter for issue type
	 * @return List
	 */
	public List<IssueTypes> getIssueSelectList() {
		return issueSelectList;
	}


	/**
	 * Getter for employment types
	 * @return List
	 */
	public List<EmploymentTypes> getEmploymentSelectList() {
		return employmentSelectList;
	}

	/**
	 * @return List
	 */
	public List<DangerTypes> getDangerSelectList() {
		return dangerSelectList;
	}

	/**
	 * Getter for enquiry status select list
	 * @return
	 */
	public List<StatusTypes> getStatusSelectList() {
		return statusSelectList;
	}

	public List<EnquiryTypes> getEnquiryTypeSelectList() {
		return enquiryTypeSelectList;
	}

	public void setEnquiryTypeSelectList(List<EnquiryTypes> enquiryTypeSelectList) {
		this.enquiryTypeSelectList = enquiryTypeSelectList;
	}

	public List<Enquiries> getLinkedEnquiriesList() {
		return linkedEnquiriesList;
	}

	public void setLinkedEnquiriesList(List<Enquiries> linkedEnquiriesList) {
		this.linkedEnquiriesList = linkedEnquiriesList;
	}
	
	public String getTheTitle() {
		return theTitle;
	}

	public void setTheTitle(String theTitle) {
		this.theTitle = theTitle;
	}
	
	
	
	
	public String getTheGender() {
		return theGender;
	}

	public void setTheGender(String theGender) {
		this.theGender = theGender;
	}

	public String getTheCulturalBackground() {
		return theCulturalBackground;
	}

	public void setTheCulturalBackground(String theCulturalBackground) {
		this.theCulturalBackground = theCulturalBackground;
	}

	public String getTheAccommodation() {
		return theAccommodation;
	}

	public void setTheAccommodation(String theAccommodation) {
		this.theAccommodation = theAccommodation;
	}

	public List<String> getTheDisabilityList() {
		return theDisabilityList;
	}

	public void setTheDisabilityList(List<String> theDisabilityList) {
		this.theDisabilityList = theDisabilityList;
	}

	public String getTheEnquiry() {
		return theEnquiry;
	}

	public void setTheEnquiry(String theEnquiry) {
		this.theEnquiry = theEnquiry;
	}

	public List<String> getTheIssueList() {
		return theIssueList;
	}

	public void setTheIssueList(List<String> theIssueList) {
		this.theIssueList = theIssueList;
	}

	public List<String> getTheEmployment() {
		return theEmploymentList;
	}

	public void setTheEmployment(List<String> theEmploymentList) {
		this.theEmploymentList = theEmploymentList;
	}

	public String getTheDanger() {
		return theDanger;
	}

	public void setTheDanger(String theDanger) {
		this.theDanger = theDanger;
	}

	public String getTheStatus() {
		return theStatus;
	}

	public void setTheStatus(String theStatus) {
		this.theStatus = theStatus;
	}

	public Map<String, Object> getUserSession() {
		return userSession;
	}

	public void setUserSession(Map<String, Object> userSession) {
		this.userSession = userSession;
	}

	
	
	public List<String> getTheEmploymentList() {
		return theEmploymentList;
	}

	public void setTheEmploymentList(List<String> theEmploymentList) {
		this.theEmploymentList = theEmploymentList;
	}

	private void printContact(Contacts c){
		System.out.println(">>>Start Printing Contact Information: ");
		//TODO: missing created and updated user date and id
		//why status type for contact?
		//"\ncontact type: " + c.getContactType().getContactTypeName() +
		System.out.println(
				"danger type: " + c.getDangerType().getDangerName() + 
				"\ncontact id: " + c.getId() + 
				"\ntitle: " + c.getTitleType().getName() +
				"\nfirst name: " + c.getFirstname() + 
				"\nother name: " + c.getOthername() +
				"\nlast name: " + c.getLastname() + 
				"\ngender type: " + c.getGenderType().getGenderName() +
				"\ndob: " + c.getDob().toString() + 
				 
				"\nmobile: " + c.getMobilephone() + 
				"\nemail: " + c.getEmail() + 
				"\nidentification: " + c.getIdentification() +
				"\ncultural background: " + c.getCulturalBackground().getCulturalBackgroundName() + 
				"\ncultrual background comment: " + c.getCulturalBackgroundComment() +
				"\naccommodation: " + c.getAccommodation().getAccommodationName() +
				"\naccommodation comment: " + c.getAccommodationComment());
		for (Addresses a : c.getAddressesList()) {
			System.out.println(
					"address id: " + a.getId() +
					"\nstreet: " + a.getStreet() +
					"\nsuburb: " + a.getSuburb() +
					"\npostcode: " + a.getPostcode() +
					"\nstate: " + a.getState() +
					"\ncountry: " + a.getCountry() + 
					"\nhomephone: " + a.getHomephone()
					);
		}
		
		for(ClientDisabilities cd: c.getDisabilitiesList()){
			System.out.println(
					"disability id: " + cd.getId() +
					"\ndisability type: " + cd.getDisabilityType().getDisabilityName() +
					"\ncomments: " + cd.getComments() +
					"\nprimary flag: " + cd.getPrimaryFlag() );
		};
		for(ContactEmployments ce: c.getEmploymentsList()){
			System.out.println(
					"employment id: " + ce.getId() +
					"\nemployment type: " + ce.getEmploymentType().getEmploymentName() +
					"\ncomments: " + ce.getComments() + 
					"\nwork phone: " + ce.getWorkphone() );
		}
		System.out.println(">>>End of Printing Contact Information");
	}
	private void printIamodel(Enquiries e) throws NullPointerException{
		System.out.println(
			"Enquiry id: " + e.getId() + 
			"\ncreated date: " + e.getCreatedDateTime() + 
			"\ncreated User: " + e.getCreatedUserId() +
			"\nupdated date: " + e.getUpdatedDateTime() +
			"\nupdated User: " + e.getUpdatedUserId() +
			"\nenquiry type: " + e.getEnquiryType().getEnquiryTypeName() +
			"\nstatus type: " + e.getStatusType().getStatusName() + 
			"\ndescription: " + e.getDescription() +
			"\ninquisitor: " + e.getInquisitor() + 
			"\nreferral by: " + e.getReferralBy() +
			"\nreferred to: " + e.getReferralTo());// +
			//"\nparent enquiry id: " + e.getParentEnquiry().getId() );
		for (EnquiryIssues ei : e.getEnquiryIssuesList()) {
			System.out.println(
					"Enquiry Issue id: " + ei.getId() +
					"\nissue type: " + ei.getIssue().getIssueName() +
					"\ncomment: " + ei.getComment()
					);
		}
//		for(Enquiries e2: e.getEnquiriesList()){
//			System.out.println( "linked enquiry id: " + e2.getId());
//		}
	
	}
	
	Map <String, Object> userSession;

	public void setSession(Map<String,Object> session) {
		System.out.println("setSession called");
		this.userSession = session;
	}

	@Override
	public void prepare() throws Exception {
		System.out.println("Struts: Prepare start");
		System.out.println("hiddenid = " + getHiddenid());
		if ((Integer) getHiddenid() == null || (Integer)getHiddenid() == 0) {
			//iamodel = new Enquiries();
			
		} else {
			iamodel = services.getEnquiry(getHiddenid());
			activateLists();
		}
		System.out.println("Struts: Prepare end");
	}

	@Override
	public Enquiries getModel() {
		return iamodel;
	}
}
