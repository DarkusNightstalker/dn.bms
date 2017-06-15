package cs.bms.service.interfac;

import cs.bms.model.Company;
import cs.bms.model.SalePayment;
import gkfire.hibernate.generic.interfac.IGenericService;
import java.math.BigDecimal;
import java.util.Date;

public abstract interface ISalePaymentService
  extends IGenericService<SalePayment, Long>
{
  public abstract BigDecimal getSumAfterByCompany(Date paramDate, Company paramCompany);
  
  public abstract BigDecimal getCreditAfterByCompany(Date paramDate, Company paramCompany);
}


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\service\interfac\ISalePaymentService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */