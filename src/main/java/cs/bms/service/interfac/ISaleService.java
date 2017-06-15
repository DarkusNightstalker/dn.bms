package cs.bms.service.interfac;

import cs.bms.model.Company;
import cs.bms.model.Sale;
import gkfire.hibernate.generic.interfac.IGenericService;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public abstract interface ISaleService
  extends IGenericService<Sale, Long>
{
  public abstract List<Object[]> getNotVerifySales(Company paramCompany, List<Long> paramList);
  
  public abstract void verified(Long paramLong, boolean paramBoolean);
  
  public abstract BigDecimal getVisaAfterByCompany(Date paramDate, Company paramCompany);
  
  public abstract void updatePoints(Long paramLong1, Long paramLong2);
  
  public abstract void updateDiscount(BigDecimal paramBigDecimal, Long paramLong);
}


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\service\interfac\ISaleService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */