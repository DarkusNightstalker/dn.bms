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
import org.springframework.stereotype.Service;

@Service
public class RolService extends GenericService<Rol, Integer> implements IRolService {

    @Autowired
    @Qualifier("rolDao")
    private IRolDao dao;

    @Override
    public boolean existCode(String code, Integer id) {
        return this.dao.existCode(code, id);
    }

    @Override
    protected IGenericDao<Rol, Integer> getBasicDao() {
        return this.dao;
    }

    @Override
    public List<Object[]> getCreateByAfterDate(Date init,Date end) {
        return this.dao.listHQL(""
                + "SELECT "
                    + "r.name,"
                    + "r.active,"
                    + "r.createUser.username,"
                    + "r.createDate,"
                    + "e.username,"
                    + "r.editDate "
                + "FROM Rol r left join r.editUser e "
                + "WHERE r.createDate >= ? AND r.createDate < ?", init,end);        
    }

    @Override
    public List<Object[]> getEditedByAfterDate(Date init,Date end, boolean b) {
        return this.dao.listHQL(""
                + "SELECT "
                    + "r.name,"
                    + "r.active,"
                    + "r.createUser.username,"
                    + "r.createDate,"
                    + "e.username,"
                    + "r.editDate "
                + "FROM Rol r left join r.editUser e "
                + "WHERE "
                    + "(r.createDate < ? OR r.createDate >= ?) AND "
                    + "(r.editDate >= ? AND r.editDate < ?)", init, end,init,end);
    
    }

    @Override
    public Integer getIdByName(String name) {
        return (Integer) dao.getByHQL("SELECT r.id FROM Rol r WHERE r.name LIKE ?",name);
    }
}
