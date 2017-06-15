package cs.bms.dao.interfac;

import cs.bms.model.AccountingEntry;
import gkfire.hibernate.generic.interfac.IGenericDao;
import gkfire.util.ErrorMessage;

public abstract interface IAccountingEntryDao
  extends IGenericDao<AccountingEntry, Long>
{
  public abstract ErrorMessage verifyCode(String paramString, Long paramLong);
  
  public abstract AccountingEntry getParent(String paramString);
  
  public abstract AccountingEntry getByPath(String paramString);
}


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\dao\interfac\IAccountingEntryDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */