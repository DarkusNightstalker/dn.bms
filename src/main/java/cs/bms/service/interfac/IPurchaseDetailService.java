package cs.bms.service.interfac;

import cs.bms.model.PurchaseDetail;
import gkfire.hibernate.generic.interfac.IGenericService;
import java.math.BigDecimal;

public abstract interface IPurchaseDetailService
  extends IGenericService<PurchaseDetail, Long>
{
  public abstract BigDecimal getQuantityById(Long paramLong);
  
  public abstract BigDecimal getUnitCostById(Long paramLong);
}


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\service\interfac\IPurchaseDetailService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */