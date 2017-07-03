package cs.bms.service;

import cs.bms.dao.interfac.IPermissionCategoryDao;
import cs.bms.model.PermissionCategory;
import cs.bms.service.interfac.IPermissionCategoryService;
import gkfire.hibernate.generic.GenericService;
import gkfire.hibernate.generic.interfac.IGenericDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PermissionCategoryService
        extends GenericService<PermissionCategory, Integer>
        implements IPermissionCategoryService {

    @Autowired
    @Qualifier("permissionCategoryDao")
    private IPermissionCategoryDao dao;

    protected IGenericDao<PermissionCategory, Integer> getDao() {
        return this.dao;
    }
}
