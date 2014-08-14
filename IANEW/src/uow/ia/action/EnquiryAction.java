package uow.ia.action;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import uow.ia.bean.AccommodationTypes;
import uow.ia.bean.Addresses;
import uow.ia.bean.Contacts;
import uow.ia.bean.CulturalBackgroundTypes;
import uow.ia.bean.DangerTypes;
import uow.ia.bean.DisabilityTypes;
import uow.ia.bean.Enquiries;
import uow.ia.bean.GenderTypes;
import uow.ia.bean.IssueTypes;
import uow.ia.bean.TitleTypes;
/*
 * Created By Quang Nhan,
 * Editor: David Forbes, Quang Nhan
 * Creaed On: 14/7/14
 * Last Updated On: 9/8/14
 * Description: Action class for enquiries
 */


/**
 * @author Quang
 *
 */
public class EnquiryAction extends BaseAction{
	
	/* 
	 * form title (can either be new enquiry/exisiting enquiry/enquiry list)
	 */
	String formTitle;;
	
	
	
	Enquiries enquiry;
	Contacts contact; //not calling from enquiry to allow 'CASE' to share the same include jsp
	Set<Addresses> address;
	
	String description;
	/*
	 * status
	 */
	Date createdDate;
	Date updatedDate;
	String createdBy;
	String updatedBy;
	
	Integer enquiryID;
	
	List<DangerTypes> dangerSelectList;
	String theDanger;
	
	//drop down menu
	List<String> flagList; 			//Danger_Type table connected to Contacts table 
	List<String> status; 			//Status_Type or criteria control value table 
	
	
	List<Enquiries> enquiryList;
	
	/*
	 * Personal Details
	 */
	//List<String> title; 
	List<TitleTypes> titleSelectList; 
	String theTitle; 	//
	//List<String> gender; 
	List<GenderTypes> genderSelectList; 
	String theGender;	//
	//List<String> culturalBackground;
	List<CulturalBackgroundTypes> culturalBackgroundSelectList;
	String theCulturalBackground; //
	Date birthDate;
	String firstName;
	String otherName;
	String lastName;
	String identification;
	String culturalBackgroundComments; 	//for cultural background
	String email; 						//need validation
	String mobile;						//need validation
	
	/*
	 * Address 
	 */
	//List<String> accomodation;
	List<AccommodationTypes> accommodationSelectList;
	String accommodationComments;
	/*String address;
	String city;
	String state;
	String country;
	String postCode;
	String homePhone;*/
	
	/*
	 * Referral
	 */
	String inquisitor;
	String referredBy;
	String referredTo;
	
	/*
	 * Employment
	 */
	String profession;
	String workPhone;
	String employmentDescription;
	String employmentComment;

	List<DisabilityTypes> disabilitySelectList;
	String theDisability;
	
	List<IssueTypes> issueSelectList;
	String theIssue;

	int hidden;
	
	public String enquiryList(){
		//contacts=services.findContacts();
		//for(Contacts c:contacts) {
			//System.out.println(c.getAccommodation().toString());
		//}
		//System.out.println(contacts);
		enquiryList = services.findEnquiries();
		return SUCCESS;
	}
	
	public String newEnquiry(){
		activateLists();
		return SUCCESS;
	}

	public String getExistingEnquiry(){
		System.out.println("The hdiden field is : " + hidden);
		enquiry = services.getEnquiry(hidden);
		contact = enquiry.getContact();
		//System.out.println("first name " + enquiry.getContact().getFirstname());
		
		
		activateLists();
		
		
		return SUCCESS;
	}
	
	//testing setter for all fields
	private void setAllFields(){
		//personal details
		
		
		/*setFirstName("Quang");
		setOtherName("Matt");
		setLastName("David");
		setIdentification("YangKim");
		setCulturalBackgroundComments("Long COmment...");
		setEmail("134@uow.edu.au");
		setMobile("0403020100");
		
		//address
		
		
		setAccomodationComments("this is a great place to live");
		setAddress("445 FFid Street");
		setCity("Wollongong");
		setState("NSW");
		setPostCode("2111");
		setHomePhone("09202002");
		
		//employment
		setProfession("Lecturer");
		setWorkPhone("97665432");
		setEmploymentDescription("employment descriptino");
		setEmploymentComment("employment comment");
		
		//referrals
		setReferredBy("Georgiei");*/
	}
	
	private void activateLists(){
		titleSelectList=services.findTitleTypes();
		genderSelectList=services.findGenderTypes();
		culturalBackgroundSelectList=services.findCulturalBackgroundTypes();
		accommodationSelectList = services.findAccommodationTypes();
		disabilitySelectList = services.findDisabilityTypes();
		issueSelectList = services.findIssueTypes();
		dangerSelectList = services.findDangerTypes();
		
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

	public List<Enquiries> getEnquiryList() {
		return enquiryList;
	}

	public void setEnquiryList(List<Enquiries> enquiryList) {
		this.enquiryList = enquiryList;
	}

	public List<DangerTypes> getDangerSelectList() {
		return dangerSelectList;
	}

	public int getHidden() {
		return hidden;
	}

	/**
	 * @param hidden
	 */
	public void setHidden(int hidden) {
		this.hidden = hidden;
	}

	/**
	 * @param enquiry
	 */
	public void setEnquiry(Enquiries enquiry) {
		this.enquiry = enquiry;
	}

	public Enquiries getEnquiry(){
		return enquiry;
	}

	public Contacts getContact() {
		return contact;
	}

	public void setContact(Contacts contact) {
		this.contact = contact;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
}
