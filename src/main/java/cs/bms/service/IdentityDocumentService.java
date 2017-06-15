/*    */ package cs.bms.service;
/*    */ 
/*    */ import cs.bms.dao.interfac.IIdentityDocumentDao;
/*    */ import cs.bms.model.IdentityDocument;
/*    */ import cs.bms.service.interfac.IIdentityDocumentService;
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
/*    */ public class IdentityDocumentService
/*    */   extends GenericService<IdentityDocument, Short>
/*    */   implements IIdentityDocumentService
/*    */ {
/*    */   @Autowired
/*    */   @Qualifier("identityDocumentDao")
/*    */   private IIdentityDocumentDao dao;
/*    */   
/*    */   public String getClassName()
/*    */   {
/* 30 */     return "IdentityDocument";
/*    */   }
/*    */   
/*    */   protected IGenericDao<IdentityDocument, Short> getDao()
/*    */   {
/* 35 */     return this.dao;
/*    */   }
/*    */   
/*    */   public boolean validCode(String code, Short id)
/*    */   {
/* 40 */     return this.dao.getByHQL("SELECT 1 FROM IdentityDocument idd WHERE idd.code LIKE ? AND idd.id <> ?", new Object[] {code
/*    */     
/*    */ 
/* 43 */       .trim(), id == null ? new Short("-1") : id }) == null;
/*    */   }
/*    */   
/*    */   public List<Object[]> getBasicData()
/*    */   {
/* 48 */     return this.dao.listHQL("SELECT idd.id, idd.abbr,idd.name FROM IdentityDocument idd WHERE idd.active = true ORDER BY idd.abbr");
/*    */   }
/*    */   
/*    */   public Short getIdByLength(int length)
/*    */   {
/* 53 */     return (Short)this.dao.getByHQL("SELECT idd.id FROM IdentityDocument idd WHERE idd.length_ = ?", new Object[] { new Short("" + length) });
/*    */   }
/*    */   
/*    */   public List<Object[]> getCreateByAfterDate(Date date)
/*    */   {
/* 58 */     return this.dao.listHQL("SELECT idd.code,idd.abbr, idd.name,idd.length_,idd.active FROM IdentityDocument idd WHERE idd.createDate > ?", new Object[] { date });
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public List<Object[]> getEditedByAfterDate(Date date, boolean b)
/*    */   {
/* 69 */     return this.dao.listHQL("SELECT idd.code,idd.abbr, idd.name,idd.length_,idd.active FROM IdentityDocument idd WHERE idd.createDate < ? AND idd.editDate > ?", new Object[] { date, date });
/*    */   }
/*    */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\service\IdentityDocumentService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */