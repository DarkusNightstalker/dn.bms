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
/*     */ @Table(name="work_shift", catalog="public")
/*     */ @XmlRootElement
/*     */ public class WorkShift
/*     */   implements AuditoryEntity<Integer, User>, EntityActivate
/*     */ {
/*     */   @Id
/*     */   @GeneratedValue(strategy=GenerationType.IDENTITY)
/*     */   @Column(name="id", nullable=false)
/*     */   protected Integer id;
/*     */   @JoinColumn(name="id_company", nullable=false)
/*     */   @ManyToOne(fetch=FetchType.LAZY)
/*     */   protected Company company;
/*     */   @Column(name="name", nullable=false)
/*     */   protected String name;
/*     */   @Column(name="time_entry")
/*     */   @Temporal(TemporalType.TIME)
/*     */   protected Date timeEntry;
/*     */   @Column(name="time_departure")
/*     */   @Temporal(TemporalType.TIME)
/*     */   protected Date timeDeparture;
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
/*  61 */   protected Boolean active = Boolean.TRUE;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getId()
/*     */   {
/*  68 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setId(Integer id)
/*     */   {
/*  75 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Company getCompany()
/*     */   {
/*  82 */     return this.company;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCompany(Company company)
/*     */   {
/*  89 */     this.company = company;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getName()
/*     */   {
/*  96 */     return this.name;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setName(String name)
/*     */   {
/* 103 */     this.name = name;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Date getTimeEntry()
/*     */   {
/* 110 */     return this.timeEntry;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setTimeEntry(Date timeEntry)
/*     */   {
/* 117 */     this.timeEntry = timeEntry;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Date getTimeDeparture()
/*     */   {
/* 124 */     return this.timeDeparture;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setTimeDeparture(Date timeDeparture)
/*     */   {
/* 131 */     this.timeDeparture = timeDeparture;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public User getCreateUser()
/*     */   {
/* 138 */     return this.createUser;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCreateUser(User createUser)
/*     */   {
/* 145 */     this.createUser = createUser;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Date getCreateDate()
/*     */   {
/* 152 */     return this.createDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCreateDate(Date createDate)
/*     */   {
/* 159 */     this.createDate = createDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public User getEditUser()
/*     */   {
/* 166 */     return this.editUser;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setEditUser(User editUser)
/*     */   {
/* 173 */     this.editUser = editUser;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Date getEditDate()
/*     */   {
/* 180 */     return this.editDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setEditDate(Date editDate)
/*     */   {
/* 187 */     this.editDate = editDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Boolean getActive()
/*     */   {
/* 194 */     return this.active;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setActive(Boolean active)
/*     */   {
/* 201 */     this.active = active;
/*     */   }
/*     */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\model\WorkShift.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */