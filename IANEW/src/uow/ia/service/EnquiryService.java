package uow.ia.service;

import java.util.List;

import uow.ia.bean.AccommodationTypes;
import uow.ia.bean.Contacts;
import uow.ia.bean.CulturalBackgroundTypes;
import uow.ia.bean.DangerTypes;
import uow.ia.bean.DisabilityTypes;
import uow.ia.bean.EmploymentTypes;
import uow.ia.bean.Enquiries;
import uow.ia.bean.EnquiryTypes;
import uow.ia.bean.GenderTypes;
import uow.ia.bean.IssueTypes;
import uow.ia.bean.StatusTypes;
import uow.ia.bean.TitleTypes;

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

	public Long countEnquiries();

	public Enquiries getEnquiry(int id);
	
	public List<Enquiries> getLinkedEnquiry(int id);
	
	public boolean saveOrUpdateEnquiry(Enquiries e, Contacts c);
	
	public boolean saveEnquiry(Enquiries e);
	
	public boolean deleteEnquiry(Enquiries e);
	
	public boolean updateEnquiry(Enquiries e);
	
	public Enquiries mergeEnquiry(Enquiries e);
	
	public boolean saveOrUpdateEnquiry(Enquiries e);
	
}
