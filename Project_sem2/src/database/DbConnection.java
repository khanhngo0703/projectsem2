package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private Connection con;
    private static DbConnection dbc;

    private DbConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagement", "root", "");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            throw new RuntimeException("JDBC driver not found");
        } catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Failed to connect database");
		}
    }

    public static DbConnection getDatabaseConnection() {
        if (dbc == null) {
            dbc = new DbConnection();
        }
        return dbc;
    }

    public Connection getConnection() {
        return con;
    }

    public static void main(String[] args) {
        new DbConnection();
    }
}
