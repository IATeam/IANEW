/**
 * 
 */
package uow.ia.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import uow.ia.bean.DisabilityTypes;
import uow.ia.dao.DisabilityTypesDao;
import uow.ia.service.AdminService;
import uow.ia.service.NewEnquiryService;

/**
 * @author ZhiYu Yang
 * @date 23/08/2014
 *
 */
@Service(AdminService.SERVICENAME)
public class AdminServiceImpl implements AdminService {
	
	
	@Resource
	private DisabilityTypesDao<DisabilityTypes> disabilityTypesDao;
	
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

}
