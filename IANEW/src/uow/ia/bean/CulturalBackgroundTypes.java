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
 * @version 1.0.3, 30/08/2014
 */

@Indexed
public class CulturalBackgroundTypes implements java.io.Serializable {

	@DocumentId
	private Integer id;
	
	@Field
	private String culturalBackgroundName;
	
	@Field
	private String culturalBackgroundDescription;
	private List<Contacts> contactsList = new ArrayList<Contacts>();

	public CulturalBackgroundTypes() {
	}

	public CulturalBackgroundTypes(String culturalBackgroundName,
			String culturalBackgroundDescription) {
		this.culturalBackgroundName = culturalBackgroundName;
		this.culturalBackgroundDescription = culturalBackgroundDescription;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCulturalBackgroundName() {
		return this.culturalBackgroundName;
	}

	public void setCulturalBackgroundName(String culturalBackgroundName) {
		this.culturalBackgroundName = culturalBackgroundName;
	}

	public String getCulturalBackgroundDescription() {
		return this.culturalBackgroundDescription;
	}

	public void setCulturalBackgroundDescription(
			String culturalBackgroundDescription) {
		this.culturalBackgroundDescription = culturalBackgroundDescription;
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
