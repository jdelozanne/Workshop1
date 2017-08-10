/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiteshop.pojos;

import java.util.ArrayList;

/**
 *
 * @author julia
 */
public class Account {

    private String gebruikersnaam;
    private String wachtwoord;
    ArrayList <Account> accountLijst = new ArrayList();
    
    private static int count = 0;

    public Account() {
    }

    public void setGebruikersnaam(String s) {
        this.gebruikersnaam = s;
    }
    
    public String getGebruikersnaam(){
        return gebruikersnaam;
    }
    //eigenlijk zou je willen dat er asterix komen ipv tekens
    public void setWachtwoord(String s) {
        this.wachtwoord = s;
    }
    
    public String getWachtwoord(){
        return wachtwoord;
    }
}
