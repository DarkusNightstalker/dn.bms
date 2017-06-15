/*     */ package cs.bms.model;
/*     */ 
/*     */ import gkfire.auditory.AuditoryEntity;
/*     */ import java.io.Serializable;
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
/*     */ @Entity
/*     */ @Table(name="actor", catalog="public")
/*     */ @XmlRootElement
/*     */ public class Actor
/*     */   implements Serializable, AuditoryEntity<Long, User>
/*     */ {
/*     */   @Id
/*     */   @GeneratedValue(strategy=GenerationType.IDENTITY)
/*     */   @Column(name="id", nullable=false)
/*     */   protected Long id;
/*     */   @Column(name="identity_number", nullable=false)
/*     */   protected String identityNumber;
/*     */   @Column(name="name", nullable=true)
/*     */   protected String name;
/*     */   @Column(name="other", nullable=true)
/*     */   protected String other;
/*     */   @Column(name="representative", nullable=true)
/*     */   protected String representative;
/*     */   @Column(name="address", nullable=true)
/*     */   protected String address;
/*     */   @Column(name="points", nullable=true)
/*  47 */   protected Long points = Long.valueOf(0L); @Column(name="synchronized", nullable=false)
/*  48 */   protected Boolean synchronized_ = Boolean.FALSE;
/*     */   @Column(name="customer", nullable=false)
/*  50 */   protected Boolean customer = Boolean.FALSE;
/*     */   @Column(name="supplier", nullable=false)
/*  52 */   protected Boolean supplier = Boolean.FALSE;
/*     */   
/*     */   @JoinColumn(name="id_district", nullable=true)
/*     */   @ManyToOne
/*     */   protected Ubigeo ubigeo;
/*     */   
/*     */   @JoinColumn(name="id_identity_document", nullable=false)
/*     */   @ManyToOne
/*     */   protected IdentityDocument identityDocument;
/*     */   @JoinColumn(name="create_uid", nullable=false)
/*     */   @ManyToOne(fetch=FetchType.LAZY)
/*     */   protected User createUser;
/*     */   @Column(name="create_date", nullable=false)
/*     */   @Temporal(TemporalType.TIMESTAMP)
/*     */   protected Date createDate;
/*     */   @JoinColumn(name="edit_uid")
/*     */   @ManyToOne(fetch=FetchType.LAZY)
/*     */   protected User editUser;
/*     */   @Column(name="edit_date")
/*     */   @Temporal(TemporalType.TIMESTAMP)
/*     */   protected Date editDate;
/*     */   @Column(name="active", nullable=false)
/*  74 */   protected Boolean active = Boolean.TRUE;
/*     */   
/*     */   public Actor(Long id)
/*     */   {
/*  78 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Actor() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public Long getId()
/*     */   {
/*  90 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/*  98 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getIdentityNumber()
/*     */   {
/* 105 */     return this.identityNumber;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setIdentityNumber(String identityNumber)
/*     */   {
/* 112 */     this.identityNumber = identityNumber;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getName()
/*     */   {
/* 119 */     return this.name;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setName(String name)
/*     */   {
/* 126 */     this.name = name;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public IdentityDocument getIdentityDocument()
/*     */   {
/* 133 */     return this.identityDocument;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setIdentityDocument(IdentityDocument identityDocument)
/*     */   {
/* 140 */     this.identityDocument = identityDocument;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public User getCreateUser()
/*     */   {
/* 147 */     return this.createUser;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCreateUser(User createUser)
/*     */   {
/* 154 */     this.createUser = createUser;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Date getCreateDate()
/*     */   {
/* 161 */     return this.createDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCreateDate(Date createDate)
/*     */   {
/* 168 */     this.createDate = createDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public User getEditUser()
/*     */   {
/* 175 */     return this.editUser;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setEditUser(User editUser)
/*     */   {
/* 182 */     this.editUser = editUser;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Date getEditDate()
/*     */   {
/* 189 */     return this.editDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setEditDate(Date editDate)
/*     */   {
/* 196 */     this.editDate = editDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Boolean getActive()
/*     */   {
/* 203 */     return this.active;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setActive(Boolean active)
/*     */   {
/* 210 */     this.active = active;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getAddress()
/*     */   {
/* 217 */     return this.address;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setAddress(String address)
/*     */   {
/* 224 */     this.address = address;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Long getPoints()
/*     */   {
/* 231 */     return this.points;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setPoints(Long points)
/*     */   {
/* 238 */     this.points = points;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getRepresentative()
/*     */   {
/* 245 */     return this.representative;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setRepresentative(String representative)
/*     */   {
/* 252 */     this.representative = representative;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Boolean getCustomer()
/*     */   {
/* 259 */     return this.customer;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCustomer(Boolean customer)
/*     */   {
/* 266 */     this.customer = customer;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Boolean getSupplier()
/*     */   {
/* 273 */     return this.supplier;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSupplier(Boolean supplier)
/*     */   {
/* 280 */     this.supplier = supplier;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getOther()
/*     */   {
/* 287 */     return this.other;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setOther(String other)
/*     */   {
/* 294 */     this.other = other;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Ubigeo getUbigeo()
/*     */   {
/* 301 */     return this.ubigeo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setUbigeo(Ubigeo ubigeo)
/*     */   {
/* 308 */     this.ubigeo = ubigeo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Boolean getSynchronized_()
/*     */   {
/* 315 */     return this.synchronized_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSynchronized_(Boolean synchronized_)
/*     */   {
/* 322 */     this.synchronized_ = synchronized_;
/*     */   }
/*     */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\model\Actor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */