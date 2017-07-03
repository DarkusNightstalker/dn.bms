package cs.bms.model;

import gkfire.auditory.AuditoryEntity;
import gkfire.model.interfac.EntityActivate;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Digits;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "company")
@XmlRootElement
public class Company implements AuditoryEntity<Integer, User>, EntityActivate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    protected Integer id;
    @Column(name = "code", nullable = false)
    protected String code;
    @Column(name = "name", nullable = false)
    protected String name;
    @Column(name = "ruc", nullable = false)
    protected String ruc;
    @Column(name = "description", nullable = true)
    protected String description;
    @JoinColumn(name = "id_district", nullable = true)
    @ManyToOne
    protected District district;
    @JoinColumn(name = "id_company_group", nullable = true)
    @ManyToOne
    protected CompanyGroup companyGroup;
    @Column(name = "city", nullable = true)
    protected String city;
    @Column(name = "address", nullable = true)
    protected String address;
    @Column(name = "phone1", nullable = true)
    protected String phone1;
    @Column(name = "phone2", nullable = true)
    protected String phone2;
    @Column(name = "fax", nullable = true)
    protected String fax;
    @Column(name = "private_transport_description", nullable = true)
    protected String privateTransportDescription;
    @Column(name = "private_driver_license", nullable = true)
    protected String privateDriverLicense;
    @JoinColumn(name = "id_parent", nullable = true)
    @ManyToOne
    protected Company parent;
    @Column(name = "path", nullable = true)
    protected String path;
    @Column(name = "igv_percent", nullable = false)
    @Digits(integer = 3, fraction = 1)
    protected BigDecimal igvPercent = BigDecimal.ZERO;

    @Column(name = "title", nullable = true)
    protected String title;
    @Column(name = "address_reference", nullable = true)
    protected String addressReference;
    @Column(name = "last_data_update", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    protected Date lastDataUpdate;
    @Column(name = "can_buy", nullable = false)
    protected Boolean buy = Boolean.FALSE;
    @Column(name = "can_stored", nullable = false)
    protected Boolean stored = Boolean.FALSE;
    @Column(name = "can_sold", nullable = false)
    protected Boolean sold = Boolean.FALSE;

    @JoinColumn(name = "create_uid", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    protected User createUser;
    @Column(name = "create_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    protected Date createDate;
    @JoinColumn(name = "edit_uid")
    @ManyToOne(fetch = FetchType.LAZY)
    protected User editUser;
    @Column(name = "edit_date")
    @Temporal(TemporalType.TIMESTAMP)
    protected Date editDate;
    @Column(name = "active", nullable = false)
    protected Boolean active = Boolean.TRUE;

    public Company() {
    }

    public Company(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRuc() {
        return this.ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public District getDistrict() {
        return this.district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone1() {
        return this.phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return this.phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getFax() {
        return this.fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public Company getParent() {
        return this.parent;
    }

    public void setParent(Company parent) {
        this.parent = parent;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public BigDecimal getIgvPercent() {
        return this.igvPercent;
    }

    public void setIgvPercent(BigDecimal igvPercent) {
        this.igvPercent = igvPercent;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddressReference() {
        return this.addressReference;
    }

    public void setAddressReference(String AddressReference) {
        this.addressReference = AddressReference;
    }

    public Date getLastDataUpdate() {
        return this.lastDataUpdate;
    }

    public void setLastDataUpdate(Date lastDataUpdate) {
        this.lastDataUpdate = lastDataUpdate;
    }

    public Boolean getBuy() {
        return this.buy;
    }

    public void setBuy(Boolean buy) {
        this.buy = buy;
    }

    public Boolean getStored() {
        return this.stored;
    }

    public void setStored(Boolean stored) {
        this.stored = stored;
    }

    public Boolean getSold() {
        return this.sold;
    }

    public void setSold(Boolean sold) {
        this.sold = sold;
    }

    @Override
    public User getCreateUser() {
        return this.createUser;
    }

    @Override
    public void setCreateUser(User createUser) {
        this.createUser = createUser;
    }

    @Override
    public Date getCreateDate() {
        return this.createDate;
    }

    @Override
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public User getEditUser() {
        return this.editUser;
    }

    public void setEditUser(User editUser) {
        this.editUser = editUser;
    }

    public Date getEditDate() {
        return this.editDate;
    }

    public void setEditDate(Date editDate) {
        this.editDate = editDate;
    }

    public Boolean getActive() {
        return this.active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPrivateTransportDescription() {
        return this.privateTransportDescription;
    }

    public void setPrivateTransportDescription(String privateTransportDescription) {
        this.privateTransportDescription = privateTransportDescription;
    }

    public String getPrivateDriverLicense() {
        return this.privateDriverLicense;
    }

    public void setPrivateDriverLicense(String privateDriverLicense) {
        this.privateDriverLicense = privateDriverLicense;
    }

    public CompanyGroup getCompanyGroup() {
        return this.companyGroup;
    }

    public void setCompanyGroup(CompanyGroup companyGroup) {
        this.companyGroup = companyGroup;
    }
}
