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
public class GoalTypes implements java.io.Serializable {

	private Integer id;
	private String goalTypeName;
	private List<PlanGoals> planGoalsList = new ArrayList<PlanGoals>();
	/**
	 * 
	 */
	public GoalTypes() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param id
	 * @param goalTypeName
	 * @param planGoalsList
	 */
	public GoalTypes(Integer id, String goalTypeName,
			List<PlanGoals> planGoalsList) {
		super();
		this.id = id;
		this.goalTypeName = goalTypeName;
		this.planGoalsList = planGoalsList;
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
	 * @return the goalTypeName
	 */
	public String getGoalTypeName() {
		return this.goalTypeName;
	}
	/**
	 * @param goalTypeName the goalTypeName to set
	 */
	public void setGoalTypeName(String goalTypeName) {
		this.goalTypeName = goalTypeName;
	}
	/**
	 * @return the planGoalsList
	 */
	public List<PlanGoals> getPlanGoalsList() {
		return this.planGoalsList;
	}
	/**
	 * @param planGoalsList the planGoalsList to set
	 */
	public void setPlanGoalsList(List<PlanGoals> planGoalsList) {
		this.planGoalsList = planGoalsList;
	}
}
