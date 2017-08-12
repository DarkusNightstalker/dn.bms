package cs.bms.service;

import cs.bms.dao.interfac.IIdentityDocumentDao;
import cs.bms.model.IdentityDocument;
import cs.bms.service.interfac.IIdentityDocumentService;
import gkfire.hibernate.generic.GenericService;
import gkfire.hibernate.generic.interfac.IGenericDao;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class IdentityDocumentService extends GenericService<IdentityDocument, Short> implements IIdentityDocumentService {

    @Autowired
    @Qualifier("identityDocumentDao")
    private IIdentityDocumentDao dao;

    @Override
    public String getClassName() {
        return "IdentityDocument";
    }

    @Override
    protected IGenericDao<IdentityDocument, Short> getBasicDao() {
        return this.dao;
    }

    @Override
    public boolean validCode(String code, Short id) {
        return this.dao.getByHQL(""
                + "SELECT "
                    + "1 "
                + "FROM IdentityDocument idd "
                + "WHERE "
                    + "idd.code LIKE ? AND "
                    + "idd.id <> ?", code.trim(), (id == null ? new Short("-1") : id)) == null;
    }

    @Override
    public List<Object[]> getBasicData() {
        return this.dao.listHQL(""
                + "SELECT "
                    + "idd.id,"
                    + "idd.abbr,"
                    + "idd.name "
                + "FROM IdentityDocument idd "
                + "WHERE idd.active = true "
                + "ORDER BY idd.code");
    }

    @Override
    public Short getIdByLength(int length) {
        return (Short) this.dao.getByHQL(""
                + "SELECT "
                    + "idd.id "
                + "FROM IdentityDocument idd "
                + "WHERE idd.length_ = ?", Short.valueOf("" + length));
    }

    @Override
    public List<Object[]> getCreateByAfterDate(Date init,Date end) {
        return this.dao.listHQL(""
                + "SELECT "
                    + "idd.code,"
                    + "idd.abbr,"
                    + "idd.name,"
                    + "idd.length_,"
                    + "idd.createUser.username,"
                    + "idd.createDate,"
                    + "e.username,"
                    + "idd.editDate,"
                    + "idd.active "
                + "FROM IdentityDocument idd left join idd.editUser e "
                + "WHERE idd.createDate >= ? AND idd.createDate < ?", init,end);
    }

    @Override
    public List<Object[]> getEditedByAfterDate(Date init,Date end, boolean b) {
        return this.dao.listHQL(""
                + "SELECT "
                    + "idd.code,"
                    + "idd.abbr,"
                    + "idd.name,"
                    + "idd.length_,"
                    + "idd.createUser.username,"
                    + "idd.createDate,"
                    + "e.username,"
                    + "idd.editDate,"
                    + "idd.active "
                + "FROM IdentityDocument idd left join idd.editUser e "
                + "WHERE "
                    + "(idd.createDate < ? OR idd.createDate >= ?) AND "
                    + "idd.editDate >= ? AND idd.editDate < ?",init, end,init, end);
    }

    @Override
    public Short getIdByCode(String code) {
        return (Short) this.dao.getByHQL(""
                + "SELECT "
                + "idd.id "
                + "FROM IdentityDocument idd "
                + "WHERE idd.code LIKE ?",code);
    }
}
