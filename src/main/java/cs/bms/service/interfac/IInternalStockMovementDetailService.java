package cs.bms.service.interfac;

import cs.bms.model.Company;
import cs.bms.model.InternalStockMovement;
import cs.bms.model.InternalStockMovementDetail;
import cs.bms.model.Product;
import gkfire.hibernate.generic.interfac.IGenericService;
import java.math.BigDecimal;
import java.util.List;

public interface IInternalStockMovementDetailService extends IGenericService<InternalStockMovementDetail, Long> {

    public List<Object[]> getRemoveds(List<Long> paramList, Long paramLong);

    public void restoreStock(InternalStockMovementDetail paramInternalStockMovementDetail, Company paramCompany1, Company paramCompany2);

    public List<Object[]> getDataForManage(InternalStockMovement paramInternalStockMovement);

    public BigDecimal getQuantityById(Long paramLong);

    public BigDecimal getUnitCostById(Long paramLong);
    
    public Long countNotUploaded();

    public BigDecimal getQuantityByDocumentBarcode(String paymentProofCode, String serie, String documentNumber, String productBarcode);

    public List<Object[]> getInSynchroBasicData(Company company, Product product);
    
    public BigDecimal getInNotServerQuantity(Company company, Product product);
    
    public BigDecimal getOutNotServerQuantity(Company company, Product product);    
    
    public List<Object[]> getOutSynchroBasicData(Company company, Product product);

    public Long getIdByISMProduct(InternalStockMovement ism, Product product);

    public void deleteByExcludeIds(InternalStockMovement ism, List<Long> ids);

}