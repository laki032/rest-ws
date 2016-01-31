package domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @author laki
 */
@Entity
@Table(name = "pilot")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pilot.findAll", query = "SELECT p FROM Pilot p"),
    @NamedQuery(name = "Pilot.findByJmbg", query = "SELECT p FROM Pilot p WHERE p.jmbg = :jmbg"),
    @NamedQuery(name = "Pilot.findByOcenaStanja", query = "SELECT p FROM Pilot p WHERE p.ocenaStanja = :ocenaStanja"),
    @NamedQuery(name = "Pilot.findByDatumPregleda", query = "SELECT p FROM Pilot p WHERE p.datumPregleda = :datumPregleda")})
public class Pilot implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 13)
    @Column(name = "JMBG")
    private String jmbg;
    @Column(name = "ocenaStanja")
    private Boolean ocenaStanja;
    @Column(name = "datumPregleda")
    @Temporal(TemporalType.DATE)
    private Date datumPregleda;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pilot")
    private List<Uloga> ulogaList;
    @JoinColumn(name = "JMBG", referencedColumnName = "JMBG", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Zaposleni zaposleni;

    public Pilot() {
    }

    public Pilot(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public Boolean getOcenaStanja() {
        return ocenaStanja;
    }

    public void setOcenaStanja(Boolean ocenaStanja) {
        this.ocenaStanja = ocenaStanja;
    }

    public Date getDatumPregleda() {
        return datumPregleda;
    }

    public void setDatumPregleda(Date datumPregleda) {
        this.datumPregleda = datumPregleda;
    }

    @XmlTransient
    public List<Uloga> getUlogaList() {
        return ulogaList;
    }

    public void setUlogaList(List<Uloga> ulogaList) {
        this.ulogaList = ulogaList;
    }

    public Zaposleni getZaposleni() {
        return zaposleni;
    }

    public void setZaposleni(Zaposleni zaposleni) {
        this.zaposleni = zaposleni;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (jmbg != null ? jmbg.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pilot)) {
            return false;
        }
        Pilot other = (Pilot) object;
        if ((this.jmbg == null && other.jmbg != null) || (this.jmbg != null && !this.jmbg.equals(other.jmbg))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Pilot[ jmbg=" + jmbg + " ]";
    }

}
