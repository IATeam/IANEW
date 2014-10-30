package uow.ia.bean;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

// Generated Aug 9, 2014 1:06:20 PM by Hibernate Tools 4.0.0

/**
 * @author Kim To
 */

@Indexed
public class ReviewFrequencies implements java.io.Serializable {

	@DocumentId
	private Integer id;
	
	@Field
	private String frequencyName;
	
	private List<Plans> plansList = new ArrayList<Plans>();
	/**
	 * 
	 */
	public ReviewFrequencies() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param id
	 * @param frequencyName
	 * @param plansList
	 */
	public ReviewFrequencies(Integer id, String frequencyName,
			List<Plans> plansList) {
		super();
		this.id = id;
		this.frequencyName = frequencyName;
		this.plansList = plansList;
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
	 * @return the frequencyName
	 */
	public String getFrequencyName() {
		return this.frequencyName;
	}
	/**
	 * @param frequencyName the frequencyName to set
	 */
	public void setFrequencyName(String frequencyName) {
		this.frequencyName = frequencyName;
	}
	/**
	 * @return the plansList
	 */
	public List<Plans> getPlansList() {
		return this.plansList;
	}
	/**
	 * @param plansList the plansList to set
	 */
	public void setPlansList(List<Plans> plansList) {
		this.plansList = plansList;
	}
}
