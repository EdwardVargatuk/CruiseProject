package cruise.dao;


import cruise.Entities.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.function.Consumer;

/**
 * @author Edward
 */
public class HibernateUtil {
    private static final SessionFactory sessionFactory;

    static {
        try {
            Configuration configuration = new Configuration().configure();
            configuration.addAnnotatedClass(Client.class);
            configuration.addAnnotatedClass(Bonus.class);
            configuration.addAnnotatedClass(Cruise.class);
            configuration.addAnnotatedClass(Excursion.class);
            configuration.addAnnotatedClass(Port.class);
            configuration.addAnnotatedClass(Ship.class);
            configuration.addAnnotatedClass(Order.class);
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
            sessionFactory = configuration.buildSessionFactory(builder.build());
        } catch (Throwable e) {
            System.err.println("initialize ses fact" + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void executeInsideTransaction(Consumer<Session> action, Session session) {
        Transaction t = null;
        try {
            t = session.beginTransaction();
            action.accept(session);
            t.commit();
        } catch (RuntimeException e) {
            if (t != null) {
                t.rollback();
            }
            throw e;
        }
    }
}
