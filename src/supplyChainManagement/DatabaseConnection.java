package supplyChainManagement;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

    private static Connection connection;

    public static Connection getConnection() throws Exception {
        if (connection == null) {
            // Create a new connection to the database.
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/supply_chain", "root", "Mardav@14");
        }

        return connection;
    }

    private DatabaseConnection() {}
}