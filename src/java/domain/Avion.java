package domain;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "avion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Avion.findAll", query = "SELECT a FROM Avion a"),
    @NamedQuery(name = "Avion.findByAvionID", query = "SELECT a FROM Avion a WHERE a.avionID = :avionID"),
    @NamedQuery(name = "Avion.maxID", query = "SELECT MAX(a.avionID) FROM Avion a")})
public class Avion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "avionID")
    private Long avionID;
    @Size(max = 30)
    @Column(name = "oznaka")
    private String oznaka;
    @Column(name = "godProizvodnje")
    private BigInteger godProizvodnje;
    @Column(name = "brojPutnika")
    private BigInteger brojPutnika;
    @Column(name = "nosivost")
    private BigInteger nosivost;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "avion")
    private List<Uloga> ulogaList;
    @JoinColumn(name = "tipID", referencedColumnName = "tipID")
    @ManyToOne
    private Tipaviona tipID;

    public Avion() {
    }

    public Avion(Long avionID) {
        this.avionID = avionID;
    }

    public Long getAvionID() {
        return avionID;
    }

    public void setAvionID(Long avionID) {
        this.avionID = avionID;
    }

    public String getOznaka() {
        return oznaka;
    }

    public void setOznaka(String oznaka) {
        this.oznaka = oznaka;
    }

    public BigInteger getGodProizvodnje() {
        return godProizvodnje;
    }

    public void setGodProizvodnje(BigInteger godProizvodnje) {
        this.godProizvodnje = godProizvodnje;
    }

    public BigInteger getBrojPutnika() {
        return brojPutnika;
    }

    public void setBrojPutnika(BigInteger brojPutnika) {
        this.brojPutnika = brojPutnika;
    }

    public BigInteger getNosivost() {
        return nosivost;
    }

    public void setNosivost(BigInteger nosivost) {
        this.nosivost = nosivost;
    }

    @XmlTransient
    public List<Uloga> getUlogaList() {
        return ulogaList;
    }

    public void setUlogaList(List<Uloga> ulogaList) {
        this.ulogaList = ulogaList;
    }

    public Tipaviona getTipID() {
        return tipID;
    }

    public void setTipID(Tipaviona tipID) {
        this.tipID = tipID;
    }

    @Override
    public int hashCode() {
        return avionID != null ? avionID.hashCode() : 0;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Avion)) {
            return false;
        }
        Avion other = (Avion) object;
        return this.avionID == null || other.avionID == null || !this.avionID.equals(other.avionID);
    }

    @Override
    public String toString() {
        return "Avion[ ID=" + avionID + " ]";
    }

}
