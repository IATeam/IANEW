package uow.ia.action;

import java.util.List;

import uow.ia.bean.AccommodationTypes;
import uow.ia.bean.CommunicationTypes;
import uow.ia.bean.Contacts;
import uow.ia.bean.CulturalBackgroundTypes;
import uow.ia.bean.DangerTypes;
import uow.ia.bean.DisabilityTypes;
import uow.ia.bean.EmploymentTypes;
import uow.ia.bean.EnquiryTypes;
import uow.ia.bean.GenderTypes;
import uow.ia.bean.GoalTypes;
import uow.ia.bean.IssueTypes;
import uow.ia.bean.PriorityTypes;
import uow.ia.bean.StatusTypes;
import uow.ia.bean.TitleTypes;

import com.opensymphony.xwork2.Preparable;

/**
 * @author David Forbes
 * @date 09/09/2014 
 * 				
 */
public class AdminAction extends BaseAction implements Preparable{	
	
	/* 
	 * 
	 * ----------------------------------------------------------------------------------------------------------
	 * ----------------------------------------------------------------------------------------------------------
	 * Admin page start up Method
	 * ----------------------------------------------------------------------------------------------------------
	 * ----------------------------------------------------------------------------------------------------------*/
	/**	 * 	
	 * 		Start Method for Admin page		
	 * 				
	 */
	public String startAdminPage(){ 
		setDisabilitySelectList(adminService.findDisabilityTypes());
		setIssueTypeList(adminService.findIssueTypes());
		setAccommodationSelectList(adminService.findAccommodationTypes());
		setCulturalBackgroundSelectList(adminService.findCulturalBackgroundTypes());
		setDangerSelectList(adminService.findDangerTypes());
		setEmploymentSelectList(adminService.findEmploymentTypes());
		setEnquiryTypeSelectList(adminService.findEnquiryTypes());
		setGenderSelectList(adminService.findGenderTypes());
		setStatusSelectList(adminService.findStatusTypes());
		setTitleSelectList(adminService.findTitleTypes());
		setContactsSelectList(adminService.findContacts());
		setCommunicationSelectList(adminService.findCommunicationTypes());
		setGoalSelectList(adminService.findGoalTypes());
		setPrioritySelectList(adminService.findPriorityTypes());
		
		return SUCCESS;
	}
	

	
	/**
	 * 		Accommodation Type Fields & Methods		
	 * 				
	 */
	private AccommodationTypes accommodationType;
	private String accommodationName;
	private String accommodationDescription;
	private List<AccommodationTypes> accommodationSelectList;	

	
	/**	
	 * 		Accommodation Type ActionMethods		
	 * 				
	 */
	
	
	/**	
	 * 	getAccommodationTypeForm
	 * 	@return String		
	 * 				
	 */
	public String getAccommodationTypeForm(){
		return SUCCESS;
	}
	
	/**	
	 * 	saveNewAccommodationType - saves a new Accommodation type
	 * 	@return String		
	 * 				
	 */
	public String saveNewAccommodationType(){
		List<AccommodationTypes> accommodationTypeList = adminService.findAccommodationTypes();
		boolean exists = false;
		
		for(AccommodationTypes at: accommodationTypeList){
			if(getAccommodationName().equals(at.getAccommodationName())){
				exists = true;
				break;
			}
		}
		
		if(exists){
			//asks the user to renter again.
			return INPUT;
		}
		System.out.println("in saving distype");
		accommodationType = new AccommodationTypes();
		accommodationType.setAccommodationName(getAccommodationName());
		accommodationType.setAccommodationDescription(getAccommodationDescription());
		System.out.println("name: " + getAccommodationName());
		System.out.println("description: " + getAccommodationDescription());
		if(adminService.saveAccommodationType(accommodationType)){
			accommodationSelectList = adminService.findAccommodationTypes();
			return SUCCESS;
		}
		else {
			return ERROR;
		}
	}
	
	/**	
	 * updateAccommodationTypes - updates the list of Accommodation types
	 * 	@return String
	 * 					
	 */
	public String updateAccommodationTypes(){
		for(AccommodationTypes at: getAccommodationSelectList())
			adminService.updateAccommodationType(at);
		return SUCCESS;
	}
	
	/**
	 * 		Accommodation Getters & Setters		
	 * 				  
	 */
	
	/**	
	 * 	getAccommodationName
	 * 	@return String		
	 * 				
	 */
	public String getAccommodationName() {
		return accommodationName;
	}

	/**	
	 * 	setAccommodationName
	 * 	@param accommodationName String		
	 * 				
	 */
	public void setAccommodationName(String accommodationName) {
		this.accommodationName = accommodationName;
	}

	/**	
	 * 	getAccommodationDescription
	 * 	@return String		
	 * 				
	 */
	public String getAccommodationDescription() {
		return accommodationDescription;
	}

	/**	
	 * 	setAccommodationDescription
	 * 	@param accommodationDescription String		
	 * 				
	 */
	public void setAccommodationDescription(String accommodationDescription) {
		this.accommodationDescription = accommodationDescription;
	}

	/**	
	 * 	getAccommodationSelectList
	 * 	@return List<AccommodationTypes>		
	 * 				
	 */
	public List<AccommodationTypes> getAccommodationSelectList() {
		return accommodationSelectList;
	}

	/**	
	 * 	setAccommodationSelectList
	 * 	@param accommodationSelectList List<AccommodationTypes> 		
	 * 				
	 */
	public void setAccommodationSelectList(List<AccommodationTypes> accommodationSelectList) {
		this.accommodationSelectList = accommodationSelectList;
	}
	
	/**
	 * 		Cultural Background Type Fields & Methods		
	 * 				
	 */
	private CulturalBackgroundTypes culturalBackgroundType;
	private String culturalBackgroundName;
	private String culturalBackgroundDescription;
	private List<CulturalBackgroundTypes> culturalBackgroundSelectList;	

	/**
	 * 		culturalBackground Type ActionMethods		
	 * 				
	 */
	
	/**	
	 * 	getCulturalBackgroundTypeForm
	 * 	@return String		
	 * 				
	 */
	public String getCulturalBackgroundTypeForm(){
		return SUCCESS;
	}
	
	/**	
	 * 	saveNewculturalBackgroundType - saves a new Cultural Background type
	 * 	@return String		
	 * 				
	 */
	public String saveNewculturalBackgroundType(){
		List<CulturalBackgroundTypes> culturalBackgroundTypeList = adminService.findCulturalBackgroundTypes();
		boolean exists = false;
		
		for(CulturalBackgroundTypes cbt: culturalBackgroundTypeList){
			if(getCulturalBackgroundName().equals(cbt.getCulturalBackgroundName())){
				exists = true;
				break;
			}
		}
		
		if(exists){
			//asks the user to renter again.
			return INPUT;
		}
		System.out.println("in saving distype");
		culturalBackgroundType = new CulturalBackgroundTypes();
		culturalBackgroundType.setCulturalBackgroundName(culturalBackgroundName);
		culturalBackgroundType.setCulturalBackgroundDescription(culturalBackgroundDescription);
		System.out.println("name: " + getCulturalBackgroundName());
		System.out.println("description: " + getCulturalBackgroundDescription());
		if(adminService.saveCulturalBackgroundType(culturalBackgroundType)){
			culturalBackgroundSelectList = adminService.findCulturalBackgroundTypes();
			return SUCCESS;
		}
		else {
			return ERROR;
		}
	}
	
	/**	
	 * updateCultualBackgroundType - updates the list of Cultural Background types
	 * 	@return String
	 * 					
	 */
	public String updateCultualBackgroundType(){
		System.out.println("Struts: start updateCulturalType");
		for(CulturalBackgroundTypes ct: getCulturalBackgroundSelectList())
			adminService.updateCulturalBackgroundType(ct);
		System.out.println("Struts: end updateCulturalType");
		return SUCCESS;
	}
	
	/**
	 * @author davidforbes
	 * @date 13/09/2014 -	
	 * 		CulturalBackground Getters & Setters		
	 * 				  
	 */
	
	/**	
	 * 	getCulturalBackgroundType
	 * 	@return CulturalBackgroundTypes		
	 * 				
	 */
	public CulturalBackgroundTypes getCulturalBackgroundType() {
		return culturalBackgroundType;
	}

	/**	
	 * 	setCulturalBackgroundType
	 * 	@param culturalBackgroundType CulturalBackgroundTypes 		
	 * 				
	 */
	public void setCulturalBackgroundType(CulturalBackgroundTypes culturalBackgroundType) {
		this.culturalBackgroundType = culturalBackgroundType;
	}

	/**	
	 * 	getCulturalBackgroundName
	 * 	@return String		
	 * 				
	 */
	public String getCulturalBackgroundName() {
		return culturalBackgroundName;
	}

	/**	
	 * 	setCulturalBackgroundName
	 * 	@param culturalBackgroundName String 		
	 * 				
	 */
	public void setCulturalBackgroundName(String culturalBackgroundName) {
		this.culturalBackgroundName = culturalBackgroundName;
	}

	/**	
	 * 	getCulturalBackgroundDescription
	 * 	@return String		
	 * 				
	 */
	public String getCulturalBackgroundDescription() {
		return culturalBackgroundDescription;
	}

	/**	
	 * 	setCulturalBackgroundDescription
	 * 	@param culturalBackgroundDescription String 		
	 * 				
	 */
	public void setCulturalBackgroundDescription(String culturalBackgroundDescription) {
		this.culturalBackgroundDescription = culturalBackgroundDescription;
	}

	/**	
	 * 	getCulturalBackgroundSelectList
	 * 	@return List<CulturalBackgroundTypes>		
	 * 				
	 */
	public List<CulturalBackgroundTypes> getCulturalBackgroundSelectList() {
		return culturalBackgroundSelectList;
	}

	/**	
	 * 	setCulturalBackgroundSelectList
	 * 	@param culturalBackgroundSelectList List<CulturalBackgroundTypes> 		
	 * 				
	 */
	public void setCulturalBackgroundSelectList(List<CulturalBackgroundTypes> culturalBackgroundSelectList) {
		this.culturalBackgroundSelectList = culturalBackgroundSelectList;
	}
	
	/**
	 * 		Danger Types Fields & Methods		
	 * 				
	 */
	private DangerTypes dangerType;
	private String dangerName;
	private String dangerDescription;
	private List<DangerTypes> dangerSelectList;							

	
	/**
	 * 		Danger Types ActionMethods		
	 * 				
	 */
	
	/**	
	 * 	getDangerTypeForm
	 * 	@return String		
	 * 				
	 */
	public String getDangerTypeForm(){
		return SUCCESS;
	}
	
	/**	
	 * 	saveNewDangerType - saves a new Danger type
	 * 	@return String		
	 * 				
	 */
	public String saveNewDangerType(){
		List<DangerTypes> dangerTypeList = adminService.findDangerTypes();
		boolean exists = false;
		
		for(DangerTypes dt: dangerTypeList){
			if(getDangerName().equals(dt.getDangerName())){
				exists = true;
				break;
			}
		}
		
		if(exists){
			//asks the user to renter again.
			return INPUT;
		}
		System.out.println("in saving distype");
		dangerType = new DangerTypes();
		dangerType.setDangerName(getDangerName());
		dangerType.setDangerDescription(getDangerDescription());
		System.out.println("name: " + getDangerName());
		System.out.println("description: " + getDangerDescription());
		if(adminService.saveDangerType(dangerType)){
			dangerSelectList = adminService.findDangerTypes();
			return SUCCESS;
		}
		else {
			return ERROR;
		}
	}
	
	/**	
	 * updateDangerType - updates the list of Danger types
	 * 	@return String
	 * 					
	 */
	public String updateDangerType(){
		System.out.println("Struts: start updateDangerType");
		for(DangerTypes dt: getDangerSelectList())
			adminService.updateDangerType(dt);
		System.out.println("Struts: end updateDangerType");
		return SUCCESS;		
	}
	
	/**
	 * 		Danger Types Getters & Setters		
	 * 				  
	 */
	
	/**	
	 * 	setDangerType
	 * 	@param dangerType DangerTypes		
	 * 				
	 */
	public void setDangerType(DangerTypes dangerType) {
		this.dangerType = dangerType;
	}

	/**	
	 * 	getDangerName
	 * 	@return String		
	 * 				
	 */
	public String getDangerName() {
		return dangerName;
	}

	/**	
	 * 	setDangerName
	 * 	@param dangerName String		
	 * 				
	 */
	public void setDangerName(String dangerName) {
		this.dangerName = dangerName;
	}

	/**	
	 * 	getDangerDescription
	 * 	@return String		
	 * 				
	 */
	public String getDangerDescription() {
		return dangerDescription;
	}

	/**	
	 * 	setDangerDescription
	 * 	@param dangerDescription String		
	 * 				
	 */
	public void setDangerDescription(String dangerDescription) {
		this.dangerDescription = dangerDescription;
	}

	/**	
	 * 	getDangerSelectList
	 * 	@return List<DangerTypes>		
	 * 				
	 */
	public List<DangerTypes> getDangerSelectList() {
		return dangerSelectList;
	}

	/**	
	 * 	setDangerSelectList
	 * 	@param dangerSelectList List<DangerTypes>		
	 * 				
	 */
	public void setDangerSelectList(List<DangerTypes> dangerSelectList) {
		this.dangerSelectList = dangerSelectList;
	}
	
	/**
	 * 		Employment Types Fields & Methods		
	 * 				
	 */
	
	private EmploymentTypes employmentType;
	private String employmentName;
	private String employmentDescription;
	private List<EmploymentTypes> employmentSelectList;					

	
	/**
	 * 		Employment Types ActionMethods		
	 * 				
	 */
	
	/**	
	 * 	getEmploymentTypeForm
	 * 	@return String		
	 * 				
	 */
	public String getEmploymentTypeForm(){
		return SUCCESS;
	}
	
	/**	
	 * 	saveNewEmploymentType - saves a new Employment type
	 * 	@return String		
	 * 				
	 */
	public String saveNewEmploymentType(){
		List<EmploymentTypes> employmentTypeList = adminService.findEmploymentTypes();
		boolean exists = false;
		
		for(EmploymentTypes et: employmentTypeList){
			if(getEmploymentName().equals(et.getEmploymentName())){
				exists = true;
				break;
			}
		}
		
		if(exists){
			//asks the user to renter again.
			return INPUT;
		}
		System.out.println("in saving distype");
		employmentType = new EmploymentTypes();
		employmentType.setEmploymentName(getEmploymentName());
		employmentType.setEmploymentDescription(getEmploymentDescription());
		System.out.println("name: " + getEmploymentName());
		System.out.println("description: " + getEmploymentDescription());
		if(adminService.saveEmploymentType(employmentType)){
			employmentSelectList = adminService.findEmploymentTypes();
			return SUCCESS;
		}
		else {
			return ERROR;
		}
	}
	
	/**	
	 * updateEmploymentType - updates the list of Employment types
	 * 	@return String
	 * 					
	 */
	public String updateEmploymentType(){
		for(EmploymentTypes et: getEmploymentSelectList())
			adminService.updateEmploymentType(et);
		return SUCCESS;
	}
	
	/**
	 * 		Employment Types Getters & Setters		
	 * 				  
	 */
	
	/**	
	 * 	getEmploymentName
	 * 	@return String		
	 * 				
	 */
	public String getEmploymentName() {
		return employmentName;
	}

	/**	
	 * 	setEmploymentName
	 * 	@param employmentName String		
	 * 				
	 */
	public void setEmploymentName(String employmentName) {
		this.employmentName = employmentName;
	}

	/**	
	 * 	getEmploymentDescription
	 * 	@return String		
	 * 				
	 */
	public String getEmploymentDescription() {
		return employmentDescription;
	}

	/**	
	 * 	setEmploymentDescription
	 * 	@param employmentDescription String		
	 * 				
	 */
	public void setEmploymentDescription(String employmentDescription) {
		this.employmentDescription = employmentDescription;
	}

	/**	
	 * 	getEmploymentType
	 * 	@return EmploymentTypes		
	 * 				
	 */
	public EmploymentTypes getEmploymentType() {
		return employmentType;
	}

	/**	
	 * 	setEmploymentType
	 * 	@param employmentType EmploymentTypes		
	 * 				
	 */
	public void setEmploymentType(EmploymentTypes employmentType) {
		this.employmentType = employmentType;
	}

	/**	
	 * 	getEmploymentSelectList
	 * 	@return List<EmploymentTypes>		
	 * 				
	 */
	public List<EmploymentTypes> getEmploymentSelectList() {
		return employmentSelectList;
	}

	/**	
	 * 	setEmploymentSelectList
	 * 	@param employmentSelectList List<EmploymentTypes>		
	 * 				
	 */
	public void setEmploymentSelectList(List<EmploymentTypes> employmentSelectList) {
		this.employmentSelectList = employmentSelectList;
	}
	
	
	/**
	 * 		Enquiry Types Fields & Methods		
	 * 				
	 */
	
	private EnquiryTypes enquiryType;
	private String enquiryTypeName;
	private String enquiryTypeDescription;
	private List<EnquiryTypes> enquiryTypeSelectList;					

	
	/**
	 * 		Enquiry Types ActionMethods		
	 * 				
	 */
	
	/**	
	 * 	getEnquiryTypeForm
	 * 	@return String
	 * 				
	 */
	public String getEnquiryTypeForm(){
		return SUCCESS;
	}
	
	/**	
	 * 	saveNewEnquiryType - saves a new Enquiry type
	 * 	@return String		
	 * 				
	 */
	public String saveNewEnquiryType(){
		List<EnquiryTypes> enquiryTypeList = adminService.findEnquiryTypes();
		boolean exists = false;
		
		for(EnquiryTypes enqt: enquiryTypeList){
			if(getEnquiryTypeName().equals(enqt.getEnquiryTypeName())){
				exists = true;
				break;
			}
		}
		
		if(exists){
			//asks the user to renter again.
			return INPUT;
		}
		System.out.println("in saving distype");
		enquiryType = new EnquiryTypes();
		enquiryType.setEnquiryTypeName(getEnquiryTypeName());
		enquiryType.setEnquiryTypeDescription(getEnquiryTypeDescription());
		System.out.println("name: " + getEnquiryTypeName());
		System.out.println("description: " + getEnquiryTypeDescription());
		if(adminService.saveEnquiryType(enquiryType)){
			enquiryTypeSelectList = adminService.findEnquiryTypes();
			return SUCCESS;
		}
		else {
			return ERROR;
		}
	}
	
