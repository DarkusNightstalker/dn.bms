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
@Table(name = "purchase", catalog = "public")
@XmlRootElement
public class Purchase
        implements AuditoryEntity<Long, User>, EntityActivate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "serie", nullable = false)
    private String serie;
    @Column(name = "document_number", nullable = false)
    private String documentNumber;
    @JoinColumn(name = "id_payment_proof", nullable = false)
    @ManyToOne
    private PaymentProof paymentProof;
    @Column(name = "electronic", nullable = false)
    private Boolean electronic = Boolean.FALSE;
    @JoinColumn(name = "id_supplier", nullable = false)
    @ManyToOne
    private Actor supplier;
    @Column(name = "supplier_name", nullable = false)
    private String supplierName;
    @Column(name = "subtotal", nullable = false)
    private BigDecimal subtotal = BigDecimal.ZERO;
    @Column(name = "igv", nullable = false)
    private BigDecimal igv = BigDecimal.ZERO;
    @Column(name = "subtotal_discount", nullable = false)
    private BigDecimal subtotalDiscount = BigDecimal.ZERO;
    @Column(name = "igv_discount", nullable = false)
    private BigDecimal igvDiscount = BigDecimal.ZERO;

    @JoinColumn(name = "id_company_arrival", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Company companyArrival;

    @Column(name = "date_issue", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateIssue;
    @Column(name = "date_due", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDue;

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

    @Formula("(subtotal + igv - subtotal_discount)")
    private BigDecimal total;

    @Formula("(serie||'-'||document_number)")
    private String fullDocument;

    public Purchase() {
    }

    public Purchase(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

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

    public Actor getSupplier() {
        return this.supplier;
    }

    public void setSupplier(Actor supplier) {
        this.supplier = supplier;
    }

    public String getSupplierName() {
        return this.supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
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

    public Company getCompanyArrival() {
        return this.companyArrival;
    }

    public void setCompanyArrival(Company companyArrival) {
        this.companyArrival = companyArrival;
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

    public Date getDateIssue() {
        return this.dateIssue;
    }

    public void setDateIssue(Date dateIssue) {
        this.dateIssue = dateIssue;
    }

    /**
     * @return the dateDue
     */
    public Date getDateDue() {
        return dateDue;
    }

    /**
     * @param dateDue the dateDue to set
     */
    public void setDateDue(Date dateDue) {
        this.dateDue = dateDue;
    }
}
