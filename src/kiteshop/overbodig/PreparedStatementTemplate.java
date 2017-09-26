/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiteshop.overbodig;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import kiteshop.daos.DBConnect;
import kiteshop.pojos.Klant;

public class PreparedStatementTemplate {

    Connection connection;
    PreparedStatement prepStat;
    ResultSet rSet;

    public PreparedStatementTemplate(Connection connection) {
        
    }
    
    public void postKlant(Klant klant){
        String sql = "INSERT INTO klant (klantID, voornaam, tussenvoegsel, achternaam, email, straatnaam, huisnummer, toevoeging, postcode, woonplaats) VALUES (?,?,?,?,?,?,?,?,?,?);";
        connection = new DBConnect().connect();
        try {
            prepStat = connection.prepareStatement(sql);
            prepStat.setInt (1,0);
            prepStat.setString (2, klant.getVoornaam());
            prepStat.setString (3, klant.getTussenvoegsel());
            prepStat.setString (4, klant.getAchternaam());
            prepStat.setString (5, klant.getAdres().getEmail());
            prepStat.setString (6, klant.getAdres().getStraatnaam());
            prepStat.setInt (7, klant.getAdres().getHuisnummer());
            prepStat.setString (8, klant.getAdres().getToevoeging());
            prepStat.setString (9, klant.getAdres().getPostcode());
            prepStat.setString (10, klant.getAdres().getWoonplaats());
            
            
            prepStat.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(PreparedStatementTemplate.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void print() {
        try {
            prepStat = this.connection.prepareStatement("select * from account where accountID > ?");

            prepStat.setInt(1,3);

            rSet = prepStat.executeQuery();

            if (rSet.next()) {
                int accountid = rSet.getInt(1);
                String gebr = rSet.getString(2);
                String ww = rSet.getString(3);
                System.out.println("AccountId = " + accountid + " gebruikersnaam =  " + gebr + " wachtwoord = " + ww);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PreparedStatementTemplate.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
