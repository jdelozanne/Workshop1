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
public class Accounts {

    public static void start() {
        System.out.println("Kies wat je wilt doen:");
        System.out.println("Kies 1 voor Nieuwe account maken");
        System.out.println("Kies 2 voor Je account wijzigen");
        System.out.println("Kies 3 voor Een account verwijderen");
        int keuze = Start.input.nextInt();
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
        //een object?
        System.out.println("Geef gebruikersnaam: ");
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
