package cs.bms.model;

import gkfire.auditory.AuditoryEntity;
import gkfire.model.interfac.EntityActivate;
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
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "payment_proof", catalog = "public")
@XmlRootElement
public class PaymentProof
        implements Serializable, AuditoryEntity<Short, User>, EntityActivate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Short id;
    @Column(name = "code", nullable = false)
    @Size(max = 2)
    @Digits(fraction = 0, integer = 2)
    private String code;
    @Column(name = "abbr", nullable = false)
    @Size(max = 10)
    private String abbr;
    @Column(name = "name", nullable = false)
    @Size(max = 380)
    private String name;
    @Column(name = "for_sale", nullable = false)
    private Boolean forSale = Boolean.FALSE;
    @Column(name = "for_purchase", nullable = false)
    private Boolean forPurchase = Boolean.FALSE;
    @Column(name = "for_stored", nullable = false)
    private Boolean forStored = Boolean.FALSE;
    @Column(name = "for_return", nullable = false)
    private Boolean forReturn = Boolean.FALSE;

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

    public PaymentProof(Short id) {
        this.id = id;
    }

    public PaymentProof() {
    }

    public Short getId() {
        return this.id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getAbbr() {
        return this.abbr;
    }

    public void setAbbr(String abbr) {
        this.abbr = abbr;
    }

    public Boolean getForSale() {
        return this.forSale;
    }

    public void setForSale(Boolean forSale) {
        this.forSale = forSale;
    }

    public Boolean getForPurchase() {
        return this.forPurchase;
    }

    public void setForPurchase(Boolean forPurchase) {
        this.forPurchase = forPurchase;
    }

    public Boolean getForStored() {
        return this.forStored;
    }

    public void setForStored(Boolean forStored) {
        this.forStored = forStored;
    }

    public Boolean getForReturn() {
        return this.forReturn;
    }

    public void setForReturn(Boolean forReturn) {
        this.forReturn = forReturn;
    }
}
