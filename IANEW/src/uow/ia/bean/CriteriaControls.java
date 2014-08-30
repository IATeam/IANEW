package uow.ia.bean;

import java.util.HashSet;
import java.util.Set;

// Generated Aug 9, 2014 1:06:20 PM by Hibernate Tools 4.0.0

/**
 * Bean class of criteria_controls
 * 
 * @author Kim To
 * @version 1.0.1, 28/08/2014
 */
public class CriteriaControls implements java.io.Serializable {

	private Integer id;
	private String tableName;
	private String columnName;
	private String description;
	private Set<CriteriaControlValues> criteriaControlValuesSet = new HashSet<CriteriaControlValues>();
	/**
	 * 
	 */
	public CriteriaControls() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param id
	 * @param tableName
	 * @param columnName
	 * @param description
	 * @param criteriaControlValuesSet
	 */
	public CriteriaControls(Integer id, String tableName, String columnName,
			String description,
			Set<CriteriaControlValues> criteriaControlValuesSet) {
		super();
		this.id = id;
		this.tableName = tableName;
		this.columnName = columnName;
		this.description = description;
		this.criteriaControlValuesSet = criteriaControlValuesSet;
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
	 * @return the criteriaControlValuesSet
	 */
	public Set<CriteriaControlValues> getCriteriaControlValuesSet() {
		return this.criteriaControlValuesSet;
	}
	/**
	 * @param criteriaControlValuesSet the criteriaControlValuesSet to set
	 */
	public void setCriteriaControlValuesSet(
			Set<CriteriaControlValues> criteriaControlValuesSet) {
		this.criteriaControlValuesSet = criteriaControlValuesSet;
	}

	
}
