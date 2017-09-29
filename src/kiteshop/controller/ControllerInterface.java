package kiteshop.controller;

import java.util.ArrayList;

import kiteshop.pojos.*;

public interface ControllerInterface {
	
	  boolean checkLogin(String gebruikersNaam, String wachtWoord);
	   void addKlant(Klant klant);
	   void removeKlant(Klant klant);
	   void addProduct(Product product);
	   void removeProduct(Product product);
	   void addBestelling(Bestelling bestelling);
	   void removeBestlling(Bestelling bestelling);
	   void addAccount(Account account);
	   void removeAccount(Account account);
	   
	   //Functies om hele tabbellen op te halen onder, je zult waarschijnlijk ook selecties willen kunnen maken
	   //maar welke dan precies is nog ter discussie, met sql kun je het zo gek maken als je wilt, dus je zult 
	   //een selectie moeten maken, weet niet hoeverre dit nu al relecvant is lala lala
	   ArrayList<Klant> showKlanten();
	   ArrayList<Klant> showKlantenAchternaam(String achterNaam);
	   
	   
	   
	   
	   
	   ArrayList<Product> showProducten();
	   ArrayList<Bestelling> showBestellingen();
	   
	   
	                   
	
	

}
