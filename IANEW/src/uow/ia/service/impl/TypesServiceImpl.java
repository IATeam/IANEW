/**
 * 
 */
package uow.ia.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import uow.ia.bean.AccommodationTypes;
import uow.ia.bean.CommunicationTypes;
import uow.ia.bean.CulturalBackgroundTypes;
import uow.ia.bean.DangerTypes;
import uow.ia.bean.DisabilityTypes;
import uow.ia.bean.EmploymentTypes;
import uow.ia.bean.EnquiryTypes;
import uow.ia.bean.GenderTypes;
import uow.ia.bean.GoalTypes;
import uow.ia.bean.IndividualCases;
import uow.ia.bean.IssueTypes;
import uow.ia.bean.PriorityTypes;
import uow.ia.bean.StatusTypes;
import uow.ia.bean.TitleTypes;
import uow.ia.dao.AccommodationTypesDao;
import uow.ia.dao.CommunicationTypesDao;
import uow.ia.dao.CulturalBackgroundTypesDao;
import uow.ia.dao.DangerTypesDao;
import uow.ia.dao.DisabilityTypesDao;
import uow.ia.dao.EmploymentTypesDao;
import uow.ia.dao.EnquiryTypesDao;
import uow.ia.dao.GenderTypesDao;
import uow.ia.dao.GoalTypesDao;
import uow.ia.dao.IssueTypesDao;
import uow.ia.dao.PriorityTypesDao;
import uow.ia.dao.StatusTypesDao;
import uow.ia.dao.TitleTypesDao;
import uow.ia.service.CaseService;
import uow.ia.service.TypesService;

/**
 * @author ZhiYu Yang
 * @date 17/09/2014
 *
 */
@Service(TypesService.SERVICENAME)
public class TypesServiceImpl implements TypesService {	
	
	@Resource
	private AccommodationTypesDao<AccommodationTypes> accommodationTypesDao;
	
	@Resource
	private CulturalBackgroundTypesDao<CulturalBackgroundTypes> culturalBackgroundTypesDao;
	
	@Resource
	private DangerTypesDao<DangerTypes> dangerTypesDao;

	@Resource
	private DisabilityTypesDao<DisabilityTypes> disabilityTypesDao;
	
	@Resource
	private EmploymentTypesDao<EmploymentTypes> employmentTypesDao;
	
	@Resource
	private EnquiryTypesDao<EnquiryTypes> enquiryTypesDao;
	
	@Resource
	private GenderTypesDao<GenderTypes> genderTypesDao;
	
	@Resource
	private IssueTypesDao<IssueTypes> issueTypesDao;
	
	@Resource
	private StatusTypesDao<StatusTypes> statusTypesDao;
	
	@Resource
	private TitleTypesDao<TitleTypes> titleTypesDao;

	@Resource
	private CommunicationTypesDao<CommunicationTypes> communicationTypesDao;
	
	@Resource
	private GoalTypesDao<GoalTypes> goalTypesDao;
	
	@Resource
	private PriorityTypesDao<PriorityTypes> priorityTypesDao;

	/* (non-Javadoc)
	 * @see uow.ia.service.TypesService#findAccommodationTypes()
	 */
	@Override
	public List<AccommodationTypes> findAccommodationTypes() {
		return accommodationTypesDao.find(" from AccommodationTypes");
	}

	/* (non-Javadoc)
	 * @see uow.ia.service.TypesService#findCulturalBackgroundTypes()
	 */
	@Override
	public List<CulturalBackgroundTypes> findCulturalBackgroundTypes() {
		return culturalBackgroundTypesDao.find(" from CulturalBackgroundTypes");
	}

	/* (non-Javadoc)
	 * @see uow.ia.service.TypesService#findDangerTypes()
	 */
	@Override
	public List<DangerTypes> findDangerTypes() {
		return dangerTypesDao.find(" from DangerTypes order by display_order");
	}

	/* (non-Javadoc)
	 * @see uow.ia.service.TypesService#findDisabilityTypes()
	 */
	@Override
	public List<DisabilityTypes> findDisabilityTypes() {
		return disabilityTypesDao.find(" from DisabilityTypes");
	}

	/* (non-Javadoc)
	 * @see uow.ia.service.TypesService#findEmploymentTypes()
	 */
	@Override
	public List<EmploymentTypes> findEmploymentTypes() {
		return employmentTypesDao.find(" from EmploymentTypes");
	}

	/* (non-Javadoc)
	 * @see uow.ia.service.TypesService#findEnquiryTypes()
	 */
	@Override
	public List<EnquiryTypes> findEnquiryTypes() {
		return enquiryTypesDao.find(" from EnquiryTypes");
	}

	/* (non-Javadoc)
	 * @see uow.ia.service.TypesService#findGenderTypes()
	 */
	@Override
	public List<GenderTypes> findGenderTypes() {
		return genderTypesDao.find(" from GenderTypes");
	}

	/* (non-Javadoc)
	 * @see uow.ia.service.TypesService#findIssueTypes()
	 */
	@Override
	public List<IssueTypes> findIssueTypes() {
		return issueTypesDao.find(" from IssueTypes");
	}

	/* (non-Javadoc)
	 * @see uow.ia.service.TypesService#findStatusTypes()
	 */
	@Override
	public List<StatusTypes> findStatusTypes() {
		return statusTypesDao.find(" from StatusTypes order by display_order");
	}

	/* (non-Javadoc)
	 * @see uow.ia.service.TypesService#findTitleTypes()
	 */
	@Override
	public List<TitleTypes> findTitleTypes() {
		return titleTypesDao.find(" from TitleTypes");
	}

	/* (non-Javadoc)
	 * @see uow.ia.service.TypesService#findCommunicationTypes()
	 */
	@Override
	public List<CommunicationTypes> findCommunicationTypes() {
		return communicationTypesDao.find(" from CommunicationTypes");
	}

	/* (non-Javadoc)
	 * @see uow.ia.service.TypesService#findGoalTypes()
	 */
	@Override
	public List<GoalTypes> findGoalTypes() {
		return goalTypesDao.find(" from GoalTypes");
	}

	/* (non-Javadoc)
	 * @see uow.ia.service.TypesService#findCases()
	 */
	@Override
	public List<PriorityTypes> findPriorityTypes() {
		return priorityTypesDao.find(" from PriorityTypes order by display_order");
	}
	
	/*
	 * (non-Javadoc)
	 * @see uow.ia.service.TypesService#getDangerTypeId(java.lang.String)
	 */

	@Override
	public int getDangerTypeId(String name) {
		DangerTypes o = dangerTypesDao.get(
				" from DangerTypes t where t.dangerName =?",
				new Object[] { name });
		if (o != null) {
			return o.getId();
		} else {
			return -1;
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see uow.ia.service.TypesService#getStatusTypeId(java.lang.String)
	 */

	@Override
	public int getStatusTypeId(String name) {
		StatusTypes o = statusTypesDao.get(
				" from StatusTypes t where t.statusName =?",
				new Object[] { name });
		if (o != null) {
			return o.getId();
		} else {
			return -1;
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see uow.ia.service.TypesService#getTitleTypeId(java.lang.String)
	 */

	@Override
	public int getTitleTypeId(String name) {
		TitleTypes o = titleTypesDao.get(
				" from TitleTypes t where t.name =?",
				new Object[] { name });
		if (o != null) {
			return o.getId();
		} else {
			return -1;
		}
	}

	/*
	 * (non-Javadoc)
	 * @see uow.ia.service.TypesService#getGenderTypeId(java.lang.String)
	 */
	
	@Override
	public int getGenderTypeId(String name) {
		GenderTypes o = genderTypesDao.get(
				" from GenderTypes t where t.genderName =?",
				new Object[] { name });
		if (o != null) {
			return o.getId();
		} else {
			return -1;
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see uow.ia.service.TypesService#getCulturalBackgroundTypeId(java.lang.String)
	 */

	@Override
	public int getCulturalBackgroundTypeId(String name) {
		CulturalBackgroundTypes o = culturalBackgroundTypesDao
				.get(" from CulturalBackgroundTypes t where t.culturalBackgroundName =?",
						new Object[] { name });
		if (o != null) {
			return o.getId();
		} else {
			return -1;
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see uow.ia.service.TypesService#getAccommodationTypeId(java.lang.String)
	 */

	@Override
	public int getAccommodationTypeId(String name) {
		AccommodationTypes o = accommodationTypesDao.get(
				" from AccommodationTypes t where t.accommodationName =?",
				new Object[] { name });
		if (o != null) {
			return o.getId();
		} else {
			return -1;
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see uow.ia.service.TypesService#getDisabilityTypeId(java.lang.String)
	 */

	@Override
	public int getDisabilityTypeId(String name) {
		DisabilityTypes o = disabilityTypesDao.get(
				" from DisabilityTypes t where t.disabilityName =?",
				new Object[] { name });
		if (o != null) {
			return o.getId();
		} else {
			return -1;
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see uow.ia.service.TypesService#getIssueTypeId(java.lang.String)
	 */

	@Override
	public int getIssueTypeId(String name) {
		IssueTypes o = issueTypesDao.get(
				" from IssueTypes t where t.issueName =?",
				new Object[] { name });
		if (o != null) {
			return o.getId();
		} else {
			return -1;
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see uow.ia.service.TypesService#getEnquiryTypeId(java.lang.String)
	 */

	@Override
	public int getEnquiryTypeId(String name) {
		EnquiryTypes o = enquiryTypesDao.get(
				" from EnquiryTypes t where t.enquiryTypeName =?",
				new Object[] { name });
		if (o != null) {
			return o.getId();
		} else {
			return -1;
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see uow.ia.service.TypesService#getEmploymentTypeId(java.lang.String)
	 */
	
	@Override
	public int getEmploymentTypeId(String name) {
		EmploymentTypes o = employmentTypesDao.get(
				" from EmploymentTypes t where t.employmentName =?",
				new Object[] { name });
		if (o != null) {
			return o.getId();
		} else {
			return -1;
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see uow.ia.service.TypesService#getDangerType(java.lang.String)
	 */
	
	@Override
	public DangerTypes getDangerTypeByName(String name) {
		DangerTypes o = dangerTypesDao.get(
				" from DangerTypes t where t.dangerName =?",
				new Object[] { name });
		if (o != null) {
			return o;
		} else {
			return null;
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see uow.ia.service.TypesService#getStatusType(java.lang.String)
	 */
	
	@Override
	public StatusTypes getStatusTypeByName(String name) {
		StatusTypes o = statusTypesDao.get(
				" from StatusTypes t where t.statusName =?",
				new Object[] { name });
		if (o != null) {
			return o;
		} else {
			return null;
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see uow.ia.service.TypesService#getTitleType(java.lang.String)
	 */

	@Override
	public TitleTypes getTitleTypeByName(String name) {
		TitleTypes o = titleTypesDao.get(
				" from TitleTypes t where t.name =?",
				new Object[] { name });
		if (o != null) {
			return o;
		} else {
			return null;
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see uow.ia.service.TypesService#getGenderType(java.lang.String)
	 */

	@Override
	public GenderTypes getGenderTypeByName(String name) {
		GenderTypes o = genderTypesDao.get(
				" from GenderTypes t where t.genderName =?",
				new Object[] { name });
		if (o != null) {
			return o;
		} else {
			return null;
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see uow.ia.service.TypesService#getCulturalBackgroundType(java.lang.String)
	 */

	@Override
	public CulturalBackgroundTypes getCulturalBackgroundTypeByName(String name) {
		CulturalBackgroundTypes o = culturalBackgroundTypesDao
				.get(" from CulturalBackgroundTypes t where t.culturalBackgroundName =?",
						new Object[] { name });
		if (o != null) {
			return o;
		} else {
			return null;
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see uow.ia.service.TypesService#getAccommodationType(java.lang.String)
	 */

	@Override
	public AccommodationTypes getAccommodationTypeByName(String name) {
		AccommodationTypes o = accommodationTypesDao.get(
				" from AccommodationTypes t where t.accommodationName =?",
				new Object[] { name });
		if (o != null) {
			return o;
		} else {
			return null;
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see uow.ia.service.TypesService#getDisabilityType(java.lang.String)
	 */

	@Override
	public DisabilityTypes getDisabilityTypeByName(String name) {
		DisabilityTypes o = disabilityTypesDao.get(
				" from DisabilityTypes t where t.disabilityName =?",
				new Object[] { name });
		if (o != null) {
			return o;
		} else {
			return null;
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see uow.ia.service.TypesService#getIssueType(java.lang.String)
	 */
	
	@Override
	public IssueTypes getIssueTypeByName(String name) {
		IssueTypes o = issueTypesDao.get(
				" from IssueTypes t where t.issueName =?",
				new Object[] { name });
		if (o != null) {
			return o;
		} else {
			return null;
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see uow.ia.service.TypesService#getEnquiryType(java.lang.String)
	 */

	@Override
	public EnquiryTypes getEnquiryTypeByName(String name) {
		EnquiryTypes o = enquiryTypesDao.get(
				" from EnquiryTypes t where t.enquiryTypeName =?",
				new Object[] { name });
		if (o != null) {
			return o;
		} else {
			return null;
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see uow.ia.service.TypesService#getEmploymentType(java.lang.String)
	 */

	@Override
	public EmploymentTypes getEmploymentTypeByName(String name) {
		EmploymentTypes o = employmentTypesDao.get(
				" from EmploymentTypes t where t.employmentName =?",
				new Object[] { name });
		if (o != null) {
			return o;
		} else {
			return null;
		}
	}
}
