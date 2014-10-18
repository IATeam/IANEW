package uow.ia.action;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import uow.ia.bean.Contacts;
import uow.ia.bean.Enquiries;
import uow.ia.bean.IndividualCases;
import uow.ia.util.SearchUtil;

public class SearchAction extends BaseAction {
	
	
	private List list = new ArrayList();
	private String searchString = null;
	private List resultList = new ArrayList();
	
	
	/**
	 * @return the list
	 */
	public List getList() {
		return list;
	}

	/**
	 * @param list the list to set
	 */
	public void setList(List list) {
		this.list = list;
	}

	public String search() {		
		list = new SearchUtil().getResultObjectList("Mrs harley Kim", utilService);
		
		return SUCCESS;
	}
	
	public String searchContact(){
		if (!(searchString == null || searchString.equals(""))) {
			searchString = searchString.trim();
			if(searchString.contains(" "))
				System.out.println("contains space");
			
			
//			list = new SearchUtil().getResultObjectList(searchString, utilService);
//			System.out.println("Got list" + list.toString());
//			for (Object o : list) {
//				int type = 0;
//				Field[] fields = o.getClass().getDeclaredFields();
//				
//				System.out.println("class name is: " + o.getClass().getSimpleName());
//				
//				if (o instanceof Enquiries) {
//					resultList.add(o);
//				} else if (o instanceof IndividualCases) {
//					resultList.add(o);
//				} else if(o instanceof Contacts){
//					System.out.print("is a contact object");
//				}
//				else {
//					Object object = null;
//					for (Field f : fields) {
//						if (f.getType().isInstance(new IndividualCases())) {
//							resultList.add(f);
//							break;
//						} else if (f.getType().isInstance(new Enquiries())) {
//							resultList.add(f);
//							break;
//						}
//					}
//				}
//			}
		}
		
		return SUCCESS;
	}
}
