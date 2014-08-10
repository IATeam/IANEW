/**
 * 
 */
package uow.ia.dao.impl;

import org.springframework.stereotype.Repository;

import uow.ia.bean.Addresses;
import uow.ia.dao.AddressesDao;

/**
 * @author ZhiYu Yang
 * @date 10/08/2014
 *
 */
@Repository(AddressesDao.DAONAME)
public class AddressesDaoImpl extends BaseDaoImpl<Addresses> implements
		AddressesDao<Addresses> {

}
