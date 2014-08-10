package uow.ia.dao.impl;

import org.springframework.stereotype.Repository;

import uow.ia.bean.EnquiryTypes;
import uow.ia.dao.EnquiryTypesDao;

/**
 * @author David Forbes
 * @date 10/08/2014
 *
 */
@Repository(EnquiryTypesDao.DAONAME)
public class EnquiryTypesDaoImpl extends BaseDaoImpl<EnquiryTypes> implements
EnquiryTypesDao<EnquiryTypes> {

}
