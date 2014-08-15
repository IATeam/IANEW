package uow.ia.action;

import com.opensymphony.xwork2.Action;

public class LoginAction implements Action {

	private String username;
	private String password;
		
	public String execute(){
		if(getUsername().equals("username") && getPassword().equals("password")){
			return SUCCESS;
		}
		return LOGIN;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
