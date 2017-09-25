/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiteshop.daos;

import java.sql.*;

/**
 *
 * @author julia en steef
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
            

            //create a statement
            statement = connection.createStatement();

            //execute query
            String sql  = "insert into account " 
                        + "(gebruikersnaam, wachtwoord)" 
                        + "values ('admin', 'ww')";
            statement.executeUpdate(sql);
            System.out.println("insert");
            
            //result set execute
            String selectSql = "select accountID, gebruikersnaam, wachtwoord from account ";
            rs = statement.executeQuery(selectSql);
            
            //process the results set
            while (rs.next()) {
                System.out.println(rs.getInt(1));
                System.out.println(rs.getString(2));
                System.out.println(rs.getString(3));

            }
/*
            ps = connection.prepareStatement("insert into account (accountID, gebruikersnaam, wachtwoord)" + "values (?,?,?)");
            ps.setInt(1, '0');
            ps.setString(2, "admin");
            ps.setString(3, "ww");
            
            rs = ps.executeQuery("select accountID, gebruikersnaam, wachtwoord from account");
            
            while (rs.next()){
                System.out.println(rs.getInt(1) +"\t" + rs.getString(2)+"\t"+ rs.getString(3));
            }
        */     
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        }
    }

}
