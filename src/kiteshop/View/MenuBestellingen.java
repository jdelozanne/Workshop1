/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiteshop.View;

import java.util.Scanner;
import kiteshop.controller.BestelRegelController;
import kiteshop.controller.BestellingenController;
import kiteshop.daos.*;

import kiteshop.pojos.*;

/**
 *
 * @author julia
 */
public class MenuBestellingen {

    private Scanner input = new Scanner(System.in);

    BestellingenController controller = new BestellingenController();
    BestelRegelController controller2 = new BestelRegelController();

    public void start() {
        System.out.println("Kies wat je wilt doen:");
        System.out.println("Kies 1 voor Nieuwe bestelling maken");
        System.out.println("Kies 5 voor terug naar Startscherm");
        int keuze = input.nextInt();
        input.nextLine();

        switch (keuze) {
            case 1:
                createBestelling();
                System.out.println("voeg bestelregels toe aan de bestelling");
                

            case 5:
                new HoofdMenu().start();
        }
    }

    public void createBestelling() {
       int id;

        //Vraag naar de klant aan wie de bestelling gericht is
        System.out.println("Voor welke klant is deze bestelling? Geef de achternaam");

        String achternaam = input.nextLine();
        KlantDAO k = new KlantDAO();
        Klant klant = k.readKlant(achternaam);
        Bestelling bestelling = new Bestelling(klant);
        id = controller.createBestelling(bestelling);
        
        System.out.println("Wilt u iets toevoegen aan de bestelling? J/N");
                if (input.nextLine().equalsIgnoreCase("J")){
                   createBestelRegel(id);      
                }
                else new HoofdMenu().start();
    }

    public void createBestelRegel(int bestellingID) {

        System.out.println("Welk product wilt u toevoegen aan de bestelling");
        String productnaam = input.nextLine();
        Product p = new ProductDAO().readProduct(productnaam);
        
        System.out.println("Hoeveel stuks wilt u van dit specifieke product toevoegen?");
        int aantal = input.nextInt();
        input.nextLine();
        
        BestelRegel b = new BestelRegel(bestellingID, p, aantal);
        
        
        controller2.createBestelRegel(b);
        
        System.out.println("Wilt u (nog)iets toevoegen aan de bestelling? J/N");
                if (input.nextLine().equalsIgnoreCase("J")){
                   createBestelRegel(bestellingID);      
                }
                else new HoofdMenu().start();
        
    }
    public static void main(String[] args) {
        
   
    new MenuBestellingen().createBestelRegel(3);
 }
    
}
