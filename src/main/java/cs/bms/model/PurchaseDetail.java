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
/*     */ @Table(name="purchase_detail", catalog="public")
/*     */ @XmlRootElement
/*     */ public class PurchaseDetail
/*     */   implements Serializable
/*     */ {
/*     */   @Id
/*     */   @GeneratedValue(strategy=GenerationType.IDENTITY)
/*     */   @Column(name="id", nullable=false)
/*     */   protected Long id;
/*     */   @JoinColumn(name="id_purchase", nullable=false)
/*     */   @ManyToOne(fetch=FetchType.LAZY)
/*     */   protected Purchase purchase;
/*     */   @JoinColumn(name="id_product", nullable=false)
/*     */   @ManyToOne(fetch=FetchType.LAZY)
/*     */   protected Product product;
/*     */   @JoinColumn(name="id_uom", nullable=false)
/*     */   @ManyToOne
/*     */   protected UoM uom;
/*     */   @Column(name="product_name", nullable=false)
/*     */   protected String productName;
/*     */   @Column(name="quantity", nullable=false)
/*     */   protected BigDecimal quantity;
/*     */   @Column(name="unit_price", nullable=false)
/*     */   protected BigDecimal unitPrice;
/*     */   @Column(name="subtotal", nullable=false)
/*  48 */   protected BigDecimal subtotal = BigDecimal.ZERO;
/*     */   @Column(name="igv", nullable=false)
/*  50 */   protected BigDecimal igv = BigDecimal.ZERO;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Purchase getPurchase()
/*     */   {
/*  57 */     return this.purchase;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setPurchase(Purchase purchase)
/*     */   {
/*  64 */     this.purchase = purchase;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Product getProduct()
/*     */   {
/*  71 */     return this.product;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setProduct(Product product)
/*     */   {
/*  78 */     this.product = product;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public UoM getUom()
/*     */   {
/*  85 */     return this.uom;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setUom(UoM uom)
/*     */   {
/*  92 */     this.uom = uom;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getProductName()
/*     */   {
/*  99 */     return this.productName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setProductName(String productName)
/*     */   {
/* 106 */     this.productName = productName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public BigDecimal getQuantity()
/*     */   {
/* 113 */     return this.quantity;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setQuantity(BigDecimal quantity)
/*     */   {
/* 120 */     this.quantity = quantity;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public BigDecimal getUnitPrice()
/*     */   {
/* 127 */     return this.unitPrice;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setUnitPrice(BigDecimal unitPrice)
/*     */   {
/* 134 */     this.unitPrice = unitPrice;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Long getId()
/*     */   {
/* 141 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/* 148 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public BigDecimal getSubtotal()
/*     */   {
/* 155 */     return this.subtotal;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSubtotal(BigDecimal subtotal)
/*     */   {
/* 162 */     this.subtotal = subtotal;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public BigDecimal getIgv()
/*     */   {
/* 169 */     return this.igv;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setIgv(BigDecimal igv)
/*     */   {
/* 176 */     this.igv = igv;
/*     */   }
/*     */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\model\PurchaseDetail.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */