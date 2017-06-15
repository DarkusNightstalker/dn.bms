package cs.bms.dao.interfac;

import cs.bms.model.DocumentNumbering;
import cs.bms.model.User;
import gkfire.hibernate.generic.interfac.IGenericDao;
import java.util.List;

public abstract interface IDocumentNumberingDao
  extends IGenericDao<DocumentNumbering, Integer>
{
  public abstract List<Object[]> getDataByUser(User paramUser, String paramString);
}


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\dao\interfac\IDocumentNumberingDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */