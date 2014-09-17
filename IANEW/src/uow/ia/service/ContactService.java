/**
 * 
 */
package uow.ia.service;

import java.util.List;

import uow.ia.bean.Contacts;

/**
 * @author ZhiYu Yang
 * @date 17/09/2014
 *
 */
public interface ContactService {
	public static final String SERVICENAME = "ContactService";
	
	public boolean saveContact(Contacts c);
	
	public boolean updateContact(Contacts c);
	
	public boolean saveOrUpdateContact(Contacts c);
	
	public boolean deleteContact(Contacts c);
	
	public Contacts mergeContacts(Contacts c);
	
	public List<Contacts> findContactsByFullName(String firstName, String lastName);
	
	public Long countContacts();
	
	public List<Contacts> findContacts();
	
	public List<Contacts> findContactsByPage(int pageNo, int rows);

}
