package cs.bms.service.interfac;

import cs.bms.model.Purchase;
import cs.bms.model.StockReturnSupplier;
import gkfire.hibernate.generic.interfac.IGenericService;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Darkus Nightmare
 */
public interface IStockReturnSupplierService extends IGenericService<StockReturnSupplier, Long> {

    /**
     *
     * @param selected
     * @return
     */
    public BigDecimal getSumRepayment(Purchase selected);

    /**
     *
     * @param selected
     * @return
     */
    public List<Object[]> getBasicDataByPurchase(Purchase selected);

}

