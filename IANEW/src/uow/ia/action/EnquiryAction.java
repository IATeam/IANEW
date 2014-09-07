package uow.ia.action;


import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import antlr.Lookahead;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.sun.org.apache.bcel.internal.generic.InstructionConstants.Clinit;
import com.sun.xml.rpc.processor.modeler.j2ee.xml.javaIdentifierType;

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
 * 02/08/2014 -		Quang Nhan
 * 					Modified JSPs such that the name is directly associated with the bean class
 * ==============================================
 * 	Description: An action class to linking the service from spring to the enquiry jsp pages
 *
 *----------------------------------------------------------------------------------------------*/



public class EnquiryAction extends BaseAction{
	
	/* 
	 * form title (can either be new enquiry/exisiting enquiry/enquiry list)
	 */
	private String formTitle;;
	private Enquiries iamodel;
	private Contacts ccontact; //not calling from enquiry to allow 'CASE' to share the same include jsp
	
	/*
	 * Lists for the drop down select options for the jsps
	 * and its associated value variables
	 */
	private List<TitleTypes> titleSelectList; 							
	private List<GenderTypes> genderSelectList; 						
	private List<CulturalBackgroundTypes> culturalBackgroundSelectList;
	private List<AccommodationTypes> accommodationSelectList;			
	private List<DisabilityTypes> disabilitySelectList;					
	private List<EnquiryTypes> enquiryTypeSelectList;					
	private List<IssueTypes> issueSelectList;							
	private List<EmploymentTypes> employmentSelectList;					
	private List<DangerTypes> dangerSelectList;							
	private List<StatusTypes> statusSelectList;							
	

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
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
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
	public String newEnquiry(){
		/*
		 * this is line for how to get session. the user part below can be deleted, only for test
		 */
		Map<String, Object> session = ActionContext.getContext().getSession();
		//Users u = (Users) session.get("user");
		//System.out.println(u.getUsername());
		activateLists();
		
		iamodel = new Enquiries();
		ccontact = new Contacts();
		
		//form status setters
		today = new Date();
		java.sql.Date sqlDate = new java.sql.Date(today.getTime());
		iamodel.setCreatedDateTime(sqlDate);
		iamodel.setUpdatedDateTime(sqlDate);
		/*
		 * TODO: change the user to the session user.
		 */
		iamodel.setCreatedUserId(1);
		iamodel.setUpdatedUserId(1);
		
		//setAddress(new Addresses());
		address = new Addresses();
		setToday(sqlDate);
		setDob("");
		
		
		return SUCCESS;
	}

	/**
	 * Action Method to get an Existing Enquiry Form by id
	 * @return String
	 */
	public String getExistingEnquiry(){
		activateLists();
		//System.out.println(getHiddenid());

		setIamodel(services.getEnquiry(getHiddenid()));
		setCcontact(getIamodel().getContact());
		System.out.println(getIamodel().getEnquiryIssuesList().size());
		
		Date date = new Date(ccontact.getDob().getTime());
		//dob = DateUtil.yyyymmddStr(date);
		
		setDob(getCcontact().getDob().toString());
		
		linkedEnquiriesList = services.getLinkedEnquiry(getHiddenid());
		for(Enquiries le: linkedEnquiriesList){
			System.out.println("id " + le.getId());
		}
		
		System.out.println("hbm date = " + ccontact.getDob());
		//LATER
		//setCreatedBy();
		//setUpdatedBy(contact.);
		
		return SUCCESS;
	}
	
	String dob;
	
	
	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}
	
	public String updateLinkedEnquiries(){
		System.out.println("hidden id is " + getHiddenid());
		linkedEnquiriesList = services.getLinkedEnquiry(getHiddenid());
		System.out.println(getLinkedEnquiriesList().size());
		
		
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
	public String saveUpdateEnquiry() throws ParseException{ 
		
		List<Addresses> aList = getCcontact().getAddressesList();
		List<EnquiryIssues> iList = getIamodel().getEnquiryIssuesList();
		List<ClientDisabilities> dList = getCcontact().getDisabilitiesList();
		List<ContactEmployments> eList = getCcontact().getEmploymentsList();
		
		System.out.println("addressSet size " + getCcontact().getAddressesList().size());
		
		//today's date in sql format
		java.sql.Date sqlDate = new java.sql.Date(new Date().getTime());
		
//		/*******************
//		 * KIM HEERE
//		 */
//		getCcontact().setDob(new java.sql.Date(DateUtil.yyyymmddDate(getDob()).getTime()));
//		System.out.println(getCcontact().getDob());
//		/***************************/
		
        try {
		java.util.Date utilDate = DateUtil.yyyymmddDate(getDob());
		
		if (utilDate != null) {
			    getCcontact().setDob(new java.sql.Date(utilDate.getTime()));
			}
		} catch (Exception e) {
			System.out.println("dob error" + e);
		}
        /*
		 * Address component
		 */
		for(Addresses a: aList){
			if(a.getId() == null){
				//TODO: set created user and updated user to session user
				a.setCreatedUserId(1);
				a.setUpdatedUserId(1);
			}
		}
		
		
		/*
		 * Disability Component
		 */
		//TODO: check primary flag and mark as Y
		for(ClientDisabilities d: dList){
			System.out.println();
			if(d.getId() == null){
				
				//TODO: set created user and updated user to session user
				d.setCreatedUserId(1);
				d.setUpdatedUserId(1);
			}
		}
		
		/*
		 * Issue Component
		 */
		for(EnquiryIssues i: iList){
			System.out.println();
			if(i.getId() == null){
				
				//TODO: set created user and updated user to session user
				i.setCreatedUserId(1);
				i.setUpdatedUserId(1);
			}
		}
		
		/*
		 * Employment Component 
		 */
		for(ContactEmployments e: eList){
			System.out.println();
			if(e.getId() == null){
				
				//TODO: set created user and updated user to session user
				e.setCreatedUserId(1);
				e.setUpdatedUserId(1);
			}
		}
		
		/*
		 * Linked Enquiries Component;
		 */
		
		
		System.out.println("kim contact id " + getCcontact().getId());
		for (Addresses a : getCcontact().getAddressesList()){
			System.out.println("kim address id " + a.getId() + a.getStreet());
		}
		
		//printIamodel(iamodel);
		printContact(ccontact);
		
		if(services.saveOrUpdateEnquiry(getIamodel(), getCcontact())){
			activateLists();
			setCcontact(getCcontact());
			setIamodel(getIamodel());
			return SUCCESS;
		}
		activateLists();
		setCcontact(getCcontact());
		setIamodel(getIamodel());
		System.out.println("save unsuccessful");
		return ERROR;
	}

	
	/* 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * ----------------------------------------------------------------------------------------------------------
	 * ----------------------------------------------------------------------------------------------------------
	 * Other Methods & Setters and Getters
	 * ----------------------------------------------------------------------------------------------------------
	 * ----------------------------------------------------------------------------------------------------------*/

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
	
	public Contacts getCcontact() {
		return ccontact;
	}

	public void setCcontact(Contacts contact) {
		this.ccontact = contact;
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
			"\nreferred to: " + e.getReferralTo() +
			"\nparent enquiry id: " + e.getParentEnquiry().getId() );
		for (EnquiryIssues ei : e.getEnquiryIssuesList()) {
			System.out.println(
					"Enquiry Issue id: " + ei.getId() +
					"\nissue type: " + ei.getIssue().getIssueName() +
					"\ncomment: " + ei.getComment()
					);
		}
		for(Enquiries e2: e.getEnquiriesList()){
			System.out.println( "linked enquiry id: " + e2.getId());
		}
	
	}
}
