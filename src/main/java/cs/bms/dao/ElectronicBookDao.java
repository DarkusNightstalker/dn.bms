/*    */ package cs.bms.dao;
/*    */ 
/*    */ import cs.bms.dao.interfac.IElectronicBookDao;
/*    */ import cs.bms.model.ElectronicBook;
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
/*    */ public class ElectronicBookDao
/*    */   extends GenericDao<ElectronicBook, Short>
/*    */   implements IElectronicBookDao
/*    */ {
/*    */   public boolean existCode(String code, Short id)
/*    */   {
/* 21 */     Query query = getSessionFactory().getCurrentSession().createQuery("SELECT 1 FROM ElectronicBook eb WHERE eb.code LIKE :code AND eb.id != :id");
/* 22 */     query.setString("code", code);
/* 23 */     query.setLong("id", id == null ? -1L : id.shortValue());
/*    */     
/* 25 */     return query.uniqueResult() != null;
/*    */   }
/*    */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\dao\ElectronicBookDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */