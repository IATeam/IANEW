package uow.ia.dao.impl;

import org.springframework.stereotype.Repository;

import uow.ia.bean.IndividualCaseCommunications;
import uow.ia.dao.IndividualCaseCommunicationsDao;

/**
 * @author David Forbes
 * @date 10/08/2014
 *
 */
@Repository(IndividualCaseCommunicationsDao.DAONAME)
public class IndividualCaseCommunicationsDaoImpl extends BaseDaoImpl<IndividualCaseCommunications> implements
IndividualCaseCommunicationsDao<IndividualCaseCommunications> {

}