	/**	
	 * updateEnquiryType - updates the list of Enquiry types
	 * 	@return String
	 * 					
	 */
	public String updateEnquiryType(){
		for(EnquiryTypes et: getEnquiryTypeSelectList())
			adminService.updateEnquiryType(et);
		return SUCCESS;
	}
	
	/**
	 * 		Enquiry Types Getters & Setters		
	 * 				  
	 */
	
	/**	
	 * 	getEnquiryTypeName
	 * 	@return String
	 * 				
	 */
	public String getEnquiryTypeName() {
		return enquiryTypeName;
	}

	/**	
	 * 	setEnquiryTypeName
	 * 	@param enquiryTypeName String		
	 * 				
	 */
	public void setEnquiryTypeName(String enquiryTypeName) {
		this.enquiryTypeName = enquiryTypeName;
	}

	/**	
	 * 	getEnquiryTypeDescription
	 * 	@return String
	 * 				
	 */
	public String getEnquiryTypeDescription() {
		return enquiryTypeDescription;
	}

	/**	
	 * 	setEnquiryTypeDescription
	 * 	@param enquiryTypeDescription String		
	 * 				
	 */
	public void setEnquiryTypeDescription(String enquiryTypeDescription) {
		this.enquiryTypeDescription = enquiryTypeDescription;
	}

	/**	
	 * 	getEnquiryTypeSelectList
	 * 	@return List<EnquiryTypes>
	 * 				
	 */
	public List<EnquiryTypes> getEnquiryTypeSelectList() {
		return enquiryTypeSelectList;
	}

	/**	
	 * 	setEnquiryTypeSelectList
	 * 	@param enquiryTypeSelectList List<EnquiryTypes>		
	 * 				
	 */
	public void setEnquiryTypeSelectList(List<EnquiryTypes> enquiryTypeSelectList) {
		this.enquiryTypeSelectList = enquiryTypeSelectList;
	}
	
	/**
	 * 		Gender Types Fields & Methods		
	 * 				
	 */
	
	private GenderTypes genderType;
	private String genderName;
	private String genderCode;
	private List<GenderTypes> genderSelectList;					

	
	/**
	 * 		Gender Types ActionMethods		
	 * 				
	 */
	
	/**	
	 * 	getGenderTypesForm
	 * 	@return String
	 * 				
	 */
	public String getGenderTypesForm(){
		return SUCCESS;
	}
	
	/**	
	 * 	saveNewGenderType - saves a new Gender type
	 * 	@return String		
	 * 				
	 */
	public String saveNewGenderType(){
		List<GenderTypes> genderTypesList = adminService.findGenderTypes();
		boolean exists = false;
		
		for(GenderTypes gt: genderTypesList){
			if(getGenderName().equals(gt.getGenderName())){
				exists = true;
				break;
			}
		}
		
		if(exists){
			//asks the user to renter again.
			return INPUT;
		}
		System.out.println("in saving distype");
		genderType = new GenderTypes();
		genderType.setGenderName(getGenderName());
		genderType.setGenderCode(getGenderCode());
		System.out.println("name: " + getGenderName());
		System.out.println("description: " + getGenderCode());
		if(adminService.saveGenderType(genderType)){
			genderSelectList = adminService.findGenderTypes();
			return SUCCESS;
		}
		else {
			return ERROR;
		}
	}
	
	/**	
	 * updateGenderType - updates the list of Gender types
	 * 	@return String
	 * 					
	 */
	public String updateGenderType(){
		for(GenderTypes gt: getGenderSelectList())
			adminService.updateGenderType(gt);
		return SUCCESS;
	}
	
	/**
	 * @author davidforbes
	 * @date 14/09/2014 -	
	 * 		Gender Types Getters & Setters		
	 * 				  
	 */
	
	/**	
	 * 	getGenderType
	 * 	@return GenderTypes
	 * 				
	 */
	public GenderTypes getGenderType() {
		return genderType;
	}

	/**	
	 * 	setGenderType
	 * 	@param genderType GenderTypes		
	 * 				
	 */
	public void setGenderType(GenderTypes genderType) {
		this.genderType = genderType;
	}

	/**	
	 * 	getGenderName
	 * 	@return String
	 * 				
	 */
	public String getGenderName() {
		return genderName;
	}

	/**	
	 * 	setGenderName
	 * 	@param genderName String		
	 * 				
	 */
	public void setGenderName(String genderName) {
		this.genderName = genderName;
	}

	/**	
	 * 	getGenderCode
	 * 	@return String
	 * 				
	 */
	public String getGenderCode() {
		return genderCode;
	}

	/**	
	 * 	setGenderCode
	 * 	@param GenderCode String		
	 * 				
	 */
	public void setGenderCode(String GenderCode) {
		this.genderCode = GenderCode;
	}

	/**	
	 * 	getGenderSelectList
	 * 	@return List<GenderTypes>
	 * 				
	 */
	public List<GenderTypes> getGenderSelectList() {
		return genderSelectList;
	}

	/**	
	 * 	setGenderSelectList
	 * 	@param genderSelectList List<GenderTypes>		
	 * 				
	 */
	public void setGenderSelectList(List<GenderTypes> genderSelectList) {
		this.genderSelectList = genderSelectList;
	}
	
	/**
	 * 		Status Types Fields & Methods		
	 * 				
	 */
	
	private StatusTypes statusType;
	private String statusName;
	private List<StatusTypes> statusSelectList;					

	
	/**
	 * 		Status Types ActionMethods		
	 * 				
	 */
	
	/**	
	 * 	getStatusTypesForm
	 * 	@return String
	 * 				
	 */
	public String getStatusTypesForm(){
		return SUCCESS;
	}
	
