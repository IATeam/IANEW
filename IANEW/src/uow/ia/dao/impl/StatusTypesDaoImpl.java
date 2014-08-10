package uow.ia.dao.impl;

import org.springframework.stereotype.Repository;

import uow.ia.bean.StatusTypes;
import uow.ia.dao.StatusTypesDao;

/**
 * @author David Forbes
 * @date 10/08/2014
 *
 */
@Repository(StatusTypesDao.DAONAME)
public class StatusTypesDaoImpl extends BaseDaoImpl<StatusTypes> implements
StatusTypesDao<StatusTypes>{

}
