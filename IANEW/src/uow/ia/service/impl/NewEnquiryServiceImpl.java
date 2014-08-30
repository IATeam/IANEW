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
public class NewEnquiryServiceImpl implements NewEnquiryService {

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
	 * @see uow.ia.service.NewEnquiryService#findDangerTypes()
	 */	
	
	@Override
	public List<DangerTypes> findDangerTypes() {
		return dangerTypesDao.find(" from DangerTypes");
	}
	
	/*
	 * (non-Javadoc)
	 * @see uow.ia.service.NewEnquiryService#findStatusTypes()
	 */

	@Override
	public List<StatusTypes> findStatusTypes() {
		return statusTypesDao.find(" from StatusTypes");
	}
	
	/*
	 * (non-Javadoc)
	 * @see uow.ia.service.NewEnquiryService#findAccommodationTypes()
	 */

	@Override
	public List<AccommodationTypes> findAccommodationTypes() {
		// logger.info("NewEnquiryService.findAccommodationTypes called");
		return accommodationTypesDao.find(" from AccommodationTypes");
	}
	
	/*
	 * (non-Javadoc)
	 * @see uow.ia.service.NewEnquiryService#findTitleTypes()
	 */

	@Override
	public List<TitleTypes> findTitleTypes() {
		return titleTypesDao.find(" from TitleTypes");
	}
	
	/*
	 * (non-Javadoc)
	 * @see uow.ia.service.NewEnquiryService#findGenderTypes()
	 */

	@Override
	public List<GenderTypes> findGenderTypes() {
		return genderTypesDao.find(" from GenderTypes");
	}
	
	/*
	 * (non-Javadoc)
	 * @see uow.ia.service.NewEnquiryService#findCulturalBackgroundTypes()
	 */

	@Override
	public List<CulturalBackgroundTypes> findCulturalBackgroundTypes() {
		return culturalBackgroundTypesDao.find(" from CulturalBackgroundTypes");
	}
	
	/*
	 * (non-Javadoc)
	 * @see uow.ia.service.NewEnquiryService#findDisabilityTypes()
	 */

	@Override
	public List<DisabilityTypes> findDisabilityTypes() {
		return disabilityTypesDao.find(" from DisabilityTypes");
	}
	
	/*
	 * (non-Javadoc)
	 * @see uow.ia.service.NewEnquiryService#findIssueTypes()
	 */

	@Override
	public List<IssueTypes> findIssueTypes() {
		return issueTypesDao.find(" from IssueTypes");
	}
	
	/*
	 * (non-Javadoc)
	 * @see uow.ia.service.NewEnquiryService#findEnquiryTypes()
	 */

	@Override
	public List<EnquiryTypes> findEnquiryTypes() {
		return enquiryTypesDao.find(" from EnquiryTypes");
	}
	
	@Override
	public List<EmploymentTypes> findEmploymentTypes() {
		return employmentTypesDao.find(" from EmploymentTypes");
	}
	
	/*
	 * (non-Javadoc)
	 * @see uow.ia.service.NewEnquiryService#getDangerTypeId(java.lang.String)
	 */

	@Override
	public int getDangerTypeId(String name) {
		DangerTypes d = dangerTypesDao.get(
				" from DangerTypes t where t.dangerName =?",
				new Object[] { name });
		if (d != null) {
			return d.getId();
		} else {
			return -1;
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see uow.ia.service.NewEnquiryService#getStatusTypeId(java.lang.String)
	 */

	@Override
	public int getStatusTypeId(String name) {
		StatusTypes s = statusTypesDao.get(
				" from StatusTypes t where t.statusName =?",
				new Object[] { name });
		if (s != null) {
			return s.getId();
		} else {
			return -1;
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see uow.ia.service.NewEnquiryService#getTitleTypeId(java.lang.String)
	 */

	@Override
	public int getTitleTypeId(String name) {
		TitleTypes t = titleTypesDao.get(
				" from TitleTypes t where t.name =?",
				new Object[] { name });
		if (t != null) {
			return t.getId();
		} else {
			return -1;
		}
	}

	/*
	 * (non-Javadoc)
	 * @see uow.ia.service.NewEnquiryService#getGenderTypeId(java.lang.String)
	 */
	
	@Override
	public int getGenderTypeId(String name) {
		GenderTypes g = genderTypesDao.get(
				" from GenderTypes t where t.genderName =?",
				new Object[] { name });
		if (g != null) {
			return g.getId();
		} else {
			return -1;
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see uow.ia.service.NewEnquiryService#getCulturalBackgroundTypeId(java.lang.String)
	 */

	@Override
	public int getCulturalBackgroundTypeId(String name) {
		CulturalBackgroundTypes c = culturalBackgroundTypesDao
				.get(" from CulturalBackgroundTypes t where t.culturalBackgroundName =?",
						new Object[] { name });
		if (c != null) {
			return c.getId();
		} else {
			return -1;
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see uow.ia.service.NewEnquiryService#getAccommodationTypeId(java.lang.String)
	 */

	@Override
	public int getAccommodationTypeId(String name) {
		AccommodationTypes a = accommodationTypesDao.get(
				" from AccommodationTypes t where t.accommodationName =?",
				new Object[] { name });
		if (a != null) {
			return a.getId();
		} else {
			return -1;
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see uow.ia.service.NewEnquiryService#getDisabilityTypeId(java.lang.String)
	 */

	@Override
	public int getDisabilityTypeId(String name) {
		DisabilityTypes d = disabilityTypesDao.get(
				" from DisabilityTypes t where t.disabilityName =?",
				new Object[] { name });
		if (d != null) {
			return d.getId();
		} else {
			return -1;
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see uow.ia.service.NewEnquiryService#getIssueTypeId(java.lang.String)
	 */

	@Override
	public int getIssueTypeId(String name) {
		IssueTypes i = issueTypesDao.get(
				" from IssueTypes t where t.issueName =?",
				new Object[] { name });
		if (i != null) {
			return i.getId();
		} else {
			return -1;
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see uow.ia.service.NewEnquiryService#getEnquiryTypeId(java.lang.String)
	 */

	@Override
	public int getEnquiryTypeId(String name) {
		EnquiryTypes i = enquiryTypesDao.get(
				" from EnquiryTypes t where t.enquiryTypeName =?",
				new Object[] { name });
		if (i != null) {
			return i.getId();
		} else {
			return -1;
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see uow.ia.service.NewEnquiryService#getEmploymentTypeId(java.lang.String)
	 */
	
	@Override
	public int getEmploymentTypeId(String name) {
		EmploymentTypes i = employmentTypesDao.get(
				" from EmploymentTypes t where t.employmentName =?",
				new Object[] { name });
		if (i != null) {
			return i.getId();
		} else {
			return -1;
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see uow.ia.service.NewEnquiryService#findContactsByFullName(java.lang.String, java.lang.String)
	 */

	@Override
	public List<Contacts> findContactsByFullName(String firstName,
			String lastName) {
		return contactsDao.find(
				" from Contacts c where c.firstname = ? and c.lastname = ? ",
				new Object[] { firstName, lastName });
	}
	
	/*
	 * (non-Javadoc)
	 * @see uow.ia.service.NewEnquiryService#findEnquiries()
	 */

	@Override
	public List<Enquiries> findEnquiries() {
		return enquiriesDao.find(" from Enquiries");
	}
	
	/*
	 * (non-Javadoc)
	 * @see uow.ia.service.NewEnquiryService#findEnquiriesByPage(int, int)
	 */

	@Override
	public List<Enquiries> findEnquiriesByPage(int pageNo, int rows) {
		return enquiriesDao.find(" from Enquiries", pageNo, rows);
	}
	
	/*
	 * (non-Javadoc)
	 * @see uow.ia.service.NewEnquiryService#countEnquiries()
	 */

	@Override
	public Long countEnquiries() {
		return enquiriesDao.count("select count(*) from Enquiries");
	}
	
	/*
	 * (non-Javadoc)
	 * @see uow.ia.service.NewEnquiryService#getEnquiry(int)
	 */

	@Override
	public Enquiries getEnquiry(int id) {
		return enquiriesDao.get(Enquiries.class, id);
	}
	
	/*
	 * (non-Javadoc)
	 * @see uow.ia.service.NewEnquiryService#getLinkedEnquiry(int)
	 */

	@Override
	public List<Enquiries> getLinkedEnquiry(int id) {
		Enquiries enquiries = enquiriesDao.get(Enquiries.class, id);
		List<Enquiries> tmpEnquiries = null;
		tmpEnquiries.add(enquiries.getParentEnquiry());
		Iterator<Enquiries> iterator = enquiries.getEnquiriesSet().iterator();
		while (iterator.hasNext()) {
			tmpEnquiries.add(iterator.next());
		}
		return tmpEnquiries;
	}
	
	/*
	 * (non-Javadoc)
	 * @see uow.ia.service.NewEnquiryService#saveOrUpdateEnquiry(uow.ia.bean.Enquiries, uow.ia.bean.Contacts)
	 */

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
	
	/*
	 * (non-Javadoc)
	 * @see uow.ia.service.NewEnquiryService#saveEnquiry(uow.ia.bean.Enquiries)
	 */

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
	
	/*
	 * (non-Javadoc)
	 * @see uow.ia.service.NewEnquiryService#deleteEnquiry(uow.ia.bean.Enquiries)
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
	 * @see uow.ia.service.NewEnquiryService#updateEnquiry(uow.ia.bean.Enquiries)
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
	
	/*
	 * (non-Javadoc)
	 * @see uow.ia.service.NewEnquiryService#saveOrUpdateEnquiry(uow.ia.bean.Enquiries)
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
