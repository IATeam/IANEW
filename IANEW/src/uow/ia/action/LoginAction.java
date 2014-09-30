package uow.ia.action;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import uow.ia.bean.Contacts;
import uow.ia.bean.Enquiries;
import uow.ia.bean.IndividualCases;
import uow.ia.bean.Users;
import uow.ia.util.SearchUtil;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class LoginAction extends BaseAction{

	private String username;
	private String password;
	
	private List list = null;
	private String searchString = null;
	private HashMap maps = new HashMap();
		
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

	/**
	 * @return the map
	 */
	public HashMap<String, Object> getMaps() {
		return maps;
	}

	/**
	 * @param map the map to set
	 */
	public void setMap(HashMap<String, Object> maps) {
		this.maps = maps;
	}

	public String search() {
		
		if (!(searchString == null || searchString.equals(""))) {
			System.out.println("search String " + searchString);
			list = new SearchUtil().getResultObjectList(searchString, utilService);
			
			for (Object o : list) {
				int type = 0;
				Field[] fields = o.getClass().getDeclaredFields();
				if (o instanceof Contacts) {
					maps.put(1, o);
				} else if (o instanceof Enquiries) {
					maps.put(2, o);
					System.out.println("Enquiry");
				} else if (o instanceof IndividualCases) {
					maps.put(3, o);
				}
				else {
					Object object = null;
					for (Field f : fields) {
						if (f.getType().isInstance(new IndividualCases())) {
							type = 3; 
							object = f;
							break;
						} else if (f.getType().isInstance(new Enquiries())) {
							type = 2;

							object = f;
						} else if (f.getType().isInstance(new Contacts())){
							type = 1;
							object = f;
						}
					}
					
					if (object != null) {
						maps.put(type, object);
					}
				}
				
			}
			System.out.println(maps.size());
			
		}
		
		return SUCCESS;
	}
}
