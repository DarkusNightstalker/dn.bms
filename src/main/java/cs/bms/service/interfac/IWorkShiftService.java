package cs.bms.service.interfac;

import cs.bms.model.Company;
import cs.bms.model.WorkShift;
import gkfire.hibernate.generic.interfac.IGenericService;
import java.util.Date;
import java.util.List;

public abstract interface IWorkShiftService
  extends IGenericService<WorkShift, Integer>
{
  public abstract List<Object[]> getFreeBasicDataByCompany(Date paramDate, Company paramCompany);
  
  public abstract List<Object[]> getBasicDataByCompany(Company paramCompany);
}


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\service\interfac\IWorkShiftService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */