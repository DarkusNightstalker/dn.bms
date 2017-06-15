/*     */ package cs.bms.model;
/*     */ 
/*     */ import gkfire.auditory.AuditoryEntity;
/*     */ import gkfire.model.interfac.EntityActivate;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import java.util.Objects;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.FetchType;
/*     */ import javax.persistence.GeneratedValue;
/*     */ import javax.persistence.GenerationType;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.JoinColumn;
/*     */ import javax.persistence.JoinTable;
/*     */ import javax.persistence.ManyToMany;
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
/*     */ @Table(name="seller", catalog="public")
/*     */ @XmlRootElement
/*     */ public class Seller
/*     */   implements AuditoryEntity<Long, User>, EntityActivate
/*     */ {
/*     */   @Id
/*     */   @GeneratedValue(strategy=GenerationType.IDENTITY)
/*     */   @Column(name="id", nullable=false)
/*     */   protected Long id;
/*     */   @JoinColumn(name="id_actor", nullable=true)
/*     */   @ManyToOne
/*     */   protected Actor actor;
/*     */   @Column(name="description", nullable=false)
/*     */   protected String description;
/*     */   @Column(name="\"default\"", nullable=false)
/*  47 */   protected Boolean default_ = Boolean.FALSE;
/*     */   
/*     */   @JoinColumn(name="id_supplier", nullable=false)
/*     */   @ManyToOne
/*     */   protected Actor supplier;
/*     */   
/*     */   @JoinColumn(name="create_uid", nullable=false)
/*     */   @ManyToOne(fetch=FetchType.LAZY)
/*     */   protected User createUser;
/*     */   
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
/*  67 */   protected Boolean active = Boolean.TRUE; @ManyToMany
/*     */   @JoinTable(name="product_has_seller", joinColumns={@JoinColumn(name="id_seller", nullable=false, updatable=false)}, inverseJoinColumns={@JoinColumn(name="id_product", nullable=false, updatable=false)})
/*  69 */   protected List<Product> products = new ArrayList(0);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Seller() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Seller(Long id)
/*     */   {
/*  81 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Long getId()
/*     */   {
/*  88 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/*  95 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Actor getActor()
/*     */   {
/* 102 */     return this.actor;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setActor(Actor actor)
/*     */   {
/* 109 */     this.actor = actor;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getDescription()
/*     */   {
/* 116 */     return this.description;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setDescription(String description)
/*     */   {
/* 123 */     this.description = description;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Boolean getDefault_()
/*     */   {
/* 130 */     return this.default_;
/*     */   }
/*     */   
/*     */   public int hashCode()
/*     */   {
/* 135 */     int hash = 7;
/* 136 */     hash = 79 * hash + Objects.hashCode(this.id);
/* 137 */     return hash;
/*     */   }
/*     */   
/*     */   public boolean equals(Object obj)
/*     */   {
/* 142 */     if (this == obj) {
/* 143 */       return true;
/*     */     }
/* 145 */     if (obj == null) {
/* 146 */       return false;
/*     */     }
/* 148 */     if (getClass() != obj.getClass()) {
/* 149 */       return false;
/*     */     }
/* 151 */     Seller other = (Seller)obj;
/* 152 */     if (this.id == null) return false;
/* 153 */     if (this.id.longValue() != other.id.longValue()) {
/* 154 */       return false;
/*     */     }
/* 156 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setDefault_(Boolean default_)
/*     */   {
/* 163 */     this.default_ = default_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Actor getSupplier()
/*     */   {
/* 170 */     return this.supplier;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSupplier(Actor supplier)
/*     */   {
/* 177 */     this.supplier = supplier;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public User getCreateUser()
/*     */   {
/* 184 */     return this.createUser;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCreateUser(User createUser)
/*     */   {
/* 191 */     this.createUser = createUser;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Date getCreateDate()
/*     */   {
/* 198 */     return this.createDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCreateDate(Date createDate)
/*     */   {
/* 205 */     this.createDate = createDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public User getEditUser()
/*     */   {
/* 212 */     return this.editUser;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setEditUser(User editUser)
/*     */   {
/* 219 */     this.editUser = editUser;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Date getEditDate()
/*     */   {
/* 226 */     return this.editDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setEditDate(Date editDate)
/*     */   {
/* 233 */     this.editDate = editDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Boolean getActive()
/*     */   {
/* 240 */     return this.active;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setActive(Boolean active)
/*     */   {
/* 247 */     this.active = active;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<Product> getProducts()
/*     */   {
/* 254 */     return this.products;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setProducts(List<Product> products)
/*     */   {
/* 261 */     this.products = products;
/*     */   }
/*     */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\model\Seller.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */