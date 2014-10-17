package uow.ia.action;


import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
	 * form title (can either be new enquiry/exisiting enquiry)
	 */
	private String formTitle;
	private Enquiries iamodel;

	
	/*
	 * Lists for the drop down select options for the jsps
	 * and its associated value variables
	 */
	private List<EnquiryTypes> enquiryTypeSelectList = new ArrayList<EnquiryTypes>();
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
	
	private String dob;
	//variable used to get enquiry id from enquiry list;
	private int hiddenid;
	//variable used to pass contact id between forms
	private int contactid;
	
	public int getContactid() {
		return contactid;
	}

	public void setContactid(int contactid) {
		this.contactid = contactid;
	}

	private Date today;
	
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
	 * Action Method to create a new enquiry also catered for new equiry using
	 * contact from an existing enquiry
	 * @return String
	 */
	public String newEnquiry(){ //TODO:
		System.out.println("Struts: start newEnquiry");
		//activateAutocomplete();

		activateLists();
		//linkedEnquiriesList = enquiryService.getLinkedEnquiry(getHiddenid());

		//if clicked new enquiry from an existing enquiry or new enquiry with
		//an existing contact then assign new id to this contact.
		if(getContactid() > 0){
			iamodel = new Enquiries();
			iamodel.setContact(contactService.getContacts(getContactid()));
		}
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
		
		

		System.out.println("Struts: end getExistingEnquiry");
		return SUCCESS;
	}
	
	public String updateLinkedEnquiries(){//TODO:
		System.out.println("Struts: start updateLinkedEnquiries");
		
		/*
		linkedEnquiriesList = enquiryService.getLinkedEnquiry(getHiddenid());
		System.out.println(getLinkedEnquiriesList().size());
		iamodel.setParentEnquiry(enquiryService.getEnquiry(getHiddenid()));
		*/
		linkedEnquiriesList = enquiryService.getLinkedEnquiry(0,getHiddenid());
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
	
	
	public String searchContact(Class<?> c){
		//ArrayList<Contacts>
		//if(c.isAssignableFrom(Enquiries.class))
		
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
		System.out.println("checking address");
		for(int i = 0; i < al.size(); i++){
			if(al.get(i).getId() == null){
				al.get(i).setContact(iamodel.getContact());
				//al.get(i).setCreatedUser(user.getContact());
				//al.get(i).setUpdatedUser(user.getContact());
			}
			else if(al.get(i).getId() == -1){
				System.out.println("Removing a false address");
				iamodel.getContact().getAddressesList().remove(i);
				i--;
			}
		}
		
		//enquiry issues set up
		List<EnquiryIssues> eil = iamodel.getEnquiryIssuesList();
		System.out.println("checking issues");
		if (getTheIssueListId().size() > 0) {
			for(int i = 0; i < theIssueListId.size(); i++){
				if(getTheIssueListId().get(i) != -1)
					eil.get(i).setIssue(typesService.getIssueTypeById(getTheIssueListId().get(i)));
				
				if(eil.get(i).getId() == null){
					eil.get(i).setEnquiry(getIamodel());
//					eil.get(i).setCreatedUser(user.getContact());
//					eil.get(i).setUpdatedUser(user.getContact());
				}
			}
		}
		
		//client disabilities set up
		List<ClientDisabilities> cdl = iamodel.getContact().getDisabilitiesList();
		System.out.println("checking disability");
		if (getTheDisabilityListId().size() > 0) {
			for(int i = 0; i < theDisabilityListId.size(); i++){
				if(getTheDisabilityListId().get(i) != -1){
					cdl.get(i).setDisabilityType(typesService.getDisabilityTypeById(getTheDisabilityListId().get(i)));
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
		System.out.println("checking employment");
		if (getTheEmploymentListId().size() > 0) {
			for(int i = 0; i < theEmploymentListId.size(); i++){
				if(getTheEmploymentListId().get(i) != -1)
					cel.get(i).setEmploymentType(typesService.getEmploymentTypeById(getTheEmploymentListId().get(i)));
		
				if(cel.get(i).getId() == null){
					cel.get(i).setContact(iamodel.getContact());
//					cel.get(i).setCreatedUser(user.getContact());
//					cel.get(i).setUpdatedUser(user.getContact());
					
				}
			}
		}
		
		System.out.println("setting types");
		
		iamodel.setEnquiryType(typesService.getEnquiryTypeById(getTheEnquiryTypeId()));
		iamodel.setStatusType(typesService.getStatusTypeById(getTheStatusTypeId()));
		
		iamodel.getContact().setCulturalBackground(typesService.getCulturalBackgroundTypeById(getTheCulturalBackgroundTypeId()));
		iamodel.getContact().setTitleType(typesService.getTitleTypeById(getTheTitleTypeId()));
		iamodel.getContact().setGenderType(typesService.getGenderTypeById(getTheGenderTypeId()));
		iamodel.getContact().setDangerType(typesService.getDangerTypeById(getTheDangerTypeId()));
		iamodel.getContact().setAccommodation(typesService.getAccommodationTypeById(getTheAccommodationTypeId()));
		
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
			linkedEnquiriesList = enquiryService.getLinkedEnquiry(0,iamodel.getId());
			System.out.println("save existing successfully");
			System.out.println("Struts: end saveUpdateEnquiry");
			return SUCCESS;
		}

		
		System.out.println("Struts: save unsuccessful");
		System.out.println("Struts: end saveUpdateEnquiry");
		return ERROR;
		
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
		titleSelectList = typesService.findTitleTypes();
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
		try{ theEnquiryTypeId = iamodel.getEnquiryType().getId(); }									catch (NullPointerException n){}
		try{ theAccommodationTypeId = iamodel.getContact().getAccommodation().getId(); }			catch (NullPointerException n){}
		try{ theCulturalBackgroundTypeId = iamodel.getContact().getCulturalBackground().getId(); }	catch (NullPointerException n){}
		try{ theDangerTypeId = iamodel.getContact().getDangerType().getId(); }						catch (NullPointerException n){}
		try{ theGenderTypeId = iamodel.getContact().getGenderType().getId(); }						catch (NullPointerException n){}
		try{ theStatusTypeId = iamodel.getStatusType().getId(); }									catch (NullPointerException n){}
		try{ theTitleTypeId = iamodel.getContact().getTitleType().getId(); }						catch (NullPointerException n){}
		
		
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

		linkedEnquiriesList = enquiryService.getLinkedEnquiry(0,getHiddenid());
		
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
	public List<AccommodationTypes> getAccommodationSelectList() {
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

	
	Map <String, Object> userSession;

	public void setSession(Map<String,Object> session) {
		System.out.println("setSession called");
		this.userSession = session;
	}

	@Override
	public void prepare() throws Exception {
		System.out.println("Struts: Prepare start");
		
		if ((Integer) getHiddenid() == null || (Integer)getHiddenid() == 0) {
			
				
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
