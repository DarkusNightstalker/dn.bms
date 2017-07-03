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
@Table(name = "product_cost_price", catalog = "public")
@XmlRootElement
public class ProductCostPrice implements AuditoryEntity<Long, User> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    protected Long id;
    @JoinColumn(name = "id_product", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    protected Product product;
    @JoinColumn(name = "id_company", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    protected Company company;
    @Column(name = "cost", nullable = false)
    protected BigDecimal cost;
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

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return this.product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Company getCompany() {
        return this.company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public BigDecimal getCost() {
        return this.cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
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
}
