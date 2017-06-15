/*    */ package cs.bms.service;
/*    */ 
/*    */ import cs.bms.dao.interfac.IStockReductionDetailDao;
/*    */ import cs.bms.model.StockReductionDetail;
/*    */ import cs.bms.service.interfac.IStockReductionDetailService;
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
/*    */ public class StockReductionDetailService
/*    */   extends GenericService<StockReductionDetail, Long>
/*    */   implements IStockReductionDetailService
/*    */ {
/*    */   @Autowired
/*    */   @Qualifier("stockReductionDetailDao")
/*    */   private IStockReductionDetailDao dao;
/*    */   
/*    */   protected IGenericDao<StockReductionDetail, Long> getDao()
/*    */   {
/* 28 */     return this.dao;
/*    */   }
/*    */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\service\StockReductionDetailService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */