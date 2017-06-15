/*    */ package cs.bms.service;
/*    */ 
/*    */ import cs.bms.dao.interfac.IElectronicBookDao;
/*    */ import cs.bms.model.ElectronicBook;
/*    */ import cs.bms.service.interfac.IElectronicBookService;
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
/*    */ 
/*    */ public class ElectronicBookService
/*    */   extends GenericService<ElectronicBook, Short>
/*    */   implements IElectronicBookService
/*    */ {
/*    */   @Autowired
/*    */   @Qualifier("electronicBookDao")
/*    */   private IElectronicBookDao dao;
/*    */   
/*    */   public boolean existCode(String code, Short id)
/*    */   {
/* 29 */     return this.dao.existCode(code, id);
/*    */   }
/*    */   
/*    */   protected IGenericDao<ElectronicBook, Short> getDao()
/*    */   {
/* 34 */     return this.dao;
/*    */   }
/*    */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\service\ElectronicBookService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */