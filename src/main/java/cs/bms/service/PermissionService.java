package cs.bms.service;

import cs.bms.dao.interfac.IPermissionDao;
import cs.bms.model.Permission;
import cs.bms.model.PermissionCategory;
import cs.bms.model.User;
import cs.bms.service.interfac.IPermissionService;
import gkfire.hibernate.generic.GenericService;
import gkfire.hibernate.generic.interfac.IGenericDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PermissionService
        extends GenericService<Permission, Integer>
        implements IPermissionService {

    @Autowired
    @Qualifier("permissionDao")
    private IPermissionDao dao;

    public List<Permission> getBy(PermissionCategory category) {
        return this.dao.getBy(category);
    }

    protected IGenericDao<Permission, Integer> getBasicDao() {
        return this.dao;
    }

    public List<String> getPermissionCodeFromUser(User user) {
        return this.dao.getPermissionCodeFromUser(user);
    }
}
