package uow.ia.dao.impl;

import org.springframework.stereotype.Repository;

import uow.ia.bean.Risks;
import uow.ia.dao.RisksDao;

/**
 * @author David Forbes
 * @date 10/08/2014
 *
 */
@Repository(RisksDao.DAONAME)
public class RisksDaoImpl extends BaseDaoImpl<Risks> implements
RisksDao<Risks>{

}
