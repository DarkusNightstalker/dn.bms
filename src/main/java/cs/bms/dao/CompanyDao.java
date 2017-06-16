package cs.bms.dao;

import cs.bms.dao.interfac.ICompanyDao;
import cs.bms.model.Company;
import gkfire.hibernate.generic.GenericDao;
import java.util.Collections;
import java.util.List;
import org.hibernate.Query;

public class CompanyDao  extends GenericDao<Company, Integer> implements ICompanyDao {

    @Override
    public List<Object[]> getDataByList(List<Long> paramList) {
        if(paramList.isEmpty()) return Collections.EMPTY_LIST;
        Query query = getSessionFactory().getCurrentSession().createQuery("SELECT c.id,c.name,c.city,c.address FROM Company c WHERE c.active = true AND c.id IN :ids ORDER BY c.code");
        query.setParameterList("ids", paramList);
        
        return query.list();
    }
}
