/*     */ package cs.bms.model;
/*     */ 
/*     */ import gkfire.auditory.AuditoryEntity;
/*     */ import gkfire.model.interfac.EntityActivate;
/*     */ import java.math.BigDecimal;
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
/*     */ @Table(name="purchase_payment", catalog="public")
/*     */ @XmlRootElement
/*     */ public class PurchasePayment
/*     */   implements AuditoryEntity<Long, User>, EntityActivate
/*     */ {
/*     */   @Id
/*     */   @GeneratedValue(strategy=GenerationType.IDENTITY)
/*     */   @Column(name="id", nullable=false)
/*     */   protected Long id;
/*     */   @JoinColumn(name="id_purchase", nullable=true)
/*     */   @ManyToOne(fetch=FetchType.LAZY)
/*     */   protected Purchase purchase;
/*     */   @Column(name="date_payment", nullable=false)
/*     */   @Temporal(TemporalType.TIMESTAMP)
/*     */   protected Date datePayment;
/*     */   @Column(name="quantity", nullable=false)
/*     */   protected BigDecimal quantity;
/*     */   @Column(name="description", nullable=false)
/*     */   protected String description;
/*     */   @JoinColumn(name="id_company_disbursement", nullable=true)
/*     */   @ManyToOne(fetch=FetchType.LAZY)
/*     */   protected Company companyDisbursement;
/*     */   @JoinColumn(name="create_uid", nullable=false)
/*     */   @ManyToOne(fetch=FetchType.LAZY)
/*     */   protected User createUser;
/*     */   @Column(name="create_date", nullable=false)
/*     */   @Temporal(TemporalType.TIMESTAMP)
/*     */   protected Date createDate;
/*     */   @JoinColumn(name="edit_uid", nullable=false)
/*     */   @ManyToOne(fetch=FetchType.LAZY)
/*     */   protected User editUser;
/*     */   @Column(name="edit_date", nullable=false)
/*     */   @Temporal(TemporalType.TIMESTAMP)
/*     */   protected Date editDate;
/*     */   @Column(name="active", nullable=false)
/*  64 */   protected Boolean active = Boolean.TRUE;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getId()
/*     */   {
/*  71 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/*  78 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Purchase getPurchase()
/*     */   {
/*  85 */     return this.purchase;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setPurchase(Purchase purchase)
/*     */   {
/*  92 */     this.purchase = purchase;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Date getDatePayment()
/*     */   {
/*  99 */     return this.datePayment;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setDatePayment(Date datePayment)
/*     */   {
/* 106 */     this.datePayment = datePayment;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public BigDecimal getQuantity()
/*     */   {
/* 113 */     return this.quantity;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setQuantity(BigDecimal quantity)
/*     */   {
/* 120 */     this.quantity = quantity;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public User getCreateUser()
/*     */   {
/* 127 */     return this.createUser;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCreateUser(User createUser)
/*     */   {
/* 134 */     this.createUser = createUser;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Date getCreateDate()
/*     */   {
/* 141 */     return this.createDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCreateDate(Date createDate)
/*     */   {
/* 148 */     this.createDate = createDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getDescription()
/*     */   {
/* 155 */     return this.description;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setDescription(String description)
/*     */   {
/* 162 */     this.description = description;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Company getCompanyDisbursement()
/*     */   {
/* 169 */     return this.companyDisbursement;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCompanyDisbursement(Company companyDisbursement)
/*     */   {
/* 176 */     this.companyDisbursement = companyDisbursement;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public User getEditUser()
/*     */   {
/* 183 */     return this.editUser;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setEditUser(User editUser)
/*     */   {
/* 190 */     this.editUser = editUser;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Date getEditDate()
/*     */   {
/* 197 */     return this.editDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setEditDate(Date editDate)
/*     */   {
/* 204 */     this.editDate = editDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean isActive()
/*     */   {
/* 211 */     return this.active.booleanValue();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Boolean getActive()
/*     */   {
/* 218 */     return this.active;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setActive(Boolean active)
/*     */   {
/* 225 */     this.active = active;
/*     */   }
/*     */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\model\PurchasePayment.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */