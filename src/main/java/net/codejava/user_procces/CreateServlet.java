package net.codejava.user_procces;

import com.fasterxml.jackson.databind.ObjectMapper;
import example_project.User;
import hibernate.HibernateCreateUser;
import hibernate.HibernateUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.SessionFactory;

import java.io.BufferedReader;
import java.io.IOException;
@WebServlet (urlPatterns = {"/create"})
public class CreateServlet extends HttpServlet {
    private HibernateCreateUser createUser;
    ObjectMapper objectMapper = new ObjectMapper(); //Создаём объект ObjectMapper из библ Jackson для объектов Java -> JSON

    @Override
    public void init() throws ServletException {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        createUser = new HibernateCreateUser(sessionFactory);
        objectMapper = new ObjectMapper();
    }

    @Override
    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException {

        try {
            // Чтение тела запроса в строку
            StringBuilder buffer = new StringBuilder();
            BufferedReader reader = request.getReader();
            String line;
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }

            String requestBody = buffer.toString();

            //Парсинг JSON строки в объект User
            User user = objectMapper.readValue(requestBody, User.class);

            //Сохранение пользователя и отправка ответа
            createUser.createUser(user);
            response.setStatus(201);
            response.setContentType("application/json"); // Установка типа контента ответа
            objectMapper.writeValue(response.getWriter(), user); // Запись объекта User в ответ в формате JSON

        } catch (Exception e) {
            response.setStatus(500); // Internal Server Error
            response.getWriter().println("Ошибка при создании пользователя: " + e.getMessage());
            e.printStackTrace();

        }


    }
}
