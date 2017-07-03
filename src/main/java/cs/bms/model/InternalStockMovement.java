package cs.bms.model;

import gkfire.auditory.AuditoryEntity;
import gkfire.model.interfac.EntityActivate;
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
@Table(name = "internal_stock_movement", catalog = "public")
@XmlRootElement
public class InternalStockMovement
        implements AuditoryEntity<Long, User>, EntityActivate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @JoinColumn(name = "id_payment_proof", nullable = false)
    @ManyToOne
    private PaymentProof paymentProof;
    @Column(name = "serie", nullable = false)
    private String serie;
    @Column(name = "document_number", nullable = false)
    private String documentNumber;
    @JoinColumn(name = "id_source_company", nullable = false)
    @ManyToOne
    private Company sourceCompany;
    @JoinColumn(name = "id_target_company", nullable = false)
    @ManyToOne
    private Company targetCompany;
    @JoinColumn(name = "id_carrier")
    @ManyToOne
    private Actor carrier;
    @Column(name = "date_shipping", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateShipping = new Date();
    @Column(name = "date_arrival")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateArrival = new Date();

    @Column(name = "date_real_arrival")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateRealArrival;

    @Column(name = "transport_description")
    private String transportDescription;

    @Column(name = "driver_license")
    private String driverLicense;

    @JoinColumn(name = "id_operation_type_source", nullable = true)
    @ManyToOne(fetch = FetchType.LAZY)
    private OperationType operationTypeSource;
    @JoinColumn(name = "id_operation_type_target", nullable = true)
    @ManyToOne(fetch = FetchType.LAZY)
    private OperationType operationTypeTarget;
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
    @Column(name = "electronic", nullable = false)
    private Boolean electronic = Boolean.TRUE;
    @Column(name = "sent", nullable = false)
    private Boolean sent = Boolean.FALSE;
    @Column(name = "uploaded", nullable = false)
    private Boolean uploaded = Boolean.TRUE;

    @Formula("(serie||'-'||document_number)")
    private String fullDocument;

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public PaymentProof getPaymentProof() {
        return this.paymentProof;
    }

    public void setPaymentProof(PaymentProof paymentProof) {
        this.paymentProof = paymentProof;
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

    public Company getSourceCompany() {
        return this.sourceCompany;
    }

    public void setSourceCompany(Company sourceCompany) {
        this.sourceCompany = sourceCompany;
    }

    public Company getTargetCompany() {
        return this.targetCompany;
    }

    public void setTargetCompany(Company targetCompany) {
        this.targetCompany = targetCompany;
    }

    public Actor getCarrier() {
        return this.carrier;
    }

    public void setCarrier(Actor carrier) {
        this.carrier = carrier;
    }

    public Date getDateShipping() {
        return this.dateShipping;
    }

    public void setDateShipping(Date dateShipping) {
        this.dateShipping = dateShipping;
    }

    public Date getDateArrival() {
        return this.dateArrival;
    }

    public void setDateArrival(Date dateArrival) {
        this.dateArrival = dateArrival;
    }

    public String getTransportDescription() {
        return this.transportDescription;
    }

    public void setTransportDescription(String transportDescription) {
        this.transportDescription = transportDescription;
    }

    public String getDriverLicense() {
        return this.driverLicense;
    }

    public void setDriverLicense(String driverLicense) {
        this.driverLicense = driverLicense;
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

    public String getFullDocument() {
        return this.fullDocument;
    }

    public void setFullDocument(String fullDocument) {
        this.fullDocument = fullDocument;
    }

    public Date getDateRealArrival() {
        return this.dateRealArrival;
    }

    public void setDateRealArrival(Date dateRealArrival) {
        this.dateRealArrival = dateRealArrival;
    }

    public Boolean getElectronic() {
        return this.electronic;
    }

    public void setElectronic(Boolean electronic) {
        this.electronic = electronic;
    }

    public Boolean getSent() {
        return this.sent;
    }

    public void setSent(Boolean sent) {
        this.sent = sent;
    }

    public OperationType getOperationTypeSource() {
        return this.operationTypeSource;
    }

    public void setOperationTypeSource(OperationType operationTypeSource) {
        this.operationTypeSource = operationTypeSource;
    }

    public OperationType getOperationTypeTarget() {
        return this.operationTypeTarget;
    }

    public void setOperationTypeTarget(OperationType operationTypeTarget) {
        this.operationTypeTarget = operationTypeTarget;
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
