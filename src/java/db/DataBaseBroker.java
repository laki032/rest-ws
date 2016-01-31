package db;

import domain.hibenate.HUloga;
import domain.hibenate.HAviomehanicar;
import domain.hibenate.HZaposleni;
import domain.hibenate.HAdmin;
import domain.hibenate.HLicenca;
import domain.hibenate.HPilot;
import domain.hibenate.HAvion;
import domain.hibenate.HAbstractDomainObject;
import domain.hibenate.HTipaviona;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtility;
import util.Messages;

/**
 *
 * @author Lazar Vujadinovic
 */
@Deprecated
public class DataBaseBroker {

    private final static Logger log = Logger.getLogger(DataBaseBroker.class.getName());
        
    public static List<HAbstractDomainObject> getAll(HAbstractDomainObject ado) {
        log.log(Level.INFO, "getAll {0}", ado.tableName());
        Session session = HibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from " + ado.tableName());
        List<HAbstractDomainObject> lista = query.list();
        session.getTransaction().commit();
        return lista;
    }

    public static boolean create(HAbstractDomainObject ado) {
        log.log(Level.INFO, "create {0}", ado);
        Session session = HibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(ado);
        session.getTransaction().commit();
        return true;
    }

    public static boolean update(HAbstractDomainObject ado) {
        log.log(Level.INFO, "update {0}", ado);
        Session session = HibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(ado);
        session.getTransaction().commit();
        return true;
    }

    public static boolean remove(HAbstractDomainObject ado) {
        log.log(Level.INFO, "remove {0}", ado);
        Session session = HibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(ado);
        session.getTransaction().commit();
        return true;
    }

    public static HAbstractDomainObject getByCriteria(String id) {
        Session session = HibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();
        HAbstractDomainObject ado;
        try {
            ado = (HZaposleni) session.get(HZaposleni.class, id);
            log.log(Level.INFO, "getByCriteria Zaposleni {0}", id);
            if (ado == null) {
                throw new Exception("nije zaposleni, nego avion");
            }
        } catch (Exception e) {
            ado = (HAvion) session.get(HAvion.class, Integer.parseInt(id));
            log.log(Level.INFO, "getByCriteria Avion {0}", id);
        }

        session.getTransaction().commit();
        return ado;
    }

    public static List<HAbstractDomainObject> getU_L(String id, int sk) {
        log.log(Level.INFO, "getU_L {0}, sk: {1}", new Object[]{id, sk});
        Session session = HibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria crit = null;
        List<HAbstractDomainObject> lista;
        switch (sk) {
            case 0: //vratiUlogeZaAvion
                crit = session.createCriteria(HUloga.class);
                crit.setMaxResults(15);
                crit.add(Restrictions.like("avion", new HAvion(Integer.parseInt(id))));
                break;
            case 1: //vratiUlogeZaPilota
                crit = session.createCriteria(HUloga.class);
                crit.setMaxResults(15);
                crit.add(Restrictions.like("pilot", new HPilot(id)));
                break;
            case 2: //vratiLicenceZaTip
                crit = session.createCriteria(HLicenca.class);
                crit.setMaxResults(15);
                crit.add(Restrictions.like("tipaviona", new HTipaviona(Integer.parseInt(id))));
                break;
            case 3: //vratiLicenceZaMehanicara
                crit = session.createCriteria(HLicenca.class);
                crit.setMaxResults(15);
                crit.add(Restrictions.like("aviomehanicar", new HAviomehanicar(id)));
                break;
        }
        lista = crit.list();
        session.getTransaction().commit();
        return lista;
    }

    public static int getMaxAvionID() {
        Session session = HibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(HAvion.class).setProjection(Projections.max("avionID"));
        Integer maxID = (Integer) criteria.uniqueResult();
        session.getTransaction().commit();
        return maxID;
    }

    public static boolean saveAll(HZaposleni[] colZap) {
        log.log(Level.INFO, "saveAll {0}", colZap);
        Session session = HibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();
        try {
            for (HZaposleni z : colZap) {
                if (z.getPilot() != null) {
                    session.persist(z.getPilot());
                }
                if (z.getAviomehanicar() != null) {
                    session.persist(z.getAviomehanicar());
                }
            }
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            return false;
        }
    }

    public static HAdmin adminLogin(HAdmin a) {
        log.log(Level.INFO, "adminLogin {0}", a);
        try {
            Session sessionFind = HibernateUtility.getSessionFactory().openSession();
            sessionFind.beginTransaction();
            Criteria crit = sessionFind.createCriteria(HAdmin.class);
            Criterion un = Restrictions.like("username", a.getUsername().trim());
            Criterion pass = Restrictions.like("password", a.getPassword());
            LogicalExpression andExp = Restrictions.and(un, pass);
            crit.add(andExp);
            HAdmin admin = (HAdmin) crit.uniqueResult();
            sessionFind.getTransaction().commit();

            if (admin != null) {
                Session sessionLogin = HibernateUtility.getSessionFactory().openSession();
                sessionLogin.beginTransaction();
                a.setUlogovan(true);
                a.setLastLogin(new Date());
                a.setTheme(admin.getTheme());
                sessionLogin.update(a);
                admin.setUlogovan(true);
                sessionLogin.getTransaction().commit();
            }
            return admin;
        } catch (Exception e) {
            return null;
        }
    }

    public static String adminLogout(HAdmin a) {
        log.log(Level.INFO, "adminLogout {0}", a);
        try {
            Session sessionFind = HibernateUtility.getSessionFactory().openSession();
            sessionFind.beginTransaction();
            Criteria crit = sessionFind.createCriteria(HAdmin.class);
            Criterion un = Restrictions.like("username", a);
            Criterion pass = Restrictions.like("password", a);
            LogicalExpression andExp = Restrictions.and(un, pass);
            crit.add(andExp);
            HAdmin admin = (HAdmin) crit.uniqueResult();
            sessionFind.getTransaction().commit();

            if (admin != null) {
                Session sessionLogout = HibernateUtility.getSessionFactory().openSession();
                sessionLogout.beginTransaction();
                a.setUlogovan(false);
                a.setTheme(admin.getTheme());
                sessionLogout.update(a);
                sessionLogout.getTransaction().commit();
            }
            return Messages.ADMIN_LOGOUT_SUCCESS;
        } catch (Exception e) {
            return Messages.ADMIN_LOGOUT_FAILURE;
        }
    }

}
