package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static String URL = "jdbc:sqlserver://localhost:1433;databaseName=gestionExpedientes;user=sa;password=admin;";
    private static String user = "admin";
    private static String password = "admin";

    
    // private static String URL = "jdbc:sqlserver://(localdb)\\\\MSSQLLocalDB;databaseName=GestionExpedientes;integratedSecurity=true;encrypt=false";// "jdbc:sqlserver://Romanl:1433;databaseName=gestionExpedientes";
    // private static final String USER = "DESKTOP-PM5E5ET/Marvin Luna";// "userAdmin1";
    // private static final String PASSWORD = ""; // "admin123";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }
}
