/**
 * 
 */
package uow.ia.dao.impl;

import org.springframework.stereotype.Repository;

import uow.ia.bean.CommunicationTypes;
import uow.ia.dao.CommunicationTypesDao;

/**
 * @author ZhiYu Yang
 * @date 10/08/2014
 *
 */
@Repository(CommunicationTypesDao.DAONAME)
public class CommunicationTypesDaoImpl extends BaseDaoImpl<CommunicationTypes>
		implements CommunicationTypesDao<CommunicationTypes> {

}
