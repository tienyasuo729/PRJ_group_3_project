package org.example.shipping_services_for_everyone.connection_config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseRepositoryJDBC {
    private String jdbcUrl = "jdbc:sqlserver://localhost:3306/shipping_project";
    private String username = "root";
    private String password = "12345";
    private Connection connection;

    public BaseRepositoryJDBC() {

    }

    public Connection getConnectionJavaToDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(jdbcUrl, username, password);
            return connection;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
