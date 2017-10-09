/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiteshop.overbodig;

import java.sql.*;

/**
 *
 * @author julia
 */
public class DatabaseConnector {

    Connection connection;
    private Statement statement;
    private PreparedStatement ps;
    private ResultSet rs;

    private static final String USERNAME = "root";
    private static final String PASSWORD = "wicked";
    private static final String CONN_URL = "jdbc:mysql://localhost:3306/juliaworkshop";

    public DatabaseConnector() {
        try {
            //upload driver
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded");

            //get a connection
            connection = DriverManager.getConnection(CONN_URL, USERNAME, PASSWORD);
            System.out.println("Database connected");
           
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        }
    }

}
