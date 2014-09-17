/**
 * 
 */
package uow.ia.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import uow.ia.bean.DisabilityTypes;
import uow.ia.bean.Users;
import uow.ia.dao.DisabilityTypesDao;
import uow.ia.dao.UsersDao;
import uow.ia.service.AdminService;
import uow.ia.service.EnquiryService;

/**
 * @author ZhiYu Yang
 * @date 23/08/2014
 *
 */
@Service(AdminService.SERVICENAME)
public class AdminServiceImpl implements AdminService {
	
	
	@Resource
	private DisabilityTypesDao<DisabilityTypes> disabilityTypesDao;
	
	@Resource
	private UsersDao<Users> usersDao;
	
	@Override
	public List<DisabilityTypes> findDisabilityTypes() {
		return disabilityTypesDao.find(" from DisabilityTypes");
	}
	
	@Override
	public boolean saveDisabilityType(DisabilityTypes d) {
		try {
			disabilityTypesDao.save(d);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	@Override
	public boolean deleteDisabilityType(DisabilityTypes d) {
		try {
			disabilityTypesDao.delete(d);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	@Override
	public boolean updateDisabilityType(DisabilityTypes d) {
		try {
			disabilityTypesDao.update(d);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	@Override
	public Users login(String username, String password) {
		List<Users> users = usersDao.find(" from Users u where u.username=? and u.password=?", new Object[] {username, password});
		if(users.isEmpty()){
			return null;
		} else {
			return users.get(0);
		}
	}

}
