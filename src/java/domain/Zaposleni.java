package domain;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author laki
 */
@Entity
@Table(name = "zaposleni")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Zaposleni.findAll", query = "SELECT z FROM Zaposleni z"),
    @NamedQuery(name = "Zaposleni.findByJmbg", query = "SELECT z FROM Zaposleni z WHERE z.jmbg = :jmbg")})
public class Zaposleni implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 13)
    @Column(name = "JMBG")
    private String jmbg;
    @Size(max = 40)
    @Column(name = "imePrezime")
    private String imePrezime;
    @Column(name = "godinaRodjenja")
    private BigInteger godinaRodjenja;

    @Transient
    private Pilot pilot;
    @Transient
    private Aviomehanicar mehanicar;

    public Zaposleni() {
    }

    public Zaposleni(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getImePrezime() {
        return imePrezime;
    }

    public void setImePrezime(String imePrezime) {
        this.imePrezime = imePrezime;
    }

    public BigInteger getGodinaRodjenja() {
        return godinaRodjenja;
    }

    public void setGodinaRodjenja(BigInteger godinaRodjenja) {
        this.godinaRodjenja = godinaRodjenja;
    }

    public Pilot getPilot() {
        return pilot;
    }

    public void setPilot(Pilot pilot) {
        this.pilot = pilot;
    }

    public Aviomehanicar getMehanicar() {
        return mehanicar;
    }

    public void setMehanicar(Aviomehanicar mehanicar) {
        this.mehanicar = mehanicar;
    }

    @Override
    public int hashCode() {
        return jmbg != null ? jmbg.hashCode() : 0;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Zaposleni)) {
            return false;
        }
        Zaposleni other = (Zaposleni) object;
        if ((this.jmbg == null && other.jmbg != null) || (this.jmbg != null && !this.jmbg.equals(other.jmbg))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Zaposleni[ jmbg=" + jmbg + " ]";
    }

}
