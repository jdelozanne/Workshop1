/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiteshop.View;

import java.util.Scanner;
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

    public void start() {
        System.out.println("Kies wat je wilt doen:");
        System.out.println("Kies 1 voor Nieuwe bestelling maken");
        System.out.println("Kies 5 voor terug naar Startscherm");
        int keuze = input.nextInt();
        input.nextLine();

        switch (keuze) {
            case 1:
                createBestelling();

            case 5:
                new HoofdMenu().start();
        }
    }

    public void createBestelling() {

        
        
        //Vraag naar de klant aan wie de bestelling gericht is
        System.out.println("Voor welke klant is deze bestelling? Geef de achternaam");

        String achternaam = input.nextLine();
        KlantDAO k = new KlantDAO();
        Klant klant = k.readKlant(achternaam);
        Bestelling bestelling = new Bestelling(klant);
        controller.createBestelling(bestelling);
    }
        
        /*vraag om toe te voegen product
        System.out.println("Welk product wilt u toevoegen aan de bestelling");

        String naamproduct = input.nextLine();
        input.nextLine();

        //Vraag om het aantal van dit specifieke product
        System.out.println("Welk aantal wilt u van dit specifieke product toevoegen aan de bestelling?");
        
        int aantal = input.nextInt();

        

        //voor productID en klantID:
        
        Product p = new ProductDAO().readProduct(naamproduct);
        int productID = p.getProductID();
        
        Klant k = new KlantDAO().readKlant(achternaam);
        int klantID = k.getKlantID();
        
        //nieuwe bestelling instantieren en opslaan in database
        Bestelling b = new Bestelling(k);
        BestellingDAO bestel = new BestellingDAO();
        bestel.createBestelling(b);
        
        BestelRegel r = new BestelRegel(p,aantal);
        
        BestelRegelDAO besteldao = new BestelRegelDAO();
        
        
        
        
        
        besteldao.createBestelRegel(r);

        //bestelregel toevoegen aan bestelling
        bestelling.addBestelRegel(r);
        
*/
       

    
}
