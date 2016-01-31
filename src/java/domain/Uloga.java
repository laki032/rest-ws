package domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author laki
 */
@Entity
@Table(name = "uloga")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Uloga.findAll", query = "SELECT u FROM Uloga u"),
    @NamedQuery(name = "Uloga.findByJmbg", query = "SELECT u FROM Uloga u WHERE u.ulogaPK.jmbg = :jmbg"),
    @NamedQuery(name = "Uloga.findByAvionID", query = "SELECT u FROM Uloga u WHERE u.ulogaPK.avionID = :avionID"),
    @NamedQuery(name = "Uloga.findByNazivUloge", query = "SELECT u FROM Uloga u WHERE u.nazivUloge = :nazivUloge"),
    @NamedQuery(name = "Uloga.findByDatum", query = "SELECT u FROM Uloga u WHERE u.ulogaPK.datum = :datum")})
public class Uloga implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UlogaPK ulogaPK;
    @Size(max = 20)
    @Column(name = "nazivUloge")
    private String nazivUloge;
    @JoinColumn(name = "JMBG", referencedColumnName = "JMBG", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Pilot pilot;
    @JoinColumn(name = "avionID", referencedColumnName = "avionID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Avion avion;

    public Uloga() {
    }

    public Uloga(UlogaPK ulogaPK) {
        this.ulogaPK = ulogaPK;
    }

    public Uloga(String jmbg, long avionID, Date datum) {
        this.ulogaPK = new UlogaPK(jmbg, avionID, datum);
    }

    public UlogaPK getUlogaPK() {
        return ulogaPK;
    }

    public void setUlogaPK(UlogaPK ulogaPK) {
        this.ulogaPK = ulogaPK;
    }

    public String getNazivUloge() {
        return nazivUloge;
    }

    public void setNazivUloge(String nazivUloge) {
        this.nazivUloge = nazivUloge;
    }

    public Pilot getPilot() {
        return pilot;
    }

    public void setPilot(Pilot pilot) {
        this.pilot = pilot;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ulogaPK != null ? ulogaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Uloga)) {
            return false;
        }
        Uloga other = (Uloga) object;
        if ((this.ulogaPK == null && other.ulogaPK != null) || (this.ulogaPK != null && !this.ulogaPK.equals(other.ulogaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Uloga[ ulogaPK=" + ulogaPK + " ]";
    }

}
