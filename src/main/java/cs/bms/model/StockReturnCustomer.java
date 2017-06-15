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
/*     */ 
/*     */ @Entity
/*     */ @Table(name="stock_return_customer", catalog="public")
/*     */ @XmlRootElement
/*     */ public class StockReturnCustomer
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
/*     */   @JoinColumn(name="id_sale", nullable=false)
/*     */   @ManyToOne
/*     */   private Sale sale;
/*     */   @Column(name="repayment", nullable=false)
/*  56 */   private BigDecimal repayment = BigDecimal.ZERO;
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
/*  72 */   private Boolean active = Boolean.TRUE;
/*     */   @Column(name="send", nullable=false)
/*  74 */   private Boolean send = Boolean.FALSE;
/*     */   
/*     */ 
/*     */   @JoinColumn(name="id_operation_type", nullable=false)
/*     */   @ManyToOne(fetch=FetchType.LAZY)
/*     */   private OperationType operationType;
/*     */   
/*     */ 
/*     */ 
/*     */   public Long getId()
/*     */   {
/*  85 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/*  93 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getSerie()
/*     */   {
/* 100 */     return this.serie;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSerie(String serie)
/*     */   {
/* 107 */     this.serie = serie;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getDocumentNumber()
/*     */   {
/* 114 */     return this.documentNumber;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setDocumentNumber(String documentNumber)
/*     */   {
/* 121 */     this.documentNumber = documentNumber;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public PaymentProof getPaymentProof()
/*     */   {
/* 128 */     return this.paymentProof;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setPaymentProof(PaymentProof paymentProof)
/*     */   {
/* 135 */     this.paymentProof = paymentProof;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Date getDateIssue()
/*     */   {
/* 142 */     return this.dateIssue;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setDateIssue(Date dateIssue)
/*     */   {
/* 149 */     this.dateIssue = dateIssue;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Sale getSale()
/*     */   {
/* 156 */     return this.sale;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSale(Sale sale)
/*     */   {
/* 163 */     this.sale = sale;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public BigDecimal getRepayment()
/*     */   {
/* 170 */     return this.repayment;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setRepayment(BigDecimal repayment)
/*     */   {
/* 177 */     this.repayment = repayment;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public User getCreateUser()
/*     */   {
/* 184 */     return this.createUser;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCreateUser(User createUser)
/*     */   {
/* 191 */     this.createUser = createUser;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Date getCreateDate()
/*     */   {
/* 198 */     return this.createDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCreateDate(Date createDate)
/*     */   {
/* 205 */     this.createDate = createDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public User getEditUser()
/*     */   {
/* 212 */     return this.editUser;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setEditUser(User editUser)
/*     */   {
/* 219 */     this.editUser = editUser;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Date getEditDate()
/*     */   {
/* 226 */     return this.editDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setEditDate(Date editDate)
/*     */   {
/* 233 */     this.editDate = editDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Boolean getActive()
/*     */   {
/* 240 */     return this.active;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setActive(Boolean active)
/*     */   {
/* 247 */     this.active = active;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Boolean getSend()
/*     */   {
/* 254 */     return this.send;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSend(Boolean send)
/*     */   {
/* 261 */     this.send = send;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public OperationType getOperationType()
/*     */   {
/* 268 */     return this.operationType;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setOperationType(OperationType operationType)
/*     */   {
/* 275 */     this.operationType = operationType;
/*     */   }
/*     */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\model\StockReturnCustomer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */