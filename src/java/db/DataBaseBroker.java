package db;

import domain.AbstractDomainObject;
import domain.Aviomehanicar;
import domain.Avion;
import domain.Licenca;
import domain.Pilot;
import domain.Tipaviona;
import domain.Uloga;
import domain.Zaposleni;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtility;

/**
 *
 * @author Lazar Vujadinovic
 */
public class DataBaseBroker {

    public static List<AbstractDomainObject> vratiSve(AbstractDomainObject ado) {
        Session session = HibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from " + ado.imeTabele());
        List<AbstractDomainObject> lista = query.list();
        session.getTransaction().commit();
        return lista;
    }

    public static boolean kreirajIUbaci(AbstractDomainObject ado) {
        Session session = HibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(ado);
        session.getTransaction().commit();
        return true;
    }

    public static boolean azuriraj(AbstractDomainObject ado) {
        Session session = HibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(ado);
        session.getTransaction().commit();
        return true;
    }

    public static boolean obrisi(AbstractDomainObject ado) {
        Session session = HibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(ado);
        session.getTransaction().commit();
        return true;
    }

    public static AbstractDomainObject vratiPoKriterijumu(String id) {
        Session session = HibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();
        AbstractDomainObject rezultat;
        try {
            rezultat = (Zaposleni) session.get(Zaposleni.class, id);
            if (rezultat == null) {
                throw new Exception("nije zaposleni, nego avion");
            }
        } catch (Exception e) {
            rezultat = (Avion) session.get(Avion.class, Integer.parseInt(id));
        }

        session.getTransaction().commit();
        return rezultat;
    }

    public static List<AbstractDomainObject> vratiU_L(String id, int sk) {
        Session sesija = HibernateUtility.getSessionFactory().openSession();
        sesija.beginTransaction();
        Criteria crit = null;
        List<AbstractDomainObject> lista;
        switch (sk) {
            case 0: //vratiUlogeZaAvion
                crit = sesija.createCriteria(Uloga.class);
                crit.setMaxResults(15);
                crit.add(Restrictions.like("avion", new Avion(Integer.parseInt(id))));
                break;
            case 1: //vratiUlogeZaPilota
                crit = sesija.createCriteria(Uloga.class);
                crit.setMaxResults(15);
                crit.add(Restrictions.like("pilot", new Pilot(id)));
                break;
            case 2: //vratiLicenceZaTip
                crit = sesija.createCriteria(Licenca.class);
                crit.setMaxResults(15);
                crit.add(Restrictions.like("tipaviona", new Tipaviona(Integer.parseInt(id))));
                break;
            case 3: //vratiLicenceZaMehanicara
                crit = sesija.createCriteria(Licenca.class);
                crit.setMaxResults(15);
                crit.add(Restrictions.like("aviomehanicar", new Aviomehanicar(id)));
                break;
        }
        lista = crit.list();
        sesija.getTransaction().commit();
        return lista;
    }

    public static int getMaxAvionID() {
        Session sesija = HibernateUtility.getSessionFactory().openSession();
        sesija.beginTransaction();
        Criteria criteria = sesija.createCriteria(Avion.class).setProjection(Projections.max("avionID"));
        Integer maxID = (Integer) criteria.uniqueResult();
        sesija.getTransaction().commit();
        return maxID;
    }

    public static boolean sacuvajZaposleneIzListe(List<Zaposleni> listaZap) {
        Session session = HibernateUtility.getSessionFactory().openSession();
        session.beginTransaction();
        try {
            for (Zaposleni z : listaZap) {
//                if(z.getAviomehanicar()==null){
//                }
//                
//                Zaposleni novi = new Zaposleni(z.getJmbg());
//                novi.setGodinaRodjenja(z.getGodinaRodjenja());
//                novi.setImePrezime(z.getImePrezime());
                
                session.persist(z);
            }
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            return false;
        }
    }

}
