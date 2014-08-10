package uow.ia.dao.impl;

import org.springframework.stereotype.Repository;

import uow.ia.bean.Calendars;
import uow.ia.dao.CalendarsDao;

/**
 * @author david
 *
 */
@Repository(CalendarsDao.DAONAME)
public class CalendarsDaoImpl extends BaseDaoImpl<Calendars> 
implements CalendarsDao<Calendars> {

}
