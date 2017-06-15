package cs.bms.service.interfac;

import cs.bms.model.OpeningBalance;
import cs.bms.model.User;
import gkfire.hibernate.generic.interfac.IGenericService;
import gkfire.util.Month;

public abstract interface IOpeningBalanceService
  extends IGenericService<OpeningBalance, Long>
{
  public abstract void generate(Integer paramInteger1, Month paramMonth, Integer paramInteger2, User paramUser);
}


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\service\interfac\IOpeningBalanceService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */