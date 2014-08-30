package uow.ia.bean;

// Generated Aug 9, 2014 1:06:20 PM by Hibernate Tools 4.0.0

/**
 * Bean class for criteria_control_values
 * 
 * @author Kim To
 * @version 1.0.1, 28/08/2014
 */
public class CriteriaControlValues implements java.io.Serializable {

	private Integer id;
	private CriteriaControls criteriaControl;
	private String value;
	/**
	 * 
	 */
	public CriteriaControlValues() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param id
	 * @param criteriaControl
	 * @param value
	 */
	public CriteriaControlValues(Integer id, CriteriaControls criteriaControl,
			String value) {
		super();
		this.id = id;
		this.criteriaControl = criteriaControl;
		this.value = value;
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
	 * @return the criteriaControl
	 */
	public CriteriaControls getCriteriaControl() {
		return this.criteriaControl;
	}
	/**
	 * @param criteriaControl the criteriaControl to set
	 */
	public void setCriteriaControl(CriteriaControls criteriaControl) {
		this.criteriaControl = criteriaControl;
	}
	/**
	 * @return the value
	 */
	public String getValue() {
		return this.value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

}
