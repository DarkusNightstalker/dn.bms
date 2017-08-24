
package cs.bms.service;

import cs.bms.dao.interfac.ISpecialPermissionDao;
import cs.bms.model.SpecialPermission;
import cs.bms.service.interfac.ISpecialPermissionService;
import gkfire.hibernate.generic.GenericService;
import gkfire.hibernate.generic.interfac.IGenericDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service
public class SpecialPermissionService
        extends GenericService<SpecialPermission, Short>
        implements ISpecialPermissionService {
    @Autowired
    @Qualifier("specialPermissionDao")
    private ISpecialPermissionDao dao;

    /*    */
    protected IGenericDao<SpecialPermission, Short> getBasicDao() {
        return this.dao;
    }

    @Override
    public Short getIdByBasicData(String entityName, long identifier) {
        return (Short) dao.getByHQL("SELECT sp.id FROM SpecialPermission sp WHERE sp.entityName LIKE ? AND sp.identifier = ?",entityName,identifier);
    }
}
