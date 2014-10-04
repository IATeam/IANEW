/**
 * 
 */
package uow.ia.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author ZhiYu Yang
 * @date 04/10/2014
 *
 */
public class FilterSortHqlGen {
	
	public static String finalHql="";
	public static List<Object> param = new ArrayList<Object>();
	
	public static void CleanHqlGen() {
		finalHql="";
		param.removeAll(param);
	}
	
	public static void HqlGen(Map<String, Map<String, List<Map<String, List<Object>>>>> dataMap) {
		finalHql = " from Enquiries e where 1=1 ";
		for (String string : dataMap.keySet()) {
			switch (string) {
			case "filter":
				Map<String, List<Map<String, List<Object>>>> tmpM2 = dataMap
						.get(string);
				for (String string2 : tmpM2.keySet()) {
					List<Map<String, List<Object>>> tmpL2 = tmpM2.get(string2);
					switch (string2) {
					case "eq":
						for (int i = 0; i < tmpL2.size(); i++) {
							Map<String, List<Object>> tmpM3 = tmpL2.get(i);
							for (String string3 : tmpM3.keySet()) {
								List<Object> tmpL3 = tmpM3.get(string3);
								if(tmpL3.size()>1) {
									finalHql = " from Enquiries e where";
									for (int j = 0; j < tmpL3.size(); j++) {
										if(j==0) {
											finalHql = finalHql + " e." + string3
													+ "=? ";//tmpL3.get(j)
											param.add(tmpL3.get(j));
										} else {
											finalHql = finalHql + " or e." + string3
													+ "=? ";//tmpL3.get(j)
											param.add(tmpL3.get(j));
										}
									}
								} else {
									finalHql = finalHql + "and e." + string3
											+ "=? ";//tmpL3.get(j)
									param.add(tmpL3.get(0));
								}
								
							}
						}
						break;
					case "ge":
						for (int i = 0; i < tmpL2.size(); i++) {
							Map<String, List<Object>> tmpM3 = tmpL2.get(i);
							for (String string3 : tmpM3.keySet()) {
								List<Object> tmpL3 = tmpM3.get(string3);
								for (int j = 0; j < tmpL3.size(); j++) {
									finalHql = finalHql + "and e." + string3
											+ ">=?"; //+ tmpL3.get(j)+" ";
									param.add(tmpL3.get(j));
								}
							}
						}
						break;
					case "le":
						for (int i = 0; i < tmpL2.size(); i++) {
							Map<String, List<Object>> tmpM3 = tmpL2.get(i);
							for (String string3 : tmpM3.keySet()) {
								List<Object> tmpL3 = tmpM3.get(string3);
								for (int j = 0; j < tmpL3.size(); j++) {
									finalHql = finalHql + "and e." + string3
											+ "<=?";// + tmpL3.get(j)+" ";
									param.add(tmpL3.get(j));
								}
							}
						}
						break;
					case "like":
						for (int i = 0; i < tmpL2.size(); i++) {
							Map<String, List<Object>> tmpM3 = tmpL2.get(i);
							for (String string3 : tmpM3.keySet()) {
								List<Object> tmpL3 = tmpM3.get(string3);
								for (int j = 0; j < tmpL3.size(); j++) {
									finalHql = finalHql + "and e." + string3
											+ " like " +"%?%";//+ tmpL3.get(j)+"%"+" ";
									param.add(tmpL3.get(j));
								}
							}
						}
						break;

					default:
						break;
					}
				}
				break;
			case "sort":
				finalHql = finalHql+ " order by ";
				Map<String, List<Map<String, List<Object>>>> tmpM22 = dataMap.get(string);
				for (String string2 : tmpM22.keySet()) {
					List<Map<String, List<Object>>> tmpL22 = tmpM22.get(string2);
					switch(string2){
					case "desc":
						for (int i = 0; i < tmpL22.size(); i++) {
							Map<String, List<Object>> tmpM33 = tmpL22.get(i);
							if(tmpL22.size()==1){
								for (String string3 : tmpM33.keySet()) {
									finalHql = finalHql+ " "+string3+" desc ";
								}
							} else {
								if(i==tmpL22.size()-1){
									for (String string3 : tmpM33.keySet()) {
										finalHql = finalHql+ " "+string3+" desc ";
									}
								} else {
									for (String string3 : tmpM33.keySet()) {
										finalHql = finalHql+ " "+string3+" desc, ";
									}
								}
							}
						}
						break;
					case "asc":
						for (int i = 0; i < tmpL22.size(); i++) {
							Map<String, List<Object>> tmpM33 = tmpL22.get(i);
							if(tmpL22.size()==1){
								for (String string3 : tmpM33.keySet()) {
									finalHql = finalHql+ " "+string3+" asc ";
								}
							} else {
								if(i==tmpL22.size()-1){
									for (String string3 : tmpM33.keySet()) {
										finalHql = finalHql+ " "+string3+" asc ";
									}
								} else {
									for (String string3 : tmpM33.keySet()) {
										finalHql = finalHql+ " "+string3+" asc, ";
									}
								}
							}
						}
						break;
					default:
						break;
					}
				}
				break;
			default:
				break;
			}
		}
		System.out.println("gen sql is: "+finalHql);
	}
}
