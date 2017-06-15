package cs.bms.service.interfac;

import cs.bms.model.Company;
import cs.bms.model.Product;
import cs.bms.model.Stock;
import cs.bms.model.User;
import gkfire.hibernate.generic.interfac.IGenericService;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public abstract interface IStockService
  extends IGenericService<Stock, Long>
{
  public abstract void substractQuantity(BigDecimal paramBigDecimal, Product paramProduct, Company paramCompany, User paramUser);
  
  public abstract void addQuantity(BigDecimal paramBigDecimal, Product paramProduct, Company paramCompany, User paramUser);
  
  public abstract Long getIdByCompanyProduct(Company paramCompany, Product paramProduct);
  
  public abstract BigDecimal getGroupQuantityByCompanyProduct(Company paramCompany, Product paramProduct);
  
  public abstract List<Object[]> getCreatedByAfterDate(Date paramDate, String paramString);
  
  public abstract List<Object[]> getEditedByAfterDate(Date paramDate, String paramString, boolean paramBoolean);
}


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\service\interfac\IStockService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */