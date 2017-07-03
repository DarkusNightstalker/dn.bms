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

@Entity
@Table(name = "company")
@XmlRootElement
public class BankAccount implements AuditoryEntity<Integer, User>,EntityActivate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "account_number", nullable = false)
    private String accountNumber;
    @Column(name = "cci", nullable = false)
    private String cci;

    @JoinColumn(name = "id_financial_entity", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private FinancialEntity financialEntity;

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

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the accountNumber
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * @param accountNumber the accountNumber to set
     */
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * @return the cci
     */
    public String getCci() {
        return cci;
    }

    /**
     * @param cci the cci to set
     */
    public void setCci(String cci) {
        this.cci = cci;
    }

    /**
     * @return the financialEntity
     */
    public FinancialEntity getFinancialEntity() {
        return financialEntity;
    }

    /**
     * @param financialEntity the financialEntity to set
     */
    public void setFinancialEntity(FinancialEntity financialEntity) {
        this.financialEntity = financialEntity;
    }

    /**
     * @return the createUser
     */
    public User getCreateUser() {
        return createUser;
    }

    /**
     * @param createUser the createUser to set
     */
    public void setCreateUser(User createUser) {
        this.createUser = createUser;
    }

    /**
     * @return the createDate
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * @param createDate the createDate to set
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * @return the editUser
     */
    public User getEditUser() {
        return editUser;
    }

    /**
     * @param editUser the editUser to set
     */
    public void setEditUser(User editUser) {
        this.editUser = editUser;
    }

    /**
     * @return the editDate
     */
    public Date getEditDate() {
        return editDate;
    }

    /**
     * @param editDate the editDate to set
     */
    public void setEditDate(Date editDate) {
        this.editDate = editDate;
    }

    /**
     * @return the active
     */
    public Boolean getActive() {
        return active;
    }

    /**
     * @param active the active to set
     */
    public void setActive(Boolean active) {
        this.active = active;
    }
    
    
}
