package uow.ia.bean;

// Generated Aug 9, 2014 1:06:20 PM by Hibernate Tools 4.0.0


import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import uow.ia.util.DateUtil;


/**
 * @author Kim To
 * @version 1.0.5, 30/08/2014
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
	private List<Addresses> addressesList = new ArrayList<Addresses>();
	private List<ClientDisabilities> disabilitiesList = new ArrayList<ClientDisabilities>();
	private List<Enquiries> enquiriesList = new ArrayList<Enquiries>();
	private List<IndividualCases> individualCasesList = new ArrayList<IndividualCases>();
	private List<ContactEmployments> employmentsList = new ArrayList<ContactEmployments>();
	private List<PlanDevelopers> planDevelopersList = new ArrayList<PlanDevelopers>();
	private List<IndividualCases> advocateCasesList = new ArrayList<IndividualCases>();
	
	
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
	 * @param timestamp
	 * @param addressesList
	 * @param disabilitiesList
	 * @param enquiriesList
	 * @param individualCasesList
	 * @param employmentsList
	 * @param planDevelopersList
	 * @param advocateCasesList
	 */
	public Contacts(Integer id, TitleTypes titleType, String firstname,
			String lastname, String othername, GenderTypes genderType,
			ContactTypes contactType, String mobilephone, String email,
			AccommodationTypes accommodation, String accommodationComment,
			CulturalBackgroundTypes culturalBackground,
			String culturalBackgroundComment, DangerTypes dangerType,
			String identification, Date dob, Integer createdUserId,
			Date createdDateTime, Integer updatedUserId, Date updatedDateTime,
			StatusTypes status, String timestamp,
			List<Addresses> addressesList,
			List<ClientDisabilities> disabilitiesList,
			List<Enquiries> enquiriesList,
			List<IndividualCases> individualCasesList,
			List<ContactEmployments> employmentsList,
			List<PlanDevelopers> planDevelopersList,
			List<IndividualCases> advocateCasesList) {
		super();
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
		this.timestamp = timestamp;
		this.addressesList = addressesList;
		this.disabilitiesList = disabilitiesList;
		this.enquiriesList = enquiriesList;
		this.individualCasesList = individualCasesList;
		this.employmentsList = employmentsList;
		this.planDevelopersList = planDevelopersList;
		this.advocateCasesList = advocateCasesList;
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
		return this.timestamp;
	}


	/**
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}


	/**
	 * @return the addressesList
	 */
	public List<Addresses> getAddressesList() {
		return this.addressesList;
	}

	/**
	 * @param addressesList the addressesList to set
	 */
	public void setAddressesList(List<Addresses> addressesList) {
		this.addressesList = addressesList;
	}

	/**
	 * @return the disabilitiesList
	 */
	public List<ClientDisabilities> getDisabilitiesList() {
		return this.disabilitiesList;
	}

	/**
	 * @param disabilitiesList the disabilitiesList to set
	 */
	public void setDisabilitiesList(List<ClientDisabilities> disabilitiesList) {
		this.disabilitiesList = disabilitiesList;
	}

	/**
	 * @return the enquiriesList
	 */
	public List<Enquiries> getEnquiriesList() {
		return this.enquiriesList;
	}

	/**
	 * @param enquiriesList the enquiriesList to set
	 */
	public void setEnquiriesList(List<Enquiries> enquiriesList) {
		this.enquiriesList = enquiriesList;
	}

	/**
	 * @return the individualCasesList
	 */
	public List<IndividualCases> getIndividualCasesList() {
		return this.individualCasesList;
	}

	/**
	 * @param individualCasesList the individualCasesList to set
	 */
	public void setIndividualCasesList(List<IndividualCases> individualCasesList) {
		this.individualCasesList = individualCasesList;
	}

	/**
	 * @return the employmentsList
	 */
	public List<ContactEmployments> getEmploymentsList() {
		return this.employmentsList;
	}

	/**
	 * @param employmentsList the employmentsList to set
	 */
	public void setEmploymentsList(List<ContactEmployments> employmentsList) {
		this.employmentsList = employmentsList;
	}

	/**
	 * @return the planDevelopersList
	 */
	public List<PlanDevelopers> getPlanDevelopersList() {
		return this.planDevelopersList;
	}

	/**
	 * @param planDevelopersList the planDevelopersList to set
	 */
	public void setPlanDevelopersList(List<PlanDevelopers> planDevelopersList) {
		this.planDevelopersList = planDevelopersList;
	}

	/**
	 * @return the advocateCasesList
	 */
	public List<IndividualCases> getAdvocateCasesList() {
		return this.advocateCasesList;
	}

	/**
	 * @param advocateCasesList the advocateCasesList to set
	 */
	public void setAdvocateCasesList(List<IndividualCases> advocateCasesList) {
		this.advocateCasesList = advocateCasesList;
	}

	public String getFullName() {
		return this.getFirstname() + " " + this.getLastname();
	}

	public String getDateString()
	{
		return uow.ia.util.DateUtil.yyyymmddStr(dob);
	}

}
