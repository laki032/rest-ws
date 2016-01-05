package ws;

import db.DataBaseBroker;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import domain.Admin;
import javax.ws.rs.POST;

/**
 *
 * @author Lazar Vujadinovic
 */
@Stateless
@Path("admin")
public class AdminFacadeREST  {

    public AdminFacadeREST() {
    }

    @POST
    @Path("login")
    @Consumes("application/json")
    @Produces("application/json")
    public Admin login(Admin a) {
        return DataBaseBroker.adminLogin(a);
    }
    
    @POST
    @Path("logout")
    @Consumes("application/json")
    public String logout(Admin a) {
        return DataBaseBroker.adminLogout(a);
    }

}
