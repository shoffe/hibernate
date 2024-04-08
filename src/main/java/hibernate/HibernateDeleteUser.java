package hibernate;

import example_project.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class HibernateDeleteUser {
    private final SessionFactory sessionFactory;

    public HibernateDeleteUser(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public void deleteUser(int userId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            User user = session.get(User.class, userId);
            if (user!= null) {
                session.remove(user);
            } else {
                throw new Exception("не найден ID");
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            } throw new RuntimeException(("Ошибка при удалении пользователя"));
        } finally {
            session.close();
        }
    }


}
