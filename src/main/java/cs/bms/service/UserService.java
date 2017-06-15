package cs.bms.service;

import cs.bms.dao.interfac.IUserDao;
import cs.bms.model.User;
import cs.bms.service.interfac.IUserService;
import gkfire.hibernate.generic.GenericService;
import gkfire.hibernate.generic.interfac.IGenericDao;
import gkfire.util.AES;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class UserService extends GenericService<User, Integer> implements IUserService {

    @Autowired
    @Qualifier("userDao")
    private IUserDao dao;

    @Override
    public User login(String username, String password)
            throws Exception {
        return this.dao.login(username, password);
    }

    @Override
    public Integer getNextId() {
        return this.dao.getNextId();
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
        return (String) this.dao.getByHQL("SELECT e.createUser.username FROM " + clazz.getSimpleName() + " e WHERE e.id = ?", new Object[]{id});
    }

    @Override
    public User getCreator(Class clazz, Serializable id) {
        return (User) this.dao.getByHQL("SELECT e.createUser FROM " + clazz.getSimpleName() + " e WHERE e.id = ?", new Object[]{id});
    }

    @Override
    public boolean verifyAuthenthication(String username, String password)
            throws Exception {
        return this.dao.getByHQL("SELECT 1 FROM User u WHERE u.username LIKE ? AND u.password LIKE ?", new Object[]{username, AES.encrypt(password, "AyfCIx53fTEuRuYU")}) != null;
    }

    @Override
    public List<Object[]> getCreateByAfterDate(Date paramDate, String paramString) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Object[]> getEditedByAfterDate(Date paramDate, String paramString, boolean paramBoolean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
