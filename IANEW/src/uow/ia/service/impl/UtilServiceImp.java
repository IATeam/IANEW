package uow.ia.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.metadata.ClassMetadata;
import org.hibernate.search.FullTextSession;
import org.springframework.stereotype.Service;

import uow.ia.service.*;
import uow.ia.bean.Users;
import uow.ia.dao.BaseDao;

@Service(UtilService.SERVICENAME)
public class UtilServiceImp implements UtilService{
	@Resource
	private BaseDao<Users> baseDAO;
	
	@Override
	public Map<String, ClassMetadata> getAllClassMetadata(){
		System.out.println(baseDAO.getAllClassMetadata().toString());
		return baseDAO.getAllClassMetadata();
	}
	
	@Override
	public FullTextSession getFullTextSession(){
		return baseDAO.getFullTextSession();
	}
}
