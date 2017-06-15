/*    */ package cs.bms.service;
/*    */ 
/*    */ import cs.bms.dao.interfac.IDocumentNumberingDao;
/*    */ import cs.bms.model.DocumentNumbering;
/*    */ import cs.bms.model.User;
/*    */ import cs.bms.service.interfac.IDocumentNumberingService;
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
/*    */ 
/*    */ public class DocumentNumberingService
/*    */   extends GenericService<DocumentNumbering, Integer>
/*    */   implements IDocumentNumberingService
/*    */ {
/*    */   @Autowired
/*    */   @Qualifier("documentNumberingDao")
/*    */   private IDocumentNumberingDao dao;
/*    */   
/*    */   protected IGenericDao<DocumentNumbering, Integer> getDao()
/*    */   {
/* 30 */     return this.dao;
/*    */   }
/*    */   
/*    */   public List<Object[]> getDataByUser(User user, String ruc)
/*    */   {
/* 35 */     return this.dao.getDataByUser(user, ruc);
/*    */   }
/*    */   
/*    */   public List<Object[]> getListData()
/*    */   {
/* 40 */     return this.dao.listHQL("SELECT dn.paymentProof.code,dn.rucCompany,dn.serie,dn.numbering,dn.electronic FROM DocumentNumbering dn ");
/*    */   }
/*    */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\service\DocumentNumberingService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */