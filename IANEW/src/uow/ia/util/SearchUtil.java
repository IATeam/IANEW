package uow.ia.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.queryParser.MultiFieldQueryParser;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.Sort;
import org.apache.lucene.search.SortField;
import org.apache.lucene.util.Version;
import org.hibernate.Filter;
import org.hibernate.mapping.Collection;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.search.FullTextQuery;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.query.dsl.QueryBuilder;

import com.google.common.collect.ImmutableBiMap.Builder;
import com.sun.tools.ws.wsdl.framework.Entity;

import bsh.This;
import uow.ia.bean.Contacts;
import uow.ia.bean.TitleTypes;
import uow.ia.dao.BaseDao;
import uow.ia.service.UtilService;

public class SearchUtil {
	UtilService service = null;
	/**
	 * @return the fieldList
	 */
	public List<String> getFieldList() {
		return fieldList;
	}

	/**
	 * @param fieldList the fieldList to set
	 */
	public void setFieldList(List<String> fieldList) {
		this.fieldList = fieldList;
	}

	private List<String> fieldList = new ArrayList<String>();
	
	public void fieldCollection (Class mappedClass, String objectFieldName) {
		Field[] fields = mappedClass.getDeclaredFields();
		for (Field f : fields) {
			if (f.getAnnotations().length != 0) {
				Class type = f.getType();
				if (!(Collection.class.isAssignableFrom(type))) {
					if (type.isInstance(new String()) || 
						type.isInstance(new java.sql.Date(0)) || 
						type.isInstance(new java.util.Date()) ||
						type.isInstance(new Integer(0)) ) {
						if (objectFieldName == null) { 
							this.fieldList.add(f.getName());
						} else { 
							this.fieldList.add(objectFieldName + "." + f.getName());
						}
					} else { 
						fieldCollection(type, f.getName());
					}
				}
			}
		}
	}
	
	public String[] SearchFields() {
		
		Map<String, ClassMetadata> map = service.getAllClassMetadata();
		for (ClassMetadata cm : map.values()) {
			fieldCollection(cm.getMappedClass(), null);
		}
		
		return this.fieldList.toArray(new String[0]);
	
	}
	
	public List getResultObjectList(String searchString, UtilService service) {
		this.service = service;
		String[] searchFields = SearchFields();
		
		BooleanQuery.setMaxClauseCount(20000);
		QueryParser parser = new MultiFieldQueryParser(Version.LUCENE_36,
														searchFields,
														new StandardAnalyzer(Version.LUCENE_36));
		
		org.apache.lucene.search.Query luceneQuery = null;
		
		try {
			luceneQuery = parser.parse(searchString);
		} catch (ParseException e) {
			System.out.println("parse exception " + e);
		} catch (Exception e2) {
			System.out.println("other exception " + e2);
		}
		
		FullTextSession fts = service.getFullTextSession();
//		
//		try {
//			fts.createIndexer().startAndWait();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
		fts.getTransaction().begin();
		
		List list = fts.createFullTextQuery(luceneQuery).list();
		
		fts.getTransaction().commit();
		
		return list;
	}
	
	
	/**
	 * @Quang
	 * @param searchString
	 * @param service
	 * @return List
	 */
	public List getResultList(String searchString, UtilService service) {
		
		FullTextSession fts = service.getFullTextSession();		
		fts.getTransaction().begin();
		
		List list = fts.createFullTextQuery(getLuceneQuery(searchString)).list();
		
		fts.getTransaction().commit();
		
		return list;
	}
	
	public int getTotalNumberOfRecords(String sortField, String searchString, UtilService s, boolean asc, Class<?> entity){
FullTextQuery ftq = null;
		
		if(sortField == null){
			ftq = getQueryResult(searchString, s, entity);
		}else{
			ftq = getSortedQueryResult(sortField, searchString, s, asc, entity);
		}
		
		return ftq.getResultSize();
	}
	
	public List getPage(int startIndex, int pageSize, String sortField, String searchString, UtilService s, boolean asc, Class<?> entity){
		System.out.println("inside get page");
		
		FullTextQuery ftq = null;
		System.out.println("inside get page");
		if(sortField == null){
			ftq = getQueryResult(searchString, s, entity);
			System.out.println("full text " + ftq.list());
		}else{
			ftq = getSortedQueryResult(sortField, searchString, s, asc, entity);
		}
		
		try{
			ftq.setFirstResult(startIndex);
			ftq.setMaxResults(pageSize);
			
		}catch(NullPointerException ne){}
		
		return ftq.list();
	}
	
	private FullTextQuery getSortedQueryResult(String sortField, String searchString, UtilService s, boolean asc, Class<?> entity){
		service = s;
		FullTextSession fts = s.getFullTextSession();
		
		
		FullTextQuery ftq = null;
		
		if(searchString.equals("")){
			QueryBuilder builder = null;
			Query q = null;
			try{
				builder = fts.getSearchFactory().buildQueryBuilder().forEntity(entity).get();
				q = builder.all().createQuery();
				ftq = fts.createFullTextQuery(q, entity);
				
			}catch(NullPointerException npe){
//				builder = fts.getSearchFactory().buildQueryBuilder();
//				q = builder.all().createQuery();
			}
		}else{
			try{
				ftq = fts.createFullTextQuery(getLuceneQuery(searchString), entity);
				
			}catch(NullPointerException npe){
				ftq = fts.createFullTextQuery(getLuceneQuery(searchString));
			}
		}
		
		Sort sort = new Sort(new SortField(sortField, SortField.STRING, asc));
		
		ftq.setSort(sort);
		//ftq.enableFullTextFilter(filteringField);
		return ftq;
	}
	
	private FullTextQuery getQueryResult(String searchString, UtilService s, Class<?> entity){
		service = s;
		FullTextSession fts = s.getFullTextSession();
		FullTextQuery ftq = null;
		
		if(searchString.equals("")){
			QueryBuilder builder = null;
			Query q = null;
			try{
				builder = fts.getSearchFactory().buildQueryBuilder().forEntity(entity).get();
				q = builder.all().createQuery();
				ftq = fts.createFullTextQuery(q, entity);
				
			}catch(NullPointerException npe){
//				builder = fts.getSearchFactory().buildQueryBuilder();
//				q = builder.all().createQuery();
			}
		}else{
			try{
				ftq = fts.createFullTextQuery(getLuceneQuery(searchString), entity);
			}catch(NullPointerException npe){
				ftq = fts.createFullTextQuery(getLuceneQuery(searchString));
			}
		}
		
		
		
		
		
		
		return ftq;
	}
	
	private Query getLuceneQuery(String searchString){
		String[] searchFields = SearchFields();
		
		BooleanQuery.setMaxClauseCount(20000);
		QueryParser parser = new MultiFieldQueryParser(Version.LUCENE_36,
														searchFields,
														new StandardAnalyzer(Version.LUCENE_36));
		
		org.apache.lucene.search.Query luceneQuery = null;
		
		try {
			luceneQuery = parser.parse(searchString);
		} catch (ParseException e) {
			System.out.println("parse exception " + e);
		} catch (Exception e2) {
			System.out.println("other exception " + e2);
		}
		
		return luceneQuery;
	}
}
