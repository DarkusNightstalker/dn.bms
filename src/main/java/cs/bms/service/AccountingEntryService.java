/*    */ package cs.bms.service;
/*    */ 
/*    */ import cs.bms.dao.interfac.IAccountingEntryDao;
/*    */ import cs.bms.model.AccountingEntry;
/*    */ import cs.bms.service.interfac.IAccountingEntryService;
/*    */ import gkfire.hibernate.generic.GenericService;
/*    */ import gkfire.hibernate.generic.interfac.IGenericDao;
/*    */ import gkfire.util.ErrorMessage;
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
/*    */ 
/*    */ 
/*    */ public class AccountingEntryService
/*    */   extends GenericService<AccountingEntry, Long>
/*    */   implements IAccountingEntryService
/*    */ {
/*    */   @Autowired
/*    */   @Qualifier("accountingEntryDao")
/*    */   private IAccountingEntryDao dao;
/*    */   
/*    */   public ErrorMessage verifyCode(String code, Long exception)
/*    */   {
/* 35 */     return this.dao.verifyCode(code, exception);
/*    */   }
/*    */   
/*    */   public AccountingEntry getParent(String path)
/*    */   {
/* 40 */     return this.dao.getParent(path);
/*    */   }
/*    */   
/*    */   public AccountingEntry getByPath(String path)
/*    */   {
/* 45 */     return this.dao.getByPath(path);
/*    */   }
/*    */   
/*    */   protected IGenericDao<AccountingEntry, Long> getDao()
/*    */   {
/* 50 */     return this.dao;
/*    */   }
/*    */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\service\AccountingEntryService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */