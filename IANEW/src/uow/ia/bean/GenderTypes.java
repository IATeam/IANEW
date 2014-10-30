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
public class GenderTypes implements java.io.Serializable {

	@DocumentId
	private Integer id;
	
	@Field
	private String genderName;
	
	private String genderCode;
	
	private List<Contacts> contactsList = new ArrayList<Contacts>();

	public GenderTypes() {
	}

	public GenderTypes(String genderName, String genderCode) {
		this.genderName = genderName;
		this.genderCode = genderCode;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGenderName() {
		return this.genderName;
	}

	public void setGenderName(String genderName) {
		this.genderName = genderName;
	}

	public String getGenderCode() {
		return this.genderCode;
	}

	public void setGenderCode(String genderCode) {
		this.genderCode = genderCode;
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
}
