package cs.bms.dao;

import cs.bms.dao.interfac.IProductCostPriceDao;
import cs.bms.model.ProductCostPrice;
import gkfire.hibernate.generic.GenericDao;
import org.springframework.stereotype.Repository;

@Repository
public class ProductCostPriceDao
  extends GenericDao<ProductCostPrice, Long>
  implements IProductCostPriceDao
{}


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\dao\ProductCostPriceDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */