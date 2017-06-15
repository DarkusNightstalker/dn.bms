package cs.bms.dao.interfac;

import cs.bms.model.User;
import gkfire.hibernate.generic.interfac.IGenericDao;

public abstract interface IUserDao
  extends IGenericDao<User, Integer>
{
  public abstract User login(String paramString1, String paramString2)
    throws Exception;
  
  public abstract Integer getNextId();
  
  public abstract boolean existUsername(String paramString, Integer paramInteger);
}


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\dao\interfac\IUserDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */