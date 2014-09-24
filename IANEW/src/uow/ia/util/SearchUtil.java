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
import org.apache.lucene.util.Version;
import org.hibernate.mapping.Collection;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.search.FullTextSession;

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
		
		try {
			fts.createIndexer().startAndWait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		fts.getTransaction().begin();
		
		List list = fts.createFullTextQuery(luceneQuery).list();
		
		fts.getTransaction().commit();
		
		return list;
	}
}
