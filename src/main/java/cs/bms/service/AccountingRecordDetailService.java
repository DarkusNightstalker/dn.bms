/*    */ package cs.bms.service;
/*    */ 
/*    */ import cs.bms.dao.interfac.IAccountingRecordDetailDao;
/*    */ import cs.bms.model.AccountingRecordDetail;
/*    */ import cs.bms.service.interfac.IAccountingRecordDetailService;
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
/*    */ public class AccountingRecordDetailService
/*    */   extends GenericService<AccountingRecordDetail, Long>
/*    */   implements IAccountingRecordDetailService
/*    */ {
/*    */   @Autowired
/*    */   @Qualifier("accountingRecordDetailDao")
/*    */   private IAccountingRecordDetailDao dao;
/*    */   
/*    */   protected IGenericDao<AccountingRecordDetail, Long> getDao()
/*    */   {
/* 28 */     return this.dao;
/*    */   }
/*    */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\service\AccountingRecordDetailService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */