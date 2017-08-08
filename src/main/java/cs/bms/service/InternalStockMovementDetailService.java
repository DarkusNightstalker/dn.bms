package cs.bms.service;

import cs.bms.dao.interfac.IInternalStockMovementDetailDao;
import cs.bms.model.Company;
import cs.bms.model.InternalStockMovement;
import cs.bms.model.InternalStockMovementDetail;
import cs.bms.model.Product;
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

    @Override
    protected IGenericDao<InternalStockMovementDetail, Long> getBasicDao() {
        return this.dao;
    }

    @Override
    public List<Object[]> getRemoveds(List<Long> productDetails, Long id) {
        return this.dao.listHQL("SELECT ismd.id,ismd.quantity,ismd.product.id FROM InternalStockMovementDetail ismd WHERE ismd.product.id NOT IN (:products) AND ismd.internalStockMovement.id = :ism_id", new String[]{"products", "ism_id"}, new Object[]{productDetails, id});
    }

    @Override
    public void restoreStock(InternalStockMovementDetail detail, Company targetCompany, Company sourceCompany) {
        this.dao.updateHQL("UPDATE Stock SET quantity = (quantity - ?) WHERE product = ? AND company = ?", new Object[]{detail.getQuantity(), detail.getProduct(), targetCompany});
        this.dao.updateHQL("UPDATE Stock SET quantity = (quantity + ?) WHERE product = ? AND company = ?", new Object[]{detail.getQuantity(), detail.getProduct(), sourceCompany});
    }

    @Override
    public List<Object[]> getDataForManage(InternalStockMovement ism) {
        return this.dao.listHQL(""
                + "SELECT "
                    + "ismd.quantity,"
                    + "ismd.product.id,"
                    + "ismd.unitCost "
                + "FROM InternalStockMovementDetail ismd "
                + "WHERE "
                    + "ismd.internalStockMovement = ?", ism);
    }

    @Override
    public BigDecimal getQuantityById(Long id) {
        return (BigDecimal) this.dao.getByHQL(""
                + "SELECT "
                    + "ismd.quantity "
                + "FROM InternalStockMovementDetail ismd "
                    + "WHERE ismd.id = ?", id);
    }

    @Override
    public BigDecimal getUnitCostById(Long id) {
        return (BigDecimal) this.dao.getByHQL(""
                + "SELECT "
                    + "ismd.unitCost "
                + "FROM InternalStockMovementDetail ismd "
                    + "WHERE ismd.id = ?", id);
    }

    @Override
    public Long countNotUploaded() {
        return (Long) dao.getByHQL("SELECT COUNT(ismd.id) FROM InternalStockMovementDetail ismd WHERE ismd.internalStockMovement.uploaded = false");    
    }

    @Override
    public BigDecimal getQuantityByDocumentBarcode(String paymentProofCode, String serie, String documentNumber, String productBarcode) {
        return (BigDecimal) dao.getByHQL(""
                + "SELECT "
                    + "ismd.quantity "
                + "FROM InternalStockMovementDetail ismd "
                + "WHERE "
                    + "ismd.internalStockMovement.paymentProof.code LIKE ? AND "
                    + "ismd.internalStockMovement.serie LIKE ? AND "
                    + "ismd.internalStockMovement.documentNumber LIKE ? AND "
                    + "ismd.product.barcode LIKE ? ",paymentProofCode,serie,documentNumber,productBarcode);
    }

    @Override
    public List<Object[]> getInSynchroBasicData(Company company, Product product) {
        return dao.listHQL(""
                + "SELECT "
                    + "ismd.internalStockMovement.paymentProof.code,"
                    + "ismd.internalStockMovement.serie,"
                    + "ismd.internalStockMovement.documentNumber,"
                    + "ismd.quantity "
                + "FROM InternalStockMovementDetail ismd "
                + "WHERE "
                    + "ismd.targetCompany = ? AND "
                    + "ismd.product = ? AND "
                    + "ismd.dateRealArrival is not null AND "
                    + "ismd.internalStockMovement.serverExist = true AND "
                    + "ismd.internalStockMovement.uploaded = false ",company,product);
    }

    @Override
    public List<Object[]> getOutSynchroBasicData(Company company, Product product) {
        return dao.listHQL(""
                + "SELECT "
                    + "ismd.internalStockMovement.paymentProof.code,"
                    + "ismd.internalStockMovement.serie,"
                    + "ismd.internalStockMovement.documentNumber,"
                    + "ismd.quantity "
                + "FROM InternalStockMovementDetail ismd "
                + "WHERE "
                    + "ismd.sourceCompany = ? AND "
                    + "ismd.product = ? AND "
                    + "ismd.internalStockMovement.serverExist = true AND "
                    + "ismd.internalStockMovement.uploaded = false ",company,product);
    
    }

    @Override
    public BigDecimal getInNotServerQuantity(Company company, Product product) {
        return (BigDecimal) dao.getByHQL(""
                + "SELECT "
                    + "COALESCE(SUM(ismd.quantity),0) "
                + "FROM InternalStockMovementDetail ismd "
                + "WHERE "
                    + "ismd.targetCompany = ? AND "
                    + "ismd.product = ? AND "
                    + "ismd.dateRealArrival is not null AND "
                    + "ismd.internalStockMovement.serverExist = false AND "
                    + "ismd.internalStockMovement.uploaded = false ",company,product);
    }

    @Override
    public BigDecimal getOutNotServerQuantity(Company company, Product product) {
        return (BigDecimal) dao.getByHQL(""
                + "SELECT "
                    + "COALESCE(SUM(ismd.quantity),0) "
                + "FROM InternalStockMovementDetail ismd "
                + "WHERE "
                    + "ismd.sourceCompany = ? AND "
                    + "ismd.product = ? AND "
                    + "ismd.internalStockMovement.serverExist = false AND "
                    + "ismd.internalStockMovement.uploaded = false ",company,product);
    }

    @Override
    public Long getIdByISMProduct(InternalStockMovement ism, Product product) {
        return (Long) dao.getByHQL(""
                + "SELECT "
                    + "ismd.id "
                + "FROM InternalStockMovementDetail ismd "
                + "WHERE "
                    + "ismd.product  = ? AND "
                    + "ismd.internalStockMovement = ? ",product,ism);
    }

    @Override
    public void deleteByExcludeIds(InternalStockMovement ism, List<Long> ids) {
        dao.deleteByExcludeIds(ism,ids);
    }
}
