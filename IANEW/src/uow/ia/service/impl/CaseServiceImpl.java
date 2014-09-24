
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

}
