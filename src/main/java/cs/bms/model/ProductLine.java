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
/*     */ 
/*     */ 
/*     */ 
/*     */ @Entity
/*     */ @Table(name="product_line", catalog="public")
/*     */ @XmlRootElement
/*     */ public class ProductLine
/*     */   implements AuditoryEntity<Integer, User>, EntityActivate
/*     */ {
/*     */   @Id
/*     */   @GeneratedValue(strategy=GenerationType.IDENTITY)
/*     */   @Column(name="id", nullable=false)
/*     */   private Integer id;
/*     */   @Column(name="path", nullable=false)
/*     */   private String path;
/*     */   @Column(name="name", nullable=false)
/*     */   private String name;
/*     */   @JoinColumn(name="id_parent")
/*     */   @ManyToOne(fetch=FetchType.LAZY)
/*     */   private ProductLine parent;
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
/*  60 */   private Boolean active = Boolean.TRUE;
/*     */   
/*     */ 
/*     */   public ProductLine() {}
/*     */   
/*     */   public ProductLine(Integer id)
/*     */   {
/*  67 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getId()
/*     */   {
/*  76 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setId(Integer id)
/*     */   {
/*  83 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getPath()
/*     */   {
/*  90 */     return this.path;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setPath(String path)
/*     */   {
/*  97 */     this.path = path;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getName()
/*     */   {
/* 104 */     return this.name;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setName(String name)
/*     */   {
/* 111 */     this.name = name;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public ProductLine getParent()
/*     */   {
/* 118 */     return this.parent;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setParent(ProductLine parent)
/*     */   {
/* 125 */     this.parent = parent;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public User getCreateUser()
/*     */   {
/* 132 */     return this.createUser;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCreateUser(User createUser)
/*     */   {
/* 139 */     this.createUser = createUser;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Date getCreateDate()
/*     */   {
/* 146 */     return this.createDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCreateDate(Date createDate)
/*     */   {
/* 153 */     this.createDate = createDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public User getEditUser()
/*     */   {
/* 160 */     return this.editUser;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setEditUser(User editUser)
/*     */   {
/* 167 */     this.editUser = editUser;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Date getEditDate()
/*     */   {
/* 174 */     return this.editDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setEditDate(Date editDate)
/*     */   {
/* 181 */     this.editDate = editDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Boolean getActive()
/*     */   {
/* 188 */     return this.active;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setActive(Boolean active)
/*     */   {
/* 195 */     this.active = active;
/*     */   }
/*     */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\model\ProductLine.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */