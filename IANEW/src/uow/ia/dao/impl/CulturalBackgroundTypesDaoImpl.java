/**
 * 
 */
package uow.ia.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import uow.ia.bean.CulturalBackgroundTypes;
import uow.ia.dao.AccommodationTypesDao;
import uow.ia.dao.CulturalBackgroundTypesDao;

/**
 * @author bruce
 *
 */
@Repository(CulturalBackgroundTypesDao.DAONAME)
public class CulturalBackgroundTypesDaoImpl extends BaseDaoImpl<CulturalBackgroundTypes>
		implements CulturalBackgroundTypesDao<CulturalBackgroundTypes> {
	
}
