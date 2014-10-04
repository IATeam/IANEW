/**
 * 
 */
package uow.ia.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.metadata.ClassMetadata;
import org.hibernate.search.FullTextSession;

/**
 * Base Dao
 * @author bruce
 *
 */
public interface BaseDao<T> {
	
	public static final String DAONAME = "BaseDao";
	
	/** 
     * save object
     *  
     * @param o 
     */
	public Serializable save(T o);
	
	/** 
     * delete object 
     *  
     * @param o 
     */
	public void delete(T o);
	
	/** 
     * update object 
     *  
     * @param o 
     */
	public void update(T o);
	
	/** 
     * update object 
     *  
     * @param o 
     */
	public T merge(T o);
	
	/** 
     * save or update object 
     *  
     * @param o 
     */
	public void saveOrUpdate(T o);
	
	/** 
     * retrieve all with query 
     *  
     * @param hql 
     * @return List<Object>
     */
	public List<T> find(String hql);
	
	public List<T> find(String hql,String param, Object o);
	
	/** 
     * retrieve with object[] 
     *  
     * @param hql 
     * @param param
     * @return List<Object>
     */
	public List<T> find(String hql, Object[] param);
	
	/** 
     * retrieve with List<object> 
     *  
     * @param hql 
     * @param param
     * @return List<Object>
     */
	public List<T> find(String hql, List<Object> param);
	
	/** 
     * retrieve with object[] with pages
     *  
     * @param hql 
     * @param page
     *              search which page
     * @param rows
     *              rows per page
     * @return List<Object>
     */
	public List<T> find(String hql, Integer page, Integer rows);
	
	/** 
     * retrieve with object[] with pages
     *  
     * @param hql 
     * @param param
     * @param page
     *              search which page
     * @param rows
     *              rows per page
     * @return List<Object>
     */
	public List<T> find(String hql, Object[] param, Integer page, Integer rows);
	
	/** 
     * retrieve with List<Object> with pages
     *  
     * @param hql 
     * @param param
     * @param page
     *              search which page
     * @param rows
     *              rows per page
     * @return List<Object>
     */
	public List<T> find(String hql, List<Object> param, Integer page, Integer rows);
	
	/** 
     * retrieve object 
     *  
     * @param c 
     *            object type 
     * @param id 
     * @return Object 
     */
	public T get(Class<T> c, Serializable id);
	
	/** 
     * retrieve object with Object[]
     *  
     * @param hql
     * @param param 
     * @return Object 
     */
	public T get(String hql, Object[] param);
	
	/** 
     * retrieve object with List<Object>
     *  
     * @param hql
     * @param param 
     * @return Object 
     */
	public T get(String hql, List<Object> param);
	
	/** 
     * select count(*) from table 
     *  
     * @param hql 
     * @return Long
     */ 
	public Long count(String hql);
	
	/** 
     * select count(*) from table 
     *  
     * @param hql
     * @param param 
     * @return Long
     */
	public Long count(String hql, Object[] param);
	
	/** 
     * select count(*) from table 
     *  
     * @param hql
     * @param param 
     * @return Long
     */
	public Long count(String hql, List<Object> param);
	
	/** 
     * run HQL 
     *  
     * @param hql 
     * @return response number 
     */
	public Integer executeHql(String hql);
	
	/** 
     * run HQL 
     *  
     * @param hql 
     * @param param
     * @return response number 
     */
	public Integer executeHql(String hql, Object[] param);
	
	/** 
     * run HQL 
     *  
     * @param hql 
     * @param param
     * @return response number 
     */
	public Integer executeHql(String hql, List<Object> param);
	
	public Map<String, ClassMetadata> getAllClassMetadata();
	
	public Class getClassByObject(Object ob);
	
	public FullTextSession getFullTextSession();
	
	public List<T> search(Map<String, Object> parametersMap, Class clazz);
}
