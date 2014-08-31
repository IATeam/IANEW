package uow.ia.bean;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Generated Aug 9, 2014 1:06:20 PM by Hibernate Tools 4.0.0

/**
 * Bean class of criteria_controls
 * 
 * @author Kim To
 * @version 1.0.2, 30/08/2014
 */
public class CriteriaControls implements java.io.Serializable {

	private Integer id;
	private String controlName;
	private String tableName;
	private String columnName;
	private String description;
	private List<CriteriaControlValues> criteriaControlValuesList = new ArrayList<CriteriaControlValues>();
	/**
	 * 
	 */
	public CriteriaControls() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param id
	 * @param controlName
	 * @param tableName
	 * @param columnName
	 * @param description
	 * @param criteriaControlValuesList
	 */
	public CriteriaControls(Integer id, String controlName, String tableName,
			String columnName, String description,
			List<CriteriaControlValues> criteriaControlValuesList) {
		super();
		this.id = id;
		this.controlName = controlName;
		this.tableName = tableName;
		this.columnName = columnName;
		this.description = description;
		this.criteriaControlValuesList = criteriaControlValuesList;
	}
	/**
	 * @return the controlName
	 */
	public String getControlName() {
		return this.controlName;
	}
	/**
	 * @param controlName the controlName to set
	 */
	public void setControlName(String controlName) {
		this.controlName = controlName;
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
	 * @return the tableName
	 */
	public String getTableName() {
		return this.tableName;
	}
	/**
	 * @param tableName the tableName to set
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	/**
	 * @return the columnName
	 */
	public String getColumnName() {
		return this.columnName;
	}
	/**
	 * @param columnName the columnName to set
	 */
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return this.description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the criteriaControlValuesList
	 */
	public List<CriteriaControlValues> getCriteriaControlValuesList() {
		return this.criteriaControlValuesList;
	}
	/**
	 * @param criteriaControlValuesList the criteriaControlValuesList to set
	 */
	public void setCriteriaControlValuesList(
			List<CriteriaControlValues> criteriaControlValuesList) {
		this.criteriaControlValuesList = criteriaControlValuesList;
	}

	
}
