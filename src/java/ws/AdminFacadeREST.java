package ws;

import db.DataBaseBroker;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import domain.Admin;

/**
 *
 * @author Lazar Vujadinovic
 */
@Stateless
@Path("admin")
public class AdminFacadeREST  {

    public AdminFacadeREST() {
    }

    @GET
    @Path("login")
    @Consumes("application/json")
    @Produces("application/json")
    public Admin login(Admin a) {
        return DataBaseBroker.ulogujAdmina(a);
    }
    
    @GET
    @Path("logout")
    @Consumes("application/json")
    public String logout(Admin a) {
        return DataBaseBroker.izlogujAdmina(a);
    }

}
