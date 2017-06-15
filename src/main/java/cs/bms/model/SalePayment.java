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
/*     */ @Table(name="sale_payment", catalog="public")
/*     */ @XmlRootElement
/*     */ public class SalePayment
/*     */   implements Serializable
/*     */ {
/*     */   @Id
/*     */   @GeneratedValue(strategy=GenerationType.IDENTITY)
/*     */   @Column(name="id", nullable=false)
/*     */   private Long id;
/*     */   @JoinColumn(name="id_sale", nullable=false)
/*     */   @ManyToOne(fetch=FetchType.LAZY)
/*     */   private Sale sale;
/*     */   @Column(name="date_payment", nullable=false)
/*     */   private Date datePayment;
/*     */   @Column(name="quantity", nullable=false)
/*     */   private BigDecimal quantity;
/*     */   
/*     */   public SalePayment() {}
/*     */   
/*     */   public SalePayment(Sale sale, Date datePayment, BigDecimal quantity)
/*     */   {
/*  47 */     this.sale = sale;
/*  48 */     this.datePayment = datePayment;
/*  49 */     this.quantity = quantity;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Long getId()
/*     */   {
/*  57 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/*  64 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Sale getSale()
/*     */   {
/*  71 */     return this.sale;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSale(Sale sale)
/*     */   {
/*  78 */     this.sale = sale;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Date getDatePayment()
/*     */   {
/*  85 */     return this.datePayment;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setDatePayment(Date datePayment)
/*     */   {
/*  92 */     this.datePayment = datePayment;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public BigDecimal getQuantity()
/*     */   {
/*  99 */     return this.quantity;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setQuantity(BigDecimal quantity)
/*     */   {
/* 106 */     this.quantity = quantity;
/*     */   }
/*     */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\model\SalePayment.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */