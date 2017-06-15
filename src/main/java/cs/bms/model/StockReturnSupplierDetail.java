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
/*     */ 
/*     */ @Entity
/*     */ @Table(name="srs_detail", catalog="public")
/*     */ @XmlRootElement
/*     */ public class StockReturnSupplierDetail
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
/*     */   @JoinColumn(name="id_srs", nullable=false)
/*     */   @ManyToOne(fetch=FetchType.LAZY)
/*     */   private StockReturnSupplier stockReturnSupplier;
/*     */   @Column(name="quantity", nullable=false)
/*  44 */   private BigDecimal quantity = BigDecimal.ZERO;
/*     */   @Column(name="unit_cost", nullable=false)
/*  46 */   private BigDecimal unitCost = BigDecimal.ZERO;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getId()
/*     */   {
/*  54 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/*  61 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getProductName()
/*     */   {
/*  68 */     return this.productName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setProductName(String productName)
/*     */   {
/*  75 */     this.productName = productName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Product getProduct()
/*     */   {
/*  82 */     return this.product;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setProduct(Product product)
/*     */   {
/*  89 */     this.product = product;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public UoM getUom()
/*     */   {
/*  96 */     return this.uom;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setUom(UoM uom)
/*     */   {
/* 103 */     this.uom = uom;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public StockReturnSupplier getStockReturnSupplier()
/*     */   {
/* 110 */     return this.stockReturnSupplier;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setStockReturnSupplier(StockReturnSupplier stockReturnSupplier)
/*     */   {
/* 117 */     this.stockReturnSupplier = stockReturnSupplier;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public BigDecimal getQuantity()
/*     */   {
/* 124 */     return this.quantity;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setQuantity(BigDecimal quantity)
/*     */   {
/* 131 */     this.quantity = quantity;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public BigDecimal getUnitCost()
/*     */   {
/* 138 */     return this.unitCost;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setUnitCost(BigDecimal unitCost)
/*     */   {
/* 145 */     this.unitCost = unitCost;
/*     */   }
/*     */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\model\StockReturnSupplierDetail.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */