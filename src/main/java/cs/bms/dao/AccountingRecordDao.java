package cs.bms.dao;

import cs.bms.dao.interfac.IAccountingRecordDao;
import cs.bms.model.AccountingRecord;
import gkfire.hibernate.generic.GenericDao;

public class AccountingRecordDao
  extends GenericDao<AccountingRecord, Long>
  implements IAccountingRecordDao
{}


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\dao\AccountingRecordDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */