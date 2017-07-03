package cs.bms.dao;

import cs.bms.dao.interfac.IStockTypeDao;
import cs.bms.model.StockType;
import gkfire.hibernate.generic.GenericDao;
import org.springframework.stereotype.Repository;

@Repository
public class StockTypeDao
  extends GenericDao<StockType, Short>
  implements IStockTypeDao
{}


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\dao\StockTypeDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */