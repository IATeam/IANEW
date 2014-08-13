package uow.ia.bean;

// Generated Aug 9, 2014 1:06:20 PM by Hibernate Tools 4.0.0

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Contacts generated by hbm2java
 */
public class Contacts implements java.io.Serializable {

	private Integer id;
//	private Integer titleId;
	private TitleTypes titleType;
	private String firstname;
	private String lastname;
	private String othername;
//	private Integer genderId;
	private GenderTypes genderType;
//	private Integer contactTypeId;
	private ContactTypes contactType;
	private String homephone;
	private String workphone;
	private String mobilephone;
	private String email;
//	private Integer accommodationId;
	private AccommodationTypes accommodation;
	private String accommodationComment;
//	private Integer employmentId;
	private EmploymentTypes employmentType;
	private String employmentComment;
//	private Integer culturalBackgroundId;
	private CulturalBackgroundTypes culturalBackground;
	private String culturalBackgroundComment;
//	private Integer dangerFlagId;
	private DangerTypes dangerType;
	private String identification;
	private Date dob;
	private Set<Addresses> addressesSet;
	private Set<ClientDisabilities> disabilitiesSet;
	private Set<Enquiries> enquiriesSet;
//	private List<IndividualCases> individualCasesList;
	private Set<IndividualCases> individualCasesSet;

	/**
	 * 
	 */
	public Contacts() {
	}
	
	
	/**
	 * @param id
	 * @param titleType
	 * @param firstname
	 * @param lastname
	 * @param othername
	 * @param genderType
	 * @param contactType
	 * @param homephone
	 * @param workphone
	 * @param mobilephone
	 * @param email
	 * @param accommodation
	 * @param accommodationComment
	 * @param employmentType
	 * @param employmentComment
	 * @param culturalBackground
	 * @param culturalBackgroundComment
	 * @param dangerType
	 * @param identification
	 * @param dob
	 * @param addressesSet
	 * @param disabilitiesSet
	 * @param enquiriesSet
	 */
	public Contacts(Integer id, TitleTypes titleType, String firstname,
			String lastname, String othername, GenderTypes genderType,
			ContactTypes contactType, String homephone, String workphone,
			String mobilephone, String email, AccommodationTypes accommodation,
			String accommodationComment, EmploymentTypes employmentType,
			String employmentComment,
			CulturalBackgroundTypes culturalBackground,
			String culturalBackgroundComment, DangerTypes dangerType,
			String identification, Date dob, Set<Addresses> addressesSet,
			Set<ClientDisabilities> disabilitiesSet, Set<Enquiries> enquiriesSet) {
		this.id = id;
		this.titleType = titleType;
		this.firstname = firstname;
		this.lastname = lastname;
		this.othername = othername;
		this.genderType = genderType;
		this.contactType = contactType;
		this.homephone = homephone;
		this.workphone = workphone;
		this.mobilephone = mobilephone;
		this.email = email;
		this.accommodation = accommodation;
		this.accommodationComment = accommodationComment;
		this.employmentType = employmentType;
		this.employmentComment = employmentComment;
		this.culturalBackground = culturalBackground;
		this.culturalBackgroundComment = culturalBackgroundComment;
		this.dangerType = dangerType;
		this.identification = identification;
		this.dob = dob;
		this.addressesSet = addressesSet;
		this.disabilitiesSet = disabilitiesSet;
		this.enquiriesSet = enquiriesSet;
	}


	/**
	 * @return the id
	 */
	public Integer getId() {
		return this.id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the titleType
	 */
	public TitleTypes getTitleType() {
		return titleType;
	}
	/**
	 * @param titleType the titleType to set
	 */
	public void setTitleType(TitleTypes titleType) {
		this.titleType = titleType;
	}
	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return this.firstname;
	}
	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return this.lastname;
	}
	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	/**
	 * @return the othername
	 */
	public String getOthername() {
		return this.othername;
	}
	/**
	 * @param othername the othername to set
	 */
	public void setOthername(String othername) {
		this.othername = othername;
	}
	/**
	 * @return the genderType
	 */
	public GenderTypes getGenderType() {
		return genderType;
	}
	/**
	 * @param genderType the genderType to set
	 */
	public void setGenderType(GenderTypes genderType) {
		this.genderType = genderType;
	}
	/**
	 * @return the contactType
	 */
	public ContactTypes getContactType() {
		return contactType;
	}
	/**
	 * @param contactType the contactType to set
	 */
	public void setContactType(ContactTypes contactType) {
		this.contactType = contactType;
	}
	/**
	 * @return the homephone
	 */
	public String getHomephone() {
		return this.homephone;
	}
	/**
	 * @param homephone the homephone to set
	 */
	public void setHomephone(String homephone) {
		this.homephone = homephone;
	}
	/**
	 * @return the workphone
	 */
	public String getWorkphone() {
		return this.workphone;
	}
	/**
	 * @param workphone the workphone to set
	 */
	public void setWorkphone(String workphone) {
		this.workphone = workphone;
	}
	/**
	 * @return the mobilephone
	 */
	public String getMobilephone() {
		return this.mobilephone;
	}
	/**
	 * @param mobilephone the mobilephone to set
	 */
	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return this.email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the accommodation
	 */
	public AccommodationTypes getAccommodation() {
		return accommodation;
	}
	/**
	 * @param accommodation the accommodation to set
	 */
	public void setAccommodation(AccommodationTypes accommodation) {
		this.accommodation = accommodation;
	}
	/**
	 * @return the accommodationComment
	 */
	public String getAccommodationComment() {
		return this.accommodationComment;
	}
	/**
	 * @param accommodationComment the accommodationComment to set
	 */
	public void setAccommodationComment(String accommodationComment) {
		this.accommodationComment = accommodationComment;
	}
	/**
	 * @return the employmentType
	 */
	public EmploymentTypes getEmploymentType() {
		return employmentType;
	}
	/**
	 * @param employmentType the employmentType to set
	 */
	public void setEmploymentType(EmploymentTypes employmentType) {
		this.employmentType = employmentType;
	}
	/**
	 * @return the employmentComment
	 */
	public String getEmploymentComment() {
		return employmentComment;
	}
	/**
	 * @param employmentComment the employmentComment to set
	 */
	public void setEmploymentComment(String employmentComment) {
		this.employmentComment = employmentComment;
	}
	/**
	 * @return the culturalBackground
	 */
	public CulturalBackgroundTypes getCulturalBackground() {
		return culturalBackground;
	}
	/**
	 * @param culturalBackground the culturalBackground to set
	 */
	public void setCulturalBackground(CulturalBackgroundTypes culturalBackground) {
		this.culturalBackground = culturalBackground;
	}
	/**
	 * @return the culturalBackgroundComment
	 */
	public String getCulturalBackgroundComment() {
		return this.culturalBackgroundComment;
	}
	/**
	 * @param culturalBackgroundComment the culturalBackgroundComment to set
	 */
	public void setCulturalBackgroundComment(String culturalBackgroundComment) {
		this.culturalBackgroundComment = culturalBackgroundComment;
	}
	/**
	 * @return the dangerType
	 */
	public DangerTypes getDangerType() {
		return dangerType;
	}
	/**
	 * @param dangerType the dangerType to set
	 */
	public void setDangerType(DangerTypes dangerType) {
		this.dangerType = dangerType;
	}
	/**
	 * @return the identification
	 */
	public String getIdentification() {
		return identification;
	}
	/**
	 * @param identification the identification to set
	 */
	public void setIdentification(String identification) {
		this.identification = identification;
	}
	/**
	 * @return the dob
	 */
	public Date getDob() {
		return this.dob;
	}
	/**
	 * @param dob the dob to set
	 */
	public void setDob(Date dob) {
		this.dob = dob;
	}
	/**
	 * @return the addressesSet
	 */
	public Set<Addresses> getAddressesSet() {
		return addressesSet;
	}
	/**
	 * @param addressesSet the addressesSet to set
	 */
	public void setAddressesSet(Set<Addresses> addressesSet) {
		this.addressesSet = addressesSet;
	}
	/**
	 * @return the disabilitiesSet
	 */
	public Set<ClientDisabilities> getDisabilitiesSet() {
		return disabilitiesSet;
	}
	/**
	 * @param disabilitiesSet the disabilitiesSet to set
	 */
	public void setDisabilitiesSet(Set<ClientDisabilities> disabilitiesSet) {
		this.disabilitiesSet = disabilitiesSet;
	}
	/**
	 * @return the enquiriesSet
	 */
	public Set<Enquiries> getEnquiriesSet() {
		return enquiriesSet;
	}
	/**
	 * @param enquiriesSet the enquiriesSet to set
	 */
	public void setEnquiriesSet(Set<Enquiries> enquiriesSet) {
		this.enquiriesSet = enquiriesSet;
	}

	/**
	 * @return the individualCasesList
	 */
	public Set<IndividualCases> getIndividualCasesSet() {
		return individualCasesSet;
	}


	/**
	 * @param individualCasesList the individualCasesList to set
	 */
	public void setIndividualCasesSet(Set<IndividualCases> individualCasesSet) {
		this.individualCasesSet = individualCasesSet;
	}

	/**
	 * @auther ZhiYU Yang
	 * @return String - Contact's full name
	 * @
	 */
	public String getFullName() {
		return this.getFirstname() + " " + this.getLastname();
	}

}
