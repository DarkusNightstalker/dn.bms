package cs.bms.dao;

import cs.bms.dao.interfac.IPurchaseReportDao;
import cs.bms.model.Purchase;
import gkfire.hibernate.generic.GenericDao;
import org.springframework.stereotype.Repository;

@Repository
public class PurchaseReportDao
  extends GenericDao<Purchase, Long>
  implements IPurchaseReportDao
{}


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\dao\PurchaseReportDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */