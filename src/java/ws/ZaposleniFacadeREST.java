package ws;

import domain.Aviomehanicar;
import domain.Pilot;
import domain.Zaposleni;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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

    @PersistenceContext(unitName = "RESTWSAvioKompanijaPU")
    private EntityManager em;

    public ZaposleniFacadeREST() {
    }

    @GET
    @Produces("application/json")
    public List<Zaposleni> findAll() {
        return em.createNamedQuery("Zaposleni.findAll").getResultList();
    }

    @GET
    @Path("{id}")
    @Produces("application/json")
    public Zaposleni find(@PathParam("id") String id) {
        return em.find(Zaposleni.class, id);
    }

    @GET
    @Path("piloti")
    @Produces("application/json")
    public List<Pilot> findAllPilot() {
        return em.createNamedQuery("Pilot.findAll").getResultList();
    }

    @GET
    @Path("mehanicari")
    @Produces("application/json")
    public List<Aviomehanicar> findAllAvioMehanicar() {
        return em.createNamedQuery("Aviomehanicar.findAll").getResultList();
    }

    @GET
    @Path("delete/{id}")
    public String remove(@PathParam("id") String id) {
        try {
            Zaposleni z = em.find(Zaposleni.class, id);
            em.remove(z);
            return Messages.EMPLOYEE_REMOVE_SUCCESS;
        } catch (Exception e) {
            return Messages.EMPLOYEE_REMOVE_FAILURE;
        }
    }

    @POST
    @Path("createAll")
    @Consumes("application/json")
    public String createAll(Zaposleni[] zapArr) {
        try {
            for (Zaposleni z : zapArr) {
                em.persist(z);
            }
            return Messages.EMPLOYEES_CREATE_SUCCESS;
        } catch (Exception e) {
            return Messages.EMPLOYEES_CREATE_FAILURE;
        }
    }

    @POST
    @Path("edit")
    @Consumes("application/json")
    public String edit(Zaposleni entity) {
        try {
            em.merge(entity);
            return Messages.EMPLOYEE_EDIT_SUCCESS;
        } catch (Exception e) {
            return Messages.EMPLOYEE_EDIT_FAILURE;
        }
    }

}
