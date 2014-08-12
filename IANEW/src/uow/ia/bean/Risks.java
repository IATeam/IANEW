package uow.ia.bean;

// Generated Aug 9, 2014 1:06:20 PM by Hibernate Tools 4.0.0

/**
 * Risks generated by hbm2java
 */
public class Risks implements java.io.Serializable {

	private Integer id;
	private String riskDescription;
	private String riskManagement;
//	private Integer caseId;
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
	 * @param individualCase
	 */
	public Risks(Integer id, String riskDescription, String riskManagement,
			IndividualCases individualCase) {
		this.id = id;
		this.riskDescription = riskDescription;
		this.riskManagement = riskManagement;
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
		return individualCase;
	}
	/**
	 * @param individualCase the individualCase to set
	 */
	public void setIndividualCase(IndividualCases individualCase) {
		this.individualCase = individualCase;
	}

}
