/*     */ package cs.bms.model;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
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
/*     */ @Table(name="data_company", catalog="public")
/*     */ @XmlRootElement
/*     */ public class DataCompany
/*     */   implements Serializable
/*     */ {
/*     */   @Id
/*     */   @GeneratedValue(strategy=GenerationType.IDENTITY)
/*     */   @Column(name="id", nullable=false)
/*     */   private Long id;
/*     */   @JoinColumn(name="id_actor")
/*     */   @ManyToOne
/*     */   private Actor customer;
/*     */   @JoinColumn(name="id_company")
/*     */   @ManyToOne
/*     */   private Company company;
/*     */   @Column(name="code", nullable=false)
/*     */   private String code;
/*     */   @Column(name="points", nullable=false)
/*  39 */   private Long points = Long.valueOf(0L);
/*     */   
/*     */ 
/*     */ 
/*     */   public Long getId()
/*     */   {
/*  45 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setId(Long id)
/*     */   {
/*  52 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Actor getCustomer()
/*     */   {
/*  59 */     return this.customer;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCustomer(Actor customer)
/*     */   {
/*  66 */     this.customer = customer;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Company getCompany()
/*     */   {
/*  73 */     return this.company;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCompany(Company company)
/*     */   {
/*  80 */     this.company = company;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getCode()
/*     */   {
/*  87 */     return this.code;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCode(String code)
/*     */   {
/*  94 */     this.code = code;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Long getPoints()
/*     */   {
/* 101 */     return this.points;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setPoints(Long points)
/*     */   {
/* 108 */     this.points = points;
/*     */   }
/*     */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\model\DataCompany.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */