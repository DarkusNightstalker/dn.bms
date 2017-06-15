/*     */ package cs.bms.service;
/*     */ 
/*     */ import cs.bms.dao.interfac.IActorDao;
/*     */ import cs.bms.model.Actor;
/*     */ import cs.bms.model.User;
/*     */ import cs.bms.service.interfac.IActorService;
/*     */ import gkfire.hibernate.generic.GenericService;
/*     */ import gkfire.hibernate.generic.interfac.IGenericDao;
/*     */ import java.util.Arrays;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.beans.factory.annotation.Qualifier;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ActorService
/*     */   extends GenericService<Actor, Long>
/*     */   implements IActorService
/*     */ {
/*     */   @Autowired
/*     */   @Qualifier("actorDao")
/*     */   private IActorDao dao;
/*     */   
/*     */   public String getClassName()
/*     */   {
/*  32 */     return "Actor";
/*     */   }
/*     */   
/*     */   protected IGenericDao<Actor, Long> getDao()
/*     */   {
/*  37 */     return this.dao;
/*     */   }
/*     */   
/*     */   public void updateNameByIdentityDocument(String identityNumber, String name)
/*     */   {
/*  42 */     this.dao.updateHQL("UPDATE Actor SEt name = ?,synchronized_ = true WHERE identityNumber LIKE ?", new Object[] { name, identityNumber });
/*     */   }
/*     */   
/*     */   public List<Object[]> getIdentityDataForSynchro(String... identityDocumentCodes)
/*     */   {
/*  47 */     return this.dao.listHQL("SELECT a.identityNumber,a.identityDocument.code FROM Actor a WHERE a.synchronized_ = false and a.identityDocument.code IN (:codes)", new String[] { "codes" }, new Object[] {
/*     */     
/*     */ 
/*     */ 
/*  51 */       Arrays.asList(identityDocumentCodes) });
/*     */   }
/*     */   
/*     */   public Long countIdentityDataForSynchro(String... identityDocumentCodes)
/*     */   {
/*  56 */     return (Long)this.dao.getByHQL("SELECT COUNT(*) FROM Actor a WHERE a.synchronized_ = false and a.identityDocument.code IN (:codes)", new String[] { "codes" }, new Object[] {
/*     */     
/*     */ 
/*  59 */       Arrays.asList(identityDocumentCodes) });
/*     */   }
/*     */   
/*     */   public Actor getByIdentityNumber(String identityNumber)
/*     */   {
/*  64 */     return (Actor)this.dao.getByHQL("FROM Actor a WHERE a.identityNumber Like ?", new Object[] { identityNumber });
/*     */   }
/*     */   
/*     */   public boolean verifyIdentityNumber(String identityNumber, Long id)
/*     */   {
/*  69 */     return this.dao.getByHQL("SELECT 1 FROM Actor a WHERE a.identityNumber LIKE ? AND a.id <> ?", new Object[] { identityNumber, Long.valueOf(id == null ? -1L : id.longValue()) }) != null;
/*     */   }
/*     */   
/*     */   public List<Object[]> getCreatedByAfterDate(Date date)
/*     */   {
/*  74 */     return this.dao.listHQL("SELECT a.identityNumber,a.identityDocument.code,a.name,a.other,a.address,a.points,a.customer,a.supplier,a.synchronized,a.active FROM Actor a WHERE a.createDate > ?", new Object[] { date });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public List<Object[]> getEditedByAfterDate(Date date, boolean withRecentlyCreated)
/*     */   {
/*  89 */     return this.dao.listHQL("SELECT a.identityNumber,a.identityDocument.code,a.name,a.other,a.address,a.points,a.customer,a.supplier,a.synchronized,a.active FROM Actor a WHERE a.createDate < ? and a.editDate > ?", new Object[] { date, date });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void subtractPoints(Long id, Long points, User user)
/*     */   {
/* 105 */     this.dao.updateHQL("UPDATE Actor a SET points = (points - ?),editDate = ?,editUser = ? WHERE id = ?", new Object[] { points, new Date(), user, id });
/*     */   }
/*     */   
/*     */   public void addPoints(Long id, Long points, User user)
/*     */   {
/* 110 */     this.dao.updateHQL("UPDATE Actor a SET points = (points + ?),editDate = ?,editUser = ? WHERE id = ?", new Object[] { points, new Date(), user, id });
/*     */   }
/*     */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\service\ActorService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */