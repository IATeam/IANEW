package uow.ia.bean;

// Generated Aug 9, 2014 1:06:20 PM by Hibernate Tools 4.0.0

/**
 * Risks generated by hbm2java
 */
public class Risks implements java.io.Serializable {

	private Integer id;
	private String riskDescription;
	private String riskManagement;
	private Integer caseId;

	public Risks() {
	}

	public Risks(String riskDescription, String riskManagement, Integer caseId) {
		this.riskDescription = riskDescription;
		this.riskManagement = riskManagement;
		this.caseId = caseId;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRiskDescription() {
		return this.riskDescription;
	}

	public void setRiskDescription(String riskDescription) {
		this.riskDescription = riskDescription;
	}

	public String getRiskManagement() {
		return this.riskManagement;
	}

	public void setRiskManagement(String riskManagement) {
		this.riskManagement = riskManagement;
	}

	public Integer getCaseId() {
		return this.caseId;
	}

	public void setCaseId(Integer caseId) {
		this.caseId = caseId;
	}

}