	/**	
	 * 	saveNewStatusType - saves a new Status type
	 * 	@return String		
	 * 				
	 */
	public String saveNewStatusType(){
		List<StatusTypes> statusTypesList = adminService.findStatusTypes();
		boolean exists = false;
		
		for(StatusTypes st: statusTypesList){
			if(getStatusName().equals(st.getStatusName())){
				exists = true;
				break;
			}
		}
		
		if(exists){
			//asks the user to renter again.
			return INPUT;
		}
		System.out.println("in saving distype");
		statusType = new StatusTypes();
		statusType.setStatusName(getStatusName());
		System.out.println("name: " + getStatusName());
		if(adminService.saveStatusType(statusType)){
			statusSelectList = adminService.findStatusTypes();
			return SUCCESS;
		}
		else {
			return ERROR;
		}
	}
	
	/**	
	 * updateStatusType - updates the list of Status types
	 * 	@return String
	 * 					
	 */
	public String updateStatusType(){
		for(StatusTypes st: getStatusSelectList())
			adminService.updateStatusType(st);
		return SUCCESS;
	}
	
	/**
	 * 		Status Types Getters & Setters		
	 * 				  
	 */
	
	/**	
	 * 	getStatusType
	 * 	@return StatusTypes
	 * 				
	 */
	public StatusTypes getStatusType() {
		return statusType;
	}

	/**	
	 * 	setStatusType
	 * 	@param statusType StatusTypes		
	 * 				
	 */
	public void setStatusType(StatusTypes statusType) {
		this.statusType = statusType;
	}

	/**	
	 * 	getStatusName
	 * 	@return String
	 * 				
	 */
	public String getStatusName() {
		return statusName;
	}

	/**	
	 * 	setStatusName
	 * 	@param statusName String		
	 * 				
	 */
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	/**	
	 * 	getStatusSelectList
	 * 	@return List<StatusTypes> 
	 * 				
	 */
	public List<StatusTypes> getStatusSelectList() {
		return statusSelectList;
	}

	/**	
	 * 	setStatusSelectList
	 * 	@param statusSelectList List<StatusTypes>		
	 * 				
	 */
	public void setStatusSelectList(List<StatusTypes> statusSelectList) {
		this.statusSelectList = statusSelectList;
	}
	
	/**
	 * 		Title Types Fields & Methods		
	 * 				
	 */
	
	private TitleTypes titleType;
	private String titleName;
	private List<TitleTypes> titleSelectList;					

	
	/**
	 * 		Title Types ActionMethods		
	 * 				
	 */
	
	/**	
	 * 	getTitleTypesForm
	 * 	@return String
	 * 				
	 */
	public String getTitleTypesForm(){
		return SUCCESS;
	}
	
	/**	
	 * 	saveNewTitleType - saves a new Title type
	 * 	@return String		
	 * 				
	 */
	public String saveNewTitleType(){
		List<TitleTypes> titleTypesList = adminService.findTitleTypes();
		boolean exists = false;
		
		for(TitleTypes tt: titleTypesList){
			if(getTitleName().equals(tt.getName())){
				exists = true;
				break;
			}
		}
		
		if(exists){
			//asks the user to renter again.
			return INPUT;
		}
		System.out.println("in saving distype");
		titleType = new TitleTypes();
		titleType.setName(getTitleName());
		System.out.println("name: " + getTitleName());
		if(adminService.saveTitleType(titleType)){
			titleSelectList = adminService.findTitleTypes();
			return SUCCESS;
		}
		else {
			return ERROR;
		}
	}
	
	/**	
	 * updateTitleType - updates the list of title types
	 * 	@return String
	 * 					
	 */
	public String updateTitleType(){
		for(TitleTypes tt: getTitleSelectList())
			adminService.updateTitleType(tt);
		return SUCCESS;
	}
	
	/**
	 * 		Title Types Getters & Setters		
	 * 				  
	 */
	
	/**	
	 * 	getTitleName
	 * 	@return String
	 * 				
	 */
	public String getTitleName() {
		return titleName;
	}

	/**	
	 * 	setTitleName
	 * 	@param titleName String		
	 * 				
	 */
	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}

	/**	
	 * 	getTitleType
	 * 	@return TitleTypes
	 * 				
	 */
	public TitleTypes getTitleType() {
		return titleType;
	}

	/**	
	 * 	setTitleType
	 * 	@param titleType TitleTypes		
	 * 				
	 */
	public void setTitleType(TitleTypes titleType) {
		this.titleType = titleType;
	}
	
	/**	
	 * 	getTitleSelectList
	 * 	@return List<TitleTypes>
	 * 				
	 */
	public List<TitleTypes> getTitleSelectList() {
		return titleSelectList;
	}

	/**	
	 * 	setTitleSelectList
	 * 	@param titleSelectList List<TitleTypes>		
	 * 				
	 */
	public void setTitleSelectList(List<TitleTypes> titleSelectList) {
		this.titleSelectList = titleSelectList;
	}
	
	/* 
	 * 
	 * ----------------------------------------------------------------------------------------------------------
	 * ----------------------------------------------------------------------------------------------------------
	 * Disability Type Fields & Methods
	 * ----------------------------------------------------------------------------------------------------------
	 * ----------------------------------------------------------------------------------------------------------*/
	private DisabilityTypes disabilityType;
	private String disabilityName;
	private String disabilityDescription;
	private List<DisabilityTypes> DisabilitySelectList;	
	private String formTitle;
	
	 /* ----------------------------------------------------------------------------------------------------------
	 * Disability Type ActionMethods
	 * ----------------------------------------------------------------------------------------------------------
	 */
	
	/**	
	 * 	getDisabilityTypeForm
	 * 	@return String
	 * 				
	 */
	public String getDisabilityTypeForm(){
		DisabilitySelectList = adminService.findDisabilityTypes();
		return SUCCESS;
	}
	
	/**	
	 * 	saveNewDisabilityType - saves a new disability type
	 * 	@return String		
	 * 				
	 */
	public String saveNewDisabilityType(){
		List<DisabilityTypes> disabilityTypeList = adminService.findDisabilityTypes();
		boolean exists = false;
		
		for(DisabilityTypes dt: disabilityTypeList){
			if(getDisabilityName().equals(dt.getDisabilityName())){
				exists = true;
				break;
			}
		}
		
		if(exists){
			//asks the user to renter again.
			return INPUT;
		}
		System.out.println("in saving distype");
		disabilityType = new DisabilityTypes();
		disabilityType.setDisabilityName(getDisabilityName());
		disabilityType.setDisabilityDescription(getDisabilityDescription());
		System.out.println("name: " + getDisabilityName());
		System.out.println("description: " + getDisabilityDescription());
		if(adminService.saveDisabilityType(disabilityType)){
			DisabilitySelectList = adminService.findDisabilityTypes();
			return SUCCESS;
		}
		else {
			return ERROR;
		}
	}
	
	/**	
	 * updateDisabilityType - updates the list of disability types
	 * 	@return String
	 * 					
	 */
	public String updateDisabilityType(){
		System.out.println("Struts: start updateDisabilityType");
		for(DisabilityTypes dt: getDisabilitySelectList())
			adminService.updateDisabilityType(dt);
		System.out.println("Struts: end updateDisabilityType");
		return SUCCESS;
	}
	/* ----------------------------------------------------------------------------------------------------------
	 * Disability Getters & Setters
	 * ----------------------------------------------------------------------------------------------------------
	 */
	/**	
	 * 	getDangerType
	 * 	@return DangerTypes
	 * 				
	 */
	public DangerTypes getDangerType() {
		return dangerType;
	}
	
	/**	
	 * 	getDisabilityName
	 * 	@return String
	 * 				
	 */
	public String getDisabilityName() {
		return disabilityName;
	}

	/**	
	 * 	setDisabilityName
	 * 	@param disabilityName String		
	 * 				
	 */
	public void setDisabilityName(String disabilityName) {
		this.disabilityName = disabilityName;
	}

	/**	
	 * 	getDisabilityDescription
	 * 	@return String
	 * 				
	 */
	public String getDisabilityDescription() {
		return disabilityDescription;
	}

	/**	
	 * 	setDisabilityDescription
	 * 	@param disabilityDescription String		
	 * 				
	 */
	public void setDisabilityDescription(String disabilityDescription) {
		this.disabilityDescription = disabilityDescription;
	}

	/**	
	 * 	getDisabilitySelectList
	 * 	@return List<DisabilityTypes>
	 * 				
	 */
	public List<DisabilityTypes> getDisabilitySelectList() {
		return DisabilitySelectList;
	}

	/**	
	 * 	setDisabilitySelectList
	 * 	@param disabilitySelectList List<DisabilityTypes>		
	 * 				
	 */
	public void setDisabilitySelectList(List<DisabilityTypes> disabilitySelectList) {
		this.DisabilitySelectList = disabilitySelectList;
	}
	/* 
	 * 
	 * ----------------------------------------------------------------------------------------------------------
	 * ----------------------------------------------------------------------------------------------------------
	 * Issues Type Fields & Methods
	 * ----------------------------------------------------------------------------------------------------------
	 * ----------------------------------------------------------------------------------------------------------*/
	
	private IssueTypes issueType;
	private String issueName;
	private String issueDescription;
	private List<IssueTypes> IssueTypeList;	

	
	 /* ----------------------------------------------------------------------------------------------------------
	 * Issues Type ActionMethods
	 * ----------------------------------------------------------------------------------------------------------
	 */

	/**	
	 * 	getIssueTypeForm
	 * 	@return String
	 * 				
	 */
	public String getIssueTypeForm(){
		return SUCCESS;
	}
	
	/**	
	 * 	saveNewIssueType - saves a new issues type
	 * 	@return String		
	 * 				
	 */
	public String saveNewIssueType(){
		List<IssueTypes> issueTypeList = adminService.findIssueTypes();
		boolean exists = false;
		
		for(IssueTypes it: issueTypeList){
			if(getIssueName().equals(it.getIssueName())){
				exists = true;
				break;
			}
		}
		
		if(exists){
			return ERROR;
		}
		System.out.println("in saving issueType");
		issueType = new IssueTypes();
		issueType.setIssueName(getIssueName());
		issueType.setIssueDescription(getIssueDescription());
		System.out.println("name: " + getIssueName());
		System.out.println("description: " + getIssueDescription());
		if(adminService.saveIssueType(issueType)){
			IssueTypeList = adminService.findIssueTypes();
			return SUCCESS;
		}
		else {
			return ERROR;
		}
	}
	
	/**	
	 * updateIssueType - updates the list of issue types
	 * 	@return String
	 * 					
	 */
	public String updateIssueType(){
		for(IssueTypes it: getIssueTypeList())
			adminService.updateIssueType(it);
		return SUCCESS;
	}
	
	/* ----------------------------------------------------------------------------------------------------------
	 * Issue Getters & Setters
	 * ----------------------------------------------------------------------------------------------------------
	 */
	
	/**	
	 * 	getIssueName
	 * 	@return String
	 * 				
	 */
	public String getIssueName() {
		return issueName;
	}

	/**	
	 * 	setIssueName
	 * 	@param issueName String		
	 * 				
	 */
	public void setIssueName(String issueName) {
		this.issueName = issueName;
	}

	/**	
	 * 	getIssueDescription
	 * 	@return String
	 * 				
	 */
	public String getIssueDescription() {
		return issueDescription;
	}

	/**	
	 * 	setIssueDescription
	 * 	@param issueDescription String		
	 * 				
	 */
	public void setIssueDescription(String issueDescription) {
		this.issueDescription = issueDescription;
	}

	
	/**	
	 * 	getFormTitle
	 * 	@return String
	 * 				
	 */
	public String getFormTitle() {
		return formTitle;
	}

	/**	
	 * 	setFormTitle
	 * 	@param formTitle String		
	 * 				
	 */
	public void setFormTitle(String formTitle) {
		this.formTitle = formTitle;
	}

	/**	
	 * 	getIssueTypeList
	 * 	@return List<IssueTypes>
	 * 				
	 */
	public List<IssueTypes> getIssueTypeList() {
		return IssueTypeList;
	}

	/**	
	 * 	setIssueTypeList
	 * 	@param issueTypeList List<IssueTypes>		
	 * 				
	 */
	public void setIssueTypeList(List<IssueTypes> issueTypeList) {
		IssueTypeList = issueTypeList;
	}

	
	/**
	 * 		Contacts Fields & Methods		
	 * 				
	 */
	private Contacts contact;
	private String firstname;
	private String lastname;
	private List<Contacts> contactsSelectList;	

	
	/**
	 * 		Contacts ActionMethods		
	 * 				
	 */
	
	/**	
	 * 	getContactsForm
	 * 	@return String
	 * 				
	 */
	public String getContactsForm(){
		return SUCCESS;
	}
	
	/**	
	 * 	saveNewContact - saves a new contact type
	 * 	@return String		
	 * 				
	 */
	public String saveNewContact(){
		List<Contacts> contactsList = adminService.findContacts();
		boolean exists = false;
		
		for(Contacts c: contactsList){
			if((getFirstname().equals(c.getFirstname())) && (getLastname().equals(c.getLastname()))){
				exists = true;
				break;
			}
		}
		
		if(exists){
			//asks the user to renter again.
			return INPUT;
		}
		System.out.println("in saving distype");
		contact = new Contacts();
		contact.setFirstname(getFirstname());
		contact.setLastname(getLastname());
		System.out.println("First Name: " + getFirstname());
		System.out.println("Last Name: " + getLastname());
		if(adminService.saveContact(contact))
			return SUCCESS;
		else {
			return ERROR;
		}
	}
	
	/**	
	 * updateContact - updates the list of contact types
	 * 	@return String
	 * 					
	 */
	public String updateContact(){
		//adminService.updateDisabilityType(disabilityType);
		return SUCCESS;
	}
	
	/**
	 * 		Contacts Getters & Setters		
	 * 				  
	 */


	/**	
	 * 	getContact
	 * 	@return Contacts
	 * 				
	 */
	public Contacts getContact() {
		return contact;
	}

	/**	
	 * 	setContact
	 * 	@param contact Contacts		
	 * 				
	 */
	public void setContact(Contacts contact) {
		this.contact = contact;
	}

	/**	
	 * 	getFirstname
	 * 	@return String
	 * 				
	 */
	public String getFirstname() {
		return firstname;
	}

	/**	
	 * 	setFirstname
	 * 	@param firstname String		
	 * 				
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**	
	 * 	getLastname
	 * 	@return String
	 * 				
	 */
	public String getLastname() {
		return lastname;
	}

	/**	
	 * 	setLastname
	 * 	@param lastname String		
	 * 				
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**	
	 * 	getContactsSelectList
	 * 	@return List<Contacts>
	 * 				
	 */
	public List<Contacts> getContactsSelectList() {
		return contactsSelectList;
	}

	/**	
	 * 	setContactsSelectList
	 * 	@param contactsSelectList List<Contacts>		
	 * 				
	 */
	public void setContactsSelectList(List<Contacts> contactsSelectList) {
		this.contactsSelectList = contactsSelectList;
	}
	
	/**
	 * 		Communication Type Fields & Methods		
	 * 				
	 */
	private CommunicationTypes communicationType;
	private String communicationTypeName;
	private List<CommunicationTypes> communicationSelectList;	

	
	/**
	 * 		Communication Type ActionMethods		
	 * 				
	 */
	
	/**	
	 * 	getCommunicationTypeForm
	 * 	@return String
	 * 				
	 */
	public String getCommunicationTypeForm(){
		return SUCCESS;
	}
	
	/**	
	 * 	saveNewCommunicationType - saves a new communication type
	 * 	@return String		
	 * 				
	 */
	public String saveNewCommunicationType(){
		List<CommunicationTypes> communicationTypeList = adminService.findCommunicationTypes();
		boolean exists = false;
		
		for(CommunicationTypes ct: communicationTypeList){
			if(getCommunicationTypeName().equals(ct.getCommunicationTypeName())){
				exists = true;
				break;
			}
		}
		
		if(exists){
			//asks the user to renter again.
			return INPUT;
		}
		System.out.println("in saving commtype");
		communicationType = new CommunicationTypes();
		communicationType.setCommunicationTypeName(getCommunicationTypeName());
		if(adminService.saveCommunicationType(communicationType)){
			communicationSelectList = adminService.findCommunicationTypes();
			//for(CommunicationTypes ct: )
			return SUCCESS;
		}
		else {
			return ERROR;
		}
	}
	
	/**	
	 * updateCommunicationTypes - updates the list of communication types
	 * 	@return String
	 * 					
	 */
	public String updateCommunicationTypes(){
		for(CommunicationTypes ct: getCommunicationSelectList())
			adminService.updateCommunicationType(ct);
		return SUCCESS;
	}
	
	/**
	 * 		Communication Getters & Setters		
	 * 				  
	 */
	
	/**	
	 * 	getCommunicationType
	 * 	@return CommunicationTypes
	 * 				
	 */
	public CommunicationTypes getCommunicationType() {
		return communicationType;
	}

	/**	
	 * 	setCommunicationType
	 * 	@param communicationType CommunicationTypes		
	 * 				
	 */
	public void setCommunicationType(CommunicationTypes communicationType) {
		this.communicationType = communicationType;
	}

	/**	
	 * 	getCommunicationTypeName
	 * 	@return String
	 * 				
	 */
	public String getCommunicationTypeName() {
		return communicationTypeName;
	}

	/**	
	 * 	setCommunicationTypeName
	 * 	@param communicationTypeName String		
	 * 				
	 */
	public void setCommunicationTypeName(String communicationTypeName) {
		this.communicationTypeName = communicationTypeName;
	}

	/**	
	 * 	getCommunicationSelectList
	 * 	@return List<CommunicationTypes>
	 * 				
	 */
	public List<CommunicationTypes> getCommunicationSelectList() {
		return communicationSelectList;
	}

	/**	
	 * 	setCommunicationSelectList
	 * 	@param communicationSelectList List<CommunicationTypes>		
	 * 				
	 */
	public void setCommunicationSelectList(List<CommunicationTypes> communicationSelectList) {
		this.communicationSelectList = communicationSelectList;
	}
	
	/**	
	 * 		Goal Type Fields & Methods		
	 * 				
	 */
	private GoalTypes goalType;
	private String goalTypeName;
	private List<GoalTypes> goalSelectList;	

	
	/**	
	 * 		Accommodation Type ActionMethods		
	 * 				
	 */
	
	/**	
	 * 	getGoalTypeForm
	 * 	@return String
	 * 				
	 */
	public String getGoalTypeForm(){
		return SUCCESS;
	}
	
	/**	
	 * 	saveNewGoalType - saves a new goal type
	 * 	@return String		
	 * 				
	 */
	public String saveNewGoalType(){
		List<GoalTypes> goalTypeList = adminService.findGoalTypes();
		boolean exists = false;
		
		for(GoalTypes gt: goalTypeList){
			if(getGoalTypeName().equals(gt.getGoalTypeName())){
				exists = true;
				break;
			}
		}
		
		if(exists){
			//asks the user to renter again.
			return INPUT;
		}
		System.out.println("in saving distype");
		goalType = new GoalTypes();
		goalType.setGoalTypeName(getGoalTypeName());
		System.out.println("name: " + getGoalTypeName());
		if(adminService.saveGoalType(goalType)){
			goalSelectList = adminService.findGoalTypes();
			return SUCCESS;
		}
		else {
			return ERROR;
		}
	}
	
	/**	
	 * updateGoalTypes - updates the list of goal types
	 * 	@return String
	 * 					
	 */
	public String updateGoalTypes(){
		for(GoalTypes gt: getGoalSelectList())
			adminService.updateGoalType(gt);
		return SUCCESS;
	}
	
	/**	
	 * 		Goal Getters & Setters		
	 * 				  
	 */
	
	/**	
	 * 	getGoalType
	 * 	@return GoalTypes
	 * 				
	 */
	public GoalTypes getGoalType() {
		return goalType;
	}

	/**	
	 * 	setGoalType
	 * 	@param goalType GoalTypes		
	 * 				
	 */
	public void setGoalType(GoalTypes goalType) {
		this.goalType = goalType;
	}

	/**	
	 * 	getGoalTypeName
	 * 	@return String
	 * 				
	 */
	public String getGoalTypeName() {
		return goalTypeName;
	}

	/**	
	 * 	setGoalTypeName
	 * 	@param goalTypeName String		
	 * 				
	 */
	public void setGoalTypeName(String goalTypeName) {
		this.goalTypeName = goalTypeName;
	}

	/**	
	 * 	getGoalSelectList
	 * 	@return List<GoalTypes>
	 * 				
	 */
	public List<GoalTypes> getGoalSelectList() {
		return goalSelectList;
	}

	/**	
	 * 	setGoalSelectList
	 * 	@param goalSelectList List<GoalTypes> 		
	 * 				
	 */
	public void setGoalSelectList(List<GoalTypes> goalSelectList) {
		this.goalSelectList = goalSelectList;
	}
	
	/**	
	 * 		Priority Type Fields & Methods		
	 * 				
	 */
	private PriorityTypes priorityType;
	private String priorityName;
	private List<PriorityTypes> prioritySelectList;	

	
	/**	
	 * 		Priority Type ActionMethods		
	 * 				
	 */
	
	/**	
	 * 	getPriorityTypeForm
	 * 	@return String
	 * 				
	 */
	public String getPriorityTypeForm(){
		return SUCCESS;
	}
	
	/**	
	 * 	saveNewPriorityType - saves a new priority type
	 * 	@return String		
	 * 				
	 */
	public String saveNewPriorityType(){
		List<PriorityTypes> priorityTypeList = adminService.findPriorityTypes();
		boolean exists = false;
		
		for(PriorityTypes pt: priorityTypeList){
			if(getPriorityName().equals(pt.getPriorityName())){
				exists = true;
				break;
			}
		}
		
		if(exists){
			//asks the user to renter again.
			return INPUT;
		}
		System.out.println("in saving distype");
		priorityType = new PriorityTypes();
		priorityType.setPriorityName(getPriorityName());
		System.out.println("name: " + getPriorityName());
		if(adminService.savePriorityType(priorityType)){
			prioritySelectList = adminService.findPriorityTypes();
			return SUCCESS;
		}
		else {
			return ERROR;
		}
	}
	
	/**	
	 * updatePriorityTypes - updates the list of priority types
	 * 	@return String
	 * 					
	 */
	public String updatePriorityTypes(){
		for(PriorityTypes pt: getPrioritySelectList())
			adminService.updatePriorityType(pt);
		return SUCCESS;
	}
	
	/**	
	 * 		Priority Getters & Setters		
	 * 				  
	 */

	/**	
	 * 	getPriorityType
	 * 	@return PriorityTypes
	 * 				
	 */
	public PriorityTypes getPriorityType() {
		return priorityType;
	}

	/**	
	 * 	setPriorityType
	 * 	@param priorityType PriorityTypes 		
	 * 				
	 */
	public void setPriorityType(PriorityTypes priorityType) {
		this.priorityType = priorityType;
	}

	/**	
	 * 	getPriorityName
	 * 	@return String
	 * 				
	 */
	public String getPriorityName() {
		return priorityName;
	}

	/**	
	 * 	setPriorityName
	 * 	@param priorityName String 		
	 * 				
	 */
	public void setPriorityName(String priorityName) {
		this.priorityName = priorityName;
	}

	/**	
	 * 	getPrioritySelectList
	 * 	@return List<PriorityTypes>
	 * 				
	 */
	public List<PriorityTypes> getPrioritySelectList() {
		return prioritySelectList;
	}

	/**	
	 * 	setPrioritySelectList
	 * 	@param prioritySelectList List<PriorityTypes> 		
	 * 				
	 */
	public void setPrioritySelectList(List<PriorityTypes> prioritySelectList) {
		this.prioritySelectList = prioritySelectList;
	}

	
	/**
	 * 
	 * prepare function used to update the tables
	 */
	@Override
	public void prepare() throws Exception {
		setAccommodationSelectList(adminService.findAccommodationTypes());
		setCulturalBackgroundSelectList(adminService.findCulturalBackgroundTypes());
		setDangerSelectList(adminService.findDangerTypes());
		setDisabilitySelectList(adminService.findDisabilityTypes());
		setEmploymentSelectList(adminService.findEmploymentTypes());
		setEnquiryTypeSelectList(adminService.findEnquiryTypes());
		setIssueTypeList(adminService.findIssueTypes());
		setStatusSelectList(adminService.findStatusTypes());
		setTitleSelectList(adminService.findTitleTypes());
		setCommunicationSelectList(adminService.findCommunicationTypes());
		setGoalSelectList(adminService.findGoalTypes());
		setPrioritySelectList(adminService.findPriorityTypes());
	}



}
