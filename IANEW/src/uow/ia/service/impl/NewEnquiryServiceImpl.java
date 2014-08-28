/**
 * 
 */
package uow.ia.service.impl;

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
import uow.ia.service.NewEnquiryService;

/**
 * @author bruce
 *
 */
@Service(NewEnquiryService.SERVICENAME)
public class NewEnquiryServiceImpl implements
		NewEnquiryService {
	
	//static Logger logger = Logger.getLogger(ClassName.class);
	
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
	
	@Override
	public List<DangerTypes> findDangerTypes() {
		return dangerTypesDao.find(" from DangerTypes");
	}
	
	@Override
	public List<StatusTypes> findStatusTypes() {
		return statusTypesDao.find(" from StatusTypes");
	}
	
	@Override
	public List<AccommodationTypes> findAccommodationTypes() {
		//logger.info("NewEnquiryService.findAccommodationTypes called");
		return accommodationTypesDao.find(" from AccommodationTypes");
	}

	@Override
	public List<TitleTypes> findTitleTypes() {
		return titleTypesDao.find(" from TitleTypes");
	}

	@Override
	public List<GenderTypes> findGenderTypes() {
		return genderTypesDao.find(" from GenderTypes");
	}

	@Override
	public List<CulturalBackgroundTypes> findCulturalBackgroundTypes() {
		return culturalBackgroundTypesDao.find(" from CulturalBackgroundTypes");
	}

	@Override
	public List<DisabilityTypes> findDisabilityTypes() {
		return disabilityTypesDao.find(" from DisabilityTypes");
	}

	@Override
	public List<IssueTypes> findIssueTypes() {
		return issueTypesDao.find(" from IssueTypes");
	}
	
	@Override
	public List<EnquiryTypes> findEnquiryTypes() {
		return enquiryTypesDao.find(" from EnquiryTypes");
	}
	
	@Override
	public List<Contacts> findContactsByFullName(String firstName, String lastName) {
		return contactsDao.find(" from Contacts c where c.firstname = ? and c.lastname = ? ", new Object[] { firstName, lastName }); 
	}
	
	@Override
	public List<Enquiries> findEnquiries() {
		return enquiriesDao.find(" from Enquiries");
	}

	@Override
	public List<Enquiries> findEnquiriesByPage(int pageNo, int rows) {
		return enquiriesDao.find(" from Enquiries", pageNo, rows);
	}

	@Override
	public Long countEnquiries() {
		return enquiriesDao.count("select count(*) from Enquiries"); 
	}
	
	@Override
	public Enquiries getEnquiry(int id) {
		return enquiriesDao.get(Enquiries.class, id);
	}
	
	@Override
	public List<Enquiries> getLinkedEnquiry(int id) {
		Enquiries enquiries = enquiriesDao.get(Enquiries.class, id);
		List<Enquiries> tmpEnquiries = null;
		tmpEnquiries.add(enquiries.getParentEnquiry());
		Iterator<Enquiries> iterator = enquiries.getEnquiriesSet().iterator();
		while(iterator.hasNext()) {
			tmpEnquiries.add(iterator.next());
		}
		return tmpEnquiries;
	}
	
	@Override
	public boolean saveOrUpdateEnquiry(Enquiries e, Contacts c) {
		e.setContact(c);
  		c.getEnquiriesSet().add(e);
  		try {
  			contactsDao.saveOrUpdate(c);
  			return true;
		} catch (Exception e2) {
			System.out.println(e);
			return false;
		}
	}
	
	@Override
	public boolean saveEnquiry(Enquiries enquiry) {
		try {
			enquiriesDao.save(enquiry);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

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
