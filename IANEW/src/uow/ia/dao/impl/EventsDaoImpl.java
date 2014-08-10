package uow.ia.dao.impl;

import org.springframework.stereotype.Repository;

import uow.ia.bean.Events;
import uow.ia.dao.EventsDao;

/**
 * @author David Forbes
 * @date 10/08/2014
 *
 */
@Repository(EventsDao.DAONAME)
public class EventsDaoImpl extends BaseDaoImpl<Events> implements
EventsDao<Events> {

}
