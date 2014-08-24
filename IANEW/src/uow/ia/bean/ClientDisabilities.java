package uow.ia.bean;

import java.util.HashSet;

// Generated Aug 9, 2014 1:06:20 PM by Hibernate Tools 4.0.0

/**
 * ClientDisabilities generated by hbm2java
 */
public class ClientDisabilities implements java.io.Serializable {

	private Integer id;
	private Contacts contact;
	private DisabilityTypes disabilityType;
	private String comments;
	private String primaryFlag;

	public ClientDisabilities() {
	}

	/**
	 * @param id
	 * @param contact
	 * @param disabilityType
	 * @param comments
	 * @param primaryFlag
	 */
	public ClientDisabilities(Integer id, Contacts contact,
			DisabilityTypes disabilityType, String comments, String primaryFlag) {
		this.id = id;
		this.contact = contact;
		this.disabilityType = disabilityType;
		this.comments = comments;
		this.primaryFlag = primaryFlag;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the contact
	 */
	public Contacts getContact() {
		return this.contact;
	}

	/**
	 * @param contact the contact to set
	 */
	public void setContact(Contacts contact) {
		this.contact = contact;
	}

	/**
	 * @return the disabilityType
	 */
	public DisabilityTypes getDisabilityType() {
		return this.disabilityType;
	}

	/**
	 * @param disabilityType the disabilityType to set
	 */
	public void setDisabilityType(DisabilityTypes disabilityType) {
		this.disabilityType = disabilityType;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getPrimaryFlag() {
		return this.primaryFlag;
	}

	public void setPrimaryFlag(String primaryFlag) {
		this.primaryFlag = primaryFlag;
	}

}
