/*    */ package cs.bms.service;
/*    */ 
/*    */ import cs.bms.dao.interfac.IOperationTypeDao;
/*    */ import cs.bms.model.OperationType;
/*    */ import cs.bms.service.interfac.IOperationTypeService;
/*    */ import gkfire.hibernate.generic.GenericService;
/*    */ import gkfire.hibernate.generic.interfac.IGenericDao;
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
/*    */ public class OperationTypeService
/*    */   extends GenericService<OperationType, Short>
/*    */   implements IOperationTypeService
/*    */ {
/*    */   @Autowired
/*    */   @Qualifier("operationTypeDao")
/*    */   private IOperationTypeDao dao;
/*    */   
/*    */   protected IGenericDao<OperationType, Short> getDao()
/*    */   {
/* 28 */     return this.dao;
/*    */   }
/*    */   
/*    */   public Short getOpeningBalanceTypeId()
/*    */   {
/* 33 */     return (Short)this.dao.getByHQL("SELECT ot.id FROM OperationType ot WHERE ot.code LIKE ?", new Object[] { "16" });
/*    */   }
/*    */   
/*    */   public Short getSaleTypeId()
/*    */   {
/* 38 */     return (Short)this.dao.getByHQL("SELECT ot.id FROM OperationType ot WHERE ot.code LIKE ?", new Object[] { "01" });
/*    */   }
/*    */   
/*    */   public Short getPurchaseTypeId()
/*    */   {
/* 43 */     return (Short)this.dao.getByHQL("SELECT ot.id FROM OperationType ot WHERE ot.code LIKE ?", new Object[] { "02" });
/*    */   }
/*    */   
/*    */   public Short getISMInTypeId()
/*    */   {
/* 48 */     return (Short)this.dao.getByHQL("SELECT ot.id FROM OperationType ot WHERE ot.code LIKE ?", new Object[] { "21" });
/*    */   }
/*    */   
/*    */   public Short getISMOutTypeId()
/*    */   {
/* 53 */     return (Short)this.dao.getByHQL("SELECT ot.id FROM OperationType ot WHERE ot.code LIKE ?", new Object[] { "11" });
/*    */   }
/*    */   
/*    */   public Short getDecreaseTypeId()
/*    */   {
/* 58 */     return (Short)this.dao.getByHQL("SELECT ot.id FROM OperationType ot WHERE ot.code LIKE ?", new Object[] { "13" });
/*    */   }
/*    */   
/*    */   public Short getCustomerReturnTypeId()
/*    */   {
/* 63 */     return (Short)this.dao.getByHQL("SELECT ot.id FROM OperationType ot WHERE ot.code LIKE ?", new Object[] { "24" });
/*    */   }
/*    */   
/*    */   public Short getSupplierReturnTypeId()
/*    */   {
/* 68 */     return (Short)this.dao.getByHQL("SELECT ot.id FROM OperationType ot WHERE ot.code LIKE ?", new Object[] { "25" });
/*    */   }
/*    */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\service\OperationTypeService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */