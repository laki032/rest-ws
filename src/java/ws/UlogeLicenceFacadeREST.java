package ws;

import domain.Licenca;
import domain.Uloga;
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
@Path("U-L")
public class UlogeLicenceFacadeREST {

    @PersistenceContext(unitName = "RESTWSAvioKompanijaPU")
    private EntityManager em;

    public UlogeLicenceFacadeREST() {
    }

    @GET
    @Path("avion/{id}")
    @Produces("application/json")
    public List<Uloga> vratiUlogeZaAvion(@PathParam("id") int id) {
        return em.createNamedQuery("Uloga.findByAvionID").setParameter("avionID", id).getResultList();
    }

    @GET
    @Path("pilot/{id}")
    @Produces("application/json")
    public List<Uloga> vratiUlogeZaPilota(@PathParam("id") String id) {
        return em.createNamedQuery("Uloga.findByJmbg").setParameter("jmbg", id).getResultList();
    }

    @GET
    @Path("tip/{id}")
    @Produces("application/json")
    public List<Licenca> vratiLicenceZaTip(@PathParam("id") int id) {
        return em.createNamedQuery("Licenca.findByTipID").setParameter("tipID", id).getResultList();
    }

    @GET
    @Path("mehanicar/{id}")
    @Produces("application/json")
    public List<Licenca> vratiLicenceZaMehanicara(@PathParam("id") String id) {
        return em.createNamedQuery("Licenca.findByJmbg").setParameter("jmbg", id).getResultList();
    }

    @POST
    @Path("licenca")
    @Consumes("application/json")
    public String novaLicenca(Licenca l) {
        try {
            em.persist(l);
            return Messages.LICENSE_CREATE_SUCCESS;
        } catch (Exception e) {
            return Messages.LICENSE_CREATE_FAILURE;
        }
    }

    @POST
    @Path("uloga")
    @Consumes("application/json")
    public String novaUloga(Uloga u) {
        try {
            em.persist(u);
            return Messages.ROLE_CREATE_SUCCESS;
        } catch (Exception e) {
            return Messages.ROLE_CREATE_FAILURE;
        }
    }
}
