package uow.ia.service;

import java.util.List;

import uow.ia.bean.AccommodationTypes;
import uow.ia.bean.Contacts;
import uow.ia.bean.CulturalBackgroundTypes;
import uow.ia.bean.DangerTypes;
import uow.ia.bean.DisabilityTypes;
import uow.ia.bean.Enquiries;
import uow.ia.bean.EnquiryTypes;
import uow.ia.bean.GenderTypes;
import uow.ia.bean.IssueTypes;
import uow.ia.bean.StatusTypes;
import uow.ia.bean.TitleTypes;

public interface NewEnquiryService {
	
	public static final String SERVICENAME = "NewEnquiryService";
	
	public List<DangerTypes> findDangerTypes();
	
	public List<StatusTypes> findStatusTypes();
	
	public List<TitleTypes> findTitleTypes();
	
	public List<GenderTypes> findGenderTypes();
	
	public List<CulturalBackgroundTypes> findCulturalBackgroundTypes();
	
	public List<AccommodationTypes> findAccommodationTypes();
	
	public List<DisabilityTypes> findDisabilityTypes();
	
	public List<IssueTypes> findIssueTypes();
	
	public List<EnquiryTypes> findEnquiryTypes();
	
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
	
	public boolean CreateNewEnquiry(Enquiries e, Contacts c);
	
	public boolean saveEnquiry(Enquiries e);
	
	public boolean deleteEnquiry(Enquiries e);
	
	public boolean updateEnquiry(Enquiries e);
	
	public boolean saveOrUpdateEnquiry(Enquiries e);
}
