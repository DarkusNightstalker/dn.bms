package cs.bms.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.Immutable;

@Entity
@Table(name = "ubigeo")
@Immutable
@XmlRootElement
public class Ubigeo
        implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    protected Integer id;
    @Column(name = "name", nullable = false)
    protected String name;

    public Ubigeo(Integer id) {
        this.id = id;
    }

    public Ubigeo() {
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
}
