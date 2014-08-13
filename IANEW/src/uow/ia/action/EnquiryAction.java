package uow.ia.action;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import uow.ia.bean.AccommodationTypes;
import uow.ia.bean.Contacts;
import uow.ia.bean.CulturalBackgroundTypes;
import uow.ia.bean.DisabilityTypes;
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
 * @author Voom
 *
 */
/**
 * @author Voom
 *
 */
public class EnquiryAction extends BaseAction{
	
	/* 
	 * form title (can either be new enquiry/exisiting enquiry/enquiry list)
	 */
	String formTitle;;
	
	/*
	 * status
	 */
	Date createdDate;
	Date updatedDate;
	String createdBy;
	String updatedBy;
	
	Integer enquiryID;
	
	//drop down menu
	List<String> flagList; 			//Danger_Type table connected to Contacts table 
	List<String> status; 			//Status_Type or criteria control value table 
	
	
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
	String address;
	String city;
	String state;
	String country;
	String postCode;
	String homePhone;
	
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

	public String enquiryList(){
		//contacts=services.findContacts();
		//for(Contacts c:contacts) {
			//System.out.println(c.getAccommodation().toString());
		//}
		//System.out.println(contacts);
		return SUCCESS;
	}
	
	public String newEnquiry(){
		activateLists();
		return SUCCESS;
	}

	public String getEnquiry(){
		System.out.println("get (0iodfodf enquiry");
		activateLists();
		setAllFields();
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

}
