/*    */ package cs.bms.dao;
/*    */ 
/*    */ import cs.bms.dao.interfac.ISaleDao;
/*    */ import cs.bms.model.Company;
/*    */ import cs.bms.model.Sale;
/*    */ import gkfire.hibernate.generic.GenericDao;
/*    */ import java.util.List;
/*    */ import org.hibernate.Query;
/*    */ import org.hibernate.Session;
/*    */ import org.hibernate.SessionFactory;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SaleDao
/*    */   extends GenericDao<Sale, Long>
/*    */   implements ISaleDao
/*    */ {
/*    */   public List<Object[]> getNotVerifySales(Company company, List<Long> exceptions)
/*    */   {
/* 23 */     Query query = getSessionFactory().getCurrentSession().createQuery("SELECT s.id,s.dateIssue,s.paymentProof.abbr||' '||s.fullDocument,s.customerName,s.subtotal+s.igv-s.subtotalDiscount-s.igvDiscount FROM Sale s WHERE s.company = :company and s.verified = false and s.active = true " + (
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 31 */       !exceptions.isEmpty() ? " and s.id NOT IN (:ids)" : ""));
/* 32 */     query.setEntity("company", company);
/* 33 */     if (!exceptions.isEmpty()) {
/* 34 */       query.setParameterList("ids", exceptions);
/*    */     }
/* 36 */     List<Object[]> data = query.list();
/* 37 */     query = getSessionFactory().getCurrentSession().createQuery("SELECT s.id FROM Sale s WHERE s.company = :company and s.verified = false and s.active = true " + (
/* 38 */       !exceptions.isEmpty() ? " and s.id NOT IN (:ids)" : ""));
/* 39 */     query.setEntity("company", company);
/* 40 */     if (!exceptions.isEmpty()) {
/* 41 */       query.setParameterList("ids", exceptions);
/*    */     }
/* 43 */     exceptions.addAll(query.list());
/* 44 */     return data;
/*    */   }
/*    */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\dao\SaleDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */