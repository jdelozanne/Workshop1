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
public class testDB {

    Connection connection;
    private Statement statement;
    private PreparedStatement ps;
    private ResultSet rs;

    private static final String USERNAME = "root";
    private static final String PASSWORD = "wicked";
    private static final String CONN_URL = "jdbc:mysql://localhost:3306/juliaworkshop";

    public testDB() {
        try {
            //upload driver
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded");

            //get a connection
            connection = DriverManager.getConnection(CONN_URL, USERNAME, PASSWORD);
            System.out.println("Database connected");
            
            //create preparedStatement
            ps = connection.prepareStatement("insert into account (accountID, gebruikersnaam, wachtwoord)" + "values (?,?,?)");
            ps.setInt(1, '1');
            ps.setString(2, "julia");
            ps.setString(3, "ww1");
            
            //wijziging doorvoeren mysql
            ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
