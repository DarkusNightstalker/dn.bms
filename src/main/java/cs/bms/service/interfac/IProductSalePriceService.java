package cs.bms.service.interfac;

import cs.bms.model.Company;
import cs.bms.model.Product;
import cs.bms.model.ProductSalePrice;
import cs.bms.model.User;
import gkfire.hibernate.generic.interfac.IGenericService;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface IProductSalePriceService extends IGenericService<ProductSalePrice, Long> {

    public List<Object[]> getBasicDataByCompanyProduct(Company paramCompany, Product paramProduct);

    public void deleteByCompanyProduct(Company paramCompany, Product paramProduct);

    public void saveForGroup(BigDecimal price, Integer quantity, Company currentCompany, Product selected, User user);

    public List<Object[]> getCreatedByAfterDate(Date init, Date end, String paramString);

    public BigDecimal getBasicPrice(Company currentCompany, Product product);

}
