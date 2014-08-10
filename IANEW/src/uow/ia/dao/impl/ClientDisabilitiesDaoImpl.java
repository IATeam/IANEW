/**
 * 
 */
package uow.ia.dao.impl;

import org.springframework.stereotype.Repository;

import uow.ia.bean.ClientDisabilities;
import uow.ia.dao.ClientDisabilitiesDao;

/**
 * @author ZhiYu Yang
 * @date 10/08/2014
 *
 */
@Repository(ClientDisabilitiesDao.DAONAME)
public class ClientDisabilitiesDaoImpl extends BaseDaoImpl<ClientDisabilities>
		implements ClientDisabilitiesDao<ClientDisabilities> {

}
