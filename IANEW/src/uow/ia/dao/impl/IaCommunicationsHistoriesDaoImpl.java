package uow.ia.dao.impl;

import org.springframework.stereotype.Repository;

import uow.ia.bean.IaCommunicationsHistories;
import uow.ia.dao.IaCommunicationsHistoriesDao;

/**
 * @author David Forbes
 * @date 10/08/2014
 *
 */
@Repository(IaCommunicationsHistoriesDao.DAONAME)
public class IaCommunicationsHistoriesDaoImpl extends BaseDaoImpl<IaCommunicationsHistories> implements
IaCommunicationsHistoriesDao<IaCommunicationsHistories> {

}
