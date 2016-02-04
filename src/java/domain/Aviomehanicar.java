package domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author laki
 */
@Entity
@Table(name = "aviomehanicar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aviomehanicar.findAll", query = "SELECT a FROM Aviomehanicar a"),
    @NamedQuery(name = "Aviomehanicar.findByJmbg", query = "SELECT a FROM Aviomehanicar a WHERE a.jmbg = :jmbg")})
public class Aviomehanicar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 13)
    @Column(name = "JMBG")
    private String jmbg;
    @Size(max = 20)
    @Column(name = "tipMehanicara")
    private String tipMehanicara;
    @JoinColumn(name = "JMBG", referencedColumnName = "JMBG", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Zaposleni zaposleni;

    public Aviomehanicar() {
    }

    public Aviomehanicar(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getTipMehanicara() {
        return tipMehanicara;
    }

    public void setTipMehanicara(String tipMehanicara) {
        this.tipMehanicara = tipMehanicara;
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
        if (!(object instanceof Aviomehanicar)) {
            return false;
        }
        Aviomehanicar other = (Aviomehanicar) object;
        if ((this.jmbg == null && other.jmbg != null) || (this.jmbg != null && !this.jmbg.equals(other.jmbg))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Aviomehanicar[ jmbg=" + jmbg + " ]";
    }

}
