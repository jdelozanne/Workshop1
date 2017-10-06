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
import kiteshop.pojos.Product;

/**
 *
 * @author julia
 */
public class ProductDAO implements ProductDAOInterface {

    Connection connection;
    PreparedStatement statement;
    ResultSet result;

    public ProductDAO() {
        this.connection = DBConnect.getConnection();
    }

    /* (non-Javadoc)
	 * @see kiteshop.daos.ProductDAOInterface#createProduct(kiteshop.pojos.Product)
     */
    @Override
    public void createProduct(Product product) {
        try {
            String sql = "INSERT INTO product"
                    + "(idProduct, productnaam, voorraad, prijs)"
                    + "values (?,?,?,?)";
            this.statement = connection.prepareStatement(sql);
            statement.setInt(1, 0);
            statement.setString(2, product.getNaam());
            statement.setInt(3, product.getVoorraad());
            statement.setBigDecimal(4, product.getPrijs());
            statement.execute();
            
            product.setProductID(result.getInt(1));
            System.out.println("Product " + product.getNaam() + "is succesvol teogevoegd");

        } catch (SQLException ex) {
            ex.printStackTrace();

        }

    }

    @Override
    public Product readProduct(String productnaam) {
        Product p = new Product();
        try {
            String query = "Select * from Product where productnaam = ?";
            this.statement = connection.prepareStatement(query);
            statement.setString(1, productnaam);

            result = statement.executeQuery();

            p.setProductID(result.getInt(1));
            p.setNaam(result.getString(2));
            p.setPrijs(result.getBigDecimal(3));
            p.setVoorraad(result.getInt(4));

            connection.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return p;
    }

    @Override
    public void updateProduct(Product product) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteProduct(Product product) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
