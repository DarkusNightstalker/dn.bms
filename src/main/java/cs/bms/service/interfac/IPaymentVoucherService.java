package cs.bms.service.interfac;

import cs.bms.model.CashRegister;
import cs.bms.model.Company;
import cs.bms.model.PaymentVoucher;
import gkfire.hibernate.generic.interfac.IGenericService;
import java.util.Date;
import java.util.List;

public abstract interface IPaymentVoucherService
  extends IGenericService<PaymentVoucher, Long>
{
  public abstract List<Object[]> getBasicDataByCashRegister(CashRegister paramCashRegister);
  
  public abstract Long getNextNumerationByPrefix(String paramString);
  
  public abstract boolean verifyNumeration(String paramString);
  
  public abstract boolean existNumeration(String paramString);
  
  public abstract Integer getValueByCode(String paramString);
  
  public abstract void useVoucher(String paramString, Long paramLong);
  
  public abstract Integer getTotalSumAfterByCompany(Date paramDate, Company paramCompany);
}


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\service\interfac\IPaymentVoucherService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */