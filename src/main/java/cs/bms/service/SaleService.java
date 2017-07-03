package cs.bms.service;

import cs.bms.dao.interfac.ISaleDao;
import cs.bms.model.Company;
import cs.bms.model.Sale;
import cs.bms.service.interfac.ISaleService;
import gkfire.hibernate.generic.GenericService;
import gkfire.hibernate.generic.interfac.IGenericDao;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Implementación SERVICE para el modelo SALE
 *
 * @author Darkus Nightmare
 * @version 1.0
 */
@Service
public class SaleService extends GenericService<Sale, Long> implements ISaleService {

    @Autowired
    @Qualifier("saleDao")
    private ISaleDao dao;

    @Override
    protected IGenericDao<Sale, Long> getDao() {
        return this.dao;
    }

    @Override
    public List<Object[]> getNotVerifySales(Company company, List<Long> exceptions) {
        return this.dao.getNotVerifySales(company, exceptions);
    }

    @Override
    public void verified(Long id, boolean credit) {
        this.dao.updateHQL("UPDATE Sale SET verified=true,credit =? WHERE id = ?", credit, id);
    }

//    @Override
//    public BigDecimal getVisaAfterByCompany(Date date, Company company) {
//        if (date != null) {
//            return (BigDecimal) this.dao.getByHQL("SELECT COALESCE(SUM(s.subtotal+s.igv-s.subtotalDiscount-s.igvDiscount),0) FROM Sale s WHERE  s.active = true AND s.verified = true AND  s.dateIssue > ? AND s.visa = true and s.company = ?", date, company);
//        }
//
//        return (BigDecimal) this.dao.getByHQL("SELECT COALESCE(SUM(s.subtotal+s.igv-s.subtotalDiscount-s.igvDiscount),0) FROM Sale s WHERE  s.active = true AND s.verified = true  AND s.visa = true and s.company = ?", company);
//    }
    @Override
    public void updatePoints(Long points, Long id) {
        this.dao.updateHQL("UPDATE Sale SET points = ? WHERE id = ?", points, id);
    }

    @Override
    public void updateDiscount(BigDecimal discount, Long id) {
        this.dao.updateHQL("UPDATE Sale SET subtotalDiscount = ? WHERE id = ?", new Object[]{discount, id});
    }

    @Override
    public void subtractCustomerPointsDiscount(long points, Long id) {
        this.dao.updateHQL("UPDATE Sale SET customerPoints = customerPoints-? WHERE id = ?", points, id);
    }

    @Override
    public void clean() throws Exception {
        dao.updateHQL("DELETE FROM SaleDetail sd");
        dao.updateHQL("DELETE FROM SalePayment sp");
        dao.updateHQL("UPDATE PaymentVoucher pv SET sale = null,dateExpiry = ? WHERE sale is not null",new Date());        
        dao.updateHQL("DELETE FROM Sale s");        
    }
}
