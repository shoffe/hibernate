package example_project;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Properties {
    private Connection connection;

    {
        try {
            Statement statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
