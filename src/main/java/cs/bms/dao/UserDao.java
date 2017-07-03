package cs.bms.dao;

import cs.bms.dao.interfac.IUserDao;
import cs.bms.model.User;
import gkfire.hibernate.generic.GenericDao;
import gkfire.util.AES;
import java.math.BigInteger;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao extends GenericDao<User, Integer> implements IUserDao {

    @Override
    public User login(String username, String password)
            throws Exception {
        Query query = getSessionFactory().getCurrentSession().createQuery("SELECT u FROM User u WHERE u.username LIKE :username AND u.password LIKE :password");
        query.setString("username", username);
        query.setString("password", AES.encrypt(password, "AyfCIx53fTEuRuYU"));
        return (User) query.uniqueResult();
    }

    @Override
    public Integer getNextId() {
        return ((BigInteger) getSessionFactory().getCurrentSession().createSQLQuery("SELECT (last_value+1) FROM user_id_seq").uniqueResult()).intValue();
    }

    @Override
    public boolean existUsername(String username, Integer id) {
        Query query = getSessionFactory().getCurrentSession().createQuery("SELECT 1 FROM User u WHERE u.username LIKE :username AND u.id != :id");
        query.setString("username", username);
        query.setInteger("id", id == null ? -1 : id);
        return query.uniqueResult() != null;
    }
}
