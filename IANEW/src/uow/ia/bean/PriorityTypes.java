package uow.ia.bean;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Generated Aug 9, 2014 1:06:20 PM by Hibernate Tools 4.0.0

/**
 * @author Kim To
 * @version 1.0.3, 30/08/2014
 */
public class PriorityTypes implements java.io.Serializable {

	private Integer id;
	private String priorityName;
	private List<IndividualCases> individualCasesList = new ArrayList<IndividualCases>();
	/**
	 * 
	 */
	public PriorityTypes() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param id
	 * @param priorityName
	 * @param individualCasesList
	 */
	public PriorityTypes(Integer id, String priorityName,
			List<IndividualCases> individualCasesList) {
		super();
		this.id = id;
		this.priorityName = priorityName;
		this.individualCasesList = individualCasesList;
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
	 * @return the priorityName
	 */
	public String getPriorityName() {
		return this.priorityName;
	}
	/**
	 * @param priorityName the priorityName to set
	 */
	public void setPriorityName(String priorityName) {
		this.priorityName = priorityName;
	}
	/**
	 * @return the individualCasesList
	 */
	public List<IndividualCases> getIndividualCasesList() {
		return this.individualCasesList;
	}
	/**
	 * @param individualCasesList the individualCasesList to set
	 */
	public void setIndividualCasesList(List<IndividualCases> individualCasesList) {
		this.individualCasesList = individualCasesList;
	}
}
