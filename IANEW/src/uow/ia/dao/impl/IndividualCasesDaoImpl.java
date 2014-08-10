package uow.ia.dao.impl;

import org.springframework.stereotype.Repository;

import uow.ia.bean.IndividualCases;
import uow.ia.dao.IndividualCasesDao;

/**
 * @author David Forbes
 * @date 10/08/2014
 *
 */
@Repository(IndividualCasesDao.DAONAME)
public class IndividualCasesDaoImpl extends BaseDaoImpl<IndividualCases> implements
IndividualCasesDao<IndividualCases>{

}
