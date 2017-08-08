/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiteshop.Menus;

import java.io.Console;


/**
 *
 * @author julia
 */
public class Accounts {

   static Console console = System.console();
    
    public static void start() {
        System.out.println("Kies wat je wilt doen:");
        System.out.println("Kies 1 voor Nieuwe account maken");
        System.out.println("Kies 2 voor Je account wijzigen");
        System.out.println("Kies 3 voor Een account verwijderen");
        int keuze = Inlog.input.nextInt();
        switch (keuze) {
            case 1:
                maakNieuwAccount();
                break;
            case 2:
                wijzigAccount();
                break;
            case 3:
                verwijderAccount();
                break;
            default:
                System.out.println("Probeer opnieuw");
                start();
        }
    }

    public static void maakNieuwAccount() {
        Account account = new Account();
        System.out.println("Gebruikersnaam?");
        String gebruiker = Inlog.input.nextLine();
        account.setGebruikersnaam(gebruiker);
        maakNieuwww(account);
    }
    
    public static void maakNieuwww(Account account) {   
        System.out.println("Wachtwoord?");
        String ww = Inlog.input.nextLine();
        account.setWachtwoord(ww);
        System.out.println("Geef uw ww nogmaals en druk op enter");
        String wwControle = Inlog.input.nextLine();
            if(wwControle.equals(account.getWachtwoord())){
                System.out.println("Nieuw account succesvol aangemaakt");
            }
            else {
                System.out.println("Probeer opnieuw");
                maakNieuwww(account);
            }
    }

    public static void printKlanten() {
        //for( Klant element : ArrayList Klanten
        //print
    }

    public static void wijzigAccount() {
        //kies een account die je wil wijzigen
    }

    public static void verwijderAccount() {
        //kies een account die je wil verwijderen
    }
}
