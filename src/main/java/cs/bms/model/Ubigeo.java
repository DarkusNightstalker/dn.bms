/*    */ package cs.bms.model;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.Id;
/*    */ import javax.persistence.Table;
/*    */ import javax.xml.bind.annotation.XmlRootElement;
/*    */ import org.hibernate.annotations.Immutable;
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
/*    */ @Table(name="ubigeo")
/*    */ @Immutable
/*    */ @XmlRootElement
/*    */ public class Ubigeo
/*    */   implements Serializable
/*    */ {
/*    */   @Id
/*    */   @Column(name="id", nullable=false)
/*    */   protected Integer id;
/*    */   @Column(name="name", nullable=false)
/*    */   protected String name;
/*    */   
/*    */   public Ubigeo(Integer id)
/*    */   {
/* 35 */     this.id = id;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public Ubigeo() {}
/*    */   
/*    */ 
/*    */ 
/*    */   public Integer getId()
/*    */   {
/* 46 */     return this.id;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void setId(Integer id)
/*    */   {
/* 53 */     this.id = id;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public String getName()
/*    */   {
/* 60 */     return this.name;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void setName(String name)
/*    */   {
/* 67 */     this.name = name;
/*    */   }
/*    */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\model\Ubigeo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */