package cs.bms.dao.interfac;

import cs.bms.model.ElectronicBook;
import gkfire.hibernate.generic.interfac.IGenericDao;

public abstract interface IElectronicBookDao
  extends IGenericDao<ElectronicBook, Short>
{
  public abstract boolean existCode(String paramString, Short paramShort);
}


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\dao\interfac\IElectronicBookDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */