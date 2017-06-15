package cs.bms.dao.interfac;

import cs.bms.model.Company;
import cs.bms.model.Sale;
import gkfire.hibernate.generic.interfac.IGenericDao;
import java.util.List;

public abstract interface ISaleDao
  extends IGenericDao<Sale, Long>
{
  public abstract List<Object[]> getNotVerifySales(Company paramCompany, List<Long> paramList);
}


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\dao\interfac\ISaleDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */