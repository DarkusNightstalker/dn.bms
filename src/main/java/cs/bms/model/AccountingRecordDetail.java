/*     */ package cs.bms.model;
/*     */ 
/*     */ import cs.bms.enumerated.EBDetailState;
/*     */ import java.io.Serializable;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.EnumType;
/*     */ import javax.persistence.Enumerated;
/*     */ import javax.persistence.FetchType;
/*     */ import javax.persistence.GeneratedValue;
/*     */ import javax.persistence.GenerationType;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.JoinColumn;
/*     */ import javax.persistence.ManyToOne;
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
/*     */ public class AccountingRecordDetail
/*     */   implements Serializable
/*     */ {
/*     */   @Id
/*     */   @GeneratedValue(strategy=GenerationType.IDENTITY)
/*     */   @Column(name="id", nullable=false)
/*     */   private Long id;
/*     */   @JoinColumn(name="id_accounting_record")
/*     */   @ManyToOne(fetch=FetchType.LAZY)
/*     */   private AccountingRecord accountingRecord;
/*     */   @Column(name="id_reference", nullable=false)
/*     */   private Long idReference;
/*     */   @Column(name="entity_name", nullable=false)
/*     */   private String entityName;
/*     */   @Column(name="cuo", nullable=false)
/*     */   private Long cuo;
/*     */   @Column(name="prefix", nullable=false)
/*     */   private String prefix;
/*     */   @Column(name="data", nullable=false)
/*     */   private String data;
/*     */   @Column(name="state", nullable=false)
/*     */   @Enumerated(EnumType.ORDINAL)
/*     */   private EBDetailState state;
/*     */   
/*     */   public Long getId()
/*     */   {
/*  50 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/*  57 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public AccountingRecord getAccountingRecord()
/*     */   {
/*  64 */     return this.accountingRecord;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setAccountingRecord(AccountingRecord accountingRecord)
/*     */   {
/*  71 */     this.accountingRecord = accountingRecord;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Long getIdReference()
/*     */   {
/*  78 */     return this.idReference;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setIdReference(Long idReference)
/*     */   {
/*  85 */     this.idReference = idReference;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getEntityName()
/*     */   {
/*  92 */     return this.entityName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setEntityName(String entityName)
/*     */   {
/*  99 */     this.entityName = entityName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Long getCuo()
/*     */   {
/* 106 */     return this.cuo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCuo(Long cuo)
/*     */   {
/* 113 */     this.cuo = cuo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getPrefix()
/*     */   {
/* 120 */     return this.prefix;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setPrefix(String prefix)
/*     */   {
/* 127 */     this.prefix = prefix;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getData()
/*     */   {
/* 134 */     return this.data;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setData(String data)
/*     */   {
/* 141 */     this.data = data;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setState(EBDetailState state)
/*     */   {
/* 148 */     this.state = state;
/*     */   }
/*     */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\model\AccountingRecordDetail.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */