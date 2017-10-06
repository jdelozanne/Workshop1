/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiteshop.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import kiteshop.pojos.BestelRegel;
import kiteshop.pojos.Product;

/**
 *
 * @author julia
 */
public class BestelRegelDAO implements BestelRegelDAOInterface {
    
    Connection connection;
    PreparedStatement statement;

    
    public BestelRegelDAO(){
        connection = DBConnect.getConnection();
    }
    


    @Override
    public void createBestelRegel(BestelRegel regel) {
       try {
            String sql = "INSERT INTO Bestel_regel"
                    + "(bestel_regelID, productID, aantal)"
                    + "values (?,?,?)";
            this.statement = connection.prepareStatement(sql);

            statement.setInt(1, 0);
            statement.setInt(2, regel.getProduct().getProductID());
            statement.setInt(3, regel.getAantal());

            statement.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();

        }
    }

    @Override
    public void readBestelRegel(BestelRegelID regel) {
       
    }

    @Override
    public void updateBestelRegel(BestelRegel regel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteBestelRegel(BestelRegel regel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
    
      
}
