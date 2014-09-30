
/**
 * 
 */
package uow.ia.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import uow.ia.bean.ContactTypes;
import uow.ia.bean.Contacts;
import uow.ia.bean.DangerTypes;
import uow.ia.bean.IndividualCases;
import uow.ia.bean.ReviewFrequencies;
import uow.ia.bean.StatusTypes;
import uow.ia.dao.ContactTypesDao;
import uow.ia.dao.ContactsDao;
import uow.ia.dao.DangerTypesDao;
import uow.ia.dao.IndividualCasesDao;
import uow.ia.dao.ReviewFrequenciesDao;
import uow.ia.dao.StatusTypesDao;
import uow.ia.service.CaseService;

/**
 * @author bruce
 *
 */
@Service(CaseService.SERVICENAME)
public class CaseServiceImpl  implements
CaseService {

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
	
	@Resource
	private ReviewFrequenciesDao<ReviewFrequencies> reviewFrequenciesDao;
	
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
		return contactsDao.find(" from Contacts t where t.contactType =:contactType order by t.lastname asc, t.firstname asc","contactType", c);
	}
	
	@Override
	public List<ReviewFrequencies> findReviewFrequencies() {
		return reviewFrequenciesDao.find("from ReviewFrequencies");
	}

	@Override
	public boolean saveOrUpdateCase(IndividualCases ic, Contacts c) {
		ic.setContact(c);
		c.getIndividualCasesList().add(ic);
		try {
			contactsDao.saveOrUpdate(c);
			return true;
		} catch (Exception e2) {
			System.out.println(e2);
			return false;
		}
	}

	@Override
	public boolean saveCase(IndividualCases ic) {
		try {
			individualCasesDao.save(ic);
			System.out.println("saveCase called");
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	@Override
	public boolean deleteCase(IndividualCases ic) {
		try {
			individualCasesDao.delete(ic);
			System.out.println("deleteCase called");
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	@Override
	public boolean updateCase(IndividualCases ic) {
		try {
			individualCasesDao.update(ic);
			System.out.println("updateCase called");
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	@Override
	public IndividualCases mergeCase(IndividualCases ic) {
		try {
			ic = individualCasesDao.merge(ic);
			return ic;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public boolean saveOrUpdateCase(IndividualCases ic) {
		try {
			individualCasesDao.saveOrUpdate(ic);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

}
