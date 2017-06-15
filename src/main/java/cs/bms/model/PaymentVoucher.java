/*     */ package cs.bms.model;
/*     */ 
/*     */ import gkfire.auditory.AuditoryEntity;
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
/*     */ 
/*     */ 
/*     */ @Entity
/*     */ @Table(name="payment_voucher", catalog="public")
/*     */ @XmlRootElement
/*     */ public class PaymentVoucher
/*     */   implements AuditoryEntity<Long, User>
/*     */ {
/*     */   @Id
/*     */   @GeneratedValue(strategy=GenerationType.IDENTITY)
/*     */   @Column(name="id", nullable=false)
/*     */   protected Long id;
/*     */   @Column(name="value", nullable=false)
/*     */   protected Integer value;
/*     */   @Column(name="numeration", nullable=false)
/*     */   protected String numeration;
/*     */   @Column(name="date_expiry", nullable=false)
/*     */   @Temporal(TemporalType.DATE)
/*     */   protected Date dateExpiry;
/*     */   @JoinColumn(name="id_sale")
/*     */   @ManyToOne
/*     */   protected Sale sale;
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
/*     */   
/*     */   public Long getId()
/*     */   {
/*  63 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/*  70 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Integer getValue()
/*     */   {
/*  77 */     return this.value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setValue(Integer value)
/*     */   {
/*  84 */     this.value = value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getNumeration()
/*     */   {
/*  92 */     return this.numeration;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setNumeration(String numeration)
/*     */   {
/*  99 */     this.numeration = numeration;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Date getDateExpiry()
/*     */   {
/* 106 */     return this.dateExpiry;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setDateExpiry(Date dateExpiry)
/*     */   {
/* 113 */     this.dateExpiry = dateExpiry;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Sale getSale()
/*     */   {
/* 120 */     return this.sale;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSale(Sale sale)
/*     */   {
/* 127 */     this.sale = sale;
/*     */   }
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
/*     */   public void setCreateUser(User createUser)
/*     */   {
/* 141 */     this.createUser = createUser;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Date getCreateDate()
/*     */   {
/* 148 */     return this.createDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCreateDate(Date createDate)
/*     */   {
/* 155 */     this.createDate = createDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public User getEditUser()
/*     */   {
/* 162 */     return this.editUser;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setEditUser(User editUser)
/*     */   {
/* 169 */     this.editUser = editUser;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Date getEditDate()
/*     */   {
/* 176 */     return this.editDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setEditDate(Date editDate)
/*     */   {
/* 183 */     this.editDate = editDate;
/*     */   }
/*     */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\model\PaymentVoucher.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */