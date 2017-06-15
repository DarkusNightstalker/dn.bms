/*    */ package cs.bms.service;
/*    */ 
/*    */ import cs.bms.dao.interfac.IDistrictDao;
/*    */ import cs.bms.model.District;
/*    */ import cs.bms.service.interfac.IDistrictService;
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
/*    */ public class DistrictService
/*    */   extends GenericService<District, Integer>
/*    */   implements IDistrictService
/*    */ {
/*    */   @Autowired
/*    */   @Qualifier("districtDao")
/*    */   private IDistrictDao dao;
/*    */   
/*    */   protected IGenericDao<District, Integer> getDao()
/*    */   {
/* 28 */     return this.dao;
/*    */   }
/*    */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\service\DistrictService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */