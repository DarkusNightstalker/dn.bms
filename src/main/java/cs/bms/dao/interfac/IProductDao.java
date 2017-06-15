package cs.bms.dao.interfac;

import cs.bms.model.Product;
import gkfire.hibernate.generic.interfac.IGenericDao;

public abstract interface IProductDao
  extends IGenericDao<Product, Long>
{
  public abstract boolean existBarCode(String paramString, Long paramLong);
}


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\dao\interfac\IProductDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */