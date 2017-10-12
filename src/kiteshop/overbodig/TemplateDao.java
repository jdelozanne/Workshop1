package kiteshop.overbodig;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class TemplateDao {

    //set values needed for databaseconnection
    private final String USERNAME = "root";
    private final String PASSWORD = "wicked";
    private final String DB_URL = "jdbc:mysql://localhost:3306/juliaworkshop";
    
    
    private Connection connection;

    //load driver and manually add JARfile to project library
    public void loadDriver() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    //make a connection with specific database
    public void connectToDatabase() {
        try {
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            System.out.println("DB connected");

            //prepare a PreparedStatement
            //to select data
            String querySQL = "select * from account where account.gebruikernaam = admin";
            //to insert data
            String insertData = "insert into account (accountID, gebruikersnaam, wachtwoord)" + "values (?,?,?)";
            
            
            } catch (Exception ex1) {
            ex1.printStackTrace();
        }
    }
    public void deleteRows(){
        try {
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            String sqlDelete = "delete from account where accountID > '8'";
            int rowsAffected = statement.executeUpdate(sqlDelete);
            System.out.println("number of rows affected " + rowsAffected);
            System.out.println("delete completed");
        } catch (SQLException ex) {
            Logger.getLogger(TemplateDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void setParameters(){
        try {
            //set parameters to insert
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            PreparedStatement pstat = connection.prepareStatement("select * from account" + "where accountID = ?");
            pstat.setInt(1, '0');
            
            
            //execute given inserts
            ResultSet rset = pstat.executeQuery();
            
            //execute selected data preparedStatement.executeQuery();
            
        } catch (SQLException ex2) {
            ex2.printStackTrace();
        }
    }
        
}
