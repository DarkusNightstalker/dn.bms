package cs.bms.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "document_numbering", catalog = "public")
@XmlRootElement
public class DocumentNumbering  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    protected Integer id;
    @JoinColumn(name = "id_payment_proof", nullable = false)
    @ManyToOne
    protected PaymentProof paymentProof;
    @Column(name = "ruc_company", nullable = false)
    protected String rucCompany;
    @Column(name = "serie", nullable = false)
    protected String serie;
    @Column(name = "numbering", nullable = false)
    protected Long numbering = Long.valueOf(1L);
    @Column(name = "electronic", nullable = false)
    protected Boolean electronic = Boolean.FALSE;
    @ManyToMany
    @JoinTable(name = "dn_has_user", joinColumns = {@JoinColumn(name = "id_document_numbering", nullable = false, updatable = false)}, inverseJoinColumns = {@JoinColumn(name = "id_user", nullable = false, updatable = false)})
    protected List<User> users = new ArrayList(0);


    public DocumentNumbering() {
    }


    public DocumentNumbering(Integer id) {
        this.id = id;
    }


    public Integer getId() {
        return this.id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public PaymentProof getPaymentProof() {
        return this.paymentProof;
    }


    public void setPaymentProof(PaymentProof paymentProof) {
        this.paymentProof = paymentProof;
    }


    public String getSerie() {
        return this.serie;
    }


    public void setSerie(String serie) {
        this.serie = serie;
    }


    public Long getNumbering() {
        return this.numbering;
    }


    public void setNumbering(Long numbering) {
        this.numbering = numbering;
    }


    public Boolean getElectronic() {
        return this.electronic;
    }


    public void setElectronic(Boolean electronic) {
        this.electronic = electronic;
    }


    public String getRucCompany() {
        return this.rucCompany;
    }


    public void setRucCompany(String rucCompany) {
        this.rucCompany = rucCompany;
    }


    public List<User> getUsers() {
        return this.users;
    }


    public void setUsers(List<User> users) {
        this.users = users;
    }
}
