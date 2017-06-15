/*    */ package cs.bms.dao;
/*    */ 
/*    */ import cs.bms.dao.interfac.ICashRegisterDetailDao;
/*    */ import cs.bms.enumerated.CashType;
/*    */ import cs.bms.model.CashRegisterDetail;
/*    */ import gkfire.hibernate.generic.GenericDao;
/*    */ import java.io.Serializable;
/*    */ import org.hibernate.Query;
/*    */ import org.hibernate.Session;
/*    */ import org.hibernate.SessionFactory;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CashRegisterDetailDao
/*    */   extends GenericDao<CashRegisterDetail, Serializable>
/*    */   implements ICashRegisterDetailDao
/*    */ {
/*    */   public Integer getQuantity(Long cashRegisterId, CashType type)
/*    */   {
/* 23 */     Query query = getSessionFactory().getCurrentSession().createQuery("SELECT crd.quantity FROM CashRegisterDetail crd WHERE crd.cashRegister.id = ? AND crd.cashType = ?");
/*    */     
/*    */ 
/*    */ 
/* 27 */     query.setLong(0, cashRegisterId == null ? -1L : cashRegisterId.longValue());
/* 28 */     query.setParameter(1, type);
/* 29 */     return (Integer)query.uniqueResult();
/*    */   }
/*    */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\dao\CashRegisterDetailDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */