/*     */ package cs.bms.model;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.GeneratedValue;
/*     */ import javax.persistence.GenerationType;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.JoinTable;
/*     */ import javax.persistence.ManyToMany;
/*     */ import javax.persistence.Table;
/*     */ import javax.xml.bind.annotation.XmlRootElement;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Entity
/*     */ @Table(name="special_permission", catalog="public")
/*     */ @XmlRootElement
/*     */ public class SpecialPermission
/*     */   implements Serializable
/*     */ {
/*     */   @Id
/*     */   @GeneratedValue(strategy=GenerationType.IDENTITY)
/*     */   @Column(name="id", nullable=false)
/*     */   protected Short id;
/*     */   @Column(name="entity_name", nullable=false)
/*     */   protected String entityName;
/*     */   @Column(name="identifier", nullable=false)
/*     */   protected Long identifier;
/*     */   @ManyToMany
/*     */   @JoinTable(name="special_p_has_user", joinColumns={@javax.persistence.JoinColumn(name="id_special_permission", nullable=false, updatable=false)}, inverseJoinColumns={@javax.persistence.JoinColumn(name="id_user", nullable=false, updatable=false)})
/*  40 */   protected List<User> users = new ArrayList(0);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SpecialPermission() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SpecialPermission(Short id)
/*     */   {
/*  52 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Short getId()
/*     */   {
/*  60 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setId(Short id)
/*     */   {
/*  67 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getEntityName()
/*     */   {
/*  74 */     return this.entityName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setEntityName(String entityName)
/*     */   {
/*  81 */     this.entityName = entityName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Long getIdentifier()
/*     */   {
/*  88 */     return this.identifier;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setIdentifier(Long identifier)
/*     */   {
/*  95 */     this.identifier = identifier;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<User> getUsers()
/*     */   {
/* 102 */     return this.users;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setUsers(List<User> users)
/*     */   {
/* 109 */     this.users = users;
/*     */   }
/*     */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\model\SpecialPermission.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */