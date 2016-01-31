package domain.hibenate;

import java.io.Serializable;

/**
 *
 * @author Lazar Vujadinovic
 */
public abstract class HAbstractDomainObject implements Serializable {
    
    public abstract String tableName();
    
}
