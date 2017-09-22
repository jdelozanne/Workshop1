/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiteshop.View;

import java.util.ArrayList;
import kiteshop.klantbuilder.*;

/**
 *
 * @author julia
 */
public class MenuKlanten {

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
                System.out.println("geef voornaam: ");
                String voornaam = Inlog.input.next();
                System.out.println("geef tussenvoegsel: ");
                String tussenvoegsel = Inlog.input.next();
                System.out.println("geef achternaam: ");
                String achternaam = Inlog.input.next();

                KlantNaam.KlantNaamBuilder x = new KlantNaam.KlantNaamBuilder();
                       x.voornaam(voornaam)
                        .tussenvoegsel(tussenvoegsel)
                        .achternaam(achternaam)
                        .build();
                System.out.println("nieuwe klantnaam is: " + x.toString());
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
                start();
                break;
            default:
                System.out.println("Probeer opnieuw");
                start();
        }
    }

    public static void printKlanten() {
        ArrayList<Klant> klantenlijst = new ArrayList<>();
        for (Klant element : klantenlijst) {
            System.out.println(element + "\n");
        }
    }

    public static void wijzigenKlant() {
        //klant kiezen om te wijzigen en dan gegevens wijzigen
    }

    public static void verwijderenKlant() {
        //klant kiezen om te verwijderen
    }
}
