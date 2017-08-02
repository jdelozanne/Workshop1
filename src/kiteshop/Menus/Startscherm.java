/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiteshop.Menus;

/**
 *
 * @author julia
 */
public class Startscherm {
//hoofdmenu keuze uit diverse opties

    public static void start() {
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
                Klanten.start();
                break;
            case 2:
                System.out.println("naar menu producten");
                Producten.start();
                break;
            case 3:
                System.out.println("naar menu bestellingen");
                Bestellingen.start();
                break;
            case 4:
                System.out.println("naar menu account");
                Account.start();
                break;
            case 5:
                System.out.println("uitloggen");
                uitloggen();
                break;    
            default:
                System.out.println("Probeer opnieuw");
                start();
        }
    }    
}
