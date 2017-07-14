package cs.bms.service.interfac;

import cs.bms.model.Company;
import cs.bms.model.Product;
import cs.bms.model.Sale;
import cs.bms.model.SaleDetail;
import gkfire.hibernate.generic.interfac.IGenericService;
import java.math.BigDecimal;
import java.util.List;

public interface ISaleDetailService extends IGenericService<SaleDetail, Long> {

    public List<Object[]> getBasicDataBySale(Sale sale);

    public BigDecimal getQuantityById(Long paramLong);

    public List<Object[]> getProductDataBySale(Sale sale);

    public BigDecimal getSumQuantityByCompanyProduct(Company company, Product product);
}
