/*    */ package cs.bms.service;
/*    */ 
/*    */ import cs.bms.dao.interfac.IPurchasePaymentDao;
/*    */ import cs.bms.model.Company;
/*    */ import cs.bms.model.PurchasePayment;
/*    */ import cs.bms.service.interfac.IPurchasePaymentService;
/*    */ import gkfire.hibernate.generic.GenericService;
/*    */ import gkfire.hibernate.generic.interfac.IGenericDao;
/*    */ import java.math.BigDecimal;
/*    */ import java.util.Date;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.beans.factory.annotation.Qualifier;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PurchasePaymentService
/*    */   extends GenericService<PurchasePayment, Long>
/*    */   implements IPurchasePaymentService
/*    */ {
/*    */   @Autowired
/*    */   @Qualifier("purchasePaymentDao")
/*    */   private IPurchasePaymentDao dao;
/*    */   
/*    */   protected IGenericDao<PurchasePayment, Long> getDao()
/*    */   {
/* 31 */     return this.dao;
/*    */   }
/*    */   
/*    */   public BigDecimal getSumAfterByCompany(Date date, Company company)
/*    */   {
/* 36 */     if (date != null) {
/* 37 */       return (BigDecimal)this.dao.getByHQL("SELECT COALESCE(SUM(pp.quantity),0) FROM PurchasePayment pp WHERE pp.active = true AND  pp.purchase is null and  pp.datePayment > ? AND pp.companyDisbursement = ?", new Object[] { date, company });
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 42 */     return (BigDecimal)this.dao.getByHQL("SELECT COALESCE(SUM(pp.quantity),0) FROM PurchasePayment pp WHERE pp.active = true AND pp.purchase is null and pp.companyDisbursement = ?", new Object[] { company });
/*    */   }
/*    */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\service\PurchasePaymentService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */