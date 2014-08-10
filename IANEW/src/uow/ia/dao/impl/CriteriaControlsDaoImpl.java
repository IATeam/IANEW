package uow.ia.dao.impl;

import org.springframework.stereotype.Repository;

import uow.ia.bean.CriteriaControls;
import uow.ia.dao.CriteriaControlsDao;

/**
 * @author David Forbes
 * @date 10/08/2014
 *
 */
@Repository(CriteriaControlsDao.DAONAME)
public class CriteriaControlsDaoImpl extends BaseDaoImpl<CriteriaControls> implements
CriteriaControlsDao<CriteriaControls>{

}
