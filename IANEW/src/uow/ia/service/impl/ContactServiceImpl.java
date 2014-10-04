/**
 * 
 */
package uow.ia.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import uow.ia.bean.Contacts;
import uow.ia.dao.ContactsDao;
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
				" from Contacts c where c.firstname = ? and c.lastname = ? ",
				new Object[] { firstName, lastName });
	}
	
	@Override
	public List<Contacts> findContactsByNameLike(String name) {
		List<Contacts> tmpList = new ArrayList<Contacts>();
		name = "%"+name+"%";
		tmpList.addAll(contactsDao.find(
				" from Contacts c where c.firstname like ?", new Object[] {name}));
		//tmpList.addAll(contactsDao.find(
		//		" from Contacts c where c.lastname like %"+name+"%"));
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

}
