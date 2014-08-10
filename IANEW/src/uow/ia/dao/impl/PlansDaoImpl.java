package uow.ia.dao.impl;

import org.springframework.stereotype.Repository;

import uow.ia.bean.Plans;
import uow.ia.dao.PlansDao;

/**
 * @author David Forbes
 * @date 10/08/2014
 *
 */
@Repository(PlansDao.DAONAME)
public class PlansDaoImpl extends BaseDaoImpl<Plans> implements 
PlansDao<Plans>{

}
