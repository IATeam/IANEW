package uow.ia.dao.impl;

import org.springframework.stereotype.Repository;

import uow.ia.bean.Messages;
import uow.ia.dao.MessagesDao;

/**
 * @author David Forbes
 * @date 10/08/2014
 *
 */
@Repository(MessagesDao.DAONAME)
public class MessagesDaoImpl extends BaseDaoImpl<Messages> implements
MessagesDao<Messages> {

}
