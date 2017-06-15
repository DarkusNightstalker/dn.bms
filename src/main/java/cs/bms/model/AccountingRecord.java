/*     */ package cs.bms.model;
/*     */ 
/*     */ import gkfire.auditory.AuditoryEntity;
/*     */ import gkfire.util.Month;
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
/*     */ @Table(name="accounting_record")
/*     */ public class AccountingRecord
/*     */   implements AuditoryEntity<Long, User>
/*     */ {
/*     */   @Id
/*     */   @GeneratedValue(strategy=GenerationType.IDENTITY)
/*     */   @Column(name="id", nullable=false)
/*     */   private Long id;
/*     */   @Column(name="year", nullable=false)
/*     */   private Integer year;
/*     */   @Column(name="month", nullable=false)
/*     */   @Enumerated(EnumType.ORDINAL)
/*     */   private Month month;
/*     */   @Column(name="day", nullable=true)
/*     */   private Short day;
/*     */   @Column(name="sent", nullable=false)
/*     */   private Boolean sent;
/*     */   @Column(name="sent_date", nullable=true)
/*     */   @Temporal(TemporalType.TIMESTAMP)
/*     */   private Date sentDate;
/*     */   @Column(name="ple_versión", nullable=false)
/*     */   private String pleVersion;
/*     */   @Column(name="file")
/*     */   private String file;
/*     */   @Column(name="summary_data", nullable=false)
/*     */   private String summaryData;
/*     */   @JoinColumn(name="id_electronic_book", nullable=false)
/*     */   @ManyToOne
/*     */   private ElectronicBook electronicBook;
/*     */   @Column(name="ruc", nullable=false)
/*     */   private String ruc;
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
/*     */   
/*     */   public Long getId()
/*     */   {
/*  78 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/*  85 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Integer getYear()
/*     */   {
/*  92 */     return this.year;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setYear(Integer year)
/*     */   {
/*  99 */     this.year = year;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Month getMonth()
/*     */   {
/* 106 */     return this.month;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setMonth(Month month)
/*     */   {
/* 113 */     this.month = month;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Short getDay()
/*     */   {
/* 120 */     return this.day;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setDay(Short day)
/*     */   {
/* 127 */     this.day = day;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Boolean getSent()
/*     */   {
/* 134 */     return this.sent;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSent(Boolean sent)
/*     */   {
/* 141 */     this.sent = sent;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Date getSentDate()
/*     */   {
/* 148 */     return this.sentDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSentDate(Date sentDate)
/*     */   {
/* 155 */     this.sentDate = sentDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getPleVersion()
/*     */   {
/* 162 */     return this.pleVersion;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setPleVersion(String pleVersion)
/*     */   {
/* 169 */     this.pleVersion = pleVersion;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getFile()
/*     */   {
/* 176 */     return this.file;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setFile(String file)
/*     */   {
/* 183 */     this.file = file;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public ElectronicBook getElectronicBook()
/*     */   {
/* 190 */     return this.electronicBook;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setElectronicBook(ElectronicBook electronicBook)
/*     */   {
/* 197 */     this.electronicBook = electronicBook;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getRuc()
/*     */   {
/* 204 */     return this.ruc;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setRuc(String ruc)
/*     */   {
/* 211 */     this.ruc = ruc;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public User getCreateUser()
/*     */   {
/* 218 */     return this.createUser;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCreateUser(User createUser)
/*     */   {
/* 225 */     this.createUser = createUser;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Date getCreateDate()
/*     */   {
/* 232 */     return this.createDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCreateDate(Date createDate)
/*     */   {
/* 239 */     this.createDate = createDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public User getEditUser()
/*     */   {
/* 246 */     return this.editUser;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setEditUser(User editUser)
/*     */   {
/* 253 */     this.editUser = editUser;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Date getEditDate()
/*     */   {
/* 260 */     return this.editDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setEditDate(Date editDate)
/*     */   {
/* 267 */     this.editDate = editDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getSummaryData()
/*     */   {
/* 274 */     return this.summaryData;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSummaryData(String summaryData)
/*     */   {
/* 281 */     this.summaryData = summaryData;
/*     */   }
/*     */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\model\AccountingRecord.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */