package cs.bms.dao;

import cs.bms.dao.interfac.ICashRegisterDao;
import cs.bms.model.CashRegister;
import gkfire.hibernate.generic.GenericDao;
import org.springframework.stereotype.Repository;

@Repository
public class CashRegisterDao
  extends GenericDao<CashRegister, Long>
  implements ICashRegisterDao
{}
