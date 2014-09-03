package uow.ia.bean;

import java.sql.Date;

// Generated Aug 9, 2014 1:06:20 PM by Hibernate Tools 4.0.0

/**
 * @author Kim To
 * @version 1.0.3, 29/08/2014
 */
public class Risks implements java.io.Serializable {

	private Integer id;
	private String riskDescription;
	private String riskManagement;
	private Integer createdUserId;
	private Date createdDateTime;
	private Integer updatedUserId;
	private Date updatedDateTime;
	private IndividualCases individualCase;
	
	
	/**
	 * 
	 */
	public Risks() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param id
	 * @param riskDescription
	 * @param riskManagement
	 * @param createdUserId
	 * @param createdDateTime
	 * @param updatedUserId
	 * @param updatedDateTime
	 * @param individualCase
	 */
	public Risks(Integer id, String riskDescription, String riskManagement,
			Integer createdUserId, Date createdDateTime, Integer updatedUserId,
			Date updatedDateTime, IndividualCases individualCase) {
		super();
		this.id = id;
		this.riskDescription = riskDescription;
		this.riskManagement = riskManagement;
		this.createdUserId = createdUserId;
		this.createdDateTime = createdDateTime;
		this.updatedUserId = updatedUserId;
		this.updatedDateTime = updatedDateTime;
		this.individualCase = individualCase;
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
	 * @return the riskDescription
	 */
	public String getRiskDescription() {
		return this.riskDescription;
	}
	/**
	 * @param riskDescription the riskDescription to set
	 */
	public void setRiskDescription(String riskDescription) {
		this.riskDescription = riskDescription;
	}
	/**
	 * @return the riskManagement
	 */
	public String getRiskManagement() {
		return this.riskManagement;
	}
	/**
	 * @param riskManagement the riskManagement to set
	 */
	public void setRiskManagement(String riskManagement) {
		this.riskManagement = riskManagement;
	}
	/**
	 * @return the individualCase
	 */
	public IndividualCases getIndividualCase() {
		return this.individualCase;
	}
	/**
	 * @param individualCase the individualCase to set
	 */
	public void setIndividualCase(IndividualCases individualCase) {
		this.individualCase = individualCase;
	}

	/**
	 * @return the createdUserId
	 */
	public Integer getCreatedUserId() {
		return this.createdUserId;
	}

	/**
	 * @param createdUserId the createdUserId to set
	 */
	public void setCreatedUserId(Integer createdUserId) {
		this.createdUserId = createdUserId;
	}

	/**
	 * @return the createdDateTime
	 */
	public Date getCreatedDateTime() {
		return this.createdDateTime;
	}

	/**
	 * @param createdDateTime the createdDateTime to set
	 */
	public void setCreatedDateTime(Date createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	/**
	 * @return the updatedUserId
	 */
	public Integer getUpdatedUserId() {
		return this.updatedUserId;
	}

	/**
	 * @param updatedUserId the updatedUserId to set
	 */
	public void setUpdatedUserId(Integer updatedUserId) {
		this.updatedUserId = updatedUserId;
	}

	/**
	 * @return the udpatedDateTime
	 */
	public Date getUpdatedDateTime() {
		return this.updatedDateTime;
	}

	/**
	 * @param udpatedDateTime the udpatedDateTime to set
	 */
	public void setUpdatedDateTime(Date udpatedDateTime) {
		this.updatedDateTime = udpatedDateTime;
	}

}
