package cs.bms.service.interfac;

import cs.bms.model.Company;
import cs.bms.model.Product;
import cs.bms.model.StockReturnCustomerDetail;
import gkfire.hibernate.generic.interfac.IGenericService;
import java.math.BigDecimal;

public  interface IStockReturnCustomerDetailService  extends IGenericService<StockReturnCustomerDetail, Long>{

    public BigDecimal getSumQuantityByCompanyProduct(Company company, Product product);
}
