/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiteshop.pojos;

import java.util.ArrayList;

/**
 *
 * @author julia
 */
public class Klant {
    
    private String voornaam;
    private String tussenvoegsel;
    private String achternaam;
    private String emailadres;
    private int klantnummer;
    private Adres adres;
    static ArrayList <Klant> klantenLijst = new ArrayList<>();

    public Klant() {
    }
    
    public Klant(int klantNummer){ 
        this.klantnummer = klantNummer;
    }
    
    public static void voegToe(Klant klant){
        klantenLijst.add(klant);
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getTussenvoegsel() {
        return tussenvoegsel;
    }

    public void setTussenvoegsel(String tussenvoegsel) {
        this.tussenvoegsel = tussenvoegsel;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public String getEmailadres() {
        return emailadres;
    }

    public void setEmailadres(String emailadres) {
        this.emailadres = emailadres;
    }

    public int getKlantnummer() {
        return klantnummer;
    }

    public void setKlantnummer(int klantnummer) {
        this.klantnummer = klantnummer;
    }

    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }
    
    
}
