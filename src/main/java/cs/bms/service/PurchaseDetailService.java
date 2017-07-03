package cs.bms.service;

import cs.bms.dao.interfac.IPurchaseDetailDao;
import cs.bms.model.PurchaseDetail;
import cs.bms.service.interfac.IPurchaseDetailService;
import gkfire.hibernate.generic.GenericService;
import gkfire.hibernate.generic.interfac.IGenericDao;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author Darkus Nightmare
 */
@Service
public class PurchaseDetailService extends GenericService<PurchaseDetail, Long> implements IPurchaseDetailService {

    @Autowired
    @Qualifier("purchaseDetailDao")
    private IPurchaseDetailDao dao;

    @Override
    protected IGenericDao<PurchaseDetail, Long> getDao() {
        return this.dao;
    }

    @Override
    public BigDecimal getQuantityById(Long id) {
        return (BigDecimal) this.dao.getByHQL("SELECT pd.quantity FROM PurchaseDetail pd WHERE pd.id = ?", id);
    }

    @Override
    public BigDecimal getUnitCostById(Long id) {
        return (BigDecimal) this.dao.getByHQL("SELECT pd.unitPrice FROM PurchaseDetail pd WHERE pd.id = ?", id);
    }
}
