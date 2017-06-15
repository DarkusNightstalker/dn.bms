/*    */ package cs.bms.service;
/*    */ 
/*    */ import cs.bms.dao.interfac.ISpecialPermissionDao;
/*    */ import cs.bms.model.SpecialPermission;
/*    */ import cs.bms.service.interfac.ISpecialPermissionService;
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
/*    */ public class SpecialPermissionService
/*    */   extends GenericService<SpecialPermission, Short>
/*    */   implements ISpecialPermissionService
/*    */ {
/*    */   @Autowired
/*    */   @Qualifier("specialPermissionDao")
/*    */   private ISpecialPermissionDao dao;
/*    */   
/*    */   protected IGenericDao<SpecialPermission, Short> getDao()
/*    */   {
/* 28 */     return this.dao;
/*    */   }
/*    */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\service\SpecialPermissionService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */