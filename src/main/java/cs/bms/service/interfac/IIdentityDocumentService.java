package cs.bms.service.interfac;

import cs.bms.model.IdentityDocument;
import gkfire.hibernate.generic.interfac.IGenericService;
import java.util.Date;
import java.util.List;

public abstract interface IIdentityDocumentService
  extends IGenericService<IdentityDocument, Short>
{
  public abstract boolean validCode(String paramString, Short paramShort);
  
  public abstract List<Object[]> getBasicData();
  
  public abstract Short getIdByLength(int paramInt);
  
  public abstract List<Object[]> getEditedByAfterDate(Date paramDate, boolean paramBoolean);
  
  public abstract List<Object[]> getCreateByAfterDate(Date paramDate);
}


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\service\interfac\IIdentityDocumentService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */