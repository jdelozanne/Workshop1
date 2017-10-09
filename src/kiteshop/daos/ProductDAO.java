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

            System.out.println("Product " + product.getNaam() + "is succesvol teogevoegd");
            
        } catch (SQLException ex) {
            ex.printStackTrace();

        }

    }

    @Override
    public Product readProduct(String productnaam) {
        Product p = new Product();
        try {
            String query = "Select * from product where productnaam = ?";
            this.statement = this.connection.prepareStatement(query);
            statement.setString(1, productnaam);

            result = statement.executeQuery();
            while (result.next()) {

                p.setProductID(result.getInt(1));
                p.setNaam(result.getString(2));
                p.setPrijs(result.getBigDecimal(3));
                p.setVoorraad(result.getInt(4));
            }

            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return p;
    }
    
    public String readProduct(int productID) {
        Product p = new Product();
        try {
            String query = "Select productnaam from product where productID = ?";
            this.statement = this.connection.prepareStatement(query);
            statement.setInt(1, productID);

            result = statement.executeQuery();
            while (result.next()) {

                p.setProductID(result.getInt(1));
                p.setNaam(result.getString(2));
                p.setPrijs(result.getBigDecimal(3));
                p.setVoorraad(result.getInt(4));
            }

            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return p.getNaam() ;
    }

    @Override
    public void updateProduct(Product product) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteProduct(Product product) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void main(String[] args) {
        new ProductDAO().readProduct("kite 12");
    }
}
