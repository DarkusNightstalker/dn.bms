/*     */ package cs.bms.model;
/*     */ 
/*     */ import gkfire.auditory.AuditoryEntity;
/*     */ import gkfire.model.interfac.EntityActivate;
/*     */ import java.math.BigDecimal;
/*     */ import java.util.Date;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.FetchType;
/*     */ import javax.persistence.GeneratedValue;
/*     */ import javax.persistence.GenerationType;
/*     */ import javax.persistence.Id;
/*     */ import javax.persistence.JoinColumn;
/*     */ import javax.persistence.ManyToOne;
/*     */ import javax.persistence.Table;
/*     */ import javax.persistence.Temporal;
/*     */ import javax.persistence.TemporalType;
/*     */ import javax.validation.constraints.Digits;
/*     */ import javax.xml.bind.annotation.XmlRootElement;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Entity
/*     */ @Table(name="company")
/*     */ @XmlRootElement
/*     */ public class Company
/*     */   implements AuditoryEntity<Integer, User>, EntityActivate
/*     */ {
/*     */   @Id
/*     */   @GeneratedValue(strategy=GenerationType.IDENTITY)
/*     */   @Column(name="id", nullable=false)
/*     */   protected Integer id;
/*     */   @Column(name="code", nullable=false)
/*     */   protected String code;
/*     */   @Column(name="name", nullable=false)
/*     */   protected String name;
/*     */   @Column(name="ruc", nullable=false)
/*     */   protected String ruc;
/*     */   @Column(name="description", nullable=true)
/*     */   protected String description;
/*     */   @JoinColumn(name="id_district", nullable=true)
/*     */   @ManyToOne
/*     */   protected District district;
/*     */   @JoinColumn(name="id_company_group", nullable=true)
/*     */   @ManyToOne
/*     */   protected CompanyGroup companyGroup;
/*     */   @Column(name="city", nullable=true)
/*     */   protected String city;
/*     */   @Column(name="address", nullable=true)
/*     */   protected String address;
/*     */   @Column(name="phone1", nullable=true)
/*     */   protected String phone1;
/*     */   @Column(name="phone2", nullable=true)
/*     */   protected String phone2;
/*     */   @Column(name="fax", nullable=true)
/*     */   protected String fax;
/*     */   @Column(name="private_transport_description", nullable=true)
/*     */   protected String privateTransportDescription;
/*     */   @Column(name="private_driver_license", nullable=true)
/*     */   protected String privateDriverLicense;
/*     */   @JoinColumn(name="id_parent", nullable=true)
/*     */   @ManyToOne
/*     */   protected Company parent;
/*     */   @Column(name="path", nullable=true)
/*     */   protected String path;
/*     */   @Column(name="igv_percent", nullable=false)
/*     */   @Digits(integer=3, fraction=1)
/*  72 */   protected BigDecimal igvPercent = BigDecimal.ZERO;
/*     */   
/*     */   @Column(name="title", nullable=true)
/*     */   protected String title;
/*     */   @Column(name="address_reference", nullable=true)
/*     */   protected String addressReference;
/*     */   @Column(name="last_data_update", nullable=true)
/*     */   @Temporal(TemporalType.TIMESTAMP)
/*     */   protected Date lastDataUpdate;
/*     */   @Column(name="can_buy", nullable=false)
/*  82 */   protected Boolean buy = Boolean.FALSE;
/*     */   @Column(name="can_stored", nullable=false)
/*  84 */   protected Boolean stored = Boolean.FALSE;
/*     */   @Column(name="can_sold", nullable=false)
/*  86 */   protected Boolean sold = Boolean.FALSE;
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
/* 102 */   protected Boolean active = Boolean.TRUE;
/*     */   
/*     */ 
/*     */   public Company() {}
/*     */   
/*     */   public Company(Integer id)
/*     */   {
/* 109 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getId()
/*     */   {
/* 117 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setId(Integer id)
/*     */   {
/* 124 */     this.id = id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getName()
/*     */   {
/* 131 */     return this.name;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setName(String name)
/*     */   {
/* 138 */     this.name = name;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getRuc()
/*     */   {
/* 145 */     return this.ruc;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setRuc(String ruc)
/*     */   {
/* 152 */     this.ruc = ruc;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getDescription()
/*     */   {
/* 159 */     return this.description;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setDescription(String description)
/*     */   {
/* 166 */     this.description = description;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public District getDistrict()
/*     */   {
/* 173 */     return this.district;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setDistrict(District district)
/*     */   {
/* 180 */     this.district = district;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getCity()
/*     */   {
/* 187 */     return this.city;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCity(String city)
/*     */   {
/* 194 */     this.city = city;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getAddress()
/*     */   {
/* 201 */     return this.address;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setAddress(String address)
/*     */   {
/* 208 */     this.address = address;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getPhone1()
/*     */   {
/* 215 */     return this.phone1;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setPhone1(String phone1)
/*     */   {
/* 222 */     this.phone1 = phone1;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getPhone2()
/*     */   {
/* 229 */     return this.phone2;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setPhone2(String phone2)
/*     */   {
/* 236 */     this.phone2 = phone2;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getFax()
/*     */   {
/* 243 */     return this.fax;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setFax(String fax)
/*     */   {
/* 250 */     this.fax = fax;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Company getParent()
/*     */   {
/* 257 */     return this.parent;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setParent(Company parent)
/*     */   {
/* 264 */     this.parent = parent;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getPath()
/*     */   {
/* 271 */     return this.path;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setPath(String path)
/*     */   {
/* 278 */     this.path = path;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public BigDecimal getIgvPercent()
/*     */   {
/* 285 */     return this.igvPercent;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setIgvPercent(BigDecimal igvPercent)
/*     */   {
/* 292 */     this.igvPercent = igvPercent;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getTitle()
/*     */   {
/* 299 */     return this.title;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setTitle(String title)
/*     */   {
/* 306 */     this.title = title;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getAddressReference()
/*     */   {
/* 313 */     return this.addressReference;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setAddressReference(String AddressReference)
/*     */   {
/* 320 */     this.addressReference = AddressReference;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Date getLastDataUpdate()
/*     */   {
/* 327 */     return this.lastDataUpdate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setLastDataUpdate(Date lastDataUpdate)
/*     */   {
/* 334 */     this.lastDataUpdate = lastDataUpdate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Boolean getBuy()
/*     */   {
/* 341 */     return this.buy;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setBuy(Boolean buy)
/*     */   {
/* 348 */     this.buy = buy;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Boolean getStored()
/*     */   {
/* 355 */     return this.stored;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setStored(Boolean stored)
/*     */   {
/* 362 */     this.stored = stored;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Boolean getSold()
/*     */   {
/* 369 */     return this.sold;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSold(Boolean sold)
/*     */   {
/* 376 */     this.sold = sold;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public User getCreateUser()
/*     */   {
/* 383 */     return this.createUser;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCreateUser(User createUser)
/*     */   {
/* 390 */     this.createUser = createUser;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Date getCreateDate()
/*     */   {
/* 397 */     return this.createDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCreateDate(Date createDate)
/*     */   {
/* 404 */     this.createDate = createDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public User getEditUser()
/*     */   {
/* 411 */     return this.editUser;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setEditUser(User editUser)
/*     */   {
/* 418 */     this.editUser = editUser;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Date getEditDate()
/*     */   {
/* 425 */     return this.editDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setEditDate(Date editDate)
/*     */   {
/* 432 */     this.editDate = editDate;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Boolean getActive()
/*     */   {
/* 439 */     return this.active;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setActive(Boolean active)
/*     */   {
/* 446 */     this.active = active;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getCode()
/*     */   {
/* 453 */     return this.code;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCode(String code)
/*     */   {
/* 460 */     this.code = code;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getPrivateTransportDescription()
/*     */   {
/* 467 */     return this.privateTransportDescription;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setPrivateTransportDescription(String privateTransportDescription)
/*     */   {
/* 474 */     this.privateTransportDescription = privateTransportDescription;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getPrivateDriverLicense()
/*     */   {
/* 481 */     return this.privateDriverLicense;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setPrivateDriverLicense(String privateDriverLicense)
/*     */   {
/* 488 */     this.privateDriverLicense = privateDriverLicense;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CompanyGroup getCompanyGroup()
/*     */   {
/* 495 */     return this.companyGroup;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCompanyGroup(CompanyGroup companyGroup)
/*     */   {
/* 502 */     this.companyGroup = companyGroup;
/*     */   }
/*     */ }


/* Location:              D:\Proyectos\cs.bms.minisol.web-1.0.1\WEB-INF\lib\cs.bms-1.0.jar!\cs\bms\model\Company.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */