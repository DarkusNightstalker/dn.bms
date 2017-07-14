package cs.bms.dao;

import cs.bms.dao.interfac.IInternalStockMovementDetailDao;
import cs.bms.model.InternalStockMovement;
import cs.bms.model.InternalStockMovementDetail;
import gkfire.hibernate.generic.GenericDao;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

@Repository
public class InternalStockMovementDetailDao extends GenericDao<InternalStockMovementDetail, Long> implements IInternalStockMovementDetailDao {

    @Override
    public void deleteByExcludeIds(InternalStockMovement m, List<Long> ids) {
        if(ids.isEmpty()) return;
        Query q = getSessionFactory().getCurrentSession().createQuery("DELETE FROM InternalStockMovementDetail WHERE internalStockMovement = :ism AND id NOT IN (:ids)");
        q.setEntity("ism", m);
        q.setParameterList("ids", ids);
        q.executeUpdate();        
    }
    
    
}
