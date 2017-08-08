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
import org.springframework.stereotype.Service;

@Service
public class CompanyService extends GenericService<Company, Integer> implements ICompanyService {

    @Autowired
    @Qualifier("companyDao")
    private ICompanyDao dao;

    @Override
    protected IGenericDao<Company, Integer> getBasicDao() {
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
    public List<Object[]> getCreatedByAfterDate(Date init,Date end) {
        return this.dao.listHQL(""
                + "SELECT "
                    + "c.code,"
                    + "c.ruc,"
                    + "c.companyGroup.name,"
                    + "c.name,"
                    + "c.path,"
                    + "c.title,"
                    + "c.description,"
                    + "c.district.subregion.region.name||'-'||c.district.subregion.name||'-'||c.district.name,"
                    + "c.city,"
                    + "c.address,"
                    + "c.addressReference,"
                    + "c.fax,"
                    + "c.phone1,"
                    + "c.phone2,"
                    + "c.igvPercent,"
                    + "c.privateDriverLicense,"
                    + "c.privateTransportDescription,"
                    + "c.stored,"
                    + "c.sold,"
                    + "c.buy,"
                    + "c.createUser.username,"
                    + "c.createDate,"
                    + "e.username,"
                    + "c.editDate,"
                    + "c.active "
                + "FROM Company c left join c.editUser e "
                + "WHERE "
                    + "c.createDate >= ? AND c.createDate < ?  "
                + "ORDER BY c.createDate", init,end);
    }

    @Override
    public List<Object[]> getEditedByAfterDate(Date init,Date end, boolean withCreated) {
        return this.dao.listHQL(""
                + "SELECT "
                    + "c.code,"
                    + "c.ruc,"
                    + "c.companyGroup.name,"
                    + "c.name,"
                    + "c.path,"
                    + "c.title,"
                    + "c.description,"
                    + "c.district.subregion.region.name||'-'||c.district.subregion.name||'-'||c.district.name,"
                    + "c.city,"
                    + "c.address,"
                    + "c.addressReference,"
                    + "c.fax,"
                    + "c.phone1,"
                    + "c.phone2,"
                    + "c.igvPercent,"
                    + "c.privateDriverLicense,"
                    + "c.privateTransportDescription,"
                    + "c.stored,"
                    + "c.sold,"
                    + "c.buy,"
                    + "c.createUser.username,"
                    + "c.createDate,"
                    + "e.username,"
                    + "c.editDate,"
                    + "c.active "
                + "FROM Company c left join c.editUser e "
                + "WHERE "
                    + "(c.createDate < ? OR c.createDate >= ?) AND "
                    + "c.editDate => ? AND c.editDate < ?"
                + "ORDER BY c.editDate", init, end,init, end);
    }

    @Override
    public List<Object[]> getBasicData() {
        return dao.listHQL(""
                + "SELECT "
                    + "c.id,"
                    + "c.name,"
                    + "c.city,"
                    + "c.address "
                + "FROM Company c "
                + "WHERE c.active = true "
                + "ORDER BY c.code");
    }

    @Override
    public Company getByCode(String code) {
        return (Company) dao.getByHQL("FROM Company c WHERE c.code LIKE ?",code);
    }

    @Override
    public Integer getIdByCode(String code) {
        return (Integer) this.dao.getByHQL("SELECT c.id FROM Company c WHERE c.code LIKE ?",code);
    }
}
