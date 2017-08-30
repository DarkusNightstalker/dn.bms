package cs.bms.service.interfac;

import cs.bms.model.Permission;
import cs.bms.model.PermissionCategory;
import cs.bms.model.User;
import gkfire.hibernate.generic.interfac.IGenericService;

import java.util.List;

public interface IPermissionService
        extends IGenericService<Permission, Integer> {
    public List<Permission> getBy(PermissionCategory paramPermissionCategory);

    public List<String> getPermissionCodeFromUser(User paramUser);

    public Integer getIdByCode(String code);
}

