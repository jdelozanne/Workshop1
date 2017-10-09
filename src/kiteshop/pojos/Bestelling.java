/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiteshop.pojos;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author julia
 */
public class Bestelling {

    //ook hiervoor weer de vraag of de bestellingID niet pas in dao komt
    private int bestellingID;
    private Klant klant;
    private List<BestelRegel> bestelregels;
    private BigDecimal totaalprijs;

    public Bestelling() {
        bestelregels = new ArrayList<>();
    }

    public Bestelling(Klant klant) {
        bestelregels = new ArrayList<>();
        this.klant = klant;
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

    public List<BestelRegel> getBestelling() {
        return bestelregels;
    }

    public void setBestelling(ArrayList<BestelRegel> bestelling) {
        this.bestelregels = bestelling;
    }

    public BigDecimal getTotaalprijs() {
        return totaalprijs;
    }

    public void setTotaalprijs(BigDecimal totaalprijs) {
        this.totaalprijs = totaalprijs;
    }
    
    public void addBestelRegel(BestelRegel b) {
        bestelregels.add(b);
    }
    public static void main(String[] args) {
        Klant klant = new Klant();
        
    }
    
    @Override
    public String toString(){
        
        String regel = null;
        for(BestelRegel b : bestelregels){
            regel += b.toString() + "\n";
        }
        return regel;
    }
    
    public BigDecimal calculatePrijs() {
        BigDecimal result = null;
        for(BestelRegel b : bestelregels){
            result = new BigDecimal(b.getAantal()).multiply(b.getProduct().getPrijs());
        }
        return this.totaalprijs = result;
    }

}
