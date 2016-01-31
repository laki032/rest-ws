package domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author laki
 */
@Embeddable
public class UlogaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 13)
    @Column(name = "JMBG")
    private String jmbg;
    @Basic(optional = false)
    @NotNull
    @Column(name = "avionID")
    private long avionID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datum")
    @Temporal(TemporalType.DATE)
    private Date datum;

    public UlogaPK() {
    }

    public UlogaPK(String jmbg, long avionID, Date datum) {
        this.jmbg = jmbg;
        this.avionID = avionID;
        this.datum = datum;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (jmbg != null ? jmbg.hashCode() : 0);
        hash += (int) avionID;
        hash += (datum != null ? datum.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UlogaPK)) {
            return false;
        }
        UlogaPK other = (UlogaPK) object;
        if ((this.jmbg == null && other.jmbg != null) || (this.jmbg != null && !this.jmbg.equals(other.jmbg))) {
            return false;
        }
        if (this.avionID != other.avionID) {
            return false;
        }
        if ((this.datum == null && other.datum != null) || (this.datum != null && !this.datum.equals(other.datum))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.UlogaPK[ jmbg=" + jmbg + ", avionID=" + avionID + ", datum=" + datum + " ]";
    }

}
