/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiteshop.pojos;

/**
 *
 * @author julia
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    ProductVoorBuilder builder = new ProductVoorBuilder.ProductBuilder()
        .omschrijving("dit is een vlieger van het merk Cabrinha, type Drifter, maat 7")
    .voorraad(2)
    .build();
    
    }
    
}
