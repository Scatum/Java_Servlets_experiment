package utils;


import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {

    public static SessionFactory sessionFactory = null;

    public static synchronized  SessionFactory getSessionFactory() {
        Configuration cfg = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties());
        sessionFactory = cfg.buildSessionFactory(builder.build());
        return sessionFactory;
    }

}
