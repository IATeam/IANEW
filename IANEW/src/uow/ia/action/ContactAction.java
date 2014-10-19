package uow.ia.action;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.Preparable;

import uow.ia.bean.AccommodationTypes;
import uow.ia.bean.Addresses;
import uow.ia.bean.Contacts;
import uow.ia.bean.CulturalBackgroundTypes;
import uow.ia.bean.GenderTypes;
import uow.ia.bean.TitleTypes;
import uow.ia.bean.Users;
import uow.ia.util.DateUtil;

public class ContactAction extends BaseAction implements Preparable, SessionAware{
	private String formTitle;
	public String adminAdvocatePage(){
		setAdvocateSelectList(contactService.findAdvocates());
		setGenderSelectList(typesService.findGenderTypes());
		setAccommodationSelectList(typesService.findAccommodationTypes());
		setCulturalBackgroundSelectList(typesService.findCulturalBackgroundTypes());
		setTitleSelectList(typesService.findTitleTypes());
		setContactType(1);
	
		try{ setTheAccommodationTypeId(getContact().getAccommodation().getId()); }catch (NullPointerException n){}
		try{ setDob(getContact().getDob().toString()); }catch (NullPointerException n) {}
		try{ setTheTitleTypeId(getContact().getTitleType().getId()); }catch (NullPointerException n){}
		try{ theCulturalBackgroundTypeId = getContact().getCulturalBackground().getId(); }	catch (NullPointerException n){}
		
		return SUCCESS;
	}
	
	public String adminUserPage(){
		setClientSelectList(contactService.findClients());
		setGenderSelectList(typesService.findGenderTypes());
		setAccommodationSelectList(typesService.findAccommodationTypes());
		setCulturalBackgroundSelectList(typesService.findCulturalBackgroundTypes());
		setTitleSelectList(typesService.findTitleTypes());
		setContactType(2);

		
		try{ setTheAccommodationTypeId(getContact().getAccommodation().getId()); }catch (NullPointerException n){}
		try{ setDob(getContact().getDob().toString()); }catch (NullPointerException n) {}
		try{ setTheTitleTypeId(getContact().getTitleType().getId()); }catch (NullPointerException n){}
		try{ theCulturalBackgroundTypeId = getContact().getCulturalBackground().getId(); }	catch (NullPointerException n){}
		
		
		return SUCCESS;
	}
	
	/**
	 * @author davidforbes
	 * @date 16/09/2014 -	
	 * 		User settings page		
	 * 				
	 */
	public String userSettingsPage(){
		setAdvocateSelectList(contactService.findAdvocates());
		return SUCCESS;
		
	}
	
	
	/**
	 * @author davidforbes
	 * @date 30/09/2014 -	
	 * 		Advocate Fields & Methods		
	 * 				
	 */
	
	private int theAdvocate;						
	private int hiddenid;
	private int contactType;
	
	private List<Contacts> advocateSelectList;	
	private List<GenderTypes> genderSelectList;
	private List<AccommodationTypes> accommodationSelectList;
	private List<CulturalBackgroundTypes> culturalBackgroundSelectList;
	private List<TitleTypes> titleSelectList;
	private int theAccommodationTypeId;
	private int theCulturalBackgroundTypeId;
	private int theTitleTypeId; 
	private int theGenderTypeId;
	
	private Contacts contact;
	Map <String, Object> userSession;
	String dob;

	/**
	 * @author davidforbes
	 * @date 30/09/2014 -	
	 * 		Advocate Type ActionMethods		
	 * 				
	 */
	
	@SuppressWarnings("unchecked")
	private void activateLists(){
		genderSelectList=typesService.findGenderTypes();
		accommodationSelectList = typesService.findAccommodationTypes();
		setTitleSelectList(typesService.findTitleTypes());
		setCulturalBackgroundSelectList(typesService.findCulturalBackgroundTypes());
	}
	
	public String getAdvocateForm(){
		return SUCCESS;
	}
	
	public String saveOrUpdateContact(){		
		Date saveDate = null;
		try {
			saveDate = DateUtil.yyyymmddDate(getDob());
		} catch (ParseException e) {
			System.out.println("Problem with date: " + e.getMessage());
		}		
		java.sql.Date date = null;
		try{ date = new java.sql.Date(saveDate.getTime()); } catch(NullPointerException n){}
		
		getContact().setDob(date);
		
		Users user = (Users)userSession.get(USER);
				
		//addresses setup
		List<Addresses> al = getContact().getAddressesList();
		for(int i = 0; i < al.size(); i++){
			if(al.get(i).getId() == null)
				al.get(i).setContact(getContact());
			else if(al.get(i).getId() == -1){
				getContact().getAddressesList().remove(i);
				i--;
			}
	}
	getContact().setCulturalBackground(typesService.getCulturalBackgroundTypeById(getTheCulturalBackgroundTypeId()));
	getContact().setTitleType(typesService.getTitleTypeById(getTheTitleTypeId()));
	getContact().setGenderType(typesService.getGenderTypeById(getTheGenderTypeId()));
	getContact().setAccommodation(typesService.getAccommodationTypeById(getTheAccommodationTypeId()));
	System.out.println("Contact type: " + getContactType());
	getContact().setContactType(typesService.getContactTypeById(getContactType()));
		
	if(contactService.saveOrUpdateContact(this.getContact())){
		setAdvocateSelectList(contactService.findAdvocates());
		setClientSelectList(contactService.findClients());

		setGenderSelectList(typesService.findGenderTypes());
		setAccommodationSelectList(typesService.findAccommodationTypes());
		setCulturalBackgroundSelectList(typesService.findCulturalBackgroundTypes());
		setTitleSelectList(typesService.findTitleTypes());
		
		setContactType(getContactType());
		
		try{ setTheAccommodationTypeId(getContact().getAccommodation().getId()); }catch (NullPointerException n){}
		try{ setDob(getContact().getDob().toString()); }catch (NullPointerException n) {}
		try{ setTheTitleTypeId(getContact().getTitleType().getId()); }catch (NullPointerException n){}
		try{ theCulturalBackgroundTypeId = getContact().getCulturalBackground().getId(); }	catch (NullPointerException n){}
		contact = new Contacts();
		if(contactType == 1)
			return "advocatesettings";
		else {
			return "clientsettings";
		}
	}
	return ERROR;	
	}
	/**
	 * @author davidforbes
	 * @date 30/09/2014 -	
	 * 		Advocate Getters & Setters		
	 * 				  
	 */
	public List<Contacts> getAdvocateSelectList() {
		return advocateSelectList;
	}

	public void setAdvocateSelectList(List<Contacts> advocateSelectList) {
		this.advocateSelectList = advocateSelectList;
	}
	public int getTheAccommodationTypeId() {
		return theAccommodationTypeId;
	}

	public void setTheAccommodationTypeId(int theAccommodationTypeId) {
		this.theAccommodationTypeId = theAccommodationTypeId;
	}
	public Map<String, Object> getUserSession() {
		return userSession;
	}

	public void setUserSession(Map<String, Object> userSession) {
		this.userSession = userSession;
	}
	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}
	public int getTheTitleTypeId() {
		return theTitleTypeId;
	}

	public void setTheTitleTypeId(int theTitleTypeId) {
		this.theTitleTypeId = theTitleTypeId;
	}


	public List<GenderTypes> getGenderSelectList() {
		return genderSelectList;
	}



	public void setGenderSelectList(List<GenderTypes> genderSelectList) {
		this.genderSelectList = genderSelectList;
	}



	public List<AccommodationTypes> getAccommodationSelectList() {
		return accommodationSelectList;
	}



	public void setAccommodationSelectList(List<AccommodationTypes> accommodationSelectList) {
		this.accommodationSelectList = accommodationSelectList;
	}

	public List<TitleTypes> getTitleSelectList() {
		return titleSelectList;
	}

	public void setTitleSelectList(List<TitleTypes> titleSelectList) {
		this.titleSelectList = titleSelectList;
	}

	public int getTheAdvocate() {
		return theAdvocate;
	}

	public void setTheAdvocate(int theAdvocate) {
		this.theAdvocate = theAdvocate;
	}

	public Contacts getContact() {
		return contact;
	}



	public void setContact(Contacts contact) {
		this.contact = contact;
	}
	
	/**
	 * @author davidforbes
	 * @date 03/10/2014 -	
	 * 		Client Fields & Methods		
	 * 				
	 */
	
	private List<Contacts> clientSelectList;	

	
	/**
	 * @author davidforbes
	 * @date 03/10/2014 -	
	 * 		Client Type ActionMethods		
	 * 				
	 */
	
	public String getClientForm(){
		return SUCCESS;
	}
	
	/**
	 * @author davidforbes
	 * @date 03/10/2014 -	
	 * 		Client Getters & Setters		
	 * 				  
	 */
	
	public List<Contacts> getClientSelectList() {
		return clientSelectList;
	}

	public void setClientSelectList(List<Contacts> clientSelectList) {
		this.clientSelectList = clientSelectList;
	}

	@Override
	public void prepare() throws Exception {
		
		setAccommodationSelectList(typesService.findAccommodationTypes());
		setTitleSelectList(typesService.findTitleTypes());
		setCulturalBackgroundSelectList(typesService.findCulturalBackgroundTypes());
		setGenderSelectList(typesService.findGenderTypes());
		
	}

	public List<CulturalBackgroundTypes> getCulturalBackgroundSelectList() {
		return culturalBackgroundSelectList;
	}

	public void setCulturalBackgroundSelectList(
			List<CulturalBackgroundTypes> culturalBackgroundSelectList) {
		this.culturalBackgroundSelectList = culturalBackgroundSelectList;
	}

	public int getTheCulturalBackgroundTypeId() {
		return theCulturalBackgroundTypeId;
	}

	public void setTheCulturalBackgroundTypeId(int theCulturalBackgroundTypeId) {
		this.theCulturalBackgroundTypeId = theCulturalBackgroundTypeId;
	}

	public int getTheGenderTypeId() {
		return theGenderTypeId;
	}

	public void setTheGenderTypeId(int theGenderTypeId) {
		this.theGenderTypeId = theGenderTypeId;
	}


	public void setSession(Map<String,Object> session) {
		System.out.println("setSession called");
		this.userSession = session;
	}
	
	public String getExistingContact(){
		contact = contactService.getContacts(getHiddenid());
		return SUCCESS;
	}

	public int getHiddenid() {
		return hiddenid;
	}

	public void setHiddenid(int hiddenid) {
		this.hiddenid = hiddenid;
	}

	public int getContactType() {
		return contactType;
	}

	public void setContactType(int contactType) {
		this.contactType = contactType;
	}

	public String getFormTitle() {
		return formTitle;
	}

	public void setFormTitle(String formTitle) {
		this.formTitle = formTitle;
	}


}
