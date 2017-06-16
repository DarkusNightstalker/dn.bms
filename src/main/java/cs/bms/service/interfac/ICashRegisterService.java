package cs.bms.service.interfac;

import cs.bms.model.CashRegister;
import cs.bms.model.Company;
import gkfire.hibernate.generic.interfac.IGenericService;
import java.util.Date;

public abstract interface ICashRegisterService extends IGenericService<CashRegister, Long> {

    public abstract Date getLastDate(Company paramCompany);
}
