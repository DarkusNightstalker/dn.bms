package cs.bms.service.interfac;

import cs.bms.model.ElectronicBookCategory;
import gkfire.hibernate.generic.interfac.IGenericService;
import java.util.List;

public abstract interface IElectronicBookCategoryService
  extends IGenericService<ElectronicBookCategory, Short>
{
  public abstract boolean existCode(String paramString, Short paramShort);
  
  public abstract List<Object[]> getBasicData();
}


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\service\interfac\IElectronicBookCategoryService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */