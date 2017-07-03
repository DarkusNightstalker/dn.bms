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
@Table(name = "stock_return_customer", catalog = "public")
@XmlRootElement
public class StockReturnCustomer
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
    
    
    @Column(name = "date_issue", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateIssue;
    @JoinColumn(name = "id_sale", nullable = true)
    @ManyToOne
    private Sale sale;
    @Column(name = "repayment", nullable = false)
    private BigDecimal repayment = BigDecimal.ZERO;

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
    @Column(name = "send", nullable = false)
    private Boolean send = Boolean.FALSE;

    @JoinColumn(name = "id_operation_type", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private OperationType operationType;

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

    public Date getDateIssue() {
        return this.dateIssue;
    }

    public void setDateIssue(Date dateIssue) {
        this.dateIssue = dateIssue;
    }

    public Sale getSale() {
        return this.sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    public BigDecimal getRepayment() {
        return this.repayment;
    }

    public void setRepayment(BigDecimal repayment) {
        this.repayment = repayment;
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

    public Boolean getSend() {
        return this.send;
    }

    public void setSend(Boolean send) {
        this.send = send;
    }

    public OperationType getOperationType() {
        return this.operationType;
    }

    public void setOperationType(OperationType operationType) {
        this.operationType = operationType;
    }

}
