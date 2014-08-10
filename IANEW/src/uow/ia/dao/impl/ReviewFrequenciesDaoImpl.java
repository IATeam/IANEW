package uow.ia.dao.impl;

import org.springframework.stereotype.Repository;

import uow.ia.bean.ReviewFrequencies;
import uow.ia.dao.ReviewFrequenciesDao;

/**
 * @author David Forbes
 * @date 10/08/2014
 *
 */
@Repository(ReviewFrequenciesDao.DAONAME)
public class ReviewFrequenciesDaoImpl extends BaseDaoImpl<ReviewFrequencies> implements
ReviewFrequenciesDao<ReviewFrequencies>{

}
