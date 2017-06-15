package cs.bms.service;

import cs.bms.dao.interfac.IInternalStockMovementDao;
import cs.bms.model.InternalStockMovement;
import cs.bms.service.interfac.IInternalStockMovementService;
import gkfire.hibernate.generic.GenericService;
import gkfire.hibernate.generic.interfac.IGenericDao;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class InternalStockMovementService
        extends GenericService<InternalStockMovement, Long>
        implements IInternalStockMovementService {

    @Autowired
    @Qualifier("internalStockMovementDao")
    private IInternalStockMovementDao dao;

    protected IGenericDao<InternalStockMovement, Long> getDao() {
        return this.dao;
    }

    @Override
    public List<Object[]> getCreatedByAfterDate(Date paramDate, String paramString) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Object[]> getEditedByAfterDate(Date paramDate, String paramString, boolean paramBoolean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
