package uow.ia.search;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.management.Query;

import bsh.This;

import com.sun.tools.ws.wsdl.framework.Entity;

import uow.ia.bean.Contacts;
import uow.ia.bean.Enquiries;
import uow.ia.bean.IndividualCases;
import uow.ia.service.UtilService;
import uow.ia.util.SearchUtil;

public class SearchHelper {
	Class<?> entity;
	String searchString;
	
	
	public SearchHelper(Class<?> entity, String searchString) {
		super();
		this.entity = entity;
		this.searchString = searchString;
	}
	
	@Resource
	protected static UtilService utilService;
	
	public List<Object> getRelevantObjectList(List<Object> obList){
		List<Object> returnList = new ArrayList<Object>();
		
		try{
			for(Object o: obList){
				if(entity.isInstance(o)){
					System.out.println("is instance of: " + entity.getSimpleName());
					returnList.add(o);
				}else{
					for (Field f : o.getClass().getDeclaredFields()) {
						if (entity.isInstance(f.getType()))
							returnList.add(f); break;
					}
				}
			}
		}catch(NullPointerException np){ //entity is null
			for(Object o: obList){
				if(isSearchableClass(o)){
					returnList.add(o);
				}else{
					for (Field f : o.getClass().getDeclaredFields()) {
						if (isSearchableClass(o))
							returnList.add(f); break;
					}
				}
			}
			
		}
		
		return returnList;
	}
	
	private boolean isSearchableClass(Object o)
	{
		System.out.println(o.getClass().getSimpleName());
		//remove characters starting from '_' and any characters after
		String objectClassName = o.getClass().getSimpleName().replaceAll("_.*", "");
		
		switch (objectClassName) {
		case "Enquiries":
		case "IndividualCases":
		case "Contacts":		return true;
		default:				return false;
		}
	}
}
