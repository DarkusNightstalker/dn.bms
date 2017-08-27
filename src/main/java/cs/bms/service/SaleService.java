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
import java.util.Map;
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
    protected IGenericDao<Sale, Long> getBasicDao() {
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
        dao.updateHQL("UPDATE PaymentVoucher pv SET sale = null,active = false WHERE sale is not null",new Date());        
        dao.updateHQL("DELETE FROM Sale s");        
    }

    @Override
    public Long getNotUploadedPointsByIdentityNumber(String identityNumber) {
        return ((Number) dao.getByHQL(""
                + "SELECT "
                + "COALESCE(SUM(s.points - s.spendPoints),0) "
                + "FROM Sale s "
                + "WHERE "
                + "s.customer.identityNumber LIKE ? AND "
                + "s.uploadPoints = false", identityNumber)).longValue();
        
    }

    @Override
    public List<Object[]> listPointsWhenNotUploaded() {
        return dao.listHQL(""
                + "SELECT "
                    + "s.customer.identityNumber,"
                    + "SUM(s.points-s.spendPoints) "
                + "FROM Sale s "
                + "WHERE s.uploadPoints = false "
                + "GROUP BY s.customer.identityNumber");
    }

    @Override
    public void completeUploadPoints() {
        try {
            dao.updateHQL("UPDATE Sale s SET s.uploadPoints = true WHERE s.uploadPoints = false");
        } catch (Exception ex) {
            
        }
    }

    @Override
    public List<Map<String,Object>> getForSynchroUpload() {
       List<Map<String,Object>> data = dao.listHQL(""
               + "SELECT "
               + "new map("
                    + "s.paymentProof.code as paymentProofCode,"
                    + "s.serie as serie,"
                    + "s.documentNumber as documentNumber,"
                    + "c.identityNumber as identityNumber,"
                    + "s.customerName as customerName,"
                    + "s.electronic as electronic,"
                    + "s.sent as sent,"
                    + "s.verified as verified,"
                    + "s.credit as credit,"
                    + "s.points as points,"
                    + "s.customerPoints as customerPoints,"
                    + "s.spendPoints as spendPoints,"
                    + "s.subtotal as subtotal,"
                    + "s.igv as igv,"
                    + "s.subtotalDiscount as subtotalDiscount,"
                    + "s.igvDiscount as igvDiscount,"
                    + "s.company.code as companyCode,"
                    + "s.dateIssue as dateIssue,"
                    + "s.dateDue as dateDue,"
                    + "s.createUser.username as createUsername,"
                    + "s.createDate as createDate,"
                    + "e.username as editUsername,"
                    + "s.editDate as editDate,"
                    + "s.uploadPoints as uploadPoints,"
                    + "s.total as total,"
                    + "s.active as active,"
                    + "s.id as details,"
                    + "s.id as payments"
               + ") "
               + "FROM Sale s LEFT JOIN s.editUser e LEFT JOIN s.customer c");
       data.forEach(item -> {
           item.put("details", dao.listHQL(""
                    + "SELECT "
                    + "new map("
                        + "sd.product.barcode as productBarcode,"
                        + "sd.uom.code as uomCode,"
                        + "sd.subtotal as subtotal,"
                        + "sd.productName as productName,"
                        + "sd.quantity as quantity,"
                        + "sd.unitPrice as unitPrice,"
                        + "sd.unitCost as unitCost,"
                        + "sd.pointsPrice as pointsPrice"
                    + ") "
                    + "FROM SaleDetail sd WHERE sd.sale.id = ?",item.get("details")));
           item.put("payments", dao.listHQL(""
                    + "SELECT "
                    + "new map("
                        + "sp.datePayment as datePayment,"
                        + "sp.quantity as quantity,"
                        + "sp.visa as visa "
                    + ") "
                    + "FROM SalePayment sp WHERE sp.sale.id = ?",item.get("payments")));
       });       
       return data;
    }
}
