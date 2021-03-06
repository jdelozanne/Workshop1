/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiteshop.pojos;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 *
 * @author julia
 */
public class Bestelling {

    //ook hiervoor weer de vraag of de bestellingID niet pas in dao komt
    private int bestellingID;
    private Klant klant;
    private ArrayList<Product> bestelling;
    private BigDecimal totaalprijs;

    public Bestelling() {
        bestelling = new ArrayList<>();
    }

    public Bestelling(Klant klant) {
        bestelling = new ArrayList<>();
        this.klant = klant;

    }

    public void voegToe(Product p) {
        bestelling.add(p);
    }

    public int getBestellingID() {
        return bestellingID;
    }

    public void setBestellingID(int bestellingID) {
        this.bestellingID = bestellingID;
    }

    public Klant getKlant() {
        return klant;
    }

    public void setKlant(Klant klant) {
        this.klant = klant;
    }

    public ArrayList<Product> getBestelling() {
        return bestelling;
    }

    public void setBestelling(ArrayList<Product> bestelling) {
        this.bestelling = bestelling;
    }

    public BigDecimal getTotaalprijs() {
        return totaalprijs;
    }

    public void setTotaalprijs(BigDecimal totaalprijs) {
        this.totaalprijs = totaalprijs;
    }

}
