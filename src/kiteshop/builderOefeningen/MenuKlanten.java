/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiteshop.builderOefeningen;


import kiteshop.controller.Controller;
import kiteshop.controller.ControllerInterface;


import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author julia
 */
public class MenuKlanten {

	Scanner input = new Scanner(System.in);
	ControllerInterface controller = new Controller();
	
    public void start() {
        System.out.println("Kies wat je wilt doen:");
        System.out.println("Kies 1 voor Nieuwe klant maken");
        System.out.println("Kies 2 voor Klantgegevens wijzigen");
        System.out.println("Kies 3 voor Klantgegevens verwijderen");
        System.out.println("Kies 4 voor Overzicht klanten");
        System.out.println("Kies 5 voor terug naar Startscherm");
        int keuze = input.nextInt();
        
        switch (keuze) {
        case 1:
        	nieuweKlantMaken();
        	System.out.println("Wilt u nog een nieuwe klant maken Y/N");
        	if(input.next().equalsIgnoreCase("Y")){
        		nieuweKlantMaken();
        	} else {
        		start();
        	}
        	break;
        case 2:
        	ArrayList<Klant> searchResult = new ArrayList<>();
        	System.out.println("Geef alstublieft de achternaam van de klant die u wil wijzigen?");
        	
        	
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
                break; 
             // hiermee komt de methode ten einde, en valt het programma vanzelf terug naar waar hij in het hoofdmenu gebleven was
            default:
                System.out.println("Probeer opnieuw");
                start();
        }
    }
    
    
    private void nieuweKlantMaken(){
    	System.out.println("geef voornaam: ");
        String voornaam = input.next();
        System.out.println("geef tussenvoegsel: ");
        String tussenvoegsel = input.next();
        System.out.println("geef achternaam: ");
        String achternaam = input.next();

        KlantNaam.KlantNaamBuilder x = new KlantNaam.KlantNaamBuilder();

        KlantNaam naam = x.voornaam(voornaam)
                .tussenvoegsel(tussenvoegsel)
                .achternaam(achternaam)
                .build();

        KlantAdres.AdresBuilder y = new KlantAdres.AdresBuilder();

        System.out.println("geef woonplaats: ");
        String woonplaats = input.next();
        System.out.println("geef postcode: ");
        String postcode = input.next();
        System.out.println("geef straatnaam: ");
        String straatnaam = input.next();
        System.out.println("geef huisnummer: ");
        int huisnummer = input.nextInt();
        System.out.println("geef toevoeging: ");
        String toevoeging = input.next();
        System.out.println("geef emailadres: ");
        String email = input.next();
        System.out.println("geef telefoon: ");
        int telefoon = input.nextInt();

        KlantAdres adres = y.woonplaats(woonplaats)
                .postcode(postcode)
                .straatnaam(straatnaam)
                .huisnummer(huisnummer)
                .toevoeging(toevoeging)
                .email(email)
                .telefoon(telefoon)
                .build();

        Klant.KlantBuilder z = new Klant.KlantBuilder();

        Klant klant = z.klantnaam(naam)
                .adres(adres)
                .build();

        System.out.println(x.toString() + y.toString());
        
   
        
    }
    
    private void klantVerwijderenAchterNaam(){
    	 System.out.println("Geef alstublieft de achternaam van de klant die u wil wijzigen?");
    	
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
