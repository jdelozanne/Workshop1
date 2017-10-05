/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiteshop.View;

import java.util.Scanner;
import kiteshop.controller.BestellingenController;
import kiteshop.daos.BestelRegelDAO;
import kiteshop.pojos.BestelRegel;
import kiteshop.pojos.Bestelling;
import kiteshop.pojos.Product;

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
                
                switch(keuze){
                    case 1: createBestelling();
                    
                    case 5: new HoofdMenu().start();
                }
}
    public void createBestelling(){
        //vraag om toe te voegen product
        System.out.println("Welk product wilt u toevoegen aan de bestelling");
        //verwerk input productnaam naar productID
       Product choosenProduct = new Product();
       String naamproduct = input.nextLine();
       input.nextLine();
        //Vraag om het aantal van dit specifieke product
        System.out.println("Welk aantal wilt u van dit specifieke product toevoegen aan de bestelling?");
        //verwerk input van aantal int
        int aantal = input.nextInt();
        //nieuwe regel instantieren
        BestelRegel bestelregel = new BestelRegel(choosenProduct, aantal);
        //nieuwe bestelling instantieren
        Bestelling bestelling = new Bestelling();
        //bestelregel toevoegen aan bestelling
        bestelling.addBestelRegel(bestelregel);
        BestelRegelDAO b = new BestelRegelDAO();
        b.createBestelRegel(bestelregel);
        
        
        
    }
}
