/*     */ package cs.bms.model;
/*     */ 
/*     */ import gkfire.auditory.AuditoryEntity;
/*     */ import gkfire.model.interfac.EntityActivate;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.List;
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
/*     */ import javax.persistence.OneToMany;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Entity
/*     */ @Table(name="product", catalog="public")
/*     */ @XmlRootElement
/*     */ public class Product
/*     */   implements AuditoryEntity<Long, User>, EntityActivate
/*     */ {
/*     */   @Id
/*     */   @GeneratedValue(strategy=GenerationType.IDENTITY)
/*     */   @Column(name="id", nullable=false)
/*     */   protected Long id;
/*     */   @Column(name="barcode", nullable=true)
/*     */   protected String barcode;
/*     */   @Column(name="name", nullable=false)
/*     */   protected String name;
/*     */   @Column(name="description", nullable=true)
/*     */   protected String description;
/*     */   @Column(name="image", nullable=true)
/*     */   protected String image;
/*     */   @JoinColumn(name="id_uom", nullable=false)
/*     */   @ManyToOne
/*     */   protected UoM uom;
/*     */   @JoinColumn(name="id_stock_type", nullable=false)
/*     */   @ManyToOne
/*     */   protected StockType stockType;
/*     */   @JoinColumn(name="id_product_line", nullable=true)
/*     */   @ManyToOne
/*     */   protected ProductLine productLine;
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
/*  79 */   protected Boolean active = Boolean.TRUE;
/*     */   @ManyToMany
/*     */   @JoinTable(name="product_has_supplier", joinColumns={@JoinColumn(name="id_product", nullable=false, updatable=false)}, inverseJoinColumns={@JoinColumn(name="id_supplier", nullable=false, updatable=false)})
/*  82 */   protected List<Actor> suppliers = new ArrayList(0);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @ManyToMany
/*     */   @JoinTable(name="product_has_seller", joinColumns={@JoinColumn(name="id_product", nullable=false, updatable=false)}, inverseJoinColumns={@JoinColumn(name="id_seller", nullable=false, updatable=false)})
/*  90 */   protected List<Seller> sellers = new ArrayList(0);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @OneToMany(fetch=FetchType.LAZY, mappedBy="product")
/*  97 */   protected List<Kardex> kardexs = new ArrayList(0);
/*     */   
/*     */   public Product(Long id)
/*     */   {
/* 101 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Product() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public Long getId()
/*     */   {
/* 113 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/* 120 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getBarcode()
/*     */   {
/* 127 */     return this.barcode;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setBarcode(String barcode)
/*     */   {
/* 134 */     this.barcode = barcode;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getName()
/*     */   {
/* 141 */     return this.name;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setName(String name)
/*     */   {
/* 148 */     this.name = name;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getDescription()
/*     */   {
/* 155 */     return this.description;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setDescription(String description)
/*     */   {
/* 162 */     this.description = description;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getImage()
/*     */   {
/* 169 */     return this.image;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setImage(String image)
/*     */   {
/* 176 */     this.image = image;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public ProductLine getProductLine()
/*     */   {
/* 183 */     return this.productLine;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setProductLine(ProductLine productLine)
/*     */   {
/* 190 */     this.productLine = productLine;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public User getCreateUser()
/*     */   {
/* 197 */     return this.createUser;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCreateUser(User createUser)
/*     */   {
/* 204 */     this.createUser = createUser;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Date getCreateDate()
/*     */   {
/* 211 */     return this.createDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCreateDate(Date createDate)
/*     */   {
/* 218 */     this.createDate = createDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public User getEditUser()
/*     */   {
/* 225 */     return this.editUser;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setEditUser(User editUser)
/*     */   {
/* 232 */     this.editUser = editUser;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Date getEditDate()
/*     */   {
/* 239 */     return this.editDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setEditDate(Date editDate)
/*     */   {
/* 246 */     this.editDate = editDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Boolean getActive()
/*     */   {
/* 253 */     return this.active;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setActive(Boolean active)
/*     */   {
/* 260 */     this.active = active;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<Actor> getSuppliers()
/*     */   {
/* 267 */     return this.suppliers;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSuppliers(List<Actor> suppliers)
/*     */   {
/* 274 */     this.suppliers = suppliers;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public StockType getStockType()
/*     */   {
/* 281 */     return this.stockType;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setStockType(StockType stockType)
/*     */   {
/* 288 */     this.stockType = stockType;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public UoM getUom()
/*     */   {
/* 295 */     return this.uom;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setUom(UoM uom)
/*     */   {
/* 302 */     this.uom = uom;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<Seller> getSellers()
/*     */   {
/* 309 */     return this.sellers;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSellers(List<Seller> sellers)
/*     */   {
/* 316 */     this.sellers = sellers;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<Kardex> getKardexs()
/*     */   {
/* 323 */     return this.kardexs;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setKardexs(List<Kardex> kardexs)
/*     */   {
/* 330 */     this.kardexs = kardexs;
/*     */   }
/*     */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\model\Product.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */