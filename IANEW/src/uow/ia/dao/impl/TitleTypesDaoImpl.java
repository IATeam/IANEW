/**
 * 
 */
package uow.ia.dao.impl;

import org.springframework.stereotype.Repository;

import uow.ia.bean.AccommodationTypes;
import uow.ia.dao.AccommodationTypesDao;
import uow.ia.dao.TitleTypesDao;

/**
 * @author bruce
 *
 */
@Repository(TitleTypesDao.DAONAME)
public class TitleTypesDaoImpl<TitleTypes> extends BaseDaoImpl<TitleTypes> implements TitleTypesDao<TitleTypes> {

}
