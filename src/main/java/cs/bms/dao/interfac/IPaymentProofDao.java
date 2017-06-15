package cs.bms.dao.interfac;

import cs.bms.model.PaymentProof;
import gkfire.hibernate.generic.interfac.IGenericDao;

public abstract interface IPaymentProofDao
  extends IGenericDao<PaymentProof, Short>
{
  public abstract boolean existCode(String paramString, Short paramShort);
  
  public abstract Short getIdByAbbr(String paramString);
}


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\dao\interfac\IPaymentProofDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */