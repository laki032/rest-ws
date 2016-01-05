package domain;

import java.io.Serializable;

/**
 *
 * @author Lazar Vujadinovic
 */
public abstract class AbstractDomainObject implements Serializable {
    
    public abstract String tableName();
    
}
