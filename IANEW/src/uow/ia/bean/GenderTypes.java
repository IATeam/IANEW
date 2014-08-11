package uow.ia.bean;

import java.util.Set;

// Generated Aug 9, 2014 1:06:20 PM by Hibernate Tools 4.0.0

/**
 * GenderTypes generated by hbm2java
 */
public class GenderTypes implements java.io.Serializable {

	private Integer id;
	private String genderName;
	private String genderCode;
	private Set<Contacts> contactsSet;

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

	public Set<Contacts> getContactsSet() {
		return contactsSet;
	}

	public void setContactsSet(Set<Contacts> contactsSet) {
		this.contactsSet = contactsSet;
	}

}
