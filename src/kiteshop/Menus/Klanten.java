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
public class Klanten {

    public static void start() {
        System.out.println("Kies wat je wilt doen:");
        System.out.println("Kies 1 voor Nieuwe klant maken");
        System.out.println("Kies 2 voor Klantgegevens wijzigen");
        System.out.println("Kies 3 voor Klantgegevens verwijderen");
        System.out.println("Kies 4 voor Overzicht klanten");
        System.out.println("Kies 5 voor terug naar Startscherm");
        int keuze = Start.input.nextInt();
        switch (keuze) {
            case 1:
                maakNieuweKlant();
                break;
            case 2:
                //overzicht printen klanten
                System.out.println("Van welke klant wilt u de gegevens wijzigen?");
                //door naar klantgevens
                break;
            case 3:
                //overzicht printen klanten
                System.out.println("Van welke klant wilt u de gevens verwijderen?");
                //door naar klant
                verwijderKlant();
                break;
            case 4:
                //overzicht printen klanten
                break;
            case 5:
                Startscherm.start();
                break; 
            default:
                System.out.println("Probeer opnieuw");
                start();
        }
    }
    
   public static void maakNieuweKlant(){
       /*nieuwe klant als object maken? 
       naam, adres, email, telefoon
       */
       
       
   }
}
