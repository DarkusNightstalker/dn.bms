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
/*     */ 
/*     */ 
/*     */ 
/*     */ @Entity
/*     */ @Table(name="stock_return_supplier", catalog="public")
/*     */ @XmlRootElement
/*     */ public class StockReturnSupplier
/*     */   implements AuditoryEntity<Long, User>, EntityActivate
/*     */ {
/*     */   @Id
/*     */   @GeneratedValue(strategy=GenerationType.IDENTITY)
/*     */   @Column(name="id", nullable=false)
/*     */   private Long id;
/*     */   @Column(name="serie", nullable=false)
/*     */   private String serie;
/*     */   @Column(name="document_number", nullable=false)
/*     */   private String documentNumber;
/*     */   @JoinColumn(name="id_payment_proof", nullable=false)
/*     */   @ManyToOne
/*     */   private PaymentProof paymentProof;
/*     */   @Column(name="date_issue", nullable=false)
/*     */   @Temporal(TemporalType.DATE)
/*     */   private Date dateIssue;
/*     */   @JoinColumn(name="id_purchase", nullable=false)
/*     */   @ManyToOne
/*     */   private Purchase purchase;
/*     */   @Column(name="subtotal", nullable=false)
/*  55 */   private BigDecimal subtotal = BigDecimal.ZERO;
/*     */   @Column(name="igv", nullable=false)
/*  57 */   private BigDecimal igv = BigDecimal.ZERO;
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
/*     */ 
/*     */   @JoinColumn(name="id_operation_type", nullable=false)
/*     */   @ManyToOne(fetch=FetchType.LAZY)
/*     */   private OperationType operationType;
/*     */   
/*     */ 
/*     */   public Long getId()
/*     */   {
/*  83 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/*  90 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getSerie()
/*     */   {
/*  97 */     return this.serie;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSerie(String serie)
/*     */   {
/* 104 */     this.serie = serie;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getDocumentNumber()
/*     */   {
/* 111 */     return this.documentNumber;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setDocumentNumber(String documentNumber)
/*     */   {
/* 118 */     this.documentNumber = documentNumber;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public PaymentProof getPaymentProof()
/*     */   {
/* 125 */     return this.paymentProof;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setPaymentProof(PaymentProof paymentProof)
/*     */   {
/* 132 */     this.paymentProof = paymentProof;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Date getDateIssue()
/*     */   {
/* 139 */     return this.dateIssue;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setDateIssue(Date dateIssue)
/*     */   {
/* 146 */     this.dateIssue = dateIssue;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Purchase getPurchase()
/*     */   {
/* 153 */     return this.purchase;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setPurchase(Purchase purchase)
/*     */   {
/* 160 */     this.purchase = purchase;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public BigDecimal getSubtotal()
/*     */   {
/* 167 */     return this.subtotal;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSubtotal(BigDecimal subtotal)
/*     */   {
/* 174 */     this.subtotal = subtotal;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public BigDecimal getIgv()
/*     */   {
/* 181 */     return this.igv;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setIgv(BigDecimal igv)
/*     */   {
/* 188 */     this.igv = igv;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public User getCreateUser()
/*     */   {
/* 195 */     return this.createUser;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCreateUser(User createUser)
/*     */   {
/* 202 */     this.createUser = createUser;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Date getCreateDate()
/*     */   {
/* 209 */     return this.createDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCreateDate(Date createDate)
/*     */   {
/* 216 */     this.createDate = createDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public User getEditUser()
/*     */   {
/* 223 */     return this.editUser;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setEditUser(User editUser)
/*     */   {
/* 230 */     this.editUser = editUser;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Date getEditDate()
/*     */   {
/* 237 */     return this.editDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setEditDate(Date editDate)
/*     */   {
/* 244 */     this.editDate = editDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Boolean getActive()
/*     */   {
/* 251 */     return this.active;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setActive(Boolean active)
/*     */   {
/* 258 */     this.active = active;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public OperationType getOperationType()
/*     */   {
/* 265 */     return this.operationType;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setOperationType(OperationType operationType)
/*     */   {
/* 272 */     this.operationType = operationType;
/*     */   }
/*     */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\model\StockReturnSupplier.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */