package uow.ia.dao.impl;

import org.springframework.stereotype.Repository;

import uow.ia.bean.DocumentLinks;
import uow.ia.dao.DocumentLinksDao;

/**
 * @author David Forbes
 * @date 10/08/2014
 *
 */
@Repository(DocumentLinksDao.DAONAME)
public class DocumentLinksDaoImpl extends BaseDaoImpl<DocumentLinks> implements
DocumentLinksDao<DocumentLinks> {

}
