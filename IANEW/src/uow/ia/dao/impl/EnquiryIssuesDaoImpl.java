package uow.ia.dao.impl;

import org.springframework.stereotype.Repository;

import uow.ia.bean.EnquiryIssues;
import uow.ia.dao.EnquiryIssuesDao;

/**
 * @author David Forbes
 * @date 10/08/2014
 *
 */
@Repository(EnquiryIssuesDao.DAONAME)
public class EnquiryIssuesDaoImpl extends BaseDaoImpl<EnquiryIssues> implements
EnquiryIssuesDao<EnquiryIssues> {

}
