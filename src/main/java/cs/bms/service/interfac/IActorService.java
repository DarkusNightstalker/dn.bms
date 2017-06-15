package cs.bms.service.interfac;

import cs.bms.model.Actor;
import cs.bms.model.User;
import gkfire.hibernate.generic.interfac.IGenericService;
import java.util.Date;
import java.util.List;

public abstract interface IActorService
  extends IGenericService<Actor, Long>
{
  public abstract void updateNameByIdentityDocument(String paramString1, String paramString2);
  
  public abstract List<Object[]> getIdentityDataForSynchro(String... paramVarArgs);
  
  public abstract Long countIdentityDataForSynchro(String... paramVarArgs);
  
  public abstract Actor getByIdentityNumber(String paramString);
  
  public abstract boolean verifyIdentityNumber(String paramString, Long paramLong);
  
  public abstract List<Object[]> getCreatedByAfterDate(Date paramDate);
  
  public abstract List<Object[]> getEditedByAfterDate(Date paramDate, boolean paramBoolean);
  
  public abstract void subtractPoints(Long paramLong1, Long paramLong2, User paramUser);
  
  public abstract void addPoints(Long paramLong1, Long paramLong2, User paramUser);
}


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\service\interfac\IActorService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */