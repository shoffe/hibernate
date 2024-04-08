package net.codejava.user_procces;

import hibernate.HibernateDeleteUser;
import hibernate.HibernateUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.SessionFactory;

import java.io.IOException;


@WebServlet(urlPatterns = {"/delete"})
public class DeleteServlet extends HttpServlet {
    private HibernateDeleteUser hibernateDeleteUser;

    @Override
    public void init() throws ServletException {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        hibernateDeleteUser = new HibernateDeleteUser(sessionFactory);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            String userId = request.getParameter("userId");
            int id = Integer.parseInt(userId);

            hibernateDeleteUser.deleteUser(id);

            response.getWriter().println("Пользователь с ID " + userId + " удалён.");


        } catch (NumberFormatException e) {
            response.getWriter().println("Неверный формат ID пользователя.");
            throw new RuntimeException(e);
        } catch (Exception e) {
            response.getWriter().println("Ошибка при удалении пользователя: " + e.getMessage());
        }
        response.setStatus(201);
    }

}
