/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiteshop.klantbuilder;

/**
 *
 * @author julia
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Adres x = new Adres.AdresBuilder()
                .woonplaats("Amsterdam")
                .postcode("1093EA")
                .straatnaam("Wagenaarstraat")
                .huisnummer(442)
                .email("jdelozanne@gmail.com")
                .build();

        KlantNaam naam = new KlantNaam.KlantNaamBuilder()
                .voornaam("Julia")
                .tussenvoegsel("de")
                .achternaam("Lozanne")
                .build();

        Klant klant = new Klant.KlantBuilder()
                .klantnaam(naam)
                .adres(x)
                .build();
        System.out.println(klant.toString());
    }

}
