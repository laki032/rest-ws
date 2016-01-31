package ws;

import db.DataBaseBroker;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import domain.hibenate.HAdmin;
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
    public HAdmin login(HAdmin a) {
        return DataBaseBroker.adminLogin(a);
    }
    
    @POST
    @Path("logout")
    @Consumes("application/json")
    public String logout(HAdmin a) {
        return DataBaseBroker.adminLogout(a);
    }

}
