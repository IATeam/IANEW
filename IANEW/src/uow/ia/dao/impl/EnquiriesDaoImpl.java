package uow.ia.dao.impl;

import org.springframework.stereotype.Repository;

import uow.ia.bean.Enquiries;
import uow.ia.dao.EnquiriesDao;

/**
 * @author David Forbes
 * @date 10/08/2014
 *
 */
@Repository(EnquiriesDao.DAONAME)
public class EnquiriesDaoImpl extends BaseDaoImpl<Enquiries> implements
EnquiriesDao<Enquiries> {

}
