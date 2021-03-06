/**
 * 
 */
package uow.ia.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
import uow.ia.dao.AccommodationTypesDao;
import uow.ia.dao.ContactsDao;
import uow.ia.dao.CulturalBackgroundTypesDao;
import uow.ia.dao.DangerTypesDao;
import uow.ia.dao.DisabilityTypesDao;
import uow.ia.dao.EmploymentTypesDao;
import uow.ia.dao.EnquiriesDao;
import uow.ia.dao.EnquiryTypesDao;
import uow.ia.dao.GenderTypesDao;
import uow.ia.dao.IssueTypesDao;
import uow.ia.dao.StatusTypesDao;
import uow.ia.dao.TitleTypesDao;
import uow.ia.service.EnquiryService;
import uow.ia.util.FilterSortHqlGen;

/**
 * @author bruce
 * 
 */
@Service(EnquiryService.SERVICENAME)
public class EnquiryServiceImpl implements EnquiryService {

	// static Logger logger = Logger.getLogger(ClassName.class);

	@Resource
	private TitleTypesDao<TitleTypes> titleTypesDao;

	@Resource
	private GenderTypesDao<GenderTypes> genderTypesDao;

	@Resource
	private CulturalBackgroundTypesDao<CulturalBackgroundTypes> culturalBackgroundTypesDao;

	@Resource
	private AccommodationTypesDao<AccommodationTypes> accommodationTypesDao;

	@Resource
	private DisabilityTypesDao<DisabilityTypes> disabilityTypesDao;

	@Resource
	private IssueTypesDao<IssueTypes> issueTypesDao;

	@Resource
	private EnquiryTypesDao<EnquiryTypes> enquiryTypesDao;

	@Resource
	private ContactsDao<Contacts> contactsDao;

	@Resource
	private EnquiriesDao<Enquiries> enquiriesDao;

	@Resource
	private DangerTypesDao<DangerTypes> dangerTypesDao;

	@Resource
	private StatusTypesDao<StatusTypes> statusTypesDao;
	
	@Resource
	private EmploymentTypesDao<EmploymentTypes> employmentTypesDao;
	
	/*
	 * (non-Javadoc)
	 * @see uow.ia.service.EnquiryService#findEnquiries()
	 */

	@Override
	public List<Enquiries> findEnquiries() {
		return enquiriesDao.find(" from Enquiries");
	}
	
	/*
	 * (non-Javadoc)
	 * @see uow.ia.service.EnquiryService#findEnquiriesByPage(int, int)
	 */

	@Override
	public List<Enquiries> findEnquiriesByPage(int pageNo, int rows) {
		return enquiriesDao.find(" from Enquiries", pageNo, rows);
	}
	

	@Override
	public List<Enquiries> findEnquiries(Map<String, Map<String, List<Map<String, List<Object>>>>> dataMap, int pageNo, int rows) {
		
		FilterSortHqlGen.HqlGen(dataMap);
		return enquiriesDao.find(FilterSortHqlGen.finalHql, FilterSortHqlGen.param, pageNo,rows);
	}
	
	/*
	 * (non-Javadoc)
	 * @see uow.ia.service.EnquiryService#countEnquiries()
	 */

	@Override
	public Long countEnquiries() {
		return enquiriesDao.count("select count(*) from Enquiries");
	}
	
	@Override
	public Long countEnquiries(
			Map<String, Map<String, List<Map<String, List<Object>>>>> dataMap) {
		String hql = "select count(*) ";
		FilterSortHqlGen.CleanHqlGen();
		FilterSortHqlGen.HqlGen(dataMap);
		hql += FilterSortHqlGen.finalHql;
		Long count = 0l;
		count += enquiriesDao.count(hql,FilterSortHqlGen.param);
		return count;
	}
	
	/*
	 * (non-Javadoc)
	 * @see uow.ia.service.EnquiryService#getEnquiry(int)
	 */

	@Override
	public Enquiries getEnquiry(int id) {
		return enquiriesDao.get(Enquiries.class, id);
	}
	
	/*
	 * (non-Javadoc)
	 * @see uow.ia.service.EnquiryService#getLinkedEnquiry(int)
	 */

	@Override
	public List<Enquiries> getLinkedEnquiry(int type, int id) {
		Enquiries enquiries = enquiriesDao.get(Enquiries.class, id);
		if(enquiries!=null) {
			List<Enquiries> tmpEnquiries = new ArrayList<Enquiries>();
			if(enquiries.getParentEnquiry()!=null) {
				tmpEnquiries.add(enquiries.getParentEnquiry());
				// if someone has a parent that means the parent always has at least one child
				//if(enquiries.getParentEnquiry().getEnquiriesList()!=null) {
				if(type!=0){
					Iterator<Enquiries> iterator = enquiries.getParentEnquiry().getEnquiriesList().iterator();
					while (iterator.hasNext()) {
						tmpEnquiries.add(iterator.next());
					}
				} else {
					Iterator<Enquiries> iterator = enquiries.getParentEnquiry().getEnquiriesList().iterator();
					while (iterator.hasNext()) {
						tmpEnquiries.add(iterator.next());
					}
					for (int i=0;i<tmpEnquiries.size();i++) {
						if(tmpEnquiries.get(i).getId()==id) {
							tmpEnquiries.remove(i);
						}
					}
				}
				//}
			} else if(enquiries.getEnquiriesList()!=null) { //selected enquire is parent and has some children
				if(type!=0){
					tmpEnquiries.add(enquiries);
				}
				Iterator<Enquiries> iterator = enquiries.getEnquiriesList().iterator();
				while (iterator.hasNext()) {
					tmpEnquiries.add(iterator.next());
				}
			} else { // the selected enquire is the parent and no children
				if(type!=0){
					tmpEnquiries.add(enquiries);
				}
			}
			return tmpEnquiries;
		}
		return null;
	}
	
	/*
	 * (non-Javadoc)
	 * @see uow.ia.service.EnquiryService#saveOrUpdateEnquiry(uow.ia.bean.Enquiries, uow.ia.bean.Contacts)
	 */

	@Override
	@Transactional
	public boolean saveOrUpdateEnquiry(Enquiries e, Contacts c) {
		e.setContact(c);
		c.getEnquiriesList().add(e);
		try {
			contactsDao.saveOrUpdate(c);
			return true;
		} catch (Exception e2) {
			System.out.println(e2);
			return false;
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see uow.ia.service.EnquiryService#saveEnquiry(uow.ia.bean.Enquiries)
	 */

	@Override
	public boolean saveEnquiry(Enquiries enquiry) {
		try {
			enquiriesDao.save(enquiry);
			System.out.println("saveEnquiry called");
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see uow.ia.service.EnquiryService#deleteEnquiry(uow.ia.bean.Enquiries)
	 */

	@Override
	public boolean deleteEnquiry(Enquiries enquiry) {
		try {
			enquiriesDao.delete(enquiry);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see uow.ia.service.EnquiryService#updateEnquiry(uow.ia.bean.Enquiries)
	 */

	@Override
	public boolean updateEnquiry(Enquiries enquiry) {
		try {
			enquiriesDao.update(enquiry);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	@Override
	public Enquiries mergeEnquiry(Enquiries enquiry) {
		try {
			enquiry = enquiriesDao.merge(enquiry);
			return enquiry;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see uow.ia.service.EnquiryService#saveOrUpdateEnquiry(uow.ia.bean.Enquiries)
	 */

	@Override
	public boolean saveOrUpdateEnquiry(Enquiries enquiry) {
		try {
			enquiriesDao.saveOrUpdate(enquiry);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

}
