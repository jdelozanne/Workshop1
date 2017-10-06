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

        switch (keuze) {
            case 1:
                createBestelling();

            case 5:
                new HoofdMenu().start();
        }
    }

    public void createBestelling() {

        Bestelling bestelling = new Bestelling();

        //vraag om toe te voegen product
        System.out.println("Welk product wilt u toevoegen aan de bestelling");

        String naamproduct = input.nextLine();
        input.nextLine();

        //Vraag om het aantal van dit specifieke product
        System.out.println("Welk aantal wilt u van dit specifieke product toevoegen aan de bestelling?");
        
        int aantal = input.nextInt();

        //Vraag naar de klant aan wie de bestelling gericht is
        System.out.println("Voor welke klant is deze bestelling? Geef de achternaam");

        String achternaam = input.nextLine();

        //voor productID en klantID:
        
        Product p = new ProductDAO().readProduct(naamproduct);
        int productID = p.getProductID();
        
        Klant k = new KlantDAO().readKlant(achternaam);
        int klantID = k.getKlantID();
        
        //nieuwe bestelling en bestelregel instantieren
        Bestelling b = new Bestelling();
        b.setKlant(k);
        
        BestelRegel r = new BestelRegel(p,aantal);
        
        BestelRegelDAO besteldao = new BestelRegelDAO();
        
        
        BestellingDAO bestel = new BestellingDAO();
        
        bestel.createBestelling(b);
        besteldao.createBestelRegel(r);

        //bestelregel toevoegen aan bestelling
        bestelling.addBestelRegel(r);
        
       

    }
}
