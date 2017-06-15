/*    */ package cs.bms.dao;
/*    */ 
/*    */ import cs.bms.dao.interfac.IUoMDao;
/*    */ import cs.bms.model.UoM;
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
/*    */ public class UoMDao
/*    */   extends GenericDao<UoM, Integer>
/*    */   implements IUoMDao
/*    */ {
/*    */   public boolean existName(String name, Integer exception)
/*    */   {
/* 21 */     Query query = getSessionFactory().getCurrentSession().createQuery("SELECT 1 FROM UoM uom WHERE uom.name LIKE :name AND uom.id <> :id");
/* 22 */     query.setString("name", name);
/* 23 */     query.setInteger("id", exception == null ? -1 : exception.intValue());
/* 24 */     return query.uniqueResult() != null;
/*    */   }
/*    */   
/*    */   public boolean existAbbr(String abbr, Integer exception)
/*    */   {
/* 29 */     Query query = getSessionFactory().getCurrentSession().createQuery("SELECT 1 FROM UoM uom WHERE uom.abbr LIKE :abbr AND uom.id <> :id");
/* 30 */     query.setString("abbr", abbr);
/* 31 */     query.setInteger("id", exception == null ? -1 : exception.intValue());
/* 32 */     return query.uniqueResult() != null;
/*    */   }
/*    */   
/*    */   public boolean existCode(String code, Integer exception) {
/* 36 */     Query query = getSessionFactory().getCurrentSession().createQuery("SELECT 1 FROM UoM uom WHERE uom.code LIKE :code AND uom.id <> :id");
/* 37 */     query.setString("code", code);
/* 38 */     query.setInteger("id", exception == null ? -1 : exception.intValue());
/* 39 */     return query.uniqueResult() != null;
/*    */   }
/*    */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\dao\UoMDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */