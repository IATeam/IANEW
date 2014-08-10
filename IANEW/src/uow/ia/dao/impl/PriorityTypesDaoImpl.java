package uow.ia.dao.impl;

import org.springframework.stereotype.Repository;

import uow.ia.bean.PriorityTypes;
import uow.ia.dao.PriorityTypesDao;


/**
 * @author David Forbes
 * @date 10/08/2014
 *
 */
@Repository(PriorityTypesDao.DAONAME)
public class PriorityTypesDaoImpl extends BaseDaoImpl<PriorityTypes> implements
PriorityTypesDao<PriorityTypes>{

}
