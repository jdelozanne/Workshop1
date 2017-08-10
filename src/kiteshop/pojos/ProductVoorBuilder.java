/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiteshop.pojos;

import java.math.BigDecimal;

/**
 *
 * @author julia
 */
public class ProductVoorBuilder {

    private String naam;
    private String omschrijving;
    private BigDecimal prijs;
    private int productnummer;
    private int voorraad;

    //constructor product met als argument productbuilder
    public ProductVoorBuilder(ProductBuilder builder) {
        this.naam = builder.naam;
        this.omschrijving = builder.omschrijving;
        this.prijs = builder.prijs;
        this.voorraad = builder.voorraad;
        this.voorraad = builder.voorraad;
    }
    
    
    //statische binnenklasse builder
    public static class ProductBuilder {

    private  String naam;
    private  String omschrijving;
    private  BigDecimal prijs;
    private  int productnummer;
    private  int voorraad;
    
    public ProductBuilder(){
        
    }

    public ProductBuilder(String naam) {
        this.naam = naam;
    }

    public ProductBuilder omschrijving(String omschrijving) {
        this.omschrijving = omschrijving;
        return this;
    }

    public ProductBuilder prijs(BigDecimal prijs) {
        this.prijs = prijs;
        return this;
    }

    public ProductBuilder productnummer(int productnummer) {
        this.productnummer = productnummer;
        return this;
    }

    public ProductBuilder voorraad(int voorraad) {
        this.voorraad = voorraad;
        return this;
    }

    public ProductVoorBuilder build() {
        return new ProductVoorBuilder(this); 
    }
}
}