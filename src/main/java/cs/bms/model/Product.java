package cs.bms.model;

import gkfire.auditory.AuditoryEntity;
import gkfire.model.interfac.EntityActivate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "product", catalog = "public")
@XmlRootElement
public class Product
        implements AuditoryEntity<Long, User>, EntityActivate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    protected Long id;
    @Column(name = "barcode", nullable = true)
    protected String barcode;
    @Column(name = "name", nullable = false)
    protected String name;
    @Column(name = "description", nullable = true)
    protected String description;
    @Column(name = "image", nullable = true)
    protected String image;
    @JoinColumn(name = "id_uom", nullable = false)
    @ManyToOne
    protected UoM uom;
    @JoinColumn(name = "id_stock_type", nullable = false)
    @ManyToOne
    protected StockType stockType;
    @JoinColumn(name = "id_product_line", nullable = true)
    @ManyToOne
    protected ProductLine productLine;
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
    @ManyToMany
    @JoinTable(name = "product_has_supplier",
            joinColumns = {
                @JoinColumn(name = "id_product", nullable = false, updatable = false)
            },
            inverseJoinColumns = {
                @JoinColumn(name = "id_supplier", nullable = false, updatable = false)
            }
    )
    protected List<Actor> suppliers = new ArrayList(0);

    @ManyToMany
    @JoinTable(name = "product_has_seller",
            joinColumns = {
                @JoinColumn(name = "id_product", nullable = false, updatable = false)
            },
            inverseJoinColumns = {
                @JoinColumn(name = "id_seller", nullable = false, updatable = false)
            }
    )
    protected List<Seller> sellers = new ArrayList(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    protected List<Kardex> kardexs = new ArrayList(0);

    public Product(Long id) {
        this.id = id;
    }

    public Product() {
    }

    @Override
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBarcode() {
        return this.barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ProductLine getProductLine() {
        return this.productLine;
    }

    public void setProductLine(ProductLine productLine) {
        this.productLine = productLine;
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

    public List<Actor> getSuppliers() {
        return this.suppliers;
    }

    public void setSuppliers(List<Actor> suppliers) {
        this.suppliers = suppliers;
    }

    public StockType getStockType() {
        return this.stockType;
    }

    public void setStockType(StockType stockType) {
        this.stockType = stockType;
    }

    public UoM getUom() {
        return this.uom;
    }

    public void setUom(UoM uom) {
        this.uom = uom;
    }

    public List<Seller> getSellers() {
        return this.sellers;
    }

    public void setSellers(List<Seller> sellers) {
        this.sellers = sellers;
    }

    public List<Kardex> getKardexs() {
        return this.kardexs;
    }

    public void setKardexs(List<Kardex> kardexs) {
        this.kardexs = kardexs;
    }
}
