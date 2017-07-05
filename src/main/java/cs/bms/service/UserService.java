package cs.bms.service;

import cs.bms.dao.interfac.IUserDao;
import cs.bms.model.User;
import cs.bms.service.interfac.IUserService;
import cs.bms.util.AESKeys;
import gkfire.auditory.AuditoryEntity;
import gkfire.hibernate.generic.GenericService;
import gkfire.hibernate.generic.interfac.IGenericDao;
import gkfire.util.AES;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserService extends GenericService<User, Integer> implements IUserService {

    @Autowired
    @Qualifier("userDao")
    private IUserDao dao;

    @Override
    public User login(String username, String password)  throws Exception {
        return this.dao.login(username, password);
    }


    @Override
    public boolean existUsername(String username, Integer id) {
        return this.dao.existUsername(username, id);
    }

    @Override
    protected IGenericDao<User, Integer> getDao() {
        return this.dao;
    }

    @Override
    public String getCreatorUsername(Class clazz, Serializable id) {
        return (String) this.dao.getByHQL(""
                + "SELECT "
                    + "e.createUser.username "
                + "FROM " + clazz.getSimpleName() + " e "
                + "WHERE e.id = ?", id);
    }

    @Override
    public User getCreator(Class clazz, Serializable id) {
        return (User) this.dao.getByHQL(""
                + "SELECT "
                    + "e.createUser "
                + "FROM " + clazz.getSimpleName() + " e "
                + "WHERE e.id = ?", id);
    }

    @Override
    public boolean verifyAuthenthication(String username, String password) throws Exception {
        return this.dao.getByHQL(""
                + "SELECT "
                    + "1 "
                + "FROM User u "
                + "WHERE "
                    + "u.username LIKE ? AND "
                    + "u.password LIKE ? AND u.active = true", username, AES.encrypt(password, AESKeys.USER_PASSWORD)) != null;
    }

    @Override
    public List<Object[]> getCreateByAfterDate(Date date, String paramString) {
        return this.dao.listHQL(""
                + "SELECT "
                    + "u.id,"
                    + "u.username,"
                    + "u.password,"
                    + "u.lastLogin,"
                    + "u.superUser,"
                    + "u.employee.id,"
                    + "u.employee.identityNumber,"
                    + "u.active,"
                    + "u.createUser.id,"
                    + "u.createDate "
                + "FROM User u "
                + "WHERE u.createDate > ?", date);
    }

    @Override
    public List<Object[]> getEditedByAfterDate(Date date, String companyCode, boolean b) {
         return this.dao.listHQL(""
                + "SELECT "
                    + "u.id,"
                    + "u.username,"
                    + "u.password,"
                    + "u.lastLogin,"
                    + "u.superUser,"
                    + "u.employee.id,"
                    + "u.employee.identityNumber,"
                    + "u.active,"
                    + "u.createUser.id,"
                    + "u.createDate,"
                    + "u.editUser.id,"
                    + "u.editDate "
                + "FROM User u "
                + "WHERE u.createDate < ? AND u.editDate > ?", date,date);
    }

    @Override
    public boolean authorize(String username,String password, String codePermission) throws Exception{
           return ((Number)this.dao.getByHQL(""
                + "SELECT "
                    + "COUNT(u.id) "
                + "FROM User u  "
                + "WHERE "
                    + "u.username LIKE ? AND "
                    + "u.password LIKE ? AND "
                    + "u.active = true AND "
                    + "(? IN ("
                        + "SELECT "
                            + "p.code "
                        + "FROM User u_  "
                            + "join u_.rols r "
                            + "join r.permissions p "
                        + "WHERE u_.id = u.id"
                   + ") OR u.superUser = true)", username, AES.encrypt(password, AESKeys.USER_PASSWORD),codePermission)).intValue() != 0;
     
    }

    @Override
    public Object[] getCreatedBasicData(AuditoryEntity entity) {
        return (Object[]) dao.getByHQL("SELECT e.createUser.id,e.createDate FROM "+entity.getClass().getSimpleName()+" e WHERE e.id = ?",entity.getId());
    }

    @Override
    public Integer getIdByUsername(String username) {
         return (Integer) dao.getByHQL("SELECT u.id FROM User u WHERE u.username = ?",username);
   }
}
