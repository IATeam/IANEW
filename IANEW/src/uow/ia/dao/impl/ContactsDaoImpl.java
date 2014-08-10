package uow.ia.dao.impl;

import org.springframework.stereotype.Repository;

import uow.ia.bean.Contacts;
import uow.ia.dao.ContactsDao;

/**
 * @author David Forbes
 * @date 10/08/2014
 *
 */
@Repository(ContactsDao.DAONAME)
public class ContactsDaoImpl extends BaseDaoImpl<Contacts> implements
ContactsDao<Contacts>  {

}
