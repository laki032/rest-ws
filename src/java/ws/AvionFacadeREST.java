package ws;

import db.DataBaseBroker;
import domain.hibenate.HAbstractDomainObject;
import domain.hibenate.HAvion;
import domain.hibenate.HTipaviona;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import util.Messages;

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
    public List<HAvion> findAll() {
        List<HAvion> la = new ArrayList<>();
        List<HAbstractDomainObject> lado = DataBaseBroker.getAll(new HAvion());
        for (HAbstractDomainObject ado : lado) {
            la.add((HAvion) ado);
        }
        return la;
    }

    @GET
    @Path("tipovi")
    @Produces("application/json")
    public List<HTipaviona> findAllTypes() {
        List<HTipaviona> lt = new ArrayList<>();
        List<HAbstractDomainObject> lado = DataBaseBroker.getAll(new HTipaviona());
        for (HAbstractDomainObject ado : lado) {
            lt.add((HTipaviona) ado);
        }
        return lt;
    }

    @GET
    @Path("{id}")
    @Produces("application/json")
    public HAvion find(@PathParam("id") int id) {
        return (HAvion) DataBaseBroker.getByCriteria(id + "");
    }

    @GET
    @Path("delete/{id}")
    public String remove(@PathParam("id") int id) {
        if (DataBaseBroker.remove(new HAvion(id))) {
            return Messages.PLANE_REMOVE_SUCCESS;
        } else {
            return Messages.PLANE_REMOVE_FAILURE;
        }
    }

    @POST
    @Consumes("application/json")
    public String create(HAvion entity) {
        if (entity.getAvionID() == 0) {
            //promeni id entity-ja na max avionID + 1
            entity.setAvionID(DataBaseBroker.getMaxAvionID() + 1);
            if (DataBaseBroker.create(entity)) {
                return Messages.PLANE_CREATE_SUCCESS;
            }
        }
        return Messages.PLANE_CREATE_FAILURE;
    }

    @POST
    @Path("edit/{id}")
    @Consumes("application/json")
    public String edit(@PathParam("id") int id, HAvion entity) {
        entity.setAvionID(id);
        if (DataBaseBroker.update(entity)) {
            return Messages.PLANE_EDIT_SUCCESS;
        } else {
            return Messages.PLANE_EDIT_FAILURE;
        }
    }

}
