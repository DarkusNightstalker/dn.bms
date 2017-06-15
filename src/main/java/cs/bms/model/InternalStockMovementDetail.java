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
/*     */ import javax.validation.constraints.Digits;
/*     */ import javax.xml.bind.annotation.XmlRootElement;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Entity
/*     */ @Table(name="ism_detail", catalog="public")
/*     */ @XmlRootElement
/*     */ public class InternalStockMovementDetail
/*     */   implements Serializable
/*     */ {
/*     */   @Id
/*     */   @GeneratedValue(strategy=GenerationType.IDENTITY)
/*     */   @Column(name="id", nullable=false)
/*     */   private Long id;
/*     */   @JoinColumn(name="id_ism", nullable=false)
/*     */   @ManyToOne(fetch=FetchType.LAZY)
/*     */   private InternalStockMovement internalStockMovement;
/*     */   @JoinColumn(name="id_product", nullable=false)
/*     */   @ManyToOne
/*     */   private Product product;
/*     */   @JoinColumn(name="id_uom", nullable=false)
/*     */   @ManyToOne
/*     */   private UoM uom;
/*     */   @Column(name="quantity", nullable=false)
/*     */   @Digits(integer=12, fraction=2)
/*  43 */   private BigDecimal quantity = BigDecimal.ZERO;
/*     */   @Column(name="product_name", nullable=false)
/*     */   private String productName;
/*     */   @Column(name="weight", nullable=true)
/*     */   @Digits(integer=10, fraction=3)
/*  48 */   private BigDecimal weight = BigDecimal.ZERO;
/*     */   
/*     */ 
/*     */   @JoinColumn(name="id_weight_uom", nullable=true)
/*     */   @ManyToOne
/*     */   private UoM weightUoM;
/*     */   
/*     */   @Column(name="unit_cost", nullable=false)
/*     */   private BigDecimal unitCost;
/*     */   
/*     */ 
/*     */   public Long getId()
/*     */   {
/*  61 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/*  68 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public InternalStockMovement getInternalStockMovement()
/*     */   {
/*  75 */     return this.internalStockMovement;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setInternalStockMovement(InternalStockMovement internalStockMovement)
/*     */   {
/*  82 */     this.internalStockMovement = internalStockMovement;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Product getProduct()
/*     */   {
/*  89 */     return this.product;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setProduct(Product product)
/*     */   {
/*  96 */     this.product = product;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public UoM getUom()
/*     */   {
/* 103 */     return this.uom;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setUom(UoM uom)
/*     */   {
/* 110 */     this.uom = uom;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public BigDecimal getQuantity()
/*     */   {
/* 117 */     return this.quantity;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setQuantity(BigDecimal quantity)
/*     */   {
/* 124 */     this.quantity = quantity;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public BigDecimal getWeight()
/*     */   {
/* 131 */     return this.weight;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setWeight(BigDecimal weight)
/*     */   {
/* 138 */     this.weight = weight;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public UoM getWeightUoM()
/*     */   {
/* 145 */     return this.weightUoM;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setWeightUoM(UoM weightUoM)
/*     */   {
/* 152 */     this.weightUoM = weightUoM;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getProductName()
/*     */   {
/* 159 */     return this.productName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setProductName(String productName)
/*     */   {
/* 166 */     this.productName = productName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public BigDecimal getUnitCost()
/*     */   {
/* 173 */     return this.unitCost;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setUnitCost(BigDecimal unitCost)
/*     */   {
/* 180 */     this.unitCost = unitCost;
/*     */   }
/*     */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\model\InternalStockMovementDetail.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */