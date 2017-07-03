/*    */ package cs.bms.dao;
/*    */ 
/*    */ import cs.bms.dao.interfac.IDocumentNumberingDao;
/*    */ import cs.bms.model.DocumentNumbering;
/*    */ import cs.bms.model.User;
/*    */ import gkfire.hibernate.generic.GenericDao;
/*    */ import java.util.List;
/*    */ import org.hibernate.Query;
/*    */ import org.hibernate.Session;
/*    */ import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
@Repository
/*    */ public class DocumentNumberingDao
/*    */   extends GenericDao<DocumentNumbering, Integer>
/*    */   implements IDocumentNumberingDao
/*    */ {
/*    */   public List<Object[]> getDataByUser(User user, String ruc)
/*    */   {
/* 23 */     Query query = getSessionFactory().getCurrentSession().createQuery("SELECT dn.id,dn.paymentProof.id,dn.serie FROM DocumentNumbering dn join dn.users u WHERE u.id = ? AND dn.rucCompany LIKE ?");
/*    */     
/*    */ 
/*    */ 
/* 27 */     query.setInteger(0, user.getId().intValue());
/* 28 */     query.setString(1, ruc);
/* 29 */     return query.list();
/*    */   }
/*    */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\dao\DocumentNumberingDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */