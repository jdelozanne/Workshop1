/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiteshop.View;

/**
 *
 * @author julia
 */
public class Producten {

    public void start() {
        System.out.println("Kies wat je wilt doen:");
        System.out.println("Kies 1 voor Nieuwe product maken");
        System.out.println("Kies 2 voor Een product wijzigen");
        System.out.println("Kies 3 voor Een product verwijderen");
        System.out.println("Kies 4 voor terug naar Startscherm");
        int keuze = Inlog.input.nextInt();
        switch (keuze) {
            case 1:
                maakNieuwProduct();
                break;
            case 2:
                printProduct();
                wijzigenProduct();
                break;
            case 3:
                printProduct();
                verwijderenProduct();
                break;
            case 4:
                start();
                break;
            default:
                System.out.println("Probeer opnieuw");
                start();
        }
    }

    public static void maakNieuwProduct() {
        //constructor product
    }

    public static void printProduct() {
        //print lijst met producten
    }

    public static void wijzigenProduct() {
        //print lijst product en maak een keuze welk product je wilt wijzigen
        //als alleen de eigenaar mag wijzigen verifieren met een ww
    }

    public static void verwijderenProduct() {
        //print lijst product en maak een keuze welk product je wilt verwijderen
        //als alleen de eigenaar mag wijzigen verifieren met een ww
    }
}
