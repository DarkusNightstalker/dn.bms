/*    */ package cs.bms.dao;
/*    */ 
/*    */ import cs.bms.dao.interfac.IPermissionDao;
/*    */ import cs.bms.model.Permission;
/*    */ import cs.bms.model.PermissionCategory;
/*    */ import cs.bms.model.User;
/*    */ import gkfire.hibernate.generic.GenericDao;
/*    */ import java.util.List;
/*    */ import org.hibernate.Query;
/*    */ import org.hibernate.Session;
/*    */ import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
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
@Repository
/*    */ public class PermissionDao
/*    */   extends GenericDao<Permission, Integer>
/*    */   implements IPermissionDao
/*    */ {
/*    */   public List<Permission> getBy(PermissionCategory category)
/*    */   {
/* 29 */     Query query = getSessionFactory().getCurrentSession().createQuery("SELECT p FROM Permission p WHERE " + (category != null ? "p.permissionCategory = :category" : "p.permissionCategory is null"));
/* 30 */     if (category != null) {
/* 31 */       query.setEntity("category", category);
/*    */     }
/* 33 */     return query.list();
/*    */   }
/*    */   
/*    */   public List<String> getPermissionCodeFromUser(User user)
/*    */   {
/* 38 */     Query query = getSessionFactory().getCurrentSession().createQuery("SELECT DISTINCT p.code FROM Permission p join p.rols r join r.users u WHERE u.id = ? and  p.active = true and r.active = true");
/*    */     
/*    */ 
/*    */ 
/* 42 */     query.setInteger(0, user.getId().intValue());
/* 43 */     return query.list();
/*    */   }
/*    */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\dao\PermissionDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */