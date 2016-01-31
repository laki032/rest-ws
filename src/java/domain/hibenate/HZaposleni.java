package domain.hibenate;

import java.io.Serializable;

/**
 *
 * @author Lazar Vujadinovic
 */
public class HZaposleni extends HAbstractDomainObject  implements Serializable {
    private static final long serialVersionUID = 1L;
    private String jmbg;
    private String imePrezime;
    private int godinaRodjenja;
    private HPilot pilot;
    private HAviomehanicar aviomehanicar;

    public HZaposleni() {
    }

    public HZaposleni(String jmbg) {
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

    public int getGodinaRodjenja() {
        return godinaRodjenja;
    }

    public void setGodinaRodjenja(int godinaRodjenja) {
        this.godinaRodjenja = godinaRodjenja;
    }

    public HPilot getPilot() {
        return pilot;
    }

    public void setPilot(HPilot pilot) {
        this.pilot = pilot;
    }

    public HAviomehanicar getAviomehanicar() {
        return aviomehanicar;
    }

    public void setAviomehanicar(HAviomehanicar aviomehanicar) {
        this.aviomehanicar = aviomehanicar;
    }

    @Override
    public String toString() {
        return "[" + jmbg + "] " + getImePrezime();
    }

    @Override
    public String tableName() {
        return "Zaposleni";
    }
    
}
