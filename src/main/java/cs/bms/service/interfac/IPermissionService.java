package cs.bms.service.interfac;

import cs.bms.model.Permission;
import cs.bms.model.PermissionCategory;
import cs.bms.model.User;
import gkfire.hibernate.generic.interfac.IGenericService;
import java.util.List;

public abstract interface IPermissionService
  extends IGenericService<Permission, Integer>
{
  public abstract List<Permission> getBy(PermissionCategory paramPermissionCategory);
  
  public abstract List<String> getPermissionCodeFromUser(User paramUser);
}


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\service\interfac\IPermissionService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */