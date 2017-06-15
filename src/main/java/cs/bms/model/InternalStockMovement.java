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
/*     */ @Table(name="internal_stock_movement", catalog="public")
/*     */ @XmlRootElement
/*     */ public class InternalStockMovement
/*     */   implements AuditoryEntity<Long, User>, EntityActivate
/*     */ {
/*     */   @Id
/*     */   @GeneratedValue(strategy=GenerationType.IDENTITY)
/*     */   @Column(name="id", nullable=false)
/*     */   private Long id;
/*     */   @JoinColumn(name="id_payment_proof", nullable=false)
/*     */   @ManyToOne
/*     */   private PaymentProof paymentProof;
/*     */   @Column(name="serie", nullable=false)
/*     */   private String serie;
/*     */   @Column(name="document_number", nullable=false)
/*     */   private String documentNumber;
/*     */   @JoinColumn(name="id_source_company", nullable=false)
/*     */   @ManyToOne
/*     */   private Company sourceCompany;
/*     */   @JoinColumn(name="id_target_company", nullable=false)
/*     */   @ManyToOne
/*     */   private Company targetCompany;
/*     */   @JoinColumn(name="id_carrier")
/*     */   @ManyToOne
/*     */   private Actor carrier;
/*     */   @Column(name="date_shipping", nullable=false)
/*     */   @Temporal(TemporalType.TIMESTAMP)
/*  58 */   private Date dateShipping = new Date();
/*     */   @Column(name="date_arrival")
/*     */   @Temporal(TemporalType.TIMESTAMP)
/*  61 */   private Date dateArrival = new Date();
/*     */   
/*     */   @Column(name="date_real_arrival")
/*     */   @Temporal(TemporalType.TIMESTAMP)
/*     */   private Date dateRealArrival;
/*     */   
/*     */   @Column(name="transport_description")
/*     */   private String transportDescription;
/*     */   
/*     */   @Column(name="driver_license")
/*     */   private String driverLicense;
/*     */   
/*     */   @JoinColumn(name="id_operation_type_source", nullable=true)
/*     */   @ManyToOne(fetch=FetchType.LAZY)
/*     */   private OperationType operationTypeSource;
/*     */   @JoinColumn(name="id_operation_type_target", nullable=true)
/*     */   @ManyToOne(fetch=FetchType.LAZY)
/*     */   private OperationType operationTypeTarget;
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
/*  92 */   private Boolean active = Boolean.TRUE;
/*     */   @Column(name="electronic", nullable=false)
/*  94 */   private Boolean electronic = Boolean.TRUE;
/*     */   @Column(name="sent", nullable=false)
/*  96 */   private Boolean sent = Boolean.FALSE;
/*     */   
/*     */ 
/*     */   @Formula("(serie||'-'||document_number)")
/*     */   private String fullDocument;
/*     */   
/*     */ 
/*     */   public Long getId()
/*     */   {
/* 105 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/* 112 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public PaymentProof getPaymentProof()
/*     */   {
/* 119 */     return this.paymentProof;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setPaymentProof(PaymentProof paymentProof)
/*     */   {
/* 126 */     this.paymentProof = paymentProof;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getSerie()
/*     */   {
/* 133 */     return this.serie;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSerie(String serie)
/*     */   {
/* 140 */     this.serie = serie;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getDocumentNumber()
/*     */   {
/* 147 */     return this.documentNumber;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setDocumentNumber(String documentNumber)
/*     */   {
/* 154 */     this.documentNumber = documentNumber;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Company getSourceCompany()
/*     */   {
/* 161 */     return this.sourceCompany;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSourceCompany(Company sourceCompany)
/*     */   {
/* 168 */     this.sourceCompany = sourceCompany;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Company getTargetCompany()
/*     */   {
/* 175 */     return this.targetCompany;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setTargetCompany(Company targetCompany)
/*     */   {
/* 182 */     this.targetCompany = targetCompany;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Actor getCarrier()
/*     */   {
/* 189 */     return this.carrier;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCarrier(Actor carrier)
/*     */   {
/* 196 */     this.carrier = carrier;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Date getDateShipping()
/*     */   {
/* 203 */     return this.dateShipping;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setDateShipping(Date dateShipping)
/*     */   {
/* 210 */     this.dateShipping = dateShipping;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Date getDateArrival()
/*     */   {
/* 217 */     return this.dateArrival;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setDateArrival(Date dateArrival)
/*     */   {
/* 224 */     this.dateArrival = dateArrival;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getTransportDescription()
/*     */   {
/* 231 */     return this.transportDescription;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setTransportDescription(String transportDescription)
/*     */   {
/* 238 */     this.transportDescription = transportDescription;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getDriverLicense()
/*     */   {
/* 245 */     return this.driverLicense;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setDriverLicense(String driverLicense)
/*     */   {
/* 252 */     this.driverLicense = driverLicense;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public User getCreateUser()
/*     */   {
/* 259 */     return this.createUser;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCreateUser(User createUser)
/*     */   {
/* 266 */     this.createUser = createUser;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Date getCreateDate()
/*     */   {
/* 273 */     return this.createDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCreateDate(Date createDate)
/*     */   {
/* 280 */     this.createDate = createDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public User getEditUser()
/*     */   {
/* 287 */     return this.editUser;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setEditUser(User editUser)
/*     */   {
/* 294 */     this.editUser = editUser;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Date getEditDate()
/*     */   {
/* 301 */     return this.editDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setEditDate(Date editDate)
/*     */   {
/* 308 */     this.editDate = editDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Boolean getActive()
/*     */   {
/* 315 */     return this.active;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setActive(Boolean active)
/*     */   {
/* 322 */     this.active = active;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getFullDocument()
/*     */   {
/* 329 */     return this.fullDocument;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setFullDocument(String fullDocument)
/*     */   {
/* 336 */     this.fullDocument = fullDocument;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Date getDateRealArrival()
/*     */   {
/* 343 */     return this.dateRealArrival;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setDateRealArrival(Date dateRealArrival)
/*     */   {
/* 350 */     this.dateRealArrival = dateRealArrival;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Boolean getElectronic()
/*     */   {
/* 357 */     return this.electronic;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setElectronic(Boolean electronic)
/*     */   {
/* 364 */     this.electronic = electronic;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Boolean getSent()
/*     */   {
/* 371 */     return this.sent;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSent(Boolean sent)
/*     */   {
/* 378 */     this.sent = sent;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public OperationType getOperationTypeSource()
/*     */   {
/* 385 */     return this.operationTypeSource;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setOperationTypeSource(OperationType operationTypeSource)
/*     */   {
/* 392 */     this.operationTypeSource = operationTypeSource;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public OperationType getOperationTypeTarget()
/*     */   {
/* 399 */     return this.operationTypeTarget;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setOperationTypeTarget(OperationType operationTypeTarget)
/*     */   {
/* 406 */     this.operationTypeTarget = operationTypeTarget;
/*     */   }
/*     */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\model\InternalStockMovement.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */