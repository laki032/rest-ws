package domain;

import java.io.Serializable;
import java.util.Set;

/**
 *
 * @author Lazar Vujadinovic
 */
public class Avion extends AbstractDomainObject implements Serializable {

    private static final long serialVersionUID = 1L;
    private int avionID;
    private String oznaka;
    private int godProizvodnje;
    private int brojPutnika;
    private int nosivost;
//    private Set<Uloga> ulogaList;
    private Tipaviona tipID;

    public Avion() {
    }

    public Avion(int avionID) {
        this.avionID = avionID;
    }

    public int getAvionID() {
        return avionID;
    }

    public void setAvionID(int avionID) {
        this.avionID = avionID;
    }

    public String getOznaka() {
        return oznaka;
    }

    public void setOznaka(String oznaka) {
        this.oznaka = oznaka;
    }

    public int getGodProizvodnje() {
        return godProizvodnje;
    }

    public void setGodProizvodnje(int godProizvodnje) {
        this.godProizvodnje = godProizvodnje;
    }

    public int getBrojPutnika() {
        return brojPutnika;
    }

    public void setBrojPutnika(int brojPutnika) {
        this.brojPutnika = brojPutnika;
    }

    public int getNosivost() {
        return nosivost;
    }

    public void setNosivost(int nosivost) {
        this.nosivost = nosivost;
    }

//    public Set<Uloga> getUlogaList() {
//        return ulogaList;
//    }
//
//    public void setUlogaList(Set<Uloga> ulogaList) {
//        this.ulogaList = ulogaList;
//    }

    public Tipaviona getTipID() {
        return tipID;
    }

    public void setTipID(Tipaviona tipID) {
        this.tipID = tipID;
    }

    @Override
    public String toString() {
        return "[" + avionID + "] " + oznaka;
    }

    @Override
    public String tableName() {
        return "Avion";
    }

}
