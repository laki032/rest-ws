package ws;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 *
 * @author Lazar Vujadinovic
 */
@ApplicationPath("rest")
public class AppConfig extends Application {

    // Daje informaciju o dostupnim ws
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> set = new HashSet<>();
        set.add(UlogeLicenceFacadeREST.class);
        set.add(AvionFacadeREST.class);
        set.add(AdminFacadeREST.class);
        set.add(ZaposleniFacadeREST.class);
        return set;
    }
    
    
    
}
