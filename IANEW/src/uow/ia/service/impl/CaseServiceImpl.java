
/**
 * 
 */
package uow.ia.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import uow.ia.bean.ContactTypes;
import uow.ia.bean.Contacts;
import uow.ia.bean.DangerTypes;
import uow.ia.bean.Enquiries;
import uow.ia.bean.IndividualCases;
import uow.ia.bean.PlanDevelopers;
import uow.ia.bean.Plans;
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
		System.out.println("saev new contact");
		ic.setContact(c);
		c.getIndividualCasesList().add(ic);
		try {
			if (ic.getPlan().getAuthorisedBy() != null) {
				System.out.println("save authorised " + ic.getPlan().getAuthorisedBy().getId());
				contactsDao.saveOrUpdate(ic.getPlan().getAuthorisedBy());
			}
			
			if (ic.getPlan().getSupportPerson() != null) {
				System.out.println("save support " + ic.getPlan().getSupportPerson().getId());
				contactsDao.saveOrUpdate(ic.getPlan().getSupportPerson());
			}
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
			System.out.println("saveCase called");
			individualCasesDao.save(ic);
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
		System.out.println("does it does in here?");
		try {
//			IndividualCases icCases = individualCasesDao.get(IndividualCases.class, 1);
//			Plans plan = icCases.getPlan();
//			plan.setSupportPerson(null);
//			individualCasesDao.saveOrUpdate(icCases);
			individualCasesDao.saveOrUpdate(ic);
			System.out.println("short save called");
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	@Override
	public List<IndividualCases> getLinkedIndividualCases(int type, int id) {
		IndividualCases individualCases = individualCasesDao.get(IndividualCases.class, id);
		if(individualCases!=null) {
			List<IndividualCases> tmpCases = new ArrayList<IndividualCases>();
			if(individualCases.getOldCase()!=null) {
				tmpCases.add(individualCases.getOldCase());
				// if someone has a parent that means the parent always has at least one child
				//if(enquiries.getParentEnquiry().getEnquiriesList()!=null) {
				if(type!=0){
					Iterator<IndividualCases> iterator = individualCases.getOldCase().getIndividualCasesList().iterator();
					while (iterator.hasNext()) {
						tmpCases.add(iterator.next());
					}
				} else {
					Iterator<IndividualCases> iterator = individualCases.getOldCase().getIndividualCasesList().iterator();
					while (iterator.hasNext()) {
						tmpCases.add(iterator.next());
					}
					for (int i=0;i<tmpCases.size();i++) {
						if(tmpCases.get(i).getId()==id) {
							tmpCases.remove(i);
						}
					}
				}
				//}
			} else if(individualCases.getIndividualCasesList()!=null) { //selected enquire is parent and has some children
				if(type!=0){
					tmpCases.add(individualCases);
				}	
				Iterator<IndividualCases> iterator = individualCases.getIndividualCasesList().iterator();
				while (iterator.hasNext()) {
					tmpCases.add(iterator.next());
				}
			} else { // the selected enquire is the parent and no children
				if(type!=0){
					tmpCases.add(individualCases);
				}	
			}
			return tmpCases;
		}
		return null;
	}

}
