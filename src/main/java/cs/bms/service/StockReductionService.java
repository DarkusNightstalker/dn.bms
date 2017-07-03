/*    */ package cs.bms.service;
/*    */ 
/*    */ import cs.bms.dao.interfac.IStockReductionDao;
/*    */ import cs.bms.model.StockReduction;
/*    */ import cs.bms.service.interfac.IStockReductionService;
/*    */ import gkfire.hibernate.generic.GenericService;
/*    */ import gkfire.hibernate.generic.interfac.IGenericDao;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
@Service
/*    */ public class StockReductionService
/*    */   extends GenericService<StockReduction, Long>
/*    */   implements IStockReductionService
/*    */ {
/*    */   @Autowired
/*    */   @Qualifier("stockReductionDao")
/*    */   private IStockReductionDao dao;
/*    */   
/*    */   protected IGenericDao<StockReduction, Long> getDao()
/*    */   {
/* 28 */     return this.dao;
/*    */   }
/*    */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\service\StockReductionService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */