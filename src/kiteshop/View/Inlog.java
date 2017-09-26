/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiteshop.View;

import java.util.Scanner;

import kiteshop.controller.*;
import kiteshop.pojos.Account;

/**
 *
 * @author julia
 */
public class Inlog {
	
	ControllerInterface controller = new Controller();
    
public static Scanner input = new Scanner(System.in);
//inloggegevens opvragen, invoeren en controleren vanaf database? Dus al direct connectie maken?
    public void inloggen() {
        System.out.println("Geef uw gebruikersnaam: ");
        String user = input.nextLine();
        System.out.println("Geef uw wachtwoord: ");
        String ww = input.nextLine();
        
        ControllerInterface controller = new Controller();
    
        if(controller.checkLogin(user, ww)){
        	new Startscherm().start();
        } else {
        	System.out.println("Onjuiste gegevens, probeer opnieuw");
            inloggen();
        }
        
        /*
        if (user.equals(account.getGebruikersnaam()) && ww.equals(account.getWachtwoord())){
            //door naar het hoofdmenu van he programma
            System.out.println("programma start");
        } else {
            System.out.println("Onjuiste gegevens, probeer opnieuw");
            inloggen();
        }
        */

    }
    
    public static void main (String args[]){
    	new Inlog().inloggen();
    }
}
