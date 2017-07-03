package cs.bms.dao;

import cs.bms.dao.interfac.IInternalStockMovementDao;
import cs.bms.model.InternalStockMovement;
import gkfire.hibernate.generic.GenericDao;
import org.springframework.stereotype.Repository;

@Repository
public class InternalStockMovementDao
  extends GenericDao<InternalStockMovement, Long>
  implements IInternalStockMovementDao
{}


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\dao\InternalStockMovementDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */