package cs.bms.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "data_company", catalog = "public")
@XmlRootElement
public class DataCompany
        implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "property_name", nullable = false)
    private String propertyName;
    @Column(name = "value_", nullable = false)
    private byte[] value_;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the propertyName
     */
    public String getPropertyName() {
        return propertyName;
    }

    /**
     * @param propertyName the propertyName to set
     */
    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    /**
     * @return the value_
     */
    public byte[] getValue_() {
        return value_;
    }

    /**
     * @param value_ the value_ to set
     */
    public void setValue_(byte[] value_) {
        this.value_ = value_;
    }

}
