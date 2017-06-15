/*    */ package cs.bms.dao;
/*    */ 
/*    */ import cs.bms.dao.interfac.IAccountingEntryDao;
/*    */ import cs.bms.model.AccountingEntry;
/*    */ import gkfire.hibernate.generic.GenericDao;
/*    */ import gkfire.util.ErrorMessage;
/*    */ import org.hibernate.Query;
/*    */ import org.hibernate.Session;
/*    */ import org.hibernate.SessionFactory;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AccountingEntryDao
/*    */   extends GenericDao<AccountingEntry, Long>
/*    */   implements IAccountingEntryDao
/*    */ {
/*    */   public ErrorMessage verifyCode(String code, Long exception)
/*    */   {
/* 22 */     if ((code == null) || ("".equalsIgnoreCase(code))) {
/* 23 */       return new ErrorMessage("CG-0001", "El codigo no puede ser nulo o vacio");
/*    */     }
/* 25 */     Query query = getSessionFactory().getCurrentSession().createQuery("SELECT 1 FROM AccountingEntry c WHERE c.path LIKE :path  AND c.id != :exception");
/* 26 */     query.setLong("exception", exception.longValue());
/* 27 */     query.setString("path", code);
/* 28 */     if (query.uniqueResult() != null) {
/* 29 */       return new ErrorMessage("CG-0002", "El codigo '" + code + "' ya se encuentra registrado");
/*    */     }
/*    */     
/* 32 */     if (code.length() == 1) {
/* 33 */       return null;
/*    */     }
/* 35 */     query = getSessionFactory().getCurrentSession().createQuery("SELECT 1 FROM AccountingEntry c WHERE c.path LIKE :path");
/* 36 */     query.setString("path", code.substring(0, code.length() - 1));
/* 37 */     if (query.uniqueResult() == null) {
/* 38 */       return new ErrorMessage("CG-0004", "No se encuentra el asiento contable de codigo '" + code.substring(0, code.length() - 1) + "' generico para el asiento contable '" + code + "'", new Object[] { code.substring(0, code.length() - 1) });
/*    */     }
/* 40 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public AccountingEntry getParent(String path)
/*    */   {
/* 47 */     if (path.length() == 1) {
/* 48 */       return null;
/*    */     }
/* 50 */     return getByPath(path.substring(0, path.length() - 1));
/*    */   }
/*    */   
/*    */   public AccountingEntry getByPath(String path)
/*    */   {
/* 55 */     Query query = getSessionFactory().getCurrentSession().createQuery("FROM AccountingEntry c WHERE c.path LIKE :path");
/* 56 */     query.setString("path", path);
/* 57 */     return (AccountingEntry)query.uniqueResult();
/*    */   }
/*    */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\dao\AccountingEntryDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */