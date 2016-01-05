package domain;

import java.io.Serializable;
import java.util.Set;

/**
 *
 * @author Lazar Vujadinovic
 */
public class Tipaviona extends AbstractDomainObject implements Serializable {

    private static final long serialVersionUID = 1L;
    private int tipID;
    private String naziv;

//    private Set<Avion> avionList;
//    private Set<Licenca> licencaList;
    
    public Tipaviona() {
    }

    public Tipaviona(int tipID) {
        this.tipID = tipID;
    }

    public int getTipID() {
        return tipID;
    }

    public void setTipID(int tipID) {
        this.tipID = tipID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

//    public Set<Avion> getAvionList() {
//        return avionList;
//    }
//
//    public void setAvionList(Set<Avion> avionList) {
//        this.avionList = avionList;
//    }
//
//    public Set<Licenca> getLicencaList() {
//        return licencaList;
//    }
//
//    public void setLicencaList(Set<Licenca> licencaList) {
//        this.licencaList = licencaList;
//    }
    
    @Override
    public String toString() {
        return "[" + tipID + "] " + naziv;
    }

    @Override
    public String tableName() {
        return "Tipaviona";
    }

}
