package domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author laki
 */
@Entity
@Table(name = "uloga")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Uloga.findByJmbg", query = "SELECT u FROM Uloga u WHERE u.jmbg = :jmbg"),
    @NamedQuery(name = "Uloga.findByAvionID", query = "SELECT u FROM Uloga u WHERE u.avionID = :avionID")})
public class Uloga implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 20)
    @Column(name = "nazivUloge")
    private String nazivUloge;
    @JoinColumn(name = "JMBG", referencedColumnName = "JMBG", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Pilot pilot;
    @JoinColumn(name = "avionID", referencedColumnName = "avionID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Avion avion;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 13)
    @Column(name = "JMBG")
    private String jmbg;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "avionID")
    private long avionID;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "datum")
    @Temporal(TemporalType.DATE)
    private Date datum;

    public Uloga() {
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public long getAvionID() {
        return avionID;
    }

    public void setAvionID(long avionID) {
        this.avionID = avionID;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
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
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Uloga)) {
            return false;
        }
        Uloga other = (Uloga) object;
        return other.getJmbg().equals(this.getJmbg());
    }

    @Override
    public String toString() {
        return "domain.Uloga[ ulogaPK=" + jmbg + " ]";
    }

}
