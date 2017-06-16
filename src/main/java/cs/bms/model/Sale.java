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
import org.hibernate.annotations.Formula;

@Entity
@Table(name = "sale", catalog = "public")
@XmlRootElement
public class Sale implements AuditoryEntity<Long, User>, EntityActivate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    protected Long id;
    @Column(name = "serie", nullable = false)
    protected String serie;
    @Column(name = "document_number", nullable = false)
    protected String documentNumber;
    @JoinColumn(name = "id_payment_proof", nullable = false)
    @ManyToOne
    protected PaymentProof paymentProof;
    @Column(name = "electronic", nullable = false)
    protected Boolean electronic = Boolean.FALSE;
    @Column(name = "sent", nullable = false)
    protected Boolean sent = Boolean.FALSE;
    @Column(name = "verified", nullable = false)
    protected Boolean verified = Boolean.FALSE;

    @JoinColumn(name = "id_customer", nullable = true)
    @ManyToOne
    protected Actor customer;
    @Column(name = "customer_name")
    protected String customerName;
    @Column(name = "points")
    protected Long points = 0L;
    @Column(name = "subtotal", nullable = false)
    protected BigDecimal subtotal = BigDecimal.ZERO;
    @Column(name = "igv", nullable = false)
    protected BigDecimal igv = BigDecimal.ZERO;
    @Column(name = "subtotal_discount", nullable = false)
    protected BigDecimal subtotalDiscount = BigDecimal.ZERO;
    @Column(name = "igv_discount", nullable = false)
    protected BigDecimal igvDiscount = BigDecimal.ZERO;

    @JoinColumn(name = "id_company", nullable = false)
    @ManyToOne
    protected Company company;

    @Column(name = "date_issue", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    protected Date dateIssue;

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
    @Formula("(subtotal + igv - subtotal_discount)")
    protected BigDecimal total;
    @Formula("(serie||'-'||document_number)")
    protected String fullDocument;

    public Sale(Long id) {
        this.id = id;
    }

    public Sale() {
    }

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getSerie() {
        return this.serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getDocumentNumber() {
        return this.documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public PaymentProof getPaymentProof() {
        return this.paymentProof;
    }

    public void setPaymentProof(PaymentProof paymentProof) {
        this.paymentProof = paymentProof;
    }

    public Boolean getElectronic() {
        return this.electronic;
    }

    public void setElectronic(Boolean electronic) {
        this.electronic = electronic;
    }

    public Actor getCustomer() {
        return this.customer;
    }

    public void setCustomer(Actor customer) {
        this.customer = customer;
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public BigDecimal getSubtotal() {
        return this.subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public BigDecimal getIgv() {
        return this.igv;
    }

    public void setIgv(BigDecimal igv) {
        this.igv = igv;
    }

    public BigDecimal getSubtotalDiscount() {
        return this.subtotalDiscount;
    }

    public void setSubtotalDiscount(BigDecimal subtotalDiscount) {
        this.subtotalDiscount = subtotalDiscount;
    }

    public BigDecimal getIgvDiscount() {
        return this.igvDiscount;
    }

    public void setIgvDiscount(BigDecimal igvDiscount) {
        this.igvDiscount = igvDiscount;
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

    @Override
    public void setEditUser(User editUser) {
        this.editUser = editUser;
    }

    @Override
    public Date getEditDate() {
        return this.editDate;
    }

    @Override
    public void setEditDate(Date editDate) {
        this.editDate = editDate;
    }

    @Override
    public Boolean getActive() {
        return this.active;
    }

    @Override
    public void setActive(Boolean active) {
        this.active = active;
    }

    public Company getCompany() {
        return this.company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Date getDateIssue() {
        return this.dateIssue;
    }

    public void setDateIssue(Date dateIssue) {
        this.dateIssue = dateIssue;
    }

    public Long getPoints() {
        return this.points;
    }

    public void setPoints(Long points) {
        this.points = points;
    }

    public BigDecimal getTotal() {
        return this.total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getFullDocument() {
        return this.fullDocument;
    }

    public void setFullDocument(String fullDocument) {
        this.fullDocument = fullDocument;
    }

    public Boolean getSent() {
        return this.sent;
    }

    public void setSent(Boolean sent) {
        this.sent = sent;
    }

    public Boolean getVerified() {
        return this.verified;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }
}
