package uow.ia.bean;

// Generated Aug 9, 2014 1:06:20 PM by Hibernate Tools 4.0.0

import java.sql.Date;

import org.hibernate.search.annotations.DateBridge;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;
import org.hibernate.search.annotations.Resolution;

/**
 * PlanGoals generated by hbm2java
 * 
 * @author Kim To
 * @version 1.0.2, 28/09/2014
 * 
 * Modification History:
 * 		28/09/2014	Change from Integer to Contacts for createdUser and updatedUser
 * 					Mods to constructor, setters and getters
 */

@Indexed
public class PlanGoals implements java.io.Serializable {

	@DocumentId
	private Integer id;
	
	@IndexedEmbedded
	private IndividualCases individualCase;
	
	@IndexedEmbedded
	private GoalTypes goalType;
	
	private Date completionDateTime;
	
	private Contacts createdUser;
	
	private Date createdDateTime;
	
	private Contacts updatedUser;
	
	private Date updatedDateTime;
	
	@Field
	private String goalDescription;
	
	@Field
	private String goalAction;
	
	@IndexedEmbedded
	private StatusTypes statusType;
	
	/**
	 * 
	 */
	public PlanGoals() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param individualCase
	 * @param goalType
	 * @param completionDateTime
	 * @param createdUser
	 * @param createdDateTime
	 * @param updatedUser
	 * @param updatedDateTime
	 * @param goalDescription
	 * @param goalAction
	 * @param statusType
	 */
	public PlanGoals(Integer id, IndividualCases individualCase,
			GoalTypes goalType, Date completionDateTime, Contacts createdUser,
			Date createdDateTime, Contacts updatedUser, Date updatedDateTime,
			String goalDescription, String goalAction, StatusTypes statusType) {
		this.id = id;
		this.individualCase = individualCase;
		this.goalType = goalType;
		this.completionDateTime = completionDateTime;
		this.createdUser = createdUser;
		this.createdDateTime = createdDateTime;
		this.updatedUser = updatedUser;
		this.updatedDateTime = updatedDateTime;
		this.goalDescription = goalDescription;
		this.goalAction = goalAction;
		this.statusType = statusType;
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
	 * @return the goalType
	 */
	public GoalTypes getGoalType() {
		return this.goalType;
	}

	/**
	 * @param goalType the goalType to set
	 */
	public void setGoalType(GoalTypes goalType) {
		this.goalType = goalType;
	}

	/**
	 * @return the completionDateTime
	 */
	public Date getCompletionDateTime() {
		return this.completionDateTime;
	}

	/**
	 * @param completionDateTime the completionDateTime to set
	 */
	public void setCompletionDateTime(Date completionDateTime) {
		this.completionDateTime = completionDateTime;
	}

	/**
	 * @return the createdUser
	 */
	public Contacts getCreatedUser() {
		return this.createdUser;
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
	 * @return the updatedDateTime
	 */
	public Date getUpdatedDateTime() {
		return this.updatedDateTime;
	}

	/**
	 * @param updatedDateTime the updatedDateTime to set
	 */
	public void setUpdatedDateTime(Date updatedDateTime) {
		this.updatedDateTime = updatedDateTime;
	}

	/**
	 * @return the goalDescription
	 */
	public String getGoalDescription() {
		return this.goalDescription;
	}

	/**
	 * @param goalDescription the goalDescription to set
	 */
	public void setGoalDescription(String goalDescription) {
		this.goalDescription = goalDescription;
	}

	/**
	 * @return the goalAction
	 */
	public String getGoalAction() {
		return this.goalAction;
	}

	/**
	 * @param goalAction the goalAction to set
	 */
	public void setGoalAction(String goalAction) {
		this.goalAction = goalAction;
	}

	/**
	 * @return the statusType
	 */
	public StatusTypes getStatusType() {
		return this.statusType;
	}

	/**
	 * @param statusType the statusType to set
	 */
	public void setStatusType(StatusTypes statusType) {
		this.statusType = statusType;
	}


}
