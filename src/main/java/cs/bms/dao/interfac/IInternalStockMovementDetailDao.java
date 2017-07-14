package cs.bms.dao.interfac;

import cs.bms.model.InternalStockMovement;
import cs.bms.model.InternalStockMovementDetail;
import gkfire.hibernate.generic.interfac.IGenericDao;
import java.util.List;

public abstract interface IInternalStockMovementDetailDao extends IGenericDao<InternalStockMovementDetail, Long> {

    public void deleteByExcludeIds(InternalStockMovement m, List<Long> ids);
}
