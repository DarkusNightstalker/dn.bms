package cs.bms.service.interfac;

import cs.bms.model.Company;
import cs.bms.model.InternalStockMovement;
import cs.bms.model.InternalStockMovementDetail;
import gkfire.hibernate.generic.interfac.IGenericService;
import java.math.BigDecimal;
import java.util.List;

public abstract interface IInternalStockMovementDetailService
  extends IGenericService<InternalStockMovementDetail, Long>
{
  public abstract List<Object[]> getRemoveds(List<Long> paramList, Long paramLong);
  
  public abstract void restoreStock(InternalStockMovementDetail paramInternalStockMovementDetail, Company paramCompany1, Company paramCompany2);
  
  public abstract List<Object[]> getDataForManage(InternalStockMovement paramInternalStockMovement);
  
  public abstract BigDecimal getQuantityById(Long paramLong);
  
  public abstract BigDecimal getUnitCostById(Long paramLong);
}


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\service\interfac\IInternalStockMovementDetailService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */