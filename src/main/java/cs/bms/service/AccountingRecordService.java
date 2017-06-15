/*    */ package cs.bms.service;
/*    */ 
/*    */ import cs.bms.dao.interfac.IAccountingRecordDao;
/*    */ import cs.bms.model.AccountingRecord;
/*    */ import cs.bms.service.interfac.IAccountingRecordService;
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
/*    */ public class AccountingRecordService
/*    */   extends GenericService<AccountingRecord, Long>
/*    */   implements IAccountingRecordService
/*    */ {
/*    */   @Autowired
/*    */   @Qualifier("accountingRecordDao")
/*    */   private IAccountingRecordDao dao;
/*    */   
/*    */   protected IGenericDao<AccountingRecord, Long> getDao()
/*    */   {
/* 29 */     return this.dao;
/*    */   }
/*    */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\service\AccountingRecordService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */