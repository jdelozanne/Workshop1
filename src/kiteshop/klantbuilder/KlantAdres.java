/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiteshop.klantbuilder;

import kiteshop.View.Inlog;

/**
 *
 * @author julia
 */
public class KlantAdres {

    private final String woonplaats;
    private final String postcode;
    private final String straatnaam;
    private final int huisnummer;
    private String toevoeging;
    private String email;
    private int telefoon;

    private KlantAdres(AdresBuilder builder) {
        this.woonplaats = builder.woonplaats;
        this.postcode = builder.postcode;
        this.straatnaam = builder.straatnaam;
        this.huisnummer = builder.huisnummer;
        this.toevoeging = builder.toevoeging;
        this.email = builder.email;
        this.telefoon = builder.telefoon;
    }

    public static class AdresBuilder {

        private String woonplaats;
        private String postcode;
        private String straatnaam;
        private int huisnummer;
        private String toevoeging;
        private String email;
        private int telefoon;

        public AdresBuilder() {
        }

        public AdresBuilder woonplaats(String woonplaats) {
            this.woonplaats = woonplaats;
            return this;
        }

        public AdresBuilder postcode(String postcode) {
            this.postcode = postcode;
            return this;
        }

        public AdresBuilder straatnaam(String straatnaam) {
            this.straatnaam = straatnaam;
            return this;
        }

        public AdresBuilder huisnummer(int huisnummer) {
            this.huisnummer = huisnummer;
            return this;
        }

        public AdresBuilder toevoeging(String toevoeging) {
            this.toevoeging = toevoeging;
            return this;
        }

        public AdresBuilder email(String email) {
            this.email = email;
            return this;
        }

        public AdresBuilder telefoon(int telefoon) {
            this.telefoon = telefoon;
            return this;
        }

        public KlantAdres build() {
            return new KlantAdres(this);
        }
        
        public void maakNieuwAdres() {

            System.out.println("geef woonplaats: ");
            woonplaats(Inlog.input.next());
            System.out.println("geef postcode: ");
            postcode(Inlog.input.next());
            System.out.println("geef straatnaam: ");
            straatnaam(Inlog.input.next());
            System.out.println("geef huisnummer: ");
            huisnummer(Inlog.input.nextInt());
            System.out.println("geef toevoeging: ");
            toevoeging(Inlog.input.next());
            System.out.println("geef emailadres: ");
            email(Inlog.input.next());
            System.out.println("geef telefoon: ");
            telefoon(Inlog.input.nextInt());

        }

    }

    @Override
    public String toString() {
        return ("\n Woonplaats:" + this.woonplaats + "\n Postcode: " + this.postcode + "\n Straatnaam: " + this.straatnaam + "\n Huisnummer: " + this.huisnummer + "\n Toevoeging: " + this.toevoeging + "\n Emailadres: " + this.email + "\n Telefoon: " + this.telefoon);
    } 

}
