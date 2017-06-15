package cs.bms.service.interfac;

import cs.bms.model.ElectronicBook;
import gkfire.hibernate.generic.interfac.IGenericService;

public abstract interface IElectronicBookService
  extends IGenericService<ElectronicBook, Short>
{
  public abstract boolean existCode(String paramString, Short paramShort);
}


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\service\interfac\IElectronicBookService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */