package util;

import java.util.logging.Logger;
import org.hibernate.*;

@Deprecated
public class HibernateUtility {

    private static SessionFactory sessionFactory;
    private final static Logger log;

    static {
        log = Logger.getLogger(HibernateUtility.class.getName());
        try {
//            sessionFactory = new Configuration().configure().buildSessionFactory();
            log.info("SessionFactory init success");
        } catch (Throwable ex) {
            log.severe("SessionFactory init falure");
            log.severe(ex.getMessage());
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
