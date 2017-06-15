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
/*     */ 
/*     */ 
/*     */ 
/*     */ @Entity
/*     */ @Table(name="stock_reduction", catalog="public")
/*     */ @XmlRootElement
/*     */ public class StockReduction
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
/*     */   @JoinColumn(name="id_responsible", nullable=false)
/*     */   @ManyToOne
/*     */   private Actor responsible;
/*     */   @JoinColumn(name="id_company", nullable=false)
/*     */   @ManyToOne
/*     */   private Company company;
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
/*  72 */   private Boolean active = Boolean.TRUE;
/*     */   
/*     */   @Formula("(serie||'-'||document_number)")
/*     */   private String fullDocument;
/*     */   
/*     */   @JoinColumn(name="id_operation_type", nullable=false)
/*     */   @ManyToOne(fetch=FetchType.LAZY)
/*     */   private OperationType operationType;
/*     */   
/*     */ 
/*     */   public Long getId()
/*     */   {
/*  84 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/*  91 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getSerie()
/*     */   {
/*  98 */     return this.serie;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSerie(String serie)
/*     */   {
/* 105 */     this.serie = serie;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getDocumentNumber()
/*     */   {
/* 112 */     return this.documentNumber;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setDocumentNumber(String documentNumber)
/*     */   {
/* 119 */     this.documentNumber = documentNumber;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public PaymentProof getPaymentProof()
/*     */   {
/* 126 */     return this.paymentProof;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setPaymentProof(PaymentProof paymentProof)
/*     */   {
/* 133 */     this.paymentProof = paymentProof;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Date getDateIssue()
/*     */   {
/* 140 */     return this.dateIssue;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setDateIssue(Date dateIssue)
/*     */   {
/* 147 */     this.dateIssue = dateIssue;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Actor getResponsible()
/*     */   {
/* 154 */     return this.responsible;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setResponsible(Actor responsible)
/*     */   {
/* 161 */     this.responsible = responsible;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public User getCreateUser()
/*     */   {
/* 168 */     return this.createUser;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCreateUser(User createUser)
/*     */   {
/* 175 */     this.createUser = createUser;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Date getCreateDate()
/*     */   {
/* 182 */     return this.createDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCreateDate(Date createDate)
/*     */   {
/* 189 */     this.createDate = createDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public User getEditUser()
/*     */   {
/* 196 */     return this.editUser;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setEditUser(User editUser)
/*     */   {
/* 203 */     this.editUser = editUser;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Date getEditDate()
/*     */   {
/* 210 */     return this.editDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setEditDate(Date editDate)
/*     */   {
/* 217 */     this.editDate = editDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Boolean getActive()
/*     */   {
/* 224 */     return this.active;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setActive(Boolean active)
/*     */   {
/* 231 */     this.active = active;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Company getCompany()
/*     */   {
/* 238 */     return this.company;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCompany(Company company)
/*     */   {
/* 245 */     this.company = company;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getFullDocument()
/*     */   {
/* 252 */     return this.fullDocument;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setFullDocument(String fullDocument)
/*     */   {
/* 259 */     this.fullDocument = fullDocument;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public OperationType getOperationType()
/*     */   {
/* 266 */     return this.operationType;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setOperationType(OperationType operationType)
/*     */   {
/* 273 */     this.operationType = operationType;
/*     */   }
/*     */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\model\StockReduction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */