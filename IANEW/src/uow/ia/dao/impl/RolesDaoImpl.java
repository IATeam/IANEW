package uow.ia.dao.impl;

import org.springframework.stereotype.Repository;

import uow.ia.bean.Roles;
import uow.ia.dao.RolesDao;

/**
 * @author David Forbes
 * @date 10/08/2014
 *
 */
@Repository(RolesDao.DAONAME)
public class RolesDaoImpl extends BaseDaoImpl<Roles> implements
RolesDao<Roles>{

}
