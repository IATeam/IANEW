package uow.ia.dao.impl;

import org.springframework.stereotype.Repository;

import uow.ia.bean.IacaseEnquiryMappings;
import uow.ia.dao.IacaseEnquiryMappingsDao;

/**
 * @author David Forbes
 * @date 10/08/2014
 *
 */
@Repository(IacaseEnquiryMappingsDao.DAONAME)
public class IacaseEnquiryMappingsDaoImpl extends BaseDaoImpl<IacaseEnquiryMappings> implements
IacaseEnquiryMappingsDao<IacaseEnquiryMappings>{

}
