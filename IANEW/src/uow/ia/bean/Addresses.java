package uow.ia.bean;

import java.sql.Date;

import org.hibernate.search.annotations.DateBridge;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;
import org.hibernate.search.annotations.Resolution;

// Generated Aug 9, 2014 1:06:20 PM by Hibernate Tools 4.0.0

/**
 * Bean class for Addresses
 * 
 * @author Kim To
 */

@Indexed
public class Addresses implements java.io.Serializable {

	@DocumentId
	private Integer id;
	
	@Field
	private String street;
	
	@Field
	private String suburb;
	
	@Field
	private String postcode;
	
	@Field
	private String state;
	
	@Field
	private String country;
	
	@Field
	private String homephone;
	
	private Contacts createdUser;
	
	private Date createdDateTime;
	
	private Contacts updatedUser;
	
	private Date updatedDateTime;
	
	@IndexedEmbedded
	private Contacts contact;

	public Addresses() {
	}

	
	/**
	 * @param id
	 * @param street
	 * @param suburb
	 * @param postcode
	 * @param state
	 * @param country
	 * @param homephone
	 * @param createdUser
	 * @param createdDateTime
	 * @param updatedUser
	 * @param updatedDateTime
	 * @param contact
	 */
	public Addresses(Integer id, String street, String suburb, String postcode,
			String state, String country, String homephone,
			Contacts createdUser, Date createdDateTime, Contacts updatedUser,
			Date updatedDateTime, Contacts contact) {
		this.id = id;
		this.street = street;
		this.suburb = suburb;
		this.postcode = postcode;
		this.state = state;
		this.country = country;
		this.homephone = homephone;
		this.createdUser = createdUser;
		this.createdDateTime = createdDateTime;
		this.updatedUser = updatedUser;
		this.updatedDateTime = updatedDateTime;
		this.contact = contact;
	}


	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStreet() {
		return this.street;
	}

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

	public String getPostcode() {
		return this.postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
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
	 * @return the createdUser
	 */
	public Contacts getCreatedUser() {
		return createdUser;
	}


	/**
	 * @param createdUser the createdUser to set
	 */
	public void setCreatedUser(Contacts createdUser) {
		this.createdUser = createdUser;
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
	 * @return the updatedUser
	 */
	public Contacts getUpdatedUser() {
		return updatedUser;
	}


	/**
	 * @param updatedUser the updatedUser to set
	 */
	public void setUpdatedUser(Contacts updatedUser) {
		this.updatedUser = updatedUser;
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

	public Contacts getContact() {
		return this.contact;
	}

	public void setContact(Contacts contact) {
		this.contact = contact;
	}

}
