package cs.bms.dao;

import cs.bms.dao.interfac.ICompanyGroupDao;
import cs.bms.model.CompanyGroup;
import gkfire.hibernate.generic.GenericDao;

public class CompanyGroupDao
        extends GenericDao<CompanyGroup, Integer>
        implements ICompanyGroupDao {
}
