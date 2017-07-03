package cs.bms.model;

import gkfire.auditory.AuditoryEntity;
import gkfire.model.interfac.EntityActivate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Darkus Nightmare
 */
@Entity
@Table(name = "user", catalog = "public")
@XmlRootElement
public class User implements AuditoryEntity<Integer, User>, EntityActivate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    protected Integer id;
    @Column(name = "password", nullable = false)
    protected String password;
    @Column(name = "username", nullable = false)
    protected String username;
    @Column(name = "last_login")
    @Temporal(TemporalType.TIMESTAMP)
    protected Date lastLogin;
    @Column(name = "is_superuser", nullable = false)
    protected Boolean superUser = Boolean.FALSE;

    @JoinColumn(name = "id_employee", nullable = true)
    @ManyToOne
    protected Actor employee;

    @JoinColumn(name = "create_uid", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    protected User createUser;

    @Column(name = "create_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    protected Date createDate;
    @JoinColumn(name = "edit_uid")
    @ManyToOne(fetch = FetchType.LAZY)
    protected User editUser;
    @Column(name = "edit_date")
    @Temporal(TemporalType.TIMESTAMP)
    protected Date editDate;
    @Column(name = "active", nullable = false)
    protected Boolean active = Boolean.TRUE;
    @ManyToMany
    @JoinTable(name = "rol_has_user", joinColumns = {
        @JoinColumn(name = "id_user", nullable = false, updatable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "id_rol", nullable = false, updatable = false)})
    protected List<Rol> rols = new ArrayList(0);

    @ManyToMany
    @JoinTable(name = "dn_has_user", joinColumns = {
        @JoinColumn(name = "id_user", nullable = false, updatable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "id_document_numbering", nullable = false, updatable = false)})
    protected List<DocumentNumbering> documentNumberings = new ArrayList(0);

    @ManyToMany
    @JoinTable(name = "special_p_has_user", joinColumns = {
        @JoinColumn(name = "id_user", nullable = false, updatable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "id_special_permission", nullable = false, updatable = false)})
    protected List<SpecialPermission> specialPermissions = new ArrayList(0);

    public User() {
    }

    public User(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getLastLogin() {
        return this.lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Boolean getSuperUser() {
        return this.superUser;
    }

    public void setSuperUser(Boolean superUser) {
        this.superUser = superUser;
    }

    public User getCreateUser() {
        return this.createUser;
    }

    public void setCreateUser(User createUser) {
        this.createUser = createUser;
    }

    public Date getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public User getEditUser() {
        return this.editUser;
    }

    public void setEditUser(User editUser) {
        this.editUser = editUser;
    }

    public Date getEditDate() {
        return this.editDate;
    }

    public void setEditDate(Date editDate) {
        this.editDate = editDate;
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

    public Actor getEmployee() {
        return this.employee;
    }

    public void setEmployee(Actor employee) {
        this.employee = employee;
    }

    public List<SpecialPermission> getSpecialPermissions() {
        return this.specialPermissions;
    }

    public void setSpecialPermissions(List<SpecialPermission> specialPermissions) {
        this.specialPermissions = specialPermissions;
    }

    public List<DocumentNumbering> getDocumentNumberings() {
        return this.documentNumberings;
    }

    public void setDocumentNumberings(List<DocumentNumbering> documentNumberings) {
        this.documentNumberings = documentNumberings;
    }
}
