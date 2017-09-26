package kiteshop.controller;

import java.util.ArrayList;

import kiteshop.pojos.*;

public interface ControllerInterface {
	
	  boolean checkLogin(String gebruikersNaam, String wachtWoord);
	   void addKlant(Klant k);
	   void removeKlant(Klant k);
	   void addProduct(Product p);
	   void removeProduct(Product p);
	   void addBestelling(Bestelling b);
	   void removeBestlling(Bestelling b);
	   void addAccount(Account a);
	   void removeAccount(Account a);
	   
	   //Functies om hele tabbellen op te halen onder, je zult waarschijnlijk ook selecties willen kunnen maken
	   //maar welke dan precies is nog ter discussie, met sql kun je het zo gek maken als je wilt, dus je zult 
	   //een selectie moeten maken, weet niet hoeverre dit nu al relecvant is lala lala
	   ArrayList<Klant> showKlanten();
	   ArrayList<Klant> showKlantenAchternaam(String achterNaam);
	   
	   
	   
	   
	   
	   ArrayList<Product> showProducten();
	   ArrayList<Bestelling> showBestellingen();
	   
	   
	                   
	
	

}
