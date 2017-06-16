package cs.bms.service;

import cs.bms.dao.interfac.ICompanyDao;
import cs.bms.model.Company;
import cs.bms.service.interfac.ICompanyService;
import gkfire.hibernate.generic.GenericService;
import gkfire.hibernate.generic.interfac.IGenericDao;
import gkfire.util.Month;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class CompanyService extends GenericService<Company, Integer> implements ICompanyService {

    @Autowired
    @Qualifier("companyDao")
    private ICompanyDao dao;

    @Override
    protected IGenericDao<Company, Integer> getDao() {
        return this.dao;
    }

    @Override
    public List getDataByList(List ids) {
        return this.dao.getDataByList(ids);
    }

    @Override
    public List<Object[]> getBasicDataNotOpening(int year, Month month) {
        return month == null
                ? this.dao.listHQL("SELECT "
                        + "c.id,"
                        + "c.code,"
                        + "c.name||' '||c.city||' ('||c.address||')' "
                        + "FROM Company c WHERE c.id NOT IN ("
                            + "SELECT DISTINCT ob.company.id "
                            + "FROM OpeningBalance ob WHERE ob.year  = ? "
                        + ")", year)
                : this.dao.listHQL("SELECT "
                        + "c.id,"
                        + "c.code,"
                        + "c.name||' '||c.city||' ('||c.address||')' "
                        + "FROM Company c WHERE c.id NOT IN ("
                             + "SELECT DISTINCT ob.company.id FROM OpeningBalance ob WHERE ob.year  = ? AND ob.month = ?"
                        + ")", year, month);
    }

    @Override
    public List<Object[]> getCreatedByAfterDate(Date date) {
        return this.dao.listHQL("SELECT c.code,c.ruc,c.path,c.name,c.city,c.igvPercent,c.title,c.address,c.buy,c.stored,c.sold,c.privateTransportDescription,c.privateDriverLicense,c.active FROM Company c WHERE c.createDate > ?  ORDER BY c.createDate", new Object[]{date});
    }

    @Override
    public List<Object[]> getEditedByAfterDate(Date date, boolean withCreated) {
        return this.dao.listHQL("SELECT c.code,c.ruc,c.path,c.name,c.city,c.igvPercent,c.title,c.address,c.buy,c.stored,c.sold,c.privateTransportDescription,c.privateDriverLicense,c.active FROM Company c WHERE c.createDate < ?  AND c.editDate > ?  ORDER BY c.createDate", new Object[]{date, date});
    }

    @Override
    public List<Object[]> getBasicData() {
        return dao.listHQL("SELECT c.id,c.name,c.city,c.address FROM Company c WHERE c.active = true ORDER BY c.code");
    }
}
