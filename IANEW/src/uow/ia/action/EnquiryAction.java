package uow.ia.action;


import java.lang.reflect.InvocationTargetException;
import java.sql.SQLData;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.converters.SqlDateConverter;
import org.apache.struts2.interceptor.SessionAware;

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
import uow.ia.bean.IssueTypes;
import uow.ia.bean.StatusTypes;
import uow.ia.bean.TitleTypes;
import uow.ia.bean.Users;

import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

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
 * 29/09/2014 -		Quang Nhan
 * 					Updated all type from names to id
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
	private int theEnquiryTypeId;
	private int theTitleTypeId; 							
	private int theGenderTypeId;
	private int theCulturalBackgroundTypeId;
	private int theAccommodationTypeId;
	private int theDangerTypeId;
	private int theStatusTypeId;
	
	
	
	

	private List<Integer> theDisabilityListId = new ArrayList<Integer>();
	private List<Integer> theIssueListId = new ArrayList<Integer>();
	private List<Integer> theEmploymentListId = new ArrayList<Integer>();
	private List<String> firstNameAuto;

	private List<Enquiries> linkedEnquiriesList;
	
	//vairiable used to get enquiry id from enquiry list;
	private int hiddenid;
	
	
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

	/**
	 * Action Method to create a new enquiry
	 * @return String
	 */
	public String newEnquiry(){ //TODO:
		
		System.out.println("Struts: start newEnquiry");
		//activateAutocomplete();

		activateLists();

		//linkedEnquiriesList = enquiryService.getLinkedEnquiry(getHiddenid());

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
		
		try{ theEnquiryTypeId = iamodel.getEnquiryType().getId(); }catch (NullPointerException n){}
		try{ theAccommodationTypeId = iamodel.getContact().getAccommodation().getId(); }catch (NullPointerException n){}
		try{ theCulturalBackgroundTypeId = iamodel.getContact().getCulturalBackground().getId(); }catch (NullPointerException n){}
		try{ theDangerTypeId = iamodel.getContact().getDangerType().getId(); }catch (NullPointerException n){}
		try{ theGenderTypeId = iamodel.getContact().getGenderType().getId(); }catch (NullPointerException n){}
		try{ theStatusTypeId = iamodel.getStatusType().getId(); }catch (NullPointerException n){}
		try{ theTitleTypeId = iamodel.getContact().getTitleType().getId(); }catch (NullPointerException n){}
		
		
		try{ setDob(iamodel.getContact().getDob().toString()); }catch (NullPointerException n) {}
		
		
		
		if(iamodel.getContact().getEmploymentsList().size() > 0){
			for(ContactEmployments ce: iamodel.getContact().getEmploymentsList()){
				theEmploymentListId.add(ce.getEmploymentType().getId());
				
			}
		}
		
		if(iamodel.getContact().getDisabilitiesList().size() > 0){
			for(ClientDisabilities cd: iamodel.getContact().getDisabilitiesList()){
				theDisabilityListId.add(cd.getDisabilityType().getId());
				
			}
		}
		
		if(iamodel.getEnquiryIssuesList().size() > 0){
			for(EnquiryIssues is: iamodel.getEnquiryIssuesList()){
				theIssueListId.add(is.getIssue().getId());
			}
		}
		
		
		System.out.println("Struts: start getExistingEnquiry");
		return SUCCESS;
	}
	
	String dob;
	
	
	
	
	public String updateLinkedEnquiries(){//TODO:
		System.out.println("Struts: start updateLinkedEnquiries");
		
		/*
		linkedEnquiriesList = enquiryService.getLinkedEnquiry(getHiddenid());
		System.out.println(getLinkedEnquiriesList().size());
		iamodel.setParentEnquiry(enquiryService.getEnquiry(getHiddenid()));
		*/
		linkedEnquiriesList = enquiryService.getLinkedEnquiry(getHiddenid());
		System.out.println(getLinkedEnquiriesList().size() + " id: " + getHiddenid());
		//System.out.println(iamodel.getParentEnquiry());
		try{
			if(iamodel.getParentEnquiry() != null)
				iamodel.setParentEnquiry(enquiryService.getEnquiry(getHiddenid()));
		}catch(NullPointerException e){
			//iamodel.setParentEnquiry(new Enquiries());
			//iamodel.setParentEnquiry(services.getEnquiry(getHiddenid()));
			
		}
		
		System.out.println("Struts: end updateLinkedEnquiries");
		return SUCCESS;
	}
	
	public String checkContactExists(){
		//enquiryService.findContactsByFullName(, lastName);
		return SUCCESS;
	}
	
	/**
	 * Action method to Save/Update an enquiry form
	 * @return String
	 * @throws ParseException 
	 */
	public String saveUpdateEnquiry(){ //TODO
		System.out.println("Struts: start SaveUpdateEnquiry");
		
		Date saveDate = null;
		try {
			saveDate = DateUtil.yyyymmddDate(getDob());
		} catch (ParseException e) {
			System.out.println("Problem with date: " + e.getMessage());
		}
		
		java.sql.Date date = null;
		try{ date = new java.sql.Date(saveDate.getTime()); } catch(NullPointerException n){}
		
		iamodel.getContact().setDob(date);
		
		Users user = (Users)userSession.get(USER);
		
		//addresses setup
		List<Addresses> al = iamodel.getContact().getAddressesList();
		for(int i = 0; i < al.size(); i++){
				
			if(al.get(i).getId() == null){
				al.get(i).setContact(iamodel.getContact());
				//al.get(i).setCreatedUser(user.getContact());
				//al.get(i).setUpdatedUser(user.getContact());
				
			}
		}
		
		//enquiry issues set up
		List<EnquiryIssues> eil = iamodel.getEnquiryIssuesList();
		if (getTheIssueListId().size() > 0) {
			for(int i = 0; i < theIssueListId.size(); i++){
				if(getTheIssueListId().get(i) != -1)
					eil.get(i).setIssue(typesService.getIssueTypeId(getTheIssueListId().get(i)));
		
				if(eil.get(i).getId() == null){
					eil.get(i).setEnquiry(getIamodel());
//					eil.get(i).setCreatedUser(user.getContact());
//					eil.get(i).setUpdatedUser(user.getContact());
				}
			}
		}
		
		//client disabilities set up
		List<ClientDisabilities> cdl = iamodel.getContact().getDisabilitiesList();
		if (getTheDisabilityListId().size() > 0) {
			for(int i = 0; i < theDisabilityListId.size(); i++){
				if(getTheDisabilityListId().get(i) != -1){
					cdl.get(i).setDisabilityType(typesService.getDisabilityTypeId(getTheDisabilityListId().get(i)));
				}
		
				if(cdl.get(i).getId() == null){
					cdl.get(i).setContact(iamodel.getContact());
//					cdl.get(i).setCreatedUser(user.getContact());
//					cdl.get(i).setUpdatedUser(user.getContact());
					
				}
			}
		}
		
		//contact employments set up
		List<ContactEmployments> cel = iamodel.getContact().getEmploymentsList();
		if (getTheEmploymentListId().size() > 0) {
			for(int i = 0; i < theEmploymentListId.size(); i++){
				if(getTheEmploymentListId().get(i) != -1)
					cel.get(i).setEmploymentType(typesService.getEmploymentTypeId(getTheEmploymentListId().get(i)));
		
				if(cel.get(i).getId() == null){
					cel.get(i).setContact(iamodel.getContact());
//					cel.get(i).setCreatedUser(user.getContact());
//					cel.get(i).setUpdatedUser(user.getContact());
					
				}
			}
		}
		
		
		iamodel.setStatusType(typesService.getStatusTypeId(getTheStatusTypeId()));
		iamodel.setEnquiryType(typesService.getEnquiryTypeId(getTheEnquiryTypeId()));
		
		iamodel.getContact().setCulturalBackground(typesService.getCulturalBackgroundTypeId(getTheCulturalBackgroundTypeId()));
		iamodel.getContact().setTitleType(typesService.getTitleTypeId(getTheTitleTypeId()));
		iamodel.getContact().setGenderType(typesService.getGenderTypeId(getTheGenderTypeId()));
		iamodel.getContact().setDangerType(typesService.getDangerTypeId(getTheDangerTypeId()));
		iamodel.getContact().setAccommodation(typesService.getAccommodationTypeId(getTheAccommodationTypeId()));
		
		System.out.println("Start to save");
		if(iamodel.getId() == null){
			if(enquiryService.saveOrUpdateEnquiry(iamodel, iamodel.getContact())){
				activateLists();
				setIamodel(iamodel);
				System.out.println("save new enquiry successfully");
				System.out.println("Struts: end saveUpdateEnquiry");
				return SUCCESS;
			}
		}
		
		
		else if(enquiryService.saveOrUpdateEnquiry(iamodel)){
			activateLists();
			setIamodel(iamodel);
			linkedEnquiriesList = enquiryService.getLinkedEnquiry(iamodel.getId());
			System.out.println("save existing successfully");
			System.out.println("Struts: end saveUpdateEnquiry");
			return SUCCESS;
		}

		
		System.out.println("Struts: save unsuccessful");
		System.out.println("Struts: end saveUpdateEnquiry");
		return ERROR;
		
	}
	
