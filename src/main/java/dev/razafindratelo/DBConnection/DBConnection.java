package dev.razafindratelo.DBConnection;

import lombok.Getter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Getter
public class DBConnection {
    private Connection connection;
    private String url = "jdbc:postgresql://localhost:5432/student_portal";
    private String user = "postgres";
    private String password = "razafindratelo";

    public DBConnection() {
        try {
            Class.forName("org.postgresql.Driver");

            connection = DriverManager.getConnection(url, user, password);
            System.out.println(" +++ Connection to database established successfully ! +++ ");

        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found.");

        } catch (SQLException e) {
            System.out.println(" !!! Connection to database failed !!! ");
        }
    }
    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println(" +++ Connection closed successfully ! +++ ");
            }
        } catch (SQLException e) {
            System.out.println(" !!! Failed to close connection !!! ");
        }
    }
}
