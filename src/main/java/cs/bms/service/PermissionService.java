/*    */ package cs.bms.service;
/*    */ 
/*    */ import cs.bms.dao.interfac.IPermissionDao;
/*    */ import cs.bms.model.Permission;
/*    */ import cs.bms.model.PermissionCategory;
/*    */ import cs.bms.model.User;
/*    */ import cs.bms.service.interfac.IPermissionService;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PermissionService
/*    */   extends GenericService<Permission, Integer>
/*    */   implements IPermissionService
/*    */ {
/*    */   @Autowired
/*    */   @Qualifier("permissionDao")
/*    */   private IPermissionDao dao;
/*    */   
/*    */   public List<Permission> getBy(PermissionCategory category)
/*    */   {
/* 35 */     return this.dao.getBy(category);
/*    */   }
/*    */   
/*    */   protected IGenericDao<Permission, Integer> getDao()
/*    */   {
/* 40 */     return this.dao;
/*    */   }
/*    */   
/*    */   public List<String> getPermissionCodeFromUser(User user)
/*    */   {
/* 45 */     return this.dao.getPermissionCodeFromUser(user);
/*    */   }
/*    */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\service\PermissionService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */