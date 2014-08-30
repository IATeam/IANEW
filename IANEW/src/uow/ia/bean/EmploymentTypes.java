package uow.ia.bean;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Generated Aug 9, 2014 1:06:20 PM by Hibernate Tools 4.0.0

/**
 * @author Kim To
 * @version 1.0.3, 30/08/2014
 */
public class EmploymentTypes implements java.io.Serializable {

	private Integer id;
	private String employmentName;
	private String employmentDescription;
	private List<ContactEmployments> contactEmploymentsList = new ArrayList<ContactEmployments>();

	public EmploymentTypes() {
	}


	/**
	 * @param id
	 * @param employmentName
	 * @param employmentDescription
	 * @param contactEmploymentsList
	 */
	public EmploymentTypes(Integer id, String employmentName,
			String employmentDescription,
			List<ContactEmployments> contactEmploymentsList) {
		super();
		this.id = id;
		this.employmentName = employmentName;
		this.employmentDescription = employmentDescription;
		this.contactEmploymentsList = contactEmploymentsList;
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
	 * @return the contactEmploymentsList
	 */
	public List<ContactEmployments> getContactEmploymentsList() {
		return this.contactEmploymentsList;
	}


	/**
	 * @param contactEmploymentsList the contactEmploymentsList to set
	 */
	public void setContactEmploymentsList(
			List<ContactEmployments> contactEmploymentsList) {
		this.contactEmploymentsList = contactEmploymentsList;
	}
}
