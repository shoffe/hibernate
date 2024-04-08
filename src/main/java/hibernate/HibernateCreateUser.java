package hibernate;

import example_project.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class HibernateCreateUser {

    private final SessionFactory sessionFactory;

    public HibernateCreateUser(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public void createUser(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.persist(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Ошибка при создании пользователя", e);
        } finally {
            session.close();
        }

    }
}