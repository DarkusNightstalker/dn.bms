/*    */ package cs.bms.service;
/*    */ 
/*    */ import cs.bms.dao.interfac.IPurchaseDetailDao;
/*    */ import cs.bms.model.PurchaseDetail;
/*    */ import cs.bms.service.interfac.IPurchaseDetailService;
/*    */ import gkfire.hibernate.generic.GenericService;
/*    */ import gkfire.hibernate.generic.interfac.IGenericDao;
/*    */ import java.math.BigDecimal;
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
/*    */ public class PurchaseDetailService
/*    */   extends GenericService<PurchaseDetail, Long>
/*    */   implements IPurchaseDetailService
/*    */ {
/*    */   @Autowired
/*    */   @Qualifier("purchaseDetailDao")
/*    */   private IPurchaseDetailDao dao;
/*    */   
/*    */   protected IGenericDao<PurchaseDetail, Long> getDao()
/*    */   {
/* 29 */     return this.dao;
/*    */   }
/*    */   
/*    */   public BigDecimal getQuantityById(Long id)
/*    */   {
/* 34 */     return (BigDecimal)this.dao.getByHQL("SELECT pd.quantity FROM PurchaseDetail pd WHERE pd.id = ?", new Object[] { id });
/*    */   }
/*    */   
/*    */   public BigDecimal getUnitCostById(Long id)
/*    */   {
/* 39 */     return (BigDecimal)this.dao.getByHQL("SELECT pd.unitPrice FROM PurchaseDetail pd WHERE pd.id = ?", new Object[] { id });
/*    */   }
/*    */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\service\PurchaseDetailService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */