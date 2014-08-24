package uow.ia.bean;

import java.util.HashSet;
import java.util.Set;

// Generated Aug 9, 2014 1:06:20 PM by Hibernate Tools 4.0.0

/**
 * CommunicationTypesDao generated by hbm2java
 */
public class CommunicationTypes implements java.io.Serializable {

	private Integer id;
	private String communicationTypeName;
	private Set<IndividualCaseCommunications> individualCaseCommunicationsSet = new HashSet<IndividualCaseCommunications>();

	public CommunicationTypes() {
	}

	public CommunicationTypes(String communicationTypeName) {
		this.communicationTypeName = communicationTypeName;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCommunicationTypeName() {
		return this.communicationTypeName;
	}

	public void setCommunicationTypeName(String communicationTypeName) {
		this.communicationTypeName = communicationTypeName;
	}

	/**
	 * @return the individualCaseCommunicationsSet
	 */
	public Set<IndividualCaseCommunications> getIndividualCaseCommunicationsSet() {
		return this.individualCaseCommunicationsSet;
	}

	/**
	 * @param individualCaseCommunicationsSet the individualCaseCommunicationsSet to set
	 */
	public void setIndividualCaseCommunicationsSet(
			Set<IndividualCaseCommunications> individualCaseCommunicationsSet) {
		this.individualCaseCommunicationsSet = individualCaseCommunicationsSet;
	}
	
	
}
