package uow.ia.dao.impl;

import org.springframework.stereotype.Repository;

import uow.ia.bean.EmploymentTypes;
import uow.ia.dao.EmploymentTypesDao;

/**
 * @author David Forbes
 * @date 10/08/2014
 *
 */
@Repository(EmploymentTypesDao.DAONAME)
public class EmploymentTypesDaoImpl extends BaseDaoImpl<EmploymentTypes> implements
EmploymentTypesDao<EmploymentTypes>{

}
