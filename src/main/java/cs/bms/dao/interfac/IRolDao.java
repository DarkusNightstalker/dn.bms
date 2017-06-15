package cs.bms.dao.interfac;

import cs.bms.model.Rol;
import gkfire.hibernate.generic.interfac.IGenericDao;

public abstract interface IRolDao
  extends IGenericDao<Rol, Integer>
{
  public abstract boolean existCode(String paramString, Integer paramInteger);
}


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\dao\interfac\IRolDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */