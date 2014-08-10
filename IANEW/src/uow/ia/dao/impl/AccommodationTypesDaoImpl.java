/**
 * 
 */
package uow.ia.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import uow.ia.bean.AccommodationTypes;
import uow.ia.dao.AccommodationTypesDao;

/**
 * @author bruce
 *
 */
@Repository(AccommodationTypesDao.DAONAME)
public class AccommodationTypesDaoImpl extends BaseDaoImpl<AccommodationTypes> 
		implements AccommodationTypesDao<AccommodationTypes> {

}
