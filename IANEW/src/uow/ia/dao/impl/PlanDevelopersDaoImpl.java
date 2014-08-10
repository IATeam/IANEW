package uow.ia.dao.impl;

import org.springframework.stereotype.Repository;

import uow.ia.bean.PlanDevelopers;
import uow.ia.dao.PlanDevelopersDao;

/**
 * @author David Forbes
 * @date 10/08/2014
 *
 */
@Repository(PlanDevelopersDao.DAONAME)
public class PlanDevelopersDaoImpl extends BaseDaoImpl<PlanDevelopers> implements
PlanDevelopersDao<PlanDevelopers> {

}
