/**
 * 
 */
package uow.ia.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import uow.ia.bean.DisabilityTypes;
import uow.ia.dao.AccommodationTypesDao;
import uow.ia.dao.DisabilityTypesDao;

/**
 * @author bruce
 *
 */
@Repository(DisabilityTypesDao.DAONAME)
public class DisabilityTypesDaoImpl extends BaseDaoImpl<DisabilityTypes>
		implements DisabilityTypesDao<DisabilityTypes> {

}
