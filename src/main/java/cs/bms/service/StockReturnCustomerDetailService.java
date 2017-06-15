/*    */ package cs.bms.service;
/*    */ 
/*    */ import cs.bms.dao.interfac.IStockReturnCustomerDetailDao;
/*    */ import cs.bms.model.StockReturnCustomerDetail;
/*    */ import cs.bms.service.interfac.IStockReturnCustomerDetailService;
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
/*    */ public class StockReturnCustomerDetailService
/*    */   extends GenericService<StockReturnCustomerDetail, Long>
/*    */   implements IStockReturnCustomerDetailService
/*    */ {
/*    */   @Autowired
/*    */   @Qualifier("stockReturnCustomerDetailDao")
/*    */   private IStockReturnCustomerDetailDao dao;
/*    */   
/*    */   protected IGenericDao<StockReturnCustomerDetail, Long> getDao()
/*    */   {
/* 28 */     return this.dao;
/*    */   }
/*    */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\service\StockReturnCustomerDetailService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */