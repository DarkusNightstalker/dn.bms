/*    */ package cs.bms.service;
/*    */ 
/*    */ import cs.bms.dao.interfac.IInternalStockMovementDetailDao;
/*    */ import cs.bms.model.Company;
/*    */ import cs.bms.model.InternalStockMovement;
/*    */ import cs.bms.model.InternalStockMovementDetail;
/*    */ import cs.bms.service.interfac.IInternalStockMovementDetailService;
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
/*    */ 
/*    */ 
/*    */ public class InternalStockMovementDetailService
/*    */   extends GenericService<InternalStockMovementDetail, Long>
/*    */   implements IInternalStockMovementDetailService
/*    */ {
/*    */   @Autowired
/*    */   @Qualifier("internalStockMovementDetailDao")
/*    */   private IInternalStockMovementDetailDao dao;
/*    */   
/*    */   protected IGenericDao<InternalStockMovementDetail, Long> getDao()
/*    */   {
/* 34 */     return this.dao;
/*    */   }
/*    */   
/*    */   public List<Object[]> getRemoveds(List<Long> productDetails, Long id)
/*    */   {
/* 39 */     return this.dao.listHQL("SELECT ismd.id,ismd.quantity,ismd.product.id FROM InternalStockMovementDetail ismd WHERE ismd.product.id NOT IN (:products) AND ismd.internalStockMovement.id = :ism_id", new String[] { "products", "ism_id" }, new Object[] { productDetails, id });
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void restoreStock(InternalStockMovementDetail detail, Company targetCompany, Company sourceCompany)
/*    */   {
/* 50 */     this.dao.updateHQL("UPDATE Stock SET quantity = (quantity - ?) WHERE product = ? AND company = ?", new Object[] { detail.getQuantity(), detail.getProduct(), targetCompany });
/* 51 */     this.dao.updateHQL("UPDATE Stock SET quantity = (quantity + ?) WHERE product = ? AND company = ?", new Object[] { detail.getQuantity(), detail.getProduct(), sourceCompany });
/*    */   }
/*    */   
/*    */ 
/*    */   public List<Object[]> getDataForManage(InternalStockMovement ism)
/*    */   {
/* 57 */     return this.dao.listHQL("SELECT ismd.quantity,ismd.product.id,ismd.unitCost FROM InternalStockMovementDetail ismd WHERE ismd.internalStockMovement = ?", new Object[] { ism });
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public BigDecimal getQuantityById(Long id)
/*    */   {
/* 67 */     return (BigDecimal)this.dao.getByHQL("SELECT ismd.quantity FROM InternalStockMovementDetail ismd WHERE ismd.id = ?", new Object[] { id });
/*    */   }
/*    */   
/*    */   public BigDecimal getUnitCostById(Long id)
/*    */   {
/* 72 */     return (BigDecimal)this.dao.getByHQL("SELECT ismd.unitCost FROM InternalStockMovementDetail ismd WHERE ismd.id = ?", new Object[] { id });
/*    */   }
/*    */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\service\InternalStockMovementDetailService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */