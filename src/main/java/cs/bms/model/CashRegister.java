package cs.bms.model;

import gkfire.auditory.AuditoryEntity;
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
@Table(name = "cash_register", catalog = "public")
@XmlRootElement
public class CashRegister implements AuditoryEntity<Long, User> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @JoinColumn(name = "id_company", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Company company;
    @JoinColumn(name = "id_work_shift", nullable = false)
    @ManyToOne
    private WorkShift workShift;
    @Column(name = "initial_cash", nullable = false)
    private BigDecimal initialCash = BigDecimal.ZERO;
    @Column(name = "expected_cash", nullable = false)
    private BigDecimal expectedCash = BigDecimal.ZERO;
    @Column(name = "credit", nullable = false)
    private BigDecimal credit = BigDecimal.ZERO;
    @Column(name = "visa", nullable = false)
    private BigDecimal visa = BigDecimal.ZERO;
    @Column(name = "\"out\"", nullable = false)
    private BigDecimal outs = BigDecimal.ZERO;
    @Column(name = "real_cash", nullable = false)
    private BigDecimal realCash = BigDecimal.ZERO;

    @Column(name = "payment_voucher_total", nullable = false)
    private Integer paymentVoucherTotal;

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
    @Column(name = "date_arcing")
    @Temporal(TemporalType.DATE)
    private Date dateArcing;

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Company getCompany() {
        return this.company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public WorkShift getWorkShift() {
        return this.workShift;
    }

    public void setWorkShift(WorkShift workShift) {
        this.workShift = workShift;
    }

    public BigDecimal getInitialCash() {
        return this.initialCash;
    }

    public void setInitialCash(BigDecimal initialCash) {
        this.initialCash = initialCash;
    }

    public BigDecimal getExpectedCash() {
        return this.expectedCash;
    }

    public void setExpectedCash(BigDecimal expectedCash) {
        this.expectedCash = expectedCash;
    }

    public BigDecimal getRealCash() {
        return this.realCash;
    }

    public void setRealCash(BigDecimal realCash) {
        this.realCash = realCash;
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

    public Date getDateArcing() {
        return this.dateArcing;
    }

    public void setDateArcing(Date dateArcing) {
        this.dateArcing = dateArcing;
    }

    public BigDecimal getCredit() {
        return this.credit;
    }

    public void setCredit(BigDecimal credit) {
        this.credit = credit;
    }

    public BigDecimal getVisa() {
        return this.visa;
    }

    public void setVisa(BigDecimal visa) {
        this.visa = visa;
    }

    public Integer getPaymentVoucherTotal() {
        return this.paymentVoucherTotal;
    }

    public void setPaymentVoucherTotal(Integer paymentVoucherTotal) {
        this.paymentVoucherTotal = paymentVoucherTotal;
    }

    /**
     * @return the out
     */
    public BigDecimal getOuts() {
        return outs;
    }

    /**
     * @param outs the out to set
     */
    public void setOuts(BigDecimal outs) {
        this.outs = outs;
    }
}
