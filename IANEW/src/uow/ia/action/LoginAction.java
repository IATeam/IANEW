package uow.ia.action;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.EntityNameResolver;
import org.hibernate.search.FullTextSession;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import uow.ia.bean.Contacts;
import uow.ia.bean.Enquiries;
import uow.ia.bean.IndividualCases;
import uow.ia.bean.Users;
import uow.ia.util.SearchUtil;

import com.opensymphony.xwork2.ActionContext;
import com.sun.tools.ws.wsdl.framework.Entity;

/**
 * This class is used for Login action as well as for Search Box
 * 
 * @author KimTo
 * @author Quang
 * @author Yang
 *
 */
public class LoginAction extends BaseAction{

	private String username;
	private String password;
	
	private List list = new ArrayList();
	private String searchString = null;
	private List resultList = new ArrayList();
	
	public String execute(){
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Users user = adminService.getUsers(userDetails.getUsername());
		ActionContext.getContext().getSession().put(USER, user);
        System.out.println("username: " + userDetails.getUsername());
        System.out.println("password: " + userDetails.getPassword());
        Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>) userDetails.getAuthorities();
        for (Iterator it = authorities.iterator(); it.hasNext();) {
            SimpleGrantedAuthority authority = (SimpleGrantedAuthority) it.next();
            System.out.println("Role: " + authority.getAuthority());
        }
        FullTextSession fts = utilService.getFullTextSession();
		
		try {
			fts.createIndexer().startAndWait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        
        return SUCCESS;
	}

	/**
	 * This method is used for the Search Box, which is used to search for Enquiry and Individual Case
	 * that contains the search string
	 * 
	 * It will call the getResultList utility to get all the objects that contains the search string.
	 * However, the method will check whether the object or its declared fields are an instance of 
	 * Enquiries or IndividualCases. If it is, it will add to the resultList. This resultList is a list 
	 * contains all the results that matched the user search string, and will be displayed to the user.
	 * 
	 * All other object that is not an instance of Enquiries or IndividualCases and has no declared fields
	 * that are an instance of either of those entity, will be disregard. 
	 * 
	 * @return String SUCCESS
	 * @see uow.ia.util.SearchUtil#getResultList(String, uow.ia.service.UtilService)
	 */
	public String search() {
		
		if (!(searchString == null || searchString.equals(""))) {
			list = new SearchUtil().getResultObjectList(searchString, utilService);
			System.out.println("Got list" + list.toString());
			for (Object o : list) {
				int type = 0;
				Field[] fields = o.getClass().getDeclaredFields();
				
				System.out.println("class name is: " + o.getClass().getSimpleName());
				
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
}