//	String deleteFrom;
//	int index;
//	
//	
//
//	public String getDeleteFrom() {
//		return deleteFrom;
//	}
//
//	public void setDeleteFrom(String deleteFrom) {
//		this.deleteFrom = deleteFrom;
//	}
//
//	public int getIndex() {
//		return index;
//	}
//
//	public void setIndex(int index) {
//		this.index = index;
//	}
//
//	public String deleteFromList(){ //TODO:
//		System.out.println("Struts: start deleteFromList");
//		
//		String returnString = "error";
//		
//		System.out.println("index" + index);
//		System.out.println("deleteFrom: " + deleteFrom);
//		
//		System.out.println("iamodel disalist size: " +iamodel.getContact().getDisabilitiesList().size());
//		switch(deleteFrom){
//		case "disabilitiesList": 
//			System.out.println("deleting list id: " + index + " from " + deleteFrom); 
//			iamodel.getContact().getDisabilitiesList().remove(index); returnString = "disabilityUpdate"; break;
//		case "enquiryIssuesList": 
//			System.out.println("deleting list id: " + index + " from " + deleteFrom); 
//			iamodel.getEnquiryIssuesList().remove(index); returnString = "issueUpdate" ; break;
//		case "addressesList": 
//			System.out.println("deleting list id: " + index + " from " + deleteFrom); 
//			iamodel.getContact().getAddressesList().remove(index); returnString = "addressUpdate"; break;
//		case "employmentsList": 
//			System.out.println("deleting list id: " + index + " from " + deleteFrom); 
//			iamodel.getContact().getEmploymentsList().remove(index); returnString = "employmentUpdate"; break;
//		default: System.out.println("Error deleting list");
//		}
//		
//		if(enquiryService.saveOrUpdateEnquiry(iamodel)){
//			System.out.println("Struts: delete successful");
//			activateLists();
//			setIamodel(iamodel);
//		}
//		System.out.println(returnString);
//		System.out.println("Struts: end deleteFromList");
//		return returnString;
//	}
	
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
	@SuppressWarnings("unchecked")
	private void activateLists(){
		setTitleSelectList(typesService.findTitleTypes());
		genderSelectList=typesService.findGenderTypes();
		culturalBackgroundSelectList=typesService.findCulturalBackgroundTypes();
		accommodationSelectList = typesService.findAccommodationTypes();
		disabilitySelectList = typesService.findDisabilityTypes();
		issueSelectList = typesService.findIssueTypes();
		dangerSelectList = typesService.findDangerTypes();
		employmentSelectList = typesService.findEmploymentTypes();
		statusSelectList = typesService.findStatusTypes(1);
		enquiryTypeSelectList = typesService.findEnquiryTypes();

		theDisabilityListId = new ArrayList<Integer>();
		theEmploymentListId = new ArrayList<Integer>();
		theIssueListId = new ArrayList<Integer>();
		
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

	public int getTheEnquiryTypeId() {
		return theEnquiryTypeId;
	}

	public void setTheEnquiryTypeId(int theEnquiryTypeId) {
		this.theEnquiryTypeId = theEnquiryTypeId;
	}

	public int getTheTitleTypeId() {
		return theTitleTypeId;
	}

	public void setTheTitleTypeId(int theTitleTypeId) {
		this.theTitleTypeId = theTitleTypeId;
	}

	public int getTheGenderTypeId() {
		return theGenderTypeId;
	}

	public void setTheGenderTypeId(int theGenderTypeId) {
		this.theGenderTypeId = theGenderTypeId;
	}

	public int getTheCulturalBackgroundTypeId() {
		return theCulturalBackgroundTypeId;
	}

	public void setTheCulturalBackgroundTypeId(int theCulturalBackgroundTypeId) {
		this.theCulturalBackgroundTypeId = theCulturalBackgroundTypeId;
	}

	public int getTheAccommodationTypeId() {
		return theAccommodationTypeId;
	}

	public void setTheAccommodationTypeId(int theAccommodationTypeId) {
		this.theAccommodationTypeId = theAccommodationTypeId;
	}

	public int getTheDangerTypeId() {
		return theDangerTypeId;
	}

	public void setTheDangerTypeId(int theDangerTypeId) {
		this.theDangerTypeId = theDangerTypeId;
	}

	public int getTheStatusTypeId() {
		return theStatusTypeId;
	}

	public void setTheStatusTypeId(int theStatusTypeId) {
		this.theStatusTypeId = theStatusTypeId;
	}

	public List<Integer> getTheDisabilityListId() {
		return theDisabilityListId;
	}

	public void setTheDisabilityListId(List<Integer> theDisabilityListId) {
		this.theDisabilityListId = theDisabilityListId;
	}

	public List<Integer> getTheIssueListId() {
		return theIssueListId;
	}

	public void setTheIssueListId(List<Integer> theIssueListId) {
		this.theIssueListId = theIssueListId;
	}

	public List<Integer> getTheEmploymentListId() {
		return theEmploymentListId;
	}

	public void setTheEmploymentListId(List<Integer> theEmploymentListId) {
		this.theEmploymentListId = theEmploymentListId;
	}

	public List<String> getFirstNameAuto() {
		return firstNameAuto;
	}

	public void setFirstNameAuto(List<String> firstNameAuto) {
		this.firstNameAuto = firstNameAuto;
	}

	public List<Enquiries> getLinkedEnquiriesList() {
		return linkedEnquiriesList;
	}

	public void setLinkedEnquiriesList(List<Enquiries> linkedEnquiriesList) {
		this.linkedEnquiriesList = linkedEnquiriesList;
	}
	



	public int getHiddenid() { 
		return hiddenid;
	}

	public void setHiddenid(int hiddenid) {
		this.hiddenid = hiddenid;
	}
	
	public Map<String, Object> getUserSession() {
		return userSession;
	}

	public void setUserSession(Map<String, Object> userSession) {
		this.userSession = userSession;
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
			"\ncreated User: " + e.getCreatedUser().getFullName() +
			"\nupdated date: " + e.getUpdatedDateTime() +
			"\nupdated User: " + e.getUpdatedUser().getFullName() +
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
			iamodel = enquiryService.getEnquiry(getHiddenid());
			activateLists();
		}
		System.out.println("Struts: Prepare end");
	}

	@Override
	public Enquiries getModel() {
		return iamodel;
	}
}
