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
        Klant klant1 = new Klant(1);
        Product p = new Product("kite");
        Product c = new Product ("bar");
    Bestelling order = new Bestelling();
    order.voegToe(p);
    order.voegToe(c);
    order.printLijst();
    
    
    }
    
}
