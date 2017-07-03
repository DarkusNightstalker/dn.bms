package cs.bms.service;

import cs.bms.dao.interfac.IStockReturnSupplierDao;
import cs.bms.model.Purchase;
import cs.bms.model.StockReturnSupplier;
import cs.bms.service.interfac.IStockReturnSupplierService;
import gkfire.hibernate.generic.GenericService;
import gkfire.hibernate.generic.interfac.IGenericDao;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author Darkus Nightmare
 */
@Service
public class StockReturnSupplierService extends GenericService<StockReturnSupplier, Long> implements IStockReturnSupplierService {

    @Autowired
    @Qualifier("stockReturnSupplierDao")
    private IStockReturnSupplierDao dao;

    @Override
    protected IGenericDao<StockReturnSupplier, Long> getDao() {
        return this.dao;
    }

    @Override
    public BigDecimal getSumRepayment(Purchase selected) {
        return (BigDecimal) dao.getByHQL(""
                + "SELECT "
                    + "COALESCE(SUM(srs.repayment+srs.igv),0) "
                + "FROM StockReturnSupplier srs "
                + "WHERE srs.purchase  = ?", selected);
    }

    @Override
    public List<Object[]> getBasicDataByPurchase(Purchase selected) {
        return dao.listHQL(""
                + "SELECT "
                    + "srs.id,"
                    + "srs.dateIssue,"
                    + "srs.paymentProof.abbr||' '||srs.fullDocument,"
                    + "srs.repayment,"
                    + "srs.igv "
                + "FROM StockReturnSupplier srs "
                + "WHERE srs.purchase  = ?", selected);
    }
}
