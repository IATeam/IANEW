/**
 * 
 */
package uow.ia.dao.impl;

import org.springframework.stereotype.Repository;

import uow.ia.bean.IssueTypes;
import uow.ia.dao.IssueTypesDao;

/**
 * @author bruce
 *
 */
@Repository(IssueTypesDao.DAONAME)
public class IssueTypesDaoImpl extends BaseDaoImpl<IssueTypes> implements
		IssueTypesDao<IssueTypes> {

}
