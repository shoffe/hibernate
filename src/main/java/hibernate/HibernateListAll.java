package hibernate;


import example_project.User;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class HibernateListAll {

    private final SessionFactory sessionFactory;


    public HibernateListAll(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<User> listAllUsers() {

        try (Session session = sessionFactory.openSession()) {
            // Создание HQL-запроса для получения всех пользователей
            String hql = "FROM User";
            Query<User> query = session.createQuery(hql, User.class);

            return query.getResultList();
        }
    }
}
