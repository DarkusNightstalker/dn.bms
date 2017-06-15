/*    */ package cs.bms.model;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import java.util.List;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.GeneratedValue;
/*    */ import javax.persistence.GenerationType;
/*    */ import javax.persistence.Id;
/*    */ import javax.persistence.JoinColumn;
/*    */ import javax.persistence.ManyToOne;
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
/*    */ @Entity
/*    */ @Table(name="region", uniqueConstraints={@javax.persistence.UniqueConstraint(columnNames={"name", "id_country"})})
/*    */ @XmlRootElement
/*    */ public class Region
/*    */   implements Serializable
/*    */ {
/*    */   @Id
/*    */   @GeneratedValue(strategy=GenerationType.IDENTITY)
/*    */   @Column(name="id", nullable=false)
/*    */   private Integer id;
/*    */   @Column(name="name", nullable=false)
/*    */   private String name;
/*    */   @Column(name="code", nullable=true)
/*    */   private String code;
/*    */   @JoinColumn(name="id_country", nullable=true)
/*    */   @ManyToOne
/*    */   private Country country;
/*    */   @OneToMany(mappedBy="region")
/*    */   private List<Subregion> subregions;
/*    */   
/*    */   public Integer getId()
/*    */   {
/* 51 */     return this.id;
/*    */   }
/*    */   
/*    */   public void setId(Integer id) {
/* 55 */     this.id = id;
/*    */   }
/*    */   
/*    */   public String getName() {
/* 59 */     return this.name;
/*    */   }
/*    */   
/*    */   public void setName(String name) {
/* 63 */     this.name = name;
/*    */   }
/*    */   
/*    */   public String getCode() {
/* 67 */     return this.code;
/*    */   }
/*    */   
/*    */   public void setCode(String code) {
/* 71 */     this.code = code;
/*    */   }
/*    */   
/*    */   public Country getCountry() {
/* 75 */     return this.country;
/*    */   }
/*    */   
/*    */   public void setCountry(Country country) {
/* 79 */     this.country = country;
/*    */   }
/*    */   
/*    */   public List<Subregion> getSubregions() {
/* 83 */     return this.subregions;
/*    */   }
/*    */   
/*    */   public void setSubregions(List<Subregion> subregions) {
/* 87 */     this.subregions = subregions;
/*    */   }
/*    */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\model\Region.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */