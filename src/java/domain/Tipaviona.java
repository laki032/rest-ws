package domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @author laki
 */
@Entity
@Table(name = "tipaviona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipaviona.findAll", query = "SELECT t FROM Tipaviona t"),
    @NamedQuery(name = "Tipaviona.findByTipID", query = "SELECT t FROM Tipaviona t WHERE t.tipID = :tipID"),
    @NamedQuery(name = "Tipaviona.findByNaziv", query = "SELECT t FROM Tipaviona t WHERE t.naziv = :naziv")})
public class Tipaviona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipID")
    private Long tipID;
    @Size(max = 100)
    @Column(name = "naziv")
    private String naziv;
    @OneToMany(mappedBy = "tipID")
    private List<Avion> avionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipaviona")
    private List<Licenca> licencaList;

    public Tipaviona() {
    }

    public Tipaviona(Long tipID) {
        this.tipID = tipID;
    }

    public Long getTipID() {
        return tipID;
    }

    public void setTipID(Long tipID) {
        this.tipID = tipID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @XmlTransient
    public List<Avion> getAvionList() {
        return avionList;
    }

    public void setAvionList(List<Avion> avionList) {
        this.avionList = avionList;
    }

    @XmlTransient
    public List<Licenca> getLicencaList() {
        return licencaList;
    }

    public void setLicencaList(List<Licenca> licencaList) {
        this.licencaList = licencaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipID != null ? tipID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipaviona)) {
            return false;
        }
        Tipaviona other = (Tipaviona) object;
        if ((this.tipID == null && other.tipID != null) || (this.tipID != null && !this.tipID.equals(other.tipID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Tipaviona[ tipID=" + tipID + " ]";
    }

}
