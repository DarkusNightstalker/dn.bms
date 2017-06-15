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
/*     */ @Table(name="identity_document", catalog="public")
/*     */ @XmlRootElement
/*     */ public class IdentityDocument
/*     */   implements AuditoryEntity<Short, User>, EntityActivate
/*     */ {
/*     */   @Id
/*     */   @GeneratedValue(strategy=GenerationType.IDENTITY)
/*     */   @Column(name="id", nullable=false)
/*     */   private Short id;
/*     */   @Column(name="code", nullable=false)
/*     */   private String code;
/*     */   @Column(name="name", nullable=false)
/*     */   private String name;
/*     */   @Column(name="length", nullable=false)
/*     */   private Short length_;
/*     */   @Column(name="abbr", nullable=false)
/*     */   private String abbr;
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
/*  58 */   private Boolean active = Boolean.TRUE;
/*     */   
/*     */ 
/*     */   public IdentityDocument() {}
/*     */   
/*     */   public IdentityDocument(Short id)
/*     */   {
/*  65 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Short getId()
/*     */   {
/*  73 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setId(Short id)
/*     */   {
/*  80 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getCode()
/*     */   {
/*  87 */     return this.code;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCode(String code)
/*     */   {
/*  94 */     this.code = code;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getName()
/*     */   {
/* 101 */     return this.name;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setName(String name)
/*     */   {
/* 108 */     this.name = name;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Short getLength_()
/*     */   {
/* 115 */     return this.length_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setLength_(Short length_)
/*     */   {
/* 122 */     this.length_ = length_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getAbbr()
/*     */   {
/* 129 */     return this.abbr;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setAbbr(String abbr)
/*     */   {
/* 136 */     this.abbr = abbr;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public User getCreateUser()
/*     */   {
/* 143 */     return this.createUser;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCreateUser(User createUser)
/*     */   {
/* 150 */     this.createUser = createUser;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Date getCreateDate()
/*     */   {
/* 157 */     return this.createDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCreateDate(Date createDate)
/*     */   {
/* 164 */     this.createDate = createDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public User getEditUser()
/*     */   {
/* 171 */     return this.editUser;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setEditUser(User editUser)
/*     */   {
/* 178 */     this.editUser = editUser;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Date getEditDate()
/*     */   {
/* 185 */     return this.editDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setEditDate(Date editDate)
/*     */   {
/* 192 */     this.editDate = editDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Boolean getActive()
/*     */   {
/* 199 */     return this.active;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setActive(Boolean active)
/*     */   {
/* 206 */     this.active = active;
/*     */   }
/*     */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\model\IdentityDocument.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */