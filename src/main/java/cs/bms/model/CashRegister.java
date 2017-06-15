/*     */ package cs.bms.model;
/*     */ 
/*     */ import gkfire.auditory.AuditoryEntity;
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
/*     */ @Entity
/*     */ @Table(name="cash_register", catalog="public")
/*     */ @XmlRootElement
/*     */ public class CashRegister
/*     */   implements AuditoryEntity<Long, User>
/*     */ {
/*     */   @Id
/*     */   @GeneratedValue(strategy=GenerationType.IDENTITY)
/*     */   @Column(name="id", nullable=false)
/*     */   protected Long id;
/*     */   @JoinColumn(name="id_company", nullable=false)
/*     */   @ManyToOne(fetch=FetchType.LAZY)
/*     */   protected Company company;
/*     */   @JoinColumn(name="id_work_shift", nullable=false)
/*     */   @ManyToOne
/*     */   protected WorkShift workShift;
/*     */   @Column(name="initial_cash", nullable=false)
/*  43 */   protected BigDecimal initialCash = BigDecimal.ZERO;
/*     */   @Column(name="expected_cash", nullable=false)
/*  45 */   protected BigDecimal expectedCash = BigDecimal.ZERO;
/*     */   @Column(name="credit", nullable=false)
/*  47 */   protected BigDecimal credit = BigDecimal.ZERO;
/*     */   @Column(name="visa", nullable=false)
/*  49 */   protected BigDecimal visa = BigDecimal.ZERO;
/*     */   @Column(name="real_cash", nullable=false)
/*  51 */   protected BigDecimal realCash = BigDecimal.ZERO;
/*     */   
/*     */   @Column(name="payment_voucher_total", nullable=false)
/*     */   protected Integer paymentVoucherTotal;
/*     */   
/*     */   @JoinColumn(name="create_uid", nullable=false)
/*     */   @ManyToOne(fetch=FetchType.LAZY)
/*     */   protected User createUser;
/*     */   
/*     */   @Column(name="create_date", nullable=false)
/*     */   @Temporal(TemporalType.TIMESTAMP)
/*     */   protected Date createDate;
/*     */   
/*     */   @JoinColumn(name="edit_uid")
/*     */   @ManyToOne(fetch=FetchType.LAZY)
/*     */   protected User editUser;
/*     */   
/*     */   @Column(name="edit_date")
/*     */   @Temporal(TemporalType.TIMESTAMP)
/*     */   protected Date editDate;
/*     */   @Column(name="date_arcing")
/*     */   @Temporal(TemporalType.DATE)
/*     */   protected Date dateArcing;
/*     */   
/*     */   public Long getId()
/*     */   {
/*  77 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/*  84 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Company getCompany()
/*     */   {
/*  91 */     return this.company;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCompany(Company company)
/*     */   {
/*  98 */     this.company = company;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public WorkShift getWorkShift()
/*     */   {
/* 105 */     return this.workShift;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setWorkShift(WorkShift workShift)
/*     */   {
/* 112 */     this.workShift = workShift;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public BigDecimal getInitialCash()
/*     */   {
/* 119 */     return this.initialCash;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setInitialCash(BigDecimal initialCash)
/*     */   {
/* 126 */     this.initialCash = initialCash;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public BigDecimal getExpectedCash()
/*     */   {
/* 133 */     return this.expectedCash;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setExpectedCash(BigDecimal expectedCash)
/*     */   {
/* 140 */     this.expectedCash = expectedCash;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public BigDecimal getRealCash()
/*     */   {
/* 147 */     return this.realCash;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setRealCash(BigDecimal realCash)
/*     */   {
/* 154 */     this.realCash = realCash;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public User getCreateUser()
/*     */   {
/* 161 */     return this.createUser;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCreateUser(User createUser)
/*     */   {
/* 168 */     this.createUser = createUser;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Date getCreateDate()
/*     */   {
/* 175 */     return this.createDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCreateDate(Date createDate)
/*     */   {
/* 182 */     this.createDate = createDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public User getEditUser()
/*     */   {
/* 189 */     return this.editUser;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setEditUser(User editUser)
/*     */   {
/* 196 */     this.editUser = editUser;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Date getEditDate()
/*     */   {
/* 203 */     return this.editDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setEditDate(Date editDate)
/*     */   {
/* 210 */     this.editDate = editDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Date getDateArcing()
/*     */   {
/* 217 */     return this.dateArcing;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setDateArcing(Date dateArcing)
/*     */   {
/* 224 */     this.dateArcing = dateArcing;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public BigDecimal getCredit()
/*     */   {
/* 231 */     return this.credit;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCredit(BigDecimal credit)
/*     */   {
/* 238 */     this.credit = credit;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public BigDecimal getVisa()
/*     */   {
/* 245 */     return this.visa;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setVisa(BigDecimal visa)
/*     */   {
/* 252 */     this.visa = visa;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Integer getPaymentVoucherTotal()
/*     */   {
/* 259 */     return this.paymentVoucherTotal;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setPaymentVoucherTotal(Integer paymentVoucherTotal)
/*     */   {
/* 266 */     this.paymentVoucherTotal = paymentVoucherTotal;
/*     */   }
/*     */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\model\CashRegister.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */