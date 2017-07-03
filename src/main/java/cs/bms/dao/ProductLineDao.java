/*    */ package cs.bms.dao;
/*    */ 
/*    */ import cs.bms.dao.interfac.IProductLineDao;
/*    */ import cs.bms.model.ProductLine;
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
/*    */ public class ProductLineDao
/*    */   extends GenericDao<ProductLine, Integer>
/*    */   implements IProductLineDao
/*    */ {
/*    */   public boolean existPath(String path, Integer exception)
/*    */   {
/* 21 */     Query query = getSessionFactory().getCurrentSession().createQuery("SELECT 1 FROM ProductLine pl WHERE pl.path LIKE :path ANND pl.id <> :id");
/* 22 */     query.setString("path", path);
/* 23 */     query.setInteger("id", exception == null ? -1 : exception.intValue());
/* 24 */     return query.uniqueResult() != null;
/*    */   }
/*    */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\dao\ProductLineDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */