/*     */ package cs.bms.model;
/*     */ 
/*     */ import gkfire.auditory.AuditoryEntity;
/*     */ import gkfire.util.Month;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.EnumType;
/*     */ import javax.persistence.Enumerated;
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
/*     */ @Entity
/*     */ @Table(name="opening_balance", catalog="public")
/*     */ @XmlRootElement
/*     */ public class OpeningBalance
/*     */   implements AuditoryEntity<Long, User>
/*     */ {
/*     */   @Id
/*     */   @GeneratedValue(strategy=GenerationType.IDENTITY)
/*     */   @Column(name="id", nullable=false)
/*     */   private Long id;
/*     */   @JoinColumn(name="id_product", nullable=false)
/*     */   @ManyToOne
/*     */   private Product product;
/*     */   @JoinColumn(name="id_uom", nullable=false)
/*     */   @ManyToOne
/*     */   private UoM uom;
/*     */   @Column(name="year", nullable=false)
/*     */   private Integer year;
/*     */   @Column(name="month")
/*     */   @Enumerated(EnumType.ORDINAL)
/*     */   private Month month;
/*     */   @Column(name="quantity", nullable=false)
/*  53 */   private BigDecimal quantity = BigDecimal.ZERO;
/*     */   @Column(name="unit_cost", nullable=false)
/*  55 */   private BigDecimal unitCost = BigDecimal.ZERO;
/*     */   @Column(name="total_cost", nullable=false)
/*  57 */   private BigDecimal totalCost = BigDecimal.ZERO;
/*     */   
/*     */   @JoinColumn(name="id_operation_type", nullable=false)
/*     */   @ManyToOne(fetch=FetchType.LAZY)
/*     */   private OperationType operationType;
/*     */   
/*     */   @JoinColumn(name="id_company", nullable=false)
/*     */   @ManyToOne
/*     */   private Company company;
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
/*     */   public Product getProduct()
/*     */   {
/*  97 */     return this.product;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setProduct(Product product)
/*     */   {
/* 104 */     this.product = product;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public UoM getUom()
/*     */   {
/* 111 */     return this.uom;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setUom(UoM uom)
/*     */   {
/* 118 */     this.uom = uom;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Integer getYear()
/*     */   {
/* 125 */     return this.year;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setYear(Integer year)
/*     */   {
/* 132 */     this.year = year;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Month getMonth()
/*     */   {
/* 139 */     return this.month;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setMonth(Month month)
/*     */   {
/* 146 */     this.month = month;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public BigDecimal getQuantity()
/*     */   {
/* 153 */     return this.quantity;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setQuantity(BigDecimal quantity)
/*     */   {
/* 160 */     this.quantity = quantity;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public BigDecimal getUnitCost()
/*     */   {
/* 167 */     return this.unitCost;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setUnitCost(BigDecimal unitCost)
/*     */   {
/* 174 */     this.unitCost = unitCost;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public BigDecimal getTotalCost()
/*     */   {
/* 181 */     return this.totalCost;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setTotalCost(BigDecimal totalCost)
/*     */   {
/* 188 */     this.totalCost = totalCost;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public OperationType getOperationType()
/*     */   {
/* 195 */     return this.operationType;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setOperationType(OperationType operationType)
/*     */   {
/* 202 */     this.operationType = operationType;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Company getCompany()
/*     */   {
/* 209 */     return this.company;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCompany(Company company)
/*     */   {
/* 216 */     this.company = company;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public User getCreateUser()
/*     */   {
/* 223 */     return this.createUser;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCreateUser(User createUser)
/*     */   {
/* 230 */     this.createUser = createUser;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Date getCreateDate()
/*     */   {
/* 237 */     return this.createDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCreateDate(Date createDate)
/*     */   {
/* 244 */     this.createDate = createDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public User getEditUser()
/*     */   {
/* 251 */     return this.editUser;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setEditUser(User editUser)
/*     */   {
/* 258 */     this.editUser = editUser;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Date getEditDate()
/*     */   {
/* 265 */     return this.editDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setEditDate(Date editDate)
/*     */   {
/* 272 */     this.editDate = editDate;
/*     */   }
/*     */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\model\OpeningBalance.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */