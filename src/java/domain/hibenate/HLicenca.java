package domain.hibenate;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Lazar Vujadinovic
 */
public class HLicenca extends HAbstractDomainObject implements Serializable {

    private static final long serialVersionUID = 1L;

    private Date datumDobijanja;
    private HAviomehanicar aviomehanicar;
    private HTipaviona tipaviona;

    public HLicenca() {
    }

    public String getJmbg() {
        return aviomehanicar.getJmbg();
    }

    public void setJmbg(String jmbg) {
        this.aviomehanicar.setJmbg(jmbg);
    }

    public int getTipID() {
        return tipaviona.getTipID();
    }

    public void setTipID(int tipID) {
        this.tipaviona.setTipID(tipID);
    }

    public Date getDatumDobijanja() {
        return datumDobijanja;
    }

    public void setDatumDobijanja(Date datumDobijanja) {
        this.datumDobijanja = datumDobijanja;
    }

    public HAviomehanicar getAviomehanicar() {
        return aviomehanicar;
    }

    public void setAviomehanicar(HAviomehanicar aviomehanicar) {
        this.aviomehanicar = aviomehanicar;
    }

    public HTipaviona getTipaviona() {
        return tipaviona;
    }

    public void setTipaviona(HTipaviona tipaviona) {
        this.tipaviona = tipaviona;
    }

    @Override
    public String tableName() {
        return "Licenca";
    }

}
