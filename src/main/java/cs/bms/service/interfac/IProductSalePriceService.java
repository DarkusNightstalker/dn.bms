package cs.bms.service.interfac;

import cs.bms.model.Company;
import cs.bms.model.Product;
import cs.bms.model.ProductSalePrice;
import cs.bms.model.User;
import gkfire.hibernate.generic.interfac.IGenericService;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public abstract interface IProductSalePriceService
  extends IGenericService<ProductSalePrice, Long>
{
  public abstract List<Object[]> getBasicDataByCompanyProduct(Company paramCompany, Product paramProduct);
  
  public abstract void deleteByCompanyProduct(Company paramCompany, Product paramProduct);
  
  public abstract void saveForGroup(BigDecimal paramBigDecimal, Integer paramInteger, Company paramCompany, Product paramProduct, User paramUser);
  
  public abstract List<Object[]> getCreatedByAfterDate(Date paramDate, String paramString);
}


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\service\interfac\IProductSalePriceService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */