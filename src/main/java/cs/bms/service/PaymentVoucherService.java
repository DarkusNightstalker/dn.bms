/*    */ package cs.bms.service;
/*    */ 
/*    */ import cs.bms.dao.interfac.IPaymentVoucherDao;
/*    */ import cs.bms.model.CashRegister;
/*    */ import cs.bms.model.Company;
/*    */ import cs.bms.model.PaymentVoucher;
/*    */ import cs.bms.model.Sale;
/*    */ import cs.bms.service.interfac.IPaymentVoucherService;
/*    */ import gkfire.hibernate.generic.GenericService;
/*    */ import gkfire.hibernate.generic.interfac.IGenericDao;
/*    */ import java.util.Collections;
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
/*    */ 
/*    */ public class PaymentVoucherService
/*    */   extends GenericService<PaymentVoucher, Long>
/*    */   implements IPaymentVoucherService
/*    */ {
/*    */   @Autowired
/*    */   @Qualifier("paymentVoucherDao")
/*    */   private IPaymentVoucherDao dao;
/*    */   
/*    */   protected IGenericDao<PaymentVoucher, Long> getDao()
/*    */   {
/* 35 */     return this.dao;
/*    */   }
/*    */   
/*    */   public List<Object[]> getBasicDataByCashRegister(CashRegister cashRegister)
/*    */   {
/* 40 */     return Collections.EMPTY_LIST;
/*    */   }
/*    */   
/*    */   public Long getNextNumerationByPrefix(String prefix)
/*    */   {
/* 45 */     List result = this.dao.listHQLPage("SELECT pv.numeration FROM PaymentVoucher pv WHERE pv.numeration LIKE ? ORDER BY  numeration_format(pv.numeration,'" + prefix + "') DESC", 1, 1, new Object[] { prefix + "%" });
/* 46 */     if (result.isEmpty()) {
/* 47 */       return Long.valueOf(1L);
/*    */     }
/* 49 */     return Long.valueOf(Long.parseLong(result.get(0).toString().replace(prefix, "")) + 1L);
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean verifyNumeration(String code)
/*    */   {
/* 55 */     return this.dao.getByHQL("SELECT 1 FROM PaymentVoucher pv WHERE pv.sale is not null AND pv.numeration LIKE ?", new Object[] { code }) != null;
/*    */   }
/*    */   
/*    */   public boolean existNumeration(String code)
/*    */   {
/* 60 */     return this.dao.getByHQL("SELECT 1 FROM PaymentVoucher pv WHERE pv.numeration LIKE ?", new Object[] { code }) != null;
/*    */   }
/*    */   
/*    */   public Integer getValueByCode(String code)
/*    */   {
/* 65 */     return (Integer)this.dao.getByHQL("SELECT pv.value FROM PaymentVoucher pv WHERE pv.numeration LIKE ?", new Object[] { code });
/*    */   }
/*    */   
/*    */   public void useVoucher(String code, Long saleId)
/*    */   {
/* 70 */     this.dao.updateHQL("UPDATE PaymentVoucher SET sale = ? WHERE numeration like ?", new Object[] { new Sale(saleId), code });
/*    */   }
/*    */   
/*    */   public Integer getTotalSumAfterByCompany(Date date, Company company)
/*    */   {
/* 75 */     if (date != null) {
/* 76 */       return Integer.valueOf(((Long)this.dao.getByHQL("SELECT COALESCE(SUM(pv.value),0) FROM PaymentVoucher pv WHERE  pv.sale.active = true AND pv.sale.verified = true AND  pv.sale.dateIssue > ? AND pv.sale.visa = false and pv.sale.company = ?", new Object[] { date, company }))
/*    */       
/* 78 */         .intValue());
/*    */     }
/*    */     
/* 81 */     return Integer.valueOf(((Long)this.dao.getByHQL("SELECT COALESCE(SUM(pv.value),0) FROM PaymentVoucher s WHERE  pv.sale.active = true AND pv.sale.verified = true  AND pv.sale.visa = false and pv.sale.company = ?", new Object[] { company }))
/*    */     
/* 83 */       .intValue());
/*    */   }
/*    */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\service\PaymentVoucherService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */