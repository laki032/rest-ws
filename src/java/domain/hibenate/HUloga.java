package domain.hibenate;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Lazar Vujadinovic
 */
public class HUloga extends HAbstractDomainObject implements Serializable {

    private static final long serialVersionUID = 1L;
    private String nazivUloge;
    private HPilot pilot;
    private HAvion avion;
    private Date datum;

    public HUloga() {
    }

    public String getNazivUloge() {
        return nazivUloge;
    }

    public void setNazivUloge(String nazivUloge) {
        this.nazivUloge = nazivUloge;
    }

    public HPilot getPilot() {
        return pilot;
    }

    public void setPilot(HPilot pilot) {
        this.pilot = pilot;
    }

    public HAvion getAvion() {
        return avion;
    }

    public void setAvion(HAvion avion) {
        this.avion = avion;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }
    
    @Override
    public String toString() {
        return "uloga[ " + avion.getOznaka() + " ]";
    }

    @Override
    public String tableName() {
        return "Uloga";
    }

}
