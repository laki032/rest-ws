package ws;

import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import domain.Admin;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.POST;
import util.Encryptor;
import util.Messages;

/**
 *
 * @author Lazar Vujadinovic
 */
@Stateless
@Path("admin")
public class AdminFacadeREST {

    @PersistenceContext(unitName = "RESTWSAvioKompanijaPU")
    private EntityManager em;

    public AdminFacadeREST() {
    }

    @POST
    @Path("login")
    @Consumes("application/json")
    @Produces("application/json")
    public Admin login(Admin a) {
        Admin admin = (Admin) em.createNamedQuery("Admin.findByUsername").setParameter("username", a.getUsername()).getSingleResult();
        a.setPassword(Encryptor.decrypt(a.getPassword()));
        if (admin.getUsername().equals(a.getUsername()) && admin.getPassword().equals(a.getPassword())) {
            a.setUlogovan(true);
            a.setLastLogin(new Date());
            a.setTheme(admin.getTheme());
            em.merge(a);
            return a;
        }
        return null;
    }

    @POST
    @Path("logout")
    @Consumes("application/json")
    public String logout(Admin a) {
        Admin admin = (Admin) em.createNamedQuery("Admin.findByUsername").setParameter("username", a.getUsername()).getSingleResult();
        a.setPassword(Encryptor.decrypt(a.getPassword()));
        if (admin.getUsername().equals(a.getUsername()) && admin.getPassword().equals(a.getPassword())) {
            a.setUlogovan(false);
            a.setTheme(admin.getTheme());
            em.merge(a);
            return Messages.ADMIN_LOGOUT_SUCCESS;
        }
        return Messages.ADMIN_LOGOUT_FAILURE;
    }

}
