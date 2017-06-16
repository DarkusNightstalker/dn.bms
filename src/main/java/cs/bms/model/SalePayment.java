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
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "sale_payment", catalog = "public")
@XmlRootElement
public class SalePayment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @JoinColumn(name = "id_sale", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Sale sale;
    @Column(name = "date_payment", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date datePayment;
    @Column(name = "quantity", nullable = false)
    private BigDecimal quantity;
    @Column(name = "visa", nullable = false)
    private Boolean visa = Boolean.FALSE;

    public SalePayment() {
    }

    public SalePayment(Sale sale, Date datePayment, BigDecimal quantity) {
        this.sale = sale;
        this.datePayment = datePayment;
        this.quantity = quantity;
    }

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

    public Date getDatePayment() {
        return this.datePayment;
    }

    public void setDatePayment(Date datePayment) {
        this.datePayment = datePayment;
    }

    public BigDecimal getQuantity() {
        return this.quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the visa
     */
    public Boolean getVisa() {
        return visa;
    }

    /**
     * @param visa the visa to set
     */
    public void setVisa(Boolean visa) {
        this.visa = visa;
    }
}
