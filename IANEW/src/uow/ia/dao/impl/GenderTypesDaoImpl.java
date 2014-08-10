/**
 * 
 */
package uow.ia.dao.impl;


import org.springframework.stereotype.Repository;

import uow.ia.bean.GenderTypes;
import uow.ia.dao.GenderTypesDao;

/**
 * @author bruce
 *
 */
@Repository(GenderTypesDao.DAONAME)
public class GenderTypesDaoImpl extends BaseDaoImpl<GenderTypes> implements
		GenderTypesDao<GenderTypes> {
}
