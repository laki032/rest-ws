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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author laki
 */
@Entity
@Table(name = "licenca")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Licenca.findAll", query = "SELECT l FROM Licenca l"),
    @NamedQuery(name = "Licenca.findByJmbg", query = "SELECT l FROM Licenca l WHERE l.licencaPK.jmbg = :jmbg"),
    @NamedQuery(name = "Licenca.findByTipID", query = "SELECT l FROM Licenca l WHERE l.licencaPK.tipID = :tipID"),
    @NamedQuery(name = "Licenca.findByDatumDobijanja", query = "SELECT l FROM Licenca l WHERE l.datumDobijanja = :datumDobijanja")})
public class Licenca implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LicencaPK licencaPK;
    @Column(name = "datumDobijanja")
    @Temporal(TemporalType.DATE)
    private Date datumDobijanja;
    @JoinColumn(name = "JMBG", referencedColumnName = "JMBG", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Aviomehanicar aviomehanicar;
    @JoinColumn(name = "tipID", referencedColumnName = "tipID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Tipaviona tipaviona;

    public Licenca() {
    }

    public Licenca(LicencaPK licencaPK) {
        this.licencaPK = licencaPK;
    }

    public Licenca(String jmbg, long tipID) {
        this.licencaPK = new LicencaPK(jmbg, tipID);
    }

    public LicencaPK getLicencaPK() {
        return licencaPK;
    }

    public void setLicencaPK(LicencaPK licencaPK) {
        this.licencaPK = licencaPK;
    }

    public Date getDatumDobijanja() {
        return datumDobijanja;
    }

    public void setDatumDobijanja(Date datumDobijanja) {
        this.datumDobijanja = datumDobijanja;
    }

    public Aviomehanicar getAviomehanicar() {
        return aviomehanicar;
    }

    public void setAviomehanicar(Aviomehanicar aviomehanicar) {
        this.aviomehanicar = aviomehanicar;
    }

    public Tipaviona getTipaviona() {
        return tipaviona;
    }

    public void setTipaviona(Tipaviona tipaviona) {
        this.tipaviona = tipaviona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (licencaPK != null ? licencaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Licenca)) {
            return false;
        }
        Licenca other = (Licenca) object;
        if ((this.licencaPK == null && other.licencaPK != null) || (this.licencaPK != null && !this.licencaPK.equals(other.licencaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Licenca[ licencaPK=" + licencaPK + " ]";
    }

}
