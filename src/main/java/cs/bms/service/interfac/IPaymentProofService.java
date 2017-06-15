package cs.bms.service.interfac;

import cs.bms.model.PaymentProof;
import gkfire.hibernate.generic.interfac.IGenericService;
import java.util.Date;
import java.util.List;

public abstract interface IPaymentProofService
  extends IGenericService<PaymentProof, Short>
{
  public abstract boolean existCode(String paramString, Short paramShort);
  
  public abstract Short getIdByAbbr(String paramString);
  
  public abstract List<Object[]> getCreateByAfterDate(Date paramDate);
  
  public abstract List<Object[]> getEditedByAfterDate(Date paramDate, boolean paramBoolean);
  
  public abstract Short getIdByCode(String paramString);
}


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\service\interfac\IPaymentProofService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */