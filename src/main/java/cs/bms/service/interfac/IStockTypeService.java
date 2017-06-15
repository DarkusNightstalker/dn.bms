package cs.bms.service.interfac;

import cs.bms.model.StockType;
import gkfire.hibernate.generic.interfac.IGenericService;
import java.util.Date;
import java.util.List;

public abstract interface IStockTypeService
  extends IGenericService<StockType, Short>
{
  public abstract StockType getByCode(String paramString);
  
  public abstract List<Object[]> getBasicData();
  
  public abstract Short getIdByCode(String paramString);
  
  public abstract List<Object[]> getCreatedByAfterDate(Date paramDate);
  
  public abstract List<Object[]> getEditedByAfterDate(Date paramDate, boolean paramBoolean);
}


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\service\interfac\IStockTypeService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */