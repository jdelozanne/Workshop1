/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiteshop.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import kiteshop.pojos.Account;

/**
 *
 * @author julia
 */
public class AccountDAO {

    Connection connection;
    PreparedStatement statement;
    Statement state;

    public AccountDAO() {
        this.connection = DBConnect.getConnection();
    }

    public void postNieuwAccount(Account account) {
        try {
            String sql = "INSERT INTO account"
                    + "(accountID, gebruikersnaam, wachtwoord)"
                    + "values (?,?,?)";
            this.statement = connection.prepareStatement(sql);

            statement.setInt(1, 0);
            statement.setString(2, account.getGebruikersnaam());
            statement.setString(3, account.getWachtwoord());

            statement.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();

        }

    }

    public void controleerInlog(String gebruiker, String ww) {
        try {
            String sqlQuery = "SELECT wachtwoord FROM account WHERE gebruikersnaam = gebruikersnaam";

           state = connection.createStatement();

            ResultSet result = state.executeQuery(sqlQuery);
            while(result.next()){
                System.out.println(result.getString(1));
                
            }
            
            

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        
    }

}
