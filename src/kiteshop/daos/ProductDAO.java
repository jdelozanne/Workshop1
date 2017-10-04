/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiteshop.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import kiteshop.pojos.Product;

/**
 *
 * @author julia
 */
public class ProductDAO implements ProductDAOInterface {

    Connection connection;
    PreparedStatement statement;

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
                    + "(idProduct, productnaam, prijs, voorraad)"
                    + "values (?,?,?,?)";
            this.statement = connection.prepareStatement(sql);
            statement.setInt(1, 0);
            statement.setString(2, product.getNaam());
            statement.setBigDecimal(3, product.getPrijs());
            statement.setInt(4, product.getVoorraad());

            statement.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();

        }

    }

    @Override
    public void readProduct(Product product) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
