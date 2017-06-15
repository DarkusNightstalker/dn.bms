/*    */ package cs.bms.model;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.GeneratedValue;
/*    */ import javax.persistence.GenerationType;
/*    */ import javax.persistence.Id;
/*    */ import javax.persistence.JoinColumn;
/*    */ import javax.persistence.ManyToOne;
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
/*    */ @Table(name="district", uniqueConstraints={@javax.persistence.UniqueConstraint(columnNames={"name", "id_subregion"})})
/*    */ @XmlRootElement
/*    */ public class District
/*    */   implements Serializable
/*    */ {
/*    */   @Id
/*    */   @GeneratedValue(strategy=GenerationType.IDENTITY)
/*    */   @Column(name="id", nullable=false)
/*    */   private Integer id;
/*    */   @Column(name="name", nullable=false)
/*    */   private String name;
/*    */   @JoinColumn(name="id_subregion", nullable=true)
/*    */   @ManyToOne
/*    */   private Subregion subregion;
/*    */   
/*    */   public Integer getId()
/*    */   {
/* 45 */     return this.id;
/*    */   }
/*    */   
/*    */   public void setId(Integer id) {
/* 49 */     this.id = id;
/*    */   }
/*    */   
/*    */   public String getName() {
/* 53 */     return this.name;
/*    */   }
/*    */   
/*    */   public void setName(String name) {
/* 57 */     this.name = name;
/*    */   }
/*    */   
/*    */   public Subregion getSubregion() {
/* 61 */     return this.subregion;
/*    */   }
/*    */   
/*    */   public void setSubregion(Subregion subregion) {
/* 65 */     this.subregion = subregion;
/*    */   }
/*    */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\model\District.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */