/**
 * 
 */
package uow.ia.dao.impl;

import org.springframework.stereotype.Repository;

import uow.ia.bean.ContactEmployments;
import uow.ia.dao.ContactEmploymentsDao;

/**
 * @author ZhiYu Yang
 * @date 16/08/2014
 *
 */
@Repository(ContactEmploymentsDao.DAONAME)
public class ContactEmploymentsDaoImpl extends BaseDaoImpl<ContactEmployments>
		implements ContactEmploymentsDao<ContactEmployments> {

}
