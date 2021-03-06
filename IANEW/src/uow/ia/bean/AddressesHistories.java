package uow.ia.bean;

// Generated Aug 9, 2014 1:06:20 PM by Hibernate Tools 4.0.0

import java.sql.Date;

/**
 * @author Kim To
 * @version 1.0.1, 28/09/2014
 * 
 * Modification History:
 * 		28/09/2014: Add displayOrder attribute, change constructor, setters and getters
 */
public class AddressesHistories implements java.io.Serializable {

	private Integer id;
	private String action;
	private Integer addressId;
	private Integer contactId;
	private String street;
	private String suburb;
	private String postcode;
	private String state;
	private String country;
	private String homephone;
	private Integer changeOrder;
	private Integer createdUserId;
	private Date createdDateTime;
	/**
	 * 
	 */
	public AddressesHistories() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param action
	 * @param addressId
	 * @param contactId
	 * @param street
	 * @param suburb
	 * @param postcode
	 * @param state
	 * @param country
	 * @param homephone
	 * @param changeOrder
	 * @param createdUserId
	 * @param createdDateTime
	 */
	public AddressesHistories(Integer id, String action, Integer addressId,
			Integer contactId, String street, String suburb, String postcode,
			String state, String country, String homephone,
			Integer changeOrder, Integer createdUserId, Date createdDateTime) {
		this.id = id;
		this.action = action;
		this.addressId = addressId;
		this.contactId = contactId;
		this.street = street;
		this.suburb = suburb;
		this.postcode = postcode;
		this.state = state;
		this.country = country;
		this.homephone = homephone;
		this.changeOrder = changeOrder;
		this.createdUserId = createdUserId;
		this.createdDateTime = createdDateTime;
	}


	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the action
	 */
	public String getAction() {
		return action;
	}
	/**
	 * @param action the action to set
	 */
	public void setAction(String action) {
		this.action = action;
	}
	/**
	 * @return the addressId
	 */
	public Integer getAddressId() {
		return addressId;
	}
	/**
	 * @param addressId the addressId to set
	 */
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}
	/**
	 * @return the contactId
	 */
	public Integer getContactId() {
		return contactId;
	}
	/**
	 * @param contactId the contactId to set
	 */
	public void setContactId(Integer contactId) {
		this.contactId = contactId;
	}
	/**
	 * @return the street
	 */
	public String getStreet() {
		return this.street;
	}
	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}
	/**
	 * @return the suburb
	 */
	public String getSuburb() {
		return this.suburb;
	}
	/**
	 * @param suburb the suburb to set
	 */
	public void setSuburb(String suburb) {
		this.suburb = suburb;
	}
	/**
	 * @return the postcode
	 */
	public String getPostcode() {
		return postcode;
	}
	/**
	 * @param postcode the postcode to set
	 */
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * @return the homephone
	 */
	public String getHomephone() {
		return homephone;
	}
	/**
	 * @param homephone the homephone to set
	 */
	public void setHomephone(String homephone) {
		this.homephone = homephone;
	}
	

	/**
	 * @return the changeOrder
	 */
	public Integer getChangeOrder() {
		return changeOrder;
	}

	/**
	 * @param changeOrder the changeOrder to set
	 */
	public void setChangeOrder(Integer changeOrder) {
		this.changeOrder = changeOrder;
	}

	/**
	 * @return the createdUserId
	 */
	public Integer getCreatedUserId() {
		return createdUserId;
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
		return createdDateTime;
	}
	/**
	 * @param createdDateTime the createdDateTime to set
	 */
	public void setCreatedDateTime(Date createdDateTime) {
		this.createdDateTime = createdDateTime;
	}
	
	

}
