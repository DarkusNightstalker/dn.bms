package cs.bms.model;

import gkfire.model.interfac.EntityActivate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "permission", catalog = "public")
@XmlRootElement
public class Permission
        implements Serializable, EntityActivate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "code", nullable = false, length = 6)
    private String code;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "limited", nullable = false)
    private Boolean limited = Boolean.FALSE;


    @JoinColumn(name = "id_permission_category", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private PermissionCategory permissionCategory;


    @Column(name = "active", nullable = false)
    private Boolean active = Boolean.TRUE;
    @ManyToMany
    @JoinTable(name = "permission_has_rol", joinColumns = {@JoinColumn(name = "id_permission", nullable = false, updatable = false)}, inverseJoinColumns = {@JoinColumn(name = "id_rol", nullable = false, updatable = false)})
    private List<Rol> rols = new ArrayList(0);

    public Permission() {
    }

    public Permission(Integer id) {
        this.id = id;
    }


    public Integer getId() {
        return this.id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public String getCode() {
        return this.code;
    }


    public void setCode(String code) {
        this.code = code;
    }


    public String getName() {
        return this.name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public Boolean getLimited() {
        return this.limited;
    }


    public void setLimited(Boolean limited) {
        this.limited = limited;
    }


    public Boolean getActive() {
        return this.active;
    }


    public void setActive(Boolean active) {
        this.active = active;
    }


    public List<Rol> getRols() {
        return this.rols;
    }


    public void setRols(List<Rol> rols) {
        this.rols = rols;
    }


    public PermissionCategory getPermissionCategory() {
        return this.permissionCategory;
    }


    public void setPermissionCategory(PermissionCategory permissionCategory) {
        this.permissionCategory = permissionCategory;
    }

    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.id);
        return hash;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Permission other = (Permission) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}

