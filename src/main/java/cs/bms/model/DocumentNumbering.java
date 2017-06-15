/*     */ package cs.bms.model;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.GeneratedValue;
/*     */ import javax.persistence.GenerationType;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.JoinColumn;
/*     */ import javax.persistence.JoinTable;
/*     */ import javax.persistence.ManyToMany;
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
/*     */ @Table(name="document_numbering", catalog="public")
/*     */ @XmlRootElement
/*     */ public class DocumentNumbering
/*     */   implements Serializable
/*     */ {
/*     */   @Id
/*     */   @GeneratedValue(strategy=GenerationType.IDENTITY)
/*     */   @Column(name="id", nullable=false)
/*     */   protected Integer id;
/*     */   @JoinColumn(name="id_payment_proof", nullable=false)
/*     */   @ManyToOne
/*     */   protected PaymentProof paymentProof;
/*     */   @Column(name="ruc_company", nullable=false)
/*     */   protected String rucCompany;
/*     */   @Column(name="serie", nullable=false)
/*     */   protected String serie;
/*     */   @Column(name="numbering", nullable=false)
/*  43 */   protected Long numbering = Long.valueOf(1L); @Column(name="electronic", nullable=false)
/*  44 */   protected Boolean electronic = Boolean.FALSE;
/*     */   @ManyToMany
/*     */   @JoinTable(name="dn_has_user", joinColumns={@JoinColumn(name="id_document_numbering", nullable=false, updatable=false)}, inverseJoinColumns={@JoinColumn(name="id_user", nullable=false, updatable=false)})
/*  47 */   protected List<User> users = new ArrayList(0);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public DocumentNumbering() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public DocumentNumbering(Integer id)
/*     */   {
/*  59 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getId()
/*     */   {
/*  67 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setId(Integer id)
/*     */   {
/*  74 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public PaymentProof getPaymentProof()
/*     */   {
/*  81 */     return this.paymentProof;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setPaymentProof(PaymentProof paymentProof)
/*     */   {
/*  88 */     this.paymentProof = paymentProof;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getSerie()
/*     */   {
/*  96 */     return this.serie;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSerie(String serie)
/*     */   {
/* 103 */     this.serie = serie;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Long getNumbering()
/*     */   {
/* 110 */     return this.numbering;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setNumbering(Long numbering)
/*     */   {
/* 117 */     this.numbering = numbering;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Boolean getElectronic()
/*     */   {
/* 124 */     return this.electronic;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setElectronic(Boolean electronic)
/*     */   {
/* 131 */     this.electronic = electronic;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getRucCompany()
/*     */   {
/* 138 */     return this.rucCompany;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setRucCompany(String rucCompany)
/*     */   {
/* 145 */     this.rucCompany = rucCompany;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<User> getUsers()
/*     */   {
/* 152 */     return this.users;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setUsers(List<User> users)
/*     */   {
/* 159 */     this.users = users;
/*     */   }
/*     */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\model\DocumentNumbering.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */