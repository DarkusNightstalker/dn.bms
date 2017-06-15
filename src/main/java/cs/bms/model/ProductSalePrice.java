/*     */ package cs.bms.model;
/*     */ 
/*     */ import java.io.Serializable;
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
/*     */ import javax.validation.constraints.Digits;
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
/*     */ @Table(name="product_sale_price", catalog="public")
/*     */ @XmlRootElement
/*     */ public class ProductSalePrice
/*     */   implements Serializable
/*     */ {
/*     */   @Id
/*     */   @GeneratedValue(strategy=GenerationType.IDENTITY)
/*     */   @Column(name="id", nullable=false)
/*     */   protected Long id;
/*     */   @JoinColumn(name="id_product", nullable=false)
/*     */   @ManyToOne(fetch=FetchType.LAZY)
/*     */   protected Product product;
/*     */   @JoinColumn(name="id_company", nullable=false)
/*     */   @ManyToOne(fetch=FetchType.LAZY)
/*     */   protected Company company;
/*     */   @Column(name="quantity", nullable=false)
/*     */   protected Integer quantity;
/*     */   @Column(name="price", nullable=false)
/*     */   @Digits(integer=4, fraction=2)
/*     */   protected BigDecimal price;
/*     */   @JoinColumn(name="create_uid", nullable=false)
/*     */   @ManyToOne(fetch=FetchType.LAZY)
/*     */   protected User createUser;
/*     */   @Column(name="create_date", nullable=false)
/*     */   @Temporal(TemporalType.TIMESTAMP)
/*     */   protected Date createDate;
/*     */   
/*     */   public ProductSalePrice(Long id)
/*     */   {
/*  59 */     this.id = id;
/*     */   }
/*     */   
/*     */   public ProductSalePrice() {}
/*     */   
/*     */   public ProductSalePrice(Product product, Company company, Integer quantity, BigDecimal price)
/*     */   {
/*  66 */     this.product = product;
/*  67 */     this.company = company;
/*  68 */     this.quantity = quantity;
/*  69 */     this.price = price;
/*     */   }
/*     */   
/*     */ 
/*     */ 
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
/*     */   public Product getProduct()
/*     */   {
/*  91 */     return this.product;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setProduct(Product product)
/*     */   {
/*  98 */     this.product = product;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Company getCompany()
/*     */   {
/* 105 */     return this.company;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCompany(Company company)
/*     */   {
/* 112 */     this.company = company;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getQuantity()
/*     */   {
/* 120 */     return this.quantity;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setQuantity(Integer quantity)
/*     */   {
/* 127 */     this.quantity = quantity;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public BigDecimal getPrice()
/*     */   {
/* 134 */     return this.price;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setPrice(BigDecimal price)
/*     */   {
/* 141 */     this.price = price;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public User getCreateUser()
/*     */   {
/* 148 */     return this.createUser;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCreateUser(User createUser)
/*     */   {
/* 155 */     this.createUser = createUser;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Date getCreateDate()
/*     */   {
/* 162 */     return this.createDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCreateDate(Date createDate)
/*     */   {
/* 169 */     this.createDate = createDate;
/*     */   }
/*     */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\model\ProductSalePrice.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */