/*    */ package cs.bms.service;
/*    */ 
/*    */ import cs.bms.dao.interfac.ICountryDao;
/*    */ import cs.bms.model.Country;
/*    */ import cs.bms.service.interfac.ICountryService;
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
/*    */ public class CountryService
/*    */   extends GenericService<Country, Integer>
/*    */   implements ICountryService
/*    */ {
/*    */   @Autowired
/*    */   @Qualifier("countryDao")
/*    */   private ICountryDao dao;
/*    */   
/*    */   protected IGenericDao<Country, Integer> getDao()
/*    */   {
/* 28 */     return this.dao;
/*    */   }
/*    */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\service\CountryService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */