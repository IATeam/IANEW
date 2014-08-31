package uow.ia.bean;

import java.util.ArrayList;
import java.util.List;


// Generated Aug 9, 2014 1:06:20 PM by Hibernate Tools 4.0.0

/**
 * @author Kim To
 * @version 1.0.3, 30/08/2014
 */
public class CommunicationTypes implements java.io.Serializable {

	private Integer id;
	private String communicationTypeName;
	private List<IndividualCaseCommunications> individualCaseCommunicationsList = new ArrayList<IndividualCaseCommunications>();

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
	 * @return the individualCaseCommunicationsList
	 */
	public List<IndividualCaseCommunications> getIndividualCaseCommunicationsList() {
		return this.individualCaseCommunicationsList;
	}

	/**
	 * @param individualCaseCommunicationsList the individualCaseCommunicationsList to set
	 */
	public void setIndividualCaseCommunicationsList(
			List<IndividualCaseCommunications> individualCaseCommunicationsList) {
		this.individualCaseCommunicationsList = individualCaseCommunicationsList;
	}
	
}
