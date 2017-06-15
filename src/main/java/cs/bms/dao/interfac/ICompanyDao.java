package cs.bms.dao.interfac;

import cs.bms.model.Company;
import gkfire.hibernate.generic.interfac.IGenericDao;
import java.util.List;

public abstract interface ICompanyDao
  extends IGenericDao<Company, Integer>
{
  public abstract List getDataByList(List<Long> paramList);
}


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\dao\interfac\ICompanyDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */