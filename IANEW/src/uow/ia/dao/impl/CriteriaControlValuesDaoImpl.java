package uow.ia.dao.impl;

import org.springframework.stereotype.Repository;

import uow.ia.bean.CriteriaControlValues;
import uow.ia.dao.CriteriaControlValuesDao;

/**
 * @author David Forbes
 * @date 10/08/2014
 *
 */
@Repository(CriteriaControlValuesDao.DAONAME)
public class CriteriaControlValuesDaoImpl extends BaseDaoImpl<CriteriaControlValues> implements
CriteriaControlValuesDao<CriteriaControlValues> {

}
