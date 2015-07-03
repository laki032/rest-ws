package ws;

import db.DataBaseBroker;
import domain.AbstractDomainObject;
import domain.Aviomehanicar;
import domain.Pilot;
import domain.Zaposleni;
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
@Path("zaposleni")
public class ZaposleniFacadeREST {

    public ZaposleniFacadeREST() {
    }

    @GET
    @Produces("application/json")
    public List<Zaposleni> findAll() {
        List<Zaposleni> lz = new ArrayList<>();
        List<AbstractDomainObject> lado = DataBaseBroker.vratiSve(new Zaposleni());
        for (AbstractDomainObject ado : lado) {
            lz.add((Zaposleni) ado);
        }
        return lz;
    }

    @GET
    @Path("{id}")
    @Produces("application/json")
    public Zaposleni find(@PathParam("id") String id) {
        return (Zaposleni) DataBaseBroker.vratiPoKriterijumu(id);
    }

    @GET
    @Path("piloti")
    @Produces("application/json")
    public List<Pilot> findAllPilot() {
        List<Pilot> lz = new ArrayList<>();
        List<AbstractDomainObject> lado = DataBaseBroker.vratiSve(new Pilot());
        for (AbstractDomainObject ado : lado) {
            lz.add((Pilot) ado);
        }
        return lz;
    }

    @GET
    @Path("mehanicari")
    @Produces("application/json")
    public List<Aviomehanicar> findAllAvioMehanicar() {
        List<Aviomehanicar> lz = new ArrayList<>();
        List<AbstractDomainObject> lado = DataBaseBroker.vratiSve(new Aviomehanicar());
        for (AbstractDomainObject ado : lado) {
            lz.add((Aviomehanicar) ado);
        }
        return lz;
    }

    @GET
    @Path("delete/{id}")
    public boolean remove(@PathParam("id") String id) {
        //ne moze ovako
        return DataBaseBroker.obrisi(new Zaposleni(id));
    }

    @POST
    @Consumes("application/json")
    public boolean create(Zaposleni entity) {
        return DataBaseBroker.kreirajIUbaci(entity);
    }

    @POST
    @Path("edit/{id}")
    @Consumes("application/json")
    public boolean edit(@PathParam("id") String id, Zaposleni entity) {
        return DataBaseBroker.azuriraj(entity);
    }

}
