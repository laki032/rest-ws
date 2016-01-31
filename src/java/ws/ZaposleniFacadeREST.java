package ws;

import db.DataBaseBroker;
import domain.hibenate.HAbstractDomainObject;
import domain.hibenate.HAviomehanicar;
import domain.hibenate.HPilot;
import domain.hibenate.HZaposleni;
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
    public List<HZaposleni> findAll() {
        List<HZaposleni> lz = new ArrayList<>();
        List<HAbstractDomainObject> lado = DataBaseBroker.getAll(new HZaposleni());
        for (HAbstractDomainObject ado : lado) {
            lz.add((HZaposleni) ado);
        }
        return lz;
    }

    @GET
    @Path("{id}")
    @Produces("application/json")
    public HZaposleni find(@PathParam("id") String id) {
        return (HZaposleni) DataBaseBroker.getByCriteria(id);
    }

    @GET
    @Path("piloti")
    @Produces("application/json")
    public List<HPilot> findAllPilot() {
        List<HPilot> lz = new ArrayList<>();
        List<HAbstractDomainObject> lado = DataBaseBroker.getAll(new HPilot());
        for (HAbstractDomainObject ado : lado) {
            lz.add((HPilot) ado);
        }
        return lz;
    }

    @GET
    @Path("mehanicari")
    @Produces("application/json")
    public List<HAviomehanicar> findAllAvioMehanicar() {
        List<HAviomehanicar> lz = new ArrayList<>();
        List<HAbstractDomainObject> lado = DataBaseBroker.getAll(new HAviomehanicar());
        for (HAbstractDomainObject ado : lado) {
            lz.add((HAviomehanicar) ado);
        }
        return lz;
    }

    @GET
    @Path("delete/{id}")
    public String remove(@PathParam("id") String id) {
        if (DataBaseBroker.remove(new HZaposleni(id))) {
            return Messages.EMPLOYEE_REMOVE_SUCCESS;
        } else {
            return Messages.EMPLOYEE_REMOVE_FAILURE;
        }
    }

    @POST
    @Path("createAll")
    @Consumes("application/json")
    public String createAll(HZaposleni[] zapArr) {
        if (DataBaseBroker.saveAll(zapArr)) {
            return Messages.EMPLOYEES_CREATE_SUCCESS;
        } else {
            return Messages.EMPLOYEES_CREATE_FAILURE;
        }
    }

    @POST
    @Path("edit/{id}")
    @Consumes("application/json")
    public String edit(@PathParam("id") String id, HZaposleni entity) {
        if (DataBaseBroker.update(entity)) {
            return Messages.EMPLOYEE_EDIT_SUCCESS;
        } else {
            return Messages.EMPLOYEE_EDIT_FAILURE;
        }
    }

}
