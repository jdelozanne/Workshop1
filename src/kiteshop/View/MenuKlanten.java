/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiteshop.View;


import kiteshop.controller.Controller;
import kiteshop.controller.ControllerInterface;
import kiteshop.pojos.*;

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
			System.out.println("Wilt u nog een nieuwe klant maken J/N");
			if(input.next().equalsIgnoreCase("J")){
				nieuweKlantMaken();
			} else {
				start();
			}
			break;
		case 2:  
			/* geimplenteerd nu voor zoeken op achternaam (wellicht in de toekomst meer opties) omdat 
			 * er meerdere klanten kunnen zijn met dezelfde achternaam
			 */
			klantVerwijderenAchterNaam();
			System.out.println("Wilt u nog een een klant verwijderen J/N");
			if(input.next().equalsIgnoreCase("J")){
				klantVerwijderenAchterNaam();
			} else {
				start();
			}
			break;
		case 3:

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
		
		// om toch het 'teveel strings in contructor' te vermijden, alles met setters gedaan
		// neemt wel iets meer plaats in
		
		Klant klant = new Klant();

		System.out.println("geef voornaam: ");
		String voornaam = input.next();
		klant.setVoornaam(voornaam);
		
		System.out.println("geef tussenvoegsel: ");
		String tussenvoegsel = input.next();
		klant.setTussenvoegsel(tussenvoegsel);
		
		System.out.println("geef achternaam: ");
		String achternaam = input.next();
		klant.setAchternaam(achternaam);
		
		System.out.println("geef emailadres: ");
		String email = input.next();
		klant.setEmail(email);
				
		System.out.println("geef telefoon: ");
		String telefoonnr = input.next();
		klant.setTelefoonnummer(telefoonnr);

		Adres adres = new Adres();

		System.out.println("geef woonplaats: ");
		String woonplaats = input.next();
		adres.setWoonplaats(woonplaats);

		System.out.println("geef postcode: ");
		String postcode = input.next();
		adres.setPostcode(postcode);

		System.out.println("geef straatnaam: ");
		String straatnaam = input.next();
		adres.setStraatnaam(straatnaam);
		
		int huisnummer = geefHuisnummer();
		
		
		System.out.println("geef toevoeging: ");
		String toevoeging = input.next();
		adres.setToevoeging(toevoeging);
		
		klant.setAdres(adres);
		
		controller.addKlant(klant);

	}

	private void klantVerwijderenAchterNaam(){
		System.out.println("Geef alstublieft de achternaam van de klant die u wilt verwijderen?");
		ArrayList<Klant> searchResult = controller.showKlantenAchternaam(input.next());

		System.out.println("De volgende klanten zijn gevonden, geeft u alstublieft het nummer van de klant die u wil verwijderen");
		for(int i = 0; i < searchResult.size(); i++ ){
			// arraylist begint op 0, maar ik laat de klant kiezen vanaf 1, moet later wel weer terugrekenen
			System.out.println(i+1 +" "+ searchResult.get(i));
		}
		Klant choosenKlant = searchResult.get(input.nextInt()-1);
		System.out.println("Weet u zeker dat u de volgende klant wil verwijderen: "+ choosenKlant + "J/N");
		if(input.next().equalsIgnoreCase("J")){
			controller.removeKlant(choosenKlant);

		} else {
			System.out.println("De klant is niet verwijderd");
		}

	}

	private int geefHuisnummer(){
		int huisnummer = 0;
		System.out.println("geef huisnummer: ");  // ik heb hem hier twee pogingen gegeven, anders moet het een aparte methoede worden
		String tempHuisnummer = input.next();
		try {
			huisnummer = Integer.parseInt(tempHuisnummer);
		} catch (NumberFormatException e) {
			System.out.println("Je hebt geen nummer in getoetst, probeer opnieuw");
			geefHuisnummer();
		}
		return huisnummer;
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
	
	public static void main (String args[]){
		new MenuKlanten().geefHuisnummer();
	}
	
	
}
