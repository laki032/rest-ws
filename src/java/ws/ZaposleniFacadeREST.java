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
import util.Messages;

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
        List<AbstractDomainObject> lado = DataBaseBroker.getAll(new Zaposleni());
        for (AbstractDomainObject ado : lado) {
            lz.add((Zaposleni) ado);
        }
        return lz;
    }

    @GET
    @Path("{id}")
    @Produces("application/json")
    public Zaposleni find(@PathParam("id") String id) {
        return (Zaposleni) DataBaseBroker.getByCriteria(id);
    }

    @GET
    @Path("piloti")
    @Produces("application/json")
    public List<Pilot> findAllPilot() {
        List<Pilot> lz = new ArrayList<>();
        List<AbstractDomainObject> lado = DataBaseBroker.getAll(new Pilot());
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
        List<AbstractDomainObject> lado = DataBaseBroker.getAll(new Aviomehanicar());
        for (AbstractDomainObject ado : lado) {
            lz.add((Aviomehanicar) ado);
        }
        return lz;
    }

    @GET
    @Path("delete/{id}")
    public String remove(@PathParam("id") String id) {
        if (DataBaseBroker.remove(new Zaposleni(id))) {
            return Messages.EMPLOYEE_REMOVE_SUCCESS;
        } else {
            return Messages.EMPLOYEE_REMOVE_FAILURE;
        }
    }

    @POST
    @Path("createAll")
    @Consumes("application/json")
    public String createAll(Zaposleni[] zapArr) {
        if (DataBaseBroker.saveAll(zapArr)) {
            return Messages.EMPLOYEES_CREATE_SUCCESS;
        } else {
            return Messages.EMPLOYEES_CREATE_FAILURE;
        }
    }

    @POST
    @Path("edit/{id}")
    @Consumes("application/json")
    public String edit(@PathParam("id") String id, Zaposleni entity) {
        if (DataBaseBroker.update(entity)) {
            return Messages.EMPLOYEE_EDIT_SUCCESS;
        } else {
            return Messages.EMPLOYEE_EDIT_FAILURE;
        }
    }

}
