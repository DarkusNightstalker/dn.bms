/*    */ package cs.bms.dao;
/*    */ 
/*    */ import cs.bms.dao.interfac.IUserDao;
/*    */ import cs.bms.model.User;
/*    */ import gkfire.hibernate.generic.GenericDao;
/*    */ import gkfire.util.AES;
/*    */ import java.math.BigInteger;
/*    */ import org.hibernate.Query;
/*    */ import org.hibernate.SQLQuery;
/*    */ import org.hibernate.Session;
/*    */ import org.hibernate.SessionFactory;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class UserDao
/*    */   extends GenericDao<User, Integer>
/*    */   implements IUserDao
/*    */ {
/*    */   public User login(String username, String password)
/*    */     throws Exception
/*    */   {
/* 23 */     Query query = getSessionFactory().getCurrentSession().createQuery("SELECT u FROM User u WHERE u.username LIKE :username AND u.password LIKE :password");
/* 24 */     query.setString("username", username);
/* 25 */     query.setString("password", AES.encrypt(password, "AyfCIx53fTEuRuYU"));
/* 26 */     return (User)query.uniqueResult();
/*    */   }
/*    */   
/*    */   public Integer getNextId() {
/* 30 */     return Integer.valueOf(((BigInteger)getSessionFactory().getCurrentSession().createSQLQuery("SELECT (last_value+1) FROM user_id_seq").uniqueResult()).intValue());
/*    */   }
/*    */   
/*    */   public boolean existUsername(String username, Integer id)
/*    */   {
/* 35 */     Query query = getSessionFactory().getCurrentSession().createQuery("SELECT 1 FROM User u WHERE u.username LIKE :username AND u.id != :id");
/* 36 */     query.setString("username", username);
/* 37 */     query.setInteger("id", id == null ? -1 : id.intValue());
/* 38 */     return query.uniqueResult() != null;
/*    */   }
/*    */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\dao\UserDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */