package uow.ia.bean;

// Generated Aug 9, 2014 1:06:20 PM by Hibernate Tools 4.0.0

/**
 * Calendars generated by hbm2java
 */
public class Calendars implements java.io.Serializable {

	private Integer id;
	private Integer userId;
	private Integer eventId;

	public Calendars() {
	}

	public Calendars(Integer userId, Integer eventId) {
		this.userId = userId;
		this.eventId = eventId;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getEventId() {
		return this.eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

}
