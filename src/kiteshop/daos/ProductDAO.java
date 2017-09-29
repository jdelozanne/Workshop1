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
public class ProductDAO {

    Connection connection;
    PreparedStatement statement;

    public ProductDAO() {
        this.connection = DBConnect.getConnection();
    }

    public void postNieuwProduct(Product product) {
        try {
            String sql = "INSERT INTO product"
                    + "(idProduct, productnaam, omschrijving, prijs)"
                    + "values (?,?,?,?)";
            this.statement = connection.prepareStatement(sql);
            statement.setInt(1, 0);
            statement.setString(2, product.getNaam());
            statement.setString(3, product.getOmschrijving());
            statement.setBigDecimal(4, product.getPrijs());

            statement.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();

        }

    }

}
