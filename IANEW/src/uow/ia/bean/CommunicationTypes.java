package uow.ia.bean;

// Generated Aug 9, 2014 1:06:20 PM by Hibernate Tools 4.0.0

/**
 * CommunicationTypesDao generated by hbm2java
 */
public class CommunicationTypes implements java.io.Serializable {

	private Integer id;
	private String communicationTypeName;

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

}
