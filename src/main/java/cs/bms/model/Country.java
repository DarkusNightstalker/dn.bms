/*    */ package cs.bms.model;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import java.util.List;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.GeneratedValue;
/*    */ import javax.persistence.GenerationType;
/*    */ import javax.persistence.Id;
/*    */ import javax.persistence.OneToMany;
/*    */ import javax.persistence.Table;
/*    */ import javax.xml.bind.annotation.XmlRootElement;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Entity
/*    */ @Table(name="country", uniqueConstraints={@javax.persistence.UniqueConstraint(columnNames={"name"}), @javax.persistence.UniqueConstraint(columnNames={"iso2"}), @javax.persistence.UniqueConstraint(columnNames={"iso3"})})
/*    */ @XmlRootElement
/*    */ public class Country
/*    */   implements Serializable
/*    */ {
/*    */   @Id
/*    */   @GeneratedValue(strategy=GenerationType.IDENTITY)
/*    */   @Column(name="id", nullable=false)
/*    */   private Integer id;
/*    */   @Column(name="name", length=50, nullable=false)
/*    */   private String name;
/*    */   @Column(name="iso2", length=2, nullable=false)
/*    */   private String iso2;
/*    */   @Column(name="iso3", length=3, nullable=false)
/*    */   private String iso3;
/*    */   @OneToMany(mappedBy="country")
/*    */   private List<Region> regions;
/*    */   
/*    */   public Integer getId()
/*    */   {
/* 52 */     return this.id;
/*    */   }
/*    */   
/*    */   public void setId(Integer id) {
/* 56 */     this.id = id;
/*    */   }
/*    */   
/*    */   public String getName() {
/* 60 */     return this.name;
/*    */   }
/*    */   
/*    */   public void setName(String name) {
/* 64 */     this.name = name;
/*    */   }
/*    */   
/*    */   public String getIso2() {
/* 68 */     return this.iso2;
/*    */   }
/*    */   
/*    */   public void setIso2(String iso2) {
/* 72 */     this.iso2 = iso2;
/*    */   }
/*    */   
/*    */   public String getIso3() {
/* 76 */     return this.iso3;
/*    */   }
/*    */   
/*    */   public void setIso3(String iso3) {
/* 80 */     this.iso3 = iso3;
/*    */   }
/*    */   
/*    */   public List<Region> getRegions() {
/* 84 */     return this.regions;
/*    */   }
/*    */   
/*    */   public void setRegions(List<Region> regions) {
/* 88 */     this.regions = regions;
/*    */   }
/*    */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\model\Country.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */