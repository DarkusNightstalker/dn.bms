package cs.bms.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "srs_detail", catalog = "public")
@XmlRootElement
public class StockReturnSupplierDetail implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "product_name", nullable = false)
    private String productName;
    @JoinColumn(name = "id_product", nullable = false)
    @ManyToOne
    private Product product;
    @JoinColumn(name = "id_uom", nullable = false)
    @ManyToOne
    private UoM uom;
    @JoinColumn(name = "id_srs", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private StockReturnSupplier stockReturnSupplier;
    @Column(name = "quantity", nullable = false)
    private BigDecimal quantity = BigDecimal.ZERO;
    @Column(name = "unit_cost", nullable = false)
    private BigDecimal unitCost = BigDecimal.ZERO;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Product getProduct() {
        return this.product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public UoM getUom() {
        return this.uom;
    }

    public void setUom(UoM uom) {
        this.uom = uom;
    }

    public StockReturnSupplier getStockReturnSupplier() {
        return this.stockReturnSupplier;
    }

    public void setStockReturnSupplier(StockReturnSupplier stockReturnSupplier) {
        this.stockReturnSupplier = stockReturnSupplier;
    }

    public BigDecimal getQuantity() {
        return this.quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitCost() {
        return this.unitCost;
    }

    public void setUnitCost(BigDecimal unitCost) {
        this.unitCost = unitCost;
    }
}
