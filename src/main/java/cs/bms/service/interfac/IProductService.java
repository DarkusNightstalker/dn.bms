package cs.bms.service.interfac;

import cs.bms.model.Product;
import gkfire.hibernate.generic.interfac.IGenericService;
import java.util.Date;
import java.util.List;

public abstract interface IProductService
  extends IGenericService<Product, Long>
{
  public abstract boolean existBarCode(String paramString, Long paramLong);
  
  public abstract Product getByBarcode(String paramString);
  
  public abstract Object[] getAuditoryData(Long paramLong);
  
  public abstract List<Object[]> getSuppliersBasicData(Long paramLong);
  
  public abstract List<Object[]> getSellersBasicData(Long paramLong);
  
  public abstract List<String> getAllBarcodes();
  
  public abstract List<Object[]> getCreatedByAfterDate(Date paramDate);
  
  public abstract List<Object[]> getEditedByAfterDate(Date paramDate, boolean paramBoolean);
}


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\service\interfac\IProductService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */