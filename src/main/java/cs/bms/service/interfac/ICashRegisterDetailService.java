package cs.bms.service.interfac;

import cs.bms.enumerated.CashType;
import cs.bms.model.CashRegisterDetail;
import gkfire.hibernate.generic.interfac.IGenericService;
import java.io.Serializable;
import java.util.Map;

public abstract interface ICashRegisterDetailService
  extends IGenericService<CashRegisterDetail, Serializable>
{
  public abstract Integer getQuantity(Long paramLong, CashType paramCashType);
  
  public abstract Map<CashType, Integer> getQuantitiesAsMap(Long paramLong);
}


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\service\interfac\ICashRegisterDetailService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */