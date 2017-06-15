/*     */ package cs.bms.model;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.JoinColumn;
/*     */ import javax.persistence.ManyToOne;
/*     */ import javax.persistence.Table;
/*     */ import javax.persistence.Temporal;
/*     */ import javax.persistence.TemporalType;
/*     */ import org.hibernate.annotations.Immutable;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ @Entity
/*     */ @Immutable
/*     */ @Table(name="kardex")
/*     */ public class Kardex
/*     */   implements Serializable
/*     */ {
/*     */   @Id
/*     */   @Column(name="date", nullable=false)
/*     */   @Temporal(TemporalType.TIMESTAMP)
/*     */   private Date date;
/*     */   @Id
/*     */   @JoinColumn(name="id_company", nullable=false)
/*     */   @ManyToOne
/*     */   private Company company;
/*     */   @Id
/*     */   @JoinColumn(name="id_payment_proof", nullable=false)
/*     */   @ManyToOne
/*     */   private PaymentProof paymentProof;
/*     */   @Id
/*     */   @Column(name="serie", nullable=false)
/*     */   private String serie;
/*     */   @Id
/*     */   @Column(name="document_number", nullable=false)
/*     */   private String documentNumber;
/*     */   @Id
/*     */   @JoinColumn(name="id_operation_type", nullable=false)
/*     */   @ManyToOne
/*     */   private OperationType operationType;
/*     */   @Id
/*     */   @JoinColumn(name="id_product", nullable=false)
/*     */   @ManyToOne
/*     */   private Product product;
/*     */   @Id
/*     */   @Column(name="quantity_in")
/*     */   private BigDecimal quantityIn;
/*     */   @Id
/*     */   @Column(name="cost_in")
/*     */   private BigDecimal costIn;
/*     */   @Id
/*     */   @Column(name="total_in")
/*     */   private BigDecimal totalIn;
/*     */   @Id
/*     */   @Column(name="quantity_out")
/*     */   private BigDecimal quantityOut;
/*     */   @Id
/*     */   @Column(name="cost_out")
/*     */   private BigDecimal costOut;
/*     */   @Id
/*     */   @Column(name="total_out")
/*     */   private BigDecimal totalOut;
/*     */   @Id
/*     */   @Column(name="priority", nullable=false)
/*     */   private Short priority;
/*     */   @Id
/*     */   @Column(name="id_reference", nullable=false)
/*     */   private Long idReference;
/*     */   @Id
/*     */   @Column(name="entity_name", nullable=false)
/*     */   private String entityName;
/*     */   @Id
/*     */   @Column(name="active", nullable=false)
/*     */   private Boolean active;
/*     */   @Id
/*     */   @Column(name="edit_date", nullable=false)
/*     */   @Temporal(TemporalType.TIMESTAMP)
/*     */   private Date editDate;
/*     */   @Id
/*     */   @Column(name="order_date", nullable=false)
/*     */   @Temporal(TemporalType.TIMESTAMP)
/*     */   private Date orderDate;
/*     */   
/*     */   public Date getDate()
/*     */   {
/* 105 */     return this.date;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setDate(Date date)
/*     */   {
/* 112 */     this.date = date;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Company getCompany()
/*     */   {
/* 119 */     return this.company;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCompany(Company company)
/*     */   {
/* 126 */     this.company = company;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public PaymentProof getPaymentProof()
/*     */   {
/* 133 */     return this.paymentProof;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setPaymentProof(PaymentProof paymentProof)
/*     */   {
/* 140 */     this.paymentProof = paymentProof;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getSerie()
/*     */   {
/* 147 */     return this.serie;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSerie(String serie)
/*     */   {
/* 154 */     this.serie = serie;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getDocumentNumber()
/*     */   {
/* 161 */     return this.documentNumber;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setDocumentNumber(String documentNumber)
/*     */   {
/* 168 */     this.documentNumber = documentNumber;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public OperationType getOperationType()
/*     */   {
/* 175 */     return this.operationType;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setOperationType(OperationType operationType)
/*     */   {
/* 182 */     this.operationType = operationType;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public BigDecimal getQuantityIn()
/*     */   {
/* 189 */     return this.quantityIn;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setQuantityIn(BigDecimal quantityIn)
/*     */   {
/* 196 */     this.quantityIn = quantityIn;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public BigDecimal getCostIn()
/*     */   {
/* 203 */     return this.costIn;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCostIn(BigDecimal costIn)
/*     */   {
/* 210 */     this.costIn = costIn;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public BigDecimal getTotalIn()
/*     */   {
/* 217 */     return this.totalIn;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setTotalIn(BigDecimal totalIn)
/*     */   {
/* 224 */     this.totalIn = totalIn;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public BigDecimal getQuantityOut()
/*     */   {
/* 231 */     return this.quantityOut;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setQuantityOut(BigDecimal quantityOut)
/*     */   {
/* 238 */     this.quantityOut = quantityOut;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public BigDecimal getCostOut()
/*     */   {
/* 245 */     return this.costOut;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCostOut(BigDecimal costOut)
/*     */   {
/* 252 */     this.costOut = costOut;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public BigDecimal getTotalOut()
/*     */   {
/* 259 */     return this.totalOut;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setTotalOut(BigDecimal totalOut)
/*     */   {
/* 266 */     this.totalOut = totalOut;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Short getPriority()
/*     */   {
/* 273 */     return this.priority;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setPriority(Short priority)
/*     */   {
/* 280 */     this.priority = priority;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Long getIdReference()
/*     */   {
/* 287 */     return this.idReference;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setIdReference(Long idReference)
/*     */   {
/* 294 */     this.idReference = idReference;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getEntityName()
/*     */   {
/* 301 */     return this.entityName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setEntityName(String entityName)
/*     */   {
/* 308 */     this.entityName = entityName;
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
/*     */   public Date getEditDate()
/*     */   {
/* 329 */     return this.editDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setEditDate(Date editDate)
/*     */   {
/* 336 */     this.editDate = editDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Date getOrderDate()
/*     */   {
/* 343 */     return this.orderDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setOrderDate(Date orderDate)
/*     */   {
/* 350 */     this.orderDate = orderDate;
/*     */   }
/*     */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\model\Kardex.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */