package cs.bms.dao.interfac;

import cs.bms.model.Company;
import gkfire.hibernate.generic.interfac.IGenericDao;
import java.util.List;

public abstract interface ICompanyDao
        extends IGenericDao<Company, Integer> {

    public abstract List<Object[]> getDataByList(List<Long> paramList);
}

