package cs.bms.service;

import cs.bms.dao.interfac.IInternalStockMovementDetailDao;
import cs.bms.model.Company;
import cs.bms.model.InternalStockMovement;
import cs.bms.model.InternalStockMovementDetail;
import cs.bms.service.interfac.IInternalStockMovementDetailService;
import gkfire.hibernate.generic.GenericService;
import gkfire.hibernate.generic.interfac.IGenericDao;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class InternalStockMovementDetailService extends GenericService<InternalStockMovementDetail, Long> implements IInternalStockMovementDetailService {

    @Autowired
    @Qualifier("internalStockMovementDetailDao")
    private IInternalStockMovementDetailDao dao;

    protected IGenericDao<InternalStockMovementDetail, Long> getDao() {
        return this.dao;
    }

    public List<Object[]> getRemoveds(List<Long> productDetails, Long id) {
        return this.dao.listHQL("SELECT ismd.id,ismd.quantity,ismd.product.id FROM InternalStockMovementDetail ismd WHERE ismd.product.id NOT IN (:products) AND ismd.internalStockMovement.id = :ism_id", new String[]{"products", "ism_id"}, new Object[]{productDetails, id});
    }

    public void restoreStock(InternalStockMovementDetail detail, Company targetCompany, Company sourceCompany) {
        this.dao.updateHQL("UPDATE Stock SET quantity = (quantity - ?) WHERE product = ? AND company = ?", new Object[]{detail.getQuantity(), detail.getProduct(), targetCompany});
        this.dao.updateHQL("UPDATE Stock SET quantity = (quantity + ?) WHERE product = ? AND company = ?", new Object[]{detail.getQuantity(), detail.getProduct(), sourceCompany});
    }

    public List<Object[]> getDataForManage(InternalStockMovement ism) {
        return this.dao.listHQL("SELECT ismd.quantity,ismd.product.id,ismd.unitCost FROM InternalStockMovementDetail ismd WHERE ismd.internalStockMovement = ?", new Object[]{ism});
    }

    public BigDecimal getQuantityById(Long id) {
        return (BigDecimal) this.dao.getByHQL("SELECT ismd.quantity FROM InternalStockMovementDetail ismd WHERE ismd.id = ?", new Object[]{id});
    }

    public BigDecimal getUnitCostById(Long id) {
        return (BigDecimal) this.dao.getByHQL("SELECT ismd.unitCost FROM InternalStockMovementDetail ismd WHERE ismd.id = ?", new Object[]{id});
    }

    @Override
    public Long countNotUploaded() {
        return (Long) dao.getByHQL("SELECT COUNT(ismd.id) FROM InternalStockMovementDetail ismd WHERE ismd.internalStockMovement.uploaded = false");    
    }
}
