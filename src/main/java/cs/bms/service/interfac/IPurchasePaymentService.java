package cs.bms.service.interfac;

import cs.bms.model.Company;
import cs.bms.model.Purchase;
import cs.bms.model.PurchasePayment;
import gkfire.hibernate.generic.interfac.IGenericService;
import java.math.BigDecimal;
import java.util.Date;

public interface IPurchasePaymentService extends IGenericService<PurchasePayment, Long> {

    public abstract BigDecimal getSumAfterByCompany(Date paramDate, Company paramCompany);

    public BigDecimal getCurrentPay(Purchase selected);
}