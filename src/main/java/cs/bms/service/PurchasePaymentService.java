package cs.bms.service;

import cs.bms.dao.interfac.IPurchasePaymentDao;
import cs.bms.model.Company;
import cs.bms.model.Purchase;
import cs.bms.model.PurchasePayment;
import cs.bms.service.interfac.IPurchasePaymentService;
import gkfire.hibernate.generic.GenericService;
import gkfire.hibernate.generic.interfac.IGenericDao;
import java.math.BigDecimal;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PurchasePaymentService extends GenericService<PurchasePayment, Long> implements IPurchasePaymentService {

    @Autowired
    @Qualifier("purchasePaymentDao")
    private IPurchasePaymentDao dao;

    @Override
    protected IGenericDao<PurchasePayment, Long> getBasicDao() {
        return this.dao;
    }

    @Override
    public BigDecimal getSumAfterByCompany(Date date, Company company) {
        if (date != null) {
            return (BigDecimal) this.dao.getByHQL("SELECT COALESCE(SUM(pp.quantity),0) FROM PurchasePayment pp WHERE pp.active = true AND  pp.purchase is null and  pp.datePayment > ? AND pp.companyDisbursement = ?", new Object[]{date, company});
        }

        return (BigDecimal) this.dao.getByHQL("SELECT COALESCE(SUM(pp.quantity),0) FROM PurchasePayment pp WHERE pp.active = true AND pp.purchase is null and pp.companyDisbursement = ?", new Object[]{company});
    }

    @Override
    public BigDecimal getCurrentPay(Purchase selected) {
        return (BigDecimal) dao.getByHQL(""
                + "SELECT "
                    + "COALESCE(SUM(pp.quantity),0) "
                + "FROM PurchasePayment pp "
                + "WHERE pp.purchase  = ?", selected);
    }
}
