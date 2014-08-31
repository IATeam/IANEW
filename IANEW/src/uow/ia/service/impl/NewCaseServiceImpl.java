
/**
 * 
 */
package uow.ia.service.impl;

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
import uow.ia.service.NewCaseService;

/**
 * @author bruce
 *
 */
@Service(NewCaseService.SERVICENAME)
public class NewCaseServiceImpl  implements
NewCaseService {
	
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
	private EmploymentTypesDao<EmploymentTypes> employmentTypesDao;
	
	@Resource
	private CommunicationTypesDao<CommunicationTypes> communicationTypesDao;
	
	@Resource
	private GoalTypesDao<GoalTypes> goalTypesDao;
	
	@Resource
	private PriorityTypesDao<PriorityTypes> priorityTypesDao;
	
	@Resource
	private ContactsDao<Contacts> contactsDao;
	
	@Resource
	private ContactTypesDao<ContactTypes> contactTypesDao;
	
	@Resource
	private IndividualCasesDao<IndividualCases> individualCasesDao;
	
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
	public List<EmploymentTypes> findEmploymentTypes() {
		return employmentTypesDao.find(" from EmploymentTypes");
	}

	@Override
	public List<CommunicationTypes> findCommunicationTypes() {
		return communicationTypesDao.find(" from CommunicationTypes");
	}

	@Override
	public List<GoalTypes> findGoalTypes() {
		return goalTypesDao.find(" from GoalTypes");
	}
	
	@Override
	public List<PriorityTypes> findPriorityTypes() {
		return priorityTypesDao.find(" from PriorityTypes");
	}
	
	@Override
	public List<IndividualCases> findCases() {
		return individualCasesDao.find(" from IndividualCases");
	}

	@Override
	public List<IndividualCases> findCasesByPage(int pageNo, int rows) {
		return individualCasesDao.find(" from IndividualCases", pageNo, rows);
	}

	@Override
	public Long countCases() {
		return individualCasesDao.count("select count(*) from IndividualCases"); 
	}
	
	@Override
	public IndividualCases getCase(int id) {
		return individualCasesDao.get(IndividualCases.class, id);
	}

	@Override
	public List<Contacts> findAdvocates() {
		ContactTypes c = contactTypesDao.get(
				" from ContactTypes t where t.contactTypeName =?",
				new Object[] { "Advocate" });
		return contactsDao.find(" from Contacts t where t.contactType =:contactType","contactType", c);
	}


}
