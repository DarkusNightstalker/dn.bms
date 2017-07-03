package cs.bms.model;

import gkfire.auditory.AuditoryEntity;
import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "actor", catalog = "public")
@XmlRootElement
public class Actor
        implements Serializable, AuditoryEntity<Long, User> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "identity_number", nullable = false)
    private String identityNumber;
    @Column(name = "name", nullable = true)
    private String name;
    @Column(name = "other", nullable = true)
    private String other;
    @Column(name = "representative", nullable = true)
    private String representative;
    @Column(name = "address", nullable = true)
    private String address;
    @Column(name = "points", nullable = true)
    private Long points = 0L;
    @Column(name = "synchronized", nullable = false)
    private Boolean synchronized_ = Boolean.FALSE;
    @Column(name = "uploaded", nullable = false)
    private Boolean uploaded = Boolean.TRUE;
    @Column(name = "customer", nullable = false)
    private Boolean customer = Boolean.FALSE;
    @Column(name = "supplier", nullable = false)
    private Boolean supplier = Boolean.FALSE;

    @JoinColumn(name = "id_district", nullable = true)
    @ManyToOne
    private Ubigeo ubigeo;

    @JoinColumn(name = "id_identity_document", nullable = false)
    @ManyToOne
    private IdentityDocument identityDocument;
    @JoinColumn(name = "create_uid", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private User createUser;
    @Column(name = "create_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @JoinColumn(name = "edit_uid")
    @ManyToOne(fetch = FetchType.LAZY)
    private User editUser;
    @Column(name = "edit_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date editDate;
    @Column(name = "active", nullable = false)
    private Boolean active = Boolean.TRUE;

    public Actor(Long id) {
        this.id = id;
    }

    public Actor() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdentityNumber() {
        return this.identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public IdentityDocument getIdentityDocument() {
        return this.identityDocument;
    }

    public void setIdentityDocument(IdentityDocument identityDocument) {
        this.identityDocument = identityDocument;
    }

    public User getCreateUser() {
        return this.createUser;
    }

    public void setCreateUser(User createUser) {
        this.createUser = createUser;
    }

    public Date getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

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

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getPoints() {
        return this.points;
    }

    public void setPoints(Long points) {
        this.points = points;
    }

    public String getRepresentative() {
        return this.representative;
    }

    public void setRepresentative(String representative) {
        this.representative = representative;
    }

    public Boolean getCustomer() {
        return this.customer;
    }

    public void setCustomer(Boolean customer) {
        this.customer = customer;
    }

    public Boolean getSupplier() {
        return this.supplier;
    }

    public void setSupplier(Boolean supplier) {
        this.supplier = supplier;
    }

    public String getOther() {
        return this.other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public Ubigeo getUbigeo() {
        return this.ubigeo;
    }

    public void setUbigeo(Ubigeo ubigeo) {
        this.ubigeo = ubigeo;
    }

    public Boolean getSynchronized_() {
        return this.synchronized_;
    }

    public void setSynchronized_(Boolean synchronized_) {
        this.synchronized_ = synchronized_;
    }

    /**
     * @return the uploaded
     */
    public Boolean getUploaded() {
        return uploaded;
    }

    /**
     * @param uploaded the uploaded to set
     */
    public void setUploaded(Boolean uploaded) {
        this.uploaded = uploaded;
    }
}
