package uow.ia.action;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import uow.ia.bean.AccommodationTypes;
import uow.ia.bean.Contacts;
import uow.ia.bean.CulturalBackgroundTypes;
import uow.ia.bean.GenderTypes;
import uow.ia.bean.TitleTypes;


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
	List<TitleTypes> title; 
	String theTitle; 	//
	//List<String> gender; 
	List<GenderTypes> gender; 
	String theGender;	//
	//List<String> culturalBackground;
	List<CulturalBackgroundTypes> culturalBackground;
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
	List<AccommodationTypes> accomodation;
	String accomodationComments;
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
	
	List<Contacts> contacts;
	public String enquiryList(){
		//contacts=services.findContacts();
		//for(Contacts c:contacts) {
			//System.out.println(c.getAccommodation().toString());
		//}
		//System.out.println(contacts);
		return SUCCESS;
	}
	
	public List<Contacts> getContacts() {
		return contacts;
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
		
		
		setFirstName("Quang");
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
		setReferredBy("Georgiei");
	}
	
	private void activateLists(){
		title=services.findTitleTypes();
		gender=services.findGenderTypes();
		culturalBackground=services.findCulturalBackgroundTypes();
		accomodation = services.findAccommodationTypes();
		//List<String> tit = new ArrayList<String>();
		//tit.add("Mr");
		//tit.add("Mrs");
		//setTitle(tit);
		
		//List<String> gen = new ArrayList<String>();
		//gen.add("Male");
		//gen.add("Female");
		//setGender(gen);
		
		//List<String> cult = new ArrayList<String>();
		//cult.add("aussie");
		//cult.add("oi");
		//setCulturalBackground(cult);
		/*
		List<String> acco = new ArrayList<String>();
		acco.add("Acc1");
		acco.add("Acc2");
		setTitle(acco);
		*/
	}
	
	/*
	 * title
	 */
	public String getFormTitle() {
		return formTitle;
	}

	public void setFormTitle(String formTitle) {
		System.out.println(formTitle);
		this.formTitle = formTitle;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Integer getEnquiryID() {
		return enquiryID;
	}

	public void setEnquiryID(Integer enquiryID) {
		this.enquiryID = enquiryID;
	}

	public List<String> getFlagList() {
		return flagList;
	}

	public void setFlagList(List<String> flagList) {
		this.flagList = flagList;
	}

	public List<String> getStatus() {
		return status;
	}

	public void setStatus(List<String> status) {
		this.status = status;
	}

	public List<TitleTypes> getTitle() {
		return title;
	}

	public void setTitle(List<TitleTypes> title) {
		this.title = title;
	}

	public List<GenderTypes> getGender() {
		return gender;
	}

	public void setGender(List<GenderTypes> gender) {
		this.gender = gender;
	}

	public List<CulturalBackgroundTypes> getCulturalBackground() {
		return culturalBackground;
	}

	public void setCulturalBackground(List<CulturalBackgroundTypes> culturalBackground) {
		this.culturalBackground = culturalBackground;
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

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getOtherName() {
		return otherName;
	}

	public void setOtherName(String otherName) {
		this.otherName = otherName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getIdentification() {
		return identification;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}

	public String getCulturalBackgroundComments() {
		return culturalBackgroundComments;
	}

	public void setCulturalBackgroundComments(String culturalBackgroundComments) {
		this.culturalBackgroundComments = culturalBackgroundComments;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String string) {
		this.mobile = string;
	}

	public List<AccommodationTypes> getAccomodation() {
		return accomodation;
	}

	public void setAccomodation(List<AccommodationTypes> accomodation) {
		this.accomodation = accomodation;
	}

	public String getAccomodationComments() {
		return accomodationComments;
	}

	public void setAccomodationComments(String accomodationComments) {
		this.accomodationComments = accomodationComments;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getInquisitor() {
		return inquisitor;
	}

	public void setInquisitor(String inquisitor) {
		this.inquisitor = inquisitor;
	}

	public String getReferredBy() {
		return referredBy;
	}

	public void setReferredBy(String referredBy) {
		this.referredBy = referredBy;
	}

	public String getReferredTo() {
		return referredTo;
	}

	public void setReferredTo(String referredTo) {
		this.referredTo = referredTo;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getWorkPhone() {
		return workPhone;
	}

	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}

	public String getEmploymentDescription() {
		return employmentDescription;
	}

	public void setEmploymentDescription(String employmentDescription) {
		this.employmentDescription = employmentDescription;
	}

	public String getEmploymentComment() {
		return employmentComment;
	}

	public void setEmploymentComment(String employmentComment) {
		this.employmentComment = employmentComment;
	}
	
	
}
