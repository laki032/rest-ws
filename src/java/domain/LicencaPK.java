package domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author laki
 */
@Embeddable
public class LicencaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 13)
    @Column(name = "JMBG")
    private String jmbg;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipID")
    private long tipID;

    public LicencaPK() {
    }

    public LicencaPK(String jmbg, long tipID) {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (jmbg != null ? jmbg.hashCode() : 0);
        hash += (int) tipID;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LicencaPK)) {
            return false;
        }
        LicencaPK other = (LicencaPK) object;
        if ((this.jmbg == null && other.jmbg != null) || (this.jmbg != null && !this.jmbg.equals(other.jmbg))) {
            return false;
        }
        if (this.tipID != other.tipID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.LicencaPK[ jmbg=" + jmbg + ", tipID=" + tipID + " ]";
    }

}
