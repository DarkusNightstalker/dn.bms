package cs.bms.service;

import cs.bms.dao.interfac.ICompanyGroupDao;
import cs.bms.model.CompanyGroup;
import cs.bms.service.interfac.ICompanyGroupService;
import gkfire.hibernate.generic.GenericService;
import gkfire.hibernate.generic.interfac.IGenericDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CompanyGroupService
        extends GenericService<CompanyGroup, Integer>
        implements ICompanyGroupService {

    @Autowired
    @Qualifier("companyGroupDao")
    private ICompanyGroupDao dao;

    @Override
    protected IGenericDao<CompanyGroup, Integer> getBasicDao() {
        return this.dao;
    }

    @Override
    public List<Object[]> getBasicData() {
        return this.dao.listHQL("SELECT cg.id,cg.name FROM CompanyGroup cg WHERE cg.active = true");
    }

    @Override
    public Integer getIdByName(String name) {
        return (Integer) dao.getByHQL(""
                + "SELECT "
                + "cg.id "
                + "FROM CompanyGroup cg "
                + "WHERE cg.name LIKE ?",name);
    }
}
