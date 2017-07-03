package cs.bms.service;

import cs.bms.dao.interfac.IRolDao;
import cs.bms.model.Rol;
import cs.bms.service.interfac.IRolService;
import gkfire.hibernate.generic.GenericService;
import gkfire.hibernate.generic.interfac.IGenericDao;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class RolService extends GenericService<Rol, Integer> implements IRolService {

    @Autowired
    @Qualifier("rolDao")
    private IRolDao dao;

    @Override
    public boolean existCode(String code, Integer id) {
        return this.dao.existCode(code, id);
    }

    @Override
    protected IGenericDao<Rol, Integer> getDao() {
        return this.dao;
    }

    @Override
    public List<Object[]> getCreateByAfterDate(Date date) {
        return this.dao.listHQL(""
                + "SELECT "
                    + "r.id,"
                    + "r.name,"
                    + "r.active,"
                    + "r.createUser.id,"
                    + "r.createDate "
                + "FROM Rol r "
                + "WHERE r.createDate > ?", date);        
    }

    @Override
    public List<Object[]> getEditedByAfterDate(Date date, boolean b) {
        return this.dao.listHQL(""
                + "SELECT "
                    + "r.id,"
                    + "r.name,"
                    + "r.active,"
                    + "r.createUser.id,"
                    + "r.createDate,"
                    + "r.editUser.id,"
                    + "r.editDate "
                + "FROM Rol r "
                + "WHERE "
                    + "a.createDate < ? AND "
                    + "a.editDate > ?", date, date);
    
    }
}
