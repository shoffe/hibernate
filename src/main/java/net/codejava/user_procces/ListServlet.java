package net.codejava.user_procces;


import com.fasterxml.jackson.databind.ObjectMapper;
import example_project.User;
import hibernate.HibernateListAll;
import hibernate.HibernateUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.SessionFactory;

import java.io.IOException;
import java.util.List;
@WebServlet(urlPatterns = "/list")
public class ListServlet extends HttpServlet {

    private HibernateListAll listAll;
    private ObjectMapper objectMapper;


    @Override
    public void init() throws ServletException {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        listAll = new HibernateListAll(sessionFactory);
        objectMapper = new ObjectMapper();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<User> users = listAll.listAllUsers();
            response.setContentType("application/json");
            objectMapper.writeValue(response.getWriter(), users);
        } catch (Exception e) {
            response.setStatus(500);
            response.getWriter().println("Ошибка при получении списка" + e.getMessage());
        }



    }

}
