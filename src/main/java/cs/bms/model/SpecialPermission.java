package cs.bms.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "special_permission", catalog = "public")
@XmlRootElement
public class SpecialPermission
        implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    protected Short id;
    @Column(name = "entity_name", nullable = false)
    protected String entityName;
    @Column(name = "identifier", nullable = false)
    protected Long identifier;
    @ManyToMany
    @JoinTable(name = "special_p_has_user", joinColumns = {@javax.persistence.JoinColumn(name = "id_special_permission", nullable = false, updatable = false)}, inverseJoinColumns = {@javax.persistence.JoinColumn(name = "id_user", nullable = false, updatable = false)})
    protected List<User> users = new ArrayList(0);


    public SpecialPermission() {
    }


    public SpecialPermission(Short id) {
        this.id = id;
    }


    public Short getId() {
        return this.id;
    }


    public void setId(Short id) {
        this.id = id;
    }


    public String getEntityName() {
        return this.entityName;
    }


    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }


    public Long getIdentifier() {
        return this.identifier;
    }


    public void setIdentifier(Long identifier) {
        this.identifier = identifier;
    }


    public List<User> getUsers() {
        return this.users;
    }


    public void setUsers(List<User> users) {
        this.users = users;
    }
}
