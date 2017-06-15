/*    */ package cs.bms.service;
/*    */ 
/*    */ import cs.bms.dao.interfac.IElectronicBookCategoryDao;
/*    */ import cs.bms.model.ElectronicBookCategory;
/*    */ import cs.bms.service.interfac.IElectronicBookCategoryService;
/*    */ import gkfire.hibernate.generic.GenericService;
/*    */ import gkfire.hibernate.generic.interfac.IGenericDao;
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
/*    */ public class ElectronicBookCategoryService
/*    */   extends GenericService<ElectronicBookCategory, Short>
/*    */   implements IElectronicBookCategoryService
/*    */ {
/*    */   @Autowired
/*    */   @Qualifier("electronicBookCategoryDao")
/*    */   private IElectronicBookCategoryDao dao;
/*    */   
/*    */   public boolean existCode(String code, Short id)
/*    */   {
/* 29 */     return this.dao.existCode(code, id);
/*    */   }
/*    */   
/*    */   protected IGenericDao<ElectronicBookCategory, Short> getDao()
/*    */   {
/* 34 */     return this.dao;
/*    */   }
/*    */   
/*    */   public List<Object[]> getBasicData()
/*    */   {
/* 39 */     return this.dao.listHQL("SELECT ebc.id,ebc.code,ebc.name FROM ElectronicBookCategory ebc WHERE ebc.active = true ORDER by ebc.id");
/*    */   }
/*    */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\service\ElectronicBookCategoryService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */