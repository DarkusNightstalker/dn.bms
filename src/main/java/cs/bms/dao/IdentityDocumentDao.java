package cs.bms.dao;

import cs.bms.dao.interfac.IIdentityDocumentDao;
import cs.bms.model.IdentityDocument;
import gkfire.hibernate.generic.GenericDao;
import org.springframework.stereotype.Repository;

@Repository
public class IdentityDocumentDao
  extends GenericDao<IdentityDocument, Short>
  implements IIdentityDocumentDao
{}


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\dao\IdentityDocumentDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */