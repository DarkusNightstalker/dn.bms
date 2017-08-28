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
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "purchase_payment", catalog = "public")
@XmlRootElement
public class PurchasePayment
        implements AuditoryEntity<Long, User>, EntityActivate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    protected Long id;
    @JoinColumn(name = "id_purchase", nullable = true)
    @ManyToOne(fetch = FetchType.LAZY)
    protected Purchase purchase;
    @Column(name = "date_payment", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    protected Date datePayment;
    @Column(name = "quantity", nullable = false)
    protected BigDecimal quantity;
    @Column(name = "description", nullable = false)
    protected String description;
    @JoinColumn(name = "id_company_disbursement", nullable = true)
    @ManyToOne(fetch = FetchType.LAZY)
    protected Company companyDisbursement;
    @JoinColumn(name = "create_uid", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    protected User createUser;
    @Column(name = "create_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    protected Date createDate;
    @JoinColumn(name = "edit_uid", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    protected User editUser;
    @Column(name = "edit_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    protected Date editDate;
    @Column(name = "active", nullable = false)
    protected Boolean active = Boolean.TRUE;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Purchase getPurchase() {
        return this.purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }

    public Date getDatePayment() {
        return this.datePayment;
    }

    public void setDatePayment(Date datePayment) {
        this.datePayment = datePayment;
    }

    public BigDecimal getQuantity() {
        return this.quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
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

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Company getCompanyDisbursement() {
        return this.companyDisbursement;
    }

    public void setCompanyDisbursement(Company companyDisbursement) {
        this.companyDisbursement = companyDisbursement;
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

    public boolean isActive() {
        return this.active.booleanValue();
    }

    public Boolean getActive() {
        return this.active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
