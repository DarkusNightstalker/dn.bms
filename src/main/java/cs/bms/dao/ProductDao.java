/*    */ package cs.bms.dao;
/*    */ 
/*    */ import cs.bms.dao.interfac.IProductDao;
/*    */ import org.hibernate.Query;
import org.springframework.stereotype.Repository;
/*    */ 
@Repository
/*    */ public class ProductDao extends gkfire.hibernate.generic.GenericDao<cs.bms.model.Product, Long> implements IProductDao
/*    */ {
/*    */   public boolean existBarCode(String code, Long exception)
/*    */   {
/* 12 */     Query query = getSessionFactory().getCurrentSession().createQuery("SELECT 1 FROM Product p where p.barcode  LIKE :code AND p.id <> :id");
/* 13 */     query.setString("code", code);
/* 14 */     query.setLong("id", exception == null ? -1L : exception.longValue());
/* 15 */     return query.uniqueResult() != null;
/*    */   }
/*    */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\dao\ProductDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */