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
/*     */ @Entity
/*     */ @Table(name="purchase", catalog="public")
/*     */ @XmlRootElement
/*     */ public class Purchase
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
/*     */   @Column(name="electronic", nullable=false)
/*  46 */   private Boolean electronic = Boolean.FALSE;
/*     */   @JoinColumn(name="id_supplier", nullable=false)
/*     */   @ManyToOne
/*     */   private Actor supplier;
/*     */   @Column(name="supplier_name", nullable=false)
/*     */   private String supplierName;
/*     */   @Column(name="subtotal", nullable=false)
/*  53 */   private BigDecimal subtotal = BigDecimal.ZERO;
/*     */   @Column(name="igv", nullable=false)
/*  55 */   private BigDecimal igv = BigDecimal.ZERO;
/*     */   @Column(name="subtotal_discount", nullable=false)
/*  57 */   private BigDecimal subtotalDiscount = BigDecimal.ZERO;
/*     */   @Column(name="igv_discount", nullable=false)
/*  59 */   private BigDecimal igvDiscount = BigDecimal.ZERO;
/*     */   
/*     */   @JoinColumn(name="id_company_arrival", nullable=false)
/*     */   @ManyToOne(fetch=FetchType.LAZY)
/*     */   private Company companyArrival;
/*     */   
/*     */   @Column(name="date_issue", nullable=false)
/*     */   @Temporal(TemporalType.TIMESTAMP)
/*     */   private Date dateIssue;
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
/*  83 */   private Boolean active = Boolean.TRUE;
/*     */   
/*     */   @Formula("(subtotal + igv - subtotal_discount)")
/*     */   private BigDecimal total;
/*     */   
/*     */   @Formula("(serie||'-'||document_number)")
/*     */   private String fullDocument;
/*     */   
/*     */   public Purchase() {}
/*     */   
/*     */   public Purchase(Long id)
/*     */   {
/*  95 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getId()
/*     */   {
/* 103 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/* 110 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getSerie()
/*     */   {
/* 117 */     return this.serie;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSerie(String serie)
/*     */   {
/* 124 */     this.serie = serie;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getDocumentNumber()
/*     */   {
/* 131 */     return this.documentNumber;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setDocumentNumber(String documentNumber)
/*     */   {
/* 138 */     this.documentNumber = documentNumber;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public PaymentProof getPaymentProof()
/*     */   {
/* 145 */     return this.paymentProof;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setPaymentProof(PaymentProof paymentProof)
/*     */   {
/* 152 */     this.paymentProof = paymentProof;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Boolean getElectronic()
/*     */   {
/* 159 */     return this.electronic;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setElectronic(Boolean electronic)
/*     */   {
/* 166 */     this.electronic = electronic;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Actor getSupplier()
/*     */   {
/* 173 */     return this.supplier;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSupplier(Actor supplier)
/*     */   {
/* 180 */     this.supplier = supplier;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getSupplierName()
/*     */   {
/* 187 */     return this.supplierName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSupplierName(String supplierName)
/*     */   {
/* 194 */     this.supplierName = supplierName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public BigDecimal getSubtotal()
/*     */   {
/* 201 */     return this.subtotal;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSubtotal(BigDecimal subtotal)
/*     */   {
/* 208 */     this.subtotal = subtotal;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public BigDecimal getIgv()
/*     */   {
/* 215 */     return this.igv;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setIgv(BigDecimal igv)
/*     */   {
/* 222 */     this.igv = igv;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public BigDecimal getSubtotalDiscount()
/*     */   {
/* 229 */     return this.subtotalDiscount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSubtotalDiscount(BigDecimal subtotalDiscount)
/*     */   {
/* 236 */     this.subtotalDiscount = subtotalDiscount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public BigDecimal getIgvDiscount()
/*     */   {
/* 243 */     return this.igvDiscount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setIgvDiscount(BigDecimal igvDiscount)
/*     */   {
/* 250 */     this.igvDiscount = igvDiscount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Company getCompanyArrival()
/*     */   {
/* 257 */     return this.companyArrival;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCompanyArrival(Company companyArrival)
/*     */   {
/* 264 */     this.companyArrival = companyArrival;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public User getCreateUser()
/*     */   {
/* 271 */     return this.createUser;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCreateUser(User createUser)
/*     */   {
/* 278 */     this.createUser = createUser;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Date getCreateDate()
/*     */   {
/* 285 */     return this.createDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCreateDate(Date createDate)
/*     */   {
/* 292 */     this.createDate = createDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public User getEditUser()
/*     */   {
/* 299 */     return this.editUser;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setEditUser(User editUser)
/*     */   {
/* 306 */     this.editUser = editUser;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Date getEditDate()
/*     */   {
/* 313 */     return this.editDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setEditDate(Date editDate)
/*     */   {
/* 320 */     this.editDate = editDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Boolean getActive()
/*     */   {
/* 327 */     return this.active;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setActive(Boolean active)
/*     */   {
/* 334 */     this.active = active;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public BigDecimal getTotal()
/*     */   {
/* 341 */     return this.total;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setTotal(BigDecimal total)
/*     */   {
/* 348 */     this.total = total;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getFullDocument()
/*     */   {
/* 355 */     return this.fullDocument;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setFullDocument(String fullDocument)
/*     */   {
/* 362 */     this.fullDocument = fullDocument;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Date getDateIssue()
/*     */   {
/* 369 */     return this.dateIssue;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setDateIssue(Date dateIssue)
/*     */   {
/* 376 */     this.dateIssue = dateIssue;
/*     */   }
/*     */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\model\Purchase.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */