package uow.ia.dao.impl;

import org.springframework.stereotype.Repository;

import uow.ia.bean.Users;
import uow.ia.dao.UsersDao;

/**
 * @author David Forbes
 * @date 10/08/2014
 *
 */
@Repository(UsersDao.DAONAME)
public class UsersDaoImpl extends BaseDaoImpl<Users> implements
UsersDao<Users> {

}
