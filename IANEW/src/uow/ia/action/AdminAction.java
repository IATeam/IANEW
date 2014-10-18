package uow.ia.action;

import uow.ia.bean.CommunicationTypes;
import uow.ia.bean.DisabilityTypes;
import uow.ia.bean.EmploymentTypes;
import uow.ia.bean.GoalTypes;
import uow.ia.bean.IssueTypes;
import uow.ia.bean.AccommodationTypes;
import uow.ia.bean.CulturalBackgroundTypes;
import uow.ia.bean.DangerTypes;
import uow.ia.bean.EnquiryTypes;
import uow.ia.bean.GenderTypes;
import uow.ia.bean.PriorityTypes;
import uow.ia.bean.StatusTypes;
import uow.ia.bean.TitleTypes;
import uow.ia.bean.Contacts;
import uow.ia.bean.Users;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.Preparable;
import com.sun.tools.xjc.reader.xmlschema.bindinfo.BIConversion.User;

/**
 * @author David
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
	/**
	 * @author davidforbes
	 * @date 09/09/2014 -	
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
	 * @author davidforbes
	 * @date 09/09/2014 -	
	 * 		Accommodation Type Fields & Methods		
	 * 				
	 */
	private AccommodationTypes accommodationType;
	private String accommodationName;
	private String accommodationDescription;
	private List<AccommodationTypes> accommodationSelectList;	

	
	/**
	 * @author davidforbes
	 * @date 09/09/2014 -	
	 * 		Accommodation Type ActionMethods		
	 * 				
	 */
	
	public String getAccommodationTypeForm(){
		return SUCCESS;
	}
	
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
	
	public String updateAccommodationTypes(){
		for(AccommodationTypes at: getAccommodationSelectList())
			adminService.updateAccommodationType(at);
		return SUCCESS;
	}
	
	/**
	 * @author davidforbes
	 * @date 09/09/2014 -	
	 * 		Accommodation Getters & Setters		
	 * 				  
	 */
	
	public String getAccommodationName() {
		return accommodationName;
	}

	public void setAccommodationName(String accommodationName) {
		this.accommodationName = accommodationName;
	}

	public String getAccommodationDescription() {
		return accommodationDescription;
	}

	public void setAccommodationDescription(String accommodationDescription) {
		this.accommodationDescription = accommodationDescription;
	}

	public List<AccommodationTypes> getAccommodationSelectList() {
		return accommodationSelectList;
	}

	public void setAccommodationSelectList(List<AccommodationTypes> accommodationSelectList) {
		this.accommodationSelectList = accommodationSelectList;
	}
	
	/**
	 * @author davidforbes
	 * @date 13/09/2014 -	
	 * 		Cultural Background Type Fields & Methods		
	 * 				
	 */
	private CulturalBackgroundTypes culturalBackgroundType;
	

	private String culturalBackgroundName;
	private String culturalBackgroundDescription;
	private List<CulturalBackgroundTypes> culturalBackgroundSelectList;	

	/**
	 * @author davidforbes
	 * @date 13/09/2014 -	
	 * 		culturalBackground Type ActionMethods		
	 * 				
	 */
	
	public String getCulturalBackgroundTypeForm(){
		return SUCCESS;
	}
	
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
	
	public CulturalBackgroundTypes getCulturalBackgroundType() {
		return culturalBackgroundType;
	}

	public void setCulturalBackgroundType(
			CulturalBackgroundTypes culturalBackgroundType) {
		this.culturalBackgroundType = culturalBackgroundType;
	}

	public String getCulturalBackgroundName() {
		return culturalBackgroundName;
	}

	public void setCulturalBackgroundName(String culturalBackgroundName) {
		this.culturalBackgroundName = culturalBackgroundName;
	}

	public String getCulturalBackgroundDescription() {
		return culturalBackgroundDescription;
	}

	public void setCulturalBackgroundDescription(
			String culturalBackgroundDescription) {
		this.culturalBackgroundDescription = culturalBackgroundDescription;
	}

	public List<CulturalBackgroundTypes> getCulturalBackgroundSelectList() {
		return culturalBackgroundSelectList;
	}

	public void setCulturalBackgroundSelectList(
			List<CulturalBackgroundTypes> culturalBackgroundSelectList) {
		this.culturalBackgroundSelectList = culturalBackgroundSelectList;
	}
	
	/**
	 * @author davidforbes
	 * @date 14/09/2014 -	
	 * 		Danger Types Fields & Methods		
	 * 				
	 */
	private DangerTypes dangerType;
	private String dangerName;
	private String dangerDescription;
	private List<DangerTypes> dangerSelectList;							

	
	/**
	 * @author davidforbes
	 * @date 14/09/2014 -	
	 * 		Danger Types ActionMethods		
	 * 				
	 */
	
	public String getDangerTypeForm(){
		return SUCCESS;
	}
	
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
	
	public String updateDangerType(){
		System.out.println("Struts: start updateDangerType");
		for(DangerTypes dt: getDangerSelectList())
			adminService.updateDangerType(dt);
		System.out.println("Struts: end updateDangerType");
		return SUCCESS;		
	}
	
	/**
	 * @author davidforbes
	 * @date 14/09/2014 -	
	 * 		Danger Types Getters & Setters		
	 * 				  
	 */
	
	public void setDangerType(DangerTypes dangerType) {
		this.dangerType = dangerType;
	}

	public String getDangerName() {
		return dangerName;
	}

	public void setDangerName(String dangerName) {
		this.dangerName = dangerName;
	}

	public String getDangerDescription() {
		return dangerDescription;
	}

	public void setDangerDescription(String dangerDescription) {
		this.dangerDescription = dangerDescription;
	}

	public List<DangerTypes> getDangerSelectList() {
		return dangerSelectList;
	}

	public void setDangerSelectList(List<DangerTypes> dangerSelectList) {
		this.dangerSelectList = dangerSelectList;
	}
	
	/**
	 * @author davidforbes
	 * @date 14/09/2014 -	
	 * 		Employment Types Fields & Methods		
	 * 				
	 */
	
	private EmploymentTypes employmentType;
	private String employmentName;
	private String employmentDescription;
	private List<EmploymentTypes> employmentSelectList;					

	
	/**
	 * @author davidforbes
	 * @date 14/09/2014 -	
	 * 		Employment Types ActionMethods		
	 * 				
	 */
	
	public String getEmploymentTypeForm(){
		return SUCCESS;
	}
	
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
	
	public String updateEmploymentType(){
		for(EmploymentTypes et: getEmploymentSelectList())
			adminService.updateEmploymentType(et);
		return SUCCESS;
	}
	
	/**
	 * @author davidforbes
	 * @date 14/09/2014 -	
	 * 		Employment Types Getters & Setters		
	 * 				  
	 */
	public String getEmploymentName() {
		return employmentName;
	}

	public void setEmploymentName(String employmentName) {
		this.employmentName = employmentName;
	}

	public String getEmploymentDescription() {
		return employmentDescription;
	}

	public void setEmploymentDescription(String employmentDescription) {
		this.employmentDescription = employmentDescription;
	}

	public EmploymentTypes getEmploymentType() {
		return employmentType;
	}

	public void setEmploymentType(EmploymentTypes employmentType) {
		this.employmentType = employmentType;
	}

	public List<EmploymentTypes> getEmploymentSelectList() {
		return employmentSelectList;
	}

	public void setEmploymentSelectList(List<EmploymentTypes> employmentSelectList) {
		this.employmentSelectList = employmentSelectList;
	}
	
	
	/**
	 * @author davidforbes
	 * @date 14/09/2014 -	
	 * 		Enquiry Types Fields & Methods		
	 * 				
	 */
	
	private EnquiryTypes enquiryType;
	private String enquiryTypeName;
	private String enquiryTypeDescription;
	private List<EnquiryTypes> enquiryTypeSelectList;					

	
	/**
	 * @author davidforbes
	 * @date 14/09/2014 -	
	 * 		Enquiry Types ActionMethods		
	 * 				
	 */
	
	public String getEnquiryTypeForm(){
		return SUCCESS;
	}
	
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
	
	public String updateEnquiryType(){
		for(EnquiryTypes et: getEnquiryTypeSelectList())
			adminService.updateEnquiryType(et);
		return SUCCESS;
	}
	
	/**
	 * @author davidforbes
	 * @date 14/09/2014 -	
	 * 		Enquiry Types Getters & Setters		
	 * 				  
	 */
	
	public String getEnquiryTypeName() {
		return enquiryTypeName;
	}

	public void setEnquiryTypeName(String enquiryTypeName) {
		this.enquiryTypeName = enquiryTypeName;
	}

	public String getEnquiryTypeDescription() {
		return enquiryTypeDescription;
	}

	public void setEnquiryTypeDescription(String enquiryTypeDescription) {
		this.enquiryTypeDescription = enquiryTypeDescription;
	}

	public List<EnquiryTypes> getEnquiryTypeSelectList() {
		return enquiryTypeSelectList;
	}

	public void setEnquiryTypeSelectList(List<EnquiryTypes> enquiryTypeSelectList) {
		this.enquiryTypeSelectList = enquiryTypeSelectList;
	}
	
	/**
	 * @author davidforbes
	 * @date 14/09/2014 -	
	 * 		Gender Types Fields & Methods		
	 * 				
	 */
	
	private GenderTypes genderType;
	private String genderName;
	private String genderCode;
	private List<GenderTypes> genderSelectList;					

	
	/**
	 * @author davidforbes
	 * @date 14/09/2014 -	
	 * 		Gender Types ActionMethods		
	 * 				
	 */
	
	public String getGenderTypesForm(){
		return SUCCESS;
	}
	
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
	
	public GenderTypes getGenderType() {
		return genderType;
	}

	public void setGenderType(GenderTypes genderType) {
		this.genderType = genderType;
	}

	public String getGenderName() {
		return genderName;
	}

	public void setGenderName(String genderName) {
		this.genderName = genderName;
	}

	public String getGenderCode() {
		return genderCode;
	}

	public void setGenderCode(String GenderCode) {
		this.genderCode = GenderCode;
	}

	public List<GenderTypes> getGenderSelectList() {
		return genderSelectList;
	}

	public void setGenderSelectList(List<GenderTypes> genderSelectList) {
		this.genderSelectList = genderSelectList;
	}
	
	/**
	 * @author davidforbes
	 * @date 14/09/2014 -	
	 * 		Status Types Fields & Methods		
	 * 				
	 */
	
	private StatusTypes statusType;
	private String statusName;
	private List<StatusTypes> statusSelectList;					

	
	/**
	 * @author davidforbes
	 * @date 14/09/2014 -	
	 * 		Status Types ActionMethods		
	 * 				
	 */
	
	public String getStatusTypesForm(){
		return SUCCESS;
	}
	
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
	
	public String updateStatusType(){
		for(StatusTypes st: getStatusSelectList())
			adminService.updateStatusType(st);
		return SUCCESS;
	}
	
	/**
	 * @author davidforbes
	 * @date 14/09/2014 -	
	 * 		Status Types Getters & Setters		
	 * 				  
	 */
	public StatusTypes getStatusType() {
		return statusType;
	}

	public void setStatusType(StatusTypes statusType) {
		this.statusType = statusType;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public List<StatusTypes> getStatusSelectList() {
		return statusSelectList;
	}

	public void setStatusSelectList(List<StatusTypes> statusSelectList) {
		this.statusSelectList = statusSelectList;
	}
	
	/**
	 * @author davidforbes
	 * @date 14/09/2014 -	
	 * 		Title Types Fields & Methods		
	 * 				
	 */
	
	private TitleTypes titleType;
	private String titleName;
	private List<TitleTypes> titleSelectList;					

	
	/**
	 * @author davidforbes
	 * @date 14/09/2014 -	
	 * 		Title Types ActionMethods		
	 * 				
	 */
	
	public String getTitleTypesForm(){
		return SUCCESS;
	}
	
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
	
	public String updateTitleType(){
		for(TitleTypes tt: getTitleSelectList())
			adminService.updateTitleType(tt);
		return SUCCESS;
	}
	
	/**
	 * @author davidforbes
	 * @date 14/09/2014 -	
	 * 		Title Types Getters & Setters		
	 * 				  
	 */
	public String getTitleName() {
		return titleName;
	}

	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}

	public TitleTypes getTitleType() {
		return titleType;
	}

	public void setTitleType(TitleTypes titleType) {
		this.titleType = titleType;
	}
	
	public List<TitleTypes> getTitleSelectList() {
		return titleSelectList;
	}

	public void setTitleSelectList(List<TitleTypes> titleSelectList) {
		this.titleSelectList = titleSelectList;
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
	
	
	public String getDisabilityTypeForm(){
		DisabilitySelectList = adminService.findDisabilityTypes();
		return SUCCESS;
	}
	
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
	public DangerTypes getDangerType() {
		return dangerType;
	}
	
	public String getDisabilityName() {
		return disabilityName;
	}

	public void setDisabilityName(String disabilityName) {
		this.disabilityName = disabilityName;
	}

	public String getDisabilityDescription() {
		return disabilityDescription;
	}

	public void setDisabilityDescription(String disabilityDescription) {
		this.disabilityDescription = disabilityDescription;
	}

	public List<DisabilityTypes> getDisabilitySelectList() {
		return DisabilitySelectList;
	}

	public void setDisabilitySelectList(List<DisabilityTypes> disabilitySelectList) {
		this.DisabilitySelectList = disabilitySelectList;
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

	
	public String getIssueTypeForm(){
		return SUCCESS;
	}
	
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
	
	public String updateIssueType(){
		for(IssueTypes it: getIssueTypeList())
			adminService.updateIssueType(it);
		return SUCCESS;
	}
	
	/* ----------------------------------------------------------------------------------------------------------
	 * Issue Getters & Setters
	 * ----------------------------------------------------------------------------------------------------------
	 */
	public String getIssueName() {
		return issueName;
	}

	public void setIssueName(String issueName) {
		this.issueName = issueName;
	}

	public String getIssueDescription() {
		return issueDescription;
	}

	public void setIssueDescription(String issueDescription) {
		this.issueDescription = issueDescription;
	}

	

	public String getFormTitle() {
		return formTitle;
	}

	public void setFormTitle(String formTitle) {
		this.formTitle = formTitle;
	}

	public List<IssueTypes> getIssueTypeList() {
		return IssueTypeList;
	}

	public void setIssueTypeList(List<IssueTypes> issueTypeList) {
		IssueTypeList = issueTypeList;
	}

	
	/**
	 * @author davidforbes
	 * @date 16/09/2014 -	
	 * 		Contacts Fields & Methods		
	 * 				
	 */
	private Contacts contact;
	

	private String firstname;
	private String lastname;
	private List<Contacts> contactsSelectList;	

	
	/**
	 * @author davidforbes
	 * @date 16/09/2014 -	
	 * 		Contacts ActionMethods		
	 * 				
	 */
	
	public String getContactsForm(){
		return SUCCESS;
	}
	
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
	
	public String updateContact(){
		//adminService.updateDisabilityType(disabilityType);
		return SUCCESS;
	}
	
	/**
	 * @author davidforbes
	 * @date 16/09/2014 -	
	 * 		Contacts Getters & Setters		
	 * 				  
	 */

	public Contacts getContact() {
		return contact;
	}

	public void setContact(Contacts contact) {
		this.contact = contact;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public List<Contacts> getContactsSelectList() {
		return contactsSelectList;
	}

	public void setContactsSelectList(List<Contacts> contactsSelectList) {
		this.contactsSelectList = contactsSelectList;
	}
	
	/**
	 * @author davidforbes
	 * @date 04/10/2014 -	
	 * 		Communication Type Fields & Methods		
	 * 				
	 */
	private CommunicationTypes communicationType;
	private String communicationTypeName;
	private List<CommunicationTypes> communicationSelectList;	

	
	/**
	 * @author davidforbes
	 * @date 04/10/2014 -	
	 * 		Communication Type ActionMethods		
	 * 				
	 */
	
	public String getCommunicationTypeForm(){
		return SUCCESS;
	}
	
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
	
	public String updateCommunicationTypes(){
		for(CommunicationTypes ct: getCommunicationSelectList())
			adminService.updateCommunicationType(ct);
		return SUCCESS;
	}
	
	/**
	 * @author davidforbes
	 * @date 04/10/2014 -	
	 * 		Communication Getters & Setters		
	 * 				  
	 */
	
	public CommunicationTypes getCommunicationType() {
		return communicationType;
	}

	public void setCommunicationType(CommunicationTypes communicationType) {
		this.communicationType = communicationType;
	}

	public String getCommunicationTypeName() {
		return communicationTypeName;
	}

	public void setCommunicationTypeName(String communicationTypeName) {
		this.communicationTypeName = communicationTypeName;
	}

	public List<CommunicationTypes> getCommunicationSelectList() {
		return communicationSelectList;
	}

	public void setCommunicationSelectList(
			List<CommunicationTypes> communicationSelectList) {
		this.communicationSelectList = communicationSelectList;
	}
	
	/**
	 * @author davidforbes
	 * @date 06/10/2014 -	
	 * 		Goal Type Fields & Methods		
	 * 				
	 */
	private GoalTypes goalType;
	private String goalTypeName;
	private List<GoalTypes> goalSelectList;	

	
	/**
	 * @author davidforbes
	 * @date 06/10/2014 -	
	 * 		Accommodation Type ActionMethods		
	 * 				
	 */
	
	public String getGoalTypeForm(){
		return SUCCESS;
	}
	
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
	
	public String updateGoalTypes(){
		for(GoalTypes gt: getGoalSelectList())
			adminService.updateGoalType(gt);
		return SUCCESS;
	}
	
	/**
	 * @author davidforbes
	 * @date 06/10/2014 -	
	 * 		Goal Getters & Setters		
	 * 				  
	 */
	public GoalTypes getGoalType() {
		return goalType;
	}

	public void setGoalType(GoalTypes goalType) {
		this.goalType = goalType;
	}

	public String getGoalTypeName() {
		return goalTypeName;
	}

	public void setGoalTypeName(String goalTypeName) {
		this.goalTypeName = goalTypeName;
	}

	public List<GoalTypes> getGoalSelectList() {
		return goalSelectList;
	}

	public void setGoalSelectList(List<GoalTypes> goalSelectList) {
		this.goalSelectList = goalSelectList;
	}
	
	/**
	 * @author davidforbes
	 * @date 06/10/2014 -	
	 * 		Priority Type Fields & Methods		
	 * 				
	 */
	private PriorityTypes priorityType;
	private String priorityName;
	private List<PriorityTypes> prioritySelectList;	

	
	/**
	 * @author davidforbes
	 * @date 06/10/2014 -	
	 * 		Priority Type ActionMethods		
	 * 				
	 */
	
	public String getPriorityTypeForm(){
		return SUCCESS;
	}
	
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
	
	public String updatePriorityTypes(){
		for(PriorityTypes pt: getPrioritySelectList())
			adminService.updatePriorityType(pt);
		return SUCCESS;
	}
	
	/**
	 * @author davidforbes
	 * @date 09/09/2014 -	
	 * 		Priority Getters & Setters		
	 * 				  
	 */

	public PriorityTypes getPriorityType() {
		return priorityType;
	}

	public void setPriorityType(PriorityTypes priorityType) {
		this.priorityType = priorityType;
	}

	public String getPriorityName() {
		return priorityName;
	}

	public void setPriorityName(String priorityName) {
		this.priorityName = priorityName;
	}

	public List<PriorityTypes> getPrioritySelectList() {
		return prioritySelectList;
	}

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
