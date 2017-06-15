/*     */ package cs.bms.model;
/*     */ 
/*     */ import gkfire.model.interfac.EntityActivate;
/*     */ import java.io.Serializable;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Objects;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.FetchType;
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
/*     */ @Table(name="permission", catalog="public")
/*     */ @XmlRootElement
/*     */ public class Permission
/*     */   implements Serializable, EntityActivate
/*     */ {
/*     */   @Id
/*     */   @GeneratedValue(strategy=GenerationType.IDENTITY)
/*     */   @Column(name="id", nullable=false)
/*     */   private Integer id;
/*     */   @Column(name="code", nullable=false, length=6)
/*     */   private String code;
/*     */   @Column(name="name", nullable=false)
/*     */   private String name;
/*     */   @Column(name="limited", nullable=false)
/*  43 */   private Boolean limited = Boolean.FALSE;
/*     */   
/*     */ 
/*     */   @JoinColumn(name="id_permission_category", nullable=false)
/*     */   @ManyToOne(fetch=FetchType.LAZY)
/*     */   private PermissionCategory permissionCategory;
/*     */   
/*     */ 
/*     */   @Column(name="active", nullable=false)
/*  52 */   private Boolean active = Boolean.TRUE;
/*     */   @ManyToMany
/*     */   @JoinTable(name="permission_has_rol", joinColumns={@JoinColumn(name="id_permission", nullable=false, updatable=false)}, inverseJoinColumns={@JoinColumn(name="id_rol", nullable=false, updatable=false)})
/*  55 */   private List<Rol> rols = new ArrayList(0);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   public String getCode()
/*     */   {
/*  81 */     return this.code;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCode(String code)
/*     */   {
/*  88 */     this.code = code;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getName()
/*     */   {
/*  95 */     return this.name;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setName(String name)
/*     */   {
/* 102 */     this.name = name;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Boolean getLimited()
/*     */   {
/* 109 */     return this.limited;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setLimited(Boolean limited)
/*     */   {
/* 116 */     this.limited = limited;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Boolean getActive()
/*     */   {
/* 123 */     return this.active;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setActive(Boolean active)
/*     */   {
/* 130 */     this.active = active;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<Rol> getRols()
/*     */   {
/* 137 */     return this.rols;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setRols(List<Rol> rols)
/*     */   {
/* 144 */     this.rols = rols;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public PermissionCategory getPermissionCategory()
/*     */   {
/* 151 */     return this.permissionCategory;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setPermissionCategory(PermissionCategory permissionCategory)
/*     */   {
/* 158 */     this.permissionCategory = permissionCategory;
/*     */   }
/*     */   
/*     */   public int hashCode()
/*     */   {
/* 163 */     int hash = 5;
/* 164 */     hash = 53 * hash + Objects.hashCode(this.id);
/* 165 */     return hash;
/*     */   }
/*     */   
/*     */   public boolean equals(Object obj)
/*     */   {
/* 170 */     if (obj == null) {
/* 171 */       return false;
/*     */     }
/* 173 */     if (getClass() != obj.getClass()) {
/* 174 */       return false;
/*     */     }
/* 176 */     Permission other = (Permission)obj;
/* 177 */     if (!Objects.equals(this.id, other.id)) {
/* 178 */       return false;
/*     */     }
/* 180 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\model\Permission.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */