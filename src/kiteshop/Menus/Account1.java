/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiteshop.Menus;

/**
 *
 * @author julia
 */
public class Account1 {
    private String gebruikersnaam;
    private String wachtwoord;
    private String klantnummer ="000";
    private static int count = 0;

    public Account1() {
        count++;
        this.klantnummer = klantnummer + count;
        System.out.println("Geef uw gebruikersnaam en druk op enter");
        this.gebruikersnaam = Inlog.input.nextLine();
        System.out.println("Geef uw ww en druk op enter");
        this.wachtwoord = Inlog.input.nextLine();
        System.out.println("Geef uw ww nogmaals en druk op enter");
        String wwControle = Inlog.input.nextLine();
            if(wwControle.equals(this.wachtwoord)){
                System.out.println("Nieuw account succesvol aangemaakt");
            }
            else {
                System.out.println("Probeer opnieuw");
                
            }
    }

    public String getGebruikersnaam() {
        return gebruikersnaam;
    }

    public void setGebruikersnaam(String gebruikersnaam) {
        this.gebruikersnaam = gebruikersnaam;
    }

    public String getWachtwoord() {
        return wachtwoord;
    }

    public void setWachtwoord(String wachtwoord) {
        this.wachtwoord = wachtwoord;
    }

    public String getKlantnummer() {
        return klantnummer;
    }

    public void setKlantnummer(String klantnummer) {
        this.klantnummer = klantnummer;
    }
    
    
    
}
