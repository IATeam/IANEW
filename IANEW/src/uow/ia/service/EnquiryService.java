package uow.ia.service;

import java.util.List;
import java.util.Map;

import uow.ia.bean.Contacts;
import uow.ia.bean.Enquiries;

public interface EnquiryService {
	
	public static final String SERVICENAME = "EnquiryService";
	
	public List<Enquiries> findEnquiries();
	
	/** 
     * retrieve with List<object> 
     *  
     * @param pageNo 
     * @param rows
     * @return List<Object>
     */
	public List<Enquiries> findEnquiriesByPage(int pageNo, int rows);
	
	public List<Enquiries> findEnquiries(Map<String, Map<String, List<Map<String, List<Object>>>>> parametersMap, int pageNo, int rows);

	public Long countEnquiries();
	
	public Long countEnquiries(Map<String, Map<String, List<Map<String, List<Object>>>>> parametersMap);

	public Enquiries getEnquiry(int id);
	
	public List<Enquiries> getLinkedEnquiry(int type, int id);
	
	public boolean saveOrUpdateEnquiry(Enquiries e, Contacts c);
	
	public boolean saveEnquiry(Enquiries e);
	
	public boolean deleteEnquiry(Enquiries e);
	
	public boolean updateEnquiry(Enquiries e);
	
	public Enquiries mergeEnquiry(Enquiries e);
	
	public boolean saveOrUpdateEnquiry(Enquiries e);
	
}
