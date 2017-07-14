package cs.bms.service.interfac;

import cs.bms.model.Company;
import cs.bms.model.Product;
import cs.bms.model.PurchaseDetail;
import gkfire.hibernate.generic.interfac.IGenericService;
import java.math.BigDecimal;

public interface IPurchaseDetailService extends IGenericService<PurchaseDetail, Long> {

    public BigDecimal getQuantityById(Long paramLong);

    public BigDecimal getUnitCostById(Long paramLong);

    public BigDecimal getSumQuantityByCompanyProduct(Company company, Product product);
}