package uow.ia.bean;

// Generated Aug 9, 2014 1:06:20 PM by Hibernate Tools 4.0.0

/**
 * @author Kim To
 */
public class Users implements java.io.Serializable {

	private Integer id;
	private String username;
	private String password;
	private Contacts contact;

	public Users() {
	}


	/**
	 * @param id
	 * @param username
	 * @param password
	 * @param contact
	 */
	public Users(Integer id, String username, String password, Contacts contact) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.contact = contact;
	}


	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	/**
	 * @return the contact
	 */
	public Contacts getContact() {
		return this.contact;
	}


	/**
	 * @param contact the contact to set
	 */
	public void setContact(Contacts contact) {
		this.contact = contact;
	}


}
