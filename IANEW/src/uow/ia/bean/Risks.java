package uow.ia.bean;

import java.sql.Date;

import org.hibernate.search.annotations.DateBridge;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;
import org.hibernate.search.annotations.Resolution;

// Generated Aug 9, 2014 1:06:20 PM by Hibernate Tools 4.0.0

/**
 * @author Kim To
 */

@Indexed
public class Risks implements java.io.Serializable {

	@DocumentId
	private Integer id;
	
	@Field
	private String riskDescription;
	
	@Field
	private String riskManagement;
	
	private Contacts createdUser;
	
	private Date createdDateTime;
	
	private Contacts updatedUser;
	
	private Date updatedDateTime;
	
	@IndexedEmbedded
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
	 * @param createdUser
	 * @param createdDateTime
	 * @param updatedUser
	 * @param updatedDateTime
	 * @param individualCase
	 */
	public Risks(Integer id, String riskDescription, String riskManagement,
			Contacts createdUser, Date createdDateTime, Contacts updatedUser,
			Date updatedDateTime, IndividualCases individualCase) {
		this.id = id;
		this.riskDescription = riskDescription;
		this.riskManagement = riskManagement;
		this.createdUser = createdUser;
		this.createdDateTime = createdDateTime;
		this.updatedUser = updatedUser;
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
	 * @return the createdUser
	 */
	public Contacts getCreatedUser() {
		return createdUser;
	}

	/**
	 * @param createdUser the createdUser to set
	 */
	public void setCreatedUser(Contacts createdUser) {
		this.createdUser = createdUser;
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
	 * @return the updatedUser
	 */
	public Contacts getUpdatedUser() {
		return updatedUser;
	}

	/**
	 * @param updatedUser the updatedUser to set
	 */
	public void setUpdatedUser(Contacts updatedUser) {
		this.updatedUser = updatedUser;
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
