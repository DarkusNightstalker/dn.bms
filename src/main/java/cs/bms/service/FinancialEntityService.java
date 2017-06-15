/*    */ package cs.bms.service;
/*    */ 
/*    */ import cs.bms.dao.interfac.IFinancialEntityDao;
/*    */ import cs.bms.model.FinancialEntity;
/*    */ import cs.bms.service.interfac.IFinancialEntityService;
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
/*    */ public class FinancialEntityService
/*    */   extends GenericService<FinancialEntity, Short>
/*    */   implements IFinancialEntityService
/*    */ {
/*    */   @Autowired
/*    */   @Qualifier("financialEntityDao")
/*    */   private IFinancialEntityDao dao;
/*    */   
/*    */   protected IGenericDao<FinancialEntity, Short> getDao()
/*    */   {
/* 28 */     return this.dao;
/*    */   }
/*    */   
/*    */   public boolean verifyCode(String code, Short id)
/*    */   {
/* 33 */     return this.dao.getByHQL("SELECT 1 FROM FinancialEntity idd WHERE idd.code LIKE ? AND idd.id <> ?", new Object[] { code, id == null ? new Short("-1") : id }) == null;
/*    */   }
/*    */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\service\FinancialEntityService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */