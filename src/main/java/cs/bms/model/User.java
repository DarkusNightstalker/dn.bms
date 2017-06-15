/*     */ package cs.bms.model;
/*     */ 
/*     */ import gkfire.auditory.AuditoryEntity;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.List;
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
/*     */ @Entity
/*     */ @Table(name="user", catalog="public")
/*     */ @XmlRootElement
/*     */ public class User
/*     */   implements AuditoryEntity<Integer, User>
/*     */ {
/*     */   @Id
/*     */   @GeneratedValue(strategy=GenerationType.IDENTITY)
/*     */   @Column(name="id", nullable=false)
/*     */   protected Integer id;
/*     */   @Column(name="password", nullable=false)
/*     */   protected String password;
/*     */   @Column(name="username", nullable=false)
/*     */   protected String username;
/*     */   @Column(name="last_login")
/*     */   @Temporal(TemporalType.TIMESTAMP)
/*     */   protected Date lastLogin;
/*     */   @Column(name="is_superuser", nullable=false)
/*  47 */   protected Boolean superUser = Boolean.FALSE;
/*     */   
/*     */   @JoinColumn(name="id_employee", nullable=true)
/*     */   @ManyToOne
/*     */   protected Actor employee;
/*     */   
/*     */   @JoinColumn(name="create_uid", nullable=false)
/*     */   @ManyToOne(fetch=FetchType.LAZY)
/*     */   protected User createUser;
/*     */   
/*     */   @Column(name="create_date", nullable=false)
/*     */   @Temporal(TemporalType.TIMESTAMP)
/*     */   protected Date createDate;
/*     */   @JoinColumn(name="edit_uid")
/*     */   @ManyToOne(fetch=FetchType.LAZY)
/*     */   protected User editUser;
/*     */   @Column(name="edit_date")
/*     */   @Temporal(TemporalType.TIMESTAMP)
/*     */   protected Date editDate;
/*     */   @Column(name="active", nullable=false)
/*  67 */   protected Boolean active = Boolean.TRUE;
/*     */   @ManyToMany
/*     */   @JoinTable(name="rol_has_user", joinColumns={@JoinColumn(name="id_user", nullable=false, updatable=false)}, inverseJoinColumns={@JoinColumn(name="id_rol", nullable=false, updatable=false)})
/*  70 */   protected List<Rol> rols = new ArrayList(0);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @ManyToMany
/*     */   @JoinTable(name="dn_has_user", joinColumns={@JoinColumn(name="id_user", nullable=false, updatable=false)}, inverseJoinColumns={@JoinColumn(name="id_document_numbering", nullable=false, updatable=false)})
/*  78 */   protected List<DocumentNumbering> documentNumberings = new ArrayList(0);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @ManyToMany
/*     */   @JoinTable(name="special_p_has_user", joinColumns={@JoinColumn(name="id_user", nullable=false, updatable=false)}, inverseJoinColumns={@JoinColumn(name="id_special_permission", nullable=false, updatable=false)})
/*  86 */   protected List<SpecialPermission> specialPermissions = new ArrayList(0);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public User() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public User(Integer id)
/*     */   {
/*  98 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getId()
/*     */   {
/* 106 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setId(Integer id)
/*     */   {
/* 114 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getPassword()
/*     */   {
/* 121 */     return this.password;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setPassword(String password)
/*     */   {
/* 128 */     this.password = password;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getUsername()
/*     */   {
/* 135 */     return this.username;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setUsername(String username)
/*     */   {
/* 142 */     this.username = username;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Date getLastLogin()
/*     */   {
/* 149 */     return this.lastLogin;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setLastLogin(Date lastLogin)
/*     */   {
/* 156 */     this.lastLogin = lastLogin;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Boolean getSuperUser()
/*     */   {
/* 163 */     return this.superUser;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSuperUser(Boolean superUser)
/*     */   {
/* 170 */     this.superUser = superUser;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public User getCreateUser()
/*     */   {
/* 177 */     return this.createUser;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCreateUser(User createUser)
/*     */   {
/* 184 */     this.createUser = createUser;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Date getCreateDate()
/*     */   {
/* 191 */     return this.createDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCreateDate(Date createDate)
/*     */   {
/* 198 */     this.createDate = createDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public User getEditUser()
/*     */   {
/* 205 */     return this.editUser;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setEditUser(User editUser)
/*     */   {
/* 212 */     this.editUser = editUser;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Date getEditDate()
/*     */   {
/* 219 */     return this.editDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setEditDate(Date editDate)
/*     */   {
/* 226 */     this.editDate = editDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Boolean getActive()
/*     */   {
/* 233 */     return this.active;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setActive(Boolean active)
/*     */   {
/* 240 */     this.active = active;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<Rol> getRols()
/*     */   {
/* 247 */     return this.rols;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setRols(List<Rol> rols)
/*     */   {
/* 254 */     this.rols = rols;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Actor getEmployee()
/*     */   {
/* 261 */     return this.employee;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setEmployee(Actor employee)
/*     */   {
/* 268 */     this.employee = employee;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<SpecialPermission> getSpecialPermissions()
/*     */   {
/* 275 */     return this.specialPermissions;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSpecialPermissions(List<SpecialPermission> specialPermissions)
/*     */   {
/* 282 */     this.specialPermissions = specialPermissions;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<DocumentNumbering> getDocumentNumberings()
/*     */   {
/* 289 */     return this.documentNumberings;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setDocumentNumberings(List<DocumentNumbering> documentNumberings)
/*     */   {
/* 296 */     this.documentNumberings = documentNumberings;
/*     */   }
/*     */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\model\User.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */