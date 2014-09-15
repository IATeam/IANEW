package uow.ia.action;

import java.util.Date;
import java.util.Map;

import uow.ia.bean.Users;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class LoginAction extends BaseAction {

	private String username;
	private String password;
		
	public String execute(){
		
		//if(getUsername().equals("username") && getPassword().equals("password")){
		Users user = adminService.login(username, password);
		if(user!=null) {
			Map<String, Object> session = ActionContext.getContext().getSession();
			session.put(USER, user);
            session.put("context", new Date());
			return SUCCESS;
		} else {
			return ERROR;
		}
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
