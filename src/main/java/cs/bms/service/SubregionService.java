/*    */ package cs.bms.service;
/*    */ 
/*    */ import cs.bms.dao.interfac.ISubregionDao;
/*    */ import cs.bms.model.Subregion;
/*    */ import cs.bms.service.interfac.ISubregionService;
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
/*    */ public class SubregionService
/*    */   extends GenericService<Subregion, Integer>
/*    */   implements ISubregionService
/*    */ {
/*    */   @Autowired
/*    */   @Qualifier("subregionDao")
/*    */   private ISubregionDao dao;
/*    */   
/*    */   protected IGenericDao<Subregion, Integer> getDao()
/*    */   {
/* 28 */     return this.dao;
/*    */   }
/*    */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\service\SubregionService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */