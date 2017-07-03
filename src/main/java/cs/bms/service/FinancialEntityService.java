package cs.bms.service;

import cs.bms.dao.interfac.IFinancialEntityDao;
import cs.bms.model.FinancialEntity;
import cs.bms.service.interfac.IFinancialEntityService;
import gkfire.hibernate.generic.GenericService;
import gkfire.hibernate.generic.interfac.IGenericDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class FinancialEntityService
        extends GenericService<FinancialEntity, Short>
        implements IFinancialEntityService {

    @Autowired
    @Qualifier("financialEntityDao")
    private IFinancialEntityDao dao;

    protected IGenericDao<FinancialEntity, Short> getDao() {
        return this.dao;
    }

    public boolean verifyCode(String code, Short id) {
        return this.dao.getByHQL("SELECT 1 FROM FinancialEntity idd WHERE idd.code LIKE ? AND idd.id <> ?", new Object[]{code, id == null ? new Short("-1") : id}) == null;
    }
}
