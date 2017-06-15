package cs.bms.service.interfac;

import cs.bms.model.DocumentNumbering;
import cs.bms.model.User;
import gkfire.hibernate.generic.interfac.IGenericService;
import java.util.List;

public abstract interface IDocumentNumberingService
  extends IGenericService<DocumentNumbering, Integer>
{
  public abstract List<Object[]> getDataByUser(User paramUser, String paramString);
  
  public abstract List<Object[]> getListData();
}


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\service\interfac\IDocumentNumberingService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */