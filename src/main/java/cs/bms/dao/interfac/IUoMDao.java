package cs.bms.dao.interfac;

import cs.bms.model.UoM;
import gkfire.hibernate.generic.interfac.IGenericDao;

public abstract interface IUoMDao
  extends IGenericDao<UoM, Integer>
{
  public abstract boolean existName(String paramString, Integer paramInteger);
  
  public abstract boolean existAbbr(String paramString, Integer paramInteger);
  
  public abstract boolean existCode(String paramString, Integer paramInteger);
}


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\dao\interfac\IUoMDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */