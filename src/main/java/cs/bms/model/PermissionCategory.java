/*     */ package cs.bms.model;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Objects;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.GeneratedValue;
/*     */ import javax.persistence.GenerationType;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.OneToMany;
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
/*     */ @Table(name="permission_category")
/*     */ @XmlRootElement
/*     */ public class PermissionCategory
/*     */   implements Serializable
/*     */ {
/*     */   @Id
/*     */   @GeneratedValue(strategy=GenerationType.IDENTITY)
/*     */   @Column(name="id", nullable=false)
/*     */   private Integer id;
/*     */   @Column(name="name", nullable=false)
/*     */   private String name;
/*     */   @Column(name="icon", nullable=false)
/*     */   private String icon;
/*     */   @Column(name="summary", nullable=false)
/*     */   private String summary;
/*     */   @OneToMany(mappedBy="permissionCategory")
/*  40 */   private List<Permission> permissions = new ArrayList(0);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getId()
/*     */   {
/*  47 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setId(Integer id)
/*     */   {
/*  54 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getName()
/*     */   {
/*  61 */     return this.name;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setName(String name)
/*     */   {
/*  68 */     this.name = name;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getIcon()
/*     */   {
/*  75 */     return this.icon;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setIcon(String icon)
/*     */   {
/*  82 */     this.icon = icon;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getSummary()
/*     */   {
/*  89 */     return this.summary;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSummary(String summary)
/*     */   {
/*  96 */     this.summary = summary;
/*     */   }
/*     */   
/*     */   public int hashCode()
/*     */   {
/* 101 */     int hash = 3;
/* 102 */     hash = 29 * hash + Objects.hashCode(this.id);
/* 103 */     return hash;
/*     */   }
/*     */   
/*     */   public boolean equals(Object obj)
/*     */   {
/* 108 */     if (obj == null) {
/* 109 */       return false;
/*     */     }
/* 111 */     if (getClass() != obj.getClass()) {
/* 112 */       return false;
/*     */     }
/* 114 */     PermissionCategory other = (PermissionCategory)obj;
/* 115 */     if (!Objects.equals(this.id, other.id)) {
/* 116 */       return false;
/*     */     }
/* 118 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<Permission> getPermissions()
/*     */   {
/* 125 */     return this.permissions;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setPermissions(List<Permission> permissions)
/*     */   {
/* 132 */     this.permissions = permissions;
/*     */   }
/*     */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\model\PermissionCategory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */