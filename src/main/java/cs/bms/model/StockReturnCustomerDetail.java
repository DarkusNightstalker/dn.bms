/*     */ package cs.bms.model;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.math.BigDecimal;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.FetchType;
/*     */ import javax.persistence.GeneratedValue;
/*     */ import javax.persistence.GenerationType;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.JoinColumn;
/*     */ import javax.persistence.ManyToOne;
/*     */ import javax.persistence.Table;
/*     */ import javax.xml.bind.annotation.XmlRootElement;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Entity
/*     */ @Table(name="src_detail", catalog="public")
/*     */ @XmlRootElement
/*     */ public class StockReturnCustomerDetail
/*     */   implements Serializable
/*     */ {
/*     */   @Id
/*     */   @GeneratedValue(strategy=GenerationType.IDENTITY)
/*     */   @Column(name="id", nullable=false)
/*     */   private Long id;
/*     */   @Column(name="product_name", nullable=false)
/*     */   private String productName;
/*     */   @JoinColumn(name="id_product", nullable=false)
/*     */   @ManyToOne
/*     */   private Product product;
/*     */   @JoinColumn(name="id_uom", nullable=false)
/*     */   @ManyToOne
/*     */   private UoM uom;
/*     */   @JoinColumn(name="id_src", nullable=false)
/*     */   @ManyToOne(fetch=FetchType.LAZY)
/*     */   private StockReturnCustomer stockReturnCustomer;
/*     */   @Column(name="quantity", nullable=false)
/*  43 */   private BigDecimal quantity = BigDecimal.ZERO;
/*     */   
/*     */ 
/*     */   @Column(name="unit_cost", nullable=false)
/*     */   private BigDecimal unitCost;
/*     */   
/*     */ 
/*     */   public Long getId()
/*     */   {
/*  52 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/*  59 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getProductName()
/*     */   {
/*  66 */     return this.productName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setProductName(String productName)
/*     */   {
/*  73 */     this.productName = productName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Product getProduct()
/*     */   {
/*  80 */     return this.product;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setProduct(Product product)
/*     */   {
/*  87 */     this.product = product;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public UoM getUom()
/*     */   {
/*  94 */     return this.uom;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setUom(UoM uom)
/*     */   {
/* 101 */     this.uom = uom;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public StockReturnCustomer getStockReturnCustomer()
/*     */   {
/* 108 */     return this.stockReturnCustomer;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setStockReturnCustomer(StockReturnCustomer stockReturnCustomer)
/*     */   {
/* 115 */     this.stockReturnCustomer = stockReturnCustomer;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public BigDecimal getQuantity()
/*     */   {
/* 122 */     return this.quantity;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setQuantity(BigDecimal quantity)
/*     */   {
/* 129 */     this.quantity = quantity;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public BigDecimal getUnitCost()
/*     */   {
/* 136 */     return this.unitCost;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setUnitCost(BigDecimal unitCost)
/*     */   {
/* 143 */     this.unitCost = unitCost;
/*     */   }
/*     */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\model\StockReturnCustomerDetail.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */