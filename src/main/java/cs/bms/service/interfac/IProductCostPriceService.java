package cs.bms.service.interfac;

import cs.bms.model.Company;
import cs.bms.model.Product;
import cs.bms.model.ProductCostPrice;
import cs.bms.model.User;
import gkfire.hibernate.generic.interfac.IGenericService;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public abstract interface IProductCostPriceService
  extends IGenericService<ProductCostPrice, Long>
{
  public abstract Long getIdByCompanyProduct(Company paramCompany, Product paramProduct);
  
  public abstract BigDecimal getCostByCompanyProduct(Company paramCompany, Product paramProduct);
  
  public abstract BigDecimal getLastAcquisitionCost(Company paramCompany, Product paramProduct);
  
  public abstract void updateGroupCostByCompanyProduct(BigDecimal paramBigDecimal, Company paramCompany, Product paramProduct, User paramUser);
  
  public abstract List<Object[]> getCreatedByAfterDate(Date paramDate, String paramString);
  
  public abstract List<Object[]> getEditedByAfterDate(Date paramDate, String paramString, boolean paramBoolean);
}


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\service\interfac\IProductCostPriceService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */