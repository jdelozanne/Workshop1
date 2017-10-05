/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiteshop.View;

import java.util.Scanner;
import kiteshop.controller.BestellingenController;

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
        Bestel
    }
}
