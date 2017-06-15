/*    */ package cs.bms.service;
/*    */ 
/*    */ import cs.bms.dao.interfac.ISaleDetailDao;
/*    */ import cs.bms.model.Sale;
/*    */ import cs.bms.model.SaleDetail;
/*    */ import cs.bms.service.interfac.ISaleDetailService;
/*    */ import gkfire.hibernate.generic.GenericService;
/*    */ import gkfire.hibernate.generic.interfac.IGenericDao;
/*    */ import java.math.BigDecimal;
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
/*    */ public class SaleDetailService
/*    */   extends GenericService<SaleDetail, Long>
/*    */   implements ISaleDetailService
/*    */ {
/*    */   @Autowired
/*    */   @Qualifier("saleDetailDao")
/*    */   private ISaleDetailDao dao;
/*    */   
/*    */   protected IGenericDao<SaleDetail, Long> getDao()
/*    */   {
/* 31 */     return this.dao;
/*    */   }
/*    */   
/*    */   public List<Object[]> getBasicDataBySale(Sale sale)
/*    */   {
/* 36 */     return this.dao.listHQL("SELECT sd.productName,sd.quantity,sd.uom.abbr,sd.unitPrice,sd.subtotal FROM SaleDetail sd WHERE sd.sale = ?", new Object[] { sale });
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public BigDecimal getQuantityById(Long id)
/*    */   {
/* 47 */     return (BigDecimal)this.dao.getByHQL("SELECT sd.quantity FROM SaleDetail sd WHERE sd.id = ?", new Object[] { id });
/*    */   }
/*    */   
/*    */   public List<Object[]> getProductDataBySale(Sale sale)
/*    */   {
/* 52 */     return this.dao.listHQL("SELECT sd.product.id,sd.quantity FROM SaleDetail sd WHERE sd.sale = ?", new Object[] { sale });
/*    */   }
/*    */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\service\SaleDetailService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */