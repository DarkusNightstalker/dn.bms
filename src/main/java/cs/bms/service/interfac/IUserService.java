package cs.bms.service.interfac;

import cs.bms.model.User;
import gkfire.hibernate.generic.interfac.IGenericService;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

public abstract interface IUserService
  extends IGenericService<User, Integer>
{
  public abstract User login(String paramString1, String paramString2)
    throws Exception;
  
  public abstract Integer getNextId();
  
  public abstract boolean existUsername(String paramString, Integer paramInteger);
  
  public abstract String getCreatorUsername(Class paramClass, Serializable paramSerializable);
  
  public abstract User getCreator(Class paramClass, Serializable paramSerializable);
  
  public abstract boolean verifyAuthenthication(String paramString1, String paramString2)
    throws Exception;
  
  public abstract List<Object[]> getCreateByAfterDate(Date paramDate, String paramString);
  
  public abstract List<Object[]> getEditedByAfterDate(Date paramDate, String paramString, boolean paramBoolean);
}


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\service\interfac\IUserService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */