package domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
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
@Table(name = "licenca")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Licenca.findByJmbg", query = "SELECT l FROM Licenca l WHERE l.jmbg = :jmbg"),
    @NamedQuery(name = "Licenca.findByTipID", query = "SELECT l FROM Licenca l WHERE l.tipID = :tipID")})
public class Licenca implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 13)
    @Column(name = "JMBG")
    private String jmbg;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipID")
    private long tipID;
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

    public Licenca(String jmbg, long tipID) {
        this.jmbg = jmbg;
        this.tipID = tipID;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public long getTipID() {
        return tipID;
    }

    public void setTipID(long tipID) {
        this.tipID = tipID;
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
        return hash;
    }

    @Override
    public String toString() {
        return "domain.Licenca[ licencaPK=" + tipID + " ]";
    }

}
