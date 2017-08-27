package cs.bms.service;

import cs.bms.dao.interfac.IPurchaseDao;
import cs.bms.model.Purchase;
import cs.bms.service.interfac.IPurchaseService;
import gkfire.hibernate.generic.GenericService;
import gkfire.hibernate.generic.interfac.IGenericDao;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author Darkus Nightmare
 */
@Service
public class PurchaseService extends GenericService<Purchase, Long> implements IPurchaseService {

    @Autowired
    @Qualifier("purchaseDao")
    private IPurchaseDao dao;

    @Override
    protected IGenericDao<Purchase, Long> getBasicDao() {
        return this.dao;
    }

    @Override
    public List<Object[]> forAutocomplete(int quantity, String query, Long idSupplier) {
        return dao.listHQLPage(""
                + "SELECT "
                + "p.id,"
                + "p.paymentProof.abbr||' '||p.fullDocument,"
                + "p.dateIssue,"
                + "p.dateDue,"
                + "s.id,"
                + "p.serie "
                + "FROM Purchase p left join p.supplier s "
                + "WHERE "
                + "LOWER(p.paymentProof.abbr||' '||p.fullDocument) LIKE LOWER(?) AND "
                + "p.active = true AND "
                + "s.id = ?", 1, quantity, "%" + query + "%", idSupplier);
    }

    @Override
    public List<Object[]> getBasicData(Long idSupplier) {
        return dao.listHQL(""
                + "SELECT "
                + "p.id,"
                + "p.paymentProof.abbr||' '||p.fullDocument,"
                + "p.dateIssue,"
                + "p.dateDue,"
                + "s.id,"
                + "p.serie "
                + "FROM Purchase p left join p.supplier s "
                + "WHERE "
                + "p.active = true AND "
                + "s.id = ?", idSupplier);
    }

    @Override
    public void clean() throws Exception {
        dao.updateHQL("DELETE FROM PurchaseDetail pd");
        dao.updateHQL("DELETE FROM PurchasePayment pp");
        dao.updateHQL("DELETE FROM Purchase p");
    }

    @Override
    public Long getIdByDocument(String supplierIdentityNumber, String paymentProofCode, String serie, String documentNumber) {
        return (Long) dao.getByHQL(""
                + "SELECT "
                    + "p.id "
                + "FROM Purchase p "
                + "WHERE "
                    + "p.supplier.identityNumber LIKE ? AND "
                    + "p.paymentProof.code LIKE ? AND "
                    + "p.serie LIKE ? AND "
                    + "p.documentNumber LIKE ?",supplierIdentityNumber,paymentProofCode,serie,documentNumber);
    }

    @Override
    public List<Map<String, Object>> getForSynchroUpload() {
        
       List<Map<String,Object>> data = dao.listHQL(""
               + "SELECT "
               + "new map("
                    + "p.paymentProof.code as paymentProofCode,"
                    + "p.serie as serie,"
                    + "p.documentNumber as documentNumber,"
                    + "p.electronic as electronic,"
                    + "s.identityNumber as identityNumber,"
                    + "p.supplierName as supplierName,"
                    + "p.subtotal as subtotal,"
                    + "p.igv as igv,"
                    + "p.subtotalDiscount as subtotalDiscount,"
                    + "p.igvDiscount as igvDiscount,"
                    + "p.companyArrival.code as companyArrivalCode,"
                    + "p.dateIssue as dateIssue,"
                    + "p.dateDue as dateDue,"
                    + "p.createUser.username as createUsername,"
                    + "p.createDate as createDate,"
                    + "e.username as editUsername,"
                    + "p.editDate as editDate,"
                    + "p.active as active,"
                    + "p.id as details,"
                    + "p.id as payments"
               + ") "
               + "FROM Purchase p LEFT JOIN p.supplier s LEFT JOIN p.editUser e");
       data.forEach(item -> {
           item.put("details", dao.listHQL(""
                    + "SELECT "
                    + "new map("
                        + "pd.product.barcode as productBarcode,"
                        + "pd.uom.code as uomCode,"
                        + "pd.productName as productName,"
                        + "pd.quantity as quantity,"
                        + "pd.unitPrice as unitPrice,"
                        + "pd.subtotal as subtotal,"
                        + "pd.igv as igv "
                    + ") "
                    + "FROM PurchaseDetail pd WHERE pd.purchase.id = ?",item.get("details")));
           item.put("payments", dao.listHQL(""
                    + "SELECT "
                    + "new map( "
                        + "pp.datePayment as datePayment,"
                        + "pp.quantity as quantity,"
                        + "pp.description as description,"
                        + "pp.companyDisbursement.code as companyDisbursementCode,"
                        + "pp.createUser.username as createUsername,"
                        + "pp.createDate as createDate,"
                        + "e.username as editUsername,"
                        + "pp.editDate as editDate,"
                        + "pp.active as active "
                    + ") "
                    + "FROM PurchasePayment pp LEFT JOIN pp.editUser e WHERE pp.purchase.id = ?",item.get("payments")));
       });       
       return data;
    }
}
