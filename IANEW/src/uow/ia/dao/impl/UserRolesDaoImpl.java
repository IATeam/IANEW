package uow.ia.dao.impl;

import org.springframework.stereotype.Repository;

import uow.ia.bean.UserRoles;
import uow.ia.dao.UserRolesDao;

/**
 * @author David Forbes
 * @date 10/08/2014
 *
 */
@Repository(UserRolesDao.DAONAME)
public class UserRolesDaoImpl extends BaseDaoImpl<UserRoles> implements
UserRolesDao<UserRoles>{

}
