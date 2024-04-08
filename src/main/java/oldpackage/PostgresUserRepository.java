//package example_project.repository;
//
//import example_project.User;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
//public class PostgresUserRepository implements UserRepository {
//
//    @Override
//    public List<User> findAll() {
//        String SQL_PRINT = "SELECT * FROM users_table_one";
//        try (Connection connection = ConnectionUtil.getConnection();
//             Statement statement = connection.createStatement()) {
//            ResultSet resultSet = statement.executeQuery(SQL_PRINT);
//
//            List<User> users = new ArrayList<>();
//
//            while (resultSet.next()) {
//                int id = resultSet.getInt("id");
//                String name = resultSet.getString("nickname");
//                int age = resultSet.getInt("age");
//                String race = resultSet.getString("race");
//
//                User user = new User(id, name, age, race);
//                users.add(user);
//            }
//
//            return users;
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//
//            return Collections.emptyList();
//        }
//    }
//
//    @Override
//    public User save(User user) {
//        String SQL_SEND = "INSERT INTO users_table_one (nickname, age, race) values (?, ?, ?);";
//        try (Connection connection = ConnectionUtil.getConnection();
//             PreparedStatement statement = connection.prepareStatement(SQL_SEND, Statement.RETURN_GENERATED_KEYS)) {
//
//            statement.setString(1, user.getName());
//            statement.setInt(2, user.getAge());
//            statement.setString(3, user.getRace());
//
//            statement.executeUpdate();
//            ResultSet generatedKeys = statement.getGeneratedKeys();
//            if (generatedKeys.next()) {
//                user.setId(generatedKeys.getInt(1));
//            }
//
//            return user;
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Override
//    public List<User> saveAll(List<User> users) {
//        List<User> savedUsers = new ArrayList<>();
//
//        for (User user : users) {
//            User save = save(user);
//            savedUsers.add(save);
//        }
//
//        return savedUsers;
//    }
//
//    @Override
//    public boolean delete(int id) {
//        String SQL_DELETE = "DELETE FROM users_table_one WHERE id = ?";
//        try (Connection connection = ConnectionUtil.getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE)) {
//            preparedStatement.setInt(1, id);
//            int deletedRowsCount = preparedStatement.executeUpdate();
//
//            return deletedRowsCount > 0;
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Override
//    public User update(User user) {
//        throw new UnsupportedOperationException("Этот функционал ещё в разработке");
//    }
//
//    @Override
//    public User findById(int id) {
//        throw new UnsupportedOperationException("Этот функционал ещё в разработке");
//    }
//}
