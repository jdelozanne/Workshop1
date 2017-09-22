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
public class KlantNaam {

    private final String voornaam;
    private String tussenvoegsel;
    private final String achternaam;

    private KlantNaam(KlantNaamBuilder builder) {
        this.voornaam = builder.voornaam;
        this.tussenvoegsel = builder.tussenvoegsel;
        this.achternaam = builder.achternaam;
    }

    public static class KlantNaamBuilder {

        private String voornaam;
        private String tussenvoegsel;
        private String achternaam;

        public KlantNaamBuilder() {
        }

        public KlantNaamBuilder voornaam(String voornaam) {
            this.voornaam = voornaam;
            return this;
        }

        public KlantNaamBuilder tussenvoegsel(String tussenvoegsel) {
            this.tussenvoegsel = tussenvoegsel;
            return this;
        }

        public KlantNaamBuilder achternaam(String achternaam) {
            this.achternaam = achternaam;
            return this;
        }

        public KlantNaam build() {
            return new KlantNaam(this);
        }

        public void maakNieuweKlantNaam(String voornaam, String tussenvoegsel, String achternaam ) {
        }
            

        

        @Override
        public String toString() {
            return ("\nVoornaam: " + this.voornaam + " \n Tussenvoegsel: " + this.tussenvoegsel + " \n Achternaam: " + this.achternaam);
        }
    }

    @Override
    public String toString() {
        return ("\nVoornaam: " + this.voornaam + " \n Tussenvoegsel: " + this.tussenvoegsel + " \n Achternaam: " + this.achternaam);
    }

}
