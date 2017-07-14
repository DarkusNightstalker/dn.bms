package cs.bms.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "district", uniqueConstraints = {
    @javax.persistence.UniqueConstraint(columnNames = {"name", "id_subregion"})})
@XmlRootElement
public class District    implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "name", nullable = false)
    private String name;
    @JoinColumn(name = "id_subregion", nullable = true)
    @ManyToOne
    private Subregion subregion;

    public District() {
    }

    public District(Integer id) {
        this.id = id;
    }

    
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Subregion getSubregion() {
        return this.subregion;
    }

    public void setSubregion(Subregion subregion) {
        this.subregion = subregion;
    }
}
