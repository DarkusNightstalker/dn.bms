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
@Table(name = "purchase_detail", catalog = "public")
@XmlRootElement
public class PurchaseDetail
        implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    protected Long id;
    @JoinColumn(name = "id_purchase", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    protected Purchase purchase;
    @JoinColumn(name = "id_product", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    protected Product product;
    @JoinColumn(name = "id_uom", nullable = false)
    @ManyToOne
    protected UoM uom;
    @Column(name = "product_name", nullable = false)
    protected String productName;
    @Column(name = "quantity", nullable = false)
    protected BigDecimal quantity;
    @Column(name = "unit_price", nullable = false)
    protected BigDecimal unitPrice;
    @Column(name = "subtotal", nullable = false)
    protected BigDecimal subtotal = BigDecimal.ZERO;
    @Column(name = "igv", nullable = false)
    protected BigDecimal igv = BigDecimal.ZERO;

    public Purchase getPurchase() {
        return this.purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
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

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
