/**
 * 
 */
package uow.ia.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import uow.ia.bean.AccommodationTypes;
import uow.ia.bean.ContactTypes;
import uow.ia.bean.Contacts;
import uow.ia.bean.GenderTypes;
import uow.ia.dao.AccommodationTypesDao;
import uow.ia.dao.ContactTypesDao;
import uow.ia.dao.ContactsDao;
import uow.ia.dao.GenderTypesDao;
import uow.ia.service.ContactService;



/**
 * @author ZhiYu Yang
 * @date 17/09/2014
 *
 */
@Service(ContactService.SERVICENAME)
public class ContactServiceImpl implements ContactService {
	
	@Resource
	private ContactsDao<Contacts> contactsDao;
	
	@Resource
	private ContactTypesDao<ContactTypes> contactTypesDao;

	@Override
	public boolean saveContact(Contacts c) {
		try {
			contactsDao.save(c);
			return true;
		} catch (Exception e) {
			System.out.println("saveContact Exception: " + e);
			return false;
		}
	}

	@Override
	public boolean updateContact(Contacts c) {
		try {
			contactsDao.update(c);
			return true;
		} catch (Exception e) {
			System.out.println("updateContact Exception: " + e);
			return false;
		}
	}

	@Override
	public boolean saveOrUpdateContact(Contacts c) {
		try {
			contactsDao.saveOrUpdate(c);
			return true;
		} catch (Exception e) {
			System.out.println("saveOrUpdateContact Exception: " + e);
			return false;
		}
	}

	@Override
	public boolean deleteContact(Contacts c) {
		try {
			contactsDao.delete(c);
			return true;
		} catch (Exception e) {
			System.out.println("deleteContact Exception: " + e);
			return false;
		}
	}

	@Override
	public Contacts mergeContacts(Contacts c) {
		try {
			return contactsDao.merge(c);
		} catch (Exception e) {
			System.out.println("mergeContacts Exception: " + e);
			return null;
		}
	}

	@Override
	public List<Contacts> findContactsByFullName(String firstName,
			String lastName) {
		return contactsDao.find(
				" from Contacts c where lower(c.firstname) = ? and lower(c.lastname) = ? ",
				new Object[] { firstName.toLowerCase(), lastName.toLowerCase() });
	}
	
	/**
	 * search the input name like both firstname and lastname, return a list contacts which have similar
	 * first name or last name
	 */
	@Override
	public List<Contacts> findContactsByNameLike(String name) {
		List<Contacts> tmpList = new ArrayList<Contacts>();
		name = "%"+name+"%";
		tmpList.addAll(contactsDao.find(
				" from Contacts c where lower(c.firstname) like ?", new Object[] {name.toLowerCase()}));
		tmpList.addAll(contactsDao.find(
				" from Contacts c where lower(c.lastname) like ?", new Object[] {name.toLowerCase()}));
		return tmpList;
	}

	@Override
	public Long countContacts() {
		return contactsDao.count("select count(*) from Contacts");
	}

	@Override
	public List<Contacts> findContacts() {
		return contactsDao.find(" from Contacts");
	}

	@Override
	public List<Contacts> findContactsByPage(int pageNo, int rows) {
		return contactsDao.find(" from Contacts", pageNo, rows);
	}

	@Override
	public Contacts getContacts(int id) {
		return contactsDao.get(Contacts.class, id);
	}
	
	@Override
	public List<Contacts> findAdvocates() {
		ContactTypes c = contactTypesDao.get(
				" from ContactTypes t where t.contactTypeName =?",
				new Object[] { "Advocate" });
		return contactsDao.find(" from Contacts t where t.contactType =:contactType order by t.lastname asc, t.firstname asc","contactType", c);
	}
	
	@Override
	public List<Contacts> findClients() {
		ContactTypes c = contactTypesDao.get(
				" from ContactTypes t where t.contactTypeName =?",
				new Object[] { "Client" });
		return contactsDao.find(" from Contacts t where t.contactType =:contactType order by t.lastname asc, t.firstname asc","contactType", c);
	}

}
