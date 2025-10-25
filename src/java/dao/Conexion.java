package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=gestionExpedientes;";
    private static String user = "testuser";
    private static String password = "Test1234!";

    
    // private static String URL = "jdbc:sqlserver://Romanl:1433;databaseName=gestionExpedientes";
    // private static final String USER = "DESKTOP-PM5E5ET/Marvin Luna";// "userAdmin1";
    // private static final String PASSWORD = ""; // "admin123";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, user, password);
    }
}
