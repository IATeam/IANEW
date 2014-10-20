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
 *
 */
@Service(AdminService.SERVICENAME)
public class AdminServiceImpl implements AdminService {
	
	
	/** 
     * Accomodation Service methods
     *  @author davidforbes
     *  @date 09/09/2014
     * 
     */
	
	@Resource
	private AccommodationTypesDao<AccommodationTypes> AccommodationTypesDao;
	
	@Override
	public List<AccommodationTypes> findAccommodationTypes() {
		return AccommodationTypesDao.find(" from AccommodationTypes");
	}
	
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
     *  @author davidforbes
     *  @date 13/09/2014
     * 
     */
	
	@Resource
	private CulturalBackgroundTypesDao<CulturalBackgroundTypes> CulturalBackgroundTypesDao;
	
	@Override
	public List<CulturalBackgroundTypes> findCulturalBackgroundTypes() {
		return CulturalBackgroundTypesDao.find(" from CulturalBackgroundTypes");
	}
	
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
     *  @author davidforbes
     *  @date 14/09/2014
     * 
     */
	
	@Resource
	private DangerTypesDao<DangerTypes> DangerTypesDao;
	
	@Override
	public List<DangerTypes> findDangerTypes() {
		return DangerTypesDao.find(" from DangerTypes");
	}
	
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
     *  @author davidforbes
     *  @date 14/09/2014
     * 
     */
	
	@Resource
	private EmploymentTypesDao<EmploymentTypes> EmploymentTypesDao;
	
	@Override
	public List<EmploymentTypes> findEmploymentTypes() {
		return EmploymentTypesDao.find(" from EmploymentTypes");
	}
	
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
     *  @author davidforbes
     *  @date 14/09/2014
     * 
     */
	
	@Resource
	private EnquiryTypesDao<EnquiryTypes> EnquiryTypesDao;
	
	@Override
	public List<EnquiryTypes> findEnquiryTypes() {
		return EnquiryTypesDao.find(" from EnquiryTypes");
	}
	
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
     *  @author davidforbes
     *  @date 14/09/2014
     * 
     */
	
	@Resource
	private GenderTypesDao<GenderTypes> GenderTypesDao;
	
	@Override
	public List<GenderTypes> findGenderTypes() {
		return GenderTypesDao.find(" from GenderTypes");
	}
	
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
     *  @author davidforbes
     *  @date 14/09/2014
     * 
     */
	
	@Resource
	private StatusTypesDao<StatusTypes> StatusTypesDao;
	
	@Override
	public List<StatusTypes> findStatusTypes() {
		return StatusTypesDao.find(" from StatusTypes");
	}
	
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
     *  @author davidforbes
     *  @date 14/09/2014
     * 
     */
	
	@Resource
	private TitleTypesDao<TitleTypes> TitleTypesDao;
	
	@Override
	public List<TitleTypes> findTitleTypes() {
		return TitleTypesDao.find(" from TitleTypes");
	}
	
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
     * Disability Service methods
     *  @author Quang
     *  
     * 
     */
	
	@Resource
	private DisabilityTypesDao<DisabilityTypes> disabilityTypesDao;

	@Resource
	private UsersDao<Users> usersDao;

	@Override
	public List<DisabilityTypes> findDisabilityTypes() {
		return disabilityTypesDao.find(" from DisabilityTypes");
	}
	
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
     * IssueTypes Service methods
     *  @author davidforbes
     *  @date 09/09/2014
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
	
	@Override
	public Users getUsers(String username) {
		return usersDao.get(" from Users u where u.username=?", new Object[] {username});
	}

	@Resource
	private IssueTypesDao<IssueTypes> issueTypesDao;
	
	@Override
	public List<IssueTypes> findIssueTypes() {
		return issueTypesDao.find(" from IssueTypes");
	}
	
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
     *  @author davidforbes
     *  @date 16/09/2014
     */

	@Resource
	private ContactsDao<Contacts> ContactsDao;
	
	@Override
	public List<Contacts> findContacts() {
		return ContactsDao.find(" from Contacts");
	}
	
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
     * Accomodation Service methods
     *  @author davidforbes
     *  @date 09/09/2014
     * 
     */
	
	@Resource
	private CommunicationTypesDao<CommunicationTypes> CommunicationTypesDao;
	
	@Override
	public List<CommunicationTypes> findCommunicationTypes() {
		return CommunicationTypesDao.find(" from CommunicationTypes");
	}
	
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
     *  @author davidforbes
     *  @date 06/10/2014
     * 
     */
	
	@Resource
	private GoalTypesDao<GoalTypes> GoalTypesDao;
	
	@Override
	public List<GoalTypes> findGoalTypes() {
		return GoalTypesDao.find(" from GoalTypes");
	}
	
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
     *  @author davidforbes
     *  @date 06/10/2014
     * 
     */
	
	@Resource
	private PriorityTypesDao<PriorityTypes> PriorityTypesDao;
	
	@Override
	public List<PriorityTypes> findPriorityTypes() {
		return PriorityTypesDao.find(" from PriorityTypes");
	}
	
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
