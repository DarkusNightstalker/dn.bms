/*     */ package cs.bms.model;
/*     */ 
/*     */ import gkfire.auditory.AuditoryEntity;
/*     */ import gkfire.model.interfac.EntityActivate;
/*     */ import java.io.Serializable;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
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
/*     */ import javax.persistence.Temporal;
/*     */ import javax.persistence.TemporalType;
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
/*     */ 
/*     */ @Entity
/*     */ @Table(name="rol", catalog="public")
/*     */ @XmlRootElement
/*     */ public class Rol
/*     */   implements Serializable, AuditoryEntity<Integer, User>, EntityActivate
/*     */ {
/*     */   @Id
/*     */   @GeneratedValue(strategy=GenerationType.IDENTITY)
/*     */   @Column(name="id", nullable=false)
/*     */   private Integer id;
/*     */   @Column(name="name", nullable=false, length=100)
/*     */   private String name;
/*     */   @JoinColumn(name="create_uid", nullable=false)
/*     */   @ManyToOne(fetch=FetchType.LAZY)
/*     */   private User createUser;
/*     */   @Column(name="create_date", nullable=false)
/*     */   @Temporal(TemporalType.TIMESTAMP)
/*     */   private Date createDate;
/*     */   @JoinColumn(name="edit_uid")
/*     */   @ManyToOne(fetch=FetchType.LAZY)
/*     */   private User editUser;
/*     */   @Column(name="edit_date")
/*     */   @Temporal(TemporalType.TIMESTAMP)
/*     */   private Date editDate;
/*     */   @Column(name="active", nullable=false)
/*  59 */   private Boolean active = Boolean.TRUE;
/*     */   @ManyToMany
/*     */   @JoinTable(name="rol_has_user", joinColumns={@JoinColumn(name="id_rol", nullable=false, updatable=false)}, inverseJoinColumns={@JoinColumn(name="id_user", nullable=false, updatable=false)})
/*  62 */   private List<User> users = new ArrayList(0);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @ManyToMany
/*     */   @JoinTable(name="permission_has_rol", joinColumns={@JoinColumn(name="id_rol", nullable=false, updatable=false)}, inverseJoinColumns={@JoinColumn(name="id_permission", nullable=false, updatable=false)})
/*  70 */   private List<Permission> permissions = new ArrayList(0);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Rol() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Rol(Integer id)
/*     */   {
/*  82 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int hashCode()
/*     */   {
/*  89 */     int hash = 3;
/*  90 */     hash = 19 * hash + Objects.hashCode(this.id);
/*  91 */     return hash;
/*     */   }
/*     */   
/*     */   public boolean equals(Object obj)
/*     */   {
/*  96 */     if (obj == null) {
/*  97 */       return false;
/*     */     }
/*  99 */     if (getClass() != obj.getClass()) {
/* 100 */       return false;
/*     */     }
/* 102 */     Rol other = (Rol)obj;
/* 103 */     if (!Objects.equals(this.id, other.id)) {
/* 104 */       return false;
/*     */     }
/* 106 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getId()
/*     */   {
/* 114 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setId(Integer id)
/*     */   {
/* 122 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getName()
/*     */   {
/* 130 */     return this.name;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setName(String name)
/*     */   {
/* 137 */     this.name = name;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public User getCreateUser()
/*     */   {
/* 144 */     return this.createUser;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCreateUser(User createUser)
/*     */   {
/* 151 */     this.createUser = createUser;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Date getCreateDate()
/*     */   {
/* 158 */     return this.createDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCreateDate(Date createDate)
/*     */   {
/* 165 */     this.createDate = createDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public User getEditUser()
/*     */   {
/* 172 */     return this.editUser;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setEditUser(User editUser)
/*     */   {
/* 179 */     this.editUser = editUser;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Date getEditDate()
/*     */   {
/* 186 */     return this.editDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setEditDate(Date editDate)
/*     */   {
/* 193 */     this.editDate = editDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Boolean getActive()
/*     */   {
/* 200 */     return this.active;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setActive(Boolean active)
/*     */   {
/* 207 */     this.active = active;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<User> getUsers()
/*     */   {
/* 214 */     return this.users;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setUsers(List<User> users)
/*     */   {
/* 221 */     this.users = users;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<Permission> getPermissions()
/*     */   {
/* 228 */     return this.permissions;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setPermissions(List<Permission> permissions)
/*     */   {
/* 235 */     this.permissions = permissions;
/*     */   }
/*     */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\model\Rol.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */