package ws;

import db.DataBaseBroker;
import domain.Avion;
import domain.Tipaviona;
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
@Path("avioni")
public class AvionFacadeREST {

    @PersistenceContext(unitName = "RESTWSAvioKompanijaPU")
    private EntityManager em;

    public AvionFacadeREST() {
    }

    @GET
    @Produces("application/json")
    public List<Avion> findAll() {
        return em.createNamedQuery("Avion.findAll").getResultList();
    }
    
    @GET
    @Path("tipovi")
    @Produces("application/json")
    public List<Tipaviona> findAllTypes() {
        return em.createNamedQuery("Tipaviona.findAll").getResultList();
    }

    @GET
    @Path("{id}")
    @Produces("application/json")
    public Avion find(@PathParam("id") int id) {
        return em.find(Avion.class, new Long(id));
    }

    @GET
    @Path("delete/{id}")
    public String remove(@PathParam("id") int id) {
        try {
            Avion a = em.find(Avion.class, new Long(id));
            em.remove(a);
            return Messages.PLANE_REMOVE_SUCCESS;
        } catch (Exception e) {
            return Messages.PLANE_REMOVE_FAILURE;
        }
    }

    @POST
    @Consumes("application/json")
    public String create(Avion entity) {
        try {
            if (entity.getAvionID() == 0) {
                //promeni id entity-ja na max avionID + 1
                Long max = (Long) em.createNamedQuery("Avion.maxID").getSingleResult();
                entity.setAvionID(max + 1);
                em.persist(entity);
            }
            return Messages.PLANE_CREATE_SUCCESS;
        } catch (Exception e) {
            return Messages.PLANE_CREATE_FAILURE;
        }
    }

    @POST
    @Path("edit")
    @Consumes("application/json")
    public String edit(Avion entity) {
        try {
            em.merge(entity);
            return Messages.PLANE_EDIT_SUCCESS;
        } catch (Exception e) {
            return Messages.PLANE_EDIT_FAILURE;
        }
    }

}
