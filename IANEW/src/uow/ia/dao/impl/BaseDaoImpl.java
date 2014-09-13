/**
 * 
 */
package uow.ia.dao.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.metadata.ClassMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import uow.ia.dao.BaseDao;

/**
 * @author bruce
 * 
 */

@Repository(BaseDao.DAONAME)
// SuppressWarnings("all")
public class BaseDaoImpl<T> implements BaseDao<T> {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {

		// the method name cannot be setSessionFactory since HibernateDaoSupport
		// has this one.
		// public void anyMethodName(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		// setSessionFactory(sessionFactory);

	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public Serializable save(T o) {
		return this.getCurrentSession().save(o);
		// return getHibernateTemplate().save(o);
	}

	@Override
	public void delete(T o) {
		this.getCurrentSession().delete(o);
		// getHibernateTemplate().delete(o);
	}

	@Override
	public void update(T o) {
		this.getCurrentSession().update(o);
		// getHibernateTemplate().update(o);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public T merge(T o) {
		return (T) this.getCurrentSession().merge(o);
		// getHibernateTemplate().update(o);
	}

	@Override
	public void saveOrUpdate(T o) {
		this.getCurrentSession().saveOrUpdate(o);
		// getHibernateTemplate().saveOrUpdate(o);
	}

	@Override
	public List<T> find(String hql) {
		return this.getCurrentSession().createQuery(hql).list();
		// return (List<T>) getHibernateTemplate().find(hql);
	}
	
	@Override
	public List<T> find(String hql, String param, Object o) {
		Query q = this.getCurrentSession().createQuery(hql);
		q.setParameter(param, o);
		return q.list();
	}

	@Override
	public List<T> find(String hql, Object[] param) {

		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				q.setParameter(i, param[i]);
			}
		}
		return q.list();

		// return (List<T>) getHibernateTemplate().find(hql, param);
	}

	@Override
	public List<T> find(String hql, List<Object> param) {

		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.size() > 0) {
			for (int i = 0; i < param.size(); i++) {
				q.setParameter(i, param.get(i));
				// q.setParameter("firstname","%"+param+"%");
			}
		}
		return q.list();

		// return (List<T>) getHibernateTemplate().find(hql, param);
	}
	
	@Override
	public List<T> find(String hql, Integer page, Integer rows) {
		if (page == null || page < 1) {
			page = 1;
		}
		if (rows == null || rows < 1) {
			rows = 10;
		}
		Query q = this.getCurrentSession().createQuery(hql);
		return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
	}

	@Override
	public List<T> find(String hql, Object[] param, Integer page, Integer rows) {
		if (page == null || page < 1) {
			page = 1;
		}
		if (rows == null || rows < 1) {
			rows = 10;
		}
		// modify for hibernatedaosupport
		/*
		 * HibernateCallback<T> callback = new HibernateCallback<T>() {
		 * 
		 * @Override public T doInHibernate(Session session) throws
		 * HibernateException { Query q = session.createQuery(hql); if (param !=
		 * null && param.length > 0) { for (int i = 0; i < param.length; i++) {
		 * q.setParameter(i, param[i]); } } return (T) q.setFirstResult((page -
		 * 1) * rows).setMaxResults(rows).list(); } };
		 */

		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				q.setParameter(i, param[i]);
			}
		}
		return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
		// return (List<T>) getHibernateTemplate().execute(callback);
	}

	@Override
	public List<T> find(String hql, List<Object> param, Integer page,
			Integer rows) {

		if (page == null || page < 1) {
			page = 1;
		}
		if (rows == null || rows < 1) {
			rows = 10;
		}
		Query q = this.getCurrentSession().createQuery(hql);
		// Query q = session.createQuery(hql);
		if (param != null && param.size() > 0) {
			for (int i = 0; i < param.size(); i++) {
				q.setParameter(i, param.get(i));
			}
		}
		return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();

		// return null;
	}

	@Override
	public T get(Class<T> c, Serializable id) {
		return (T) this.getCurrentSession().get(c, id);
		// return getHibernateTemplate().get(c, id);
	}

	@Override
	public T get(String hql, Object[] param) {
		List<T> l = this.find(hql, param);
		if (l != null && l.size() > 0) {
			return l.get(0);
		} else {
			return null;
		}
	}

	@Override
	public T get(String hql, List<Object> param) {
		List<T> l = this.find(hql, param);
		if (l != null && l.size() > 0) {
			return l.get(0);
		} else {
			return null;
		}
	}

	@Override
	public Long count(String hql) {
		return (Long) this.getCurrentSession().createQuery(hql).uniqueResult();
		// return null;
	}

	@Override
	public Long count(String hql, Object[] param) {

		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				q.setParameter(i, param[i]);
			}
		}
		return (Long) q.uniqueResult();

		// return null;
	}

	@Override
	public Long count(String hql, List<Object> param) {

		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.size() > 0) {
			for (int i = 0; i < param.size(); i++) {
				q.setParameter(i, param.get(i));
			}
		}
		return (Long) q.uniqueResult();

		// return null;
	}

	@Override
	public Integer executeHql(String hql) {

		return this.getCurrentSession().createQuery(hql).executeUpdate();

		// return null;
	}

	@Override
	public Integer executeHql(String hql, Object[] param) {

		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				q.setParameter(i, param[i]);
			}
		}
		return q.executeUpdate();

		// return null;
	}

	@Override
	public Integer executeHql(String hql, List<Object> param) {

		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.size() > 0) {
			for (int i = 0; i < param.size(); i++) {
				q.setParameter(i, param.get(i));
			}
		}
		return q.executeUpdate();

		// return null;
	}

	@Override
	public Map<String, ClassMetadata> getAllClassMetadata() {
		return sessionFactory.getAllClassMetadata();
	}

	@Override
	public Class getClassByObject(Object ob) {
		return sessionFactory.getClassMetadata(ob.getClass()).getMappedClass();
	}

}
