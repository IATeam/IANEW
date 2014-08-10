/**
 * 
 */
package uow.ia.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import uow.ia.bean.GenderTypes;
import uow.ia.dao.AccommodationTypesDao;
import uow.ia.dao.GenderTypesDao;

/**
 * @author bruce
 *
 */
@Repository(GenderTypesDao.DAONAME)
public class GenderTypesDaoImpl extends BaseDaoImpl<GenderTypes> implements
		GenderTypesDao<GenderTypes> {
}
