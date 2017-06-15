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
/*    */ @Entity
/*    */ @Table(name="subregion", uniqueConstraints={@javax.persistence.UniqueConstraint(columnNames={"name", "id_region"})})
/*    */ @XmlRootElement
/*    */ public class Subregion
/*    */   implements Serializable
/*    */ {
/*    */   @Id
/*    */   @GeneratedValue(strategy=GenerationType.IDENTITY)
/*    */   @Column(name="id", nullable=false)
/*    */   private Integer id;
/*    */   @Column(name="name", nullable=false)
/*    */   private String name;
/*    */   @JoinColumn(name="id_region", nullable=true)
/*    */   @ManyToOne
/*    */   private Region region;
/*    */   @OneToMany(mappedBy="subregion")
/*    */   private List<District> districts;
/*    */   
/*    */   public Integer getId()
/*    */   {
/* 48 */     return this.id;
/*    */   }
/*    */   
/*    */   public void setId(Integer id) {
/* 52 */     this.id = id;
/*    */   }
/*    */   
/*    */   public String getName() {
/* 56 */     return this.name;
/*    */   }
/*    */   
/*    */   public void setName(String name) {
/* 60 */     this.name = name;
/*    */   }
/*    */   
/*    */   public Region getRegion() {
/* 64 */     return this.region;
/*    */   }
/*    */   
/*    */   public void setRegion(Region region) {
/* 68 */     this.region = region;
/*    */   }
/*    */   
/*    */   public List<District> getDistricts() {
/* 72 */     return this.districts;
/*    */   }
/*    */   
/*    */   public void setDistricts(List<District> districts) {
/* 76 */     this.districts = districts;
/*    */   }
/*    */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\model\Subregion.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */