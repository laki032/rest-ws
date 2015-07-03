package util;

import org.hibernate.*;
import org.hibernate.cfg.*;

public class HibernateUtility {
    private static final SessionFactory sessionFactory;
    
    static {
        try{
            // Kreira SessionFactory na osnovu hibernate.cfg.xml
            sessionFactory=new Configuration().configure().buildSessionFactory();
        }catch(Throwable ex){
            System.err.println("Inicijalno kreiranje SessionFactory nije uspelo! " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}
