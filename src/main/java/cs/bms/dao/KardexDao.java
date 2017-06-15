package cs.bms.dao;

import cs.bms.dao.interfac.IKardexDao;
import cs.bms.model.Kardex;
import gkfire.hibernate.generic.GenericDao;
import java.io.Serializable;

public class KardexDao
  extends GenericDao<Kardex, Serializable>
  implements IKardexDao
{}


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\dao\KardexDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */