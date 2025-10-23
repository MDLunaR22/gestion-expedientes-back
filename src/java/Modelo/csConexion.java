package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class csConexion {
    private static final String URL = "jdbc:sqlserver://Romanl:1433;databaseName=gestionExpedientes";
    private static final String USER = "userAdmin1";
    private static final String PASSWORD = "admin123";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
