package cs.bms.dao;

import cs.bms.dao.interfac.ICompanyGroupDao;
import cs.bms.model.CompanyGroup;
import gkfire.hibernate.generic.GenericDao;
import org.springframework.stereotype.Repository;

@Repository
public class CompanyGroupDao
        extends GenericDao<CompanyGroup, Integer>
        implements ICompanyGroupDao {
}
