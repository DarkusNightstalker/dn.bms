package cs.bms.model;

import java.io.Serializable;
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
import javax.validation.constraints.Digits;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "product_sale_price", catalog = "public")
@XmlRootElement
public class ProductSalePrice
        implements Serializable {

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
    @Column(name = "quantity", nullable = false)
    protected Integer quantity;
    @Column(name = "price", nullable = false)
    @Digits(integer = 4, fraction = 2)
    protected BigDecimal price;
    @JoinColumn(name = "create_uid", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    protected User createUser;
    @Column(name = "create_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    protected Date createDate;

    public ProductSalePrice(Long id) {
        this.id = id;
    }

    public ProductSalePrice() {
    }

    public ProductSalePrice(Product product, Company company, Integer quantity, BigDecimal price) {
        this.product = product;
        this.company = company;
        this.quantity = quantity;
        this.price = price;
    }

    public Long getId() {
        return this.id;
    }

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

    public Integer getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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
}
