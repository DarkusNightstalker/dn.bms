package cs.bms.service.interfac;

import cs.bms.model.SpecialPermission;
import gkfire.hibernate.generic.interfac.IGenericService;

public interface ISpecialPermissionService extends IGenericService<SpecialPermission, Short> {
    public Short getIdByBasicData(String entityName, long identifier);
}

