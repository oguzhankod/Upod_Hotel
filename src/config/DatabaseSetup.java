package config;
import queries.SQLQueries;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseSetup {
    public static void createTables() throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement()) {

            stmt.executeUpdate(SQLQueries.CREATE_ROOMS_TABLE);
            stmt.executeUpdate(SQLQueries.CREATE_CUSTOMERS_TABLE);
            stmt.executeUpdate(SQLQueries.CREATE_RESERVATIONS_TABLE);
        }
    }
}

