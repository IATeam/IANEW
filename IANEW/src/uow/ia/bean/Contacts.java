package uow.ia.bean;

// Generated Aug 9, 2014 1:06:20 PM by Hibernate Tools 4.0.0


import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Kim To
 * @version 1.0.4, 29/08/2014
 */
public class Contacts implements java.io.Serializable {

	private Integer id;
	private TitleTypes titleType;
	private String firstname;
	private String lastname;
	private String othername;
	private GenderTypes genderType;
	private ContactTypes contactType;
	private String mobilephone;
	private String email;
	private AccommodationTypes accommodation;
	private String accommodationComment;
	private CulturalBackgroundTypes culturalBackground;
	private String culturalBackgroundComment;
	private DangerTypes dangerType;
	private String identification;
	private Date dob;
	private Integer createdUserId;
	private Date createdDateTime;
	private Integer updatedUserId;
	private Date updatedDateTime;
	private StatusTypes status;
	private String timestamp;
	private Set<Addresses> addressesSet = new HashSet<Addresses>();
	private Set<ClientDisabilities> disabilitiesSet = new HashSet<ClientDisabilities>();
	private Set<Enquiries> enquiriesSet = new HashSet<Enquiries>();
	private Set<IndividualCases> individualCasesSet = new HashSet<IndividualCases>();
	private Set<ContactEmployments> employmentsSet = new HashSet<ContactEmployments>();
	private Set<PlanDevelopers> planDevelopersSet = new HashSet<PlanDevelopers>();
	private Set<IndividualCases> advocateCasesSet = new HashSet<IndividualCases>();
	
	
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
	 * @param mobilephone
	 * @param email
	 * @param accommodation
	 * @param accommodationComment
	 * @param culturalBackground
	 * @param culturalBackgroundComment
	 * @param dangerType
	 * @param identification
	 * @param dob
	 * @param createdUserId
	 * @param createdDateTime
	 * @param updatedUserId
	 * @param updatedDateTime
	 * @param status
	 * @param addressesSet
	 * @param disabilitiesSet
	 * @param enquiriesSet
	 * @param individualCasesSet
	 * @param employmentsSet
	 * @param planDevelopersSet
	 * @param advocateCasesSet
	 */
	public Contacts(Integer id, TitleTypes titleType, String firstname,
			String lastname, String othername, GenderTypes genderType,
			ContactTypes contactType, String mobilephone, String email,
			AccommodationTypes accommodation, String accommodationComment,
			CulturalBackgroundTypes culturalBackground,
			String culturalBackgroundComment, DangerTypes dangerType,
			String identification, Date dob, Integer createdUserId,
			Date createdDateTime, Integer updatedUserId, Date updatedDateTime,
			StatusTypes status, Set<Addresses> addressesSet,
			Set<ClientDisabilities> disabilitiesSet,
			Set<Enquiries> enquiriesSet,
			Set<IndividualCases> individualCasesSet,
			Set<ContactEmployments> employmentsSet,
			Set<PlanDevelopers> planDevelopersSet,
			Set<IndividualCases> advocateCasesSet) {
		this.id = id;
		this.titleType = titleType;
		this.firstname = firstname;
		this.lastname = lastname;
		this.othername = othername;
		this.genderType = genderType;
		this.contactType = contactType;
		this.mobilephone = mobilephone;
		this.email = email;
		this.accommodation = accommodation;
		this.accommodationComment = accommodationComment;
		this.culturalBackground = culturalBackground;
		this.culturalBackgroundComment = culturalBackgroundComment;
		this.dangerType = dangerType;
		this.identification = identification;
		this.dob = dob;
		this.createdUserId = createdUserId;
		this.createdDateTime = createdDateTime;
		this.updatedUserId = updatedUserId;
		this.updatedDateTime = updatedDateTime;
		this.status = status;
		this.addressesSet = addressesSet;
		this.disabilitiesSet = disabilitiesSet;
		this.enquiriesSet = enquiriesSet;
		this.individualCasesSet = individualCasesSet;
		this.employmentsSet = employmentsSet;
		this.planDevelopersSet = planDevelopersSet;
		this.advocateCasesSet = advocateCasesSet;
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
		return this.titleType;
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
		return this.genderType;
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
		return this.contactType;
	}
	/**
	 * @param contactType the contactType to set
	 */
	public void setContactType(ContactTypes contactType) {
		this.contactType = contactType;
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
		return this.accommodation;
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
	 * @return the culturalBackground
	 */
	public CulturalBackgroundTypes getCulturalBackground() {
		return this.culturalBackground;
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
		return this.dangerType;
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
		return this.identification;
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
	 * @return the createdUserId
	 */
	public Integer getCreatedUserId() {
		return this.createdUserId;
	}




	/**
	 * @param createdUserId the createdUserId to set
	 */
	public void setCreatedUserId(Integer createdUserId) {
		this.createdUserId = createdUserId;
	}




	/**
	 * @return the createdDateTime
	 */
	public Date getCreatedDateTime() {
		return this.createdDateTime;
	}




	/**
	 * @param createdDateTime the createdDateTime to set
	 */
	public void setCreatedDateTime(Date createdDateTime) {
		this.createdDateTime = createdDateTime;
	}




	/**
	 * @return the updatedUserId
	 */
	public Integer getUpdatedUserId() {
		return this.updatedUserId;
	}




	/**
	 * @param updatedUserId the updatedUserId to set
	 */
	public void setUpdatedUserId(Integer updatedUserId) {
		this.updatedUserId = updatedUserId;
	}




	/**
	 * @return the updatedDateTime
	 */
	public Date getUpdatedDateTime() {
		return this.updatedDateTime;
	}




	/**
	 * @param updatedDateTime the updatedDateTime to set
	 */
	public void setUpdatedDateTime(Date updatedDateTime) {
		this.updatedDateTime = updatedDateTime;
	}




	/**
	 * @return the status
	 */
	public StatusTypes getStatus() {
		return this.status;
	}




	/**
	 * @param status the status to set
	 */
	public void setStatus(StatusTypes status) {
		this.status = status;
	}






	/**
	 * @return the timestamp
	 */
	public String getTimestamp() {
		return timestamp;
	}


	/**
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}


	/**
	 * @return the addressesSet
	 */
	public Set<Addresses> getAddressesSet() {
		return this.addressesSet;
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
		return this.disabilitiesSet;
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
		return this.enquiriesSet;
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
		return this.individualCasesSet;
	}


	/**
	 * @param individualCasesList the individualCasesList to set
	 */
	public void setIndividualCasesSet(Set<IndividualCases> individualCasesSet) {
		this.individualCasesSet = individualCasesSet;
	}

	/**
	 * @return the employmentsSet
	 */
	public Set<ContactEmployments> getEmploymentsSet() {
		return this.employmentsSet;
	}


	/**
	 * @param employmentsSet the employmentsSet to set
	 */
	public void setEmploymentsSet(Set<ContactEmployments> employmentsSet) {
		this.employmentsSet = employmentsSet;
	}

	/**
	 * @return the planDevelopersSet
	 */
	public Set<PlanDevelopers> getPlanDevelopersSet() {
		return this.planDevelopersSet;
	}


	/**
	 * @param planDevelopersSet the planDevelopersSet to set
	 */
	public void setPlanDevelopersSet(Set<PlanDevelopers> planDevelopersSet) {
		this.planDevelopersSet = planDevelopersSet;
	}


	/**
	 * @return the advocateCasesSet
	 */
	public Set<IndividualCases> getAdvocateCasesSet() {
		return this.advocateCasesSet;
	}


	/**
	 * @param advocateCasesSet the advocateCasesSet to set
	 */
	public void setAdvocateCasesSet(Set<IndividualCases> advocateCasesSet) {
		this.advocateCasesSet = advocateCasesSet;
	}


	public String getFullName() {
		return this.getFirstname() + " " + this.getLastname();
	}

}
