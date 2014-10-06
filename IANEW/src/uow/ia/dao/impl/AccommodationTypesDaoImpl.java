/**
 * 
 */
package uow.ia.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import uow.ia.bean.AccommodationTypes;
import uow.ia.dao.AccommodationTypesDao;

/**
 * @author bruce
 *
 */
@Repository(AccommodationTypesDao.DAONAME)
public class AccommodationTypesDaoImpl extends BaseDaoImpl<AccommodationTypes> 
		implements AccommodationTypesDao<AccommodationTypes> {
	
//	private SessionFactory sessionFactory;
//
//	public SessionFactory getSessionFactory() {
//		return sessionFactory;
//	}
//
//	@Autowired
//	public void setSessionFactory(SessionFactory sessionFactory) {
//
//		// the method name cannot be setSessionFactory since HibernateDaoSupport
//		// has this one.
//		// public void anyMethodName(SessionFactory sessionFactory) {
//		this.sessionFactory = sessionFactory;
//		// setSessionFactory(sessionFactory);
//
//	}
//
//	private Session getCurrentSession() {
//		return sessionFactory.getCurrentSession();
//	}
//	
//	@Override
//	public List<AccommodationTypes> find(String hql) {
//		List<AccommodationTypes> list = new ArrayList<AccommodationTypes>();
//		Iterator<AccommodationTypes> itor = this.getCurrentSession().createQuery(hql).iterate();
//		while(itor.hasNext()){
//			list.add(itor.next());
//		}
//		System.out.println("override find called");
//		return list;
//	}

}
