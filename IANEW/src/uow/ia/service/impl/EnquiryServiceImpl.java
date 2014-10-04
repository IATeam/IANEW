/**
 * 
 */
package uow.ia.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javassist.bytecode.stackmap.TypeData.ClassName;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.apache.log4j.lf5.Log4JLogRecord;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sun.tools.xjc.reader.xmlschema.bindinfo.BIConversion.Static;

import uow.ia.bean.*;
import uow.ia.dao.*;
import uow.ia.service.EnquiryService;

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
	
	/*
	 * (non-Javadoc)
	 * @see uow.ia.service.EnquiryService#countEnquiries()
	 */

	@Override
	public Long countEnquiries() {
		return enquiriesDao.count("select count(*) from Enquiries");
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
