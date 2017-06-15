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
/*     */ import org.hibernate.annotations.Formula;
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
/*     */ @Table(name="sale", catalog="public")
/*     */ @XmlRootElement
/*     */ public class Sale
/*     */   implements AuditoryEntity<Long, User>, EntityActivate
/*     */ {
/*     */   @Id
/*     */   @GeneratedValue(strategy=GenerationType.IDENTITY)
/*     */   @Column(name="id", nullable=false)
/*     */   protected Long id;
/*     */   @Column(name="serie", nullable=false)
/*     */   protected String serie;
/*     */   @Column(name="document_number", nullable=false)
/*     */   protected String documentNumber;
/*     */   @JoinColumn(name="id_payment_proof", nullable=false)
/*     */   @ManyToOne
/*     */   protected PaymentProof paymentProof;
/*     */   @Column(name="electronic", nullable=false)
/*  49 */   protected Boolean electronic = Boolean.FALSE;
/*     */   @Column(name="sent", nullable=false)
/*  51 */   protected Boolean sent = Boolean.FALSE;
/*     */   @Column(name="visa", nullable=false)
/*  53 */   protected Boolean visa = Boolean.FALSE;
/*     */   @Column(name="verified", nullable=false)
/*  55 */   protected Boolean verified = Boolean.FALSE;
/*     */   
/*     */   @JoinColumn(name="id_customer", nullable=true)
/*     */   @ManyToOne
/*     */   protected Actor customer;
/*     */   @Column(name="customer_name")
/*     */   protected String customerName;
/*     */   @Column(name="points")
/*  63 */   protected Long points = Long.valueOf(0L); @Column(name="subtotal", nullable=false)
/*  64 */   protected BigDecimal subtotal = BigDecimal.ZERO;
/*     */   @Column(name="igv", nullable=false)
/*  66 */   protected BigDecimal igv = BigDecimal.ZERO;
/*     */   @Column(name="subtotal_discount", nullable=false)
/*  68 */   protected BigDecimal subtotalDiscount = BigDecimal.ZERO;
/*     */   @Column(name="igv_discount", nullable=false)
/*  70 */   protected BigDecimal igvDiscount = BigDecimal.ZERO;
/*     */   
/*     */   @JoinColumn(name="id_company", nullable=false)
/*     */   @ManyToOne
/*     */   protected Company company;
/*     */   
/*     */   @Column(name="date_issue", nullable=false)
/*     */   @Temporal(TemporalType.TIMESTAMP)
/*     */   protected Date dateIssue;
/*     */   
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
/*  93 */   protected Boolean active = Boolean.TRUE;
/*     */   @Formula("(subtotal + igv - subtotal_discount)")
/*     */   protected BigDecimal total;
/*     */   @Formula("(serie||'-'||document_number)")
/*     */   protected String fullDocument;
/*     */   
/*     */   public Sale(Long id)
/*     */   {
/* 101 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Sale() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public Long getId()
/*     */   {
/* 113 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/* 120 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getSerie()
/*     */   {
/* 127 */     return this.serie;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSerie(String serie)
/*     */   {
/* 134 */     this.serie = serie;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getDocumentNumber()
/*     */   {
/* 141 */     return this.documentNumber;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setDocumentNumber(String documentNumber)
/*     */   {
/* 148 */     this.documentNumber = documentNumber;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public PaymentProof getPaymentProof()
/*     */   {
/* 155 */     return this.paymentProof;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setPaymentProof(PaymentProof paymentProof)
/*     */   {
/* 162 */     this.paymentProof = paymentProof;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Boolean getElectronic()
/*     */   {
/* 169 */     return this.electronic;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setElectronic(Boolean electronic)
/*     */   {
/* 176 */     this.electronic = electronic;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Actor getCustomer()
/*     */   {
/* 183 */     return this.customer;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCustomer(Actor customer)
/*     */   {
/* 190 */     this.customer = customer;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getCustomerName()
/*     */   {
/* 197 */     return this.customerName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCustomerName(String customerName)
/*     */   {
/* 204 */     this.customerName = customerName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public BigDecimal getSubtotal()
/*     */   {
/* 211 */     return this.subtotal;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSubtotal(BigDecimal subtotal)
/*     */   {
/* 218 */     this.subtotal = subtotal;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public BigDecimal getIgv()
/*     */   {
/* 225 */     return this.igv;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setIgv(BigDecimal igv)
/*     */   {
/* 232 */     this.igv = igv;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public BigDecimal getSubtotalDiscount()
/*     */   {
/* 239 */     return this.subtotalDiscount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSubtotalDiscount(BigDecimal subtotalDiscount)
/*     */   {
/* 246 */     this.subtotalDiscount = subtotalDiscount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public BigDecimal getIgvDiscount()
/*     */   {
/* 253 */     return this.igvDiscount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setIgvDiscount(BigDecimal igvDiscount)
/*     */   {
/* 260 */     this.igvDiscount = igvDiscount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public User getCreateUser()
/*     */   {
/* 267 */     return this.createUser;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCreateUser(User createUser)
/*     */   {
/* 274 */     this.createUser = createUser;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Date getCreateDate()
/*     */   {
/* 281 */     return this.createDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCreateDate(Date createDate)
/*     */   {
/* 288 */     this.createDate = createDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public User getEditUser()
/*     */   {
/* 295 */     return this.editUser;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setEditUser(User editUser)
/*     */   {
/* 302 */     this.editUser = editUser;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Date getEditDate()
/*     */   {
/* 309 */     return this.editDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setEditDate(Date editDate)
/*     */   {
/* 316 */     this.editDate = editDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Boolean getActive()
/*     */   {
/* 323 */     return this.active;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setActive(Boolean active)
/*     */   {
/* 330 */     this.active = active;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Company getCompany()
/*     */   {
/* 337 */     return this.company;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCompany(Company company)
/*     */   {
/* 344 */     this.company = company;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Date getDateIssue()
/*     */   {
/* 351 */     return this.dateIssue;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setDateIssue(Date dateIssue)
/*     */   {
/* 358 */     this.dateIssue = dateIssue;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Long getPoints()
/*     */   {
/* 365 */     return this.points;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setPoints(Long points)
/*     */   {
/* 372 */     this.points = points;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public BigDecimal getTotal()
/*     */   {
/* 379 */     return this.total;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setTotal(BigDecimal total)
/*     */   {
/* 386 */     this.total = total;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getFullDocument()
/*     */   {
/* 393 */     return this.fullDocument;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setFullDocument(String fullDocument)
/*     */   {
/* 400 */     this.fullDocument = fullDocument;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Boolean getSent()
/*     */   {
/* 407 */     return this.sent;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSent(Boolean sent)
/*     */   {
/* 414 */     this.sent = sent;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Boolean getVerified()
/*     */   {
/* 421 */     return this.verified;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setVerified(Boolean verified)
/*     */   {
/* 428 */     this.verified = verified;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Boolean getVisa()
/*     */   {
/* 435 */     return this.visa;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setVisa(Boolean visa)
/*     */   {
/* 442 */     this.visa = visa;
/*     */   }
/*     */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\model\Sale.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */