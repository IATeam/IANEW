package uow.ia.bean;

// Generated Aug 9, 2014 1:06:20 PM by Hibernate Tools 4.0.0

import java.util.Date;
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

	public Contacts() {
	}

	public Contacts(Integer id, TitleTypes titleType, String firstname,
			String lastname, String othername, GenderTypes genderType,
			ContactTypes contactType, String homephone, String workphone,
			String mobilephone, String email, AccommodationTypes accommodation,
			String accommodationComment, Integer employmentId,
			String employmentComment,
			CulturalBackgroundTypes culturalBackground,
			String culturalBackgroundComment, Integer dangerFlagId,
			String identification, Date dob, Set<Addresses> addressesSet) {
		super();
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
		this.employmentComment = employmentComment;
		this.culturalBackground = culturalBackground;
		this.culturalBackgroundComment = culturalBackgroundComment;
		this.identification = identification;
		this.dob = dob;
		this.addressesSet = addressesSet;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

//	public Integer getTitleId() {
//		return this.titleId;
//	}
//
//	public void setTitleId(Integer titleId) {
//		this.titleId = titleId;
//	}

	public TitleTypes getTitleType() {
		return titleType;
	}

	public void setTitleType(TitleTypes titleType) {
		this.titleType = titleType;
	}
	
	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getOthername() {
		return this.othername;
	}

	public void setOthername(String othername) {
		this.othername = othername;
	}

//	public Integer getGenderId() {
//		return this.genderId;
//	}
//
//	public void setGenderId(Integer genderId) {
//		this.genderId = genderId;
//	}
	

//	public Integer getContactTypeId() {
//		return this.contactTypeId;
//	}
//
//	public void setContactTypeId(Integer contactTypeId) {
//		this.contactTypeId = contactTypeId;
//	}

	public GenderTypes getGenderType() {
		return genderType;
	}

	public void setGenderType(GenderTypes genderType) {
		this.genderType = genderType;
	}

	public ContactTypes getContactType() {
		return contactType;
	}

	public void setContactType(ContactTypes contactType) {
		this.contactType = contactType;
	}

	public String getHomephone() {
		return this.homephone;
	}

	public void setHomephone(String homephone) {
		this.homephone = homephone;
	}

	public String getWorkphone() {
		return this.workphone;
	}

	public void setWorkphone(String workphone) {
		this.workphone = workphone;
	}

	public String getMobilephone() {
		return this.mobilephone;
	}

	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

//	public Integer getAccommodationId() {
//		return this.accommodationId;
//	}
//
//	public void setAccommodationId(Integer accommodationId) {
//		this.accommodationId = accommodationId;
//	}

	public String getAccommodationComment() {
		return this.accommodationComment;
	}

	public void setAccommodationComment(String accommodationComment) {
		this.accommodationComment = accommodationComment;
	}

//	public Integer getEmploymentId() {
//		return this.employmentId;
//	}
//
//	public void setEmploymentId(Integer employmentId) {
//		this.employmentId = employmentId;
//	}

	public EmploymentTypes getEmploymentType() {
		return employmentType;
	}

	public void setEmploymentType(EmploymentTypes employmentType) {
		this.employmentType = employmentType;
	}

	public String getEmploymentComment() {
		return this.employmentComment;
	}

	public void setEmploymentComment(String employmentComment) {
		this.employmentComment = employmentComment;
	}

//	public Integer getCulturalBackgroundId() {
//		return this.culturalBackgroundId;
//	}
//
//	public void setCulturalBackgroundId(Integer culturalBackgroundId) {
//		this.culturalBackgroundId = culturalBackgroundId;
//	}

	public CulturalBackgroundTypes getCulturalBackground() {
		return culturalBackground;
	}

	public void setCulturalBackground(CulturalBackgroundTypes culturalBackground) {
		this.culturalBackground = culturalBackground;
	}

	public String getCulturalBackgroundComment() {
		return this.culturalBackgroundComment;
	}

	public void setCulturalBackgroundComment(String culturalBackgroundComment) {
		this.culturalBackgroundComment = culturalBackgroundComment;
	}

//	public Integer getDangerFlagId() {
//		return this.dangerFlagId;
//	}
//
//	public void setDangerFlagId(Integer dangerFlagId) {
//		this.dangerFlagId = dangerFlagId;
//	}

	public DangerTypes getDangerType() {
		return dangerType;
	}

	public void setDangerType(DangerTypes dangerType) {
		this.dangerType = dangerType;
	}

	public String getIdentification() {
		return this.identification;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}

	public Date getDob() {
		return this.dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public AccommodationTypes getAccommodation() {
		return accommodation;
	}

	public void setAccommodation(AccommodationTypes accommodation) {
		this.accommodation = accommodation;
	}

	public Set<Addresses> getAddressesSet() {
		return addressesSet;
	}

	public void setAddressesSet(Set<Addresses> addressesSet) {
		this.addressesSet = addressesSet;
	}

}
