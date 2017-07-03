package cs.bms.service;

import cs.bms.dao.interfac.IStockReturnSupplierDetailDao;
import cs.bms.model.StockReturnSupplierDetail;
import cs.bms.service.interfac.IStockReturnSupplierDetailService;
import gkfire.hibernate.generic.GenericService;
import gkfire.hibernate.generic.interfac.IGenericDao;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author Darkus Nightmare
 */
@Service
public class StockReturnSupplierDetailService extends GenericService<StockReturnSupplierDetail, Long> implements IStockReturnSupplierDetailService {

    @Autowired
    @Qualifier("stockReturnSupplierDetailDao")
    private IStockReturnSupplierDetailDao dao;

    @Override
    protected IGenericDao<StockReturnSupplierDetail, Long> getDao() {
        return this.dao;
    }

    @Override
    public List<Object[]> getDataBySupplierReturn(Long idSupplierReturn) {
        if(idSupplierReturn == null) return Collections.EMPTY_LIST;
        return dao.listHQL(""
                + "SELECT "
                    + "srsd.id,"
                    + "srsd.product.id,"
                    + "srsd.uom.id,"
                    + "srsd.uom.abbr,"
                    + "srsd.productName,"
                    + "srsd.quantity,"
                    + "srsd.unitCost "
                + "FROM StockReturnSupplierDetail srsd "
                + "WHERE srsd.stockReturnSupplier.id = ?",idSupplierReturn);
    }

    @Override
    public BigDecimal getSumQuantityByProduct(Long idPurchase,Long idProduct,Long exception) {
    return (BigDecimal) dao.getByHQL(""
                + "SELECT "
                    + "COALESCE(SUM(srsd.quantity),0) "
                + "FROM StockReturnSupplierDetail srsd "
                + "WHERE "
                    + "srsd.stockReturnSupplier.purchase.id = ? AND "
                    + "srsd.stockReturnSupplier.id <> ? AND "
                    + "srsd.product.id = ? ",idPurchase,exception == null ?  -1L : exception,idProduct);
    }

    @Override
    public BigDecimal getUnitCostById(Long id) {
        return (BigDecimal) this.dao.getByHQL("SELECT pd.unitCost FROM StockReturnSupplierDetail pd WHERE pd.id = ?", id);
    }

    @Override
    public BigDecimal getQuantityById(Long id) {
        return (BigDecimal) this.dao.getByHQL("SELECT pd.quantity FROM StockReturnSupplierDetail pd WHERE pd.id = ?", id);
    }
}
