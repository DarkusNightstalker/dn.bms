/*     */ package cs.bms.model;
/*     */ 
/*     */ import gkfire.auditory.AuditoryEntity;
/*     */ import gkfire.model.interfac.EntityActivate;
/*     */ import java.util.Date;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.FetchType;
/*     */ import javax.persistence.GeneratedValue;
/*     */ import javax.persistence.GenerationType;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.JoinColumn;
/*     */ import javax.persistence.ManyToOne;
/*     */ import javax.persistence.Table;
/*     */ import javax.persistence.Temporal;
/*     */ import javax.persistence.TemporalType;
/*     */ import javax.validation.constraints.Size;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ @Entity
/*     */ @Table(name="stock_type", catalog="public")
/*     */ @XmlRootElement
/*     */ public class StockType
/*     */   implements AuditoryEntity<Short, User>, EntityActivate
/*     */ {
/*     */   @Id
/*     */   @GeneratedValue(strategy=GenerationType.IDENTITY)
/*     */   @Column(name="id", nullable=false)
/*     */   private Short id;
/*     */   @Column(name="code", nullable=false)
/*     */   @Size(max=2)
/*     */   private String code;
/*     */   @Column(name="name", nullable=false)
/*     */   @Size(max=50)
/*     */   private String name;
/*     */   @JoinColumn(name="create_uid", nullable=false)
/*     */   @ManyToOne(fetch=FetchType.LAZY)
/*     */   private User createUser;
/*     */   @Column(name="create_date", nullable=false)
/*     */   @Temporal(TemporalType.TIMESTAMP)
/*     */   private Date createDate;
/*     */   @JoinColumn(name="edit_uid")
/*     */   @ManyToOne(fetch=FetchType.LAZY)
/*     */   private User editUser;
/*     */   @Column(name="edit_date")
/*     */   @Temporal(TemporalType.TIMESTAMP)
/*     */   private Date editDate;
/*     */   @Column(name="active", nullable=false)
/*  60 */   private Boolean active = Boolean.TRUE;
/*     */   
/*     */ 
/*     */   public StockType() {}
/*     */   
/*     */   public StockType(Short id)
/*     */   {
/*  67 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Short getId()
/*     */   {
/*  75 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setId(Short id)
/*     */   {
/*  82 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getCode()
/*     */   {
/*  89 */     return this.code;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCode(String code)
/*     */   {
/*  96 */     this.code = code;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getName()
/*     */   {
/* 103 */     return this.name;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setName(String name)
/*     */   {
/* 110 */     this.name = name;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public User getCreateUser()
/*     */   {
/* 117 */     return this.createUser;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCreateUser(User createUser)
/*     */   {
/* 124 */     this.createUser = createUser;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Date getCreateDate()
/*     */   {
/* 131 */     return this.createDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCreateDate(Date createDate)
/*     */   {
/* 138 */     this.createDate = createDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public User getEditUser()
/*     */   {
/* 145 */     return this.editUser;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setEditUser(User editUser)
/*     */   {
/* 152 */     this.editUser = editUser;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Date getEditDate()
/*     */   {
/* 159 */     return this.editDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setEditDate(Date editDate)
/*     */   {
/* 166 */     this.editDate = editDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Boolean getActive()
/*     */   {
/* 173 */     return this.active;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setActive(Boolean active)
/*     */   {
/* 180 */     this.active = active;
/*     */   }
/*     */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\model\StockType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */