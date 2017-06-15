package cs.bms.service.interfac;

import cs.bms.model.CashRegister;
import cs.bms.model.Company;
import gkfire.hibernate.generic.interfac.IGenericService;
import java.util.Date;

public abstract interface ICashRegisterService
  extends IGenericService<CashRegister, Long>
{
  public abstract Date getLastDate(Company paramCompany);
}


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\service\interfac\ICashRegisterService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */