/**
 * 
 */
package uow.ia.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import uow.ia.bean.AccommodationTypes;
import uow.ia.bean.CommunicationTypes;
import uow.ia.bean.Contacts;
import uow.ia.bean.CulturalBackgroundTypes;
import uow.ia.bean.DangerTypes;
import uow.ia.bean.DisabilityTypes;
import uow.ia.bean.EmploymentTypes;
import uow.ia.bean.EnquiryTypes;
import uow.ia.bean.GenderTypes;
import uow.ia.bean.GoalTypes;
import uow.ia.bean.PriorityTypes;
import uow.ia.bean.IssueTypes;
import uow.ia.bean.StatusTypes;
import uow.ia.bean.TitleTypes;
import uow.ia.bean.Users;
import uow.ia.dao.AccommodationTypesDao;
import uow.ia.dao.ContactsDao;
import uow.ia.dao.CulturalBackgroundTypesDao;
import uow.ia.dao.CommunicationTypesDao;
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
import uow.ia.dao.UsersDao;
import uow.ia.service.AdminService;

/**
 * @author ZhiYu Yang
 * @date 23/08/2014
 * @author davidforbes
 *  @date 09/09/2014
 *
 */
@Service(AdminService.SERVICENAME)
public class AdminServiceImpl implements AdminService {
	
	
	/** 
     * Accomodation Service methods
     * 
     */
	
	@Resource
	private AccommodationTypesDao<AccommodationTypes> AccommodationTypesDao;
	
	/** 
     * retrieve with List<object> of Accommodation Types from Accommodation_Types table
     * @return List<Object>
     */
	@Override
	public List<AccommodationTypes> findAccommodationTypes() {
		return AccommodationTypesDao.find(" from AccommodationTypes");
	}
	
	/** 
     * save Accommodation Types object to Accommodation_Types table
     * 
     * @param AccommodationTypes a
     * @return boolean
     */
	@Override
	public boolean saveAccommodationType(AccommodationTypes a) {
		try {
			AccommodationTypesDao.save(a);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	/** 
     * update Accommodation Types object to Accommodation_Types table
     * @param AccommodationTypes a
     * @return boolean
     */
	@Override
	public boolean updateAccommodationType(AccommodationTypes a) {
		try {
			AccommodationTypesDao.update(a);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	/** 
     * Cultural Background Service methods
     * 
     */
	
	@Resource
	private CulturalBackgroundTypesDao<CulturalBackgroundTypes> CulturalBackgroundTypesDao;
	
	/** 
     * retrieve with List<object> of Cultural Background Types from CulturalBackground_Types table
     * @return List<Object>
     */
	@Override
	public List<CulturalBackgroundTypes> findCulturalBackgroundTypes() {
		return CulturalBackgroundTypesDao.find(" from CulturalBackgroundTypes");
	}
	
	/** 
     * save Cultural Background  Types object to CulturalBackground_Types table
     * 
     * @param CulturalBackgroundTypes cbt
     * @return boolean
     */
	@Override
	public boolean saveCulturalBackgroundType(CulturalBackgroundTypes cbt) {
		try {
			CulturalBackgroundTypesDao.save(cbt);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	/** 
     * update Cultural Background  Types object to CulturalBackground_Types table
     * @param CulturalBackgroundTypes cbt
     * @return boolean
     */
	@Override
	public boolean updateCulturalBackgroundType(CulturalBackgroundTypes cbt) {
		try {
			CulturalBackgroundTypesDao.update(cbt);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	/** 
     * DangerTypes Service methods
     * 
     */
	
	@Resource
	private DangerTypesDao<DangerTypes> DangerTypesDao;
	
	/** 
     * retrieve with List<object> of Danger Type from Danger_Types table
     * @return List<Object>
     */
	@Override
	public List<DangerTypes> findDangerTypes() {
		return DangerTypesDao.find(" from DangerTypes");
	}
	
	/** 
     * save Danger Types object to Danger_Types table
     * 
     * @param DangerTypes dt
     * @return boolean
     */
	@Override
	public boolean saveDangerType(DangerTypes dt) {
		try {
			DangerTypesDao.save(dt);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	/** 
     * update DangerTypes object to Danger_Types table
     * @param DangerTypes dt
     * @return boolean
     */
	@Override
	public boolean updateDangerType(DangerTypes dt) {
		try {
			DangerTypesDao.update(dt);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	/** 
     * EmploymentTypes Service methods
     * 
     */
	
	@Resource
	private EmploymentTypesDao<EmploymentTypes> EmploymentTypesDao;
	
	/** 
     * retrieve with List<object> of Employment Type from Employment_Types table
     * @return List<Object>
     */
	@Override
	public List<EmploymentTypes> findEmploymentTypes() {
		return EmploymentTypesDao.find(" from EmploymentTypes");
	}
	
	/** 
     * save Employment Types object to Employment_Types table
     * 
     * @param EmploymentType et
     * @return boolean
     */
	@Override
	public boolean saveEmploymentType(EmploymentTypes et) {
		try {
			EmploymentTypesDao.save(et);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	/** 
     * update EmploymentType object to Employment_Types table
     * @param EmploymentTypes et
     * @return boolean
     */
	@Override
	public boolean updateEmploymentType(EmploymentTypes et) {
		try {
			EmploymentTypesDao.update(et);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	/** 
     * EnquiryTypes Service methods
     * 
     */
	
	@Resource
	private EnquiryTypesDao<EnquiryTypes> EnquiryTypesDao;
	
	/** 
     * retrieve with List<object> of Enquiry Type from Enquiry_Type table
     * @return List<Object>
     */
	@Override
	public List<EnquiryTypes> findEnquiryTypes() {
		return EnquiryTypesDao.find(" from EnquiryTypes");
	}
	
	/** 
     * save Enquiry Types object to Enquiry_Types table
     * 
     * @param EnquiryType enqt
     * @return boolean
     */
	@Override
	public boolean saveEnquiryType(EnquiryTypes enqt) {
		try {
			EnquiryTypesDao.save(enqt);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	/** 
     * update EnquiryType object to Enquiry_Types table
     * @param EnquiryTypes enqt
     * @return boolean
     */
	@Override
	public boolean updateEnquiryType(EnquiryTypes enqt) {
		try {
			EnquiryTypesDao.update(enqt);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	/** 
     * GenderTypes Service methods
     * 
     */
	
	@Resource
	private GenderTypesDao<GenderTypes> GenderTypesDao;
	
	/** 
     * retrieve with List<object> of Gender Type from Gender_Type table
     * @return List<Object>
     */
	@Override
	public List<GenderTypes> findGenderTypes() {
		return GenderTypesDao.find(" from GenderTypes");
	}
	
	/** 
     * save Gender Types object to Gender_Types table
     * 
     * @param GenderType gt
     * @return boolean
     */
	@Override
	public boolean saveGenderType(GenderTypes gt) {
		try {
			GenderTypesDao.save(gt);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	/** 
     * update GenderType object to Gender_Types table
     * @param GenderTypes gt
     * @return boolean
     */
	@Override
	public boolean updateGenderType(GenderTypes gt) {
		try {
			GenderTypesDao.update(gt);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	/** 
     * StatusTypes Service methods
     * 
     */
	
	@Resource
	private StatusTypesDao<StatusTypes> StatusTypesDao;
	
	/** 
     * retrieve with List<object> of Status Type from Status_Type table
     * @return List<Object>
     */
	@Override
	public List<StatusTypes> findStatusTypes() {
		return StatusTypesDao.find(" from StatusTypes");
	}
	
	/** 
     * save Status Types object to Status_Types table
     * 
     * @param StatusType st
     * @return boolean
     */
	@Override
	public boolean saveStatusType(StatusTypes st) {
		try {
			StatusTypesDao.save(st);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	/** 
     * update StatusType object to Status_Types table
     * @return boolean
     */
	@Override
	public boolean updateStatusType(StatusTypes st) {
		try {
			StatusTypesDao.update(st);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	/** 
     * TitleTypes Service methods
     * 
     */
	
	@Resource
	private TitleTypesDao<TitleTypes> TitleTypesDao;
	
	/** 
     * retrieve with List<object> of Title Type from Title_Type table
     * @return List<Object>
     */
	@Override
	public List<TitleTypes> findTitleTypes() {
		return TitleTypesDao.find(" from TitleTypes");
	}
	
	/** 
     * save Title Types object to Title_Types table
     * 
     * @param TitleType tt
     * @return boolean
     */
	@Override
	public boolean saveTitleType(TitleTypes tt) {
		try {
			TitleTypesDao.save(tt);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	/** 
     * update TitleType object to Title_Types table
     * @param TitleTypes tt
     * @return boolean
     */
	@Override
	public boolean updateTitleType(TitleTypes tt) {
		try {
			TitleTypesDao.update(tt);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	/** 
     * Disability Service methods     *  
     * 
     */
	
	@Resource
	private DisabilityTypesDao<DisabilityTypes> disabilityTypesDao;

	@Resource
	private UsersDao<Users> usersDao;

	/** 
     * retrieve with List<object> of Disability Types from Disability_Types table
     *  
     * @return List<Object>
     */
	@Override
	public List<DisabilityTypes> findDisabilityTypes() {
		return disabilityTypesDao.find(" from DisabilityTypes");
	}
	
	/** 
     * save Disability Types object to Disability_Types table
     * 
     * @param DisabilityTypes d
     * @return boolean
     */
	@Override
	public boolean saveDisabilityType(DisabilityTypes d) {
		try {
			disabilityTypesDao.save(d);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	/** 
     * update Disability Types object to Disability_Types table
     * @param DisabilityTypes d
     * @return boolean
     */
	@Override
	public boolean updateDisabilityType(DisabilityTypes d) {
		try {
			disabilityTypesDao.update(d);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	
	/** 
     * Login
     * @param String username, String password
     * @return Users
     */
	@Override
	public Users login(String username, String password) {
		List<Users> users = usersDao.find(" from Users u where u.username=? and u.password=?", new Object[] {username, password});
		if(users.isEmpty()){
			return null;
		} else {
			return users.get(0);
		}
	}
	
	/** 
     * getUsers
     * @param String username
     * @return Users
     */
	@Override
	public Users getUsers(String username) {
		return usersDao.get(" from Users u where u.username=?", new Object[] {username});
	}
	
	/** 
     * IssueTypes Service methods
     */

	@Resource
	private IssueTypesDao<IssueTypes> issueTypesDao;
	
	/** 
     * retrieve with List<object> of Issue Types from Issue_Types table 
     * @return List<Object>
     */
	@Override
	public List<IssueTypes> findIssueTypes() {
		return issueTypesDao.find(" from IssueTypes");
	}
	
	/** 
     * save Issue Types object to Issue_Types table
     * 
     * @param IssueTypes i
     * @return boolean
     */
	@Override
	public boolean saveIssueType(IssueTypes i) {
		try {
			issueTypesDao.save(i);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	/** 
     * update Issue Types object to Issue_Types table
     * 
     * @param IssueTypes i
     * @return boolean
     */
	@Override
	public boolean updateIssueType(IssueTypes i) {
		try {
			issueTypesDao.update(i);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	/** 
     * Contacts Service methods
     */

	@Resource
	private ContactsDao<Contacts> ContactsDao;
	
	/** 
     * retrieve with List<Contacts> of Contacts from Contacts table
     *  
     * @return List<Contacts>
     */
	@Override
	public List<Contacts> findContacts() {
		return ContactsDao.find(" from Contacts");
	}
	
	/** 
     * save Contacts object to Contacts table
     * 
     * @param Contacts c
     * @return boolean
     */
	@Override
	public boolean saveContact(Contacts c) {
		try {
			ContactsDao.save(c);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	/** 
     * update Contacts object to Contacts table
     * 
     * @param Contact c
     * @return boolean
     */
	@Override
	public boolean updateContact(Contacts c) {
		try {
			ContactsDao.update(c);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	/** 
     * Communication Service methods
     * 
     */
	
	@Resource
	private CommunicationTypesDao<CommunicationTypes> CommunicationTypesDao;
	
	/** 
     * retrieve with List<object> of Communication Types from Communication_Types table
     * @return List<Object>
     */
	@Override
	public List<CommunicationTypes> findCommunicationTypes() {
		return CommunicationTypesDao.find(" from CommunicationTypes");
	}
	
	/** 
     * save Communication Types object to Communication_Types table
     * 
     * @param CommunicationTypes c
     * @return boolean
     */
	@Override
	public boolean saveCommunicationType(CommunicationTypes c) {
		try {
			CommunicationTypesDao.save(c);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	/** 
     * update Communication Types object to Communication_Types table
     * @param CommunicationTypes a
     * @return boolean
     */
	@Override
	public boolean updateCommunicationType(CommunicationTypes c) {
		try {
			CommunicationTypesDao.update(c);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	/** 
     * Goal Service methods
     * 
     */
	
	@Resource
	private GoalTypesDao<GoalTypes> GoalTypesDao;
	
	/** 
     * retrieve with List<object> of Goal Types from Goal_Types table
     * @return List<Object>
     */
	@Override
	public List<GoalTypes> findGoalTypes() {
		return GoalTypesDao.find(" from GoalTypes");
	}
	
	/** 
     * save Goal Types object to Goal_Types table
     * 
     * @param GoalTypes g
     * @return boolean
     */
	@Override
	public boolean saveGoalType(GoalTypes g) {
		try {
			GoalTypesDao.save(g);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	/** 
     * update Goal Types object to Goal_Types table
     * @param GoalTypes g
     * @return boolean
     */
	@Override
	public boolean updateGoalType(GoalTypes g) {
		try {
			GoalTypesDao.update(g);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	/** 
     * Priority Service methods
     * 
     */
	
	@Resource
	private PriorityTypesDao<PriorityTypes> PriorityTypesDao;
	
	/** 
     * retrieve with List<object> of Priority Types from Priority_Types table
     * @return List<Object>
     */
	@Override
	public List<PriorityTypes> findPriorityTypes() {
		return PriorityTypesDao.find(" from PriorityTypes");
	}
	
	/** 
     * save Priority Types object to Priority_Types table
     * 
     * @param PriorityTypes p
     * @return boolean
     */
	@Override
	public boolean savePriorityType(PriorityTypes p) {
		try {
			PriorityTypesDao.save(p);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	/** 
     * update Priority Types object to Priority_Types table
     * @param PriorityTypes p
     * @return boolean
     */
	@Override
	public boolean updatePriorityType(PriorityTypes p) {
		try {
			PriorityTypesDao.update(p);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
}
