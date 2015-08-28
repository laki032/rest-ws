package ws;

import db.DataBaseBroker;
import domain.AbstractDomainObject;
import domain.Aviomehanicar;
import domain.Licenca;
import domain.Tipaviona;
import domain.Uloga;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author Lazar Vujadinovic
 */
@Stateless
@Path("U-L")
public class UlogeLicenceFacadeREST {

    public UlogeLicenceFacadeREST() {
    }

    //dodaj deo za unos pojedinacnih u/l ali tek kad ovo proradi, da se ne gomila pre toga
    @GET
    @Path("avion/{id}")
    @Produces("application/json")
    public List<Uloga> vratiUlogeZaAvion(@PathParam("id") int id) {
        List<Uloga> lu = new ArrayList<>();
        List<AbstractDomainObject> lado = DataBaseBroker.vratiU_L(id + "", 0);
        for (AbstractDomainObject ado : lado) {
            lu.add((Uloga) ado);
        }
        return lu;
    }

    @GET
    @Path("pilot/{id}")
    @Produces("application/json")
    public List<Uloga> vratiUlogeZaPilota(@PathParam("id") String id) {
        List<Uloga> lu = new ArrayList<>();
        List<AbstractDomainObject> lado = DataBaseBroker.vratiU_L(id, 1);
        for (AbstractDomainObject ado : lado) {
            lu.add((Uloga) ado);
        }
        return lu;
    }

    @GET
    @Path("tip/{id}")
    @Produces("application/json")
    public List<Licenca> vratiLicenceZaTip(@PathParam("id") int id) {
        List<Licenca> ll = new ArrayList<>();
        List<AbstractDomainObject> lado = DataBaseBroker.vratiU_L(id + "", 2);
        for (AbstractDomainObject ado : lado) {
            ll.add((Licenca) ado);
        }
        return ll;
    }

    @GET
    @Path("mehanicar/{id}")
    @Produces("application/json")
    public List<Licenca> vratiLicenceZaMehanicara(@PathParam("id") String id) {
        List<Licenca> ll = new ArrayList<>();
        List<AbstractDomainObject> lado = DataBaseBroker.vratiU_L(id, 3);
        for (AbstractDomainObject ado : lado) {
            ll.add((Licenca) ado);
        }
        return ll;
    }

    @POST
    @Path("licenca")
    @Consumes("application/json")
    public String novaLicenca(Licenca l) {
        if (DataBaseBroker.kreirajIUbaci(l)) {
            return "uspesno uneta";
        } else {
            return "nije uneta";
        }
    }

    @POST
    @Path("uloga")
    @Consumes("application/json")
    public String novaUloga(Uloga u) {
        if (DataBaseBroker.kreirajIUbaci(u)) {
            return "uspesno uneta";
        } else {
            return "nije uneta";
        }
    }
}
