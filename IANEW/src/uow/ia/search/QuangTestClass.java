package uow.ia.search;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;

import com.fasterxml.classmate.util.ResolvedTypeCache.Key;

import uow.ia.bean.Contacts;
import uow.ia.bean.Enquiries;
import uow.ia.bean.IndividualCases;
import uow.ia.service.UtilService;
import uow.ia.util.SearchUtil;




public class QuangTestClass {
	@Resource
	protected static UtilService utilService;
	
	
	public static void main(String[] args) {
		
		String searchString = "bill gaate";
		SearchHelper search = new SearchHelper(Contacts.class, searchString);
		
//		try {
//			search.getSearchResult();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
//		String finalQueryString = "";
//		TokenAnalyzer ta = new TokenAnalyzer(null, searchString);
//		try {
//			finalQueryString = ta.xpathing();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		System.out.println("remain query string: " + searchString);
//		System.out.println("final query string is: " + finalQueryString);
	}
	
	
	
	
}
