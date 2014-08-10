package uow.ia.dao.impl;

import org.springframework.stereotype.Repository;

import uow.ia.bean.Reminders;
import uow.ia.dao.RemindersDao;

/**
 * @author David Forbes
 * @date 10/08/2014
 *
 */
@Repository(RemindersDao.DAONAME)
public class RemindersDaoImpl extends BaseDaoImpl<Reminders> implements
RemindersDao<Reminders> {

}
