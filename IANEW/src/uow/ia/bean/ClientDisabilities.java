package uow.ia.bean;

// Generated Aug 9, 2014 1:06:20 PM by Hibernate Tools 4.0.0

/**
 * ClientDisabilities generated by hbm2java
 */
public class ClientDisabilities implements java.io.Serializable {

	private Integer id;
	private Integer contactId;
	private Integer disabilityId;
	private String comments;
	private String primaryFlag;

	public ClientDisabilities() {
	}

	public ClientDisabilities(Integer contactId, Integer disabilityId,
			String comments, String primaryFlag) {
		this.contactId = contactId;
		this.disabilityId = disabilityId;
		this.comments = comments;
		this.primaryFlag = primaryFlag;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getContactId() {
		return this.contactId;
	}

	public void setContactId(Integer contactId) {
		this.contactId = contactId;
	}

	public Integer getDisabilityId() {
		return this.disabilityId;
	}

	public void setDisabilityId(Integer disabilityId) {
		this.disabilityId = disabilityId;
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
