/*    */ package cs.bms.service;
/*    */ 
/*    */ import cs.bms.dao.interfac.ICompanyDao;
/*    */ import cs.bms.model.Company;
/*    */ import cs.bms.service.interfac.ICompanyService;
/*    */ import gkfire.hibernate.generic.GenericService;
/*    */ import gkfire.hibernate.generic.interfac.IGenericDao;
/*    */ import gkfire.util.Month;
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
/*    */ public class CompanyService
/*    */   extends GenericService<Company, Integer>
/*    */   implements ICompanyService
/*    */ {
/*    */   @Autowired
/*    */   @Qualifier("companyDao")
/*    */   private ICompanyDao dao;
/*    */   
/*    */   protected IGenericDao<Company, Integer> getDao()
/*    */   {
/* 31 */     return this.dao;
/*    */   }
/*    */   
/*    */   public List getDataByList(List ids)
/*    */   {
/* 36 */     return this.dao.getDataByList(ids);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public List<Object[]> getBasicDataNotOpening(int year, Month month)
/*    */   {
/* 45 */     return month == null ? this.dao.listHQL("SELECT c.id,c.code,c.name||' '||c.city||' ('||c.address||')' FROM Company c WHERE c.id NOT IN (SELECT DISTINCT ob.company.id FROM OpeningBalance ob WHERE ob.year  = ? )", new Object[] {Integer.valueOf(year) }) : this.dao.listHQL("SELECT c.id,c.code,c.name||' '||c.city||' ('||c.address||')' FROM Company c WHERE c.id NOT IN (SELECT DISTINCT ob.company.id FROM OpeningBalance ob WHERE ob.year  = ? AND ob.month = ?)", new Object[] {
/*    */     
/*    */ 
/* 48 */       Integer.valueOf(year), month });
/*    */   }
/*    */   
/*    */   public List<Object[]> getCreatedByAfterDate(Date date)
/*    */   {
/* 53 */     return this.dao.listHQL("SELECT c.code,c.ruc,c.path,c.name,c.city,c.igvPercent,c.title,c.address,c.buy,c.stored,c.sold,c.privateTransportDescription,c.privateDriverLicense,c.active FROM Company c WHERE c.createDate > ?  ORDER BY c.createDate", new Object[] { date });
/*    */   }
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
/*    */ 
/*    */ 
/*    */   public List<Object[]> getEditedByAfterDate(Date date, boolean withCreated)
/*    */   {
/* 73 */     return this.dao.listHQL("SELECT c.code,c.ruc,c.path,c.name,c.city,c.igvPercent,c.title,c.address,c.buy,c.stored,c.sold,c.privateTransportDescription,c.privateDriverLicense,c.active FROM Company c WHERE c.createDate < ?  AND c.editDate > ?  ORDER BY c.createDate", new Object[] { date, date });
/*    */   }
/*    */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\service\CompanyService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */