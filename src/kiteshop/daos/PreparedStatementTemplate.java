/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiteshop.daos;

import java.sql.*;


public class PreparedStatementTemplate {

    private final String USERNAME = "root";
    private final String PASSWORD = "wicked";
    private final String DB_URL = "jdbc:mysql://localhost:3306/juliaworkshop";
    Connection connection;
    PreparedStatement prepStat;
    ResultSet rSet;
    public PreparedStatementTemplate() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        
            prepStat = connection.prepareStatement("select * from account where accountID > ?");
            
            prepStat.setInt(1, 3);
            
            rSet = prepStat.executeQuery();
            
            if(rSet.next()){
                int accountid = rSet.getInt(1);
                String gebr = rSet.getString(2);
                String ww = rSet.getString(3);
                System.out.println("AccountId = " + accountid + " gebruikersnaam =  " + gebr +" wachtwoord = "+ ww);
            }
        
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
