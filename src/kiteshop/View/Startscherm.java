/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiteshop.View;

import kiteshop.pojos.Account;

/**
 *
 * @author julia
 */
public class Startscherm {
//hoofdmenu keuze uit diverse opties

    public void start() {
        System.out.println("Maak uw keuze:");
        System.out.println("Kies 1 Klanten");
        System.out.println("Kies 2 Producten");
        System.out.println("Kies 3 Bestellingen");
        System.out.println("Kies 4 Account");
        System.out.println("Kies 5 Uitloggen");
        int keuze = Inlog.input.nextInt();
        switch (keuze) {
            case 1:
                System.out.println("naar menu klanten");
                MenuKlanten klanten = new MenuKlanten();
                klanten.start();
                break;
            case 2:
                System.out.println("naar menu producten");
                
                break;
            case 3:
                System.out.println("naar menu bestellingen");
                
                break;
            case 4:
                System.out.println("naar menu account");
                
                break;
            case 5:
                System.out.println("uitloggen");
                this.uitloggen();
                break;
            default:
                System.out.println("Probeer opnieuw");
                start();
        }
    }

    public void uitloggen() {
        System.out.println("Weet u zeker dat u wilt afsluiten?\n Toets 1 voor ja\n Toets 2 om in het programma te blijven");
        if (Inlog.input.nextInt() == 1) {
            System.exit(0);
        } else {
            start();
        }
    }
}
