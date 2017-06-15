package cs.bms.dao.interfac;

import cs.bms.model.ProductLine;
import gkfire.hibernate.generic.interfac.IGenericDao;

public abstract interface IProductLineDao
  extends IGenericDao<ProductLine, Integer>
{
  public abstract boolean existPath(String paramString, Integer paramInteger);
}


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\dao\interfac\IProductLineDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */