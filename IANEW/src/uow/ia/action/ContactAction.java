package uow.ia.action;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.Preparable;

import uow.ia.bean.AccommodationTypes;
import uow.ia.bean.Addresses;
import uow.ia.bean.Contacts;
import uow.ia.bean.GenderTypes;
import uow.ia.bean.Users;
import uow.ia.util.DateUtil;

public class ContactAction extends BaseAction{
	public String adminAdvocatePage(){
		setAdvocateSelectList(contactService.findAdvocates());
		setGenderSelectList(contactService.findGenderTypes());
		setAccommodationSelectList(contactService.findAccommodationTypes());
		try{ setTheAccommodationTypeId(getContact().getAccommodation().getId()); }catch (NullPointerException n){}
		try{ setDob(getContact().getDob().toString()); }catch (NullPointerException n) {}
		return SUCCESS;
	}
	
	public String adminUserPage(){
		setClientSelectList(contactService.findClients());
		setGenderSelectList(adminService.findGenderTypes());
		setAccommodationSelectList(adminService.findAccommodationTypes());
		return SUCCESS;
	}
	
	/**
	 * @author davidforbes
	 * @date 30/09/2014 -	
	 * 		Advocate Fields & Methods		
	 * 				
	 */
	
	private List<Contacts> advocateSelectList;	
	private List<GenderTypes> genderSelectList;
	private List<AccommodationTypes> accommodationSelectList;
	private int theAccommodationTypeId;
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
	}
	
	public String getAdvocateForm(){
		return SUCCESS;
	}
	
	

	public String saveOrUpdateContact(){ //TODO
	System.out.println("Struts: start SaveUpdateEnquiry");
	
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
	System.out.println("checking address");
	for(int i = 0; i < al.size(); i++){
		if(al.get(i).getId() == null){
			al.get(i).setContact(getContact());
			//al.get(i).setCreatedUser(user.getContact());
			//al.get(i).setUpdatedUser(user.getContact());
		}
		else if(al.get(i).getId() == -1){
			System.out.println("Removing a false address");
			getContact().getAddressesList().remove(i);
			i--;
		}
	}
	System.out.println("Start to save");
	if(contact.getId() == null){
		if(contactService.saveOrUpdateContact(this.getContact())){
			activateLists();
			setContact(contact);
			System.out.println("save new enquiry successfully");
			System.out.println("Struts: end saveUpdateEnquiry");
			return SUCCESS;
		}
	}
	
	System.out.println("Struts: save unsuccessful");
	System.out.println("Struts: end saveUpdateEnquiry");
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
}
