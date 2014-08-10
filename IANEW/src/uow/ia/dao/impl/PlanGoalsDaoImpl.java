package uow.ia.dao.impl;

import org.springframework.stereotype.Repository;

import uow.ia.bean.PlanGoals;
import uow.ia.dao.PlanGoalsDao;

/**
 * @author David Forbes
 * @date 10/08/2014
 *
 */
@Repository(PlanGoalsDao.DAONAME)
public class PlanGoalsDaoImpl extends BaseDaoImpl<PlanGoals> implements 
PlanGoalsDao<PlanGoals>{

}
