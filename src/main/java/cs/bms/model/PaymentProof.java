/*     */ package cs.bms.model;
/*     */ 
/*     */ import gkfire.auditory.AuditoryEntity;
/*     */ import gkfire.model.interfac.EntityActivate;
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
/*     */ import javax.validation.constraints.Digits;
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
/*     */ @Entity
/*     */ @Table(name="payment_proof", catalog="public")
/*     */ @XmlRootElement
/*     */ public class PaymentProof
/*     */   implements Serializable, AuditoryEntity<Short, User>, EntityActivate
/*     */ {
/*     */   @Id
/*     */   @GeneratedValue(strategy=GenerationType.IDENTITY)
/*     */   @Column(name="id", nullable=false)
/*     */   private Short id;
/*     */   @Column(name="code", nullable=false)
/*     */   @Size(max=2)
/*     */   @Digits(fraction=0, integer=2)
/*     */   private String code;
/*     */   @Column(name="abbr", nullable=false)
/*     */   @Size(max=10)
/*     */   private String abbr;
/*     */   @Column(name="name", nullable=false)
/*     */   @Size(max=380)
/*     */   private String name;
/*     */   @Column(name="for_sale", nullable=false)
/*  51 */   private Boolean forSale = Boolean.FALSE;
/*     */   @Column(name="for_purchase", nullable=false)
/*  53 */   private Boolean forPurchase = Boolean.FALSE;
/*     */   @Column(name="for_stored", nullable=false)
/*  55 */   private Boolean forStored = Boolean.FALSE;
/*     */   @Column(name="for_return", nullable=false)
/*  57 */   private Boolean forReturn = Boolean.FALSE;
/*     */   
/*     */   @JoinColumn(name="create_uid", nullable=false)
/*     */   @ManyToOne(fetch=FetchType.LAZY)
/*     */   private User createUser;
/*     */   
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
/*  73 */   private Boolean active = Boolean.TRUE;
/*     */   
/*     */   public PaymentProof(Short id)
/*     */   {
/*  77 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public PaymentProof() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Short getId()
/*     */   {
/*  90 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setId(Short id)
/*     */   {
/*  98 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getCode()
/*     */   {
/* 105 */     return this.code;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCode(String code)
/*     */   {
/* 112 */     this.code = code;
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
/*     */ 
/*     */   public User getCreateUser()
/*     */   {
/* 134 */     return this.createUser;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCreateUser(User createUser)
/*     */   {
/* 142 */     this.createUser = createUser;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Date getCreateDate()
/*     */   {
/* 150 */     return this.createDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCreateDate(Date createDate)
/*     */   {
/* 158 */     this.createDate = createDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public User getEditUser()
/*     */   {
/* 166 */     return this.editUser;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setEditUser(User editUser)
/*     */   {
/* 174 */     this.editUser = editUser;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Date getEditDate()
/*     */   {
/* 182 */     return this.editDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setEditDate(Date editDate)
/*     */   {
/* 190 */     this.editDate = editDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Boolean getActive()
/*     */   {
/* 197 */     return this.active;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setActive(Boolean active)
/*     */   {
/* 204 */     this.active = active;
/*     */   }
/*     */   
/*     */ 
/*     */   public String getAbbr()
/*     */   {
/* 210 */     return this.abbr;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setAbbr(String abbr)
/*     */   {
/* 217 */     this.abbr = abbr;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Boolean getForSale()
/*     */   {
/* 224 */     return this.forSale;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setForSale(Boolean forSale)
/*     */   {
/* 231 */     this.forSale = forSale;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Boolean getForPurchase()
/*     */   {
/* 238 */     return this.forPurchase;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setForPurchase(Boolean forPurchase)
/*     */   {
/* 245 */     this.forPurchase = forPurchase;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Boolean getForStored()
/*     */   {
/* 252 */     return this.forStored;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setForStored(Boolean forStored)
/*     */   {
/* 259 */     this.forStored = forStored;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Boolean getForReturn()
/*     */   {
/* 266 */     return this.forReturn;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setForReturn(Boolean forReturn)
/*     */   {
/* 273 */     this.forReturn = forReturn;
/*     */   }
/*     */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\model\PaymentProof.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */