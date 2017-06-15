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
/*     */ 
/*     */ @Entity
/*     */ @Table(name="sale_detail", catalog="public")
/*     */ @XmlRootElement
/*     */ public class SaleDetail
/*     */   implements Serializable
/*     */ {
/*     */   @Id
/*     */   @GeneratedValue(strategy=GenerationType.IDENTITY)
/*     */   @Column(name="id", nullable=false)
/*     */   private Long id;
/*     */   @JoinColumn(name="id_sale", nullable=false)
/*     */   @ManyToOne(fetch=FetchType.LAZY)
/*     */   private Sale sale;
/*     */   @JoinColumn(name="id_product", nullable=false)
/*     */   @ManyToOne(fetch=FetchType.LAZY)
/*     */   private Product product;
/*     */   @JoinColumn(name="id_uom", nullable=false)
/*     */   @ManyToOne
/*     */   private UoM uom;
/*     */   @Column(name="subtotal", nullable=false)
/*  43 */   private BigDecimal subtotal = BigDecimal.ZERO;
/*     */   @Column(name="product_name", nullable=false)
/*     */   private String productName;
/*     */   @Column(name="quantity", nullable=false)
/*     */   private BigDecimal quantity;
/*     */   @Column(name="unit_price", nullable=false)
/*     */   private BigDecimal unitPrice;
/*     */   @Column(name="unit_cost", nullable=false)
/*  51 */   private BigDecimal unitCost = BigDecimal.ZERO;
/*     */   
/*     */ 
/*     */   @Column(name="points_price", nullable=false)
/*     */   private BigDecimal pointsPrice;
/*     */   
/*     */ 
/*     */   public Long getId()
/*     */   {
/*  60 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/*  67 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Sale getSale()
/*     */   {
/*  74 */     return this.sale;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSale(Sale sale)
/*     */   {
/*  81 */     this.sale = sale;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Product getProduct()
/*     */   {
/*  88 */     return this.product;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setProduct(Product product)
/*     */   {
/*  95 */     this.product = product;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public UoM getUom()
/*     */   {
/* 102 */     return this.uom;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setUom(UoM uom)
/*     */   {
/* 109 */     this.uom = uom;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getProductName()
/*     */   {
/* 116 */     return this.productName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setProductName(String productName)
/*     */   {
/* 123 */     this.productName = productName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public BigDecimal getQuantity()
/*     */   {
/* 130 */     return this.quantity;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setQuantity(BigDecimal quantity)
/*     */   {
/* 137 */     this.quantity = quantity;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public BigDecimal getUnitPrice()
/*     */   {
/* 144 */     return this.unitPrice;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setUnitPrice(BigDecimal unitPrice)
/*     */   {
/* 151 */     this.unitPrice = unitPrice;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public BigDecimal getSubtotal()
/*     */   {
/* 158 */     return this.subtotal;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSubtotal(BigDecimal subtotal)
/*     */   {
/* 165 */     this.subtotal = subtotal;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public BigDecimal getPointsPrice()
/*     */   {
/* 172 */     return this.pointsPrice;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setPointsPrice(BigDecimal pointsPrice)
/*     */   {
/* 179 */     this.pointsPrice = pointsPrice;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public BigDecimal getUnitCost()
/*     */   {
/* 186 */     return this.unitCost;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setUnitCost(BigDecimal unitCost)
/*     */   {
/* 193 */     this.unitCost = unitCost;
/*     */   }
/*     */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\model\SaleDetail.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */