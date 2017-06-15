/*    */ package cs.bms.service;
/*    */ 
/*    */ import cs.bms.dao.interfac.IStockReturnCustomerDao;
/*    */ import cs.bms.model.StockReturnCustomer;
/*    */ import cs.bms.service.interfac.IStockReturnCustomerService;
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
/*    */ public class StockReturnCustomerService
/*    */   extends GenericService<StockReturnCustomer, Long>
/*    */   implements IStockReturnCustomerService
/*    */ {
/*    */   @Autowired
/*    */   @Qualifier("stockReturnCustomerDao")
/*    */   private IStockReturnCustomerDao dao;
/*    */   
/*    */   protected IGenericDao<StockReturnCustomer, Long> getDao()
/*    */   {
/* 28 */     return this.dao;
/*    */   }
/*    */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\service\StockReturnCustomerService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */