package cs.bms.service.interfac;

import cs.bms.model.OperationType;
import gkfire.hibernate.generic.interfac.IGenericService;

public abstract interface IOperationTypeService
  extends IGenericService<OperationType, Short>
{
  public abstract Short getOpeningBalanceTypeId();
  
  public abstract Short getSaleTypeId();
  
  public abstract Short getPurchaseTypeId();
  
  public abstract Short getISMInTypeId();
  
  public abstract Short getISMOutTypeId();
  
  public abstract Short getDecreaseTypeId();
  
  public abstract Short getCustomerReturnTypeId();
  
  public abstract Short getSupplierReturnTypeId();
}


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\service\interfac\IOperationTypeService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */