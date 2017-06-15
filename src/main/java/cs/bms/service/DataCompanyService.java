/*    */ package cs.bms.service;
/*    */ 
/*    */ import cs.bms.dao.interfac.IDataCompanyDao;
/*    */ import cs.bms.model.DataCompany;
/*    */ import cs.bms.service.interfac.IDataCompanyService;
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
/*    */ public class DataCompanyService
/*    */   extends GenericService<DataCompany, Long>
/*    */   implements IDataCompanyService
/*    */ {
/*    */   @Autowired
/*    */   @Qualifier("dataCompanyDao")
/*    */   private IDataCompanyDao dao;
/*    */   
/*    */   public String getClassName()
/*    */   {
/* 29 */     return "Actor";
/*    */   }
/*    */   
/*    */   protected IGenericDao<DataCompany, Long> getDao()
/*    */   {
/* 34 */     return this.dao;
/*    */   }
/*    */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\service\DataCompanyService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */