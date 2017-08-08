package cs.bms.service;

import cs.bms.dao.interfac.IPurchaseDao;
import cs.bms.model.Purchase;
import cs.bms.service.interfac.IPurchaseService;
import gkfire.hibernate.generic.GenericService;
import gkfire.hibernate.generic.interfac.IGenericDao;
import java.util.List;
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
}
