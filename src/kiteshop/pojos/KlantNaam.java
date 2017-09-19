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
public class KlantNaam {
    private String voornaam;
    private String tussenvoegsel;
    private String achternaam;
    
    public KlantNaam(String voornaam, String tussenvoegsel, String achternaam){
        this.voornaam = voornaam;
        this.tussenvoegsel = tussenvoegsel;
        this.achternaam = achternaam;  
    }
    
    public String getVoornaam(){
        return this.voornaam;
    }
    public void setVoornaam(String vn){
        this.voornaam = vn;
    }
}
