/*    */ package cs.bms.service;
/*    */ 
/*    */ import cs.bms.dao.interfac.ISaleDao;
/*    */ import cs.bms.model.Company;
/*    */ import cs.bms.model.Sale;
/*    */ import cs.bms.service.interfac.ISaleService;
/*    */ import gkfire.hibernate.generic.GenericService;
/*    */ import gkfire.hibernate.generic.interfac.IGenericDao;
/*    */ import java.math.BigDecimal;
/*    */ import java.util.Date;
/*    */ import java.util.List;
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
/*    */ public class SaleService
/*    */   extends GenericService<Sale, Long>
/*    */   implements ISaleService
/*    */ {
/*    */   @Autowired
/*    */   @Qualifier("saleDao")
/*    */   private ISaleDao dao;
/*    */   
/*    */   protected IGenericDao<Sale, Long> getDao()
/*    */   {
/* 32 */     return this.dao;
/*    */   }
/*    */   
/*    */   public List<Object[]> getNotVerifySales(Company company, List<Long> exceptions)
/*    */   {
/* 37 */     return this.dao.getNotVerifySales(company, exceptions);
/*    */   }
/*    */   
/*    */   public void verified(Long id, boolean visa)
/*    */   {
/* 42 */     this.dao.updateHQL("UPDATE Sale SET verified=true,visa=? WHERE id = ?", new Object[] { Boolean.valueOf(visa), id });
/*    */   }
/*    */   
/*    */   public BigDecimal getVisaAfterByCompany(Date date, Company company)
/*    */   {
/* 47 */     if (date != null) {
/* 48 */       return (BigDecimal)this.dao.getByHQL("SELECT COALESCE(SUM(s.subtotal+s.igv-s.subtotalDiscount-s.igvDiscount),0) FROM Sale s WHERE  s.active = true AND s.verified = true AND  s.dateIssue > ? AND s.visa = true and s.company = ?", new Object[] { date, company });
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 53 */     return (BigDecimal)this.dao.getByHQL("SELECT COALESCE(SUM(s.subtotal+s.igv-s.subtotalDiscount-s.igvDiscount),0) FROM Sale s WHERE  s.active = true AND s.verified = true  AND s.visa = true and s.company = ?", new Object[] { company });
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void updatePoints(Long points, Long id)
/*    */   {
/* 61 */     this.dao.updateHQL("UPDATE Sale SET points = ? WHERE id = ?", new Object[] { points, id });
/*    */   }
/*    */   
/*    */   public void updateDiscount(BigDecimal discount, Long id)
/*    */   {
/* 66 */     this.dao.updateHQL("UPDATE Sale SET subtotalDiscount = ? WHERE id = ?", new Object[] { discount, id });
/*    */   }
/*    */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\service\SaleService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */