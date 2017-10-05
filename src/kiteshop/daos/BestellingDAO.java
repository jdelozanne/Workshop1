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
import kiteshop.pojos.Bestelling;

/**
 *
 * @author julia
 */
public class BestellingDAO implements BestellingDAOInterface {
    
    Connection connection;
    PreparedStatement statement;
    ResultSet result;

    public BestellingDAO() {
        connection = DBConnect.getConnection();
    }

    @Override
    public void createBestelling(Bestelling bestelling) {
        try {
            String sql = "INSERT INTO bestelling"
                    + "(bestellingID, klantID, bestel_regelID, totaalprijs)"
                    + "values (?,?,?,?)";
            this.statement = connection.prepareStatement(sql);
            statement.setInt(1, 0);
            statement.setInt(2, bestelling.getKlant().getKlantID());
            statement.setString(3, bestelling.getBestelling().toString());
            statement.setBigDecimal(4, bestelling.getTotaalprijs());

            statement.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();

        }
    }

    @Override
    public void readBestelling(Bestelling bestelling) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateBestelling(Bestelling bestelling) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteBestelling(Bestelling bestelling) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
