package uow.ia.bean;

import java.util.ArrayList;
import java.util.List;



// Generated Aug 9, 2014 1:06:20 PM by Hibernate Tools 4.0.0

/**
 * @author Kim To
 * @version 1.0.3, 30/08/2014
 */
public class AccommodationTypes implements java.io.Serializable {

	private Integer id;
	private String accommodationName;
	private String accommodationDescription;
	private List<Contacts> contactsList = new ArrayList<Contacts>();

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
	
	/**
	 * @return the contactsList
	 */
	public List<Contacts> getContactsList() {
		return this.contactsList;
	}

	/**
	 * @param contactsList the contactsList to set
	 */
	public void setContactsList(List<Contacts> contactsList) {
		this.contactsList = contactsList;
	}

	public String toString() {
		return this.accommodationName;
		
	}
}
