/*    */ package cs.bms.service;
/*    */ 
/*    */ import cs.bms.dao.interfac.ICashRegisterDao;
/*    */ import cs.bms.model.CashRegister;
/*    */ import cs.bms.model.Company;
/*    */ import cs.bms.service.interfac.ICashRegisterService;
/*    */ import gkfire.hibernate.generic.GenericService;
/*    */ import gkfire.hibernate.generic.interfac.IGenericDao;
/*    */ import java.util.Date;
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
/*    */ public class CashRegisterService
/*    */   extends GenericService<CashRegister, Long>
/*    */   implements ICashRegisterService
/*    */ {
/*    */   @Autowired
/*    */   @Qualifier("cashRegisterDao")
/*    */   private ICashRegisterDao dao;
/*    */   
/*    */   protected IGenericDao<CashRegister, Long> getDao()
/*    */   {
/* 31 */     return this.dao;
/*    */   }
/*    */   
/*    */   public Date getLastDate(Company company)
/*    */   {
/* 36 */     List result = this.dao.listHQLPage("SELECT cr.createDate FROM CashRegister cr WHERE cr.company = ? ORDER BY cr.createDate DESC", 1, 1, new Object[] { company });
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 41 */     return result.isEmpty() ? null : (Date)result.get(0);
/*    */   }
/*    */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\service\CashRegisterService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */