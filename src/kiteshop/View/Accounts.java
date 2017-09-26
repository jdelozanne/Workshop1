/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiteshop.View;

import java.util.ArrayList;
import kiteshop.pojos.Account;

/**
 *
 * @author julia en steef
 */
public class Accounts {

    public static void start() {
        System.out.println("Kies wat je wilt doen:");
        System.out.println("Kies 1 voor Nieuwe account maken");
        System.out.println("Kies 2 voor Je account wijzigen");
        System.out.println("Kies 3 voor Een account verwijderen");
        int keuze = Inlog.input.nextInt();
        switch (keuze) {
            case 1:
                maakNieuwGebruikersnaam();
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

    public static void maakNieuwGebruikersnaam() {
        Account account = new Account();
        System.out.println("Gebruikersnaam?");
        String gebruiker = Inlog.input.nextLine();
        account.setGebruikersnaam(gebruiker);
        maakNieuwWachtwoord(account);//hier of bij de switch onder maakNieuwGebruikersnaam()?
    }

    public static void maakNieuwWachtwoord(Account account) {
        System.out.println("Kies een wachtwoord minimaal 4 karakters");
        String ww = Inlog.input.nextLine();
        account.setWachtwoord(ww);
        System.out.println("Geef uw wachtwoord nogmaals en druk op enter");
        String wwControle = Inlog.input.nextLine();
        if (wwControle.equals(account.getWachtwoord())) {
            System.out.println("Nieuw account succesvol aangemaakt");
        } else {
            System.out.println("Probeer opnieuw");
            maakNieuwWachtwoord(account);
        }
    }
    
    public static void printAccount(){
        //lijst ophalen met accounts
        ArrayList <Account> accountlijst = new ArrayList<>();
        for(Account element: accountlijst){
            System.out.println(element+ "\n");
        }
    }

    public static void wijzigAccount() {
        //kies een account die je wil wijzigen
    }

    public static void verwijderAccount() {
        System.out.println("Welke account wil je verwijderen?");
        //lijst printen van database accounts met gebruikersnamen
        
        
    }
}
