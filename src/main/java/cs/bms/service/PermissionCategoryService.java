/*    */ package cs.bms.service;
/*    */ 
/*    */ import cs.bms.dao.interfac.IPermissionCategoryDao;
/*    */ import cs.bms.model.PermissionCategory;
/*    */ import cs.bms.service.interfac.IPermissionCategoryService;
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
/*    */ public class PermissionCategoryService
/*    */   extends GenericService<PermissionCategory, Integer>
/*    */   implements IPermissionCategoryService
/*    */ {
/*    */   @Autowired
/*    */   @Qualifier("permissionCategoryDao")
/*    */   private IPermissionCategoryDao dao;
/*    */   
/*    */   protected IGenericDao<PermissionCategory, Integer> getDao()
/*    */   {
/* 28 */     return this.dao;
/*    */   }
/*    */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\service\PermissionCategoryService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */