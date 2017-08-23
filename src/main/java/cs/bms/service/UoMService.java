package cs.bms.service;

import cs.bms.dao.interfac.IUoMDao;
import cs.bms.model.UoM;
import cs.bms.service.interfac.IUoMService;
import gkfire.hibernate.generic.GenericService;
import gkfire.hibernate.generic.interfac.IGenericDao;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author Darkus Nightmare
 * @version 1.0
 */
@Service("uomService")
public class UoMService extends GenericService<UoM, Integer> implements IUoMService {

    @Autowired
    @Qualifier("uomDao")
    private IUoMDao dao;

    @Override
    protected IGenericDao<UoM, Integer> getBasicDao() {
        return this.dao;
    }

    @Override
    public boolean existName(String name, Integer exception) {
        return this.dao.existName(name, exception);
    }

    @Override
    public boolean existAbbr(String abbr, Integer exception) {
        return this.dao.existAbbr(abbr, exception);
    }

    @Override
    public boolean existCode(String code, Integer exception) {
        return this.dao.existCode(code, exception);
    }

    @Override
    public Integer getIdByCode(String code) {
        return (Integer) this.dao.getByHQL(""
                + "SELECT "
                    + "uom.id "
                + "FROM UoM uom "
                + "WHERE uom.code LIKE ?", new Object[]{code});
    }

    @Override
    public List<Object[]> getBasicData() {
        return this.dao.listHQL(""
                + "SELECT "
                    + "uom.id,"
                    + "uom.abbr,"
                    + "uom.name "
                + "FROM UoM uom "
                + "WHERE uom.active = true");
    }

    @Override
    public List<Object[]> getCreatedByAfterDate(Date init,Date end) {
        return this.dao.listHQL(""
                + "SELECT "
                    + "uom.code,"
                    + "uom.abbr,"
                    + "uom.name,"
                    + "uom.createUser.username,"
                    + "uom.createDate,"
                    + "e.username,"
                    + "uom.editDate,"
                    + "uom.active "
                + "FROM UoM uom left join uom.editUser e "
                + "WHERE "
                    + "uom.createDate >= ? AND uom.createDate < ? "
                + "ORDER BY uom.createDate", init,end);
    }

    @Override
    public List<Object[]> getEditedByAfterDate(Date init,Date end, boolean b) {
        return this.dao.listHQL(""
                + "SELECT "
                    + "uom.code,"
                    + "uom.abbr,"
                    + "uom.name,"
                    + "uom.createUser.username,"
                    + "uom.createDate,"
                    + "e.username,"
                    + "uom.editDate,"
                    + "uom.active "
                + "FROM UoM uom left join uom.editUser e "
                + "WHERE "
                    + "(uom.editDate >= ? AND uom.editDate < ?) AND "
                    + "(uom.createDate < ? OR uom.createDate >=?  )"
                + "ORDER BY uom.editDate", init,end,init,end);
    }
}
