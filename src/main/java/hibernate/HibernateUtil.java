package hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sessionFactory;
    private HibernateUtil() {}

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration config = new org.hibernate.cfg.Configuration().configure("hibernate.cfg.xml");
                sessionFactory = config.buildSessionFactory();
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
        return sessionFactory;
    }

}
