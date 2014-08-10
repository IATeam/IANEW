/**
 * 
 */
package uow.ia.dao.impl;

import org.springframework.stereotype.Repository;

import uow.ia.bean.CaseIssues;
import uow.ia.dao.CaseIssuesDao;

/**
 * @author ZhiYu Yang
 * @date 10/08/2014
 *
 */
@Repository(CaseIssuesDao.DAONAME)
public class CaseIssuesDaoImpl extends BaseDaoImpl<CaseIssues> implements
		CaseIssuesDao<CaseIssues> {

}
