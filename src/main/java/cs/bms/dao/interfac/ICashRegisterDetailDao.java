package cs.bms.dao.interfac;

import cs.bms.enumerated.CashType;
import cs.bms.model.CashRegisterDetail;
import gkfire.hibernate.generic.interfac.IGenericDao;
import java.io.Serializable;

public abstract interface ICashRegisterDetailDao
  extends IGenericDao<CashRegisterDetail, Serializable>
{
  public abstract Integer getQuantity(Long paramLong, CashType paramCashType);
}


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\dao\interfac\ICashRegisterDetailDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */