package uow.ia.dao.impl;

import org.springframework.stereotype.Repository;

import uow.ia.bean.DangerTypes;
import uow.ia.dao.DangerTypesDao;

/**
 * @author David Forbes
 * @date 10/08/2014
 *
 */
@Repository(DangerTypesDao.DAONAME)
public class DangerTypesDaoImpl extends BaseDaoImpl<DangerTypes> implements
DangerTypesDao<DangerTypes> {

}
