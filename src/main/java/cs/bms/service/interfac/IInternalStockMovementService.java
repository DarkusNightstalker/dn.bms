package cs.bms.service.interfac;

import cs.bms.model.InternalStockMovement;
import gkfire.hibernate.generic.interfac.IGenericService;
import java.util.Date;
import java.util.List;

public abstract interface IInternalStockMovementService
  extends IGenericService<InternalStockMovement, Long>
{
  public abstract List<Object[]> getCreatedByAfterDate(Date paramDate, String paramString);
  
  public abstract List<Object[]> getEditedByAfterDate(Date paramDate, String paramString, boolean paramBoolean);
}


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\service\interfac\IInternalStockMovementService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */