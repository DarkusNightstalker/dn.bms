/*    */ package cs.bms.service;
/*    */ 
/*    */ import cs.bms.dao.interfac.ISalePaymentDao;
/*    */ import cs.bms.model.Company;
/*    */ import cs.bms.model.SalePayment;
/*    */ import cs.bms.service.interfac.ISalePaymentService;
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
/*    */ public class SalePaymentService
/*    */   extends GenericService<SalePayment, Long>
/*    */   implements ISalePaymentService
/*    */ {
/*    */   @Autowired
/*    */   @Qualifier("salePaymentDao")
/*    */   private ISalePaymentDao dao;
/*    */   
/*    */   protected IGenericDao<SalePayment, Long> getDao()
/*    */   {
/* 31 */     return this.dao;
/*    */   }
/*    */   
/*    */   public BigDecimal getSumAfterByCompany(Date date, Company company)
/*    */   {
/* 36 */     if (date != null) {
/* 37 */       return (BigDecimal)this.dao.getByHQL("SELECT COALESCE(SUM(sp.quantity),0) FROM SalePayment sp WHERE sp.sale.active = true AND sp.sale.verified = true AND sp.datePayment > ? AND sp.sale.company = ?", new Object[] { date, company });
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 42 */     return (BigDecimal)this.dao.getByHQL("SELECT COALESCE(SUM(sp.quantity),0) FROM SalePayment sp WHERE sp.sale.active = true AND sp.sale.verified = true AND sp.sale.company = ?", new Object[] { company });
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public BigDecimal getCreditAfterByCompany(Date date, Company company)
/*    */   {
/* 51 */     if (date != null) {
/* 52 */       return (BigDecimal)this.dao.getByHQL("SELECT COALESCE(SUM(s.subtotal+s.igv-s.subtotalDiscount-s.igvDiscount-(SELECT COALESCE(SUM(sp.quantity),0) FROM SalePayment sp WHERE sp.sale.id = s.id )),0) FROM Sale s WHERE s.active = true AND s.verified = true AND s.dateIssue > ? AND s.visa = false AND s.company = ?", new Object[] { date, company });
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 57 */     return (BigDecimal)this.dao.getByHQL("SELECT COALESCE(SUM(s.subtotal+s.igv-s.subtotalDiscount-s.igvDiscount-(SELECT COALESCE(SUM(sp.quantity),0) FROM SalePayment sp WHERE sp.sale.id = s.id )),0) FROM Sale s WHERE s.active = true AND s.verified = true AND s.visa = false AND s.company = ?", new Object[] { company });
/*    */   }
/*    */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\service\SalePaymentService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */