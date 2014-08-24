package uow.ia.bean;

import java.util.List;
import java.util.Set;



// Generated Aug 9, 2014 1:06:20 PM by Hibernate Tools 4.0.0

/**
 * AccommodationTypes generated by hbm2java
 */
public class AccommodationTypes implements java.io.Serializable {

	private Integer id;
	private String accommodationName;
	private String accommodationDescription;
	private Set<Contacts> contactsSet;

	public AccommodationTypes() {
	}

	public AccommodationTypes(String accommodationName,
			String accommodationDescription) {
		this.accommodationName = accommodationName;
		this.accommodationDescription = accommodationDescription;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccommodationName() {
		return this.accommodationName;
	}

	public void setAccommodationName(String accommodationName) {
		this.accommodationName = accommodationName;
	}

	public String getAccommodationDescription() {
		return this.accommodationDescription;
	}

	public void setAccommodationDescription(String accommodationDescription) {
		this.accommodationDescription = accommodationDescription;
	}

	public Set<Contacts> getContactsSet() {
		return this.contactsSet;
	}

	public void setContactsSet(Set<Contacts> contactsSet) {
		this.contactsSet = contactsSet;
	}
	
	public String toString() {
		return this.accommodationName;
		
	}
}
