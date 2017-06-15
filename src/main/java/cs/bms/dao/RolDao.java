/*    */ package cs.bms.dao;
/*    */ 
/*    */ import cs.bms.dao.interfac.IRolDao;
/*    */ import cs.bms.model.Rol;
/*    */ import gkfire.hibernate.generic.GenericDao;
/*    */ import org.hibernate.Query;
/*    */ import org.hibernate.Session;
/*    */ import org.hibernate.SessionFactory;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RolDao
/*    */   extends GenericDao<Rol, Integer>
/*    */   implements IRolDao
/*    */ {
/*    */   public boolean existCode(String code, Integer id)
/*    */   {
/* 21 */     Query query = getSessionFactory().getCurrentSession().createQuery("SELECT 1 FROM Rol r WHERE r.code LIKE :code AND r.id != :id");
/* 22 */     query.setString("code", code);
/* 23 */     query.setInteger("id", id == null ? -1 : id.intValue());
/* 24 */     return query.uniqueResult() != null;
/*    */   }
/*    */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\dao\RolDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */