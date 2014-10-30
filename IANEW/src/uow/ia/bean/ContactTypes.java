package uow.ia.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

// Generated Aug 9, 2014 1:06:20 PM by Hibernate Tools 4.0.0

/**
 * @author Kim To
 */
@Indexed
public class ContactTypes implements java.io.Serializable {

	@DocumentId
	private Integer id;
	
	@Field
	private String contactTypeName;
	
	private String contactTypeDescription;
	private List<Contacts> contactsList = new ArrayList<Contacts>();

	public ContactTypes() {
	}

	public ContactTypes(String contactTypeName, String contactTypeDescription) {
		this.contactTypeName = contactTypeName;
		this.contactTypeDescription = contactTypeDescription;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContactTypeName() {
		return this.contactTypeName;
	}

	public void setContactTypeName(String contactTypeName) {
		this.contactTypeName = contactTypeName;
	}

	public String getContactTypeDescription() {
		return this.contactTypeDescription;
	}

	public void setContactTypeDescription(String contactTypeDescription) {
		this.contactTypeDescription = contactTypeDescription;
	}

	/**
	 * @return the contactsList
	 */
	public List<Contacts> getContactsList() {
		return contactsList;
	}

	/**
	 * @param contactsList the contactsList to set
	 */
	public void setContactsList(List<Contacts> contactsList) {
		this.contactsList = contactsList;
	}

}
