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

/**
 * Representa una venta común realizada en el negocio
 * @version 1.0
 * @author Darkus Nightmare
 */
@Entity
@Table(name = "sale", catalog = "public")
@XmlRootElement
public class Sale implements AuditoryEntity<Long, User>, EntityActivate {

    /**
     *   Identificador único del registro
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    /**
     *  Serie del comprobante de pago emitido
     */
    @Column(name = "serie", nullable = false)
    private String serie;
    /**
     * Número correlativo con respecto a la serie del comprobante de pago
     */
    @Column(name = "document_number", nullable = false)
    private String documentNumber;
    /**
     * Tipo de comprobante de pago
     */
    @JoinColumn(name = "id_payment_proof", nullable = false)
    @ManyToOne
    private PaymentProof paymentProof;
    /**
     *  Muestra si la venta es con CPE
     */
    @Column(name = "electronic", nullable = false)
    private Boolean electronic = Boolean.FALSE;
    /**
     * Muestra si la venta fue enviada a la SUNAT
     */
    @Column(name = "sent", nullable = false)
    private Boolean sent = Boolean.FALSE;
    /**
     * Muestra si la venta fue verificada en caja
     */
    @Column(name = "verified", nullable = false)
    private Boolean verified = Boolean.FALSE;
    /**
     * Muestra si la venta fue hecha al crédito inicialmente
     */
    @Column(name = "credit", nullable = false)
    private Boolean credit = Boolean.FALSE;

    @JoinColumn(name = "id_customer", nullable = true)
    @ManyToOne
    private Actor customer;
    @Column(name = "customer_name")
    private String customerName;
    /**
     * Puntos generados por esta venta
     */
    @Column(name = "points")
    private Long points = 0L;
    /**
     * Puntos del cliente a la hora de hacer esta venta
     */
    @Column(name = "customer_points")
    private Long customerPoints;
    @Column(name = "spend_points")
    private Integer spendPoints;
    @Column(name = "subtotal", nullable = false)
    private BigDecimal subtotal = BigDecimal.ZERO;
    @Column(name = "igv", nullable = false)
    private BigDecimal igv = BigDecimal.ZERO;
    @Column(name = "subtotal_discount", nullable = false)
    private BigDecimal subtotalDiscount = BigDecimal.ZERO;
    @Column(name = "igv_discount", nullable = false)
    private BigDecimal igvDiscount = BigDecimal.ZERO;

    @JoinColumn(name = "id_company", nullable = false)
    @ManyToOne
    private Company company;

    @Column(name = "date_issue", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateIssue;
    @Column(name = "date_due", nullable = false)
    @Temporal(TemporalType.DATE)
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
    @Column(name = "upload_points")
    private Boolean uploadPoints;
    @Formula("(subtotal + igv - subtotal_discount)")
    private BigDecimal total;
    @Formula("(serie||'-'||document_number)")
    private String fullDocument;

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

    /**
     * 
     * @return la serie
     */
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

    /**
     * @return the credit
     */
    public Boolean getCredit() {
        return credit;
    }

    /**
     * @param credit the credit to set
     */
    public void setCredit(Boolean credit) {
        this.credit = credit;
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

    /**
     * @return the customerPoints
     */
    public Long getCustomerPoints() {
        return customerPoints;
    }

    /**
     * @param customerPoints the customerPoints to set
     */
    public void setCustomerPoints(Long customerPoints) {
        this.customerPoints = customerPoints;
    }

    /**
     * @return the spendPoints
     */
    public Integer getSpendPoints() {
        return spendPoints;
    }

    /**
     * @param spendPoints the spendPoints to set
     */
    public void setSpendPoints(Integer spendPoints) {
        this.spendPoints = spendPoints;
    }

    /**
     * @return the uploadPoints
     */
    public Boolean getUploadPoints() {
        return uploadPoints;
    }

    /**
     * @param uploadPoints the uploadPoints to set
     */
    public void setUploadPoints(Boolean uploadPoints) {
        this.uploadPoints = uploadPoints;
    }
}
