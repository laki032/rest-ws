package ws;

import db.DataBaseBroker;
import domain.hibenate.HAbstractDomainObject;
import domain.hibenate.HLicenca;
import domain.hibenate.HUloga;
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
@Path("U-L")
public class UlogeLicenceFacadeREST {

    public UlogeLicenceFacadeREST() {
    }

    @GET
    @Path("avion/{id}")
    @Produces("application/json")
    public List<HUloga> vratiUlogeZaAvion(@PathParam("id") int id) {
        List<HUloga> lu = new ArrayList<>();
        List<HAbstractDomainObject> lado = DataBaseBroker.getU_L(id + "", 0);
        for (HAbstractDomainObject ado : lado) {
            lu.add((HUloga) ado);
        }
        return lu;
    }

    @GET
    @Path("pilot/{id}")
    @Produces("application/json")
    public List<HUloga> vratiUlogeZaPilota(@PathParam("id") String id) {
        List<HUloga> lu = new ArrayList<>();
        List<HAbstractDomainObject> lado = DataBaseBroker.getU_L(id, 1);
        for (HAbstractDomainObject ado : lado) {
            lu.add((HUloga) ado);
        }
        return lu;
    }

    @GET
    @Path("tip/{id}")
    @Produces("application/json")
    public List<HLicenca> vratiLicenceZaTip(@PathParam("id") int id) {
        List<HLicenca> ll = new ArrayList<>();
        List<HAbstractDomainObject> lado = DataBaseBroker.getU_L(id + "", 2);
        for (HAbstractDomainObject ado : lado) {
            ll.add((HLicenca) ado);
        }
        return ll;
    }

    @GET
    @Path("mehanicar/{id}")
    @Produces("application/json")
    public List<HLicenca> vratiLicenceZaMehanicara(@PathParam("id") String id) {
        List<HLicenca> ll = new ArrayList<>();
        List<HAbstractDomainObject> lado = DataBaseBroker.getU_L(id, 3);
        for (HAbstractDomainObject ado : lado) {
            ll.add((HLicenca) ado);
        }
        return ll;
    }

    @POST
    @Path("licenca")
    @Consumes("application/json")
    public String novaLicenca(HLicenca l) {
        if (DataBaseBroker.create(l)) {
            return Messages.LICENSE_CREATE_SUCCESS;
        } else {
            return Messages.LICENSE_CREATE_FAILURE;
        }
    }

    @POST
    @Path("uloga")
    @Consumes("application/json")
    public String novaUloga(HUloga u) {
        if (DataBaseBroker.create(u)) {
            return Messages.ROLE_CREATE_SUCCESS;
        } else {
            return Messages.ROLE_CREATE_FAILURE;
        }
    }
}
