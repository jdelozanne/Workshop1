/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiteshop.Menus;

import java.util.ArrayList;
import kiteshop.pojos.Klant;
import static kiteshop.pojos.Klant.voegToe;

/**
 *
 * @author julia
 */
public class Klanten {

    public void start() {
        System.out.println("Kies wat je wilt doen:");
        System.out.println("Kies 1 voor Nieuwe klant maken");
        System.out.println("Kies 2 voor Klantgegevens wijzigen");
        System.out.println("Kies 3 voor Klantgegevens verwijderen");
        System.out.println("Kies 4 voor Overzicht klanten");
        System.out.println("Kies 5 voor terug naar Startscherm");
        int keuze = Inlog.input.nextInt();
        switch (keuze) {
            case 1:
                System.out.println("Geef gegevens. Velden met * zijn verplicht");
                break;
            case 2:
                printKlanten();
                System.out.println("Van welke klant wilt u de gegevens wijzigen?");
                //door naar klantgevens
                break;
            case 3:
                //overzicht printen klanten
                printKlanten();
                verwijderenKlant();
                break;
            case 4:
                printKlanten();
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
       System.out.println("Geef klantnummer");
       int nummer = Inlog.input.nextInt();
       Klant klant = new Klant(nummer);
       voegToe(klant);
       System.out.println(klant);
   }
   
  public static void printKlanten(){
      ArrayList <Klant> klantenlijst = new ArrayList<>();
      for( Klant element : klantenlijst){
          System.out.println(element + "\n");
      }
  }
  
  public static void wijzigenKlant(){
      //klant kiezen om te wijzigen en dan gegevens wijzigen
  }
  
  public static void verwijderenKlant(){
      //klant kiezen om te verwijderen
  }
}
