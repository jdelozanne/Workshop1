/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiteshop.pojos;

/**
 *
 * @author julia
 */
public class Adres {

    private String woonplaats;
    private String postcode;
    private String straatnaam;
    private int huisnummer;
    private String toevoeging;
    private String email;
    private int telefoon;

    public Adres() {
    }

    public String getWoonplaats() {
        return woonplaats;
    }

    public void setWoonplaats(String woonplaats) {
        this.woonplaats = woonplaats;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getStraatnaam() {
        return straatnaam;
    }

    public void setStraatnaam(String straatnaam) {
        this.straatnaam = straatnaam;
    }

    public int getHuisnummer() {
        return huisnummer;
    }

    public void setHuisnummer(int huisnummer) {
        this.huisnummer = huisnummer;
    }

    public String getToevoeging() {
        return toevoeging;
    }

    public void setToevoeging(String toevoeging) {
        this.toevoeging = toevoeging;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelefoon() {
        return telefoon;
    }

    public void setTelefoon(int telefoon) {
        this.telefoon = telefoon;
    }
    
    @Override
    public String toString(){
        return woonplaats + " "+ postcode+ " "+straatnaam  + " "+huisnummer  + " "+ toevoeging;
    }

}
