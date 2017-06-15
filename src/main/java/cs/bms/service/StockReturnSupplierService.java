/*    */ package cs.bms.service;
/*    */ 
/*    */ import cs.bms.dao.interfac.IStockReturnSupplierDao;
/*    */ import cs.bms.model.StockReturnSupplier;
/*    */ import cs.bms.service.interfac.IStockReturnSupplierService;
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
/*    */ public class StockReturnSupplierService
/*    */   extends GenericService<StockReturnSupplier, Long>
/*    */   implements IStockReturnSupplierService
/*    */ {
/*    */   @Autowired
/*    */   @Qualifier("stockReturnSupplierDao")
/*    */   private IStockReturnSupplierDao dao;
/*    */   
/*    */   protected IGenericDao<StockReturnSupplier, Long> getDao()
/*    */   {
/* 28 */     return this.dao;
/*    */   }
/*    */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\service\StockReturnSupplierService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */