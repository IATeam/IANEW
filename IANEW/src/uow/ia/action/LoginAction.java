package uow.ia.action;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.EntityNameResolver;
import org.hibernate.search.FullTextSession;

import uow.ia.bean.Contacts;
import uow.ia.bean.Enquiries;
import uow.ia.bean.IndividualCases;
import uow.ia.bean.Users;
import uow.ia.util.SearchUtil;

import com.opensymphony.xwork2.ActionContext;
import com.sun.tools.ws.wsdl.framework.Entity;

public class LoginAction extends BaseAction{

	private String username;
	private String password;
	
	private List list = new ArrayList();
	private String searchString = null;
	private List resultList = new ArrayList();
	/**
	 * @return the resultList
	 */
	public List getResultList() {
		return resultList;
	}

	/**
	 * @param resultList the resultList to set
	 */
	public void setResultList(List resultList) {
		this.resultList = resultList;
	}

		
	public String execute(){
		
		//if(getUsername().equals("username") && getPassword().equals("password")){
		Users user = adminService.login(username, password);
		if(user!=null) {
			Map<String, Object> session = ActionContext.getContext().getSession();
			session.put(USER,user);
            session.put("context", new Date());
            
            FullTextSession fts = utilService.getFullTextSession();
    		
    		//try {
    			//fts.createIndexer().startAndWait();
    			System.out.println("commented index out");
    		//} catch (InterruptedException e) {
    			//e.printStackTrace();
    		//}
            
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
			list = new SearchUtil().getResultObjectList(searchString, utilService);
			
			for (Object o : list) {
				int type = 0;
				Field[] fields = o.getClass().getDeclaredFields();
				if (o instanceof Enquiries) {
					resultList.add(o);
				} else if (o instanceof IndividualCases) {
					resultList.add(o);
				}
				else {
					Object object = null;
					for (Field f : fields) {
						if (f.getType().isInstance(new IndividualCases())) {
							resultList.add(f);
							break;
						} else if (f.getType().isInstance(new Enquiries())) {
							resultList.add(f);
							break;
						}
					}
				}
				
			}
			
		}
		
		return SUCCESS;
	}
}
