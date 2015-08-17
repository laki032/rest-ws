package ws;

import db.DataBaseBroker;
import domain.AbstractDomainObject;
import domain.Avion;
import domain.Tipaviona;
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
@Path("avioni")
public class AvionFacadeREST {

    public AvionFacadeREST() {
    }

    @GET
    @Produces("application/json")
    public List<Avion> findAll() {
        List<Avion> la = new ArrayList<>();
        List<AbstractDomainObject> lado = DataBaseBroker.vratiSve(new Avion());
        for (AbstractDomainObject ado : lado) {
            la.add((Avion) ado);
        }
        return la;
    }

    @GET
    @Path("tipovi")
    @Produces("application/json")
    public List<Tipaviona> findAllTypes() {
        List<Tipaviona> lt = new ArrayList<>();
        List<AbstractDomainObject> lado = DataBaseBroker.vratiSve(new Tipaviona());
        for (AbstractDomainObject ado : lado) {
            lt.add((Tipaviona) ado);
        }
        return lt;
    }

    @GET
    @Path("{id}")
    @Produces("application/json")
    public Avion find(@PathParam("id") int id) {
        return (Avion) DataBaseBroker.vratiPoKriterijumu(id + "");
    }

    @GET
    @Path("delete/{id}")
    public boolean remove(@PathParam("id") int id) {
        return DataBaseBroker.obrisi(new Avion(id));
    }

    @POST
    @Consumes("application/json")
    public boolean create(Avion entity) {
        if (entity.getAvionID() == 0) {
            //promeni id entity-ja na max avionID + 1
            entity.setAvionID(DataBaseBroker.getMaxAvionID() + 1);
            return DataBaseBroker.kreirajIUbaci(entity);
        } else {
            return false;
        }
    }

    @POST
    @Path("edit/{id}")
    @Consumes("application/json")
    public boolean edit(@PathParam("id") int id, Avion entity) {
        return DataBaseBroker.azuriraj(entity);
    }

}
