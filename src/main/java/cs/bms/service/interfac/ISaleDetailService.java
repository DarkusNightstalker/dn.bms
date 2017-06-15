package cs.bms.service.interfac;

import cs.bms.model.Sale;
import cs.bms.model.SaleDetail;
import gkfire.hibernate.generic.interfac.IGenericService;
import java.math.BigDecimal;
import java.util.List;

public abstract interface ISaleDetailService
  extends IGenericService<SaleDetail, Long>
{
  public abstract List<Object[]> getBasicDataBySale(Sale paramSale);
  
  public abstract BigDecimal getQuantityById(Long paramLong);
  
  public abstract List<Object[]> getProductDataBySale(Sale paramSale);
}


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\service\interfac\ISaleDetailService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */