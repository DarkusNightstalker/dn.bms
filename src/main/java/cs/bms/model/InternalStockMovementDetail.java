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
import javax.validation.constraints.Digits;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "ism_detail", catalog = "public")
@XmlRootElement
public class InternalStockMovementDetail implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @JoinColumn(name = "id_ism", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private InternalStockMovement internalStockMovement;
    @JoinColumn(name = "id_product", nullable = false)
    @ManyToOne
    private Product product;
    @JoinColumn(name = "id_uom", nullable = false)
    @ManyToOne
    private UoM uom;
    @Column(name = "quantity", nullable = false)
    @Digits(integer = 12, fraction = 2)
    private BigDecimal quantity = BigDecimal.ZERO;
    @Column(name = "product_name", nullable = false)
    private String productName;
    @Column(name = "weight", nullable = true)
    @Digits(integer = 10, fraction = 3)
    private BigDecimal weight = BigDecimal.ZERO;

    @JoinColumn(name = "id_weight_uom", nullable = true)
    @ManyToOne
    private UoM weightUoM;

    @Column(name = "unit_cost", nullable = false)
    private BigDecimal unitCost;

    public InternalStockMovementDetail() {
    }

    public InternalStockMovementDetail(Long id) {
        this.id = id;
    }

    
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public InternalStockMovement getInternalStockMovement() {
        return this.internalStockMovement;
    }

    public void setInternalStockMovement(InternalStockMovement internalStockMovement) {
        this.internalStockMovement = internalStockMovement;
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

    public BigDecimal getQuantity() {
        return this.quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getWeight() {
        return this.weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public UoM getWeightUoM() {
        return this.weightUoM;
    }

    public void setWeightUoM(UoM weightUoM) {
        this.weightUoM = weightUoM;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getUnitCost() {
        return this.unitCost;
    }

    public void setUnitCost(BigDecimal unitCost) {
        this.unitCost = unitCost;
    }
}
