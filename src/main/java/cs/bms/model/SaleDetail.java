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
@Table(name = "sale_detail", catalog = "public")
@XmlRootElement
public class SaleDetail implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @JoinColumn(name = "id_sale", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Sale sale;
    @JoinColumn(name = "id_product", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;
    @JoinColumn(name = "id_uom", nullable = false)
    @ManyToOne
    private UoM uom;
    @Column(name = "subtotal", nullable = false)
    private BigDecimal subtotal = BigDecimal.ZERO;
    @Column(name = "product_name", nullable = false)
    private String productName;
    @Column(name = "quantity", nullable = false)
    private BigDecimal quantity;
    @Column(name = "unit_price", nullable = false)
    private BigDecimal unitPrice;
    @Column(name = "unit_cost", nullable = false)
    private BigDecimal unitCost = BigDecimal.ZERO;

    @Column(name = "points_price", nullable = false)
    private BigDecimal pointsPrice;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Sale getSale() {
        return this.sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
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

    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getQuantity() {
        return this.quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitPrice() {
        return this.unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getSubtotal() {
        return this.subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public BigDecimal getPointsPrice() {
        return this.pointsPrice;
    }

    public void setPointsPrice(BigDecimal pointsPrice) {
        this.pointsPrice = pointsPrice;
    }

    public BigDecimal getUnitCost() {
        return this.unitCost;
    }

    public void setUnitCost(BigDecimal unitCost) {
        this.unitCost = unitCost;
    }
}
