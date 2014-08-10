/**
 * 
 */
package uow.ia.dao.impl;


import org.springframework.stereotype.Repository;

import uow.ia.bean.DisabilityTypes;
import uow.ia.dao.DisabilityTypesDao;

/**
 * @author bruce
 *
 */
@Repository(DisabilityTypesDao.DAONAME)
public class DisabilityTypesDaoImpl extends BaseDaoImpl<DisabilityTypes>
		implements DisabilityTypesDao<DisabilityTypes> {

}
