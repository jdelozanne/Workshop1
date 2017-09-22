/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiteshop.klantbuilder;

/**
 *
 * @author julia
 */
public class Klant {
    private final KlantNaam klantnaam;
    private final KlantAdres adres;
    
    //constructor klant met klantbuilder als argument
    public Klant(KlantBuilder builder){
        this.klantnaam = builder.klantnaam;
        this.adres = builder.adres;
    }
    //static innerclass
    public static class KlantBuilder{
    private KlantNaam klantnaam;
    private KlantAdres adres;
    
    public KlantBuilder(){
    }
    
    public KlantBuilder klantnaam(KlantNaam klantnaam){
        this.klantnaam = klantnaam;
        return this;
    }
    
    public KlantBuilder adres(KlantAdres adres){
        this.adres = adres;
        return this;
    }
    public Klant build(){
        return new Klant(this);
    }
    
    @Override
    public String toString(){
        return ("Klantgevens: " + this.klantnaam + this.adres);
    }
    }
    
    @Override
    public String toString(){
        return ("Klantgevens: " + this.klantnaam + this.adres);
    }
}
