package uow.ia.bean;

import java.util.ArrayList;
import java.util.HashSet;
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
public class DisabilityTypes implements java.io.Serializable {

	@DocumentId
	private Integer id;
	
	@Field
	private String disabilityName;
	
	private String disabilityDescription;
	
	private List<ClientDisabilities> clientDisabilitiesList = new ArrayList<ClientDisabilities>();
	/**
	 * 
	 */
	public DisabilityTypes() {
	}

	/**
	 * @param id
	 * @param disabilityName
	 * @param disabilityDescription
	 * @param clientDisabilitiesList
	 */
	public DisabilityTypes(Integer id, String disabilityName,
			String disabilityDescription,
			List<ClientDisabilities> clientDisabilitiesList) {
		super();
		this.id = id;
		this.disabilityName = disabilityName;
		this.disabilityDescription = disabilityDescription;
		this.clientDisabilitiesList = clientDisabilitiesList;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return this.id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the disabilityName
	 */
	public String getDisabilityName() {
		return this.disabilityName;
	}
	/**
	 * @param disabilityName the disabilityName to set
	 */
	public void setDisabilityName(String disabilityName) {
		this.disabilityName = disabilityName;
	}
	/**
	 * @return the disabilityDescription
	 */
	public String getDisabilityDescription() {
		return this.disabilityDescription;
	}
	/**
	 * @param disabilityDescription the disabilityDescription to set
	 */
	public void setDisabilityDescription(String disabilityDescription) {
		this.disabilityDescription = disabilityDescription;
	}

	/**
	 * @return the clientDisabilitiesList
	 */
	public List<ClientDisabilities> getClientDisabilitiesList() {
		return this.clientDisabilitiesList;
	}

	/**
	 * @param clientDisabilitiesList the clientDisabilitiesList to set
	 */
	public void setClientDisabilitiesList(
			List<ClientDisabilities> clientDisabilitiesList) {
		this.clientDisabilitiesList = clientDisabilitiesList;
	}

}
