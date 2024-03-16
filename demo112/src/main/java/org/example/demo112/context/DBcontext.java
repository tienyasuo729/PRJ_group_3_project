/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.demo112.context;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBcontext {

    private String jdbcUrl = "jdbc:sqlserver://localhost:3306/shipping_project";
    private String username = "root";
    private String password = "12345";
    private Connection connection;

    public DBcontext() {

    }

    public Connection getConnection() {
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

