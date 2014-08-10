package uow.ia.dao.impl;

import org.springframework.stereotype.Repository;

import uow.ia.bean.GoalTypes;
import uow.ia.dao.GoalTypesDao;

/**
 * @author david
 *
 */
@Repository(GoalTypesDao.DAONAME)

public class GoalTypesDaoImpl extends BaseDaoImpl<GoalTypes> 
implements GoalTypesDao<GoalTypes> {

}
