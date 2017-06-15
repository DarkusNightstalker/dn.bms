/*    */ package cs.bms.service;
/*    */ 
/*    */ import cs.bms.dao.interfac.ICompanyGroupDao;
/*    */ import cs.bms.model.CompanyGroup;
/*    */ import cs.bms.service.interfac.ICompanyGroupService;
/*    */ import gkfire.hibernate.generic.GenericService;
/*    */ import gkfire.hibernate.generic.interfac.IGenericDao;
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
/*    */ public class CompanyGroupService
/*    */   extends GenericService<CompanyGroup, Integer>
/*    */   implements ICompanyGroupService
/*    */ {
/*    */   @Autowired
/*    */   @Qualifier("companyGroupDao")
/*    */   private ICompanyGroupDao dao;
/*    */   
/*    */   protected IGenericDao<CompanyGroup, Integer> getDao()
/*    */   {
/* 28 */     return this.dao;
/*    */   }
/*    */   
/*    */   public List<Object[]> getBasicData()
/*    */   {
/* 33 */     return this.dao.listHQL("SELECT cg.id,cg.name FROM CompanyGroup cg WHERE cg.active = true");
/*    */   }
/*    */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\service\CompanyGroupService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */