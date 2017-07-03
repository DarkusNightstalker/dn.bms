package cs.bms.service;

import cs.bms.dao.interfac.ISalePaymentDao;
import cs.bms.model.Company;
import cs.bms.model.SalePayment;
import cs.bms.service.interfac.ISalePaymentService;
import gkfire.hibernate.generic.GenericService;
import gkfire.hibernate.generic.interfac.IGenericDao;
import java.math.BigDecimal;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Implementación SERVICE para el modelo SALE PAYMENT
 * 
 * @author Darkus Nightmare
 * @version 1.0
 */
@Service
public class SalePaymentService extends GenericService<SalePayment, Long> implements ISalePaymentService {

    @Autowired
    @Qualifier("salePaymentDao")
    private ISalePaymentDao dao;

    @Override
    protected IGenericDao<SalePayment, Long> getDao() {
        return this.dao;
    }

    @Override
    public BigDecimal getCashAfterByCompany(Date date, Company company) {
        if (date != null) {
            return (BigDecimal) this.dao.getByHQL("SELECT "
                    + "COALESCE(SUM(sp.quantity),0) "
                    + "FROM SalePayment sp "
                    + "WHERE "
                    + "sp.sale.active = true AND "
                    + "sp.sale.credit = false AND "
                    + "sp.sale.verified = true AND "
                    + "sp.visa = false AND "
                    + "sp.datePayment > ? AND "
                    + "sp.sale.company = ?", date, company);
        }

        return (BigDecimal) this.dao.getByHQL("SELECT "
                + "COALESCE(SUM(sp.quantity),0) "
                + "FROM SalePayment sp "
                + "WHERE "
                + "sp.sale.active = true AND "
                + "sp.sale.credit = false AND "
                + "sp.sale.verified = true AND "
                + "sp.visa = false AND "
                + "sp.sale.company = ?", company);
    }

    @Override
    public BigDecimal getCreditAfterByCompany(Date date, Company company) {
        if (date != null) {
            return (BigDecimal) this.dao.getByHQL("SELECT "
                    + "COALESCE(SUM(s.subtotal+s.igv-s.subtotalDiscount-s.igvDiscount),0) "
                    + "FROM Sale s "
                    + "WHERE s.active = true AND s.verified = true AND s.credit = true AND s.dateIssue > ? AND s.company = ?", date, company);
        }

        return (BigDecimal) this.dao.getByHQL("SELECT "
                + "COALESCE(SUM(s.subtotal+s.igv-s.subtotalDiscount-s.igvDiscount),0) "
                + "FROM Sale s "
                + "WHERE s.active = true AND s.verified = true AND s.credit = true AND s.company = ?", company);
    }
}
