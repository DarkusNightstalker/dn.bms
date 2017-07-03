/*    */ package cs.bms.dao;
/*    */ 
/*    */ import cs.bms.dao.interfac.IElectronicBookCategoryDao;
/*    */ import cs.bms.model.ElectronicBookCategory;
/*    */ import gkfire.hibernate.generic.GenericDao;
/*    */ import org.hibernate.Query;
/*    */ import org.hibernate.Session;
/*    */ import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
@Repository
/*    */ public class ElectronicBookCategoryDao
/*    */   extends GenericDao<ElectronicBookCategory, Short>
/*    */   implements IElectronicBookCategoryDao
/*    */ {
/*    */   public boolean existCode(String code, Short id)
/*    */   {
/* 21 */     Query query = getSessionFactory().getCurrentSession().createQuery("SELECT 1 FROM ElectronicBookCategory ebc WHERE ebc.code LIKE :code AND ebc.id != :id");
/* 22 */     query.setString("code", code);
/* 23 */     query.setLong("id", id == null ? -1L : id.shortValue());
/*    */     
/* 25 */     return query.uniqueResult() != null;
/*    */   }
/*    */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\dao\ElectronicBookCategoryDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */