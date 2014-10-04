/**
 * 
 */
package uow.ia.service;

import java.util.List;

import uow.ia.bean.AccommodationTypes;
import uow.ia.bean.Contacts;
import uow.ia.bean.GenderTypes;

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
	
	public Contacts getContacts(int id);
	
	public List<Contacts> findAdvocates();
	
	/** 
     * retrieve with List<object> of Gender Type from Gender_Type table
     *  @author davidforbes
     *  @date 14/09/2014
     * @return List<Object>
     */
	public List<GenderTypes> findGenderTypes();
	
	/** 
     * retrieve with List<object> of Accommodation Types from Accommodation_Types table
     *  @author davidforbes
     *  @date 09/09/2014
     * @return List<Object>
     */
	public List<AccommodationTypes> findAccommodationTypes();
	
	public List<Contacts> findClients();

}
