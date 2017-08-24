package cs.bms.service;

import cs.bms.dao.interfac.IUserDao;
import cs.bms.model.Company;
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
    protected IGenericDao<User, Integer> getBasicDao() {
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
    public List<Object[]> getCreateByAfterDate(Date init,Date end, String code) {
        List<Object[]> data = dao.listHQL(""
                + "SELECT "
                    + "u.username,"
                    + "u.password,"
                    + "u.lastLogin,"
                    + "u.superUser,"
                    + "u.employee.identityNumber,"
                    + "u.createUser.username,"
                    + "u.createDate,"
                    + "e.username,"
                    + "u.editDate,"
                    + "u.id,"
                    + "u.id,"
                    + "u.id,"
                    + "u.active "
                + "FROM User u left join u.editUser e "
                + "WHERE u.createDate >= ? AND u.createDate < ?", init,end);
        data.forEach(item -> {
            item[9] = dao.listHQL("SELECT r.name FROM User u join u.rols r WHERE u.id = ?",item[9]);
            item[10] = dao.listHQL("SELECT dn.rucCompany,dn.paymentProof,dn.serie FROM User u join u.documentNumberings dn WHERE u.id = ?",item[10]);
            item[11] = dao.listHQL("SELECT sp.entityName,sp.identifier FROM User u join u.specialPermissions sp WHERE u.id = ?",item[11]);
        });
        return data;
    }

    @Override
    public List<Object[]> getEditedByAfterDate(Date init,Date end, String companyCode, boolean b) {
        List<Object[]> data = dao.listHQL(""
                + "SELECT "
                    + "u.username,"
                    + "u.password,"
                    + "u.lastLogin,"
                    + "u.superUser,"
                    + "u.employee.identityNumber,"
                    + "u.createUser.username,"
                    + "u.createDate,"
                    + "e.username,"
                    + "u.editDate,"
                    + "u.id,"
                    + "u.id,"
                    + "u.id,"
                    + "u.active "
                + "FROM User u left join u.editUser e "
                + "WHERE "
                    + "(u.createDate < ? OR u.createDate >= ?) AND "
                    + "(u.editDate >= ? AND u.editDate < ?) ", init,end,init,end);
        data.forEach(item -> {
            item[9] = dao.listHQL("SELECT r.name FROM User u join u.rols r WHERE u.id = ?",item[9]);
            item[10] = dao.listHQL("SELECT dn.rucCompany,dn.paymentProof.code,dn.serie FROM User u join u.documentNumberings dn WHERE u.id = ?",item[10]);
            item[11] = dao.listHQL("SELECT sp.entityName,sp.identifier FROM User u join u.specialPermissions sp WHERE u.id = ?",item[11]);
        });
        return data;
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

    @Override
    public boolean havePermissionInCompany(String codeLocalCompany,User user) {
        return dao.getByHQL(""
                + "SELECT "
                + "1  "
                + "FROM SpecialPermission sp "
                + "join sp.users u "
                + "WHERE "
                    + "u.id = ? AND "
                    + "sp.entityName LIKE ? AND "
                    + "sp.identifier IN "
                    + "("
                        + "SELECT "
                        + "c.id "
                        + "FROM Company c "
                        + "WHERE c.code LIKE ?"
                    + ")",user.getId(),Company.class.getSimpleName(),codeLocalCompany) != null;
    }

    @Override
    public User getByUsername(String username) {
        return (User) dao.getByHQL("FROM User u where u.username LIKE ?", username);
    }
}
