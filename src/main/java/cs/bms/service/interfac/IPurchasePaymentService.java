package cs.bms.service.interfac;

import cs.bms.model.Company;
import cs.bms.model.PurchasePayment;
import gkfire.hibernate.generic.interfac.IGenericService;
import java.math.BigDecimal;
import java.util.Date;

public abstract interface IPurchasePaymentService
  extends IGenericService<PurchasePayment, Long>
{
  public abstract BigDecimal getSumAfterByCompany(Date paramDate, Company paramCompany);
}


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\service\interfac\IPurchasePaymentService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */