/*    */ package cs.bms.dao;
/*    */ 
/*    */ import cs.bms.dao.interfac.IPaymentProofDao;
/*    */ import cs.bms.model.PaymentProof;
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
/*    */ public class PaymentProofDao
/*    */   extends GenericDao<PaymentProof, Short>
/*    */   implements IPaymentProofDao
/*    */ {
/*    */   public boolean existCode(String code, Short id)
/*    */   {
/* 21 */     Query query = getSessionFactory().getCurrentSession().createQuery("SELECT 1 FROM PaymentProof pp WHERE pp.code LIKE :code AND pp.id != :id");
/* 22 */     query.setString("code", code);
/* 23 */     query.setLong("id", id == null ? -1L : id.shortValue());
/*    */     
/* 25 */     return query.uniqueResult() != null;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public Short getIdByAbbr(String abbr)
/*    */   {
/* 32 */     Query query = getSessionFactory().getCurrentSession().createQuery("SELECT pp.id FROM PaymentProof pp WHERE pp.abbr LIKE ?");
/* 33 */     query.setString(0, abbr);
/* 34 */     return (Short)query.uniqueResult();
/*    */   }
/*    */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\dao\PaymentProofDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */