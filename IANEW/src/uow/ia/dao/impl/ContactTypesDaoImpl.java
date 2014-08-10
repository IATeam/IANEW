package uow.ia.dao.impl;

import org.springframework.stereotype.Repository;

import uow.ia.bean.ContactTypes;
import uow.ia.dao.ContactTypesDao;

/**
 * @author David Forbes
 * @date 10/08/2014
 *
 */
@Repository(ContactTypesDao.DAONAME)
public class ContactTypesDaoImpl extends BaseDaoImpl<ContactTypes> implements
ContactTypesDao<ContactTypes> {

}
