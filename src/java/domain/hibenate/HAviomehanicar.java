package domain.hibenate;

import java.io.Serializable;
import java.util.Set;

/**
 *
 * @author Lazar Vujadinovic
 */
public class HAviomehanicar extends HZaposleni implements Serializable {

    private static final long serialVersionUID = 1L;
    private String jmbg;
    private String tipMehanicara;
    private HZaposleni zaposleni;
//    private Set<Licenca> licencaList;

    public HAviomehanicar() {
    }

    public HAviomehanicar(String jmbg) {
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

    public HZaposleni getZaposleni() {
        return zaposleni;
    }

    public void setZaposleni(HZaposleni zaposleni) {
        this.zaposleni = zaposleni;
    }

//    public Set<Licenca> getLicencaList() {
//        return licencaList;
//    }
//
//    public void setLicencaList(Set<Licenca> licencaList) {
//        this.licencaList = licencaList;
//    }

    @Override
    public String toString() {
        return "mehanicar[" + jmbg + "] " + getImePrezime();
    }

    @Override
    public String tableName() {
        return "Aviomehanicar";
    }

}
