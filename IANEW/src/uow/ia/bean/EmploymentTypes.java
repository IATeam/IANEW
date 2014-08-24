package uow.ia.bean;

import java.util.HashSet;
import java.util.Set;

// Generated Aug 9, 2014 1:06:20 PM by Hibernate Tools 4.0.0

/**
 * EmploymentTypes generated by hbm2java
 */
public class EmploymentTypes implements java.io.Serializable {

	private Integer id;
	private String employmentName;
	private String employmentDescription;
	private Set<ContactEmployments> contactEmploymentsSet = new HashSet<ContactEmployments>();

	public EmploymentTypes() {
	}




	/**
	 * @param id
	 * @param employmentName
	 * @param employmentDescription
	 * @param contactEmploymentsSet
	 */
	public EmploymentTypes(Integer id, String employmentName,
			String employmentDescription,
			Set<ContactEmployments> contactEmploymentsSet) {
		this.id = id;
		this.employmentName = employmentName;
		this.employmentDescription = employmentDescription;
		this.contactEmploymentsSet = contactEmploymentsSet;
	}




	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmploymentName() {
		return this.employmentName;
	}

	public void setEmploymentName(String employmentName) {
		this.employmentName = employmentName;
	}

	public String getEmploymentDescription() {
		return this.employmentDescription;
	}

	public void setEmploymentDescription(String employmentDescription) {
		this.employmentDescription = employmentDescription;
	}




	/**
	 * @return the contactEmploymentsSet
	 */
	public Set<ContactEmployments> getContactEmploymentsSet() {
		return this.contactEmploymentsSet;
	}




	/**
	 * @param contactEmploymentsSet the contactEmploymentsSet to set
	 */
	public void setContactEmploymentsSet(
			Set<ContactEmployments> contactEmploymentsSet) {
		this.contactEmploymentsSet = contactEmploymentsSet;
	}


}
