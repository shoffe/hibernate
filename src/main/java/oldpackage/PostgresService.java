//package example_project;
//
//import java.sql.Connection;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//public class PostgresService {
//    private final Connection connection;
//
//
//    private static final String CREATE_TABLE_QUERY =
//            "CREATE TABLE IF NOT EXISTS users_table_one (" +
//                    "id SERIAL PRIMARY KEY," +
//                    "nickname VARCHAR(50)," +
//                    "age INT," +
//                    "race VARCHAR(60)" +
//                    ")";
//
//
//    private PostgresService(Connection connection) {
//        this.connection = connection;
//    }
//
//    public static void createTable() {
//        try (Connection connection = ConnectionUtil.getConnection();
//             Statement statement = connection.createStatement()) {
//            statement.executeUpdate(CREATE_TABLE_QUERY);
//            System.out.println("Таблица успешно создана.");
//        } catch (SQLException e) {
//            System.err.println("Ошибка при подключении к базе данных или создании таблицы: " + e.getMessage());
//            e.printStackTrace();
//        }
//    }
//
////    public static void updateInfo(User) {
////        String SQL_CHANGE = ""
////        try (Connection connection = ConnectionUtil.getConnection();
////             PreparedStatement preparedStatement = connection.prepareStatement(SQL_CHANGE)) {
////
////
////        }
////
////    }
//}
//
//
