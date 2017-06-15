/*    */ package cs.bms.service;
/*    */ 
/*    */ import cs.bms.dao.interfac.IStockReturnSupplierDetailDao;
/*    */ import cs.bms.model.StockReturnSupplierDetail;
/*    */ import cs.bms.service.interfac.IStockReturnSupplierDetailService;
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
/*    */ public class StockReturnSupplierDetailService
/*    */   extends GenericService<StockReturnSupplierDetail, Long>
/*    */   implements IStockReturnSupplierDetailService
/*    */ {
/*    */   @Autowired
/*    */   @Qualifier("stockReturnSupplierDetailDao")
/*    */   private IStockReturnSupplierDetailDao dao;
/*    */   
/*    */   protected IGenericDao<StockReturnSupplierDetail, Long> getDao()
/*    */   {
/* 28 */     return this.dao;
/*    */   }
/*    */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\service\StockReturnSupplierDetailService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */