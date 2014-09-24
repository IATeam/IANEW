package uow.ia.action;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;
import java.util.Map;
import uow.ia.bean.Contacts;
import uow.ia.bean.Users;
import uow.ia.util.SearchUtil;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class LoginAction extends BaseAction{

	private String username;
	private String password;
	
	private List list = null;
	private String searchString = null;
		
	public String execute(){
		
		//if(getUsername().equals("username") && getPassword().equals("password")){
		Users user = adminService.login(username, password);
		if(user!=null) {
			Map<String, Object> session = ActionContext.getContext().getSession();
			session.put(USER,user);
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
	
	
	/**
	 * @return the searchString
	 */
	public String getSearchString() {
		return searchString;
	}

	/**
	 * @param searchString the searchString to set
	 */
	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}

	/**
	 * @return the list
	 */
	public List getList() {
		return list;
	}

	/**
	 * @param list the list to set
	 */
	public void setList(List list) {
		this.list = list;
	}

	public String search() {
		
		if (!(searchString == null || searchString.equals(""))) {
			System.out.println("search String " + searchString);
			list = new SearchUtil().getResultObjectList(searchString, utilService);
		
			for (Object o : list) {
				Field[] fields = o.getClass().getDeclaredFields();
				if (o instanceof Contacts) {
					System.out.println("Contacts object");
				} else {
					for (Field f : fields) {
						if (f.getType().isInstance(new Contacts())){
							System.out.println(o.getClass().getName());
							break;
						}
					}
				}
			}
		}
		
		return SUCCESS;
	}
}
