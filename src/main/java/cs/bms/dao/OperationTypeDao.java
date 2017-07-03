package cs.bms.dao;

import cs.bms.dao.interfac.IOperationTypeDao;
import cs.bms.model.OperationType;
import gkfire.hibernate.generic.GenericDao;
import org.springframework.stereotype.Repository;

@Repository
public class OperationTypeDao
  extends GenericDao<OperationType, Short>
  implements IOperationTypeDao
{}


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\dao\OperationTypeDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */